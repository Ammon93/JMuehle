package de.dhbw.muehle.model.theme;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;


public class Theme {
	
	private File themePath;
	
	
	private Image menueHintergrund;
	
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
				  btnOK;
	
	private Image siegerPvE,
				  siegerPvP,
				  verlierer;
	
	
	
	public Theme(File themePath){
		this.themePath = themePath;
		
		// Bilder aus Theme-Ordner laden
		menueHintergrund = getImgae("/Menuebild/Menuehintergrundbild.png");
		
		logo = getImgae("/Logo/Logo.png");
		
		spielBrett = getImgae("/Spielbrett/Spielbrett.png");
		
		spielSteinWeiss = getImgae("/Steine/WeisserStein.png");
		spielSteinWeissGewaehlt = getImgae("/Steine/WeisserSteinAusgewaehlt.png");
		spielSteinWeissTransparent = getImgae("/Steine/WeisserSteinTransparent.png");
		spielSteinSchwarz = getImgae("/Steine/SchwarzerStein.png");
		spielSteinSchwarzGewaehlt = getImgae("/Steine/SchwarzerSteinAusgewaehlt.png");
		spielSteinSchwarzTransparent = getImgae("/Steine/SchwarzerSteinTransparent.png");
		
		btnAbbrechen = getImgae("/Buttons/Abbrechen.png");
		btnBeenden = getImgae("/Buttons/Beenden.png");
		btnEinstellungen = getImgae("/Buttons/Einstellungen.png");
		btnHilfe = getImgae("/Buttons/Hilfe.png");
		btnOK = getImgae("/Buttons/OK.png");
		btnPvE = getImgae("/Buttons/Einzelspieler.png");
		btnPvP = getImgae("/Buttons/Mehrspieler.png");
		
		siegerPvE = getImgae("/SiegerbildVerliererbild/Siegerbild/SiegerHumanvshumanschwarz.png");
		siegerPvP = getImgae("/SiegerbildVerliererbild/Siegerbild/SiegerHumanvspcschwarz.png");
		verlierer = getImgae("/SiegerbildVerliererbild/Verliererbild/Verlierer.png");
	}
	
	
	/**
	 * Liefert das Image
	 * @param relPfad relativer Pfad zum Bild
	 * @return Image
	 */
	private Image getImgae(String relPfad){
		return new ImageIcon(themePath.getPath()+relPfad).getImage();
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
		 * @return menueHintergrund
		 */
		public Image getMenueHintergrund() {
			return menueHintergrund;
		}
		
		
		/**
		 * @return logo
		 */
		public Image getLogo(){
			return logo;
		}
		
	
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
		 * @return spielSteinWeissGewaehlt
		 */
		public Image getSpielSteinWeissGewaehlt() {
			return spielSteinWeissGewaehlt;
		}
	
	
		/**
		 * @return spielSteinWeissTransparent
		 */
		public Image getSpielSteinWeissTransparent() {
			return spielSteinWeissTransparent;
		}
	
	
		/**
		 * @return spielSteinSchwarz
		 */
		public Image getSpielSteinSchwarz() {
			return spielSteinSchwarz;
		}
	
	
		/**
		 * @return spielSteinSchwarzGewaehlt
		 */
		public Image getSpielSteinSchwarzGewaehlt() {
			return spielSteinSchwarzGewaehlt;
		}
	
	
		/**
		 * @return spielSteinSchwarzTransparent
		 */
		public Image getSpielSteinSchwarzTransparent() {
			return spielSteinSchwarzTransparent;
		}
	
	
		/**
		 * @return btnAbbrechen
		 */
		public Image getBtnAbbrechen() {
			return btnAbbrechen;
		}
	
	
		/**
		 * @return btnBeenden
		 */
		public Image getBtnBeenden() {
			return btnBeenden;
		}
	
	
		/**
		 * @return btnEinstellungen
		 */
		public Image getBtnEinstellungen() {
			return btnEinstellungen;
		}
	
	
		/**
		 * @return btnPvE
		 */
		public Image getBtnPvE() {
			return btnPvE;
		}
	
	
		/**
		 * @return btnPvP
		 */
		public Image getBtnPvP() {
			return btnPvP;
		}
	
	
		/**
		 * @return btnHilfe
		 */
		public Image getBtnHilfe() {
			return btnHilfe;
		}
	
	
		/**
		 * @return btnOK
		 */
		public Image getBtnOK() {
			return btnOK;
		}
	
	
		/**
		 * @return siegerPvE
		 */
		public Image getSiegerPvE() {
			return siegerPvE;
		}
	
	
		/**
		 * @return siegerPvP
		 */
		public Image getSiegerPvP() {
			return siegerPvP;
		}
	
	
		/**
		 * @return verlierer
		 */
		public Image getVerlierer() {
			return verlierer;
		}
}