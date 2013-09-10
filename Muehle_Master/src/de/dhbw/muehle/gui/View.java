package de.dhbw.muehle.gui;

import javax.swing.JFrame;


public class View {
	
	private JFrame frame;
	
	public void init(){
		//System.out.println("Passt");
		frame = new JFrame("Fenster");
		frame.setVisible(true);
		frame.setBounds(100, 100, 500, 500);
	}
}


