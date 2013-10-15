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
	
	
	private void flushAllThemes(){
		for(int i=0;i<availableThemes.length;i++)
			availableThemes[i].flushThemeImages();
	}
	
	
	
	/**
	 * Lädt eine Theme
	 * @param index Index der Theme
	 */
	public Theme getTheme(int index){
		return availableThemes[index];
	}
	
	/**
	 * Lädt eine Theme
	 * @param name Name der Theme
	 */
	public Theme getTheme(String name){
		flushAllThemes();
		
		for(int i=0;i<availableThemes.length;i++){
			if(availableThemes[i].getThemeName().equals(name))
				return availableThemes[i];
		}
		return null;
	}
}
