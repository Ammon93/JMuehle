package de.dhbw.muehle.model.theme;

import java.io.File;

public class ThemeLoader {

	private File themeFolder;
	private Theme availableThemes[];
	

	public ThemeLoader(){
		//Hauptordner für die Themes
		themeFolder = new File("res/themes/");
		
		availableThemes = new Theme[themeFolder.list().length];
		int i = 0;
		for(String theme : themeFolder.list()){
			availableThemes[i] = new Theme(new File(themeFolder, theme));
			i++;
		}
	}
	
	
	
	/**
	 * Lädt eine Theme
	 * @param Index der Theme
	 */
	public Theme getTheme(int index){
		return availableThemes[index];
	}
}
