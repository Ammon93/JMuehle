package de.dhbw.muehle.gui;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import de.dhbw.muehle.core.Core;
import de.dhbw.muehle.gui.menus.GamePanel;
import de.dhbw.muehle.gui.menus.MainMenu;
import de.dhbw.muehle.gui.menus.AMenu;
import de.dhbw.muehle.gui.menus.SettingsPanel;
import de.dhbw.muehle.gui.viewactions.ViewActions;
import de.dhbw.muehle.gui.viewactions.ViewVA;
import de.dhbw.muehle.gui.viewactions.ViewVA.ResizeAdapter;
import de.dhbw.muehle.model.theme.Theme;

/**
 * Hier wird die View gebaut.
 * Sämtliche Funktionen werden im ViewController und den View Actions implementiert.
 * @author Ammon
 *
 */
public class View extends JFrame{
	
	private Theme theme;
	
	private JPanel contentPane;
	private JPanel content;
	private JPanel topBar;
	
	private ViewController vController;
	private ViewActions globalVA;
	private ViewVA vActions;

	private MainMenu mainMenu;
	private GamePanel gamePanel;
	private SettingsPanel settingsPanel;
	
	
	/**
	 * Konstruktor
	 * 
	 * @param vController
	 * @param theme
	 */
	public View(Core core, ViewController vController, Theme theme){
		this.theme = theme;
		this.vController = vController;
		
		// globale ViewActions initialisieren
		globalVA = new ViewActions(vController, core);
		
		// ViewActions für View holen
		vActions = globalVA.getViewVA();
		

		setTitle("JMuehle");		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100,100,500,500);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("10px"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("10px"),},
			new RowSpec[] {
				RowSpec.decode("20px"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("10px"),}));
		
		JPanel top = new JPanel();
		contentPane.add(top, "1, 1, 3, 1, fill, fill");
		top.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("10px"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("5px"),},
			new RowSpec[] {
				RowSpec.decode("5px"),
				RowSpec.decode("15px"),}));
				
				JLabel lblUpLeft = new JLabel();
				lblUpLeft.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
				vActions.new ResizeAdapter(lblUpLeft, ResizeAdapter.NORTH_WEST);
				top.add(lblUpLeft, "1, 1, 1, 2, fill, fill");
				
				JLabel lblUp = new JLabel();
				lblUp.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
				vActions.new ResizeAdapter(lblUp, ResizeAdapter.NORTH);
				top.add(lblUp, "2, 1, fill, fill");
				
				JLabel lblUpRight = new JLabel();
				lblUpRight.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
				vActions.new ResizeAdapter(lblUpRight, ResizeAdapter.NORTH_EAST);
				top.add(lblUpRight, "3, 1, 1, 2, fill, fill");
				
				topBar = new JPanel(){
					@Override
					public void paintComponent(Graphics g){
						g.drawImage(getTheme().getLeiste(), 0, 0, getWidth(), getHeight(), this);
					}
				};
				vActions.new MoveAdapter(topBar);
				top.add(topBar, "1, 1, 3, 2, fill, fill");
				topBar.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
				
						MillButton btnMin = new MillButton(this, "Minimize");
						btnMin.setPreferredSize(new Dimension(20,20));
						btnMin.addActionListener(vActions.new btnMin());
						topBar.add(btnMin);
						
						MillButton btnMax = new MillButton(this, "Maximize");
						btnMax.setPreferredSize(new Dimension(20,20));
						btnMax.addActionListener(vActions.new btnMax());
						topBar.add(btnMax);
						
						MillButton btnClose = new MillButton(this, "Close");
						btnClose.setPreferredSize(new Dimension(20,20));
						btnClose.addActionListener(vActions.new btnClose());
						topBar.add(btnClose);
				
		
		JLabel lblLeft = new JLabel();
		lblLeft.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
		vActions.new ResizeAdapter(lblLeft, ResizeAdapter.WEST);
		contentPane.add(lblLeft, "1, 2, fill, fill");
		
		JLabel lblRight = new JLabel();
		lblRight.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
		vActions.new ResizeAdapter(lblRight, ResizeAdapter.EAST);
		contentPane.add(lblRight, "3, 2, fill, fill");
		
		JLabel lblDownLeft = new JLabel();
		lblDownLeft.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
		vActions.new ResizeAdapter(lblDownLeft, ResizeAdapter.SOUTH_WEST);
		contentPane.add(lblDownLeft, "1, 3, fill, fill");
		
		JLabel lblDown = new JLabel();
		lblDown.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
		vActions.new ResizeAdapter(lblDown, ResizeAdapter.SOUTH);
		contentPane.add(lblDown, "2, 3, fill, fill");
		
		JLabel lblDownRight = new JLabel();
		lblDownRight.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
		vActions.new ResizeAdapter(lblDownRight, ResizeAdapter.SOUTH_EAST);
		contentPane.add(lblDownRight, "3, 3, fill, fill");
		
		content = new JPanel();
		content.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		contentPane.add(content, "1, 2, 3, 2, fill, fill");
		
		
		// mainMenu initialisieren
		mainMenu = new MainMenu(vController, this);
		
		// gamePanel initialisieren
		gamePanel = new GamePanel(vController, this);
		
		// setingsPanel initialisieren
		settingsPanel = new SettingsPanel(vController, this);
	}
	
	
	
	/**
	 * Gibt ein Objekt der globalen {@link ViewActions}-Klasse zurück.
	 * 
	 * @return {@link ViewActions}
	 */
	public ViewActions getGlobalVA(){
		return globalVA;
	}
	
	
	/**
	 * Setzt eine Theme.
	 * 
	 * @param theme Theme
	 */
	public void setTheme(Theme theme){
		this.theme = theme;
		repaint();
	}
	
	/**
	 * Liefert das aktuell verwendete Theme.
	 * 
	 * @return Theme
	 */
	public Theme getTheme(){
		return theme;
	}
	
	
	/**
	 * Gibt den ViewController zurück.
	 * @return
	 */
	public ViewController getViewController(){
		return vController;
	}
	
	
	/**
	 * Gibt das {@link MainMenu} zurück.
	 * 
	 * @return {@link MainMenu}
	 */
	public MainMenu getMainMenu() {
		return mainMenu;
	}
	
	
	/**
	 * Gibt das {@link GamePanel} zurück.
	 * 
	 * @return {@link GamePanel}
	 */
	public GamePanel getGamePanel() {
		return gamePanel;
	}
	
	/**
	 * Setzt das aktuelle {@link GamePanel}.
	 * 
	 * @param {@link GamePanel}
	 */
	public void setGamePanel(GamePanel gamePanel){
		this.gamePanel = gamePanel;
	}
	
	
	/**
	 * Gibt das {@link SettingsPanel} zurück.
	 * 
	 * @return {@link SettingsPanel}
	 */
	public SettingsPanel getSetingsPanel() {
		return settingsPanel;
	}
	
	
	/**
	 * Gibt das aktuelle Panel, das im Frame angezeigt wird, zurück.
	 * 
	 * @return {@link AMenu}
	 */
	public AMenu getActualPanel(){
		return (AMenu) content.getComponent(0);
	}
	
	
	/**
	 * Gibt die obere Fensterleiste zurück.
	 * 
	 * @return {@link JPanel}
	 */
	public JPanel getTopBar(){
		return topBar;
	}

	
	
	/**
	 * Setzt das Hauptpanel des Frames.
	 * 
	 * @param container Container (In diesem Fall das JPanel)
	 */
	public void setContentPane(AMenu container){
		
		// aktuelles Panel entfernen, sofern vorhanden
		if(content.getComponents().length != 0)
			content.removeAll();
		
		// neues Panel setzen
		content.add(container);
		
		
		// Framegröße auf Panelgröße anpassen
		if(container.getOriginalSize().height > getHeight() || container.getOriginalSize().width > getWidth()){
			container.setPreferredSize(container.getOriginalSize());
			
			pack();
						
			//Frameminimumgröße auf Panelgröße festlegen
			setMinimumSize(getSize());
		}else{
			vController.resizePanel(container);
		}
		
		validate();
		repaint();
	}
}