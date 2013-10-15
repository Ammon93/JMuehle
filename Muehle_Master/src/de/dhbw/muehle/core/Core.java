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
	private List<Integer> Hashliste_Weiss;
	private List<Integer> Hashliste_Schwarz;
	private List<Spielstein> StW, StS;
	private boolean schwarzDran;
	private boolean weissDran;
	private boolean Muehle_weiss;
	private boolean Muehle_schwarz;
	List<Spielstein> index1s;
	List<Spielstein> index2s; 
	List<Spielstein> index3s; 
	List<Spielstein> index1w;
	List<Spielstein> index2w; 
	List<Spielstein> index3w; 


	public boolean isMuehle_weiss() {
		return Muehle_weiss;
	}

	public void setMuehle_weiss(boolean muehle_weiss) {
		Muehle_weiss = muehle_weiss;
	}

	public boolean isMuehle_schwarz() {
		return Muehle_schwarz;
	}

	public void setMuehle_schwarz(boolean muehle_schwarz) {
		Muehle_schwarz = muehle_schwarz;
	}

	public boolean isSchwarzDran() {
		return schwarzDran;
	}

	public void setSchwarzDran(boolean schwarzDran) {
		this.schwarzDran = schwarzDran;
	}

	public boolean isWeissDran() {
		return weissDran;
	}

	public void setWeissDran(boolean weissDran) {
		this.weissDran = weissDran;
	}

	public Core() {
		vController = new ViewController(this);
		model = new Model();
		StW = new ArrayList<Spielstein>();
		StS = new ArrayList<Spielstein>();
		Hashliste_Weiss = new ArrayList<Integer>();
		Hashliste_Schwarz = new ArrayList<Integer>();
		weissDran = true;
		index1w=new ArrayList<Spielstein>();
		index2w=new ArrayList<Spielstein>();
		index3w=new ArrayList<Spielstein>();
		index1s=new ArrayList<Spielstein>();
		index2s=new ArrayList<Spielstein>();
		index3s=new ArrayList<Spielstein>();

	}

	public List<Integer> getHashliste_Weiss() {
		return Hashliste_Weiss;
	}

	public void setHashliste_Weiss(List<Integer> hashliste_Weiss) {
		Hashliste_Weiss = hashliste_Weiss;
	}

	public List<Integer> getHashliste_Schwarz() {
		return Hashliste_Schwarz;
	}

	public void setHashliste_Schwarz(List<Integer> hashliste_Schwarz) {
		Hashliste_Schwarz = hashliste_Schwarz;
	}

	public void initGame() {
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

	private void run() {
		Log.log("run() ohne Fehler gestartet", getClass().getSimpleName());
	}

	public void erzeugeSpielsteinweiss(EPositionIndex ebene, EPositionIndex x,
			EPositionIndex y, Position pos) {

		StW.add(new Spielstein(ebene, x, y, ESpielsteinFarbe.WEISS));
		Hashliste_Weiss.add(pos.hashCode());

	}

	public void erzeugeSpielsteinschwarz(EPositionIndex ebene,
			EPositionIndex x, EPositionIndex y, Position pos) {

		StS.add(new Spielstein(ebene, x, y, ESpielsteinFarbe.SCHWARZ));
		Hashliste_Schwarz.add(pos.hashCode());

	}

	public boolean postitionFree(Position pos) {
		boolean posfree = true;
		if (Hashliste_Weiss.contains(pos.hashCode())) {
			posfree = false;
		}
		
		else if (Hashliste_Schwarz.contains(pos.hashCode())){
			posfree=false;
		}
		
		return posfree;

	}

	public void start_Spielphase1() {

	}

	public void ueberpruefen_Muehele_weiss(Position pos) {
		Muehle_weiss=false;
		int zaehler1 = 0;
		int zaehler2 = 0;
		int zaehler3 = 0;
		
		index1w.clear();
		index2w.clear();
		index3w.clear();


		int posEbene = pos.getEbene().getValue();
		int posX = pos.getX().getValue();
		int posY = pos.getY().getValue();

		for (int i = 0; i < StW.size(); i++) {
			if (posEbene == StW.get(i).getPosition().getEbene().getValue()
					&& posX == StW.get(i).getPosition().getX().getValue()) {
				zaehler1++;
				index1w.add(StW.get(i));
				
			}
			if (posEbene == StW.get(i).getPosition().getEbene().getValue()
					&& posY == StW.get(i).getPosition().getY().getValue()) {
				zaehler2++;
				index2w.add(StW.get(i));
			}
			if (posX == StW.get(i).getPosition().getX().getValue()
					&& posY == StW.get(i).getPosition().getY().getValue() && (posX+posY==3 || posX+posY==5)) {
				zaehler3++;
				index3w.add(StW.get(i));
			}

		}

		if (zaehler1 == 3|| zaehler2 == 3|| zaehler3 == 3) {
			if(zaehler1==3){
				for(int z = 0; z<index1w.size();z++){
					index1w.get(z).setInMuehle(true);
				}
			}
			if(zaehler2==3){
				for(int z = 0; z<index2w.size();z++){
					index2w.get(z).setInMuehle(true);
				}
			}
			if(zaehler3==3){
				for(int z = 0; z<index3w.size();z++){
					index3w.get(z).setInMuehle(true);
				}
			}
			System.out.println("Muehle weiss");
			Muehle_weiss=true;
			
		}

	}

	public void ueberpruefen_Muehele_schwarz(Position pos) {
		Muehle_schwarz=false;
		int zaehler1 = 0;
		int zaehler2 = 0;
		int zaehler3 = 0;
		
		index1s.clear();
		index2s.clear();
		index3s.clear();

		int posEbene = pos.getEbene().getValue();
		int posX = pos.getX().getValue();
		int posY = pos.getY().getValue();

		for (int i = 0; i < StS.size(); i++) {
			
			
			if (posEbene == StS.get(i).getPosition().getEbene().getValue()
					&& posX == StS.get(i).getPosition().getX().getValue()) {
				zaehler1++;
				index1s.add(StS.get(i));
			}
			if (posEbene == StS.get(i).getPosition().getEbene().getValue()
					&& posY == StS.get(i).getPosition().getY().getValue()) {
			zaehler2++;
			index2s.add(StS.get(i));
			}
			if (posX == StS.get(i).getPosition().getX().getValue()
					&& posY == StS.get(i).getPosition().getY().getValue()&& (posX+posY==3  || posX+posY==5)) {
				zaehler3++;
				index3s.add(StS.get(i));
			}

		}

		if (zaehler1 == 3 || zaehler2 == 3 || zaehler3 == 3) {
			if(zaehler1==3){
				for(int z = 0; z<index1s.size();z++){
					index1s.get(z).setInMuehle(true);
				}
			}
			if(zaehler2==3){
				for(int z = 0; z<index2s.size();z++){
					index2s.get(z).setInMuehle(true);
				}
			}
			if(zaehler3==3){
				for(int z = 0; z<index3s.size();z++){
					index3s.get(z).setInMuehle(true);
				}
			}
			System.out.println("Muehle schwarz");
			Muehle_schwarz=true;
		}

	}
	
	public List<Spielstein> getIndex1s() {
		return index1s;
	}

	public void setIndex1s(List<Spielstein> index1s) {
		this.index1s = index1s;
	}

	public List<Spielstein> getIndex2s() {
		return index2s;
	}

	public void setIndex2s(List<Spielstein> index2s) {
		this.index2s = index2s;
	}

	public List<Spielstein> getIndex3s() {
		return index3s;
	}

	public void setIndex3s(List<Spielstein> index3s) {
		this.index3s = index3s;
	}

	public List<Spielstein> getIndex1w() {
		return index1w;
	}

	public void setIndex1w(List<Spielstein> index1w) {
		this.index1w = index1w;
	}

	public List<Spielstein> getIndex2w() {
		return index2w;
	}

	public void setIndex2w(List<Spielstein> index2w) {
		this.index2w = index2w;
	}

	public List<Spielstein> getIndex3w() {
		return index3w;
	}

	public void setIndex3w(List<Spielstein> index3w) {
		this.index3w = index3w;
	}

	public void setzenSteingueltig(Position pos){
		//Pr�fen ob Stein an Eckposition
		if(pos.getX().getValue()+pos.getY().getValue()%2==0){
			// Ermitteln g�ltiger Z�ge
			//�nderung der X Position 
		}
	}

}
