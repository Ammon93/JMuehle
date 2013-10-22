package de.dhbw.muehle.gui;

/**
 * Diese Klasse dient als Schnittstelle zwischen dem Core und der View
 */

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComponent;

import de.dhbw.muehle.core.Core;
import de.dhbw.muehle.gui.menus.GamePanel.LblGameStone;
import de.dhbw.muehle.gui.menus.Menu;
import de.dhbw.muehle.model.spielstein.ISpielstein;
import de.dhbw.muehle.model.spielstein.Position;
import de.dhbw.muehle.model.theme.Sound;
import de.dhbw.muehle.model.theme.Sound.Sounds;
import de.dhbw.muehle.model.theme.Theme;
import de.dhbw.muehle.model.theme.ThemeLoader;

public class ViewController implements IViewController {

	private View frame;

	private Core core;
	private ThemeLoader thLoader;
	private Theme theme;

	public ViewController(Core _core) {
		thLoader = new ThemeLoader();
		setTheme("Wooden Mill");

		frame = new View(this, theme);
		core = _core;
	}

	public void initGui() {
		displayMainMenu();
		frame.setVisible(true); // Frame anzeigen
		
	}

	public void displayMainMenu() {
		if(!theme.isSoundPlaying())
			getTheme().playSound(Sounds.menue); // Hauptmenümusik abspielen
		frame.setContentPane(frame.getMainMenu()); // Hauptmenü anzeigen
	}

	public void startPvP() {
		getTheme().stopSound();
		frame.setContentPane(frame.getGamePanel()); // GamePanel (Spielbrett)
		changePlayer(); // Weiß beginnt
	}

	public void displaySettings() {
		frame.setContentPane(frame.getSetingsPanel());
	}

	public void changePlayer() {
		frame.getGamePanel().changePlayer();
	}



	public Theme getTheme() {
		return theme;
	}
	
	public Theme getTheme(String theme) {
		return thLoader.getTheme(theme);
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
		
		if(frame != null)
			frame.setTheme(theme);
		
		Sound.setSoundPfad(theme.getSoundPfad());
	}
	
	public void setTheme(String theme) {
		setTheme(thLoader.getTheme(theme));
	}


	public void angeklickter_Stein_speichern(LblGameStone stone) {

	}
	
	
	public View getView(){
		return frame;
	}
	

	public Core getCore() {
		return core;
	}

	public void setCore(Core core) {
		this.core = core;
	}
	
	
	public void resizePanel(Menu panel){
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
	

	@Override
	public Position getPosition(ISpielstein spielStein) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ISpielstein> setPosition(ISpielstein spielStein,
			Position position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ISpielstein> getSpielSteine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ISpielstein> removeSpielStein(ISpielstein spielStein) {
		// TODO Auto-generated method stub
		return null;
	}
}
