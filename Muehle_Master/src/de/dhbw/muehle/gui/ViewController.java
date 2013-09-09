package de.dhbw.muehle.gui;

import de.dhbw.muehle.core.Core;

public class ViewController {

	private View view;
	private ViewActions vActions;
	private Core core;
	
	public ViewController(Core _core){
		view = new View();
		core = _core;
	}
		
	public void init(){
		view.init();
		vActions = new ViewActions(view);
	}
		
	}



