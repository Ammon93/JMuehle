package de.dhbw.muehle.gui.viewactions;

import java.awt.event.ActionEvent;

import de.dhbw.muehle.model.theme.Sound.Sounds;

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
		
		public class btnWoodenMill extends ABtnWoodenMill{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.setTheme("Wooden Mill");
				vController.getTheme().playSound(Sounds.menue);
			}
		}
		
		public class btn8bitMill extends ABtn8bitMill{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.setTheme("8bit Mill");
				vController.getTheme().playSound(Sounds.menue);
			}
		}
		
		public class btnDirtyMill extends ABtnDirtyMill{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.setTheme("Dirty Mill");
				vController.getTheme().playSound(Sounds.menue);
			}
		}
//	}
}
