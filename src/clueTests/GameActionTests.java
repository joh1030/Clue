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
		board.calcAdjacencies();
	}

	// Random choice test (no room in targets)
	@Test
	public void testTargetRandomSelection() {
		ComputerPlayer player = new ComputerPlayer();
		// Pick a location with no rooms in target, just three targets
		board.calcTargets(9, 1, 2);
		int loc_8_0 = 0;
		int loc_8_2 = 0;
		int loc_9_3 = 0;
		// Run the test 100 times
		for (int i=0; i<100; i++) {
			BoardCell selected = player.pickLocation(board.getTargets());
			if (selected == board.getBoardCell(8, 0))
				loc_8_0++;
			else if (selected == board.getBoardCell(8, 2))
				loc_8_2++;
			else if (selected == board.getBoardCell(9, 3))
				loc_9_3++;
			else
				fail("Invalid target selected");
		}
		// Ensure we have 100 total selections (fail should also ensure)
		assertEquals(100, loc_8_0 + loc_8_2 + loc_9_3);
		// Ensure each target was selected more than once
		assertTrue(loc_8_0 > 1);
		assertTrue(loc_8_2 > 1);
		assertTrue(loc_9_3 > 1);				
	}
	// Target with room in selection
	@Test
	public void testTargetRoom() {
		ComputerPlayer player = new ComputerPlayer();
		board.calcTargets(4, 20, 2);
		assertEquals(board.getBoardCell(6,20), player.pickLocation(board.getTargets()));
		
		board.calcTargets(12, 7, 2);
		assertEquals(board.getBoardCell(12,6), player.pickLocation(board.getTargets()));
	}
	//Computer player makes a suggestion
	@Test
	public void testComputerSuggestion() {
		
	}
}
