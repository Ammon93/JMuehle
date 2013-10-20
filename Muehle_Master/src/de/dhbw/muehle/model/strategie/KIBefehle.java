package de.dhbw.muehle.model.strategie;
import java.util.List;


public class KIBefehle {

	private boolean bvierSteineSpieler;
	private boolean bfuenfSteineSpieler;
	private boolean bsechsSteineSpieler;
	private boolean bsiebenSteineSpieler;
	private boolean bachtSteineSpieler;
	private boolean bneunSteineSpieler;
	
	private boolean bvierSteineGegner;
	private boolean bfuenfSteineGegner;
	private boolean bsechsSteineGegner;
	private boolean bsiebenSteineGegner;
	private boolean bachtSteineGegner;
	private boolean bneunSteineGegner;

	private boolean bZweiOderDreiZugmoeglichkeitenSpieler;
	private boolean bVierOderFuenfZugmoeglichkeitenSpieler;
	private boolean bSechsOderSiebenZugmoeglichkeitenSpieler;
	private boolean bAchtOderNeunZugmoeglichkeitenSpieler;
	private boolean bMehralsZehnZugmoeglichkeitenSpieler;
	
	private boolean bZweiOderDreiZugmoeglichkeitenGegner;
	private boolean bVierOderFuenfZugmoeglichkeitenGegner;
	private boolean bSechsOderSiebenZugmoeglichkeitenGegner;
	private boolean bAchtOderNeunZugmoeglichkeitenGegner;
	private boolean bMehralsZehnZugmoeglichkeitenGegner;
	
	private boolean bEineGeschlosseneMuehleSpieler;
	private boolean bMehrAlsEineGeschlosseneMuehleSpieler;
	
	private boolean bEineGeschlosseneMuehleGegner;
	private boolean bMehrAlsEineGeschlosseneMuehleGegner;
	
	private boolean bEineOffeneMuehleSpieler;
	private boolean bMehrAlsEineOffeneMuehleSpieler;
	
	private boolean bEineOffeneMuehleGegner;
	private boolean bMehrAlsEineOffeneMuehleGegner;
	
	private boolean bMehrAlsSiebenPotentielleBewegungenWenigeralsGegnerSpieler;
	private boolean bZwischenVierUndSechsPotentielleBewegungenWenigeralsGegnerSpieler;
	private boolean bZwischenZweiBisDreiPotentielleBewegungenWenigeralsGegnerSpieler;
	private boolean bEinePotentielleBewegungWenigerAlsGegnerSpieler;
	private boolean bGenauGleichVieleBewegungenGegnerSpieler;
	private boolean bMehrAlsSiebenPotentielleBewegungenMehralsGegnerSpieler;
	private boolean bZwischenVierUndSechsPotentielleBewegungenMehralsGegnerSpieler;
	private boolean bZwischenZweiBisDreiPotentielleBewegungenMehralsGegnerSpieler;
	private boolean bEinePotentielleBewegungWenigerAlsMehrSpieler;
	
	final int ivierSteineSpieler = 10;
	final int ifuenfSteineSpieler = 15;
	final int isechsSteineSpieler = 20;
	final int isiebenSteineSpieler = 25;
	final int iachtSteineSpieler = 30;
	final int ineunSteineSpieler = 35;
	
	final int ivierSteineGegner = -10;
	final int ifuenfSteineGegner = -15;
	final int isechsSteineGegner = -20;
	final int isiebenSteineGegner = -25;
	final int iachtSteineGegner = -30;
	final int ineunSteineGegner = -35;

	final int iZweiOderDreiZugmoeglichkeitenSpieler = 10;
	final int iVierOderFuenfZugmoeglichkeitenSpieler = 15;
	final int iSechsOderSiebenZugmoeglichkeitenSpieler = 20;
	final int iAchtOderNeunZugmoeglichkeitenSpieler = 25;
	final int iMehralsZehnZugmoeglichkeitenSpieler = 30;
	
	final int iZweiOderDreiZugmoeglichkeitenGegner = -10;
	final int iVierOderFuenfZugmoeglichkeitenGegner = -15;
	final int iSechsOderSiebenZugmoeglichkeitenGegner = -20;
	final int iAchtOderNeunZugmoeglichkeitenGegner = -25;
	final int iMehralsZehnZugmoeglichkeitenGegner = -30;
	
	final int iEineGeschlosseneMuehleSpieler = 1;
	final int iMehrAlsEineGeschlosseneMuehleSpieler = 2;
	
	final int iEineGeschlosseneMuehleGegner = -1;
	final int iMehrAlsEineGeschlosseneMuehleGegner = -2;
	
	final int iEineOffeneMuehleSpieler = 2;
	final int iMehrAlsEineOffeneMuehleSpieler = 4;
	
	final int iEineOffeneMuehleGegner = -2;
	final int iMehrAlsEineOffeneMuehleGegner = -4;
	
	final int iMehrAlsSiebenPotentielleBewegungenWenigeralsGegnerSpieler = 16;
	final int iZwischenVierUndSechsPotentielleBewegungenWenigeralsGegnerSpieler = 8;
	final int iZwischenZweiBisDreiPotentielleBewegungenWenigeralsGegnerSpieler = 4;
	final int iEinePotentielleBewegungWenigerAlsGegnerSpieler = 2;
	final int iGenauGleichVieleBewegungenGegnerSpieler = 0;
	final int iMehrAlsSiebenPotentielleBewegungenMehralsGegnerSpieler = -16;
	final int iZwischenVierUndSechsPotentielleBewegungenMehralsGegnerSpieler = -8;
	final int iZwischenZweiBisDreiPotentielleBewegungenMehralsGegnerSpieler = -4;
	final int iEinePotentielleBewegungWenigerAlsMehrSpieler = 2;
	
	
	private List<Boolean> Spielzustaende;
	private List<Integer> Spielzustaendewertigkeit;
	
	private int zugwertigkeit;
	
	//Listen füllen
	public void fillList(){
		Spielzustaende.add(bvierSteineSpieler);
		Spielzustaende.add(bfuenfSteineSpieler);
		Spielzustaende.add(bsechsSteineSpieler);	
		Spielzustaende.add(bsiebenSteineSpieler);
		Spielzustaende.add(bachtSteineSpieler);
		Spielzustaende.add(bneunSteineSpieler);
		Spielzustaende.add(bvierSteineGegner);
		Spielzustaende.add(bfuenfSteineGegner);
		Spielzustaende.add(bsechsSteineGegner);	
		Spielzustaende.add(bsiebenSteineGegner);
		Spielzustaende.add(bachtSteineGegner);
		Spielzustaende.add(bneunSteineGegner);
		
		Spielzustaende.add(bZweiOderDreiZugmoeglichkeitenSpieler);
		Spielzustaende.add(bVierOderFuenfZugmoeglichkeitenSpieler);
		Spielzustaende.add(bSechsOderSiebenZugmoeglichkeitenSpieler);
		Spielzustaende.add(bAchtOderNeunZugmoeglichkeitenSpieler);
		Spielzustaende.add(bMehralsZehnZugmoeglichkeitenSpieler);
		
		Spielzustaende.add(bZweiOderDreiZugmoeglichkeitenGegner);
		Spielzustaende.add(bVierOderFuenfZugmoeglichkeitenGegner);
		Spielzustaende.add(bSechsOderSiebenZugmoeglichkeitenGegner);
		Spielzustaende.add(bAchtOderNeunZugmoeglichkeitenGegner);
		Spielzustaende.add(bMehralsZehnZugmoeglichkeitenGegner);
		
		Spielzustaende.add(bEineGeschlosseneMuehleSpieler);
		Spielzustaende.add(bMehrAlsEineGeschlosseneMuehleSpieler);
		
		Spielzustaende.add(bEineGeschlosseneMuehleGegner);
		Spielzustaende.add(bMehrAlsEineGeschlosseneMuehleGegner);
		
		Spielzustaende.add(bEineOffeneMuehleSpieler);
		Spielzustaende.add(bMehrAlsEineOffeneMuehleSpieler);

		Spielzustaende.add(bEineOffeneMuehleGegner);
		Spielzustaende.add(bMehrAlsEineOffeneMuehleGegner);
		
		Spielzustaende.add(bMehrAlsSiebenPotentielleBewegungenWenigeralsGegnerSpieler);
		Spielzustaende.add(bZwischenVierUndSechsPotentielleBewegungenWenigeralsGegnerSpieler);
		Spielzustaende.add(bZwischenZweiBisDreiPotentielleBewegungenWenigeralsGegnerSpieler);
		Spielzustaende.add(bEinePotentielleBewegungWenigerAlsGegnerSpieler);
		Spielzustaende.add(bGenauGleichVieleBewegungenGegnerSpieler);
		Spielzustaende.add(bMehrAlsSiebenPotentielleBewegungenMehralsGegnerSpieler);
		Spielzustaende.add(bZwischenVierUndSechsPotentielleBewegungenMehralsGegnerSpieler);
		Spielzustaende.add(bZwischenZweiBisDreiPotentielleBewegungenMehralsGegnerSpieler);
		Spielzustaende.add(bEinePotentielleBewegungWenigerAlsMehrSpieler);
		
		Spielzustaendewertigkeit.add(ivierSteineSpieler);
		Spielzustaendewertigkeit.add(ifuenfSteineSpieler);
		Spielzustaendewertigkeit.add(isechsSteineSpieler);	
		Spielzustaendewertigkeit.add(isiebenSteineSpieler);
		Spielzustaendewertigkeit.add(iachtSteineSpieler);
		Spielzustaendewertigkeit.add(ineunSteineSpieler);
		Spielzustaendewertigkeit.add(ivierSteineGegner);
		Spielzustaendewertigkeit.add(ifuenfSteineGegner);
		Spielzustaendewertigkeit.add(isechsSteineGegner);	
		Spielzustaendewertigkeit.add(isiebenSteineGegner);
		Spielzustaendewertigkeit.add(iachtSteineGegner);
		Spielzustaendewertigkeit.add(ineunSteineGegner);
		
		Spielzustaendewertigkeit.add(iZweiOderDreiZugmoeglichkeitenSpieler);
		Spielzustaendewertigkeit.add(iVierOderFuenfZugmoeglichkeitenSpieler);
		Spielzustaendewertigkeit.add(iSechsOderSiebenZugmoeglichkeitenSpieler);
		Spielzustaendewertigkeit.add(iAchtOderNeunZugmoeglichkeitenSpieler);
		Spielzustaendewertigkeit.add(iMehralsZehnZugmoeglichkeitenSpieler);
		
		Spielzustaendewertigkeit.add(iZweiOderDreiZugmoeglichkeitenGegner);
		Spielzustaendewertigkeit.add(iVierOderFuenfZugmoeglichkeitenGegner);
		Spielzustaendewertigkeit.add(iSechsOderSiebenZugmoeglichkeitenGegner);
		Spielzustaendewertigkeit.add(iAchtOderNeunZugmoeglichkeitenGegner);
		Spielzustaendewertigkeit.add(iMehralsZehnZugmoeglichkeitenGegner);
		
		Spielzustaendewertigkeit.add(iEineGeschlosseneMuehleSpieler);
		Spielzustaendewertigkeit.add(iMehrAlsEineGeschlosseneMuehleSpieler);
		
		Spielzustaendewertigkeit.add(iEineGeschlosseneMuehleGegner);
		Spielzustaendewertigkeit.add(iMehrAlsEineGeschlosseneMuehleGegner);
		
		Spielzustaendewertigkeit.add(iEineOffeneMuehleSpieler);
		Spielzustaendewertigkeit.add(iMehrAlsEineOffeneMuehleSpieler);

		Spielzustaendewertigkeit.add(iEineOffeneMuehleGegner);
		Spielzustaendewertigkeit.add(iMehrAlsEineOffeneMuehleGegner);
		
		Spielzustaendewertigkeit.add(iMehrAlsSiebenPotentielleBewegungenWenigeralsGegnerSpieler);
		Spielzustaendewertigkeit.add(iZwischenVierUndSechsPotentielleBewegungenWenigeralsGegnerSpieler);
		Spielzustaendewertigkeit.add(iZwischenZweiBisDreiPotentielleBewegungenWenigeralsGegnerSpieler);
		Spielzustaendewertigkeit.add(iEinePotentielleBewegungWenigerAlsGegnerSpieler);
		Spielzustaendewertigkeit.add(iGenauGleichVieleBewegungenGegnerSpieler);
		Spielzustaendewertigkeit.add(iMehrAlsSiebenPotentielleBewegungenMehralsGegnerSpieler);
		Spielzustaendewertigkeit.add(iZwischenVierUndSechsPotentielleBewegungenMehralsGegnerSpieler);
		Spielzustaendewertigkeit.add(iZwischenZweiBisDreiPotentielleBewegungenMehralsGegnerSpieler);
		Spielzustaendewertigkeit.add(iEinePotentielleBewegungWenigerAlsMehrSpieler);
	}
	
	
	public void anzahlSpielsteineSpielerpruefen(int spielsteineSpieler){
		//Hier muss Spaeter die Anzahl der Spielsteine aus Sts bzw STw ausgelesen werde
		if (spielsteineSpieler==9){
			bneunSteineSpieler=true;
		}
		else if(spielsteineSpieler==8){
			bachtSteineSpieler=true;
		}
		else if(spielsteineSpieler==7){
			bsiebenSteineSpieler=true;
		}
		else if(spielsteineSpieler==6){
			bsechsSteineSpieler=true;
		}
		else if(spielsteineSpieler==5){
			bfuenfSteineSpieler=true;
		}
		else if(spielsteineSpieler==4){
			bvierSteineSpieler=true;
		}
		else{
			System.out.println("Anzahl der Spielsteine erfolglos durchlaufen Spieler");
		}
	}
	

	public void anzahlSpielsteineGegnerpruefen(int spielsteineGegner){
		//Hier muss Spaeter die Anzahl der Spielsteine aus Sts bzw STw ausgelesen werde
		if (spielsteineGegner==9){
			bneunSteineGegner=true;
		}
		else if(spielsteineGegner==8){
			bachtSteineGegner=true;
		}
		else if(spielsteineGegner==7){
			bsiebenSteineGegner=true;
		}
		else if(spielsteineGegner==6){
			bsechsSteineGegner=true;
		}
		else if(spielsteineGegner==5){
			bfuenfSteineGegner=true;
		}
		else if(spielsteineGegner==4){
			bvierSteineGegner=true;
		}
		else{
			System.out.println("Anzahl der Spielsteine erfolglos durchlaufen Gegner");
		}
	}
	
	public void anzahlZugmoeglichkeitenSpieler(int ZugmoeglichkeitenSpieler){
		//Hier müssen später alle Möglichen Zugmöglichkeiten !ProStein!
		//ermittelt werden, bestenfalls in einer anderen, evtl. schon vorhandenen Methode
		if (ZugmoeglichkeitenSpieler<=10){
			bMehralsZehnZugmoeglichkeitenSpieler=true;
		}
		else if(ZugmoeglichkeitenSpieler==8||ZugmoeglichkeitenSpieler==9){
			bAchtOderNeunZugmoeglichkeitenSpieler=true;
		}
		else if(ZugmoeglichkeitenSpieler==6||ZugmoeglichkeitenSpieler==7){
			bSechsOderSiebenZugmoeglichkeitenSpieler=true;
		}
		else if(ZugmoeglichkeitenSpieler==4||ZugmoeglichkeitenSpieler==5){
			bVierOderFuenfZugmoeglichkeitenSpieler=true;
		}
		else if(ZugmoeglichkeitenSpieler==2||ZugmoeglichkeitenSpieler==3){
			bZweiOderDreiZugmoeglichkeitenSpieler=true;
		}
		else{
			System.out.println("Zugmöglichkeiten erfolglos durchlaufen Spieler");
		}
	}
	
	public void anzahlZugmoeglichkeitenGegner(int ZugmoeglichkeitenGegner){
		if (ZugmoeglichkeitenGegner<=10){
			bMehralsZehnZugmoeglichkeitenGegner=true;
		}
		else if(ZugmoeglichkeitenGegner==8||ZugmoeglichkeitenGegner==9){
			bAchtOderNeunZugmoeglichkeitenGegner=true;
		}
		else if(ZugmoeglichkeitenGegner==6||ZugmoeglichkeitenGegner==7){
			bSechsOderSiebenZugmoeglichkeitenGegner=true;
		}
		else if(ZugmoeglichkeitenGegner==4||ZugmoeglichkeitenGegner==5){
			bVierOderFuenfZugmoeglichkeitenGegner=true;
		}
		else if(ZugmoeglichkeitenGegner==2||ZugmoeglichkeitenGegner==3){
			bZweiOderDreiZugmoeglichkeitenGegner=true;
		}
		else{
			System.out.println("Zugmöglichkeiten erfolglos durchlaufen Gegner");
		}
	}
	
	public void anzahlgeschlosseneMuehlenSpieler(int geschlosseneMuehlenSpieler){
		if (geschlosseneMuehlenSpieler <= 1){
			bMehrAlsEineGeschlosseneMuehleSpieler=true;
		}
		else if(geschlosseneMuehlenSpieler == 1){
			bEineGeschlosseneMuehleSpieler=true;
		}
	}
	
	public void anzahlgeschlosseneMuehlenGegner(int geschlosseneMuehlenGegner){
		if (geschlosseneMuehlenGegner <= 1){
			bMehrAlsEineGeschlosseneMuehleGegner=true;
		}
		else if(geschlosseneMuehlenGegner == 1){
			bEineGeschlosseneMuehleGegner=true;
		}
	}

	public void anzahloffeneMuehlenSpieler(int offeneMuehlenSpieler){
		if (offeneMuehlenSpieler <= 1){
			bMehrAlsEineOffeneMuehleSpieler=true;
		}
		else if(offeneMuehlenSpieler == 1){
			bEineOffeneMuehleSpieler=true;
		}
	}

	public void anzahloffeneMuehlenGegner(int offeneMuehlenGegner){
		if (offeneMuehlenGegner <= 1){
			bMehrAlsEineOffeneMuehleGegner=true;
		}
		else if(offeneMuehlenGegner == 1){
			bEineOffeneMuehleGegner=true;
		}	
	}
	
	public void bewegungsmöglichkeitendifferenz(int moeglicheBewegungen){
		if(moeglicheBewegungen >= 7){
			bMehrAlsSiebenPotentielleBewegungenMehralsGegnerSpieler=true;
		}
		else if(moeglicheBewegungen == 4||moeglicheBewegungen == 5||moeglicheBewegungen == 6){
			bZwischenVierUndSechsPotentielleBewegungenMehralsGegnerSpieler=true;
		}
		else if (moeglicheBewegungen ==2||moeglicheBewegungen==3){
			bZwischenZweiBisDreiPotentielleBewegungenMehralsGegnerSpieler = true;
		}
		else if (moeglicheBewegungen ==1){
			bEinePotentielleBewegungWenigerAlsMehrSpieler = true;
		}
		else if (moeglicheBewegungen ==0){
			bGenauGleichVieleBewegungenGegnerSpieler = true;
		}
		else if (moeglicheBewegungen ==-1){
			bEinePotentielleBewegungWenigerAlsGegnerSpieler = true;
		}
		else if (moeglicheBewegungen ==-2||moeglicheBewegungen == -3){
			bZwischenZweiBisDreiPotentielleBewegungenWenigeralsGegnerSpieler = true;
		}
		else if(moeglicheBewegungen == -4||moeglicheBewegungen == -5||moeglicheBewegungen == -6){
			bZwischenVierUndSechsPotentielleBewegungenWenigeralsGegnerSpieler=true;
		}
		else if(moeglicheBewegungen <= -7){
			bMehrAlsSiebenPotentielleBewegungenWenigeralsGegnerSpieler=true;
		}
	}


	
//Methode um die Aktuelle Wertigkeit zu berechnen
	
	public void aktuelleZugwertigkeitberechnen(List <Boolean> booleanlist, List <Integer> integerlist){
		zugwertigkeit = 0;
		for(int i =0; i<=booleanlist.size(); i++){
			if(booleanlist.get(i)==true){
				zugwertigkeit = zugwertigkeit + integerlist.get(i);
			}
		}
		System.out.println("Zugwertigkeit: " + zugwertigkeit);
	}
//Methode um den besten Zug zu ermitteln
	public void ermittleBestenZug(){
		//for-Schleife, die jeden Spielstein durchläuft und prüft, welche Züge mit dem entsprechenden Stein 
		//möglich sind.
		//Für jede mögliche neue Position muss die aktuelleZugwertigkeit berechnet werden
		//Hierfür muss jede der Prüfungsmethoden mit der neuen Funktion durchlaufen werden
		//Die getestete Position wird in ein Array geschrieben (also der Hashcode o.ä. der die Position
		//eindeutig bestimmbar macht
		//In einem anderen Array muss am gleichen Index wie die Position die Zugwertigkeit für den
		//entsprechenden Zug gespeichert werden.
		//Am Ende wird die Max-Wertigkeit ermittelt und der Zug voll
		
	}
	public void ermittleBesteSetzmöglichkeit(){
		
		//Durchlauf der einzelnen Positionen auf dem Spielfeld
		for(int z=1;z<=3;z++){
			for (int x=1; x<=3;x++){
				for(int y=1; y<=3; y++){
					//überprüfe ob die Position der jeweiligen Zählvariablen frei ist
					//ÜBerprüfung kann durch die Hashcodes, die in STW und STS gespeichert sind laufen
					//Man kann selbigen mit den Zählvariablen errechnen
					//überprüfe welche Wertigkeit an der aktuellen Position für die Zählvariablen erreicht wird
				}
			}
		}
	}
	
}
