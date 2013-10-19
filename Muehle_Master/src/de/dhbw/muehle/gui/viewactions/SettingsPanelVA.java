package de.dhbw.muehle.gui.viewactions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.menus.GamePanel.LblGameStone;
import de.dhbw.muehle.model.theme.Sound.Sounds;

public class SettingsPanelVA {
	
	private ViewController vController;
	
	
	public SettingsPanelVA(ViewController vController) {
		this.vController = vController;
	}
	
	/**
	 * ActionListener
	 */
//	{
		//btnBack
		public class btnBack implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.displayMainMenu();
			}
		}
		
		public class btnWoodenMill implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.setTheme("Wooden Mill");
				vController.getTheme().playSound(Sounds.menue);
			}
		}
		
		public class btn8bitMill implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.setTheme("8bit Mill");
				vController.getTheme().playSound(Sounds.menue);
			}
		}
		
		public class btnDirtyMill implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.setTheme("Dirty Mill");
				vController.getTheme().playSound(Sounds.menue);
			}
		}
//	}
}
