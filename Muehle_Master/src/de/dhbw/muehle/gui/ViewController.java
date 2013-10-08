package de.dhbw.muehle.gui;

/**
 * Diese Klasse dient als Schnittstelle zwischen dem Core und der View
 */

import java.util.List;

import javax.swing.JLabel;

import de.dhbw.muehle.core.Core;
import de.dhbw.muehle.gui.menus.GamePanel.LblGameStone;
import de.dhbw.muehle.gui.viewactions.GamePanelVA.lblGameStoneMouse;
import de.dhbw.muehle.model.Log;
import de.dhbw.muehle.model.spielstein.ESpielsteinFarbe;
import de.dhbw.muehle.model.spielstein.ISpielstein;
import de.dhbw.muehle.model.spielstein.Position;
import de.dhbw.muehle.model.spielstein.Spielstein;
import de.dhbw.muehle.model.theme.Theme;
import de.dhbw.muehle.model.theme.ThemeLoader;

public class ViewController implements IViewController {

	private View frame;
	private Core core;
	private ThemeLoader thLoader;
	private Theme theme;
	
	
	public ViewController(Core _core){
		thLoader = new ThemeLoader();
		theme = thLoader.getTheme("Wooden Mill");
		
		frame = new View(this, theme);
		core = _core;
	}
		
	public void initGui(){
		frame.setContentPane(frame.mainMenu); // Hauptmenü anzeigen
		frame.setVisible(true); // Frame anzeigen
	}
	
	public void startPvE() {
		frame.setContentPane(frame.gamePanel); // GamePanel (Spielbrett) anzeigen
	}
	
	public void displaySettings() {
		//hier der Code um das Einstellungspanel anzuzeigen
	}
	
	public void weisseSteine_setzen(LblGameStone stone) {
		// Core fragen, ob Stein gesetzt werden darf
		if(core.postitionFree(stone.getPosition()) && !frame.gamePanel.isStackEmpty(frame.gamePanel.lblStonesMe)){
			stone.setImage(theme.getSpielSteinSchwarz());
			frame.gamePanel.updateStack(frame.gamePanel.lblStonesMe, -1);
			System.out.println(stone.getPosition());
			core.getStW()[9-frame.gamePanel.lblStonesMe.getCountStones()].setPosition(stone.getPosition().getEbene(), stone.getPosition().getX(), stone.getPosition().getY());
			System.out.println(core.getStW()[1].getPosition());
			System.out.println(core.getStW()[9-frame.gamePanel.lblStonesMe.getCountStones()].getPosition());
		}
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