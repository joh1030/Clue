package clueTests;

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
		game.loadPlayers("players.txt");
	}
	
}
