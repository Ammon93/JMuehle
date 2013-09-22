package de.dhbw.muehle.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import de.dhbw.muehle.gui.menus.GamePanel;
import de.dhbw.muehle.gui.menus.MainMenu;
import de.dhbw.muehle.model.theme.Theme;



/**
 * Hier wird die View gebaut. Nur der Aufbau !!
 * sämtliche Funktionen werden im ViewController und den View Actions implementiert.
 * @author Kreistschen
 *
 */

public class View extends JFrame{
	
	private Theme theme;

	protected MainMenu mainMenu;
	protected GamePanel gamePanel;
	private ViewController vController;
	
	
	public View(ViewController vController, Theme theme){
		this.vController = vController;
		this.theme = theme;
		
		setTitle("JMuehle");		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setBounds(100,100,500,500);
		
		
		// mainMenu initialisieren
		mainMenu = new MainMenu(vController, theme);
		
		// gamePanel initialisieren
		gamePanel = new GamePanel(vController, theme);
	}
	
	
	
	/**
	 * Setzt eine Theme
	 * @param theme Theme
	 */
	public void setTheme(Theme theme){
		this.theme = theme;
		repaint();
	}
	
	
	/**
	 * Setzt das Hauptpanel des Frames
	 * @param container Container (In diesem Fall das JPanel)
	 */
	@Override
	public void setContentPane(Container container){
		
		// aktuelles Panel entfernen, sofern vorhanden
		if(getContentPane() != null)
			remove(getContentPane());
		
		// neues Panel setzen
		super.setContentPane(container);
		
		// Framegröße auf Panelgröße anpassen
		getContentPane().setPreferredSize(container.getSize());
		
		pack();
		repaint();
	}
}