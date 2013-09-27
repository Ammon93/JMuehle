package de.dhbw.muehle.model.theme;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;


public class Theme {
	
	private File themePath;
	
	private Image spielBrett,
				  spielSteinWeiss,
				  spielSteinSchwarz;
	
	
	public Theme(File themePath){
		this.themePath = themePath;
		
		// Bilder aus Theme-Ordner laden
		spielBrett = new ImageIcon(themePath.getPath()+"/Spielbrett/Spielbrett.png").getImage();
		spielSteinWeiss = new ImageIcon(themePath.getPath()+"/Steine/WeisserStein.png").getImage();
		spielSteinSchwarz = new ImageIcon(themePath.getPath()+"/Steine/SchwarzerStein.png").getImage();
	}
	
	
	/**
	 * Liefert den Namen der Theme
	 * @return name
	 */
	public String getThemeName(){
		return themePath.getName();
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
