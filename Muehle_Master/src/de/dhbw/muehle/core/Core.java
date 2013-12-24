package de.dhbw.muehle.core;

import de.dhbw.muehle.gui.ViewController;

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
	
	
	public static String PvE="PvE",
						 PvP="PvP";

	/**
	 * Konstruktor
	 */
	public Core() {
		// ViewController initialisieren
		vController = new ViewController(this);
		
		// einzelne Spilemodi initialisieren
		cPvE = new CorePvE();
		cPvP = new CorePvP();
	}

	// TODO Log + Datenbank
	// private void run() {
	// Log.log("run() ohne Fehler gestartet", getClass().getSimpleName());
	// }

	// Zentrale Methode zur initalisierung der GUI und allen weiteren Fenstern
	public void initGame() {
		vController.initGui();
	}
	
	
	public void startPvE(){
		// Wenn bereits eine PvE-Sitzung läuft diese fortsetzen, andernfalls eine neue starten
		if(!isPvE())
			resetAll();
		
		vController.starteSpiel();
		
		spielModus = PvE;
	}
	
	public void startPvP(){
		// Wenn bereits eine PvP-Sitzung läuft diese fortsetzen, andernfalls eine neue starten
		if(!isPvP())
			resetAll();
		
		vController.starteSpiel();
				
		spielModus = PvP;
	}
	
	public boolean isPvE(){
		if(spielModus == null)
			return true;
		if(spielModus.equals(PvE))
			return true;
		else
			return false;
	}
	
	public boolean isPvP(){
		if(spielModus == null)
			return true;
		if(spielModus.equals(PvP))
			return true;
		else
			return false;
	}
	
	public String getSpielModus(){
		return spielModus;
	}
	
	
	// Reset Game
	public void resetAll() {
		// TODO Auto-generated method stub
		
	}
}