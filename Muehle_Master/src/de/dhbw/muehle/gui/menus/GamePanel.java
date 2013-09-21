package de.dhbw.muehle.gui.menus;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.dhbw.muehle.gui.GameStone;
import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.viewactions.GamePanelVA;
import de.dhbw.muehle.gui.viewactions.MainMenuVA;

import java.awt.GridLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.Cursor;

public class GamePanel extends JPanel {

	private Image background;
	private JPanel gameField;
	private GameStone gameStone[][][];
	
	private GamePanelVA vActions;
	
	public GamePanel(ViewController vController) {
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
		add(stoneField, "2, 1, fill, fill");
		
		
		// Hintergrundbild laden
		background = new ImageIcon("res/themes/Wooden Mill/Spielbrett/Spielbrett 3.0.png").getImage();
		
		// Spielsteine initialisieren
		gameStone = new GameStone[3][3][3];
		
		// Labels für die Spielsteine einfügen
		generateJLabels();
	}
	
	
	private void generateJLabels(){
		int k = 3;
		for(int i=0;i<3;i++){
			for(int x=0;x<3;x++){
				for(int y=0;y<3;y++){
					if(! (x==1 && y==1)){
						gameStone[i][x][y] = new GameStone();
						gameStone[i][x][y].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						gameStone[i][x][y].addMouseListener(vActions.new lblGameStoneMouse());
						gameField.add(gameStone[i][x][y], (x*k+i+1)+", "+(y*k+i+1)+", fill, fill");
					}
				}
			}
			k--;
		}
	}
	
	
	// Spielbrettbild dynamisch auf das GamePanel zeichnen
    @Override
    public void paintComponent(Graphics g) {
    	// Hintergrundbild dynamisch zeichnen
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

}