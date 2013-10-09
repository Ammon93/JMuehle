package de.dhbw.muehle.gui.menus;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Font;

import javax.swing.JButton;

import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.viewactions.MainMenuVA;
import de.dhbw.muehle.model.theme.Theme;

import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Dimension;

/**
 * Dieses Panel ist das Hauptmenüpanel, das zuerst im Frame angezeigt wird.
 */
public class MainMenu extends JPanel {

	private MillButton btnPvE, btnPvP, btnSettings, btnQuit, btnHilfe;
	private MainMenuVA vActions;
	
	private Theme theme;
	
	
	public MainMenu(ViewController vController, final Theme theme) {
		this.theme = theme;
		
		// Listener initialisieren
		vActions = new MainMenuVA(vController);
		
		// Panelgröße festlegen
		setSize(705, 600);
		
		
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.UNRELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(52px;min)"),
				FormFactory.UNRELATED_GAP_ROWSPEC,}));
		
		
		btnPvE = new MillButton(theme, "Einzelspieler");
		btnPvE.addActionListener(vActions.new btnPvEAction());
		add(btnPvE, "2, 5, fill, fill");
		
		btnHilfe = new MillButton(theme, "Hilfe");
		btnHilfe.setPreferredSize(new Dimension(40, 40));
		add(btnHilfe, "8, 2, right, top");
		
		btnPvP = new MillButton(theme, "Mehrspieler");
		btnPvP.addActionListener(vActions.new btnPvPAction());
		add(btnPvP, "4, 5, fill, fill");
		
		btnSettings = new MillButton(theme, "Einstellungen");
		btnSettings.addActionListener(vActions.new btnSettingsAction());
		add(btnSettings, "6, 5, fill, fill");
		
		btnQuit = new MillButton(theme, "Beenden");
		btnQuit.addActionListener(vActions.new btnQuitAction());
		add(btnQuit, "8, 5, fill, fill");
	}
	
	
	public void setTheme(Theme theme){
		this.theme = theme;
		btnHilfe.setTheme(theme);
		btnPvE.setTheme(theme);
		btnPvP.setTheme(theme);
		btnQuit.setTheme(theme);
		btnSettings.setTheme(theme);
		repaint();
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(theme.getMenueHintergrund(), 0, 0, getWidth(), getHeight(), this);
	}
}