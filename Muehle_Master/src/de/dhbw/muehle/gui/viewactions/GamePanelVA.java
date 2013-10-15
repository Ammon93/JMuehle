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
			if (vController.getCore().getSpielphase() == 1) {
				if (vController.getCore().isWeissDran() == true
						&& vController.getCore().isMuehle_weiss() == false) {
					vController.weisseSteine_setzen((LblGameStone) e
							.getComponent());
					System.out.println(vController.getCore().isWeissDran());
					System.out.println(vController.getCore().isSchwarzDran());
					System.out.println(vController.getCore().isMuehle_weiss());
					System.out
							.println(vController.getCore().isMuehle_schwarz());
				

				}

				else if (vController.getCore().isMuehle_weiss() == true
						&& vController.getCore().isWeissDran() == true) {

					vController.entferneSteinSchwarz((LblGameStone) e
							.getComponent());
					System.out.println(vController.getCore().isWeissDran());
					System.out.println(vController.getCore().isSchwarzDran());
					System.out.println(vController.getCore().isMuehle_weiss());
					System.out
							.println(vController.getCore().isMuehle_schwarz());
				

				} else if (vController.getCore().isSchwarzDran() == true
						&& vController.getCore().isMuehle_schwarz() == false) {
					vController.schwarzeSteine_setzen((LblGameStone) e
							.getComponent());
					System.out.println(vController.getCore().isWeissDran());
					System.out.println(vController.getCore().isSchwarzDran());
					System.out.println(vController.getCore().isMuehle_weiss());
					System.out
							.println(vController.getCore().isMuehle_schwarz());
				
				}

				else if (vController.getCore().isMuehle_schwarz() == true
						&& vController.getCore().isSchwarzDran() == true) {

					vController.entferneSteinWeiss((LblGameStone) e
							.getComponent());
					System.out.println(vController.getCore().isWeissDran());
					System.out.println(vController.getCore().isSchwarzDran());
					System.out.println(vController.getCore().isMuehle_weiss());
					System.out
							.println(vController.getCore().isMuehle_schwarz());
				

				}
			} else if (vController.getCore().getSpielphase() == 2) {

				if (vController.getCore().isWeissDran() == true
						&& vController.getCore().isWeisserStein_angeklickt() == false) {
					vController.getCore().setAngeklickterStein(
							(LblGameStone) e.getComponent());
					vController.getCore().angeklicktSetzen_weiss(
							(LblGameStone) e.getComponent());
//					vController.getCore().setWeisserStein_angeklickt(true);
//					vController.getCore().setWeissDran(true);
					System.out
							.println("Weisser Stein angeklickt"
									+ vController.getCore()
											.isWeisserStein_angeklickt());
				}

				else if (vController.getCore().isSchwarzDran() == true
						&& vController.getCore().isSchwarzerStein_angeklickt() == false) {
					vController.getCore().setAngeklickterStein(
							(LblGameStone) e.getComponent());
					vController.getCore().angeklicktSetzen_schwarz(
							(LblGameStone) e.getComponent());
					vController.getCore().setSchwarzerStein_angeklickt(true);
					vController.getCore().setSchwarzDran(true);
					System.out.println("Schwarzer Stein angeklickt"
							+ vController.getCore()
									.isSchwarzerStein_angeklickt());
				}

				else if (vController.getCore().isWeissDran() == true
						&& vController.getCore().isWeisserStein_angeklickt() == true) {
					System.out.println("Jetzt kannst du ziehen Weiss");
					vController.getCore().zieheSteinWeiss(
							(LblGameStone) e.getComponent());
				}

				else if (vController.getCore().isSchwarzDran() == true
						&& vController.getCore().isSchwarzerStein_angeklickt() == true) {
					System.out.println("Jetzt kannst du ziehen Schwarz");
					vController.getCore().zieheSteinSchwarz(
							(LblGameStone) e.getComponent());
				}
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
