package de.dhbw.muehle.core;

import de.dhbw.muehle.gui.menus.GamePanel;
import de.dhbw.muehle.gui.menus.GamePanel.LblGameStone;
import de.dhbw.muehle.model.theme.Sound.Sounds;

/**
 * Diese Klasse ist für das Multiplayergameplay verantwortlich.
 * @author Ammon
 */
public class CorePvP{

	private Core core;
	private GamePanel spielFeld;
	
	
	/**
	 * Konstruktor
	 * @param core
	 */
	public CorePvP(Core core){
		this.core = core;
		spielFeld = core.getView().getGamePanel();
	}
	
	
	
	/**
	 * Zeigt den durch type und color definierten Spielstein auf dem Spielbrett an.
	 * @param label
	 * @param color
	 * @param type
	 */
	private void displayLabel(LblGameStone label, String color){
		displayLabel(label, color, "");
	}
	
	private void displayLabel(LblGameStone label, String color, String type){
		core.getView().getTheme().playSound(Sounds.steinSetzen);
		label.setImage(color, type);
	}
	
	
	/**
	 * Entfernt den Spielstein vom Spielbrett.
	 * @param label
	 */
	private void removeLabel(LblGameStone label){
		label.removeImage();
	}
	
	
	
	/**
	 * Diese Methode nimmt das Label entgegen, auf das geklickt wurde
	 * und verarbeitet die Eingabe.
	 * @param label
	 */
	public void labelClicked(LblGameStone label){
		displayLabel(label, LblGameStone.schwarz);
	}
}
