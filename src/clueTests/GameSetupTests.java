package clueTests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.BadConfigFormatException;
import clueGame.Board;
import clueGame.ClueGame;

public class GameSetupTests {
	
	private static Board board;
	private static ClueGame game;
	
	@BeforeClass
	public static void setUp() throws FileNotFoundException, BadConfigFormatException {
		game = new ClueGame("ClueLayout.csv","ClueLegend.csv");
		game.loadConfigFiles();
		board = game.getBoard();
	}
	
	@Test
	public void testLoadingPlayers() throws FileNotFoundException {
		// test first line
		assertEquals("Miss"+"Scarlett", game.getPlayers().get(0).getName());
		assertEquals(Color.black, game.getPlayers().get(0).getColor());
		assertEquals(0, game.getPlayers().get(0).getRow());
		assertEquals(4, game.getPlayers().get(0).getCol());
	}
}
