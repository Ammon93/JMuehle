package de.dhbw.muehle.gui.menus;

import java.awt.Dimension;

import javax.swing.JPanel;

import de.dhbw.muehle.gui.View;
import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.viewactions.AMenuVA;
import de.dhbw.muehle.gui.viewactions.ViewActions;

/**
 * Diese abstrakte Klasse dient als Oberklasse für alle Panels, die im View angezeigt werden
 * 
 * @author Ammon
 */
public abstract class AMenu extends JPanel{
	
	public final Dimension Size;
	
	protected View view;
	protected static ViewActions vActions;
	
	
	/**
	 * Konstruktor
	 * 
	 * @param vController
	 * @param view
	 */
	public AMenu(ViewController vController, View view) {
		this.view = view;
		AMenu.vActions = view.getGlobalVA();
		
		// ViewActions für AMenu holen
		AMenuVA vActions = AMenu.vActions.getaMenuVA();
		
		
		Size = new Dimension(1000, 600);
		
		// Panelgröße festlegen
		setPreferredSize(Size);
		
		addHierarchyBoundsListener(vActions.new resizeListener());
	}
	
	
	/**
	 * Gibt die Originalgröße des Panels zurück.
	 * 
	 * @return {@link Dimension}
	 */
	public Dimension getOriginalSize(){
		return Size;
	}
}