package de.dhbw.muehle.gui.viewactions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import de.dhbw.muehle.gui.ViewController;

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
				mouseClickedLblGameStone(e);
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
		
		


	/**
	 * Methoden, die von den einzelnen Listenern aufgerufen werden
	 */
	//ActionListener
	private void mouseClickedLblGameStone(MouseEvent e) {
		
	}
}
