package clueGame;

import java.util.*;

public class ComputerPlayer extends Player {
	private ArrayList<Card> seenCards;
	
	public ComputerPlayer() {
		super();
	}
	
	public ComputerPlayer(String name, String color, int row, int col) {
		super(name,color,row,col);
		seenCards= new ArrayList<Card>();
	}
	
	private char lastRoomVisited;
	
	public BoardCell pickLocation(Set<BoardCell> targets) {
		int loc = new Random().nextInt(targets.size()); 
		int i = 0;
		for(BoardCell cell : targets) {
			if(cell.isDoorway()){
				return cell;
			}
		}
		for(BoardCell cell : targets) {
		    if (i == loc)
		        return cell;
		    i++;
		}
		return null;
	}
	
	public void createSuggestion(){
		
	}
	
	public void updateSeen(Card seen) {
		seenCards.add(seen);
	}
	
}
