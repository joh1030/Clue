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
	private String layoutFile;
	private String legendFile;
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
		loadPlayers("players.txt");
		loadWeapons("weapons.txt");	
	}
	
	public void loadPlayers(String playerFile) throws FileNotFoundException {
		
		boolean isHuman=true;
		players = new ArrayList<Player>();
		FileReader reader = new FileReader(playerFile);
		Scanner scan = new Scanner(reader);
		String firstName, lastName, color;
		int row, col;
		while (scan.hasNext()) {
			firstName = scan.next();
			lastName = scan.next();
			color = scan.next();
			row = scan.nextInt();
			col = scan.nextInt();
			if(isHuman){
				players.add(new HumanPlayer(firstName +" " + lastName, color, row, col));
			}
			else{
				players.add(new ComputerPlayer(firstName  +" " + lastName, color, row, col));
			}
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
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public Board getBoard() {
		return board;
	}
}
