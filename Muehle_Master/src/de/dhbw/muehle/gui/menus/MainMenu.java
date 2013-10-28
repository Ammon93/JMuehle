package de.dhbw.muehle.gui.menus;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.dhbw.muehle.gui.DialogBackgroundPanel;
import de.dhbw.muehle.gui.MillButton;
import de.dhbw.muehle.gui.View;
import de.dhbw.muehle.gui.ViewController;
import de.dhbw.muehle.gui.viewactions.MainMenuVA;

/**
 * Dieses Panel ist das Hauptmenüpanel, das zuerst im Frame angezeigt wird.
 */
public class MainMenu extends AMenu {

	private Spielregeln spielregeln;
	private MillButton btnPvE, btnPvP, btnSettings, btnQuit, btnHilfe;
	private MainMenuVA vActions;
	
	private View view;
	
	
	public MainMenu(ViewController vController, View view) {
		super(vController, view);
		this.view = view;
		
		// ViewActions für MainMenu holen
		vActions = AMenu.vActions.getMainMenuVA();
		
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("20px"),
				ColumnSpec.decode("max(159px;min)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(149px;min)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(149px;min)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(149px;min)"),
				ColumnSpec.decode("20px"),},
			new RowSpec[] {
				RowSpec.decode("20px"),
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(52px;min)"),
				RowSpec.decode("20px"),}));
		
		spielregeln = new Spielregeln(view, vActions);
		add(spielregeln, "1, 1, 9, 6, fill, fill");
		
		
		btnPvE = new MillButton(view, "Einzelspieler");
		btnPvE.addActionListener(vActions.new btnPvEAction());
		add(btnPvE, "2, 5, fill, fill");
		
		btnHilfe = new MillButton(view, "Hilfe");
		btnHilfe.setPreferredSize(new Dimension(40, 40));
		btnHilfe.addActionListener(vActions.new btnHilfeAction());
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
	
	
	public void openSpielregeln(){
		this.spielregeln.showDialog();
	}
	
	public void closeSpielregeln(){
			this.spielregeln.close();
	}
	
	
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(view.getTheme().getMenueHintergrund(), 0, 0, getWidth(), getHeight(), this);
	}
	
	
	
	
	public class Spielregeln extends DialogBackgroundPanel{
		
		private JLabel dialogMessage;
		
		
		public Spielregeln(View view, MainMenuVA vActions) {
			super(view, vActions);
			
			setDialogSize(450, 550);
			
			dialog.setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("max(20px;default)"),
					ColumnSpec.decode("default:grow"),
					ColumnSpec.decode("max(159px;default)"),
					ColumnSpec.decode("default:grow"),
					ColumnSpec.decode("max(20px;default)"),},
				new RowSpec[] {
					RowSpec.decode("3dlu:grow"),
					RowSpec.decode("max(52px;default)"),
					RowSpec.decode("max(30px;default)"),}));
			
			dialogMessage = new JLabel();
			dialog.add(dialogMessage, "2, 1, 3, 1, center, fill");
			
			MillButton btnBack = new MillButton(view, "Zurueck");
			btnBack.addActionListener(vActions.new dialogBtnBack());
			dialog.add(btnBack, "3, 2, fill, fill");
		}
		
		
		
		@Override
		public void paintComponent(Graphics g) {
			setDialogBackground(view.getTheme().getSpielregeln());
			
			super.paintComponent(g);
		}
	}
}