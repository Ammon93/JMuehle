package de.dhbw.muehle.model.strategie;

import java.util.ArrayList;
import java.util.List;

import de.dhbw.muehle.core.Core;
import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.menus.GamePanel.LblGameStone;
import de.dhbw.muehle.model.spielstein.Position;

public class KIBefehle {

	private Core core;
	List<LblGameStone> StonelistWhite = new ArrayList();
	List<LblGameStone> StonelistBlack = new ArrayList();
	private int zugmoeglichkeiten_weiss;
	private List<Integer> Hashliste_gueltige_Zuege_gesamt_Weiss;
	private List<Integer> Hashliste_gueltige_Zuege_gesamt_Schwarz;

	private boolean bvierSteineschwarz;
	private boolean bfuenfSteineschwarz;
	private boolean bsechsSteineschwarz;
	private boolean bsiebenSteineschwarz;
	private boolean bachtSteineschwarz;
	private boolean bneunSteineschwarz;

	private boolean bvierSteineweiss;
	private boolean bfuenfSteineweiss;
	private boolean bsechsSteineweiss;
	private boolean bsiebenSteineweiss;
	private boolean bachtSteineweiss;
	private boolean bneunSteineweiss;

	private boolean bZweiOderDreiZugmoeglichkeitenschwarz;
	private boolean bVierOderFuenfZugmoeglichkeitenschwarz;
	private boolean bSechsOderSiebenZugmoeglichkeitenschwarz;
	private boolean bAchtOderNeunZugmoeglichkeitenschwarz;
	private boolean bMehralsZehnZugmoeglichkeitenschwarz;

	private boolean bZweiOderDreiZugmoeglichkeitenweiss;
	private boolean bVierOderFuenfZugmoeglichkeitenweiss;
	private boolean bSechsOderSiebenZugmoeglichkeitenweiss;
	private boolean bAchtOderNeunZugmoeglichkeitenweiss;
	private boolean bMehralsZehnZugmoeglichkeitenweiss;

	private boolean bEineGeschlosseneMuehleschwarz;
	private boolean bMehrAlsEineGeschlosseneMuehleschwarz;

	private boolean bEineGeschlosseneMuehleweiss;
	private boolean bMehrAlsEineGeschlosseneMuehleweiss;

	private boolean bEineOffeneMuehleschwarz;
	private boolean bMehrAlsEineOffeneMuehleschwarz;

	private boolean bEineOffeneMuehleweiss;
	private boolean bMehrAlsEineOffeneMuehleweiss;

	private boolean bMehrAlsSiebenPotentielleBewegungenWenigeralsweissschwarz;
	private boolean bZwischenVierUndSechsPotentielleBewegungenWenigeralsweissschwarz;
	private boolean bZwischenZweiBisDreiPotentielleBewegungenWenigeralsweissschwarz;
	private boolean bEinePotentielleBewegungWenigerAlsweissschwarz;
	private boolean bGenauGleichVieleBewegungenweissschwarz;
	private boolean bMehrAlsSiebenPotentielleBewegungenMehralsweissschwarz;
	private boolean bZwischenVierUndSechsPotentielleBewegungenMehralsweissschwarz;
	private boolean bZwischenZweiBisDreiPotentielleBewegungenMehralsweissschwarz;
	private boolean bEinePotentielleBewegungWenigerAlsMehrschwarz;

	final int ivierSteineschwarz = 10;
	final int ifuenfSteineschwarz = 15;
	final int isechsSteineschwarz = 20;
	final int isiebenSteineschwarz = 25;
	final int iachtSteineschwarz = 30;
	final int ineunSteineschwarz = 35;

	final int ivierSteineweiss = -10;
	final int ifuenfSteineweiss = -15;
	final int isechsSteineweiss = -20;
	final int isiebenSteineweiss = -25;
	final int iachtSteineweiss = -30;
	final int ineunSteineweiss = -35;

	final int iZweiOderDreiZugmoeglichkeitenschwarz = 10;
	final int iVierOderFuenfZugmoeglichkeitenschwarz = 15;
	final int iSechsOderSiebenZugmoeglichkeitenschwarz = 20;
	final int iAchtOderNeunZugmoeglichkeitenschwarz = 25;
	final int iMehralsZehnZugmoeglichkeitenschwarz = 30;

	final int iZweiOderDreiZugmoeglichkeitenweiss = -10;
	final int iVierOderFuenfZugmoeglichkeitenweiss = -15;
	final int iSechsOderSiebenZugmoeglichkeitenweiss = -20;
	final int iAchtOderNeunZugmoeglichkeitenweiss = -25;
	final int iMehralsZehnZugmoeglichkeitenweiss = -30;

	final int iEineGeschlosseneMuehleschwarz = 1;
	final int iMehrAlsEineGeschlosseneMuehleschwarz = 2;

	final int iEineGeschlosseneMuehleweiss = -1;
	final int iMehrAlsEineGeschlosseneMuehleweiss = -2;

	final int iEineOffeneMuehleschwarz = 2;
	final int iMehrAlsEineOffeneMuehleschwarz = 4;

	final int iEineOffeneMuehleweiss = -2;
	final int iMehrAlsEineOffeneMuehleweiss = -4;

	final int iMehrAlsSiebenPotentielleBewegungenWenigeralsweissschwarz = 16;
	final int iZwischenVierUndSechsPotentielleBewegungenWenigeralsweissschwarz = 8;
	final int iZwischenZweiBisDreiPotentielleBewegungenWenigeralsweissschwarz = 4;
	final int iEinePotentielleBewegungWenigerAlsweissschwarz = 2;
	final int iGenauGleichVieleBewegungenweissschwarz = 0;
	final int iMehrAlsSiebenPotentielleBewegungenMehralsweissschwarz = -16;
	final int iZwischenVierUndSechsPotentielleBewegungenMehralsweissschwarz = -8;
	final int iZwischenZweiBisDreiPotentielleBewegungenMehralsweissschwarz = -4;
	final int iEinePotentielleBewegungWenigerAlsMehrschwarz = 2;

	private List<Boolean> Spielzustaende;
	private List<Integer> Spielzustaendewertigkeit;

	private int zugwertigkeit;
	
	public KIBefehle(Core _core){
		
		core = _core;
		Hashliste_gueltige_Zuege_gesamt_Weiss = new ArrayList();
		Hashliste_gueltige_Zuege_gesamt_Schwarz = new ArrayList();
	}

	// Listen füllen
	public void fillList() {
		Spielzustaende.add(bvierSteineschwarz);
		Spielzustaende.add(bfuenfSteineschwarz);
		Spielzustaende.add(bsechsSteineschwarz);
		Spielzustaende.add(bsiebenSteineschwarz);
		Spielzustaende.add(bachtSteineschwarz);
		Spielzustaende.add(bneunSteineschwarz);
		Spielzustaende.add(bvierSteineweiss);
		Spielzustaende.add(bfuenfSteineweiss);
		Spielzustaende.add(bsechsSteineweiss);
		Spielzustaende.add(bsiebenSteineweiss);
		Spielzustaende.add(bachtSteineweiss);
		Spielzustaende.add(bneunSteineweiss);

		Spielzustaende.add(bZweiOderDreiZugmoeglichkeitenschwarz);
		Spielzustaende.add(bVierOderFuenfZugmoeglichkeitenschwarz);
		Spielzustaende.add(bSechsOderSiebenZugmoeglichkeitenschwarz);
		Spielzustaende.add(bAchtOderNeunZugmoeglichkeitenschwarz);
		Spielzustaende.add(bMehralsZehnZugmoeglichkeitenschwarz);

		Spielzustaende.add(bZweiOderDreiZugmoeglichkeitenweiss);
		Spielzustaende.add(bVierOderFuenfZugmoeglichkeitenweiss);
		Spielzustaende.add(bSechsOderSiebenZugmoeglichkeitenweiss);
		Spielzustaende.add(bAchtOderNeunZugmoeglichkeitenweiss);
		Spielzustaende.add(bMehralsZehnZugmoeglichkeitenweiss);

		Spielzustaende.add(bEineGeschlosseneMuehleschwarz);
		Spielzustaende.add(bMehrAlsEineGeschlosseneMuehleschwarz);

		Spielzustaende.add(bEineGeschlosseneMuehleweiss);
		Spielzustaende.add(bMehrAlsEineGeschlosseneMuehleweiss);

		Spielzustaende.add(bEineOffeneMuehleschwarz);
		Spielzustaende.add(bMehrAlsEineOffeneMuehleschwarz);

		Spielzustaende.add(bEineOffeneMuehleweiss);
		Spielzustaende.add(bMehrAlsEineOffeneMuehleweiss);

		Spielzustaende
				.add(bMehrAlsSiebenPotentielleBewegungenWenigeralsweissschwarz);
		Spielzustaende
				.add(bZwischenVierUndSechsPotentielleBewegungenWenigeralsweissschwarz);
		Spielzustaende
				.add(bZwischenZweiBisDreiPotentielleBewegungenWenigeralsweissschwarz);
		Spielzustaende.add(bEinePotentielleBewegungWenigerAlsweissschwarz);
		Spielzustaende.add(bGenauGleichVieleBewegungenweissschwarz);
		Spielzustaende
				.add(bMehrAlsSiebenPotentielleBewegungenMehralsweissschwarz);
		Spielzustaende
				.add(bZwischenVierUndSechsPotentielleBewegungenMehralsweissschwarz);
		Spielzustaende
				.add(bZwischenZweiBisDreiPotentielleBewegungenMehralsweissschwarz);
		Spielzustaende.add(bEinePotentielleBewegungWenigerAlsMehrschwarz);

		Spielzustaendewertigkeit.add(ivierSteineschwarz);
		Spielzustaendewertigkeit.add(ifuenfSteineschwarz);
		Spielzustaendewertigkeit.add(isechsSteineschwarz);
		Spielzustaendewertigkeit.add(isiebenSteineschwarz);
		Spielzustaendewertigkeit.add(iachtSteineschwarz);
		Spielzustaendewertigkeit.add(ineunSteineschwarz);
		Spielzustaendewertigkeit.add(ivierSteineweiss);
		Spielzustaendewertigkeit.add(ifuenfSteineweiss);
		Spielzustaendewertigkeit.add(isechsSteineweiss);
		Spielzustaendewertigkeit.add(isiebenSteineweiss);
		Spielzustaendewertigkeit.add(iachtSteineweiss);
		Spielzustaendewertigkeit.add(ineunSteineweiss);

		Spielzustaendewertigkeit.add(iZweiOderDreiZugmoeglichkeitenschwarz);
		Spielzustaendewertigkeit.add(iVierOderFuenfZugmoeglichkeitenschwarz);
		Spielzustaendewertigkeit.add(iSechsOderSiebenZugmoeglichkeitenschwarz);
		Spielzustaendewertigkeit.add(iAchtOderNeunZugmoeglichkeitenschwarz);
		Spielzustaendewertigkeit.add(iMehralsZehnZugmoeglichkeitenschwarz);

		Spielzustaendewertigkeit.add(iZweiOderDreiZugmoeglichkeitenweiss);
		Spielzustaendewertigkeit.add(iVierOderFuenfZugmoeglichkeitenweiss);
		Spielzustaendewertigkeit.add(iSechsOderSiebenZugmoeglichkeitenweiss);
		Spielzustaendewertigkeit.add(iAchtOderNeunZugmoeglichkeitenweiss);
		Spielzustaendewertigkeit.add(iMehralsZehnZugmoeglichkeitenweiss);

		Spielzustaendewertigkeit.add(iEineGeschlosseneMuehleschwarz);
		Spielzustaendewertigkeit.add(iMehrAlsEineGeschlosseneMuehleschwarz);

		Spielzustaendewertigkeit.add(iEineGeschlosseneMuehleweiss);
		Spielzustaendewertigkeit.add(iMehrAlsEineGeschlosseneMuehleweiss);

		Spielzustaendewertigkeit.add(iEineOffeneMuehleschwarz);
		Spielzustaendewertigkeit.add(iMehrAlsEineOffeneMuehleschwarz);

		Spielzustaendewertigkeit.add(iEineOffeneMuehleweiss);
		Spielzustaendewertigkeit.add(iMehrAlsEineOffeneMuehleweiss);

		Spielzustaendewertigkeit
				.add(iMehrAlsSiebenPotentielleBewegungenWenigeralsweissschwarz);
		Spielzustaendewertigkeit
				.add(iZwischenVierUndSechsPotentielleBewegungenWenigeralsweissschwarz);
		Spielzustaendewertigkeit
				.add(iZwischenZweiBisDreiPotentielleBewegungenWenigeralsweissschwarz);
		Spielzustaendewertigkeit
				.add(iEinePotentielleBewegungWenigerAlsweissschwarz);
		Spielzustaendewertigkeit.add(iGenauGleichVieleBewegungenweissschwarz);
		Spielzustaendewertigkeit
				.add(iMehrAlsSiebenPotentielleBewegungenMehralsweissschwarz);
		Spielzustaendewertigkeit
				.add(iZwischenVierUndSechsPotentielleBewegungenMehralsweissschwarz);
		Spielzustaendewertigkeit
				.add(iZwischenZweiBisDreiPotentielleBewegungenMehralsweissschwarz);
		Spielzustaendewertigkeit
				.add(iEinePotentielleBewegungWenigerAlsMehrschwarz);
	}

	public void anzahlSpielsteineschwarzpruefen(int spielsteineschwarz) {
		// Hier muss Spaeter die Anzahl der Spielsteine aus Sts bzw STw
		
		// ausgelesen werde
		if (spielsteineschwarz == 9) {
			bneunSteineschwarz = true;
		} else if (spielsteineschwarz == 8) {
			bachtSteineschwarz = true;
		} else if (spielsteineschwarz == 7) {
			bsiebenSteineschwarz = true;
		} else if (spielsteineschwarz == 6) {
			bsechsSteineschwarz = true;
		} else if (spielsteineschwarz == 5) {
			bfuenfSteineschwarz = true;
		} else if (spielsteineschwarz == 4) {
			bvierSteineschwarz = true;
		} else {
			System.out
					.println("Anzahl der Spielsteine erfolglos durchlaufen schwarz");
		}
	}

	public void anzahlSpielsteineweisspruefen(int spielsteineweiss) {
		// Hier muss Spaeter die Anzahl der Spielsteine aus Sts bzw STw
		// ausgelesen werde
		if (spielsteineweiss == 9) {
			bneunSteineweiss = true;
		} else if (spielsteineweiss == 8) {
			bachtSteineweiss = true;
		} else if (spielsteineweiss == 7) {
			bsiebenSteineweiss = true;
		} else if (spielsteineweiss == 6) {
			bsechsSteineweiss = true;
		} else if (spielsteineweiss == 5) {
			bfuenfSteineweiss = true;
		} else if (spielsteineweiss == 4) {
			bvierSteineweiss = true;
		} else {
			System.out
					.println("Anzahl der Spielsteine erfolglos durchlaufen weiss");
		}
	}

	public void anzahlZugmoeglichkeitenschwarz(int Zugmoeglichkeitenschwarz) {
		// Hier müssen später alle Möglichen Zugmöglichkeiten !ProStein!
		// ermittelt werden, bestenfalls in einer anderen, evtl. schon
		// vorhandenen Methode
		if (Zugmoeglichkeitenschwarz <= 10) {
			bMehralsZehnZugmoeglichkeitenschwarz = true;
		} else if (Zugmoeglichkeitenschwarz == 8
				|| Zugmoeglichkeitenschwarz == 9) {
			bAchtOderNeunZugmoeglichkeitenschwarz = true;
		} else if (Zugmoeglichkeitenschwarz == 6
				|| Zugmoeglichkeitenschwarz == 7) {
			bSechsOderSiebenZugmoeglichkeitenschwarz = true;
		} else if (Zugmoeglichkeitenschwarz == 4
				|| Zugmoeglichkeitenschwarz == 5) {
			bVierOderFuenfZugmoeglichkeitenschwarz = true;
		} else if (Zugmoeglichkeitenschwarz == 2
				|| Zugmoeglichkeitenschwarz == 3) {
			bZweiOderDreiZugmoeglichkeitenschwarz = true;
		} else {
			System.out
					.println("Zugmöglichkeiten erfolglos durchlaufen schwarz");
		}
	}

	public void anzahlZugmoeglichkeitenweiss(int Zugmoeglichkeitenweiss) {
		if (Zugmoeglichkeitenweiss <= 10) {
			bMehralsZehnZugmoeglichkeitenweiss = true;
		} else if (Zugmoeglichkeitenweiss == 8 || Zugmoeglichkeitenweiss == 9) {
			bAchtOderNeunZugmoeglichkeitenweiss = true;
		} else if (Zugmoeglichkeitenweiss == 6 || Zugmoeglichkeitenweiss == 7) {
			bSechsOderSiebenZugmoeglichkeitenweiss = true;
		} else if (Zugmoeglichkeitenweiss == 4 || Zugmoeglichkeitenweiss == 5) {
			bVierOderFuenfZugmoeglichkeitenweiss = true;
		} else if (Zugmoeglichkeitenweiss == 2 || Zugmoeglichkeitenweiss == 3) {
			bZweiOderDreiZugmoeglichkeitenweiss = true;
		} else {
			System.out.println("Zugmöglichkeiten erfolglos durchlaufen weiss");
		}
	}

	public void anzahlgeschlosseneMuehlenschwarz(int geschlosseneMuehlenschwarz) {
		if (geschlosseneMuehlenschwarz <= 1) {
			bMehrAlsEineGeschlosseneMuehleschwarz = true;
		} else if (geschlosseneMuehlenschwarz == 1) {
			bEineGeschlosseneMuehleschwarz = true;
		}
	}

	public void anzahlgeschlosseneMuehlenweiss(int geschlosseneMuehlenweiss) {
		if (geschlosseneMuehlenweiss <= 1) {
			bMehrAlsEineGeschlosseneMuehleweiss = true;
		} else if (geschlosseneMuehlenweiss == 1) {
			bEineGeschlosseneMuehleweiss = true;
		}
	}

	public void anzahloffeneMuehlenschwarz(int offeneMuehlenschwarz) {
		if (offeneMuehlenschwarz <= 1) {
			bMehrAlsEineOffeneMuehleschwarz = true;
		} else if (offeneMuehlenschwarz == 1) {
			bEineOffeneMuehleschwarz = true;
		}
	}

	public void anzahloffeneMuehlenweiss(int offeneMuehlenweiss) {
		if (offeneMuehlenweiss <= 1) {
			bMehrAlsEineOffeneMuehleweiss = true;
		} else if (offeneMuehlenweiss == 1) {
			bEineOffeneMuehleweiss = true;
		}
	}

	public void bewegungsmoeglichkeitendifferenz(int moeglicheBewegungen) {
		if (moeglicheBewegungen >= 7) {
			bMehrAlsSiebenPotentielleBewegungenMehralsweissschwarz = true;
		} else if (moeglicheBewegungen == 4 || moeglicheBewegungen == 5
				|| moeglicheBewegungen == 6) {
			bZwischenVierUndSechsPotentielleBewegungenMehralsweissschwarz = true;
		} else if (moeglicheBewegungen == 2 || moeglicheBewegungen == 3) {
			bZwischenZweiBisDreiPotentielleBewegungenMehralsweissschwarz = true;
		} else if (moeglicheBewegungen == 1) {
			bEinePotentielleBewegungWenigerAlsMehrschwarz = true;
		} else if (moeglicheBewegungen == 0) {
			bGenauGleichVieleBewegungenweissschwarz = true;
		} else if (moeglicheBewegungen == -1) {
			bEinePotentielleBewegungWenigerAlsweissschwarz = true;
		} else if (moeglicheBewegungen == -2 || moeglicheBewegungen == -3) {
			bZwischenZweiBisDreiPotentielleBewegungenWenigeralsweissschwarz = true;
		} else if (moeglicheBewegungen == -4 || moeglicheBewegungen == -5
				|| moeglicheBewegungen == -6) {
			bZwischenVierUndSechsPotentielleBewegungenWenigeralsweissschwarz = true;
		} else if (moeglicheBewegungen <= -7) {
			bMehrAlsSiebenPotentielleBewegungenWenigeralsweissschwarz = true;
		}
	}

	public void pruefeAlle() {
		erstelleStoneListSchwarz();
		erstelleStoneListWeiss();
		pruefeZugmoeglichkeitenfueralleSteineweiss();
		pruefeZugmoeglichkeitenfueralleSteineschwarz();
		anzahlSpielsteineschwarzpruefen(core.getStW().size());
		anzahlSpielsteineweisspruefen(core.getStS().size());
		anzahlZugmoeglichkeitenschwarz(Hashliste_gueltige_Zuege_gesamt_Schwarz.size());
		anzahlZugmoeglichkeitenweiss(Hashliste_gueltige_Zuege_gesamt_Weiss.size());
//		anzahlgeschlosseneMuehlenschwarz();
//		anzahlgeschlosseneMuehlenweiss();
//		anzahloffeneMuehlenschwarz();
//		anzahloffeneMuehlenweiss();
//		bewegungsmoeglichkeitendifferenz();
		aktuelleZugwertigkeitberechnen(Spielzustaende, Spielzustaendewertigkeit);

	}

	// Methode um die Aktuelle Wertigkeit zu berechnen

	public int aktuelleZugwertigkeitberechnen(List<Boolean> booleanlist,
			List<Integer> integerlist) {
		zugwertigkeit = 0;
		for (int i = 0; i <= booleanlist.size(); i++) {
			if (booleanlist.get(i) == true) {
				zugwertigkeit = zugwertigkeit + integerlist.get(i);
			}
		}
		System.out.println("Zugwertigkeit: " + zugwertigkeit);
		return zugwertigkeit;
	}

	// Methode um den besten Zug zu ermitteln
	public void ermittleBestenZug() {
		if (core.getSpielphase() == 1) {
			// An dieser Stelle müssen keine Zugmöglichkeiten geprüft werden
			// Ebenfalls nicht die MöglicheBewegungsdifferenz
			int Wert = aktuelleZugwertigkeitberechnen(Spielzustaende,
					Spielzustaendewertigkeit);

		} else {
			// Alle Methoden aufrufen
			int Wert = aktuelleZugwertigkeitberechnen(Spielzustaende,
					Spielzustaendewertigkeit);
		}

		// final int prime = 31;
		// int result = 1;
		// result = prime * result + ebene.getValue(); getValue liefert immer 1
		// 2 oder 3
		// result = prime * result + x.getValue();
		// result = prime * result + y.getValue();
		// return result;

		// for-Schleife, die jeden Spielstein durchläuft und prüft, welche Züge
		// mit dem entsprechenden Stein
		// möglich sind.
		// Für jede mögliche neue Position muss die aktuelleZugwertigkeit
		// berechnet werden
		// Hierfür muss jede der Prüfungsmethoden mit der neuen Funktion
		// durchlaufen werden
		// Die getestete Position wird in ein Array geschrieben (also der
		// Hashcode o.ä. der die Position
		// eindeutig bestimmbar macht
		// In einem anderen Array muss am gleichen Index wie die Position die
		// Zugwertigkeit für den
		// entsprechenden Zug gespeichert werden.
		// Am Ende wird die Max-Wertigkeit ermittelt und der Zug voll

	}

	public void ermittleBesteSetzmoeglichkeit() {

		// Durchlauf der einzelnen Positionen auf dem Spielfeld
		for (int z = 1; z <= 3; z++) {
			for (int x = 1; x <= 3; x++) {
				for (int y = 1; y <= 3; y++) {
					// überprüfe ob die Position der jeweiligen Zählvariablen
					// frei ist
					// ÜBerprüfung kann durch die Hashcodes, die in STW und STS
					// gespeichert sind laufen
					// Man kann selbigen mit den Zählvariablen errechnen
					// überprüfe welche Wertigkeit an der aktuellen Position für
					// die Zählvariablen erreicht wird
				}
			}
		}
	}

	public void entferneSteindesweisss() {
		//
	}

	public void erstelleStoneListWeiss() {
		for (int i = 0; i < core.getStW().size(); i++) {
			for (int j = 0; j < core.getvController().getFrame()
					.getGamePanel().getPanelList().size(); j++) {
				if (core.getStW().get(i).getPosition().hashCode() == core
						.getvController().getFrame().getGamePanel()
						.getPanelList().get(j).getPosition().hashCode()) {

					StonelistWhite.add(core.getvController().getFrame()
							.getGamePanel().getPanelList().get(j));
					// In dieser Liste finden sich alle Labels, die aktuell von
					// Weiss besetzt sind
				}
			}
		}
	}

	public void erstelleStoneListSchwarz() {
		for (int i = 0; i < core.getStS().size(); i++) {
			for (int j = 0; j < core.getvController().getFrame()
					.getGamePanel().getPanelList().size(); j++) {
				if (core.getStS().get(i).getPosition().hashCode() == core
						.getvController().getFrame().getGamePanel()
						.getPanelList().get(j).getPosition().hashCode()) {

					StonelistBlack.add(core.getvController().getFrame()
							.getGamePanel().getPanelList().get(j));
					// In dieser Liste finden sich alle Labels, die aktuell von
					// schwarz besetzt sind
				}
			}
		}
	}

	public void pruefeZugmoeglichkeitenfueralleSteineweiss() {
		//Hashliste_gueltige_Zuege_gesamt_Weiss.clear();
		for (int i = 0; (i < StonelistWhite.size()); i++) {
			core.pruefeZug(StonelistWhite.get(i));
			// Welche Züge für den einen Spielstein (i) möglich sind
			for (int j = 0; (j < core.getHashliste_gueltige_Zuege().size()); j++) {
				Hashliste_gueltige_Zuege_gesamt_Weiss.add(core
						.getHashliste_gueltige_Zuege().get(j));
			}
		}
		// Hashliste gültige Züge gesamt Weiss beinhaltet die Hashcodes aller
		// möglichen Züge
		// Nun muss noch geprüft werden, welche dieser Felder durch andere
		// Spielsteine belegt sind
		// Die Informationen über alle anderen Spielsteine stehen in Stonelist
		// Black und Stone list White
		for (int i = 0; i < Hashliste_gueltige_Zuege_gesamt_Weiss.size(); i++) {
			for (int j = 0; j < StonelistWhite.size(); j++) {
				if (Hashliste_gueltige_Zuege_gesamt_Weiss.get(i) == StonelistWhite
						.get(j).getPosition().hashCode()) {
					Hashliste_gueltige_Zuege_gesamt_Weiss.remove(i);
				}
			}
			for (int k = 0; k < StonelistBlack.size(); k++) {
				if (Hashliste_gueltige_Zuege_gesamt_Weiss.get(i) == StonelistBlack
						.get(k).getPosition().hashCode()) {
					Hashliste_gueltige_Zuege_gesamt_Weiss.remove(i);
				}
			}
		}

	}

	public void pruefeZugmoeglichkeitenfueralleSteineschwarz() {
		Hashliste_gueltige_Zuege_gesamt_Schwarz.clear();
		for (int i = 0; (i < StonelistBlack.size()); i++) {
			core.pruefeZug(StonelistBlack.get(i));
			// Welche Züge für den einen Spielstein (i) möglich sind
			for (int j = 0; (j < core.getHashliste_gueltige_Zuege().size()); j++) {
				Hashliste_gueltige_Zuege_gesamt_Schwarz.add(core
						.getHashliste_gueltige_Zuege().get(j));
			}
			for (int j = 0; j < StonelistWhite.size(); j++) {
				if (Hashliste_gueltige_Zuege_gesamt_Schwarz.get(i) == StonelistWhite
						.get(j).getPosition().hashCode()) {
					Hashliste_gueltige_Zuege_gesamt_Schwarz.remove(i);
				}
			}
		}
		// Hashliste gültige Züge gesamt Weiss beinhaltet die Hashcodes aller
		// möglichen Züge
		// Nun muss noch geprüft werden, welche dieser Felder durch andere
		// Spielsteine belegt sind
		// Die Informationen über alle anderen Spielsteine stehen in Stonelist
		// Black und Stone list White
		for (int i = 0; i < Hashliste_gueltige_Zuege_gesamt_Schwarz.size(); i++) {
			for (int j = 0; j < StonelistBlack.size(); j++) {
				if (Hashliste_gueltige_Zuege_gesamt_Schwarz.get(i) == StonelistBlack
						.get(j).getPosition().hashCode()) {
					Hashliste_gueltige_Zuege_gesamt_Schwarz.remove(i);
				}
			}
		}

	}
}
