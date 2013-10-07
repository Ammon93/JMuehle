package de.dhbw.muehle.gui.viewactions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.menus.GamePanel.LblGameStone;

public class GamePanelVA {
	
	ViewController vController;
	
	
	public GamePanelVA(ViewController vController) {
		this.vController = vController;
	}
	
	/**
	 * MouseListener
	 */
//	{
		//gameStone[][][]
		public class lblGameStoneMouse implements MouseListener{
			@Override
			public void mouseClicked(MouseEvent e) {
				vController.stoneClicked((LblGameStone) e.getComponent());
				
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		}
//	}
}
