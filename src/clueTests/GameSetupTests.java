package clueTests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.BadConfigFormatException;
import clueGame.Board;
import clueGame.Card;
import clueGame.ClueGame;

public class GameSetupTests {
	
	private static Board board;
	private static ClueGame game;
	
	@BeforeClass
	public static void setUp() throws FileNotFoundException, BadConfigFormatException {
		game = new ClueGame("ClueLayout.csv","ClueLegend.csv","players.txt","weapons.txt");
		game.loadConfigFiles();
		board = game.getBoard();
	}
	
	@Test
	public void testLoadingPlayers() throws FileNotFoundException {
		
		// test first line human player
		assertEquals("Miss Scarlett", game.getPlayers().get(0).getName());
		assertEquals(Color.black, game.getPlayers().get(0).getColor());
		assertEquals(0, game.getPlayers().get(0).getRow());
		assertEquals(4, game.getPlayers().get(0).getCol());
		
		//test second line computer player
		assertEquals("Colonel Mustard", game.getPlayers().get(1).getName());
		assertEquals(Color.blue, game.getPlayers().get(1).getColor());
		assertEquals(21, game.getPlayers().get(1).getRow());
		assertEquals(6, game.getPlayers().get(1).getCol());
		//test third line computer player
		assertEquals("Mrs. White", game.getPlayers().get(2).getName());
		assertEquals(Color.cyan, game.getPlayers().get(2).getColor());
		assertEquals(14, game.getPlayers().get(2).getRow());
		assertEquals(20, game.getPlayers().get(2).getCol());

	}
	
	@Test
	public void testLoadingCards(){
		int people = 0,weapons =0,rooms=0;
		boolean containsPerson=false,containsWeapon=false,containsRoom=false;
		assertEquals(21,game.getCards().size());
		//get number of cards of each type
		for(Card c: game.getCards()){
			if(c.getCardType() == Card.CardType.PERSON){
				if(c.getName().contentEquals("Miss Scarlett")){
					containsPerson=true;
				}
				people++;
			}
			if(c.getCardType() == Card.CardType.WEAPON){
				if(c.getName().contentEquals("wrench")){
					containsWeapon=true;
				}
				weapons++;
			}
			if(c.getCardType() == Card.CardType.ROOM){
				if(c.getName().contentEquals("Bedroom")){
					containsRoom=true;
				}
				rooms++;
			}
			
			
		}
		assertEquals(6,people);
		assertEquals(9,rooms);
		assertEquals(6, weapons);
		
		assertEquals(true,containsRoom && containsWeapon && containsPerson);
		
		
	}
	
	@Test
	public void testDealingCards(){
		game.deal();
		assertEquals(0,game.getCards().size());
	}
}
