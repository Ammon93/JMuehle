package de.dhbw.muehle.core;

import de.dhbw.muehle.gui.View;
import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.menus.GamePanel.LblGameStone;


/**
 * Die Coreklasse dient als zentrale Fuktionseinheit des
 * Programmes. Hier werden alle GUI Elemente initalisiert und die
 * meisten Funktionen des Programmes bereitgestellt
 * @author Kreistschen
 */
public class Core {

	private ViewController vController;
	
	private CorePvE cPvE;
	private CorePvP cPvP;
	
	private String spielModus;
	
	private int spielPhase;
	
	private boolean weissDran,
					schwarzDran;
	
	
	public static final String PvE = "PvE",
						 	   PvP = "PvP";
	
	public static final int phase1 = 1,
							phase2 = 2,
							phase3 = 3;
	
	
	
	/**
	 * Konstruktor
	 */
	public Core(){
		// ViewController initialisieren
		vController = new ViewController(this);
		
		// einzelne Spilemodi initialisieren
		cPvE = new CorePvE();
		cPvP = new CorePvP(this);
	}
	
	

	// TODO Log + Datenbank
	// private void run() {
	// Log.log("run() ohne Fehler gestartet", getClass().getSimpleName());
	// }

	/**
	 * Zentrale Methode zur initalisierung der GUI und allen weiteren Fenstern.
	 */
	public void initGame(){
		vController.initGui();
	}
	
	
	/**
	 * Startet das Spiel im Einzelspielermodus.
	 */
	public void startPvE(){
		// Wenn bereits eine PvE-Sitzung läuft diese fortsetzen, andernfalls eine neue starten
		if(!isPvE())
			resetAll();
		
		// Weiss beginnt immer
		setWeissDran();
		// die Setzt-Phase beginnen
		spielPhase = phase1;
		
		vController.starteSpiel();
		
		spielModus = PvE;
	}
	
	/**
	 * Startet das Spiel im Mehrspielermodus.
	 */
	public void startPvP(){
		// Wenn bereits eine PvP-Sitzung läuft diese fortsetzen, andernfalls eine neue starten
		if(!isPvP())
			resetAll();
		
		// Weiss beginnt immer
		setWeissDran();
		// die Setzt-Phase beginnen
		spielPhase = phase1;
		
		vController.starteSpiel();
				
		spielModus = PvP;
	}
	
	
	/**
	 * Diese Methode leitet alle weiteren Schritte ein, wenn ein Label auf dem
	 * Spielbrett angeklickt wurde.
	 * 
	 * @param label
	 */
	public void labelClicked(LblGameStone label){
		if(isPvP())
			cPvP.labelClicked(label);
		
		// Anzeige des aktuellen Spielers aktualisieren
		getView().getGamePanel().updatePlayer();
	}
	
	
	
	/**
	 * Gibt zurück, ob es sich das Spiel aktuell im Einzelspielermodus befindet.
	 * @return {@link Boolean}
	 */
	public boolean isPvE(){
		if(spielModus == PvE)
			return true;
		else
			return false;
	}
	
	/**
	 * Gibt zurück, ob es sich das Spiel aktuell im Mehrspielermodus befindet.
	 * @return {@link Boolean}
	 */
	public boolean isPvP(){
		if(spielModus == PvP)
			return true;
		else
			return false;
	}
	
	/**
	 * Der Indikator, ob Weiss dran ist wird gesetzt.
	 * @param weiss
	 */
	public void setWeissDran(){
		weissDran = true;
		schwarzDran = false;
	}
	
	/**
	 * Gibt zurück, ob Weiß am Zug ist.
	 * @return {@link Boolean}
	 */
	public boolean isWeissDran(){
		return weissDran;
	}
	
	/**
	 * Der Indikator, ob Schwarz dran ist wird gesetzt.
	 * @param schwarz
	 */
	public void setSchwarzDran(){
		schwarzDran = true;
		weissDran = false;
	}
	
	/**
	 * Gibt zurück, ob Schwarz am Zug ist.
	 * @return {@link Boolean}
	 */
	public boolean isSchwarzDran(){
		return schwarzDran;
	}
	
	/**
	 * Setzt die Spielphase.
	 * @param phase
	 */
	public void setSpielPhase(int phase){
		spielPhase = phase;
	}
	
	/**
	 * Gibt die aktuelle Spielphase zurück.
	 * @return
	 */
	public int getSpielPhase(){
		return spielPhase;
	}
	
	/**
	 * Gibt den aktuellen Spielmodus zurück.
	 * @return PvE / PvP
	 */
	public String getSpielModus(){
		return spielModus;
	}
	
	/**
	 * Gibt das View-Objekt zurück.
	 * @return {@link View}
	 */
	public View getView(){
		return vController.getView();
	}
	
	
	
	/**
	 *  Setzt das Spiel auf Anfang zurück.
	 */
	public void resetAll() {
		// TODO Reset Game
		
	}
}