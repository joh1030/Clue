package clueGame;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.*;

public class Player {
	
	private ArrayList<Card> myCards;
	
	private String name;
	private Color color;
	private int row, col;
	
	public Player() {
		name = "";
		color = Color.black;
		row = 0;
		col = 0;
	}
	
	public Player(String name, String color, int row, int col) {
		this.name = name;
		// convert String color to Color color
		try {     
			// We can use reflection to convert the string to a color
			Field field = Class.forName("java.awt.Color").getField(color.trim());     
			this.color = (Color)field.get(null); } 
		catch (Exception e) {  
			color = null; // Not defined } 
		}
		this.row = row;
		this.col = col;
	}

	public ArrayList<Card> getMyCards() {
		return myCards;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	/*public Card disproveSuggestion(String person, String weapon, String room) {
		
	}*/
	
}
