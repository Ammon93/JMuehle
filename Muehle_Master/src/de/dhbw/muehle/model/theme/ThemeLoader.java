package de.dhbw.muehle.model.theme;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ThemeLoader {

	private String[] themeFolders;
	private Theme availableThemes[];
	

	public ThemeLoader(){
		String ressource = "themes";
		
		//Hauptordner für die Themes
		try {
			themeFolders = getResourcenOrdner(getClass(), ressource);
		} catch (URISyntaxException | IOException e) {e.printStackTrace();}
		
		availableThemes = new Theme[themeFolders.length];
		int i = 0;
		for(String theme : themeFolders){
			availableThemes[i] = new Theme(ressource + "/" + theme);
			i++;
		}
	}
	
	
	private void flushAllThemes(){
		for(int i=0;i<availableThemes.length;i++)
			availableThemes[i].flushThemeImages();
	}
	
	
	/**
	 * Liefert einen Stringarray zurück, der alle Themennamen enthält.
	 * Die Namen sind gleich mit denen des Unterordners, dessen Pfad als Parameter mit übergeben wird.
	 * 
	 * @param klasse Irgendeine Klasse des Projekts (meist: this.getClass())
	 * @param pfad Pfad der Ressource, die durchsucht werden soll
	 * @return Alle Namen der gefundenen Unterordner
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	private String[] getResourcenOrdner(Class<?> klasse, String pfad) throws URISyntaxException, IOException {
		URL ordnerURL = klasse.getClassLoader().getResource(pfad);
		
		// wenn ein Ordner erreicht werden kann (außerhalb einer jar-Datei)
		if (ordnerURL != null && ordnerURL.getProtocol().equals("file")) {
			return new File(ordnerURL.toURI()).list();
		}

		// wenn kein Ordern erreicht werden kann (in einer jar-Datei)
		if (ordnerURL == null) {
			ordnerURL = klasse.getResource(klasse.getSimpleName() + ".class");
		}
		
		// wenn es sich um eine jar-Datei handelt
		if (ordnerURL.getProtocol().equals("jar")) {
			String jarPfad = ordnerURL.getPath().substring(5, ordnerURL.getPath().indexOf("!"));
			
			JarFile jar = new JarFile(URLDecoder.decode(jarPfad, "UTF-8"));
			Enumeration<JarEntry> eintraege = jar.entries();
			Set<String> ergebnisse = new HashSet<String>();
			
			while (eintraege.hasMoreElements()) {
				String name = eintraege.nextElement().getName();
				
				if (name.startsWith(pfad)) {
					String eintrag = name.substring(pfad.length()+1);
					int checkSubdir = eintrag.indexOf("/");
					if (checkSubdir >= 0) {
						eintrag = eintrag.substring(0, checkSubdir);
						ergebnisse.add(eintrag);
					}
				}
			}
			jar.close();
			
			return ergebnisse.toArray(new String[0]);
		}

		throw new UnsupportedOperationException("Cannot list files for URL " + ordnerURL);
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
