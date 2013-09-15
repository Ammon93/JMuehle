package de.dhbw.muehle.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;



/**
 * Hier wird die View gebaut. Nur der Aufbau !!
 * s�mtliche Funktionen werden im ViewController und den View Actions implementiert.
 * @author Kreistschen
 *
 */

public class View extends JFrame{

	private MainMenu mainMenu;
	
	
	public View(ViewController vController){
		setTitle("JMuehle");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setBounds(100,100,500,500);
		
		
		// mainMenu hinzufügen
		mainMenu = new MainMenu(vController);
		mainMenu.setVisible(false);
		add(mainMenu);
	}



	/**
	 * @return mainMenu
	 */
	protected void showComponet(String component, boolean visibility) {
		switch (component) {
		case "mainMenu":
			mainMenu.setVisible(visibility);
			break;
		}
		repaint();
	}
	
	
// muss noch in eigene Klasse ausgelagert werden
//	class BgPanel extends JPanel {
//	    Image bg = new ImageIcon("res/SPIELBRETT.png").getImage();
//	    @Override
//	    public void paintComponent(Graphics g) {
//	        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
//	    }
//	}
}