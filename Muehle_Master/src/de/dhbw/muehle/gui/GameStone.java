package de.dhbw.muehle.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;

public class GameStone extends JLabel {
	
	Image image;
	
	
	/**
	 * Weist dem Stein ein bestimmtes Bild zu
	 * Dadurch wird der Stein sichtbar
	 * @param image Bild
	 */
	public void setImage(Image image){
		this.image = image;
		repaint();
	}
	
	
	/**
	 * Entfernt das aktuelle Bild vom Label
	 * Dadurch wird es unsichtbar
	 */
	public void removeImage(){
		this.image = null;
		repaint();
	}
	
	
	// Bild dynamisch auf den Stein zeichnen
	@Override
	public void paintComponent(Graphics g) {
		// Bild dynamisch zeichnen
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
