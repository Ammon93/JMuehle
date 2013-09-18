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

import de.dhbw.muehle.gui.ViewController;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

public class GamePanel extends JPanel {

	private Image background;
	private JPanel gameField;
	public JLabel gameStone[][];
	
	
	public GamePanel(ViewController vController) {
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
		
//		JLabel lblNewLabel = new JLabel("New label");
//		gameField.add(lblNewLabel, "1, 1");
		
		JPanel stoneField = new JPanel();
		add(stoneField, "2, 1, fill, fill");
		
		// Hintergrundbild laden
		background = new ImageIcon("res/SPIELBRETT.png").getImage();
		
		// Spielsteine initialisieren
		gameStone = new JLabel[7][7];
		
		// Spielsteine einfügen
		generateJLabels();
	}
	
	
	private void generateJLabels(){
		final Image bg = new ImageIcon("/home/ammon/Dropbox/Fallstudie/Design/Steine/SchwarzerStein.png").getImage();
		for(int x=0;x<7;x++){
			for(int y=0;y<7;y++){
				gameStone[x][y] = new JLabel(){
					@Override
				    public void paintComponent(Graphics g) {
				        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
				    }
				};
				gameField.add(gameStone[x][y], (x+1)+", "+(y+1)+", fill, fill");
			}
		}
	}
	
	
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

}