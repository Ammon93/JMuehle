package de.dhbw.muehle.gui.viewactions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.menus.GamePanel.LblGameStone;

public class GamePanelVA {

	private ViewController vController;

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
			if (vController.getCore().isWeissDran() == true && vController.getCore().isMuehle_weiss() == false) {
				vController
						.weisseSteine_setzen((LblGameStone) e.getComponent());
				System.out.println(vController.getCore().isWeissDran());
				System.out.println(vController.getCore().isSchwarzDran());
				System.out.println(vController.getCore().isMuehle_weiss());
				System.out.println(vController.getCore().isMuehle_schwarz());
				
			}
			
			else if (vController.getCore().isMuehle_weiss() == true && vController.getCore().isWeissDran() == true) {
				
				vController.entferneSteinSchwarz((LblGameStone) e.getComponent());
				vController.getCore().setMuehle_weiss(false);
				vController.getCore().setWeissDran(false);
				vController.getCore().setSchwarzDran(true);
				System.out.println(vController.getCore().isWeissDran());
				System.out.println(vController.getCore().isSchwarzDran());
				System.out.println(vController.getCore().isMuehle_weiss());
				System.out.println(vController.getCore().isMuehle_schwarz());
			
		}
			else if (vController.getCore().isSchwarzDran() == true && vController.getCore().isMuehle_schwarz() == false) {
				vController
						.schwarzeSteine_setzen((LblGameStone) e.getComponent());
				System.out.println(vController.getCore().isWeissDran());
				System.out.println(vController.getCore().isSchwarzDran());
				System.out.println(vController.getCore().isMuehle_weiss());
				System.out.println(vController.getCore().isMuehle_schwarz());
		}
			
			else if (vController.getCore().isMuehle_schwarz() == true && vController.getCore().isSchwarzDran() == true) {
				
				vController.entferneSteinWeiss((LblGameStone) e.getComponent());
				vController.getCore().setMuehle_schwarz(false);
				vController.getCore().setSchwarzDran(false);
				vController.getCore().setWeissDran(true);
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
