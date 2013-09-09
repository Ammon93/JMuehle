package de.dhbw.muehle.strategy;

import de.dhbw.muehle.Position;

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
