package de.dhbw.muehle.gui.viewactions;

import java.awt.event.ActionEvent;

import de.dhbw.muehle.gui.menus.SettingsPanel;
import de.dhbw.muehle.model.theme.Sound.Sounds;

/**
 * Hier werden alle Listener für das {@link SettingsPanel} implementiert.
 * 
 * @author Ammon
 */
public class SettingsPanelVA extends ViewActions{
	
	/**
	 * ActionListener
	 */
//	{
		//btnBack
		public class btnBack extends ABtnBack{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.displayMainMenu();
			}
		}
		
		public class btnWoodenMill extends ABtnChangeTheme{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.setTheme("Wooden Mill");
				vController.getTheme().playSound(Sounds.menue);
			}
		}
		
		public class btn8bitMill extends ABtnChangeTheme{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.setTheme("8bit Mill");
				vController.getTheme().playSound(Sounds.menue);
			}
		}
		
		public class btnOSMill extends ABtnChangeTheme{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.setTheme("OS Mill");
				vController.getTheme().playSound(Sounds.menue);
			}
		}
		
		public class btnStarWarsMill extends ABtnChangeTheme{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.setTheme("Star Wars Mill");
				vController.getTheme().playSound(Sounds.menue);
			}
		}
		
		public class btnDirtyMill extends ABtnChangeTheme{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.setTheme("Dirty Mill");
				vController.getTheme().playSound(Sounds.menue);
			}
		}
//	}
}
