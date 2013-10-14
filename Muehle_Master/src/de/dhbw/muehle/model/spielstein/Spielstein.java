package de.dhbw.muehle.model.spielstein;


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
		inMuehle=false;
	}
	
	
	@Override
	public ESpielsteinFarbe getFarbe() {
		
		return farbe;
	}

	@Override
	public Position getPosition() {
		
		return position;
		
	}
	
	public void setPosition(EPositionIndex ebene,EPositionIndex x,EPositionIndex y) {
		
		this.position = new Position(ebene, x, y);
		
	}
}
