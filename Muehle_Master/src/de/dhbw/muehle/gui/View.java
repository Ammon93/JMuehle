package de.dhbw.muehle.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class View {
	
	private JFrame frame;
	private JLabel label;
	
	public void init(){
		//System.out.println("Passt");
		frame = new JFrame("Fenster");
		frame.setVisible(true);
		frame.setBounds(100, 100, 500, 500);
	}
}


