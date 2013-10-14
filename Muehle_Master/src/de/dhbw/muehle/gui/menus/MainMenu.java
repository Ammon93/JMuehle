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

import de.dhbw.muehle.gui.MillButton;
import de.dhbw.muehle.gui.View;
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
public class MainMenu extends Menu {

	private MillButton btnPvE, btnPvP, btnSettings, btnQuit, btnHilfe;
	private MainMenuVA vActions;
	
	private View view;
	
	
	public MainMenu(ViewController vController, View view) {
		super(view);
		this.view = view;
		
		// Listener initialisieren
		vActions = new MainMenuVA(vController);
				
		
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("25px"),
				ColumnSpec.decode("max(159px;min)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(149px;min)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(149px;min)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(149px;min)"),
				ColumnSpec.decode("25px"),},
			new RowSpec[] {
				RowSpec.decode("25px"),
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(52px;min)"),
				RowSpec.decode("25px"),}));
		
		
		btnPvE = new MillButton(view, "Einzelspieler");
		btnPvE.addActionListener(vActions.new btnPvEAction());
		add(btnPvE, "2, 5, fill, fill");
		
		btnHilfe = new MillButton(view, "Hilfe");
		btnHilfe.setPreferredSize(new Dimension(40, 40));
		add(btnHilfe, "8, 2, right, top");
		
		btnPvP = new MillButton(view, "Mehrspieler");
		btnPvP.addActionListener(vActions.new btnPvPAction());
		add(btnPvP, "4, 5, fill, fill");
		
		btnSettings = new MillButton(view, "Einstellungen");
		btnSettings.addActionListener(vActions.new btnSettingsAction());
		add(btnSettings, "6, 5, fill, fill");
		
		btnQuit = new MillButton(view, "Beenden");
		btnQuit.addActionListener(vActions.new btnQuitAction());
		add(btnQuit, "8, 5, fill, fill");
	}
	
	
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(view.getTheme().getMenueHintergrund(), 0, 0, getWidth(), getHeight(), this);
	}
}