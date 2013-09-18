package de.dhbw.muehle.gui;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GamePanel extends JPanel {

	private Image background;
	private JPanel gameField;
	private JLabel gameStone[][];
	
	
	public GamePanel(ViewController vController) {
		// Panelgröße festlegen
		setSize(705, 600);
		
		// Hintergrundbild laden
		background = new ImageIcon("res/SPIELBRETT.png").getImage();
		
		// Spielsteine initialisieren
		gameStone = new JLabel[7][7];	
		
		
		// Panels für die Spielsteine erstellen
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{595, 110, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{5.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		gameField = new JPanel();
		gameField.setOpaque(false);
		GridBagConstraints gbc_gameField = new GridBagConstraints();
		gbc_gameField.insets = new Insets(0, 0, 0, 5);
		gbc_gameField.fill = GridBagConstraints.BOTH;
		gbc_gameField.gridx = 0;
		gbc_gameField.gridy = 0;
		add(gameField, gbc_gameField);
		GridBagLayout gbl_gameField = new GridBagLayout();
		gbl_gameField.columnWidths = new int[]{100, 100, 100, 100, 100, 100, 100};
		gbl_gameField.rowHeights = new int[]{85, 85, 85, 85, 85, 85, 85};
		gbl_gameField.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gbl_gameField.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gameField.setLayout(gbl_gameField);
		
		JPanel stoneField = new JPanel();
		GridBagConstraints gbc_stoneField = new GridBagConstraints();
		gbc_stoneField.fill = GridBagConstraints.BOTH;
		gbc_stoneField.gridx = 1;
		gbc_stoneField.gridy = 0;
		add(stoneField, gbc_stoneField);
		
		// Spielsteine einfügen
		generateJLabels();
	}
	
	
	private void generateJLabels(){
		GridBagConstraints gbc_gameStone = new GridBagConstraints();
		gbc_gameStone.insets = new Insets(0, 0, 5, 5);
		gbc_gameStone.fill = GridBagConstraints.BOTH;
		
		for(int x=0;x<7;x++){
			for(int y=0;y<7;y++){
				gameStone[x][y] = new JLabel();
				gameStone[x][y].setText(x + "hg"+ y);
				gameStone[x][y].setHorizontalAlignment(SwingConstants.CENTER);;
				gbc_gameStone.gridx = x;
				gbc_gameStone.gridy = y;
				gameField.add(gameStone[x][y], gbc_gameStone);
			}
		}
	}
	
	
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

}