package de.dhbw.muehle.model.spielstein;


public class Spielstein implements ISpielstein{
	
	private Position position;
	private ESpielsteinFarbe farbe;
	
	
	public Spielstein(EPositionIndex ebene,EPositionIndex x,EPositionIndex y,ESpielsteinFarbe farbe){
		
		position = new Position(ebene, x, y);
		this.farbe = farbe;
	}
	
	
	@Override
	public ESpielsteinFarbe getFarbe() {
		
		return farbe;
	}

	@Override
	public Position getPosition() {
		
		return position;
		
	}
}
