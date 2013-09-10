package de.dhbw.muehle.gui;

import java.awt.*;
import javax.swing.*;



/**
 * Hier wird die View gebaut. Nur der Aufbau !!
 * sämtliche Funktionen werden im ViewController und den View Actions implementiert.
 * @author Kreistschen
 *
 */

public class View {


	private JFrame mainFrame;
	private JPanel mainPanel;
	private JLabel label;
	

 class BgPanel extends JPanel {
	    Image bg = new ImageIcon("res/SPIELBRETT.png").getImage();
	    @Override
	    public void paintComponent(Graphics g) {
	        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	    }
	}
	
	
	public void init(){
		
		//ImageIcon bGround = new ImageIcon("res/SPIELBRETT_Angepasst.png");
		
		mainFrame = new JFrame("Fenster");
		mainFrame.setLayout(new FlowLayout());
		mainPanel = new BgPanel();
		mainFrame.setBounds(100,100,500,500);
		mainFrame.setContentPane(mainPanel);
		mainFrame.setVisible(true);
	}
}


