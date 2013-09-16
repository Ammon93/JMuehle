package de.dhbw.muehle.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private Image background;
	
	
	public GamePanel(ViewController vController) {
		// Panelgröße festlegen
		setSize(600, 600);
		
		// Hintergrundbild laden
		background = new ImageIcon("res/SPIELBRETT.png").getImage();
	}
	
	
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

}
