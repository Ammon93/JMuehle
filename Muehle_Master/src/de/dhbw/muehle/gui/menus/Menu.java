package de.dhbw.muehle.gui.menus;

import java.awt.Dimension;

import javax.swing.JPanel;

import de.dhbw.muehle.gui.View;
import de.dhbw.muehle.model.theme.Theme;

public abstract class Menu extends JPanel{
	
	public final Dimension Size = new Dimension(705, 600);
	
	private View view;
	
	
	public Menu(View view) {
		this.view = view;
		
		// Panelgröße festlegen
		setSize(Size);
	}
	
	
	public Dimension getOriginalSize(){
		return Size;
	}
}