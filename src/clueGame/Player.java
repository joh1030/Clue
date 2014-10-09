package clueGame;

import java.awt.Color;
import java.util.*;

public class Player {
	
	private String name;
	private Color color;
	private int row, col;
	
	
	
	public Player(String name, String color, int row, int col) {
		super();
		this.name = name;
		//int colorInt = Color.parseColor(color);
		//views.setTextColor(R.id.tvConfigInput, colorInt);
		this.row = row;
		this.col = col;
	}



	private ArrayList<Card> myCards;
	
	/*public Card disproveSuggestion(String person, String weapon, String room) {
		
	}*/
	
}
