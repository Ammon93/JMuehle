package de.dhbw.muehle.gui.menus;

import java.awt.Dimension;

import javax.swing.JPanel;

import de.dhbw.muehle.gui.View;
import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.viewactions.MenuVA;

public abstract class Menu extends JPanel{
	
	public final Dimension Size = new Dimension(1000, 600);
	
	private View view;
	private MenuVA vActions;
	
	
	public Menu(ViewController vController, View view) {
		this.view = view;
		
		vActions = new MenuVA(vController);
		
		
		// Panelgröße festlegen
		setPreferredSize(Size);
		
		
		addHierarchyBoundsListener(vActions.new reziseListener());
	}
	
	
	public Dimension getOriginalSize(){
		return Size;
	}
}