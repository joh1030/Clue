package clueGame;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

public class DetectiveNotes extends JDialog {
	public ArrayList<Card> peopleCards = new ArrayList<Card>();
	public ArrayList<Card> roomsCards = new ArrayList<Card>();
	public ArrayList<Card> weaponsCards = new ArrayList<Card>();
	
	public DetectiveNotes(ArrayList<Card> people,ArrayList<Card> rooms,ArrayList<Card> weapons) {
		setSize(400, 500);
		setTitle("Detective Notes");
		peopleCards=people;
		roomsCards=rooms;
		weaponsCards=weapons;
		createLayout();
	}
	
	public void createLayout(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		peoplePanel(panel);
		roomPanel(panel);
		weaponsPanel(panel);
		this.add(panel);
	}
	
	public void peoplePanel(JPanel dialog) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		panel.setBorder(BorderFactory.createTitledBorder("People"));
		for(Card c: peopleCards){
			panel.add(new JCheckBox(c.getName()));
		}
		dialog.add(panel);
	}
	
	public void roomPanel(JPanel dialog) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		panel.setBorder(BorderFactory.createTitledBorder("Rooms"));
		for(Card c: roomsCards){
			panel.add(new JCheckBox(c.getName()));
		}
		dialog.add(panel);
	}
	
	public void weaponsPanel(JPanel dialog) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		panel.setBorder(BorderFactory.createTitledBorder("Weapons"));
		for(Card c: weaponsCards){
			panel.add(new JCheckBox(c.getName()));
		}
		dialog.add(panel);
	}
	
}

