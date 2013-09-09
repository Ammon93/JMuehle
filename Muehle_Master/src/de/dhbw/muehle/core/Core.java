package de.dhbw.muehle.core;

import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.model.Model;

public class Core {

	ViewController vController;
	Model model;
	
	public Core(){
		vController = new ViewController(this);
		model = new Model();
		}

	public void init(){
		vController.init();
	}
}


