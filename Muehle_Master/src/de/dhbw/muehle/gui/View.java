package de.dhbw.muehle.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import de.dhbw.muehle.gui.menus.GamePanel;
import de.dhbw.muehle.gui.menus.MainMenu;



/**
 * Hier wird die View gebaut. Nur der Aufbau !!
 * s�mtliche Funktionen werden im ViewController und den View Actions implementiert.
 * @author Kreistschen
 *
 */

public class View extends JFrame{

	protected MainMenu mainMenu;
	protected GamePanel gamePanel;
	private ViewController vController;
	
	
	public View(ViewController vController){
		this.vController = vController;
		
		setTitle("JMuehle");		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setBounds(100,100,500,500);
		
		
		// mainMenu initialisieren
		mainMenu = new MainMenu(vController);
		
		// gamePanel initialisieren
		gamePanel = new GamePanel(vController);
	}
	
	
	@Override
	public void setContentPane(Container container){
		
		// aktuelles Panel entfernen
		remove(getContentPane());
		
		// neues Panel setzen
		super.setContentPane(container);
		
		// Framegröße auf Panelgröße anpassen
		getContentPane().setPreferredSize(container.getSize());
		
		pack();
		repaint();
	}
}