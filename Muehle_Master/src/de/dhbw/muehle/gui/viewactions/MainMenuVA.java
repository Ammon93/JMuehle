package de.dhbw.muehle.gui.viewactions;

import java.awt.event.ActionEvent;

import de.dhbw.muehle.gui.DialogBackgroundPanel;
import de.dhbw.muehle.gui.menus.MainMenu;

/**
 * Hier werden alle Listener des {@link MainMenu} implementiert
 * @author Ammon
 */
public class MainMenuVA extends ViewActions{	
	
	/**
	 * Actionlistener
	 */
//	{
		//btnPvE
		public class btnPvEAction extends ABtnPvE{
			@Override
			public void actionPerformed(ActionEvent e) {
				core.startPvE();
			}
		}
		
		//btnPvP
		public class btnPvPAction extends ABtnPvP{
			@Override
			public void actionPerformed(ActionEvent e) {
				core.startPvP();
			}
		}
		
		//btnSettings
		public class btnSettingsAction extends ABtnSettings{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.displaySettings();
			}
		}
		
		//btnQuit
		public class btnQuitAction extends ABtnQuit{
			@Override
			public void actionPerformed(ActionEvent e) {
				// Programm beenden
				System.exit(0); //noch die brachiale Methode, muss noch besser gelöst werden!!!
			}
		}
		
		public class btnHilfeAction extends ABtnHilfe{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.openDialog(DialogBackgroundPanel.OPEN, DialogBackgroundPanel.SPIELREGELN, vController.getView().getActualPanel());
			}
		}
		
		
		public class dialogBtnBack extends ADialogBtnOK{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.openDialog(DialogBackgroundPanel.CLOSE, DialogBackgroundPanel.SPIELREGELN, vController.getView().getActualPanel());
			}
		}
//	}
}