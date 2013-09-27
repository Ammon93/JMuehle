package de.dhbw.muehle.core;

import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.model.Log;
import de.dhbw.muehle.model.Model;
import de.dhbw.muehle.model.spielstein.EPositionIndex;
import de.dhbw.muehle.model.spielstein.ESpielsteinFarbe;
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
	
	private void run(){
		Log.log("run() ohne Fehler gestartet",getClass().getSimpleName());
	}
	
	private void erzeugeSpielsteine(){
		
		StW = new Spielstein [9];
		StS = new Spielstein [9];
		
		for(int i=0;i<9;i++){
			StW[i]= new Spielstein(EPositionIndex.Drei,EPositionIndex.Drei,EPositionIndex.Drei,ESpielsteinFarbe.WEISS);
			StS[i]= new Spielstein(EPositionIndex.Drei,EPositionIndex.Drei,EPositionIndex.Drei,ESpielsteinFarbe.SCHWARZ);
		}
	
		Log.log("Alle Spielsteine wurden erstellt",getClass().getSimpleName());
		
	}
}


