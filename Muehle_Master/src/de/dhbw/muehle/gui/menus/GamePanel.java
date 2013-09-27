package de.dhbw.muehle.gui.menus;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.viewactions.GamePanelVA;
import de.dhbw.muehle.model.spielstein.Position;
import de.dhbw.muehle.model.theme.Theme;

public class GamePanel extends JPanel {

	private Image background;
	private JPanel gameField;
	private LblGameStone lblGameStone[][][];
	private LblStoneStack lblStonesMe,
				   		  lblStonesEnemy;
	
	private GamePanelVA vActions;
	
	public GamePanel(ViewController vController, Theme theme) {
		// Listener initialisieren
		vActions = new GamePanelVA(vController);
		
		// Panelgröße festlegen
		setSize(705, 600);
		
		
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1dlu:grow(6)"),
				ColumnSpec.decode("1dlu:grow"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),}));
		
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
		
		lblStonesEnemy = new LblStoneStack();
		stoneField.add(lblStonesEnemy, "1, 2, fill, fill");
		lblStonesEnemy.setImage(theme.getSpielSteinWeiss());
		lblStonesEnemy.setCountStones(9);
		
		lblStonesMe = new LblStoneStack();
		stoneField.add(lblStonesMe, "1, 3, fill, fill");
		lblStonesMe.setImage(theme.getSpielSteinSchwarz());
		lblStonesMe.setCountStones(9);
		
		
		
		// Spielsteine initialisieren
		lblGameStone = new LblGameStone[3][3][3];
		
		// Labels für die Spielsteine einfügen
		generateJLabels();
		
		// Theme anwenden
		this.setTheme(theme);
	}
	
	
	/**
	 * Labels für Spielsteine erzeugen und auf dem Spielbrett einfügen
	 */
	private void generateJLabels(){
		int i = 3;
		for(int e=0;e<3;e++){
			for(int x=0;x<3;x++){
				for(int y=0;y<3;y++){
					if(! (x==1 && y==1)){
						lblGameStone[e][x][y] = new LblGameStone();
						lblGameStone[e][x][y].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						lblGameStone[e][x][y].addMouseListener(vActions.new lblGameStoneMouse());
						gameField.add(lblGameStone[e][x][y], (x*i+e+1)+", "+(y*i+e+1)+", fill, fill");
					}
				}
			}
			i--;
		}
	}
	
	
	/**
	 * Setzt das Theme
	 * @param theme Theme
	 */
	public void setTheme(Theme theme){
		// Hintergrundbild laden
		background = theme.getSpielBrett();
		
		repaint();
	}
	
	
	/**
	 * Liefert das Label auf dem Spielstein anhand der angegbenen Position
	 * @param pos Position
	 */
	public JLabel getLabel(Position pos){
		return lblGameStone[pos.getEbene().getValue()-1][pos.getX().getValue()-1][pos.getY().getValue()-1];
	}
	
	
	
	/**
	 * Spielbrettbild dynamisch auf das GamePanel zeichnen
	 * @param g Graphics
	 */
    @Override
    public void paintComponent(Graphics g) {
    	// Hintergrundbild dynamisch zeichnen
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
}




class LblGameStone extends JLabel{
	
	private Image image;
	
	
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


class LblStoneStack extends JLabel{
	
	private Image gameStoneImage;
	private int countStones; // Anzahl der noch nicht gesetzten Spielsteine
	
	
	/**
	 * Die Farbe für den Spielsteinstapel setzen
	 * @param gameStoneImage Bild (Farbe) des Spielsteins
	 */
	public void setImage(Image gameStoneImage){
		this.gameStoneImage = gameStoneImage;
		repaint();
	}
	
	
	/**
	 * Setzt die Anzahl der noch nicht gesetzten Spielsteine
	 * @param count Anzehl der noch nicht gestzten Spielsteine
	 */
	public void setCountStones(int count){
		this.countStones = count;
		repaint(); // Zeichnung updaten
	}
	
	
	/**
	 * Stapel an noch nicht gesetzten Steinen zeichnen
	 */
	@Override
	public void paintComponent(Graphics g) {
		// Höhe und Breite berechnen
		int h = getHeight()/4;
		int w = (int) (getWidth()*0.6);
		// Bild dynamisch zeichnen
		for(int i=0;i<=countStones;i++){
			if(i>4 && i<=7){
				g.drawImage(gameStoneImage, getWidth()*15/100, ((i-5)*h)+h/2, w, h, this);
				continue;
			}
			if(i>7){
				g.drawImage(gameStoneImage, getWidth()*15/100, ((i-8)*h)+h/2+h/2, w, h, this);
				continue;
			}
			
			g.drawImage(gameStoneImage, getWidth()*15/100, i*h, w, h, this);
		}
	}
}