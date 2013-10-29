package de.dhbw.muehle.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JComponent;

import de.dhbw.muehle.core.Core;
import de.dhbw.muehle.gui.menus.AMenu;
import de.dhbw.muehle.gui.menus.GamePanel;
import de.dhbw.muehle.gui.menus.MainMenu;
import de.dhbw.muehle.gui.menus.SettingsPanel;
import de.dhbw.muehle.model.theme.Sound;
import de.dhbw.muehle.model.theme.Sound.Sounds;
import de.dhbw.muehle.model.theme.Theme;
import de.dhbw.muehle.model.theme.ThemeLoader;

/**
 * Diese Klasse dient als Schnittstelle zwischen dem {@link Core} und der {@link View}.
 * 
 * @author Ammon
 */
public class ViewController {

	private View frame;

	private Core core;
	private ThemeLoader thLoader;
	private Theme theme;

	
	/**
	 * Konstruktor
	 * 
	 * @param _core
	 */
	public ViewController(Core _core) {
		thLoader = new ThemeLoader();
		setTheme("Wooden Mill");

		frame = new View(this, theme);
		core = _core;
	}

	
	
	/**
	 * Initialisiert die GUI/{@link View}.
	 */
	public void initGui() {
		displayMainMenu();
		frame.setVisible(true); // Frame anzeigen
	}
	
	
	/**
	 * Zeigt das {@link MainMenu} an.
	 */
	public void displayMainMenu() {
		if(!theme.isSoundPlaying())
			getTheme().playSound(Sounds.menue); // Hauptmenümusik abspielen
		frame.setContentPane(frame.getMainMenu()); // Hauptmenü anzeigen
	}
	
	
	/**
	 * Startet das Spiel im Einzelspielermodus.
	 */
	public void startPvE(){
		if(!frame.getGlobalVA().getGamePanelVA().isPvE())
			core.resetAll();
		
		frame.getGlobalVA().getGamePanelVA().setPvE(true);
		
		getTheme().stopSound();
		frame.setContentPane(frame.getGamePanel()); // GamePanel (Spielbrett)
		changePlayer(); // Weiß beginnt
		
		// inputDialog einblenden
		if(!getView().getGamePanel().anyChangesMade())
			new Thread(){
				public void run(){
					try {
						sleep(300);
					} catch (InterruptedException e) {e.printStackTrace();}
					
					frame.getGamePanel().openInputDialog();
				}
			}.start();
	}

	
	/**
	 * Startet das Spiel im Mehrspielermodus
	 */
	public void startPvP() {
		if(frame.getGlobalVA().getGamePanelVA().isPvE())
			core.resetAll();
		
		frame.getGlobalVA().getGamePanelVA().setPvE(false);
		
		getTheme().stopSound();
		frame.setContentPane(frame.getGamePanel()); // GamePanel (Spielbrett)
		changePlayer(); // Weiß beginnt
		
		// inputDialog einblenden
		if(!getView().getGamePanel().anyChangesMade())
			new Thread(){
				public void run(){
					try {
						sleep(300);
					} catch (InterruptedException e) {e.printStackTrace();}
					
					frame.getGamePanel().openInputDialog();
				}
			}.start();
	}
	
	
	/**
	 * Zeigt das {@link SettingsPanel} an.
	 */
	public void displaySettings() {
		frame.setContentPane(frame.getSetingsPanel());
	}
	
	
	
	/**
	 * Ruft die Methoden zum Öffnen/Schließen der Dialoge in der jeweiligen Klasse auf.
	 * 
	 * @param command
	 * @param dialogType
	 * @param parentMenu
	 */
	public void openDialog(String command, String dialogType, AMenu parentMenu){
		openDialog(command, dialogType, "", parentMenu);
	}
	
	/**
	 * @see openDialog(String command, String dialogType, AMenu parentMenu)
	 * @param command
	 * @param dialogType
	 * @param message
	 * @param parentMenu
	 */
	public void openDialog(String command, String dialogType, String message, AMenu parentMenu){
		try {
			if(message.isEmpty())
				Class.forName(parentMenu.getClass().getName()).getMethod(command+dialogType).invoke(parentMenu);
			else
				Class.forName(parentMenu.getClass().getName()).getMethod(command+dialogType, String.class).invoke(parentMenu, message);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException | ClassNotFoundException e) {e.printStackTrace();}
	}

	
	/**
	 * Ändert den Spieler, der gerade am Zug ist, auf dem {@link InfoField}.
	 */
	public void changePlayer() {
		frame.getGamePanel().changePlayer();
	}
	
	
	/**
	 * Setzt das {@link GamePanel} zurück.
	 */
	public void resetGamePanel(){
		frame.setGamePanel(new GamePanel(this, frame));
	}


	/**
	 * Gibt das aktuelle Theme zurück
	 * 
	 * @return {@link Theme}
	 */
	public Theme getTheme() {
		return theme;
	}
	
	/**
	 * Gibt ein Theme anhand des Namens zurück
	 * 
	 * @param theme String mit dem Themenamen
	 * @return {@link Theme}
	 */
	public Theme getTheme(String theme) {
		return thLoader.getTheme(theme);
	}

	
	/**
	 * Setzt die Theme.
	 * 
	 * @param theme
	 */
	public void setTheme(Theme theme) {
		this.theme = theme;
		
		if(frame != null)
			frame.setTheme(theme);
		
		Sound.setSoundPfad(theme.getSoundPfad());
	}
	
	/**
	 * Setzt die Theme anhand des Namens.
	 * 
	 * @param theme
	 */
	public void setTheme(String theme) {
		setTheme(thLoader.getTheme(theme));
	}
	
	
	/**
	 * Liefert den {@link View} zurück.
	 * 
	 * @return {@link View}
	 */
	public View getView(){
		return frame;
	}
	

	/**
	 * Liefert den {@link Core} zurück.
	 * 
	 * @return {@link Core}
	 */
	public Core getCore() {
		return core;
	}
	
	
	
	/**
	 * Vergrößert die {@link AMenu}-Panels im richtigen Seitenverhältnis
	 * 
	 * @param panel
	 */
	public void resizePanel(AMenu panel){
		double aspectRatio = (double) panel.getOriginalSize().height / (double) panel.getOriginalSize().width;
		
		JComponent parent = (JComponent) panel.getParent();
        Insets insets = parent.getInsets();
        int width = parent.getWidth() - insets.left - insets.right;
        int height = parent.getHeight() - insets.top - insets.bottom;
        
        int vCenter = height;
        int hCenter = width;
        
        
        width = (int) Math.min(width, height / aspectRatio);
        height = (int) Math.min(width * aspectRatio, height);
        
        vCenter = (vCenter - height) / 2;
        hCenter = (hCenter - width) / 2;
        
        panel.setPreferredSize(new Dimension(width, height));
        ((FlowLayout) parent.getLayout()).setVgap(vCenter);
        
        panel.revalidate();
        panel.repaint();
	}
}