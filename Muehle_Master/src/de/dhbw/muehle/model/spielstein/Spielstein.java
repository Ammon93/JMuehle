package de.dhbw.muehle.model.spielstein;

import javax.swing.JLabel;

import de.dhbw.muehle.EPositionIndex;
import de.dhbw.muehle.ESpielsteinFarbe;
import de.dhbw.muehle.ISpielstein;
import de.dhbw.muehle.Position;


public class Spielstein implements ISpielstein{
	
	private Position position;
	private ESpielsteinFarbe farbe;
	private boolean inMuehle;
	
	
	public boolean isInMuehle() {
		return inMuehle;
	}


	public void setInMuehle(boolean inMuehle) {
		this.inMuehle = inMuehle;
	}


	public Spielstein(EPositionIndex ebene,EPositionIndex x,EPositionIndex y,ESpielsteinFarbe farbe){
		
		position = new Position(ebene, x, y);
		this.farbe = farbe;
	//	inMuehle=false;
	}
	
	
	@Override
	public ESpielsteinFarbe getFarbe() {
		
		return farbe;
	}

	public void setPosition(EPositionIndex ebene,EPositionIndex x,EPositionIndex y) {
		
		this.position = new Position(ebene, x, y);
		
	}


	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return position;
	}
}
