package de.dhbw.muehle.gui.menus;

import java.awt.Graphics;

import javax.swing.JLabel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.dhbw.muehle.gui.MillButton;
import de.dhbw.muehle.gui.View;
import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.viewactions.SettingsPanelVA;

public class SettingsPanel extends AMenu {

	private SettingsPanelVA vActions;
	private View view;
	
	private MillButton btnBack;
	
	
	public SettingsPanel(ViewController vController, View view) {
		super(vController, view);
		this.view = view;
		
		// ViewActions für SettingsPanel holen
		vActions = AMenu.vActions.getSettingsPanelVA();
				
		// Panelgröße festlegen
		setSize(1000,600);
		
		
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("20px"),
				ColumnSpec.decode("max(35px;min):grow"),
				ColumnSpec.decode("max(51px;min)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(149px;min)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(51px;min)"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(251px;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(220px;min):grow(5)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(149px;min)"),
				ColumnSpec.decode("20px"),},
			new RowSpec[] {
				RowSpec.decode("20px"),
				RowSpec.decode("max(110px;min):grow"),
				RowSpec.decode("30px"),
				RowSpec.decode("max(88px;min)"),
				RowSpec.decode("15px"),
				RowSpec.decode("max(88px;min)"),
				RowSpec.decode("15px"),
				RowSpec.decode("max(88px;default)"),
				RowSpec.decode("default:grow(2)"),
				RowSpec.decode("52px"),
				RowSpec.decode("20px"),}));
		
		btnBack = new MillButton(view, "ZumMenue");
		btnBack.addActionListener(vActions.new btnBack());
		add(btnBack, "13, 10, fill, fill");
		
		
		MillButton btnWoodenMill = new MillButton(view, "Logo");
		btnWoodenMill.setTheme(vController.getTheme("Wooden Mill"));
		btnWoodenMill.addActionListener(vActions.new btnWoodenMill());
		add(btnWoodenMill, "3, 4, 5, 1, fill, fill");
		
		MillButton btn8bitMill = new MillButton(view, "Logo");
		btn8bitMill.setTheme(vController.getTheme("8bit Mill"));
		btn8bitMill.addActionListener(vActions.new btn8bitMill());
		add(btn8bitMill, "3, 6, 5, 1, fill, fill");
		
		MillButton btnOSMill = new MillButton(view, "Logo");
		btnOSMill.setTheme(vController.getTheme("OS Mill"));
		btnOSMill.addActionListener(vActions.new btnOSMill());
		add(btnOSMill, "3, 8, 5, 1, fill, fill");
		
		MillButton btnStarWarsMill = new MillButton(view, "Logo");
		btnStarWarsMill.setTheme(vController.getTheme("Star Wars Mill"));
		btnStarWarsMill.addActionListener(vActions.new btnStarWarsMill());
		add(btnStarWarsMill, "9, 4, fill, fill");
		
		MillButton btnDirtyMill = new MillButton(view, "Logo");
		btnDirtyMill.setTheme(vController.getTheme("Dirty Mill"));
		btnDirtyMill.addActionListener(vActions.new btnDirtyMill());
		add(btnDirtyMill, "9, 6, fill, fill");
	}
	
	
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(view.getTheme().getEinstellungsHintergrund(), 0, 0, getWidth(), getHeight(), this);
	}
}