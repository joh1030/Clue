package clueGame;

import java.awt.GridLayout;

import javax.swing.*;

public class DetectiveNotes extends JFrame {
	
	public DetectiveNotes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 500);
		setTitle("Detective Notes");
		createLayout();
	}
	
	public void createLayout(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,2));
	}
	
	public void peoplePanel() {
		
	}
	
	public static void main(String[] args) {
		DetectiveNotes gui = new DetectiveNotes();
		gui.setVisible(true);
	}
}

