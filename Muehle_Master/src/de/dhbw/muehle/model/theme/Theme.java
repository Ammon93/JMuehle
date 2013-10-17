package de.dhbw.muehle.model.theme;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Theme {
	
	private File themePath;
	
	
	private Image leiste,
				  leisteClose,
				  leisteMaximize,
				  leisteMinimize;
	
	private Image menueHintergrund,
				  einstellungsHintergrund;
	
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
				  btnHilfe,
				  btnOK,
				  btnZumMenue,
				  btnTheme,
				  btnX,
				  btnZurueck;
	
	private Image siegerPvE,
				  siegerPvP,
				  verlierer;
	
	
	
	public Theme(File themePath){
		this.themePath = themePath;
	}
	
	
	/**
	 * Liefert das Image
	 * @param relPfad relativer Pfad zum Bild
	 * @return Image
	 */
	private Image getImage(String relPfad){
		try {
			return ImageIO.read(new File(themePath.getPath()+relPfad));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Löscht alle Bilder
	 */
	public void flushThemeImages(){
		leiste = null;
		leisteClose = null;
		leisteMaximize = null;
		leisteMinimize = null;
		
		menueHintergrund = null;
		einstellungsHintergrund = null;

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
		btnHilfe = null;
		btnOK = null;

		siegerPvE = null;
		siegerPvP = null;
		verlierer = null;
	}
	
	
	/**
	 * Liefert den Namen der Theme
	 * @return name
	 */
	public String getThemeName(){
		return themePath.getName();
	}
	
	
	/**
	 * @return themePath
	 */
	public File getThemePath() {
		return themePath;
	}
	
	
	
	
	/**
	 * Getter für die einzelnen Bilder
	 */
	
		/**
		 * @return the leiste
		 */
		public Image getLeiste() {
			if(leiste != null)
				return leiste;
			else
				return leiste = getImage("/Leiste/Leiste.png");
		}
	
	
		/**
		 * @return the leisteClose
		 */
		public Image getLeisteClose() {
			if(leisteClose != null)
				return leisteClose;
			else
				return leisteClose = getImage("/Leiste/close.png");
		}
	
	
		/**
		 * @return the leisteMaximize
		 */
		public Image getLeisteMaximize() {
			if(leisteMaximize!= null)
				return leisteMaximize;
			else
				return leisteMaximize = getImage("/Leiste/maximize.png");
		}
	
	
		/**
		 * @return the leisteMinimize
		 */
		public Image getLeisteMinimize() {
			if(leisteMinimize != null)
				return leisteMinimize;
			else
				return leisteMinimize = getImage("/Leiste/minimize.png");
		}


		/**
		 * @return menueHintergrund
		 */
		public Image getMenueHintergrund() {
			if(menueHintergrund != null)
				return menueHintergrund;
			else
				return menueHintergrund = getImage("/Menuebild/Menuehintergrundbild.png");
		}
		
		
		/**
		 * @return einstellungsHintergrund
		 */
		public Image getEinstellungsHintergrund() {
			if(einstellungsHintergrund != null)
				return einstellungsHintergrund;
			else
				return einstellungsHintergrund = getImage("/Einstellungen/EinstellungenHintergrundbild.png");
		}
		
		
		/**
		 * @return logo
		 */
		public Image getLogo(){
			if(logo != null)
				return logo;
			else
				return logo = getImage("/Logo/Logo.png");
		}
		
	
		/**
		 * @return spielBrett
		 */
		public Image getSpielBrett() {
			if(spielBrett != null)
				return spielBrett;
			else
				return spielBrett = getImage("/Spielbrett/Spielbrett.png");
		}
	
	
		/**
		 * @return spielSteinWeiss
		 */
		public Image getSpielSteinWeiss() {
			if(spielSteinWeiss != null)
				return spielSteinWeiss;
			else
				return spielSteinWeiss = getImage("/Steine/WeisserStein.png");
		}
	
	
		/**
		 * @return spielSteinWeissGewaehlt
		 */
		public Image getSpielSteinWeissGewaehlt() {
			if(spielSteinWeissGewaehlt != null)
				return spielSteinWeissGewaehlt;
			else
				return spielSteinWeissGewaehlt = getImage("/Steine/WeisserSteinAusgewaehlt.png");
		}
	
	
		/**
		 * @return spielSteinWeissTransparent
		 */
		public Image getSpielSteinWeissTransparent() {
			if(spielSteinWeissTransparent != null)
				return spielSteinWeissTransparent;
			else
				return spielSteinWeissTransparent = getImage("/Steine/WeisserSteinTransparent.png");
		}
	
	
		/**
		 * @return spielSteinSchwarz
		 */
		public Image getSpielSteinSchwarz() {
			if(spielSteinSchwarz != null)
				return spielSteinSchwarz;
			else
				return spielSteinSchwarz = getImage("/Steine/SchwarzerStein.png");
		}
	
	
		/**
		 * @return spielSteinSchwarzGewaehlt
		 */
		public Image getSpielSteinSchwarzGewaehlt() {
			if(spielSteinSchwarzGewaehlt != null)
				return spielSteinSchwarzGewaehlt;
			else
				return spielSteinSchwarzGewaehlt = getImage("/Steine/SchwarzerSteinAusgewaehlt.png");
		}
	
	
		/**
		 * @return spielSteinSchwarzTransparent
		 */
		public Image getSpielSteinSchwarzTransparent() {
			if(spielSteinSchwarzTransparent != null)
				return spielSteinSchwarzTransparent;
			else
				return spielSteinSchwarzTransparent = getImage("/Steine/SchwarzerSteinTransparent.png");
		}
	
	
		/**
		 * @return btnAbbrechen
		 */
		public Image getBtnAbbrechen() {
			if(btnAbbrechen != null)
				return btnAbbrechen;
			else
				return btnAbbrechen = getImage("/Buttons/Abbrechen.png");
		}
	
	
		/**
		 * @return btnBeenden
		 */
		public Image getBtnBeenden() {
			if(btnBeenden != null)
				return btnBeenden;
			else
				return btnBeenden = getImage("/Buttons/Beenden.png");
		}
	
	
		/**
		 * @return btnEinstellungen
		 */
		public Image getBtnEinstellungen() {
			if(btnEinstellungen != null)
				return btnEinstellungen;
			else
				return btnEinstellungen = getImage("/Buttons/Einstellungen.png");
		}
	
	
		/**
		 * @return btnPvE
		 */
		public Image getBtnPvE() {
			if(btnPvE != null)
				return btnPvE;
			else
				return btnPvE = getImage("/Buttons/Einzelspieler.png");
		}
	
	
		/**
		 * @return btnPvP
		 */
		public Image getBtnPvP() {
			if(btnPvP != null)
				return btnPvP;
			else
				return btnPvP = getImage("/Buttons/Mehrspieler.png");
		}
	
	
		/**
		 * @return btnHilfe
		 */
		public Image getBtnHilfe() {
			if(btnHilfe!= null)
				return btnHilfe;
			else
				return btnHilfe = getImage("/Buttons/Hilfe.png");
		}
	
	
		/**
		 * @return btnOK
		 */
		public Image getBtnOK() {
			if(btnOK != null)
				return btnOK;
			else
				return btnOK = getImage("/Buttons/OK.png");
		}
		
		
		/**
		 * @return btnZumMenue
		 */
		public Image getBtnZumMenue() {
			if(btnZumMenue != null)
				return btnZumMenue;
			else
				return btnZumMenue = getImage("/Buttons/ZumMenue.png");
		}
	
	
		/**
		 * @return the btnTheme
		 */
		public Image getBtnTheme() {
			if(btnTheme != null)
				return btnTheme;
			else
				return btnTheme = getImage("/Buttons/Theme.png");
		}


		/**
		 * @return the btnX
		 */
		public Image getBtnX() {
			if(btnX != null)
				return btnX;
			else
				return btnX = getImage("/Buttons/x.png");
		}


		/**
		 * @return the btnZurueck
		 */
		public Image getBtnZurueck() {
			if(btnZurueck != null)
				return btnZurueck;
			else
				return btnZurueck = getImage("/Buttons/zurueck.png");
		}


		/**
		 * @return siegerPvE
		 */
		public Image getSiegerPvE() {
			if(siegerPvE != null)
				return siegerPvE;
			else
				return siegerPvE = getImage("/SiegerbildVerliererbild/Siegerbild/SiegerHumanvspcschwarz.png");
		}
	
	
		/**
		 * @return siegerPvP
		 */
		public Image getSiegerPvP() {
			if(siegerPvP != null)
				return siegerPvP;
			else
				return siegerPvP = getImage("/SiegerbildVerliererbild/Siegerbild/SiegerHumanvshumanschwarz.png");
		}
	
	
		/**
		 * @return verlierer
		 */
		public Image getVerlierer() {
			if(verlierer != null)
				return verlierer;
			else
				return verlierer = getImage("/SiegerbildVerliererbild/Verliererbild/Verlierer.png");
		}
}