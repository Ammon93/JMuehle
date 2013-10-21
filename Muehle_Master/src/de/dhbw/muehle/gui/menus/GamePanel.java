package de.dhbw.muehle.gui.menus;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.dhbw.muehle.gui.MillButton;
import de.dhbw.muehle.gui.View;
import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.viewactions.GamePanelVA;
import de.dhbw.muehle.model.spielstein.Position;

public class GamePanel extends Menu {
	
	private JPanel gameField;
	private InfoField infoField;
	private WinLose winLose;
	
	private LblGameStone lblGameStone[][][];
	private LblStoneStack schwarzeSteine;
	private LblStoneStack weisseSteine;
	
	private GamePanelVA vActions;
	
	private View view;
	
	private ArrayList<LblGameStone> panelList;
	
	
	public GamePanel(ViewController vController, View view) {
		super(vController, view);
		this.view = view;
		
		// Listener initialisieren
		vActions = new GamePanelVA(vController);
		
		
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(597px;default):grow(62)"),
				ColumnSpec.decode("max(103px;default):grow(12)"),
				ColumnSpec.decode("max(300px;default):grow(29)"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),}));
		
		
		winLose = new WinLose(view);
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
		
		weisseSteine = new LblStoneStack(view, "weiss", 9);
		stoneField.add(weisseSteine, "1, 2, fill, fill");
		
		schwarzeSteine = new LblStoneStack(view, "schwarz", 9);
		stoneField.add(schwarzeSteine, "1, 3, fill, fill");
		
		infoField = new InfoField(view);
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
						lblGameStone[e][x][y] = new LblGameStone(e+1, x+1, y+1, vActions);
						panelList.add(lblGameStone[e][x][y]);
						gameField.add(lblGameStone[e][x][y], (x*i+e+1)+", "+(y*i+e+1)+", fill, fill");
					}
				}
			}
			i--;
		}
	}
	
	
	/**
	 * Liefert das Label auf dem Spielstein anhand der angegbenen Position
	 * @param pos Position
	 */
	public JLabel getLabel(Position pos){
		return lblGameStone[pos.getEbene().getValue()-1][pos.getX().getValue()-1][pos.getY().getValue()-1];
	}
	
	
	public ArrayList<LblGameStone> getPanelList(){
		return panelList;
	}
	
	
	/**
	 * Prüft, ob Stack leer ist
	 * @param type Typ des Stacks ("schwarz" oder "weiss")
	 * @param weisseSteine2 
	 * @return true/false
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
	 * Erhöht oder veringert einen Stack
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
	
	
	public void changePlayer(){
		infoField.changePlayer();
	}
	
	
	public void info(String infoMessage){
		infoField.info(infoMessage);
	}
	
	
	/**
	 * Zeigt den GameOver-Bildschirm an
	 * 
	 * @param winLose gibt an, ob gewonnen oder verloren wurde ("win" oder "lose")
	 * @param color die Farbe, die gewonnen/verloren hat ("weiss" oder "schwarz")
	 * @param gameMode Spielmodus ("PvE" oder "PvP")
	 */
	public void displayGameOver(String winLose, String color, String gameMode){
		this.winLose.setImage(winLose, color, gameMode);
		this.winLose.setVisible(true);
	}
	
	
	
	/**
	 * Spielbrettbild dynamisch auf das GamePanel zeichnen
	 * @param g Graphics
	 */
    @Override
    public void paintComponent(Graphics g) {
    	// Hintergrundbild dynamisch zeichnen
        g.drawImage(view.getTheme().getSpielBrett(), 0, 0, getWidth(), getHeight(), this);
    }
    
    
    
    
    
    
	public class LblGameStone extends JLabel{
		
		private Image image;
		private Position pos;
		
		
		public LblGameStone(){}
		
		public LblGameStone(int ebene, int x, int y, GamePanelVA vActions) {	
			pos = new Position(ebene, x, y);
			
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			addMouseListener(vActions.new lblGameStoneMouse());
		}
		
		
		/**
		 * Liefert die Position des Labels auf dem Spielbrett
		 * @return Position
		 */
		public Position getPosition(){
			return pos;
		}
		
		
		/**
		 * Weist dem Stein ein bestimmtes Bild zu
		 * <br/>Dadurch wird der Stein sichtbar
		 * @param image Bild, das auf dem Label gezeichnet werden soll
		 */
		public void setImage(Image image){
			this.image = image;
			repaint();
		}
		
		
		/**
		 * Entfernt das aktuelle Bild vom Label
		 * <br/>Dadurch wird es unsichtbar
		 */
		public void removeImage(){
			this.image = null;
			repaint();
		}
		
		
		/**
		 * Bild dynamisch auf den Stein zeichnen
		 */
		@Override
		public void paintComponent(Graphics g) {
			// Bild dynamisch zeichnen
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
	
	
	private class LblStoneStack extends JLabel{
		
		private Image gameStoneImage;
		private int remainingStones; // Anzahl der noch nicht gesetzten Spielsteine
		private String type;
		
		private View view;
		
		
		public LblStoneStack(View view, String type, int remainingStones) {
			this.view = view;
			this.type = type;
			setImage(type);
			setCountStones(remainingStones);
		}
		
		
		/**
		 * Die Farbe für den Spielsteinstapel setzen
		 * @param type Typ des Spielsteins ("schwarz" oder "weiß")
		 */
		public void setImage(String type){
			switch (type) {
			case "weiss":
				gameStoneImage = view.getTheme().getSpielSteinWeiss();
				break;
			case "schwarz":
				gameStoneImage = view.getTheme().getSpielSteinSchwarz();
				break;
			}
		}
		
		
		/**
		 * Setzt die Anzahl der noch nicht gesetzten Spielsteine
		 * @param count Anzehl der noch nicht gestzten Spielsteine
		 */
		public void setCountStones(int count){
			this.remainingStones = count;
			repaint(); // Zeichnung updaten
		}
		
		
		/**
		 * Liefert die Anzahl der noch nicht gesetzten Spielsteine
		 * @return count Anzehl der noch nicht gestzten Spielsteine
		 */
		public int getCountStones(){
			return remainingStones;
		}
		
		
		/**
		 * Stapel an noch nicht gesetzten Steinen zeichnen
		 */
		@Override
		public void paintComponent(Graphics g) {
			// Bild auf aktuelle Theme aktualisieren
			setImage(type);
			
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
	
	
	
	private class InfoField extends JPanel{
		
		private View view;
		
		private JTextArea logPane;
		private LblGameStone lblSpielSteinSpieler1,
							 lblSpielSteinSpieler2;
		private JLabel lblSpieler1,
					   lblSpieler2;
		
		private String Spieler1Name,
					   Spieler2Name;
		
		private boolean weissDran = true; // Weiß beginnt immer
		
		
		public InfoField(View view) {
			this.view = view;
			
			setOpaque(false);
			
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
			
				lblSpielSteinSpieler1 = new LblGameStone();
				infoPanel.add(lblSpielSteinSpieler1, "2, 2, fill, fill");
				
				lblSpielSteinSpieler2 = new LblGameStone();
				infoPanel.add(lblSpielSteinSpieler2, "4, 2, fill, fill");
				
				lblSpieler1 = new JLabel();
				infoPanel.add(lblSpieler1, "2, 4, center, fill");
				
				lblSpieler2 = new JLabel();
				infoPanel.add(lblSpieler2, "4, 4, center, fill");
				
				changePlayer();
			
				
			
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
					ColumnSpec.decode("4dlu:grow"),
					ColumnSpec.decode("max(159px;default)"),
					ColumnSpec.decode("4dlu:grow"),
					ColumnSpec.decode("max(66px;default)"),},
				new RowSpec[] {
					RowSpec.decode("default:grow(25)"),
					RowSpec.decode("max(52px;default)"),
					FormFactory.UNRELATED_GAP_ROWSPEC,
					RowSpec.decode("max(52px;default)"),
					RowSpec.decode("max(38px;default):grow"),}));
			add(buttonPanel, "1, 3, 3, 1, fill, fill");
			
				MillButton btnNeustart = new MillButton(view, "Neustart");
				buttonPanel.add(btnNeustart, "3, 2, fill, fill");
				
				MillButton btnBack = new MillButton(view, "ZumMenue");
				buttonPanel.add(btnBack, "3, 4, fill, fill");
		}
		
		
		
		public void setSpielerNamen(String spieler1, String spieler2){
			lblSpieler1.setText(spieler1);
			lblSpieler2.setText(spieler2);
		}
		
		
		public void info(String infoMessage){
			logPane.append(infoMessage);
		}
		
		
		public void changePlayer(){
			if(weissDran){
				lblSpielSteinSpieler1.setImage(view.getTheme().getSpielSteinWeiss());
				lblSpielSteinSpieler2.setImage(view.getTheme().getSpielSteinSchwarzTransparent());
				
				lblSpieler1.setFont(new Font("Arial", Font.BOLD, 14));
				lblSpieler2.setFont(new Font("Arial", Font.PLAIN, 14));
				
				weissDran = false;
			}else{
				lblSpielSteinSpieler1.setImage(view.getTheme().getSpielSteinWeissTransparent());
				lblSpielSteinSpieler2.setImage(view.getTheme().getSpielSteinSchwarz());
				
				lblSpieler1.setFont(new Font("Arial", Font.PLAIN, 14));
				lblSpieler2.setFont(new Font("Arial", Font.BOLD, 14));
				
				weissDran = true;
			}
		}
	}
	
	
	
	private class WinLose extends JPanel{
		
		private View view;
		
		private Image winLoseImage;
		
		
		public WinLose(View view) {
			this.view = view;
			
			setOpaque(false);
			setVisible(false);
			
			setLayout(new FormLayout(new ColumnSpec[] {
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
			add(btnBack, "2, 2, fill, fill");
			
			MillButton btnNeustart = new MillButton(view, "Neustart");
			add(btnNeustart, "4, 2, fill, fill");
		}
		
		
		public void setImage(String winLose, String color, String gameMode){
			switch (winLose) {
			case "win":
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
				winLoseImage = view.getTheme().getVerlierer();
				break;
			}
			
			repaint();
		}
		
		
		
		@Override
		public void paintComponent(Graphics g) {
			// Bild dynamisch zeichnen
			g.drawImage(winLoseImage, 0, 0, getWidth(), getHeight(), this);
		}
	}
}