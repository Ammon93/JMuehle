package de.dhbw.muehle.core;

import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.model.Log;
import de.dhbw.muehle.model.Model;
import de.dhbw.muehle.model.spielstein.EPositionIndex;
import de.dhbw.muehle.model.spielstein.ESpielsteinFarbe;
import de.dhbw.muehle.model.spielstein.Position;
import de.dhbw.muehle.model.spielstein.Spielstein;

public class Core {
	
	
	private ViewController vController;
	private Model model;
	
	private Spielstein[] StW, StS;
	
	
	public Core(){
		vController = new ViewController(this);
		model = new Model();
		
		erzeugeSpielsteine();
	}

	public void initGame(){
		vController.initGui();
	}
	
	public Spielstein[] getStW() {
		return StW;
	}

	public void setStW(Spielstein[] stW) {
		StW = stW;
	}

	public Spielstein[] getStS() {
		return StS;
	}

	public void setStS(Spielstein[] stS) {
		StS = stS;
	}

	private void run(){
		Log.log("run() ohne Fehler gestartet",getClass().getSimpleName());
	}
	
	public void erzeugeSpielsteine(){
		
		StW = new Spielstein [9];
		StS = new Spielstein [9];
		
		for(int i=0;i<9;i++){
			StW[i]= new Spielstein(null,null,null,ESpielsteinFarbe.WEISS);
			StS[i]= new Spielstein(null,null,null,ESpielsteinFarbe.SCHWARZ);
		}
	
		Log.log("Alle Spielsteine wurden erstellt",getClass().getSimpleName());
		
	}
	
	public boolean postitionFree(Position pos){
		
		return true;
	}
}


