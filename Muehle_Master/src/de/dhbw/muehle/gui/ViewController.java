package de.dhbw.muehle.gui;

/**
 * Diese Klasse dient als Schnittstelle zwischen dem Core und der View
 */

import java.util.List;

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
		frame.setVisible(true); // Frame anzeigen
		frame.showComponet("mainMenu", true); // Hauptmenü anzeigen
	}
	
	public void displaySettings() {
		frame.showComponet("mainMenu", false); // Hauptmenü ausblenden
		
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