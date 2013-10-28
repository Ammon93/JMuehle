package de.dhbw.muehle.gui.viewactions;

import java.awt.event.HierarchyEvent;

import de.dhbw.muehle.gui.menus.AMenu;

public class AMenuVA extends ViewActions{
	
	/**
	 * HierarchyBoundsListener
	 */
//	{
		public class resizeListener extends AAMenuResizeListener{
			@Override
			public void ancestorMoved(HierarchyEvent e) {
			}
	
			@Override
			public void ancestorResized(HierarchyEvent e) {
				vController.resizePanel((AMenu) e.getComponent());
			}
		}
//	}
}