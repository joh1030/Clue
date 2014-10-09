package clueTests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.BadConfigFormatException;
import clueGame.Board;
import clueGame.ClueGame;

public class GameActionTests {
	
	private static Board board;
	
	@BeforeClass
	public static void setUp() throws FileNotFoundException, BadConfigFormatException {
		ClueGame game = new ClueGame("ClueLayout.csv","ClueLegend.csv");
		game.loadConfigFiles();
		board = game.getBoard();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
