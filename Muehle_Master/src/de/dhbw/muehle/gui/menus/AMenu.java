package de.dhbw.muehle.gui.menus;

import java.awt.Dimension;

import javax.swing.JPanel;

import de.dhbw.muehle.gui.View;
import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.viewactions.AMenuVA;
import de.dhbw.muehle.gui.viewactions.ViewActions;

public abstract class AMenu extends JPanel{
	
	public final Dimension Size;
	
	protected View view;
	protected static ViewActions vActions;
	
	
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
	
	
	public Dimension getOriginalSize(){
		return Size;
	}
}