package de.dhbw.muehle.gui;

/**
 * Diese Klasse dient als Schnittstelle zwischen dem Core und der View
 */

import de.dhbw.muehle.core.Core;

public class ViewController {

	private View view;
	private ViewActions vActions;
	private Core core;
	
	public ViewController(Core _core){
		view = new View();
		core = _core;
	}
		
	public void initGui(){
		view.initFrame();
		vActions = new ViewActions(view);
	}
		
	}



