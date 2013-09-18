package de.dhbw.muehle.core;

import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.model.Log;
import de.dhbw.muehle.model.Model;
import de.dhbw.muehle.model.spielstein.EPositionIndex;
import de.dhbw.muehle.model.spielstein.ESpielsteinFarbe;
import de.dhbw.muehle.model.spielstein.Spielstein;

public class Core {
	
	
	ViewController vController;
	Model model;
	Log log;
	
	public Core(){
		vController = new ViewController(this);
		model = new Model();
	}

	public void initGame(){
		vController.initGui();
		erzeugeSpielsteine();
		
	}
	
	private void run(){
		Log.log("run() ohne Fehler gestartet",getClass().getSimpleName());
	}
	
	private void erzeugeSpielsteine(){
		
		Spielstein [] StW = new Spielstein [9];
		Spielstein [] StS = new Spielstein [9];
		
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				StW[j]= new Spielstein(EPositionIndex.Drei,EPositionIndex.Drei,EPositionIndex.Drei,ESpielsteinFarbe.WEISS);
			}
		StS[i]= new Spielstein(EPositionIndex.Drei,EPositionIndex.Drei,EPositionIndex.Drei,ESpielsteinFarbe.WEISS);
		
		}
	
		Log.log("Alle Spielsteine wurden erstellt",getClass().getSimpleName());
		
	}
}


