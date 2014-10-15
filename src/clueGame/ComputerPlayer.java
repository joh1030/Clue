package clueGame;

import java.util.*;

public class ComputerPlayer extends Player {
	private ArrayList<Card> seenCards;
	
	public ComputerPlayer(String name, String color, int row, int col) {
		super(name,color,row,col);
		seenCards= new ArrayList<Card>();
	}
	
	private char lastRoomVisited;
	
	public void pickLocation(Set<BoardCell> targets) {
		
	}
	
	public void createSuggestion(){
		
	}
	
	public void updateSeen(Card seen) {
		seenCards.add(seen);
	}
	
}
