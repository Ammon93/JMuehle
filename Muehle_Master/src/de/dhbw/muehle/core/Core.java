package de.dhbw.muehle.core;


import java.util.ArrayList;
import java.util.List;

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
	private List<Integer> Hashliste;
	private List<Spielstein> StW,StS;
	
	
	public Core(){
		vController = new ViewController(this);
		model = new Model();
		StW = new ArrayList<Spielstein>();
		StS = new ArrayList<Spielstein>();
		Hashliste = new ArrayList<Integer>();
	
	}

	public void initGame(){
		vController.initGui();
	}
	

	public List<Spielstein> getStW() {
		return StW;
	}

	public void setStW(List<Spielstein> stW) {
		StW = stW;
	}

	public List<Spielstein> getStS() {
		return StS;
	}

	public void setStS(List<Spielstein> stS) {
		StS = stS;
	}

	private void run(){
	
		Log.log("run() ohne Fehler gestartet",getClass().getSimpleName());
	}
	
	public void erzeugeSpielsteinweiss(EPositionIndex ebene,EPositionIndex x,EPositionIndex y, Position pos){
		
		
			StW.add( new Spielstein(ebene,x,y,ESpielsteinFarbe.WEISS));
			Hashliste.add(pos.hashCode());
		
	}
	
	public void erzeugeSpielsteinschwarz(EPositionIndex ebene,EPositionIndex x,EPositionIndex y, Position pos){
		
		
		StW.add( new Spielstein(ebene,x,y,ESpielsteinFarbe.SCHWARZ));
		Hashliste.add(pos.hashCode());
	
}
	
	public boolean postitionFree(Position pos){
		boolean posfree = true;
		if(Hashliste.contains(pos.hashCode())){
			posfree = false;
		}
		return posfree;
		
		
	}
}



	