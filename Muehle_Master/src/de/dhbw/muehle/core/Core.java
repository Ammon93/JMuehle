package de.dhbw.muehle.core;

import java.util.ArrayList;
import java.util.List;

import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.menus.GamePanel.LblGameStone;
import de.dhbw.muehle.model.Log;
import de.dhbw.muehle.model.Model;
import de.dhbw.muehle.model.spielstein.EPositionIndex;
import de.dhbw.muehle.model.spielstein.ESpielsteinFarbe;
import de.dhbw.muehle.model.spielstein.Position;
import de.dhbw.muehle.model.spielstein.Spielstein;

/**
 * 
 * @author Kreistschen Die Coreklasse dient als zentrale Fuktionseinheit des
 *         Programmes. Hier werden alle GUI Elemente initalisiert und die
 *         meisten Funktionen des Programmes bereitgestellt
 * 
 */
public class Core {

	// Deklaration verschiedener Variablen und Objekte

	private ViewController vController;
	private Model model;

	/**
	 * Diese Hashlisten dienen als Zwischenspeicher der Hashcodes welche die
	 * Klasse Position erstellt. Sie sind Notwendig um sp�ter zu
	 * �berpr�fen ob die jeweilige Position schon besetzt ist
	 */
	private List<Integer> Hashliste_Weiss;
	private List<Integer> Hashliste_Schwarz;

	private List<Integer> Hashliste_gueltige_Zuege;

	// In den Listen StW und StS werden alle Spielsteine gespeichert
	private List<Spielstein> StW, StS;

	// Durch diese Boolean wird der Spielablauf bestimmt
	private boolean schwarzDran;
	private boolean weissDran;
	private boolean Muehle_weiss;
	private boolean Muehle_schwarz;
	private boolean schwarzerStein_angeklickt;
	private boolean weisserStein_angeklickt;
	private boolean weiss_Sprungphase;
	private boolean schwarz_Sprungphase;

	private int Spielphase = 1;

	private LblGameStone angeklickterStein;

	/**
	 * Diese IndexListen dienen zur Zwischenspeicherung der Steine, welche in
	 * einer Muehle stehen. Dies ist notwendig um festzustellen welche Steine in
	 * einer Muehele stehen und nicht entfernt werden duerfen
	 */
	List<Spielstein> index1s;
	List<Spielstein> index2s;
	List<Spielstein> index3s;
	List<Spielstein> index1w;
	List<Spielstein> index2w;
	List<Spielstein> index3w;

	// Getter und Setter Methoden

	public LblGameStone getAngeklickterStein() {
		return angeklickterStein;
	}

	public void setAngeklickterStein(LblGameStone angeklickterStein) {
		this.angeklickterStein = angeklickterStein;
	}

	public boolean isSchwarzerStein_angeklickt() {
		return schwarzerStein_angeklickt;
	}

	public void setSchwarzerStein_angeklickt(boolean schwarzerStein_angeklickt) {
		this.schwarzerStein_angeklickt = schwarzerStein_angeklickt;
	}

	public boolean isWeisserStein_angeklickt() {
		return weisserStein_angeklickt;
	}

	public void setWeisserStein_angeklickt(boolean weisserStein_angeklickt) {
		this.weisserStein_angeklickt = weisserStein_angeklickt;
	}

	public int getSpielphase() {
		return Spielphase;
	}

	public void setSpielphase(int spielphase) {
		Spielphase = spielphase;
	}

	public boolean isMuehle_weiss() {
		return Muehle_weiss;
	}

	public void setMuehle_weiss(boolean muehle_weiss) {
		Muehle_weiss = muehle_weiss;
	}

	public boolean isMuehle_schwarz() {
		return Muehle_schwarz;
	}

	public void setMuehle_schwarz(boolean muehle_schwarz) {
		Muehle_schwarz = muehle_schwarz;
	}

	public boolean isSchwarzDran() {
		return schwarzDran;
	}

	public void setSchwarzDran(boolean schwarzDran) {
		this.schwarzDran = schwarzDran;
		if (schwarzDran)
			vController.changePlayer(1, "schwarz");
	}

	public boolean isWeissDran() {
		return weissDran;
	}

	public void setWeissDran(boolean weissDran) {
		this.weissDran = weissDran;
		if (weissDran)
			vController.changePlayer(2, "weiss");
	}

	public List<Integer> getHashliste_Weiss() {
		return Hashliste_Weiss;
	}

	public void setHashliste_Weiss(List<Integer> hashliste_Weiss) {
		Hashliste_Weiss = hashliste_Weiss;
	}

	public List<Integer> getHashliste_Schwarz() {
		return Hashliste_Schwarz;
	}

	public void setHashliste_Schwarz(List<Integer> hashliste_Schwarz) {
		Hashliste_Schwarz = hashliste_Schwarz;
	}

	public List<Spielstein> getStW() {
		return StW;
	}

	public void setStW(List<Spielstein> stW) {
		StW = stW;
	}

	public List<Spielstein> getStS() {
		return StS;
	}

	public void setStS(List<Spielstein> stS) {
		StS = stS;
	}

	public List<Spielstein> getIndex1s() {
		return index1s;
	}

	public void setIndex1s(List<Spielstein> index1s) {
		this.index1s = index1s;
	}

	public List<Spielstein> getIndex2s() {
		return index2s;
	}

	public void setIndex2s(List<Spielstein> index2s) {
		this.index2s = index2s;
	}

	public List<Spielstein> getIndex3s() {
		return index3s;
	}

	public void setIndex3s(List<Spielstein> index3s) {
		this.index3s = index3s;
	}

	public List<Spielstein> getIndex1w() {
		return index1w;
	}

	public void setIndex1w(List<Spielstein> index1w) {
		this.index1w = index1w;
	}

	public List<Spielstein> getIndex2w() {
		return index2w;
	}

	public void setIndex2w(List<Spielstein> index2w) {
		this.index2w = index2w;
	}

	public List<Spielstein> getIndex3w() {
		return index3w;
	}

	public void setIndex3w(List<Spielstein> index3w) {
		this.index3w = index3w;
	}

	// Konstruktor

	public Core() {
		vController = new ViewController(this);
		model = new Model();
		StW = new ArrayList<Spielstein>();
		StS = new ArrayList<Spielstein>();
		Hashliste_Weiss = new ArrayList<Integer>();
		Hashliste_Schwarz = new ArrayList<Integer>();
		Hashliste_gueltige_Zuege = new ArrayList<Integer>();
		weissDran = true;
		index1w = new ArrayList<Spielstein>();
		index2w = new ArrayList<Spielstein>();
		index3w = new ArrayList<Spielstein>();
		index1s = new ArrayList<Spielstein>();
		index2s = new ArrayList<Spielstein>();
		index3s = new ArrayList<Spielstein>();

	}

	// private void run() {
	// Log.log("run() ohne Fehler gestartet", getClass().getSimpleName());
	// }

	// Zentrale Methode zur initalisierung der GUI und allen weiteren Fenstern
	public void initGame() {
		vController.initGui();
	}

	public void erzeugeSpielsteinweiss(EPositionIndex ebene, EPositionIndex x,
			EPositionIndex y, Position pos) {

		StW.add(new Spielstein(ebene, x, y, ESpielsteinFarbe.WEISS));
		Hashliste_Weiss.add(pos.hashCode());

	}

	public void erzeugeSpielsteinschwarz(EPositionIndex ebene,
			EPositionIndex x, EPositionIndex y, Position pos) {

		StS.add(new Spielstein(ebene, x, y, ESpielsteinFarbe.SCHWARZ));
		Hashliste_Schwarz.add(pos.hashCode());

	}

	public boolean postitionFree(Position pos) {
		boolean posfree = true;
		if (Hashliste_Weiss.contains(pos.hashCode())) {
			posfree = false;
		}

		else if (Hashliste_Schwarz.contains(pos.hashCode())) {
			posfree = false;
		}

		return posfree;

	}

	public void start_Spielphase1() {

	}

	public void ueberpruefen_Muehele_weiss(Position pos) {
		Muehle_weiss = false;
		int zaehler1 = 0;
		int zaehler2 = 0;
		int zaehler3 = 0;

		index1w.clear();
		index2w.clear();
		index3w.clear();

		int posEbene = pos.getEbene().getValue();
		int posX = pos.getX().getValue();
		int posY = pos.getY().getValue();

		for (int i = 0; i < StW.size(); i++) {
			if (posEbene == StW.get(i).getPosition().getEbene().getValue()
					&& posX == StW.get(i).getPosition().getX().getValue()) {
				zaehler1++;
				index1w.add(StW.get(i));

			}
			if (posEbene == StW.get(i).getPosition().getEbene().getValue()
					&& posY == StW.get(i).getPosition().getY().getValue()) {
				zaehler2++;
				index2w.add(StW.get(i));
			}
			if (posX == StW.get(i).getPosition().getX().getValue()
					&& posY == StW.get(i).getPosition().getY().getValue()
					&& (posX + posY == 3 || posX + posY == 5)) {
				zaehler3++;
				index3w.add(StW.get(i));
			}

		}

		if (zaehler1 == 3 || zaehler2 == 3 || zaehler3 == 3) {
			if (zaehler1 == 3) {
				for (int z = 0; z < index1w.size(); z++) {
					index1w.get(z).setInMuehle(true);
				}
			}
			if (zaehler2 == 3) {
				for (int z = 0; z < index2w.size(); z++) {
					index2w.get(z).setInMuehle(true);
				}
			}
			if (zaehler3 == 3) {
				for (int z = 0; z < index3w.size(); z++) {
					index3w.get(z).setInMuehle(true);
				}
			}
			System.out.println("Muehle weiss");
			Muehle_weiss = true;

		}

	}

	// Um Muehleninfos aus den Spielsteinen zu l�schen wenn Muehele geoeffnet
	// wird
	public void ueberpruefen_Muehele_weiss_vorZug(Position pos) {
		Muehle_weiss = false;
		int zaehler1 = 0;
		int zaehler2 = 0;
		int zaehler3 = 0;

		index1w.clear();
		index2w.clear();
		index3w.clear();

		int posEbene = pos.getEbene().getValue();
		int posX = pos.getX().getValue();
		int posY = pos.getY().getValue();

		for (int i = 0; i < StW.size(); i++) {
			if (posEbene == StW.get(i).getPosition().getEbene().getValue()
					&& posX == StW.get(i).getPosition().getX().getValue()) {
				zaehler1++;
				index1w.add(StW.get(i));

			}
			if (posEbene == StW.get(i).getPosition().getEbene().getValue()
					&& posY == StW.get(i).getPosition().getY().getValue()) {
				zaehler2++;
				index2w.add(StW.get(i));
			}
			if (posX == StW.get(i).getPosition().getX().getValue()
					&& posY == StW.get(i).getPosition().getY().getValue()
					&& (posX + posY == 3 || posX + posY == 5)) {
				zaehler3++;
				index3w.add(StW.get(i));
			}

		}

		if (zaehler1 == 3 || zaehler2 == 3 || zaehler3 == 3) {
			if (zaehler1 == 3) {
				for (int z = 0; z < index1w.size(); z++) {
					index1w.get(z).setInMuehle(false);
				}
			}
			if (zaehler2 == 3) {
				for (int z = 0; z < index2w.size(); z++) {
					index2w.get(z).setInMuehle(false);
				}
			}
			if (zaehler3 == 3) {
				for (int z = 0; z < index3w.size(); z++) {
					index3w.get(z).setInMuehle(false);
				}
			}
			System.out.println("Muehle weiss ge�ffnet");
			Muehle_weiss = false;

		}

	}

	public void ueberpruefen_Muehele_schwarz(Position pos) {
		Muehle_schwarz = false;
		int zaehler1 = 0;
		int zaehler2 = 0;
		int zaehler3 = 0;

		index1s.clear();
		index2s.clear();
		index3s.clear();

		int posEbene = pos.getEbene().getValue();
		int posX = pos.getX().getValue();
		int posY = pos.getY().getValue();

		for (int i = 0; i < StS.size(); i++) {

			if (posEbene == StS.get(i).getPosition().getEbene().getValue()
					&& posX == StS.get(i).getPosition().getX().getValue()) {
				zaehler1++;
				index1s.add(StS.get(i));
			}
			if (posEbene == StS.get(i).getPosition().getEbene().getValue()
					&& posY == StS.get(i).getPosition().getY().getValue()) {
				zaehler2++;
				index2s.add(StS.get(i));
			}
			if (posX == StS.get(i).getPosition().getX().getValue()
					&& posY == StS.get(i).getPosition().getY().getValue()
					&& (posX + posY == 3 || posX + posY == 5)) {
				zaehler3++;
				index3s.add(StS.get(i));
			}

		}

		if (zaehler1 == 3 || zaehler2 == 3 || zaehler3 == 3) {
			if (zaehler1 == 3) {
				for (int z = 0; z < index1s.size(); z++) {
					index1s.get(z).setInMuehle(true);
				}
			}
			if (zaehler2 == 3) {
				for (int z = 0; z < index2s.size(); z++) {
					index2s.get(z).setInMuehle(true);
				}
			}
			if (zaehler3 == 3) {
				for (int z = 0; z < index3s.size(); z++) {
					index3s.get(z).setInMuehle(true);
				}
			}
			System.out.println("Muehle schwarz");
			Muehle_schwarz = true;
		}

	}

	// Um Muehleninfos aus den Spielsteinen zu l�schen wenn Muehele geoeffnet
	// wird
	public void ueberpruefen_Muehele_schwarz_vorZug(Position pos) {
		Muehle_schwarz = false;
		int zaehler1 = 0;
		int zaehler2 = 0;
		int zaehler3 = 0;

		index1s.clear();
		index2s.clear();
		index3s.clear();

		int posEbene = pos.getEbene().getValue();
		int posX = pos.getX().getValue();
		int posY = pos.getY().getValue();

		for (int i = 0; i < StS.size(); i++) {

			if (posEbene == StS.get(i).getPosition().getEbene().getValue()
					&& posX == StS.get(i).getPosition().getX().getValue()) {
				zaehler1++;
				index1s.add(StS.get(i));
			}
			if (posEbene == StS.get(i).getPosition().getEbene().getValue()
					&& posY == StS.get(i).getPosition().getY().getValue()) {
				zaehler2++;
				index2s.add(StS.get(i));
			}
			if (posX == StS.get(i).getPosition().getX().getValue()
					&& posY == StS.get(i).getPosition().getY().getValue()
					&& (posX + posY == 3 || posX + posY == 5)) {
				zaehler3++;
				index3s.add(StS.get(i));
			}

		}

		if (zaehler1 == 3 || zaehler2 == 3 || zaehler3 == 3) {
			if (zaehler1 == 3) {
				for (int z = 0; z < index1s.size(); z++) {
					index1s.get(z).setInMuehle(false);
				}
			}
			if (zaehler2 == 3) {
				for (int z = 0; z < index2s.size(); z++) {
					index2s.get(z).setInMuehle(false);
				}
			}
			if (zaehler3 == 3) {
				for (int z = 0; z < index3s.size(); z++) {
					index3s.get(z).setInMuehle(false);
				}
			}
			System.out.println("Muehle schwarz ge�ffnet");
			Muehle_schwarz = false;
		}

	}

	public void angeklicktSetzen_weiss(LblGameStone stone) {
		
		if (getHashliste_Weiss().contains(stone.getPosition().hashCode())) {
			stone.setImage(vController.getTheme().getSpielSteinWeissGewaehlt());
			ueberpruefen_Muehele_weiss_vorZug(stone.getPosition());
			setWeisserStein_angeklickt(true);
			setWeissDran(true);
		}
		}
	

	public void angeklicktSetzen_schwarz(LblGameStone stone) {
		if (getHashliste_Schwarz().contains(stone.getPosition().hashCode())) {
			stone.setImage(vController.getTheme()
					.getSpielSteinSchwarzGewaehlt());
			ueberpruefen_Muehele_schwarz_vorZug(stone.getPosition());
			setSchwarzerStein_angeklickt(true);
			setSchwarzDran(true);
		}
		}
	

	public void entferneStein_ziehen_weiss() {
		angeklickterStein.removeImage();

	}

	public boolean isWeiss_Sprungphase() {
		return weiss_Sprungphase;
	}

	public void setWeiss_Sprungphase(boolean weiss_Sprungphase) {
		this.weiss_Sprungphase = weiss_Sprungphase;
	}

	public boolean isSchwarz_Sprungphase() {
		return schwarz_Sprungphase;
	}

	public void setSchwarz_Sprungphase(boolean schwarz_Sprungphase) {
		this.schwarz_Sprungphase = schwarz_Sprungphase;
	}

	public void entferneStein_ziehen_schwarz() {
		angeklickterStein.removeImage();

	}

	public void setzeStein_ziehen_weiss(LblGameStone stone) {
		System.out.println(angeklickterStein.getPosition().hashCode());
		EPositionIndex PosEbene = stone.getPosition().getEbene();
		EPositionIndex PosX = stone.getPosition().getX();
		EPositionIndex PosY = stone.getPosition().getY();
		for (int i = 0; i < StW.size(); i++) {
			System.out.println(StW.get(i).getPosition().hashCode());
			if (angeklickterStein.getPosition().hashCode() == StW.get(i)
					.getPosition().hashCode()) {
				for (int j = 0; j < Hashliste_Weiss.size(); j++) {
					if (Hashliste_Weiss.get(j) == StW.get(i).getPosition()
							.hashCode()) {
						System.out.println(Hashliste_Weiss.get(j));
						Hashliste_Weiss.remove(j);
						System.out.println(StW.get(i).getPosition());
						StW.get(i).setPosition(PosEbene, PosX, PosY);
						System.out.println(StW.get(i).getPosition());
						System.out.println(StW.get(i).getPosition().hashCode());
						Hashliste_Weiss
								.add(StW.get(i).getPosition().hashCode());
						stone.setImage(vController.getTheme()
								.getSpielSteinWeiss());
						

					}

				}
			}
		}

	}

	public void setzeStein_ziehen_schwarz(LblGameStone stone) {
		System.out.println(angeklickterStein.getPosition().hashCode());
		EPositionIndex PosEbene = stone.getPosition().getEbene();
		EPositionIndex PosX = stone.getPosition().getX();
		EPositionIndex PosY = stone.getPosition().getY();
		for (int i = 0; i < StS.size(); i++) {
			System.out.println(StS.get(i).getPosition().hashCode());
			if (angeklickterStein.getPosition().hashCode() == StS.get(i)
					.getPosition().hashCode()) {
				for (int j = 0; j < Hashliste_Schwarz.size(); j++) {
					if (Hashliste_Schwarz.get(j) == StS.get(i).getPosition()
							.hashCode()) {
						System.out.println(Hashliste_Schwarz.get(j));
						Hashliste_Schwarz.remove(j);
						System.out.println(StS.get(i).getPosition());
						StS.get(i).setPosition(PosEbene, PosX, PosY);
						System.out.println(StS.get(i).getPosition());
						System.out.println(StS.get(i).getPosition().hashCode());
						Hashliste_Schwarz.add(StS.get(i).getPosition()
								.hashCode());
						stone.setImage(vController.getTheme()
								.getSpielSteinSchwarz());
						if (StS.size() <= 3) {
							schwarz_Sprungphase = true;
						}

					}

				}
			}
		}

	}

	public void zieheSteinWeiss(LblGameStone stone) {
		pruefeZug(angeklickterStein);
		if (weiss_Sprungphase == false) {
		if (postitionFree(stone.getPosition())) {
			if (Hashliste_gueltige_Zuege.contains(stone.getPosition()
					.hashCode())) {

				setzeStein_ziehen_weiss(stone);
				setWeisserStein_angeklickt(false);
				for (int i = 0; i < StW.size(); i++) {
					ueberpruefen_Muehele_weiss(StW.get(i).getPosition());
				}

				ueberpruefen_Muehele_weiss(stone.getPosition());
				entferneStein_ziehen_weiss();

				if (isMuehle_weiss() == true) {
					setWeissDran(true);
					setSchwarzDran(false);
				} else {
					setSchwarzDran(true);
					setWeissDran(false);
					setMuehle_weiss(false);
				}

				// setWeissDran(false);
				// setSchwarzDran(true);
			}

		} else {
			setWeissDran(true);
			setWeisserStein_angeklickt(true);
		}
		}
		else{
			if (postitionFree(stone.getPosition())) {
					setzeStein_ziehen_weiss(stone);
					setWeisserStein_angeklickt(false);
					for (int i = 0; i < StW.size(); i++) {
						ueberpruefen_Muehele_weiss(StW.get(i).getPosition());
					}

					ueberpruefen_Muehele_weiss(stone.getPosition());
					entferneStein_ziehen_weiss();

					if (isMuehle_weiss() == true) {
						setWeissDran(true);
						setSchwarzDran(false);
					} else {
						setSchwarzDran(true);
						setWeissDran(false);
						setMuehle_weiss(false);
					}

					// setWeissDran(false);
					// setSchwarzDran(true);
				}

			 else {
				setWeissDran(true);
				setWeisserStein_angeklickt(true);
			}
		}
	}
		

		// Pr�ft Steine an den Eckpositionen
		// if (pos.getX().getValue() + pos.getY().getValue() % 2 == 0) {
		// //Dann modulo 0 heist dass der Stein an einer Ecke steht
		// System.out.println("Eckstein");
		//

	

	public void zieheSteinSchwarz(LblGameStone stone) {
		pruefeZug(angeklickterStein);

		if (schwarz_Sprungphase == false) {
			if (postitionFree(stone.getPosition())) {
				if (Hashliste_gueltige_Zuege.contains(stone.getPosition()
						.hashCode())) {
					setzeStein_ziehen_schwarz(stone);
					setSchwarzerStein_angeklickt(false);
					for (int i = 0; i < StS.size(); i++) {
						ueberpruefen_Muehele_schwarz(StS.get(i).getPosition());
					}
					ueberpruefen_Muehele_schwarz(stone.getPosition());
					entferneStein_ziehen_schwarz();

					if (isMuehle_schwarz() == true) {
						setWeissDran(false);
						setSchwarzDran(true);
					} else {
						setSchwarzDran(false);
						setWeissDran(true);
						setMuehle_schwarz(false);
					}

					// setSchwarzDran(false);
					// setWeissDran(true);
				}
			} else {
				setSchwarzDran(true);
				setSchwarzerStein_angeklickt(true);
			}
		} else {
			if (postitionFree(stone.getPosition())) {
					setzeStein_ziehen_schwarz(stone);
					setSchwarzerStein_angeklickt(false);
					for (int i = 0; i < StS.size(); i++) {
						ueberpruefen_Muehele_schwarz(StS.get(i).getPosition());
					}
					ueberpruefen_Muehele_schwarz(stone.getPosition());
					entferneStein_ziehen_schwarz();

					if (isMuehle_schwarz() == true) {
						setWeissDran(false);
						setSchwarzDran(true);
					} else {
						setSchwarzDran(false);
						setWeissDran(true);
						setMuehle_schwarz(false);
					}

					// setSchwarzDran(false);
					// setWeissDran(true);
				}
			 else {
				setSchwarzDran(true);
				setSchwarzerStein_angeklickt(true);
			}
		}

	}

	public void pruefeZug(LblGameStone stone) {

		int PosEbene = stone.getPosition().getEbene().getValue();
		int PosX = stone.getPosition().getX().getValue();
		int PosY = stone.getPosition().getY().getValue();
		int Hashcode;
		// Pr�fe ob Eckstein
		/**
		 * final int prime = 31; int result = 1; result = prime * result +
		 * ebene.getValue(); result = prime * result + x.getValue(); result =
		 * prime * result + y.getValue(); return result;
		 */
		if ((PosX + PosY) % 2 == 0) {

			if (PosX == 1 && PosY == 1) {
				Hashcode = 31 + PosEbene;
				Hashcode = 31 * Hashcode + (PosX + 1);
				Hashcode = 31 * Hashcode + PosY;
				Hashliste_gueltige_Zuege.add(Hashcode);
				Hashcode = 0;
				Hashcode = 31 + PosEbene;
				Hashcode = 31 * Hashcode + PosX;
				Hashcode = 31 * Hashcode + (PosY + 1);
				Hashliste_gueltige_Zuege.add(Hashcode);
				Hashcode = 0;
			}
			if (PosX == 3 && PosY == 1) {
				Hashcode = 31 + PosEbene;
				Hashcode = 31 * Hashcode + (PosX - 1);
				Hashcode = 31 * Hashcode + PosY;
				Hashliste_gueltige_Zuege.add(Hashcode);
				Hashcode = 0;
				Hashcode = 31 + PosEbene;
				Hashcode = 31 * Hashcode + PosX;
				Hashcode = 31 * Hashcode + (PosY + 1);
				Hashliste_gueltige_Zuege.add(Hashcode);
				Hashcode = 0;
			}
			if (PosX == 1 && PosY == 3) {
				Hashcode = 31 + PosEbene;
				Hashcode = 31 * Hashcode + (PosX + 1);
				Hashcode = 31 * Hashcode + PosY;
				Hashliste_gueltige_Zuege.add(Hashcode);
				Hashcode = 0;
				Hashcode = 31 + PosEbene;
				Hashcode = 31 * Hashcode + PosX;
				Hashcode = 31 * Hashcode + (PosY - 1);
				Hashliste_gueltige_Zuege.add(Hashcode);
				Hashcode = 0;
			}
			if (PosX == 3 && PosY == 3) {
				Hashcode = 31 + PosEbene;
				Hashcode = 31 * Hashcode + (PosX - 1);
				Hashcode = 31 * Hashcode + PosY;
				Hashliste_gueltige_Zuege.add(Hashcode);
				Hashcode = 0;
				Hashcode = 31 + PosEbene;
				Hashcode = 31 * Hashcode + PosX;
				Hashcode = 31 * Hashcode + (PosY - 1);
				Hashliste_gueltige_Zuege.add(Hashcode);
				Hashcode = 0;
			}
		}
		// Pruefen ob Mittelpos
		else if ((PosX + PosY) % 2 == 1) {
			// Verschiebung auf gleicher Ebene
			if (PosX == 2) {
				Hashcode = 31 + PosEbene;
				Hashcode = 31 * Hashcode + (PosX + 1);
				Hashcode = 31 * Hashcode + PosY;
				Hashliste_gueltige_Zuege.add(Hashcode);
				Hashcode = 0;
				Hashcode = 31 + PosEbene;
				Hashcode = 31 * Hashcode + (PosX - 1);
				Hashcode = 31 * Hashcode + PosY;
				Hashliste_gueltige_Zuege.add(Hashcode);
				Hashcode = 0;
			}
			if (PosY == 2) {
				Hashcode = 31 + PosEbene;
				Hashcode = 31 * Hashcode + PosX;
				Hashcode = 31 * Hashcode + (PosY - 1);
				Hashliste_gueltige_Zuege.add(Hashcode);
				Hashcode = 0;
				Hashcode = 31 + PosEbene;
				Hashcode = 31 * Hashcode + PosX;
				Hashcode = 31 * Hashcode + (PosY + 1);
				Hashliste_gueltige_Zuege.add(Hashcode);
				Hashcode = 0;
			}
			// Aenderung der Ebene
			if (PosEbene == 1) {
				Hashcode = 31 + (PosEbene + 1);
				Hashcode = 31 * Hashcode + PosX;
				Hashcode = 31 * Hashcode + PosY;
				Hashliste_gueltige_Zuege.add(Hashcode);
				Hashcode = 0;
			}
			if (PosEbene == 2) {
				Hashcode = 31 + (PosEbene + 1);
				Hashcode = 31 * Hashcode + PosX;
				Hashcode = 31 * Hashcode + PosY;
				Hashliste_gueltige_Zuege.add(Hashcode);
				Hashcode = 0;
				Hashcode = 31 + (PosEbene - 1);
				Hashcode = 31 * Hashcode + PosX;
				Hashcode = 31 * Hashcode + PosY;
				Hashliste_gueltige_Zuege.add(Hashcode);
				Hashcode = 0;
			}
			if (PosEbene == 3) {
				Hashcode = 31 + (PosEbene - 1);
				Hashcode = 31 * Hashcode + PosX;
				Hashcode = 31 * Hashcode + PosY;
				Hashliste_gueltige_Zuege.add(Hashcode);
				Hashcode = 0;
			}
		}
	}
	
	public void weisseSteine_setzen(LblGameStone stone) {
		if (postitionFree(stone.getPosition())
				&& !vController.frame.gamePanel.isStackEmpty(vController.frame.gamePanel.weisseSteine)) {
			erzeugeSpielsteinweiss(stone.getPosition().getEbene(), stone
					.getPosition().getX(), stone.getPosition().getY(), stone
					.getPosition());
			stone.setImage(vController.getTheme().getSpielSteinWeiss());
			vController.frame.gamePanel.updateStack(vController.frame.gamePanel.weisseSteine, -1);
			System.out.println(getStW().size());
			ueberpruefen_Muehele_weiss(stone.getPosition());
			if (isMuehle_weiss() == true) {
				setWeissDran(true);
				setSchwarzDran(false);
			} else {
				setSchwarzDran(true);
				setWeissDran(false);
			}

		}

	}
	
	public void schwarzeSteine_setzen(LblGameStone stone) {

		if (postitionFree(stone.getPosition())
				&& !vController.frame.gamePanel
						.isStackEmpty(vController.frame.gamePanel.schwarzeSteine)) {
			erzeugeSpielsteinschwarz(stone.getPosition().getEbene(), stone
					.getPosition().getX(), stone.getPosition().getY(), stone
					.getPosition());
			stone.setImage(vController.getTheme().getSpielSteinSchwarz());
			vController.frame.gamePanel.updateStack(vController.frame.gamePanel.schwarzeSteine, -1);
			System.out.println(getStS().size());
			ueberpruefen_Muehele_schwarz(stone.getPosition());
			if (isMuehle_schwarz() == true) {
				setWeissDran(false);
				setSchwarzDran(true);
			} else {
				setSchwarzDran(false);
				setWeissDran(true);
			}

		}
//		if (getStS().size() + getStW().size() >=8) {
//			setSpielphase(2);
//			}

		// System.out.println(core.isWeissDran());
		// System.out.println(core.isSchwarzDran());
		// }
		if (vController.frame.gamePanel.isStackEmpty(vController.frame.gamePanel.weisseSteine)
			&& vController.frame.gamePanel.isStackEmpty(vController.frame.gamePanel.schwarzeSteine)) {
		setSpielphase(2);
		}
	}
	
	public void entferneSteinWeiss(LblGameStone stone) {

		if (isMuehle_schwarz() == true) {
			if (!getHashliste_Schwarz().contains(
					stone.getPosition().hashCode())) {

				for (int i = 0; i < getStW().size(); i++) {
					System.out.println(" Weisser Stein " + i
							+ getStW().get(i).isInMuehle());
					if (getStW().get(i).getPosition().hashCode() == stone
							.getPosition().hashCode()
							&& getStW().get(i).isInMuehle() == false) {

						for (int j = 0; j < getHashliste_Weiss().size(); j++) {
							if (getHashliste_Weiss().get(j) == stone
									.getPosition().hashCode()) {
								getHashliste_Weiss().remove(j);
								getStW().remove(i);
								stone.removeImage();
								setMuehle_schwarz(false);
								setWeissDran(true);
								setSchwarzDran(false);
							}
						}
					}
				}

			}

			else {

				setMuehle_schwarz(true);
				setSchwarzDran(true);
			}
		}
		
		if (getStW().size() <= 3) {
			setWeiss_Sprungphase(true);
		}
		
	    if(getStW().size()<=2){
			System.out.println("Spieler Schwarz gewinnt");
		}
	}
	
	public void entferneSteinSchwarz(LblGameStone stone) {
		if (isMuehle_weiss() == true) {
			if (!getHashliste_Weiss().contains(
					stone.getPosition().hashCode())) {
				for (int i = 0; i < getStS().size(); i++) {
					System.out.println(" Schwarzer Stein " + i
							+ getStS().get(i).isInMuehle());
					if (getStS().get(i).getPosition().hashCode() == stone
							.getPosition().hashCode()
							&& getStS().get(i).isInMuehle() == false) {
						for (int j = 0; j < getHashliste_Schwarz().size(); j++) {
							if (getHashliste_Schwarz().get(j) == stone
									.getPosition().hashCode()) {
								getHashliste_Schwarz().remove(j);
								getStS().remove(i);
								stone.removeImage();
								setMuehle_weiss(false);
								setSchwarzDran(true);
								setWeissDran(false);
							}

						}

					}

				}
			}

		} else {
			setMuehle_weiss(true);
			setWeissDran(true);
		}
		
		if (getStS().size() <= 3) {
			setSchwarz_Sprungphase(true);
		}
		
	    if(getStS().size()<=2){
			System.out.println("Spieler Weiss gewinnt");
		}

	}
}
