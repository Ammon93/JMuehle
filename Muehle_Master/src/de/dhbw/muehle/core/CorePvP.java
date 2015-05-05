package de.dhbw.muehle.core;

import java.util.ArrayList;

import de.dhbw.muehle.EPositionIndex;
import de.dhbw.muehle.ESpielsteinFarbe;
import de.dhbw.muehle.Position;
import de.dhbw.muehle.gui.menus.GamePanel;
import de.dhbw.muehle.gui.menus.GamePanel.ESpielsteinTyp;
import de.dhbw.muehle.gui.menus.GamePanel.LblGameStone;
import de.dhbw.muehle.model.theme.Sound.Sounds;

/**
 * Diese Klasse ist für das Multiplayergameplay verantwortlich.
 * @author Ammon
 */
public class CorePvP{

	private Core core;
	private GamePanel spielFeld;
	private ArrayList<LblGameStone> gesetzteSteine;
	
	
	/**
	 * Konstruktor
	 * @param core
	 */
	public CorePvP(Core core){
		this.core = core;
		spielFeld = core.getView().getGamePanel();
		gesetzteSteine = new ArrayList<LblGameStone>();
	}
	
	
	
	/**
	 * Zeigt den durch type und color definierten Spielstein auf dem Spielbrett an.
	 * @param label
	 * @param color
	 * @param type
	 */
	private void putStone(LblGameStone label, ESpielsteinFarbe color){
		putStone(label, color, ESpielsteinTyp.NORMAL);
	}
	
	private void putStone(LblGameStone label, ESpielsteinFarbe color, ESpielsteinTyp type){
		// graphisch und akkustisch
		core.getView().getTheme().playSound(Sounds.steinSetzen);
		label.setImage(color, type);
		spielFeld.updateStack(color, -1);
		
		// für den Core
		gesetzteSteine.add(label);
	}
	
	
	/**
	 * Entfernt den Spielstein vom Spielbrett.
	 * @param label
	 */
	private void removeStone(LblGameStone label){
		label.removeImage();
	}
	
	
	/**
	 * Diese Methode wird in der Setz-Phase aufgerufen. Hier werden die Spielsteine gesetzt.
	 * @param label
	 * @param color
	 */
	private boolean phase1(LblGameStone label, ESpielsteinFarbe color){
		// Überprüfen, ob Feld frei ist
		if(label.isFree()){
			putStone(label, color);
			return true;
		}else{
			spielFeld.info("Feld ist schon besetzt.");
			return false;
		}
	}
	
	
	/**
	 * Wenn eine Mühle vorhanden ist liefert diese Methode die Farbe der Mühle zurück.
	 * Andernfalls wird <code>null</code> zurückgegeben.
	 * @return {@link ESpielsteinFarbe}
	 */
	private ESpielsteinFarbe isMuehle(){
		// wenn sich keine Steine auf dem Spielfeld befinden
		if(gesetzteSteine.isEmpty()){
			return null;
		}
		
		// für jeden Stein prüfen, ob er einen Nachbarn hat, dieser die gleiche Farbe hat
		// und auf der gegenüberliegenden Seite sich auch ein Stein mit derselben Farbe befindet
		for(LblGameStone stein : gesetzteSteine){
			Position pos = stein.getPosition();
			LblGameStone nachbar = null;
			int koordinate = 1;
			int richtung = -1;
			
			for(;richtung<=1;richtung++){
				if(richtung!=0){
					koordinate = 1;
					
					for(;koordinate<=3;koordinate++){
						switch (koordinate){
						case 1:
							nachbar = spielFeld.getLabel(pos.getEbene().getValue()+richtung, pos.getX().getValue(), pos.getY().getValue());
							break;
						case 2:
							nachbar = spielFeld.getLabel(pos.getEbene().getValue(), pos.getX().getValue()+richtung, pos.getY().getValue());
							break;
						case 3:
							nachbar = spielFeld.getLabel(pos.getEbene().getValue(), pos.getX().getValue(), pos.getY().getValue()+richtung);
							break;
						}
						
						if(nachbar != null)
							if(!nachbar.isFree())
								if(nachbar.getFarbe().equals(stein.getFarbe()))
									break;
					}
					
					if(nachbar != null)
						break;
				}
			}
			
			if(nachbar != null){
				richtung *= -1;
				
				switch (koordinate){
				case 1:
					nachbar = spielFeld.getLabel(pos.getEbene().getValue()+richtung, pos.getX().getValue(), pos.getY().getValue());
					break;
				case 2:
					nachbar = spielFeld.getLabel(pos.getEbene().getValue(), pos.getX().getValue()+richtung, pos.getY().getValue());
					break;
				case 3:
					nachbar = spielFeld.getLabel(pos.getEbene().getValue(), pos.getX().getValue(), pos.getY().getValue()+richtung);
					break;
				}
				
				if(nachbar != null)
					if(!nachbar.isFree())
						if(nachbar.getFarbe().equals(stein.getFarbe()))
							return stein.getFarbe();
			}
		}
		
		// wenn keine Mühle gefunden wurde: return null
		return null;
	}
	
	
	
	/**
	 * Diese Methode nimmt das Label entgegen, auf das geklickt wurde
	 * und verarbeitet die Eingabe.
	 * @param label
	 */
	public void labelClicked(LblGameStone label){
		// Ermitteln, welcher Spieler am Zug ist
		ESpielsteinFarbe color = null;
		if(core.isWeissDran())
			color = ESpielsteinFarbe.WEISS;
		else
			color = ESpielsteinFarbe.SCHWARZ;
		
		
		// TODO Spielphase überprüfen
		//		1: Setzten
		//		2: Ziehen
		//		3: Springen
		boolean status = false;
		switch(core.getSpielPhase()){
		case 1:
			status = phase1(label, color);
			break;
		case 2:
			break;
		case 3:
			break;
		}
		
		// TODO Auf eine Mühle prüfen
		// nur überprüfen, wenn zuvor ein Stein gesetzt/verschoben wurde
		if(status){
			ESpielsteinFarbe muehleFarbe = isMuehle();
			if(muehleFarbe != null)
				System.out.println(muehleFarbe.name());
		}
		
		// Bei Erfolg Spielerwechsel
		if(status && core.isWeissDran())
			core.setSchwarzDran();
		else if(status && core.isSchwarzDran())
			core.setWeissDran();
	}
}