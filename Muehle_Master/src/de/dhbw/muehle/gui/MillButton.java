package de.dhbw.muehle.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;

import de.dhbw.muehle.model.theme.Theme;

public class MillButton extends JButton{
	
	private Theme theme;
	private String type;
	private Image background;
	
	
	public MillButton(Theme theme, String type){
		this.theme = theme;
		this.type = type;
		
		setBackground();
	}
	
	
	public void setTheme(Theme theme){
		this.theme = theme;
		setBackground();
		repaint();
	}
	
	
	private void setBackground(){
		switch(type){
		case "Abbrechen":
			background = theme.getBtnAbbrechen();
			break;
		case "Beenden":
			background = theme.getBtnBeenden();
			break;
		case "Einstellungen":
			background = theme.getBtnEinstellungen();
			break;
		case "Einzelspieler":
			background = theme.getBtnPvE();
			break;
		case "Hilfe":
			background = theme.getBtnHilfe();
			break;
		case "Mehrspieler":
			background = theme.getBtnPvP();
			break;
		case "OK":
			background = theme.getBtnOK();
			break;
		case "Theme":
			background = theme.getBtnTheme();
			break;
		case "X":
			background = theme.getBtnX();
			break;
		case "ZumMenue":
			background = theme.getBtnZumMenue();
			break;
		case "Zurueck":
			background = theme.getBtnZurueck();
			break;
		case "Logo":
			background = theme.getLogo();
			break;
		}
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	}
}
