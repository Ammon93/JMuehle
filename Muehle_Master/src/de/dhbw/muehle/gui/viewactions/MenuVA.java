package de.dhbw.muehle.gui.viewactions;

import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;

import javax.sound.sampled.ReverbType;

import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.menus.Menu;

public class MenuVA {

	private ViewController vController;	
	
	
	public MenuVA(ViewController vController) {
		this.vController = vController;
	}
	

	
	/**
	 * HierarchyBoundsListener
	 */
//	{
		public class reziseListener implements HierarchyBoundsListener{
			@Override
			public void ancestorMoved(HierarchyEvent e) {
			}
	
			@Override
			public void ancestorResized(HierarchyEvent e) {
				vController.resizePanel((Menu) e.getComponent());
			}
		}
//	}
}
