package de.dhbw.muehle.gui.menus;

import java.awt.Graphics;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.dhbw.muehle.gui.MillButton;
import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.viewactions.SettingsPanelVA;
import de.dhbw.muehle.model.theme.Theme;

import java.awt.Dimension;

public class SettingsPanel extends JPanel {

	private SettingsPanelVA vActions;
	private Theme theme;
	
	private MillButton btnBack;
	
	
	public SettingsPanel(ViewController vController, Theme theme) {
		this.theme = theme;
		
		// Listener initialisieren
		vActions = new SettingsPanelVA(vController);
				
		// Panelgröße festlegen
		setSize(705, 600);
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(250px;min)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(149px;min)"),
				FormFactory.UNRELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(88px;min)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(88px;min)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(88px;min)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(88px;min)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(52px;min)"),
				FormFactory.UNRELATED_GAP_ROWSPEC,}));
		
		JComboBox<String> themeSelector = new JComboBox<String>();
		themeSelector.setModel(new DefaultComboBoxModel<String>(new String[] {"Wooden Mill", "8bit Mill", "Dirty Mill"}));
		themeSelector.addItemListener(vActions.new themeSelector());
		add(themeSelector, "8, 2, fill, default");
		
		btnBack = new MillButton(theme, "Abbrechen");
		btnBack.addActionListener(vActions.new btnBack());
		
		JButton btnWoodenMill = new JButton();
		add(btnWoodenMill, "4, 4, fill, fill");
		
		JButton btn8bitMill = new JButton();
		add(btn8bitMill, "4, 6, fill, fill");
		
		JButton btnDirtyMill = new JButton();
		add(btnDirtyMill, "4, 8, fill, fill");
		add(btnBack, "8, 12, fill, fill");
	}

	
	public void setTheme(Theme theme){
		this.theme = theme;
		btnBack.setTheme(theme);
		repaint();
	}
	
	
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(theme.getEinstellungsHintergrund(), 0, 0, getWidth(), getHeight(), this);
	}
}
