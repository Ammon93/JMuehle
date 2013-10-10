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
	// {
	// gameStone[][][]
	public class lblGameStoneMouse implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (vController.getCore().isWeissDran() == true) {
				vController
						.weisseSteine_setzen((LblGameStone) e.getComponent());
				System.out.println(vController.getCore().isWeissDran());
				System.out.println(vController.getCore().isSchwarzDran());
				System.out.println(vController.getCore().isMuehle_weiss());
				System.out.println(vController.getCore().isMuehle_schwarz());
				
			}
			
			else if (vController.getCore().isMuehle_weiss() == true) {
				
				vController.entferneStein((LblGameStone) e.getComponent());
				vController.getCore().setMuehle_weiss(false);
				System.out.println(vController.getCore().isWeissDran());
				System.out.println(vController.getCore().isSchwarzDran());
				System.out.println(vController.getCore().isMuehle_weiss());
				System.out.println(vController.getCore().isMuehle_schwarz());
			
		}
			else if (vController.getCore().isSchwarzDran() == true) {
				vController
						.schwarzeSteine_setzen((LblGameStone) e.getComponent());
				System.out.println(vController.getCore().isWeissDran());
				System.out.println(vController.getCore().isSchwarzDran());
				System.out.println(vController.getCore().isMuehle_weiss());
				System.out.println(vController.getCore().isMuehle_schwarz());
		}
			
			else if (vController.getCore().isMuehle_schwarz() == true) {
				
				vController.entferneStein((LblGameStone) e.getComponent());
				vController.getCore().setMuehle_schwarz(false);
				System.out.println(vController.getCore().isWeissDran());
				System.out.println(vController.getCore().isSchwarzDran());
				System.out.println(vController.getCore().isMuehle_weiss());
				System.out.println(vController.getCore().isMuehle_schwarz());
			
		}
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	// }
}
