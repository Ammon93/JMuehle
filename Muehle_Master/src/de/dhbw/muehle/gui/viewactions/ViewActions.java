package de.dhbw.muehle.gui.viewactions;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingConstants;

import de.dhbw.muehle.gui.ViewController;

/**
 * Diese Klasse dient als Oberklassen für alle ViewActions der einzelnen Panels.
 * 
 * @author Ammon
 */
public class ViewActions{
	
	protected static ViewController vController;	
	
	private ViewVA viewVA;
	private AMenuVA aMenuVA;
	private GamePanelVA gamePanelVA;
	private MainMenuVA mainMenuVA;
	private SettingsPanelVA settingsPanelVA;
	
	private boolean dialogShown,
					canceled;
	
	
	/**
	 * Dummy Konstruktor
	 */
	public ViewActions(){}
	
	/**
	 * Konstruktor
	 * 
	 * @param vController
	 */
	public ViewActions(ViewController vController) {
		ViewActions.vController = vController;
		
		viewVA = new ViewVA();
		aMenuVA = new AMenuVA();
		gamePanelVA = new GamePanelVA();
		mainMenuVA = new MainMenuVA();
		settingsPanelVA = new SettingsPanelVA();
	}
	
	
	
	/**
	 * Setzt einen {@link Boolean}, der anzeigt, ob ein Dialog gerade angezeigt wird.
	 * 
	 * @param dialogShown
	 */
	public void setDialogShown(boolean dialogShown){
		this.dialogShown = dialogShown;
	}
	
	/**
	 * Gibt an, ob ein Dialog gerade angezeigt wird.
	 * 
	 * @return {@link Boolean}
	 */
	public boolean isDialogShown(){
		return dialogShown;
	}
	
	
	/**
	 * Setzt einen {@link Boolean}, der angibt, ob auf einem Dialog "Abbrechen" gewählt wurde.
	 * 
	 * @param canceled
	 */
	public void setCanceled(boolean canceled){
		this.canceled = canceled;
	}
	
	/**
	 * Gibt an, ob auf einem Dialog "Abbrechen" gewählt wurde.
	 * 
	 * @return {@link Boolean}
	 */
	public boolean isCanceled(){
		return canceled;
	}
	
	
	
	/**
	 * @return the viewVA
	 */
	public ViewVA getViewVA() {
		return viewVA;
	}

	/**
	 * @param viewVA the viewVA to set
	 */
	public void setViewVA(ViewVA viewVA) {
		this.viewVA = viewVA;
	}

	/**
	 * @return the aMenuVA
	 */
	public AMenuVA getaMenuVA() {
		return aMenuVA;
	}

	/**
	 * @param aMenuVA the aMenuVA to set
	 */
	public void setaMenuVA(AMenuVA aMenuVA) {
		this.aMenuVA = aMenuVA;
	}

	/**
	 * @return the gamePanelVA
	 */
	public GamePanelVA getGamePanelVA() {
		return gamePanelVA;
	}

	/**
	 * @param gamePanelVA the gamePanelVA to set
	 */
	public void setGamePanelVA(GamePanelVA gamePanelVA) {
		this.gamePanelVA = gamePanelVA;
	}

	/**
	 * @return the mainMenuVA
	 */
	public MainMenuVA getMainMenuVA() {
		return mainMenuVA;
	}

	/**
	 * @param mainMenuVA the mainMenuVA to set
	 */
	public void setMainMenuVA(MainMenuVA mainMenuVA) {
		this.mainMenuVA = mainMenuVA;
	}

	/**
	 * @return the settingsPanelVA
	 */
	public SettingsPanelVA getSettingsPanelVA() {
		return settingsPanelVA;
	}

	/**
	 * @param settingsPanelVA the settingsPanelVA to set
	 */
	public void setSettingsPanelVA(SettingsPanelVA settingsPanelVA) {
		this.settingsPanelVA = settingsPanelVA;
	}
	
	



	/**
	 * Allgemein
	 */
	public abstract class ADialogBtnOK implements ActionListener{};
	
	public abstract class ADialogBtnAbbrechen implements ActionListener{};
	
	
	
	
	/**
	 * GamePanel
	 */
	public abstract class ALblGameStoneMouse implements MouseListener{};
	
	public abstract class AInfoFieldBtnBack implements ActionListener{};
	
	public abstract class AInfoFieldBtnNeustart implements ActionListener{};
	
	public abstract class AWinLoseBtnBack implements ActionListener{};
	
	public abstract class AWinLoseBtnNeustart implements ActionListener{};
	
	public abstract class AAdvancedTextFieldAdapter implements FocusListener, KeyListener{};
	
	
	
	/**
	 * MainMenu
	 */
	public abstract class ABtnPvE implements ActionListener{};
	
	public abstract class ABtnPvP implements ActionListener{};
	
	public abstract class ABtnSettings implements ActionListener{};
	
	public abstract class ABtnQuit implements ActionListener{};
	
	public abstract class ABtnHilfe implements ActionListener{};
	
	
	
	/**
	 * AMenu
	 */
	public abstract class AAMenuResizeListener implements HierarchyBoundsListener{};
	
	
	
	/**
	 * SettingsPanel
	 */
	public abstract class ABtnBack implements ActionListener{};
	
	public abstract class ABtnChangeTheme implements ActionListener{};
	
	
	
	/**
	 * View
	 */
	public abstract class ABtnClose implements ActionListener{};
	
	public abstract class ABtnMax implements ActionListener{};
	
	public abstract class ABtnMin implements ActionListener{};
	
	public abstract class AViewResizeAdapter implements MouseListener, MouseMotionListener, SwingConstants{};
	
	public abstract class AViewMoveAdapter implements MouseListener, MouseMotionListener{};
}