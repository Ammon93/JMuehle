package de.dhbw.muehle;

import de.dhbw.muehle.core.Core;

public class Main {

	
	public static void main(String[] args) {
		
		/** Hier wird der Core des Programmes aufgerufen. 
		*Dieser Startet den GUI Controller, welcher wiederum die GUI startet
		*/
		
		Core muehle = new Core();
		muehle.initGame();
	}

}
