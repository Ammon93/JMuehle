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

	public View frame;

	public View getFrame() {
		return frame;
	}

	public void setFrame(View frame) {
		this.frame = frame;
	}

	private Core core;
	private ThemeLoader thLoader;
	private Theme theme;

	public ViewController(Core _core) {
		thLoader = new ThemeLoader();
		theme = thLoader.getTheme("Wooden Mill");

		frame = new View(this, theme);
		core = _core;
	}

	public void initGui() {
		frame.setContentPane(frame.mainMenu); // Hauptmenü anzeigen
		frame.setVisible(true); // Frame anzeigen
	}

	public void displayMainMenu() {
		frame.setContentPane(frame.mainMenu);
	}

	public void startPvP() {
		frame.setContentPane(frame.gamePanel); // GamePanel (Spielbrett)
	}

	public void displaySettings() {
		frame.setContentPane(frame.settingsPanel);
	}

	public void changePlayer(int spielerNr, String type) {
		frame.gamePanel.setLblStatus(spielerNr, type);
	}



	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}


	public void angeklickter_Stein_speichern(LblGameStone stone) {

	}

	public Core getCore() {
		return core;
	}

	public void setCore(Core core) {
		this.core = core;
	}

	public Theme getTheme(String theme) {
		return thLoader.getTheme(theme);
	}

	public void setTheme(String theme) {
		this.theme = thLoader.getTheme(theme);
		frame.setTheme(this.theme);
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
