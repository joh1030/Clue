package clueTests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.BadConfigFormatException;
import clueGame.Board;
import clueGame.BoardCell;
import clueGame.ClueGame;
import clueGame.ComputerPlayer;

public class GameActionTests {

	private static Board board;
	private static ClueGame game;
	
	@BeforeClass
	public static void setUp() throws FileNotFoundException, BadConfigFormatException {
		game = new ClueGame("ClueLayout.csv","ClueLegend.csv","players.txt","weapons.txt");
		game.loadConfigFiles();
		board = game.getBoard();
	}

	// Random choice tests (no room in targets)
	@Test
	public void testTargetRandomSelection() {
		ComputerPlayer player = new ComputerPlayer("John", "black", 16, 15);
		// Pick a location with no rooms in target, just three targets
		board.calcTargets(16, 15, 2);
		int loc_16_13 = 0;
		int loc_16_17 = 0;
		int loc_14_15 = 0;
		// Run the test 100 times
		for (int i=0; i<100; i++) {
			BoardCell selected = null;
			if (!board.getTargets().isEmpty()) {
				selected = player.pickLocation(board.getTargets());
			}
			if (selected == board.getBoardCell(16, 13))
				loc_16_13++;
			else if (selected == board.getBoardCell(16, 17))
				loc_16_17++;
			else if (selected == board.getBoardCell(14, 15))
				loc_14_15++;
			else
				fail("Invalid target selected");
		}
		// Ensure we have 100 total selections (fail should also ensure)
		assertEquals(100, loc_16_13 + loc_16_17 + loc_14_15);
		// Ensure each target was selected more than once
		assertTrue(loc_16_13 > 1);
		assertTrue(loc_16_17 > 1);
		assertTrue(loc_14_15 > 1);				
	}
}
