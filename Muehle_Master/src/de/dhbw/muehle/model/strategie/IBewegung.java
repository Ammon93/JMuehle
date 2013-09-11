package de.dhbw.muehle.model.strategie;

import de.dhbw.muehle.model.spielstein.Position;

public interface IBewegung {

	/**
	 * Liefert die alte/aktuelle Position eines Steines.
	 *  
	 * @return Position
	 */
	public Position altePosition();
	
	/**
	 * Liefert die neue Position eines Steines.
	 * 
	 * @return Position
	 */
	public Position neuePosition();
}
