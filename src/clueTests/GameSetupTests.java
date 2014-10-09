package clueTests;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;

import clueGame.BadConfigFormatException;
import clueGame.Board;
import clueGame.ClueGame;

public class GameSetupTests {
	
	private static Board board;
	
	@BeforeClass
	public static void setUp() throws FileNotFoundException, BadConfigFormatException {
		ClueGame game = new ClueGame("ClueLayout.csv","ClueLegend.csv");
		game.loadConfigFiles();
		board = game.getBoard();
	}
	
}
