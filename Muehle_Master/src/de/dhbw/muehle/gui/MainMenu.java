package de.dhbw.muehle.gui;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;

import javax.swing.JButton;

import de.dhbw.muehle.gui.viewactions.MainMenuVA;

import java.awt.Insets;

/**
 * Dieses Panel ist das Hauptmenüpanel, das zuerst im Frame angezeigt wird.
 */
public class MainMenu extends JPanel {

	private JButton btnPvE, btnPvP, btnSettings, btnQuit;
	private MainMenuVA vActions;
	
	public MainMenu(ViewController vController) {
		// Listener initialisieren
		vActions = new MainMenuVA(vController);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 29, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("JMuehle");
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 2;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		add(lblTitle, gbc_lblTitle);
		
		btnPvE = new JButton("Player vs. PC");
		btnPvE.addActionListener(vActions.new btnPvEAction());
		GridBagConstraints gbc_btnPvE = new GridBagConstraints();
		gbc_btnPvE.gridwidth = 2;
		gbc_btnPvE.insets = new Insets(0, 0, 5, 0);
		gbc_btnPvE.gridx = 0;
		gbc_btnPvE.gridy = 1;
		add(btnPvE, gbc_btnPvE);
		
		btnPvP = new JButton("Player vs. Player");
		btnPvP.addActionListener(vActions.new btnPvPAction());
		GridBagConstraints gbc_btnPvP = new GridBagConstraints();
		gbc_btnPvP.gridwidth = 2;
		gbc_btnPvP.insets = new Insets(0, 0, 5, 0);
		gbc_btnPvP.gridx = 0;
		gbc_btnPvP.gridy = 2;
		add(btnPvP, gbc_btnPvP);
		
		btnQuit = new JButton("Beenden");
		btnQuit.addActionListener(vActions.new btnQuitAction());
		GridBagConstraints gbc_btnQuit = new GridBagConstraints();
		gbc_btnQuit.anchor = GridBagConstraints.WEST;
		gbc_btnQuit.insets = new Insets(0, 0, 0, 5);
		gbc_btnQuit.gridx = 0;
		gbc_btnQuit.gridy = 3;
		add(btnQuit, gbc_btnQuit);
		
		btnSettings = new JButton("Einstellungen");
		btnSettings.addActionListener(vActions.new btnSettingsAction());
		GridBagConstraints gbc_btnSettings = new GridBagConstraints();
		gbc_btnSettings.anchor = GridBagConstraints.EAST;
		gbc_btnSettings.gridx = 1;
		gbc_btnSettings.gridy = 3;
		add(btnSettings, gbc_btnSettings);
	}
}