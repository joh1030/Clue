package clueGame;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClueGame {
	private ArrayList<Card> cards;
	private ArrayList<Player> players;
	private Solution solution;
	private Board board;
	private int boardRows;
	private int boardCols;
	private String layoutFile = "ClueLayout.csv";
	private String legendFile = "ClueLegend.csv";
	private String playerFile = "player.txt";
	private Map<Character,String> rooms = new HashMap<Character,String>();
	public ClueGame(String layout, String legend) {
		layoutFile = layout;
		legendFile = legend;
		try {
			board = new Board(layoutFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadConfigFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void loadConfigFiles() throws FileNotFoundException, BadConfigFormatException {
		board.loadLegend(legendFile);
		//then load board layout
		board.loadBoardDimensions(layoutFile);
		board.loadBoardConfig(layoutFile);
		loadPlayers(playerFile);
		
	}
	
	public void loadPlayers(String playerFile) throws FileNotFoundException {
		FileReader reader = new FileReader(playerFile);
		Scanner scan = new Scanner(reader);
		String firstName, lastName;
		String color;
		int row, col;
		while (scan.hasNext()) {
			firstName = scan.next();
			lastName = scan.next();
			color = scan.next();
			row = scan.nextInt();
			col = scan.nextInt();
			players.add(new Player(firstName + lastName, color, row, col));
		}
	}
	
	public void loadWeapons(String weaponFile) throws FileNotFoundException {
		FileReader reader = new FileReader(weaponFile);
		Scanner scan = new Scanner(reader);
		String weaponName;
		while (scan.hasNext()) {
			weaponName = scan.next();
		}
	}
	
	public Board getBoard() {
		return board;
	}
}
