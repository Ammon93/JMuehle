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

	public void clickedLabel(LblGameStone stone) {

	}

	public void weisseSteine_setzen(LblGameStone stone) {

		if (core.postitionFree(stone.getPosition())
				&& !frame.gamePanel.isStackEmpty(frame.gamePanel.weisseSteine)) {
			core.erzeugeSpielsteinweiss(stone.getPosition().getEbene(), stone
					.getPosition().getX(), stone.getPosition().getY(), stone
					.getPosition());
			stone.setImage(theme.getSpielSteinWeiss());
			frame.gamePanel.updateStack(frame.gamePanel.weisseSteine, -1);
			System.out.println(core.getStW().size());
			core.ueberpruefen_Muehele_weiss(stone.getPosition());
			if (core.isMuehle_weiss() == true) {
				core.setWeissDran(true);
				core.setSchwarzDran(false);
			} else {
				core.setSchwarzDran(true);
				core.setWeissDran(false);
			}

		}

	}

	public void schwarzeSteine_setzen(LblGameStone stone) {

		if (core.postitionFree(stone.getPosition())
				&& !frame.gamePanel
						.isStackEmpty(frame.gamePanel.schwarzeSteine)) {
			core.erzeugeSpielsteinschwarz(stone.getPosition().getEbene(), stone
					.getPosition().getX(), stone.getPosition().getY(), stone
					.getPosition());
			stone.setImage(theme.getSpielSteinSchwarz());
			frame.gamePanel.updateStack(frame.gamePanel.schwarzeSteine, -1);
			System.out.println(core.getStS().size());
			core.ueberpruefen_Muehele_schwarz(stone.getPosition());
			if (core.isMuehle_schwarz() == true) {
				core.setWeissDran(false);
				core.setSchwarzDran(true);
			} else {
				core.setSchwarzDran(false);
				core.setWeissDran(true);
			}

		}
	}

	public void entferneSteinWeiss(LblGameStone stone) {

		if (core.isMuehle_schwarz() == true) {
			if (!core.getHashliste_Schwarz().contains(
					stone.getPosition().hashCode())) {
				stone.removeImage();
				for (int j = 0; j < core.getHashliste_Weiss().size(); j++) {
					if (core.getHashliste_Weiss().get(j) == stone.getPosition()
							.hashCode()) {
						core.getHashliste_Weiss().remove(j);
					}
				}
				for (int i = 0; i < core.getStW().size(); i++) {
					if (core.getStW().get(i).getPosition().hashCode() == stone
							.getPosition().hashCode()) {
						core.getStW().remove(i);
					}
				}
			}

			else {

			}
		}
	}

	public void entferneSteinSchwarz(LblGameStone stone) {

		if (core.isMuehle_weiss() == true) {
			if (!core.getHashliste_Weiss().contains(
					stone.getPosition().hashCode())) {
				stone.removeImage();
				for (int j = 0; j < core.getHashliste_Schwarz().size(); j++) {
					if (core.getHashliste_Schwarz().get(j) == stone
							.getPosition().hashCode()) {
						core.getHashliste_Schwarz().remove(j);
					}
					for (int i = 0; i < core.getStS().size(); i++) {
						if (core.getStS().get(i).getPosition().hashCode() == stone
								.getPosition().hashCode()) {
							core.getStS().remove(i);
						}
					}
				}
			}

			else {

			}
		}

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
