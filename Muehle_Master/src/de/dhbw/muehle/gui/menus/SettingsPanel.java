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
import de.dhbw.muehle.model.theme.ThemeLoader;

import java.awt.Dimension;

public class SettingsPanel extends JPanel {

	private SettingsPanelVA vActions;
	private Theme theme;
	
	private MillButton btnBack;
	private MillLabel lblTheme;
	
	
	public SettingsPanel(ViewController vController, Theme theme) {
		this.theme = theme;
		
		// Listener initialisieren
		vActions = new SettingsPanelVA(vController);
				
		// Panelgröße festlegen
		setSize(705, 600);
		
		
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(22px;min):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(51px;min)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(149px;min)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(51px;min)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(210px;min):grow(3)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(149px;min)"),
				FormFactory.UNRELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("max(125px;min):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(52px;min)"),
				RowSpec.decode("25px"),
				RowSpec.decode("max(88px;min)"),
				RowSpec.decode("15px"),
				RowSpec.decode("max(88px;min)"),
				RowSpec.decode("15px"),
				RowSpec.decode("max(88px;min)"),
				RowSpec.decode("15px:grow(3)"),
				RowSpec.decode("max(52px;min)"),
				FormFactory.UNRELATED_GAP_ROWSPEC,}));
		
		btnBack = new MillButton(theme, "ZumMenue");
		btnBack.addActionListener(vActions.new btnBack());
		
		lblTheme = new MillLabel(theme);
		add(lblTheme, "6, 4, fill, fill");
		
		
		MillButton btn8bitMill = new MillButton(new ThemeLoader().getTheme("8bit Mill"), "Logo");
		btn8bitMill.addActionListener(vActions.new btn8bitMill());
		
		MillButton btnWoodenMill = new MillButton(new ThemeLoader().getTheme("Wooden Mill"), "Logo");
		btnWoodenMill.addActionListener(vActions.new btnWoodenMill());
		add(btnWoodenMill, "4, 6, 5, 1, fill, fill");
		add(btn8bitMill, "4, 8, 5, 1, fill, fill");
		
		MillButton btnDirtyMill = new MillButton(new ThemeLoader().getTheme("Dirty Mill"), "Logo");
		btnDirtyMill.addActionListener(vActions.new btnDirtyMill());
		add(btnDirtyMill, "4, 10, 5, 1, fill, fill");
		add(btnBack, "12, 12, fill, fill");
	}

	
	public void setTheme(Theme theme){
		this.theme = theme;
		btnBack.setTheme(theme);
		lblTheme.setTheme(theme);
		repaint();
	}
	
	
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(theme.getEinstellungsHintergrund(), 0, 0, getWidth(), getHeight(), this);
	}
	
	
	
	private class MillLabel extends JLabel{
		
		private Theme theme;
		
		
		public MillLabel(Theme theme){
			this.theme = theme;
		}
		
		
		public void setTheme(Theme theme){
			this.theme = theme;
			repaint();
		}
		
		
		
		@Override
		public void paintComponent(Graphics g){
			g.drawImage(theme.getBtnTheme(), 0, 0, getWidth(), getHeight(), this);
		}
	}
}
