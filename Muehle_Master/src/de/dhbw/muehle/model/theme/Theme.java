package de.dhbw.muehle.model.theme;

import java.awt.Image;

import javax.swing.ImageIcon;


public class Theme {
	
	private String themePath;
	
	
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
	
	
	
	public Theme(String themePath){
		this.themePath = themePath;
	}
	
	
	/**
	 * Liefert das Image zurück
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
	 * Löscht alle Bilder
	 */
	protected void flushThemeImages(){
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
		return themePath.split("/")[1];
	}
	
	
	/**
	 * @return themePath
	 */
	public String getThemePfad() {
		return themePath;
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
		 * @return siegerPvE
		 */
		public Image getSiegerPvE() {
			return siegerPvE = returnImage("/SiegerbildVerliererbild/Siegerbild/SiegerHumanvspcschwarz.png", siegerPvE);
		}
	
	
		/**
		 * @return siegerPvP
		 */
		public Image getSiegerPvP() {
			return siegerPvP = returnImage("/SiegerbildVerliererbild/Siegerbild/SiegerHumanvshumanschwarz.png", siegerPvP);
		}
	
	
		/**
		 * @return verlierer
		 */
		public Image getVerlierer() {
			return verlierer = returnImage("/SiegerbildVerliererbild/Verliererbild/Verlierer.png", verlierer);
		}
}