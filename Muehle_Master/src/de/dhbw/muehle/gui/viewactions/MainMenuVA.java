package de.dhbw.muehle.gui.viewactions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.dhbw.muehle.gui.ViewController;

/**
 * Hier werden alle Action Listener der View implementiert
 * @author Kreistschen
 *
 */

public class MainMenuVA {
	
	ViewController vController;
	
	
	public MainMenuVA(ViewController vController) {
		this.vController = vController;
	}
	
	
	
	/**
	 * Actionlistener
	 */
//	{
		//btnPvE
		public class btnPvEAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnPvE(e);
			}
		}
		
		//btnPvP
		public class btnPvPAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnPvP(e);
			}
		}
		
		//btnSettings
		public class btnSettingsAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnSettings(e);
			}
		}
		
		//btnQuit
		public class btnQuitAction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnQuit(e);
			}
		}
//	}
		
		


	/**
	 * Methoden, die von den einzelnen Listenern aufgerufen werden
	 */
	//MainMenu
	private void actionBtnPvE(ActionEvent e) {
		vController.startPvE();
	}
	
	private void actionBtnPvP(ActionEvent e) {
		
	}
	
	private void actionBtnSettings(ActionEvent e) {
		vController.displaySettings();
	}

	private void actionBtnQuit(ActionEvent e) {
		// Programm beenden
		System.exit(0); //noch die brachiale Methode, muss noch besser gelöst werden!!!
	}
}