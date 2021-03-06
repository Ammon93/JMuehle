package de.dhbw.muehle.model.theme;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;

import de.dhbw.muehle.model.theme.Sound.Sounds;

/**
 * Diese Klasse enthält alle Bilder und Sounds des jeweiligen Themes
 * 
 * @author Ammon
 */
public class Theme {
	
	private String themePath;
	
	private Sound sound;
	private String soundPath;
	
	private Font themeFont;
	
	
	private Image leiste,
				  leisteClose,
				  leisteMaximize,
				  leisteMinimize;
	
	private Image menueHintergrund,
				  einstellungsHintergrund;
	
	private Image dialogHintergrund;
	
	private Image spielregeln;
	
	private Image logo;
	
	private Image spielBrett;
	
	private Image spielSteinWeiss,
				  spielSteinWeissGewaehlt,
				  spielSteinWeissTransparent,
				  spielSteinSchwarz,
				  spielSteinSchwarzGewaehlt,
				  spielSteinSchwarzTransparent;
	
	private Image btnAbbrechen,
				  btnBeenden,
				  btnEinstellungen,
				  btnPvE,
				  btnPvP,
				  btnNeustart,
				  btnHilfe,
				  btnOK,
				  btnZumMenue,
				  btnTheme,
				  btnX,
				  btnZurueck;
	
	private Image siegerPvEWeiss,
				  siegerPvESchwarz,
				  siegerPvPWeiss,
				  siegerPvPSchwarz,
				  verlierer;
	
	
	
	/**
	 * Konstruktor
	 * 
	 * @param themePath
	 */
	public Theme(String themePath){
		this.themePath = themePath;
		
		soundPath = themePath + "/Sounds";
		sound = new Sound();
	}
	
	
	/**
	 * Liefert das Image zurück.
	 * 
	 * @param relPfad relativer Pfad zum Bild
	 * @return Image
	 */
	private Image returnImage(String relPfad, Image destImage){
		if(destImage != null)
			return destImage;
		else
			return new ImageIcon(getClass().getClassLoader().getResource(themePath + relPfad)).getImage();
	}
	
	
	/**
	 * Löscht alle Bilder.
	 */
	protected void flushThemeImages(){
		leiste = null;
		leisteClose = null;
		leisteMaximize = null;
		leisteMinimize = null;
		
		menueHintergrund = null;
		einstellungsHintergrund = null;
		
		dialogHintergrund = null;
		
		spielregeln = null;

		logo = null;

		spielBrett = null;

		spielSteinWeiss = null;
		spielSteinWeissGewaehlt = null;
		spielSteinWeissTransparent = null;
		spielSteinSchwarz = null;
		spielSteinSchwarzGewaehlt = null;
		spielSteinSchwarzTransparent = null;

		btnAbbrechen = null;
		btnBeenden = null;
		btnEinstellungen = null;
		btnPvE = null;
		btnPvP = null;
		btnNeustart = null;
		btnHilfe = null;
		btnOK = null;
		btnTheme = null;
		btnX = null;
		btnZumMenue = null;
		btnZurueck = null;

		siegerPvEWeiss = null;
		siegerPvESchwarz = null;
		siegerPvPWeiss = null;
		siegerPvPSchwarz = null;
		verlierer = null;
	}
	
	
	
	/**
	 *  Spielt einen Sound ab.
	 *  
	 * @param sound
	 */
	public void playSound(Sounds sound){
		if(sound.equals(Sounds.menue))
			this.sound.playMusic(sound);
		else
			this.sound.playSound(sound);
	}
	
	
	/**
	 * Stoppt das Abspielen eines Sounds.
	 */
	public void stopSound(){
		this.sound.stopMusic();
	}
	
	
	/**
	 * Prüft, ob gerade ein Sound abgespielt wird.
	 * 
	 * @return {@link Boolean}
	 */
	public boolean isSoundPlaying(){
		return this.sound.isPlaying();
	}
	
	
	/**
	 * Gibt die Font für das jeweilige Theme zurück.
	 * 
	 * @return {@link Font}
	 */
	public Font getFont(){
		if(themeFont != null)
			return themeFont;
		else
			try {
				return themeFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResource(themePath + "/Font/Font.ttf").openStream());
			} catch (FontFormatException | IOException e) {
				e.printStackTrace();
				return new Font("Arial", Font.PLAIN, 12);
			}
	}
	
	/**
	 * Gibt die Farbe für das jeweilige Font zurück.
	 * 
	 * @return {@link Color}
	 */
	public Color getFontColor(){
		if(themePath.contains("Wooden Mill"))
			return new Color(49, 26, 12);
		else
			return Color.WHITE;
	}
	
	
	
	
	/**
	 * Liefert den Namen der Theme.
	 * 
	 * @return name
	 */
	public String getThemeName(){
		return themePath.split("/")[1];
	}
	
	
	/**
	 * Gibt den Themenpfad zurück.
	 * 
	 * @return themePath
	 */
	public String getThemePfad() {
		return themePath;
	}
	
	
	/**
	 * Gibt den Soundpfad zurück.
	 * 
	 * @return themePath
	 */
	public String getSoundPfad() {
		return soundPath;
	}
	
	
	
	
	/**
	 * Getter für die einzelnen Bilder
	 */
	
		/**
		 * @return the leiste
		 */
		public Image getLeiste() {
			return leiste = returnImage("/Leiste/Leiste.png", leiste);
		}
	
	
		/**
		 * @return the leisteClose
		 */
		public Image getLeisteClose() {
			return leisteClose = returnImage("/Leiste/close.png", leisteClose);
		}
	
	
		/**
		 * @return the leisteMaximize
		 */
		public Image getLeisteMaximize() {
			return leisteMaximize = returnImage("/Leiste/maximize.png", leisteMaximize);
		}
	
	
		/**
		 * @return the leisteMinimize
		 */
		public Image getLeisteMinimize() {
			return leisteMinimize = returnImage("/Leiste/minimize.png", leisteMinimize);
		}


		/**
		 * @return menueHintergrund
		 */
		public Image getMenueHintergrund() {
			return menueHintergrund = returnImage("/Menuebild/Menuehintergrundbild.png", menueHintergrund);
		}
		
		
		/**
		 * @return einstellungsHintergrund
		 */
		public Image getEinstellungsHintergrund() {
			return einstellungsHintergrund = returnImage("/Einstellungen/EinstellungenHintergrundbild.png", einstellungsHintergrund);
		}
		
		
		/**
		 * @return dialogHintergrund
		 */
		public Image getDialogHintergrund() {
			return dialogHintergrund = returnImage("/Dialog/Dialog.png", dialogHintergrund);
		}
		
		
		/**
		 * @return the spielregeln
		 */
		public Image getSpielregeln() {
			return spielregeln = returnImage("/Spielregeln/Spielregeln.png", spielregeln);
		}


		/**
		 * @return logo
		 */
		public Image getLogo(){
			return logo = returnImage("/Logo/Logo.png", logo);
		}
		
	
		/**
		 * @return spielBrett
		 */
		public Image getSpielBrett() {
			return spielBrett = returnImage("/Spielbrett/Spielbrett.png", spielBrett);
		}
	
	
		/**
		 * @return spielSteinWeiss
		 */
		public Image getSpielSteinWeiss() {
			return spielSteinWeiss = returnImage("/Steine/WeisserStein.png", spielSteinWeiss);
		}
	
	
		/**
		 * @return spielSteinWeissGewaehlt
		 */
		public Image getSpielSteinWeissGewaehlt() {
			return spielSteinWeissGewaehlt = returnImage("/Steine/WeisserSteinAusgewaehlt.png", spielSteinWeissGewaehlt);
		}
	
	
		/**
		 * @return spielSteinWeissTransparent
		 */
		public Image getSpielSteinWeissTransparent() {
			return spielSteinWeissTransparent = returnImage("/Steine/WeisserSteinTransparent.png", spielSteinWeissTransparent);
		}
	
	
		/**
		 * @return spielSteinSchwarz
		 */
		public Image getSpielSteinSchwarz() {
			return spielSteinSchwarz = returnImage("/Steine/SchwarzerStein.png", spielSteinSchwarz);
		}
	
	
		/**
		 * @return spielSteinSchwarzGewaehlt
		 */
		public Image getSpielSteinSchwarzGewaehlt() {
			return spielSteinSchwarzGewaehlt = returnImage("/Steine/SchwarzerSteinAusgewaehlt.png", spielSteinSchwarzGewaehlt);
		}
	
	
		/**
		 * @return spielSteinSchwarzTransparent
		 */
		public Image getSpielSteinSchwarzTransparent() {
			return spielSteinSchwarzTransparent = returnImage("/Steine/SchwarzerSteinTransparent.png", spielSteinSchwarzTransparent);
		}
	
	
		/**
		 * @return btnAbbrechen
		 */
		public Image getBtnAbbrechen() {
			return btnAbbrechen = returnImage("/Buttons/Abbrechen.png", btnAbbrechen);
		}
	
	
		/**
		 * @return btnBeenden
		 */
		public Image getBtnBeenden() {
			return btnBeenden = returnImage("/Buttons/Beenden.png", btnBeenden);
		}
	
	
		/**
		 * @return btnEinstellungen
		 */
		public Image getBtnEinstellungen() {
			return btnEinstellungen = returnImage("/Buttons/Einstellungen.png", btnEinstellungen);
		}
	
	
		/**
		 * @return btnPvE
		 */
		public Image getBtnPvE() {
			return btnPvE = returnImage("/Buttons/Einzelspieler.png", btnPvE);
		}
	
	
		/**
		 * @return btnPvP
		 */
		public Image getBtnPvP() {
			return btnPvP = returnImage("/Buttons/Mehrspieler.png", btnPvP);
		}
		
		
		/**
		 * @return btnNeustart
		 */
		public Image getBtnNeustart() {
			return btnNeustart = returnImage("/Buttons/Neustart.png", btnNeustart);
		}
	
	
		/**
		 * @return btnHilfe
		 */
		public Image getBtnHilfe() {
			return btnHilfe = returnImage("/Buttons/Hilfe.png", btnHilfe);
		}
	
	
		/**
		 * @return btnOK
		 */
		public Image getBtnOK() {
			return btnOK = returnImage("/Buttons/Ok.png", btnOK);
		}
		
		
		/**
		 * @return btnZumMenue
		 */
		public Image getBtnZumMenue() {
			return btnZumMenue= returnImage("/Buttons/ZumMenue.png", btnZumMenue);
		}
	
	
		/**
		 * @return the btnTheme
		 */
		public Image getBtnTheme() {
			return btnTheme = returnImage("/Buttons/Theme.png", btnTheme);
		}


		/**
		 * @return the btnX
		 */
		public Image getBtnX() {
			return btnX = returnImage("/Buttons/x.png", btnX);
		}


		/**
		 * @return the btnZurueck
		 */
		public Image getBtnZurueck() {
			return btnZurueck = returnImage("/Buttons/zurueck.png", btnZurueck);
		}


		/**
		 * @return siegerPvEWeiss
		 */
		public Image getSiegerPvEWeiss() {
			return siegerPvEWeiss = returnImage("/SiegerbildVerliererbild/Siegerbild/SiegerHumanvspcweiss.png", siegerPvEWeiss);
		}
		
		
		/**
		 * @return siegerPvESchwarz
		 */
		public Image getSiegerPvESchwarz() {
			return siegerPvESchwarz = returnImage("/SiegerbildVerliererbild/Siegerbild/SiegerHumanvspcschwarz.png", siegerPvESchwarz);
		}
	
	
		/**
		 * @return siegerPvPWeiss
		 */
		public Image getSiegerPvPWeiss() {
			return siegerPvPWeiss = returnImage("/SiegerbildVerliererbild/Siegerbild/SiegerHumanvshumanweiss.png", siegerPvPWeiss);
		}
		
		
		/**
		 * @return siegerPvPSchwarz
		 */
		public Image getSiegerPvPSchwarz() {
			return siegerPvPSchwarz = returnImage("/SiegerbildVerliererbild/Siegerbild/SiegerHumanvshumanschwarz.png", siegerPvPSchwarz);
		}
	
	
		/**
		 * @return verlierer
		 */
		public Image getVerlierer() {
			return verlierer = returnImage("/SiegerbildVerliererbild/Verliererbild/Verlierer.png", verlierer);
		}
}