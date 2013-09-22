package de.dhbw.muehle.model.theme;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;


public class Theme {
	
	private Image spielBrett,
				  spielSteinWeiss,
				  spielSteinSchwarz;
	
	
	public Theme(File themePath){
		// Bilder aus Theme-Ordner laden
		spielBrett = new ImageIcon(themePath.getPath()+"/Spielbrett/Spielbrett.png").getImage();
		spielSteinWeiss = new ImageIcon(themePath.getPath()+"/Steine/WeisserStein.png").getImage();
		spielSteinSchwarz = new ImageIcon(themePath.getPath()+"/Steine/SchwarzerStein.png").getImage();
	}
	
	
	
	/**
	 * Getter für die einzelnen Bilder
	 */

	/**
	 * @return spielBrett
	 */
	public Image getSpielBrett() {
		return spielBrett;
	}


	/**
	 * @return spielSteinWeiss
	 */
	public Image getSpielSteinWeiss() {
		return spielSteinWeiss;
	}


	/**
	 * @return spielSteinSchwarz
	 */
	public Image getSpielSteinSchwarz() {
		return spielSteinSchwarz;
	}
}
