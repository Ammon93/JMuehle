package de.dhbw.muehle.gui.viewactions;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import de.dhbw.muehle.ESpielsteinFarbe;
import de.dhbw.muehle.gui.DialogBackgroundPanel;
import de.dhbw.muehle.gui.menus.GamePanel.InputDialog;
import de.dhbw.muehle.gui.menus.GamePanel.LblGameStone;
import de.dhbw.muehle.strategy.StrategieException;

/**
 * Hier werden alle Listener für das {@link GamePanel} implementiert und
 * ausformuliert.
 * 
 * @author Ammon
 */
public class GamePanelVA extends ViewActions {

	private GamePanelVA vActions;

//	private boolean PvE;
	private ESpielsteinFarbe pcFarbe;

	/**
	 * Konstruktor
	 */
	public GamePanelVA() {
		vActions = this;
	}

	
	

	/**
	 * MouseListener
	 * @author Kreistschen Diese Mouselistener steuert den kompletten
	 *         Spielablauf Je nach gesetzten booleans werden jeweilige
	 *         Funktionen ausgeführt
	 */

	public class lblGameStoneMouse extends ALblGameStoneMouse {
		@Override
		// Wird aufgerufen falls einmal geklickt wird
		public void mouseClicked(MouseEvent e) {
			
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

	// lblInputDialogSpielstein
	public class LblInputDialogSpielsteinMouse extends ALblGameStoneMouse {
		@Override
		public void mouseClicked(MouseEvent e) {
			LblGameStone stein = ((LblGameStone) e.getSource());

			if (stein.getFarbe().equals(ESpielsteinFarbe.WEISS))
				stein.setImage("schwarz");
			else if (stein.getFarbe().equals(ESpielsteinFarbe.SCHWARZ))
				stein.setImage("weiss");
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

	/**
	 * ActionListener
	 */
	// {
	// infoField
	public class infoFieldBtnHilfe extends ABtnHilfe {
		@Override
		public void actionPerformed(ActionEvent e) {
			vController.openDialog(DialogBackgroundPanel.OPEN,
					DialogBackgroundPanel.SPIELREGELN, vController.getView()
							.getActualPanel());
		}
	}

	public class infoFieldBtnBack extends AInfoFieldBtnBack {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (vController.getView().getGamePanel().anyChangesMade())
				vController.openDialog(DialogBackgroundPanel.OPEN,
						DialogBackgroundPanel.DIALOG, "Wollen Sie wirklich?",
						vController.getView().getActualPanel());

			new Thread() {
				public void run() {
					synchronized (vActions) {
						while (vActions.isDialogShown()
								&& !vActions.isCanceled()) {
							try {
								vActions.wait();
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
					}

					if (!vActions.isCanceled())
						vController.displayMainMenu();
				}
			}.start();
		}
	}

	public class infoFieldBtnNeustart extends AInfoFieldBtnNeustart {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (vController.getView().getGamePanel().anyChangesMade())
				vController.openDialog(DialogBackgroundPanel.OPEN,
						DialogBackgroundPanel.DIALOG, "Wollen Sie wirklich?",
						vController.getView().getActualPanel());

			new Thread() {
				public void run() {
					synchronized (vActions) {
						while (vActions.isDialogShown()
								&& !vActions.isCanceled()) {
							try {
								vActions.wait();
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
					}

					if (!vActions.isCanceled()) {
						vController.getCore().resetAll();

						if(core.isPvE())
							core.startPvE();
						else
							core.startPvP();
					}
				}
			}.start();
		}
	}

	// winLose
	public class winLoseBtnBack extends AWinLoseBtnBack {
		@Override
		public void actionPerformed(ActionEvent e) {
			vController.getCore().resetAll();
			vController.displayMainMenu();
		}
	}

	public class winLoseBtnNeustart extends AWinLoseBtnNeustart {
		@Override
		public void actionPerformed(ActionEvent e) {
			vController.getCore().resetAll();

			if(core.isPvE())
				core.startPvE();
			else
				core.startPvP();
		}
	}

	// dialog
	public class dialogBtnOK extends ADialogBtnOK {
		@Override
		public void actionPerformed(ActionEvent e) {
			vController.openDialog(DialogBackgroundPanel.CLOSE,
					DialogBackgroundPanel.DIALOG, vController.getView()
							.getActualPanel());
		}
	}

	public class dialogBtnAbbrechen extends ADialogBtnAbbrechen {
		@Override
		public void actionPerformed(ActionEvent e) {
			vController.openDialog(DialogBackgroundPanel.HIDE,
					DialogBackgroundPanel.DIALOG, vController.getView()
							.getActualPanel());
		}
	}

	// inputDialog
	public class inputDialogBtnOK extends ADialogBtnOK {
		@Override
		public void actionPerformed(ActionEvent e) {
			vController.openDialog(DialogBackgroundPanel.CLOSE,
					DialogBackgroundPanel.INPUTDIALOG, vController.getView()
							.getActualPanel());
			vController.getView().getGamePanel().updatePlayer();

			if(core.isPvE()) {
				InputDialog inDialog = vController.getView().getGamePanel().getInputDialog();

				if (inDialog.getSpielerFarbe().equals(ESpielsteinFarbe.SCHWARZ)) {
					pcFarbe = ESpielsteinFarbe.WEISS;

					inDialog.setSpielerName2(inDialog.getSpielerName1());
					inDialog.setSpielerName1("PC");

					// der Computer beginnt
//					PC();
				} else {
					inDialog.setSpielerName2("PC");
					pcFarbe = ESpielsteinFarbe.SCHWARZ;
				}
			}
		}
	}

	// }

	/**
	 * AdvancedTextFieldAdapter
	 */
	// {
	public class advancedTextFieldAdapter extends AAdvancedTextFieldAdapter {

		private String spieler;
		private String lastText;

		public advancedTextFieldAdapter(String dafaultSpielerName) {
			spieler = dafaultSpielerName;
		}

		@Override
		public void focusGained(FocusEvent e) {
			String text = ((JTextField) e.getSource()).getText();

			if (text.equals("Spieler 1") || text.equals("Spieler 2")) {
				((JTextField) e.getSource()).setText("");
				((JTextField) e.getSource()).setForeground(Color.BLACK);
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			String text = ((JTextField) e.getSource()).getText();

			if (text.equals("Spieler 1") || text.equals("Spieler 2")
					|| text.isEmpty()) {
				((JTextField) e.getSource()).setText(spieler);
				((JTextField) e.getSource()).setForeground(Color.GRAY);
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				focusLost(new FocusEvent((Component) e.getSource(),
						FocusEvent.FOCUS_LOST));

				new inputDialogBtnOK().actionPerformed(new ActionEvent(this,
						ActionEvent.ACTION_PERFORMED, ""));
			}

			if (lastText == null)
				lastText = ((JTextField) e.getSource()).getText();

			if (((JTextField) e.getSource()).getText().length() > 13)
				((JTextField) e.getSource()).setText(lastText);
			else
				lastText = ((JTextField) e.getSource()).getText();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (((JTextField) e.getSource()).getText().length() > 13)
				((JTextField) e.getSource()).setText(lastText);
		}
	}
	// }
}