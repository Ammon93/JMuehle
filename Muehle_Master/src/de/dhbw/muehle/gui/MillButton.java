package de.dhbw.muehle.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import de.dhbw.muehle.model.theme.Theme;

public class MillButton extends JButton{
	
	private View view;
	private Theme theme;
	private String type;
	private boolean mouseOver;
	private boolean themeOverride;
	private Image background;
	
	
	public MillButton(View view, String type){
		this.view = view;
		this.type = type;
		
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addMouseListener(new MillButtonListener(this));
		
		setBackgroundImage(view.getTheme(), type);
	}
	
	
	private void setBackgroundImage(Theme theme, String type){
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
	
	
	/**
	 * Setzt den boolean mouseOver
	 * @param mouseOver the mouseOver to set
	 */
	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}
	
	
	/**
	 * Überschreibt das Default-Theme
	 * @param theme
	 */
	public void setTheme(Theme theme){
		this.theme = theme;
		setBackgroundImage(theme, type);
		
		themeOverride = true;
	}

	

	@Override
	public void paintComponent(Graphics g){
		if(themeOverride)
			setBackgroundImage(theme, type);
		else
			setBackgroundImage(view.getTheme(), type);
		
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		
		if(mouseOver){
			int brightness = (int) (256 - 256 * 0.5f);
	        g.setColor(new Color(0,0,0,brightness));
	        g.fillRect(0, 0, getWidth(), getHeight());
		}
	}
	
	
	
	
	private class MillButtonListener implements MouseListener{
		
		private MillButton mB;
		
		
		public MillButtonListener(MillButton mB) {
			this.mB = mB;
		}

		
		
		@Override
		public void mouseClicked(MouseEvent e) {	
		}

		@Override
		public void mousePressed(MouseEvent e) {
			mB.setMouseOver(false);
			mB.repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			mB.setMouseOver(true);
			mB.repaint();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			mB.setMouseOver(false);
			mB.repaint();
		}
	}
}