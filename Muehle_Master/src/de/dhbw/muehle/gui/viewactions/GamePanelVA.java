package de.dhbw.muehle.gui.viewactions;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import de.dhbw.muehle.gui.DialogBackgroundPanel;
import de.dhbw.muehle.gui.menus.GamePanel.LblGameStone;

public class GamePanelVA extends ViewActions{
	
	private GamePanelVA vActions;
	

	public GamePanelVA() {
		vActions = this;
	}
	

	/**
	 * MouseListener
	 */
	// {
	// gameStone[][][]

		/**
		 * 
		 * @author Kreistschen Diese Mouselistener steuert den kompletten
		 *         Spielablauf Je nach gesetzten booleans werden jeweilige
		 *         Funktionen ausgef�hrt
		 */
		
		public class lblGameStoneMouse extends ALblGameStoneMouse {
			@Override
			// Wird aufgerufen falls einmal geklickt wird
			public void mouseClicked(MouseEvent e) {
	
				/**
				 * Hier wird �berpr�ft in welcher Spielphase sich das Spiel befindet
				 * Spielphase 1 == Steine setzten Spielphase 2 == Steine ziehen
				 * Spielphase 3 == Springen
				 */
	
				// Hier wird �berpr�ft ob das Spiel in der Steine setzen Phase (1)
				// ist
				if (vController.getCore().getSpielphase() == 1) {
	
					System.out.println("Spielphase 1");
					// Falls Weis am Zug ist und Weiss keine Muehle hat wird diese
					// Code ausgef�hrt
					if (vController.getCore().isWeissDran() == true
							&& vController.getCore().isMuehle_weiss() == false) {
	
						// Methode zum setzen weisser Steine
						vController.getCore().weisseSteine_setzen((LblGameStone) e
								.getComponent());
	
						System.out.println("Weiss hat einen Stein gesetzt");
						System.out.println("Ist Weiss dran "
								+ vController.getCore().isWeissDran());
						System.out.println("Ist Schwarz dran "
								+ vController.getCore().isSchwarzDran());
						System.out.println("Hat Weiss eine Muehle "
								+ vController.getCore().isMuehle_weiss());
						System.out.println("Hat Schwarz eine Muehle "
								+ vController.getCore().isMuehle_schwarz());
	
					}
	
					// Falls Schwarz am Zug ist und Weiss keine Muehle hat wird
					// diese Code ausgef�hrt
					else if (vController.getCore().isSchwarzDran() == true
							&& vController.getCore().isMuehle_schwarz() == false) {
	
						// Methode zum Schwarze Steine setzen
						vController.getCore().schwarzeSteine_setzen((LblGameStone) e
								.getComponent());
	
						System.out.println("Schwarz hat einen Stein gesetzt");
						System.out.println("Ist Weiss dran "
								+ vController.getCore().isWeissDran());
						System.out.println("Ist Schwarz dran "
								+ vController.getCore().isSchwarzDran());
						System.out.println("Hat Weiss eine Muehle "
								+ vController.getCore().isMuehle_weiss());
						System.out.println("Hat Schwarz eine Muehle "
								+ vController.getCore().isMuehle_schwarz());
	
					}
	
					// Falls Weiss am Zug ist und Weiss eine Muehle hat wird diese
					// Code ausgef�hrt
					else if (vController.getCore().isMuehle_weiss() == true
							&& vController.getCore().isWeissDran() == true) {
	
						// Methode zum entfernen eines schwarzen Steines
						vController.getCore().entferneSteinSchwarz((LblGameStone) e
								.getComponent());
	
						System.out
								.println("Weiss hat einen Schwarzen Stein entfernt");
						System.out.println("Ist Weiss dran "
								+ vController.getCore().isWeissDran());
						System.out.println("Ist Schwarz dran "
								+ vController.getCore().isSchwarzDran());
						System.out.println("Hat Weiss eine Muehle "
								+ vController.getCore().isMuehle_weiss());
						System.out.println("Hat Schwarz eine Muehle "
								+ vController.getCore().isMuehle_schwarz());
					}
	
					// Falls Schwarz am Zug ist und Schwarz eine Muehle hat wird
					// diese Code ausgef�hrt
					else if (vController.getCore().isMuehle_schwarz() == true
							&& vController.getCore().isSchwarzDran() == true) {
	
						// Methode zum entfernen eines weissen Steines
						vController.getCore().entferneSteinWeiss((LblGameStone) e
								.getComponent());
	
						System.out
								.println("Schwarz hat einen Weissen Stein entfernt");
						System.out.println("Ist Weiss dran "
								+ vController.getCore().isWeissDran());
						System.out.println("Ist Schwarz dran "
								+ vController.getCore().isSchwarzDran());
						System.out.println("Hat Weiss eine Muehle "
								+ vController.getCore().isMuehle_weiss());
						System.out.println("Hat Schwarz eine Muehle "
								+ vController.getCore().isMuehle_schwarz());
	
					}
	
					// Hier wird �berpr�ft ob das Spiel in der Steine ziehen Phase
					// (2) ist
				} else if (vController.getCore().getSpielphase() == 2) {
	
					System.out.println("Spielphase 2");
					// Falls Weis am Zug ist, noch keinen Weissen Stein zum ziehen
					// angeklickt hat und keine Muehle geschlossen hat
					// wird dieser Code ausgef�hrt
	
					if (vController.getCore().isWeissDran() == true
							&& vController.getCore().isWeisserStein_angeklickt() == false
							&& vController.getCore().isMuehle_weiss() == false) {
	
						// Methoden zum aktivsetzen eines Steines
						vController.getCore().setAngeklickterStein(
								(LblGameStone) e.getComponent());
	
						vController.getCore().angeklicktSetzen_weiss(
								(LblGameStone) e.getComponent());
	
						System.out.println("Weiss hat einen Stein aktiv markiert");
						System.out.println("Ist Weiss dran "
								+ vController.getCore().isWeissDran());
						System.out.println("Ist Schwarz dran "
								+ vController.getCore().isSchwarzDran());
						System.out.println("Hat Weiss eine Muehle "
								+ vController.getCore().isMuehle_weiss());
						System.out.println("Hat Schwarz eine Muehle "
								+ vController.getCore().isMuehle_schwarz());
						System.out
								.println("ist ein Weisser Stein angeklickt "
										+ vController.getCore()
												.isWeisserStein_angeklickt());
					}
	
					// Falls Schwarz am Zug ist, noch keinen Schwarzen Stein zum
					// ziehen angeklickt hat und keine Muehle geschlossen hat
					// wird dieser Code ausgef�hrt
	
					else if (vController.getCore().isSchwarzDran() == true
							&& vController.getCore().isSchwarzerStein_angeklickt() == false
							&& vController.getCore().isMuehle_schwarz() == false) {
	
						// Methoden zum aktivsetzen eines Steines
						vController.getCore().setAngeklickterStein(
								(LblGameStone) e.getComponent());
	
						vController.getCore().angeklicktSetzen_schwarz(
								(LblGameStone) e.getComponent());
	
						System.out
								.println("Schwarz hat einen Stein aktiv markiert");
						System.out.println("Ist Weiss dran "
								+ vController.getCore().isWeissDran());
						System.out.println("Ist Schwarz dran "
								+ vController.getCore().isSchwarzDran());
						System.out.println("Hat Weiss eine Muehle "
								+ vController.getCore().isMuehle_weiss());
						System.out.println("Hat Schwarz eine Muehle "
								+ vController.getCore().isMuehle_schwarz());
						System.out.println("Schwarzer Stein angeklickt"
								+ vController.getCore()
										.isSchwarzerStein_angeklickt());
	
					}
	
					// Falls Weiss am Zug ist, einen weissen Stein zum ziehen
					// angeklickt hat und keine Muehle geschlossen hat
					// wird dieser Code ausgef�hrt
					else if (vController.getCore().isWeissDran() == true
							&& vController.getCore().isWeisserStein_angeklickt() == true
							&& vController.getCore().isMuehle_weiss() == false) {
	
						// Methode zum ziehen eines Weissen Steines
						vController.getCore().zieheSteinWeiss(
								(LblGameStone) e.getComponent());
	
						System.out.println("Weiss hat einen Stein bewegt");
						System.out.println("Ist Weiss dran "
								+ vController.getCore().isWeissDran());
						System.out.println("Ist Schwarz dran "
								+ vController.getCore().isSchwarzDran());
						System.out.println("Hat Weiss eine Muehle "
								+ vController.getCore().isMuehle_weiss());
						System.out.println("Hat Schwarz eine Muehle "
								+ vController.getCore().isMuehle_schwarz());
	
					}
	
					// Falls Schwarz am Zug ist, einen schwarzen Stein zum ziehen
					// angeklickt hat und keine Muehle geschlossen hat
					// wird dieser Code ausgef�hrt
					else if (vController.getCore().isSchwarzDran() == true
							&& vController.getCore().isSchwarzerStein_angeklickt() == true
							&& vController.getCore().isMuehle_schwarz() == false) {
	
						// Methode zum ziehen eines Schwarzen Steines
						vController.getCore().zieheSteinSchwarz(
								(LblGameStone) e.getComponent());
	
						System.out.println("Schwarz hat einen Stein bewegt");
						System.out.println("Ist Weiss dran "
								+ vController.getCore().isWeissDran());
						System.out.println("Ist Schwarz dran "
								+ vController.getCore().isSchwarzDran());
						System.out.println("Hat Weiss eine Muehle "
								+ vController.getCore().isMuehle_weiss());
						System.out.println("Hat Schwarz eine Muehle "
								+ vController.getCore().isMuehle_schwarz());
					}
	
					// Falls Weiss am Zug ist, einen weissen Stein zum ziehen
					// angeklickt hat und eine Muehle geschlossen hat
					// wird dieser Code ausgef�hrt
	
					else if (vController.getCore().isMuehle_weiss() == true
							&& vController.getCore().isWeissDran() == true) {
	
						// Methode zum entfernen eines schwarzen Steines
						vController.getCore().entferneSteinSchwarz((LblGameStone) e
								.getComponent());
	
						System.out.println("Ist Weiss dran "
								+ vController.getCore().isWeissDran());
						System.out.println("Ist Schwarz dran "
								+ vController.getCore().isSchwarzDran());
						System.out.println("Hat Weiss eine Muehle "
								+ vController.getCore().isMuehle_weiss());
						System.out.println("Hat Schwarz eine Muehle "
								+ vController.getCore().isMuehle_schwarz());
	
					}
	
					// Falls Schwarz am Zug ist, einen schwarzen Stein zum ziehen
					// angeklickt hat und eine Muehle geschlossen hat
					// wird dieser Code ausgef�hrt
	
					else if (vController.getCore().isMuehle_schwarz() == true
							&& vController.getCore().isSchwarzDran() == true) {
	
						// Methode zum entfernen eines weissen Steines
						vController.getCore().entferneSteinWeiss((LblGameStone) e
								.getComponent());
	
						System.out.println("Ist Weiss dran "
								+ vController.getCore().isWeissDran());
						System.out.println("Ist Schwarz dran "
								+ vController.getCore().isSchwarzDran());
						System.out.println("Hat Weiss eine Muehle "
								+ vController.getCore().isMuehle_weiss());
						System.out.println("Hat Schwarz eine Muehle "
								+ vController.getCore().isMuehle_schwarz());
	
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
	
	
		

	/**
	 * ActionListener
	 */
	// {
	// infoField
		public class infoFieldBtnHilfe extends ABtnHilfe{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.openDialog(DialogBackgroundPanel.OPEN, DialogBackgroundPanel.SPIELREGELN, vController.getView().getActualPanel());
			}
		}
		
		public class infoFieldBtnBack extends AInfoFieldBtnBack{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(vController.getView().getGamePanel().anyChangesMade())
					vController.openDialog(DialogBackgroundPanel.OPEN, DialogBackgroundPanel.DIALOG, "Wollen Sie wirklich?", vController.getView().getActualPanel());
				
				new Thread(){
					public void run(){
					synchronized (vActions) {
						while(vActions.isDialogShown() && !vActions.isCanceled()){
			                try {
								vActions.wait();
							} catch (InterruptedException e1) {e1.printStackTrace();}
			            }
					}
					
					if(!vActions.isCanceled())
						vController.displayMainMenu();
				}}.start();
			}
		}
		
		public class infoFieldBtnNeustart extends AInfoFieldBtnNeustart{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(vController.getView().getGamePanel().anyChangesMade())
					vController.openDialog(DialogBackgroundPanel.OPEN, DialogBackgroundPanel.DIALOG, "Wollen Sie wirklich?", vController.getView().getActualPanel());
				
				new Thread(){
					public void run(){
					synchronized (vActions) {
						while(vActions.isDialogShown() && !vActions.isCanceled()){
			                try {
								vActions.wait();
							} catch (InterruptedException e1) {e1.printStackTrace();}
			            }
					}
					
					if(!vActions.isCanceled()){
						vController.getCore().resetAll();
						vController.startPvP();
					}
				}}.start();
			}
		}
		
	// winLose
		public class winLoseBtnBack extends AWinLoseBtnBack{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.getCore().resetAll();
				vController.displayMainMenu();
			}
		}
		
		public class winLoseBtnNeustart extends AWinLoseBtnNeustart{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.getCore().resetAll();
				vController.startPvP();
			}
		}
		
	// dialog
		public class dialogBtnOK extends ADialogBtnOK{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.openDialog(DialogBackgroundPanel.CLOSE, DialogBackgroundPanel.DIALOG, vController.getView().getActualPanel());
			}
		}
		
		public class dialogBtnAbbrechen extends ADialogBtnAbbrechen{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.openDialog(DialogBackgroundPanel.HIDE, DialogBackgroundPanel.DIALOG, vController.getView().getActualPanel());
			}
		}
		
	// inputDialog
		public class inputDialogBtnOK extends ADialogBtnOK{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.openDialog(DialogBackgroundPanel.CLOSE, DialogBackgroundPanel.INPUTDIALOG, vController.getView().getActualPanel());
				vController.getView().getGamePanel().changePlayer();
			}
		}
	// }
		
		
		
	/**
	 * AdvancedTextFieldAdapter
	 */
//	{
		public class advancedTextFieldAdapter extends AAdvancedTextFieldAdapter{
			
			private String spieler;
			private String lastText;
			
			
			public advancedTextFieldAdapter(String dafaultSpielerName) {
				spieler = dafaultSpielerName;
			}
			
			
			@Override
			public void focusGained(FocusEvent e) {
				String text = ((JTextField) e.getSource()).getText();
				
		    	if(text.equals("Spieler 1")
		    			|| text.equals("Spieler 2")){
		    		((JTextField) e.getSource()).setText("");
		    		((JTextField) e.getSource()).setForeground(Color.BLACK);
		    	}
		    }
			
			@Override
		    public void focusLost(FocusEvent e) {
				String text = ((JTextField) e.getSource()).getText();
				
		    	if(text.equals("Spieler 1")
		    			|| text.equals("Spieler 2")
		    			|| text.isEmpty()){
		    		((JTextField) e.getSource()).setText(spieler);
		    		((JTextField) e.getSource()).setForeground(Color.GRAY);
		    	}
			}
	
			@Override
			public void keyTyped(KeyEvent e) {}
	
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					focusLost(new FocusEvent((Component) e.getSource(), FocusEvent.FOCUS_LOST));
					
					new inputDialogBtnOK().actionPerformed(
							new ActionEvent(this,
							ActionEvent.ACTION_PERFORMED,""));
				}
				
				if(lastText == null)
					lastText = ((JTextField) e.getSource()).getText();
				
				if(((JTextField) e.getSource()).getText().length() > 13)
					((JTextField) e.getSource()).setText(lastText);
				else
					lastText = ((JTextField) e.getSource()).getText();
			}
	
			@Override
			public void keyReleased(KeyEvent e) {
				if(((JTextField) e.getSource()).getText().length() > 13)
					((JTextField) e.getSource()).setText(lastText);
			}
		}
//	}
}