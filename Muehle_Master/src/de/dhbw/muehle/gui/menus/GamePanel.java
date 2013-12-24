package de.dhbw.muehle.gui.menus;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.dhbw.muehle.EPositionIndex;
import de.dhbw.muehle.ESpielsteinFarbe;
import de.dhbw.muehle.ISpielstein;
import de.dhbw.muehle.Position;
import de.dhbw.muehle.gui.DialogBackgroundPanel;
import de.dhbw.muehle.gui.MillButton;
import de.dhbw.muehle.gui.View;
import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.menus.MainMenu.Spielregeln;
import de.dhbw.muehle.gui.viewactions.GamePanelVA;
import de.dhbw.muehle.model.theme.Sound.Sounds;

/**
 * Die Klasse stellt ein {@link JPanel}, auf dem das Bild des Spielbretts gezeichnet wird. Außerdem sind alle
 * für den Spielbetrieb relevanten Komponenten auf diesem {@link JPanel} dargestellt.
 * 
 * @author Ammon
 */
public class GamePanel extends AMenu {
	
	private JPanel gameField;
	private InfoField infoField;
	private WinLose winLose;
	private GameDialog gameDialog;
	private InputDialog inputDialog;
	private Spielregeln spielregeln;
	
	private LblGameStone lblGameStone[][][];
	private LblStoneStack schwarzeSteine;
	private LblStoneStack weisseSteine;
	
	private GamePanelVA vActions;
	
	private View view;
	
	private ArrayList<LblGameStone> panelList;
	
	
	/**
	 * Konstruktor
	 * 
	 * @param vController
	 * @param view
	 */
	public GamePanel(ViewController vController, View view) {
		super(vController, view);
		this.view = view;
		
		// ViewActions für GamePanel holen
		vActions = AMenu.vActions.getGamePanelVA();
		
		
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(597px;default):grow(62)"),
				ColumnSpec.decode("max(103px;default):grow(12)"),
				ColumnSpec.decode("max(300px;default):grow(29)"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),}));
		
		
		gameDialog = new GameDialog(view, vActions);
		add(gameDialog, "1, 1, 3, 1, fill, fill");
		
		inputDialog = new InputDialog(view, vActions);
		add(inputDialog, "1, 1, 3, 1, fill, fill");
		
		spielregeln = view.getMainMenu().new Spielregeln(view, AMenu.vActions.getMainMenuVA());
		add(spielregeln, "1, 1, 3, 1, fill, fill");
		
		winLose = new WinLose(view, vActions);
		add(winLose, "1, 1, 3, 1, fill, fill");
		
		gameField = new JPanel();
		gameField.setOpaque(false);
		add(gameField, "1, 1, fill, fill");
		gameField.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),}));
		
		
		JPanel stoneField = new JPanel();
		stoneField.setOpaque(false);
		add(stoneField, "2, 1, fill, fill");
		stoneField.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow(6)"),
				RowSpec.decode("default:grow(6)"),
				RowSpec.decode("default:grow"),}));
		
		weisseSteine = new LblStoneStack("weiss", view, 9);
		stoneField.add(weisseSteine, "1, 2, fill, fill");
		
		schwarzeSteine = new LblStoneStack("schwarz", view, 9);
		stoneField.add(schwarzeSteine, "1, 3, fill, fill");
		
		infoField = new InfoField(view, vActions);
		add(infoField, "3, 1, fill, fill");
		
		
		
		// Spielsteine initialisieren
		lblGameStone = new LblGameStone[3][3][3];
		
		// Liste für die Spielsteine initialisieren
		panelList = new ArrayList<LblGameStone>();
		
		// Labels für die Spielsteine einfügen
		generateJLabels();
	}
	
	
	/**
	 * Labels für Spielsteine erzeugen und auf dem Spielbrett einfügen
	 */
	private void generateJLabels(){
		int i = 3; // Hilfsvariable
		for(int e=0;e<3;e++){
			for(int x=0;x<3;x++){
				for(int y=0;y<3;y++){
					if(! (x==1 && y==1)){
						lblGameStone[e][x][y] = new LblGameStone(e+1, x+1, y+1, view, vActions);
						panelList.add(lblGameStone[e][x][y]);
						gameField.add(lblGameStone[e][x][y], (x*i+e+1)+", "+(y*i+e+1)+", fill, fill");
					}
				}
			}
			i--;
		}
	}	
	
	
	/**
	 * Gibt den graphischen Stack der Spielsteine zurück.
	 * 
	 * @param color String mit der Farbe des Stacks ("weiss" oder "schwarz")
	 * @return {@link LblStoneStack}
	 */
	protected LblStoneStack getStack(String color){
		switch (color) {
		case "weiss":
			return weisseSteine;
		
		case "schwarz":
			return schwarzeSteine;

		default:
			return null;
		}
	}
	
	
	
	/**
	 * Gibt den InputDialog zurück.
	 * 
	 * @return {@link InputDialog}
	 */
	public InputDialog getInputDialog(){
		return inputDialog;
	}
	
	
	/**
	 * Liefert das Label auf dem Spielstein anhand der angegbenen Position.
	 * 
	 * @param pos Position
	 */
	public LblGameStone getLabel(Position pos){
		return lblGameStone[pos.getEbene().getValue()-1][pos.getX().getValue()-1][pos.getY().getValue()-1];
	}
	
	
	/**
	 * Gibt eine {@link ArrayList} aller Spielsteinlabels zurück.
	 * 
	 * @return {@link ArrayList}
	 */
	public ArrayList<LblGameStone> getPanelList(){
		return panelList;
	}
	
	
	/**
	 * Prüft, ob Stack leer ist.
	 * 
	 * @param type Typ des Stacks ("schwarz" oder "weiss")
	 * @param weisseSteine2 
	 * @return {@link Boolean}
	 */
	public boolean isStackEmpty(String type){
		switch (type) {
		case "schwarz":
			if(schwarzeSteine.getCountStones() == 0)
				return true;
			else
				return false;
		case "weiss":
			if(weisseSteine.getCountStones() == 0)
				return true;
			else
				return false;
		default:
			return false;
		}
	}
	
	
	/**
	 * Diese Methode überprüft, ob irgendwelche Änderungen auf dem Spielbrett vorgenommen wurden.
	 * 
	 * @return {@link Boolean}
	 */
	public boolean anyChangesMade(){
		if(weisseSteine.getCountStones() < 9 || schwarzeSteine.getCountStones() < 9)
			return true;
		else
			return false;
	}
	
	
	/**
	 * Erhöht oder veringert einen Stack.
	 * 
	 * @param type Typ des Stacks ("schwarz" oder "weiss")
	 * @param weisseSteine2 
	 * @param change Nur 1 und -1 erlaubt
	 */
	public void updateStack(String type, int change){
		switch (type){
		case "schwarz":
			if(change >= 1)
				schwarzeSteine.setCountStones(schwarzeSteine.getCountStones() + 1);
			else
				schwarzeSteine.setCountStones(schwarzeSteine.getCountStones() - 1);
			break;
		case "weiss":
			if(change >= 1)
				weisseSteine.setCountStones(weisseSteine.getCountStones() + 1);
			else
				weisseSteine.setCountStones(weisseSteine.getCountStones() - 1);
			break;
		}
	}
	
	
	/**
	 * Aktualisiert den aktuellen Spieler auf dem InfoPanel
	 */
	public void updatePlayer(){
		infoField.updatePlayer();
	}
	
	
	/**
	 * Zeigt die Meldung auf dem {@link InfoField} an.
	 * 
	 * @param infoMessage
	 */
	public void info(String infoMessage){
		infoField.info(infoMessage);
	}
	
	
	/**
	 * Zeigt den GameOver-Bildschirm an.
	 * 
	 * @param winLose gibt an, ob gewonnen oder verloren wurde ("win" oder "lose")
	 * @param color die Farbe, die gewonnen/verloren hat ("weiss" oder "schwarz")
	 * @param gameMode Spielmodus ("PvE" oder "PvP")
	 */
	public void displayGameOver(String winLose, String color, String gameMode){
		this.winLose.showDialog(winLose, color, gameMode);
	}
	
	
	/**
	 * Dialog {@link Spielregeln} einblenden.
	 */
	public void openSpielregeln(){
		this.spielregeln.showDialog();
	}
	
	/**
	 * Dialog {@link Spielregeln} schließen.
	 */
	public void closeSpielregeln(){
		this.spielregeln.close();
	}
	
	
	/**
	 * Dialog {@link InputDialog} einblenden.
	 */
	public void openInputDialog(){
		this.inputDialog.showDialog();
	}
	
	/**
	 * Dialog {@link InputDialog} schließen.
	 */
	public void closeInputDialog(){
		this.inputDialog.close();
	}
	
	
	/**
	 * Dialog {@link GameDialog} einblenden.
	 */
	public void openDialog(String message){
		this.gameDialog.showDialog(message);
	}
	
	/**
	 * Dialog {@link GameDialog} ausblenden.
	 */
	public void hideDialog(){
		this.gameDialog.disappear();
	}
	
	/**
	 * Dialog {@link GameDialog} schließen.
	 */
	public void closeDialog(){
		this.gameDialog.close();
	}
	
	
	
	
	/**
	 * Spielbrettbild dynamisch auf das GamePanel zeichnen
	 * 
	 * @param g Graphics
	 */
    @Override
    public void paintComponent(Graphics g) {
    	// Hintergrundbild dynamisch zeichnen
        g.drawImage(view.getTheme().getSpielBrett(), 0, 0, getWidth(), getHeight(), this);
    }
    
    
    
    
    
    
    /**
     * Auf diesem {@link JLabel} werden die Bilder der Spielsteine angezeigt.
     * 
     * @author Ammon
     */
	public class LblGameStone extends JLabel implements ISpielstein{
		
		private Image steinImage;
		private Position pos;
		
		private View view;
		
		private String color,
					   type;
		
		private boolean removed;
		
		
		/**
		 * Konstruktor
		 * 
		 * @param color
		 * @param view
		 */
		public LblGameStone(String color, View view) {
			this(color, "", view);
		}
		
		/**
		 * Konstruktor
		 * 
		 * @param color
		 * @param type
		 * @param view
		 */
		public LblGameStone(String color, String type, View view){
			this.color = color;
			this.type = type;
			this.view = view;
		}
		
		/**
		 * Konstruktor
		 * 
		 * @param ebene
		 * @param x
		 * @param y
		 * @param view
		 * @param vActions
		 */
		public LblGameStone(int ebene, int x, int y, View view, GamePanelVA vActions) {
			this.view = view;
			newPosition(ebene, x, y);
			
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			addMouseListener(vActions.new lblGameStoneMouse());
		}
		
		
		
		/**
		 * Dynamisches Update der Bilder.
		 * 
		 * @param color
		 * @param type
		 */
		private void updateImage(String color, String type){
			switch (color) {
			case "weiss":
				if(type.isEmpty())
					steinImage = view.getTheme().getSpielSteinWeiss();
				else if(type.equals("gewaehlt"))
					steinImage = view.getTheme().getSpielSteinWeissGewaehlt();
				else if(type.equals("transparent"))
					steinImage = view.getTheme().getSpielSteinWeissTransparent();
				break;
				
			case "schwarz":
				if(type.isEmpty())
					steinImage = view.getTheme().getSpielSteinSchwarz();
				else if(type.equals("gewaehlt"))
					steinImage = view.getTheme().getSpielSteinSchwarzGewaehlt();
				else if(type.equals("transparent"))
					steinImage = view.getTheme().getSpielSteinSchwarzTransparent();
				break;
			}
		}
		
		
		/**
		 * Erzeugt ein neues {@link Position}s-Objekt aus {@link Integer}-Variablen.
		 * 
		 * @param ebene
		 * @param x
		 * @param y
		 */
		private void newPosition(int ebene, int x, int y){
			switch (ebene) {
			case 1:
				switch (x) {
				case 1:
					switch (y) {
					case 1:
						pos = new Position(EPositionIndex.Eins, EPositionIndex.Eins, EPositionIndex.Eins);
						break;
					case 2:
						pos = new Position(EPositionIndex.Eins, EPositionIndex.Eins, EPositionIndex.Zwei);
						break;
					case 3:
						pos = new Position(EPositionIndex.Eins, EPositionIndex.Eins, EPositionIndex.Drei);
						break;
					}
					break;
				case 2:
					switch (y) {
					case 1:
						pos = new Position(EPositionIndex.Eins, EPositionIndex.Zwei, EPositionIndex.Eins);
						break;
					case 2:
						pos = new Position(EPositionIndex.Eins, EPositionIndex.Zwei, EPositionIndex.Zwei);
						break;
					case 3:
						pos = new Position(EPositionIndex.Eins, EPositionIndex.Zwei, EPositionIndex.Drei);
						break;
					}
					break;
				case 3:
					switch (y) {
					case 1:
						pos = new Position(EPositionIndex.Eins, EPositionIndex.Drei, EPositionIndex.Eins);
						break;
					case 2:
						pos = new Position(EPositionIndex.Eins, EPositionIndex.Drei, EPositionIndex.Zwei);
						break;
					case 3:
						pos = new Position(EPositionIndex.Eins, EPositionIndex.Drei, EPositionIndex.Drei);
						break;
					}
					break;
				}
				break;
				
			case 2:
				switch (x) {
				case 1:
					switch (y) {
					case 1:
						pos = new Position(EPositionIndex.Zwei, EPositionIndex.Eins, EPositionIndex.Eins);
						break;
					case 2:
						pos = new Position(EPositionIndex.Zwei, EPositionIndex.Eins, EPositionIndex.Zwei);
						break;
					case 3:
						pos = new Position(EPositionIndex.Zwei, EPositionIndex.Eins, EPositionIndex.Drei);
						break;
					}
					break;
				case 2:
					switch (y) {
					case 1:
						pos = new Position(EPositionIndex.Zwei, EPositionIndex.Zwei, EPositionIndex.Eins);
						break;
					case 2:
						pos = new Position(EPositionIndex.Zwei, EPositionIndex.Zwei, EPositionIndex.Zwei);
						break;
					case 3:
						pos = new Position(EPositionIndex.Zwei, EPositionIndex.Zwei, EPositionIndex.Drei);
						break;
					}
					break;
				case 3:
					switch (y) {
					case 1:
						pos = new Position(EPositionIndex.Zwei, EPositionIndex.Drei, EPositionIndex.Eins);
						break;
					case 2:
						pos = new Position(EPositionIndex.Zwei, EPositionIndex.Drei, EPositionIndex.Zwei);
						break;
					case 3:
						pos = new Position(EPositionIndex.Zwei, EPositionIndex.Drei, EPositionIndex.Drei);
						break;
					}
					break;
				}
				break;
				
			case 3:
				switch (x) {
				case 1:
					switch (y) {
					case 1:
						pos = new Position(EPositionIndex.Drei, EPositionIndex.Eins, EPositionIndex.Eins);
						break;
					case 2:
						pos = new Position(EPositionIndex.Drei, EPositionIndex.Eins, EPositionIndex.Zwei);
						break;
					case 3:
						pos = new Position(EPositionIndex.Drei, EPositionIndex.Eins, EPositionIndex.Drei);
						break;
					}
					break;
				case 2:
					switch (y) {
					case 1:
						pos = new Position(EPositionIndex.Drei, EPositionIndex.Zwei, EPositionIndex.Eins);
						break;
					case 2:
						pos = new Position(EPositionIndex.Drei, EPositionIndex.Zwei, EPositionIndex.Zwei);
						break;
					case 3:
						pos = new Position(EPositionIndex.Drei, EPositionIndex.Zwei, EPositionIndex.Drei);
						break;
					}
					break;
				case 3:
					switch (y) {
					case 1:
						pos = new Position(EPositionIndex.Drei, EPositionIndex.Drei, EPositionIndex.Eins);
						break;
					case 2:
						pos = new Position(EPositionIndex.Drei, EPositionIndex.Drei, EPositionIndex.Zwei);
						break;
					case 3:
						pos = new Position(EPositionIndex.Drei, EPositionIndex.Drei, EPositionIndex.Drei);
						break;
					}
					break;
				}
				break;
			}
		}
		
		
		
		
		/**
		 * Liefert die Position des Labels auf dem Spielbrett.
		 * 
		 * @return Position
		 */
		public Position getPosition(){
			return pos;
		}
		
		
		/**
		 * Gibt die Spielsteinfarbe des {@link JLabel}s zurück
		 * 
		 * @return {@link ESpielsteinFarbe}
		 */
		@Override
		public ESpielsteinFarbe getFarbe() {
			if(color.equals("weiss"))
				return ESpielsteinFarbe.WEISS;
			else if(color.equals("schwarz"))
				return ESpielsteinFarbe.SCHWARZ;
			
			return null;
		}
		
		
		/**
		 * Weist dem Stein ein bestimmtes Bild zu.
		 * Dadurch wird der Stein sichtbar.
		 * 
		 * @param image Bild, das auf dem Label gezeichnet werden soll
		 */
		public void setImage(String color){
			setImage(color, "");
		}
		
		public void setImage(String color, String type){
			this.color = color;
			this.type = type;
			removed = false;
			
			repaint();
		}
		
		
		/**
		 * Entfernt das aktuelle Bild vom Label.
		 * Dadurch wird es unsichtbar.
		 */
		public void removeImage(){
			this.steinImage = null;
			removed = true;
			
			repaint();
		}
		
		
		/**
		 * Bild dynamisch auf den Stein zeichnen.
		 */
		@Override
		public void paintComponent(Graphics g) {
			if((color != null || type != null) && !removed){
				updateImage(color, type);
			}
			
			// Bild dynamisch zeichnen
			g.drawImage(steinImage, 0, 0, getWidth(), getHeight(), this);
		}
	}
	
	
	/**
	 * Stapel von Spielsteinen am Rand des Spielbretts.
	 * Dient zur besseren Übersicht, wie viele Steine der Spieler noch setzen kann.
	 * 
	 * @author Ammon
	 */
	private class LblStoneStack extends JLabel{
		
		private Image gameStoneImage;
		private int remainingStones; // Anzahl der noch nicht gesetzten Spielsteine
		private String color,
					   type;
		
		private View view;
		
		
		/**
		 * Konstruktor
		 * 
		 * @param color
		 * @param view
		 * @param remainingStones
		 */
		public LblStoneStack(String color, View view, int remainingStones) {
			this(color, "", view, remainingStones);
		}
		
		/**
		 * Konstruktor
		 * 
		 * @param color
		 * @param type
		 * @param view
		 * @param remainingStones
		 */
		public LblStoneStack(String color, String type, View view, int remainingStones){
			this.color = color;
			this.type = type;
			this.view = view;
			updateImage(color, type);
			setCountStones(remainingStones);
		}
		
		
		/**
		 * Dynamisches Update der Bilder.
		 * 
		 * @param color
		 * @param type
		 */
		private void updateImage(String color, String type){
			switch (color) {
			case "weiss":
				if(type.isEmpty())
					gameStoneImage = view.getTheme().getSpielSteinWeiss();
				else if(type.equals("gewaehlt"))
					gameStoneImage = view.getTheme().getSpielSteinWeissGewaehlt();
				else if(type.equals("transparent"))
					gameStoneImage = view.getTheme().getSpielSteinWeissTransparent();
				break;
				
			case "schwarz":
				if(type.isEmpty())
					gameStoneImage = view.getTheme().getSpielSteinSchwarz();
				else if(type.equals("gewaehlt"))
					gameStoneImage = view.getTheme().getSpielSteinSchwarzGewaehlt();
				else if(type.equals("transparent"))
					gameStoneImage = view.getTheme().getSpielSteinSchwarzTransparent();
				break;
			}
		}
		
		
		/**
		 * Setzt die Anzahl der noch nicht gesetzten Spielsteine.
		 * 
		 * @param count Anzehl der noch nicht gestzten Spielsteine
		 */
		public void setCountStones(int count){
			this.remainingStones = count;
			repaint(); // Zeichnung updaten
		}
		
		
		/**
		 * Liefert die Anzahl der noch nicht gesetzten Spielsteine.
		 * 
		 * @return count Anzehl der noch nicht gestzten Spielsteine
		 */
		public int getCountStones(){
			return remainingStones;
		}
		
		
		/**
		 * Stapel an noch nicht gesetzten Steinen zeichnen.
		 */
		@Override
		public void paintComponent(Graphics g) {
			// Bild auf aktuelle Theme aktualisieren
			updateImage(color, type);
			
			// Höhe und Breite berechnen
			int h = getHeight()/4;
			int w = (int) (getWidth()*((double) h / (double) getWidth()));
			
			// Bild dynamisch zeichnen
			for(int i=0;i<remainingStones;i++){
				if(i>=4 && i<7){
					g.drawImage(gameStoneImage, getWidth()*15/100 +7, ((i-4)*h)+h/2, w-10, h-10, this);
					continue;
				}
				
				if(i>=7){
					g.drawImage(gameStoneImage, getWidth()*15/100 +7, ((i-7)*h)+h/2+h/2, w-10, h-10, this);
					continue;
				}
				
				g.drawImage(gameStoneImage, getWidth()*15/100 +7, i*h, w-10, h-10, this);
			}
		}
	}
	
	
	
	/**
	 * Ein {@link JPanel} neben dem Spielbrett, auf dem Informationen, wie welcher Spieler gerade am Zug ist
	 * oder ob jemand eine Mühle hat.
	 * Außerdem werden noch zwei {@link MillButton}s angelegt, um das Spiel neu zu starten und um ins Menü zurück zu kehren.
	 * 
	 * @author Ammon
	 */
	private class InfoField extends JPanel{
		
		private JTextArea logPane;
		private LblGameStone lblSpielSteinSpieler1,
							 lblSpielSteinSpieler2;
		private JLabel lblSpielerDran;
		
		
		/**
		 * Konstruktor
		 * 
		 * @param view
		 * @param vActions
		 */
		public InfoField(View view, GamePanelVA vActions) {setOpaque(false);
			
			setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("51px:grow"),
					ColumnSpec.decode("max(183px;default):grow(6)"),
					ColumnSpec.decode("66px:grow(2)"),},
				new RowSpec[] {
					RowSpec.decode("max(198px;default):grow(3)"),
					RowSpec.decode("max(183px;default):grow(3)"),
					RowSpec.decode("max(219px;default):grow(3)"),}));
			
			JPanel infoPanel = new JPanel();
			infoPanel.setOpaque(false);
			infoPanel.setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("max(51px;default):grow"),
					ColumnSpec.decode("max(85px;default):grow"),
					ColumnSpec.decode("20px"),
					ColumnSpec.decode("max(85px;default):grow"),
					ColumnSpec.decode("max(66px;default):grow"),},
				new RowSpec[] {
					RowSpec.decode("max(38px;default):grow(2)"),
					RowSpec.decode("max(85px;default):grow(25)"),
					FormFactory.UNRELATED_GAP_ROWSPEC,
					RowSpec.decode("max(20px;default)"),
					RowSpec.decode("max(41px;default):grow(50)"),}));
			add(infoPanel, "1, 1, 3, 1, fill, fill");
			
				lblSpielSteinSpieler1 = new LblGameStone("weiss", view);
				infoPanel.add(lblSpielSteinSpieler1, "2, 2, fill, fill");
				
				lblSpielSteinSpieler2 = new LblGameStone("schwarz", view);
				infoPanel.add(lblSpielSteinSpieler2, "4, 2, fill, fill");
				
				lblSpielerDran = new JLabel();
				infoPanel.add(lblSpielerDran, "2, 4, 3, 1, center, fill");
			
				
			
			logPane = new JTextArea();
			logPane.setLineWrap(true);
			logPane.setWrapStyleWord(true);
			logPane.setOpaque(false);
			logPane.setEditable(false);
			
			final JScrollPane logScroller = new JScrollPane();
			
			logScroller.setOpaque(false);
			logScroller.getViewport().setOpaque(false);
			logScroller.setViewportView(logPane);
			logScroller.setBorder(null);
			
			final JPanel logWrapper = new JPanel();
			logWrapper.addHierarchyBoundsListener(new HierarchyBoundsListener() {
				@Override
				public void ancestorResized(HierarchyEvent e) {
					logScroller.setBounds(5, 0, logWrapper.getWidth()-10, logWrapper.getHeight());
				}
				
				@Override
				public void ancestorMoved(HierarchyEvent e) {}
			});
			logWrapper.setLayout(null);
			logWrapper.setOpaque(false);
			logWrapper.add(logScroller);
			add(logWrapper, "2, 2, fill, fill");
			
			
			
			JPanel buttonPanel = new JPanel();
			buttonPanel.setOpaque(false);
			buttonPanel.setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("51px"),
					ColumnSpec.decode("default:grow"),
					ColumnSpec.decode("max(48px;default)"),
					ColumnSpec.decode("max(52px;default)"),
					ColumnSpec.decode("max(49px;default)"),
					ColumnSpec.decode("default:grow"),
					ColumnSpec.decode("max(66px;default)"),},
				new RowSpec[] {
					RowSpec.decode("default:grow(25)"),
					RowSpec.decode("max(52px;default)"),
					FormFactory.RELATED_GAP_ROWSPEC,
					RowSpec.decode("max(52px;default)"),
					FormFactory.RELATED_GAP_ROWSPEC,
					RowSpec.decode("max(52px;default)"),
					RowSpec.decode("max(35px;default):grow"),}));
			add(buttonPanel, "1, 3, 3, 1, fill, fill");
			
				MillButton btnHilfe = new MillButton(view, "Hilfe");
				btnHilfe.setPreferredSize(new Dimension(0, 0));
				btnHilfe.addActionListener(vActions.new infoFieldBtnHilfe());
				buttonPanel.add(btnHilfe, "4, 2, fill, fill");
			
				MillButton btnNeustart = new MillButton(view, "Neustart");
				btnNeustart.addActionListener(vActions.new infoFieldBtnNeustart());
				buttonPanel.add(btnNeustart, "3, 4, 3, 1, fill, fill");
				
				MillButton btnBack = new MillButton(view, "ZumMenue");
				btnBack.addActionListener(vActions.new infoFieldBtnBack());
				buttonPanel.add(btnBack, "3, 6, 3, 1, fill, fill");
		}
		
		
		
		/**
		 * Setzt alle Labels so, dass der aktuelle Spieler hervorgehoben wird.
		 */
		public void updatePlayer(){
			lblSpielerDran.setFont(view.getTheme().getFont().deriveFont(Font.BOLD, 18));
			lblSpielerDran.setForeground(view.getTheme().getFontColor());
			logPane.setForeground(view.getTheme().getFontColor());
			
			if(view.getViewController().getCore().isWeissDran() && !view.getViewController().getCore().isSchwarzDran()){
				lblSpielSteinSpieler1.setImage("weiss");
				lblSpielSteinSpieler2.setImage("schwarz", "transparent");
				lblSpielerDran.setText(inputDialog.getSpielerName1());
			}else{
				lblSpielSteinSpieler1.setImage("weiss", "transparent");
				lblSpielSteinSpieler2.setImage("schwarz");
				lblSpielerDran.setText(inputDialog.getSpielerName2());
			}
		}
		
		
		
		/**
		 * Fügt einen Text zur TextArea hinzu.
		 * 
		 * @param infoMessage
		 */
		public void info(String infoMessage){
			logPane.append(infoMessage + "\n");
			repaint();
		}
	}
	
	
	
	/**
	 * Dialog, der es ermöglicht, die aufgerufene Aktion zu widerrufen.
	 * 
	 * @author Ammon
	 */
	private class GameDialog extends DialogBackgroundPanel{
		
		private JLabel dialogMessage;
		
		
		/**
		 * Konstruktor
		 * 
		 * @param view
		 * @param vActions
		 */
		public GameDialog(View view, GamePanelVA vActions) {
			super(view, vActions);
			
			setDialogSize(375, 200);
			
			dialog.setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("max(20px;default)"),
					ColumnSpec.decode("max(159px;default)"),
					ColumnSpec.decode("default:grow"),
					ColumnSpec.decode("max(159px;default)"),
					ColumnSpec.decode("max(20px;default)"),},
				new RowSpec[] {
					RowSpec.decode("3dlu:grow"),
					RowSpec.decode("max(52px;default)"),
					RowSpec.decode("max(20px;default)"),}));
			
			dialogMessage = new JLabel();
			dialog.add(dialogMessage, "2, 1, 3, 1, center, fill");
			
			MillButton btnOK = new MillButton(view, "OK");
			btnOK.addActionListener(vActions.new dialogBtnOK());
			dialog.add(btnOK, "2, 2, fill, fill");
			
			MillButton btnAbbrechen = new MillButton(view, "Abbrechen");
			btnAbbrechen.addActionListener(vActions.new dialogBtnAbbrechen());
			dialog.add(btnAbbrechen, "4, 2, fill, fill");
		}
		
		
		/**
		 * Zeigt den Dialog mit dem übergebenen {@link String} als Nachricht an.
		 * 
		 * @param message
		 */
		public void showDialog(final String message){
			dialogMessage.setText(message);
			
			super.showDialog();
		}
		
		
		
		/**
		 * Updated alle themenrelevanten Variablen bei einem repaint();
		 */
		@Override
		public void paintComponent(Graphics g) {
			setDialogBackground(view.getTheme().getDialogHintergrund());
		
			super.paintComponent(g);
			
			dialogMessage.setFont(font.deriveFont(Font.BOLD, 20));
			dialogMessage.setForeground(view.getTheme().getFontColor());
		}
	}
	
	
	
	/**
	 * Eine Erweiterung des Standarddialogs.
	 * Bei diesem Dialog können die Namen der Spieler (PvP) und die Farbe des Spielers (PvE) festgelegt werden.
	 * 
	 * @author Ammon
	 */
	public class InputDialog extends DialogBackgroundPanel{
		
		private JTextField spieler1,
						   spieler2;
		
		private JLabel lblNameSpieler1,
					   lblNameSpieler2;
		
		private LblGameStone lblInputDialogSpielstein;
		

		/**
		 * Kostruktor
		 * 
		 * @param view
		 * @param vActions
		 */
		public InputDialog(View view, GamePanelVA vActions) {
			super(view, vActions);
			
			setDialogSize(375, 200);
			
			dialog.setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("max(20px;default)"),
					ColumnSpec.decode("max(88px;default)"),
					ColumnSpec.decode("max(70px;default)"),
					ColumnSpec.decode("max(19px;default)"),
					ColumnSpec.decode("max(44px;default)"),
					ColumnSpec.decode("max(70px;default)"),
					ColumnSpec.decode("max(44px;default)"),
					ColumnSpec.decode("max(20px;default)"),},
				new RowSpec[] {
					RowSpec.decode("max(20px;default)"),
					RowSpec.decode("max(28px;default)"),
					RowSpec.decode("max(70px;default)"),
					FormFactory.UNRELATED_GAP_ROWSPEC,
					RowSpec.decode("max(52px;default)"),
					RowSpec.decode("max(20px;default)"),}));
			
			lblNameSpieler1 = new JLabel();
			dialog.add(lblNameSpieler1, "2, 2, 2, 1, center, bottom");
			
			lblNameSpieler2 = new JLabel();
			dialog.add(lblNameSpieler2, "5, 2, 3, 1, center, bottom");
						
			spieler1 = new JTextField("Spieler 1");
			spieler1.setForeground(Color.GRAY);
			spieler1.addFocusListener(vActions.new advancedTextFieldAdapter(spieler1.getText()));
			spieler1.addKeyListener(vActions.new advancedTextFieldAdapter(spieler1.getText()));
			dialog.add(spieler1, "2, 3, 2, 1, fill, center");
			
			spieler2 = new JTextField("Spieler 2");
			spieler2.setForeground(Color.GRAY);
			spieler2.addFocusListener(vActions.new advancedTextFieldAdapter(spieler2.getText()));
			spieler2.addKeyListener(vActions.new advancedTextFieldAdapter(spieler2.getText()));
			
			lblInputDialogSpielstein = new LblGameStone("weiss", view);
			lblInputDialogSpielstein.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblInputDialogSpielstein.addMouseListener(vActions.new LblInputDialogSpielsteinMouse());
			
			MillButton btnOK = new MillButton(view, "OK");
			btnOK.addActionListener(vActions.new inputDialogBtnOK());
			dialog.add(btnOK, "3, 5, 3, 1, fill, fill");
		}
		
		
		/**
		 * Updated alle relevanten Labels in dem Dialog.
		 */
		private void updateInputDialog(){
			lblNameSpieler1.setFont(font.deriveFont(Font.BOLD, 15));
			lblNameSpieler1.setForeground(view.getTheme().getFontColor());
			lblNameSpieler2.setFont(font.deriveFont(Font.BOLD, 15));
			lblNameSpieler2.setForeground(view.getTheme().getFontColor());
			
			if(view.getGlobalVA().getGamePanelVA().isPvE()){
				lblNameSpieler1.setText("Name des Spielers:");
				lblNameSpieler2.setText("Spielsteinfarbe:");
				
				if(spieler2.isVisible()){
					remove(spieler2);
					dialog.add(lblInputDialogSpielstein, "6, 3, fill, fill");
				}
			}else{
				lblNameSpieler1.setText("Name Spieler 1:");
				lblNameSpieler2.setText("Name Spieler 2:");
				
				if(lblInputDialogSpielstein.isVisible()){
					remove(lblInputDialogSpielstein);
					dialog.add(spieler2, "5, 3, 3, 1, fill, center");
				}
			}
		}
		
		
		/**
		 * Gibt den Namen des ersten Spielers zurück (Aus dem {@link JTextField}).
		 * 
		 * @return {@link String}
		 */
		public String getSpielerName1(){
			return spieler1.getText();
		}
		
		/**
		 * Setzt den Namen des ersten Spielers (Auf das {@link JTextField}).
		 * 
		 * @param text
		 */
		public void setSpielerName1(String text){
			spieler1.setText(text);
		}
		
		
		/**
		 * Gibt den Namen des zweiten Spielers zurück (Aus dem {@link JTextField}).
		 * 
		 * @return {@link String}
		 */
		public String getSpielerName2(){
			return spieler2.getText();
		}
		
		/**
		 * Setzt den Namen des zweiten Spielers (Auf das {@link JTextField}).
		 * 
		 * @param text
		 */
		public void setSpielerName2(String text){
			spieler2.setText(text);
		}
		
		
		/**
		 * Gibt die gewählte Farbe des Spielers zurück.
		 * 
		 * @return {@link ESpielsteinFarbe}
		 */
		public ESpielsteinFarbe getSpielerFarbe(){
			return lblInputDialogSpielstein.getFarbe();
		}
		
		
		
		/**
		 * Zeigt den Dialog an und setzt den Focus auf das erste {@link JTextField}.
		 */
		@Override
		public void showDialog(){
			super.showDialog();
			
			spieler1.requestFocusInWindow();
		}
		
		
		/**
		 * Zeichnet den Dialog neu.
		 */
		@Override
		public void paintComponent(Graphics g) {
			setDialogBackground(view.getTheme().getDialogHintergrund());
			
			updateInputDialog();
			
			super.paintComponent(g);
		}
	}
	
	
	
	/**
	 * Dieser Dialog zeigt das Gewinner-/Verliererbild über dem Spielbrett.
	 * 
	 * @author Ammon
	 */
	private class WinLose extends DialogBackgroundPanel{
				
		private Image winLoseImage;
		
		private String winLose,
					   color,
					   gameMode;
		
		private Sounds endSound;
		
		
		/**
		 * Kostruktor
		 * 
		 * @param view
		 * @param vActions
		 */
		public WinLose(View view, GamePanelVA vActions) {
			super(view, vActions);
			
			dialog.setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("4dlu:grow(3)"),
					ColumnSpec.decode("max(159px;default)"),
					ColumnSpec.decode("4dlu:grow"),
					ColumnSpec.decode("max(159px;default)"),
					ColumnSpec.decode("4dlu:grow(3)"),},
				new RowSpec[] {
					RowSpec.decode("3dlu:grow"),
					RowSpec.decode("max(52px;default)"),
					RowSpec.decode("20px"),}));
			
			MillButton btnBack = new MillButton(view, "ZumMenue");
			btnBack.addActionListener(vActions.new winLoseBtnBack());
			dialog.add(btnBack, "2, 2, fill, fill");
			
			MillButton btnNeustart = new MillButton(view, "Neustart");
			btnNeustart.addActionListener(vActions.new winLoseBtnNeustart());
			dialog.add(btnNeustart, "4, 2, fill, fill");
		}
		
		
		/**
		 * Aktualisiert das Sieger-/Verliererbild auf das aktuelle Theme.
		 * 
		 * @param winLose
		 * @param color
		 * @param gameMode
		 */
		private void updateImage(String winLose, String color, String gameMode){
			switch (winLose) {
			case "win":
				endSound = Sounds.winner;
				
				switch (color) {
				case "weiss":
					if(gameMode.equals("PvE"))
						winLoseImage = view.getTheme().getSiegerPvEWeiss();
					else if(gameMode.equals("PvP"))
						winLoseImage = view.getTheme().getSiegerPvPWeiss();
					break;

				case "schwarz":
					if(gameMode.equals("PvE"))
						winLoseImage = view.getTheme().getSiegerPvESchwarz();
					else if(gameMode.equals("PvP"))
						winLoseImage = view.getTheme().getSiegerPvPSchwarz();
					break;
				}
				break;
			case "lose":
				endSound = Sounds.loser;
				
				winLoseImage = view.getTheme().getVerlierer();
				break;
			}
		}
		
		
		/**
		 * Zeigt den Dialog samt dem Gewinner-/verliererbild an.
		 * 
		 * @param winLose
		 * @param color
		 * @param gameMode
		 */
		public void showDialog(String winLose, String color, String gameMode){
			this.winLose = winLose;
			this.color = color;
			this.gameMode = gameMode;
			
			updateImage(winLose, color, gameMode);
			setDialogSize(getSize().width-1, getSize().height-1);
			
			view.getTheme().playSound(endSound);
			
			showDialog();
		}
		
		
		
		/**
		 * Zeichnet das Gewinner-/Verliererbild neu.
		 */
		@Override
		public void paintComponent(Graphics g) {
			updateImage(winLose, color, gameMode);
			
			super.paintComponent(g);
			
			// Bild dynamisch zeichnen
			g.drawImage(winLoseImage, 0, 0, getWidth(), getHeight(), this);
		}
	}
}