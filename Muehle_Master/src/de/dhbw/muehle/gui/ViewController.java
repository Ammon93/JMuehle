package de.dhbw.muehle.gui;

/**
 * Diese Klasse dient als Schnittstelle zwischen dem Core und der View
 */

import java.awt.Dimension;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import de.dhbw.muehle.core.Core;
import de.dhbw.muehle.model.spielstein.ISpielstein;
import de.dhbw.muehle.model.spielstein.Position;

public class ViewController implements IViewController {

	private View frame;
	private Core core;
	
	public ViewController(Core _core){
		frame = new View(this);
		core = _core;
	}
		
	public void initGui(){
		frame.setContentPane(frame.mainMenu); // Hauptmenü anzeigen
		frame.setVisible(true); // Frame anzeigen
	}
	
	public void startPvE() {
		frame.setContentPane(frame.gamePanel); // GamePanel anzeigen
//		Image bg = new ImageIcon("/Volumes/Benutzer/Ammon/Dropbox/Fallstudie/Design/Steine/SchwarzerStein.png").getImage();
//		frame.gamePanel.gameStone[0][0].setText("");
	}
	
	public void displaySettings() {
		//hier der Code um das Einstellungspanel anzuzeigen
	}
	
	

	@Override
	public Position getPosition(ISpielstein spielStein) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ISpielstein> setPosition(ISpielstein spielStein,
			Position position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ISpielstein> getSpielSteine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ISpielstein> removeSpielStein(ISpielstein spielStein) {
		// TODO Auto-generated method stub
		return null;
	}
}