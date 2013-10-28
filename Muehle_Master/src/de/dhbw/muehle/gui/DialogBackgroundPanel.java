package de.dhbw.muehle.gui;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

import com.jhlabs.image.BoxBlurFilter;

import de.dhbw.muehle.gui.viewactions.ViewActions;

public class DialogBackgroundPanel extends JPanel{
	
	private Image dialogBG;
	protected BufferedImage screenShot;
	
	protected View view;
	protected ViewActions vActions;
	
	protected JPanel dialog;
	
	public static String OPEN = "open",
						 CLOSE = "close",
						 HIDE = "hide";
	public static String DIALOG = "Dialog",
						 SPIELREGELN = "Spielregeln",
						 INPUTDIALOG = "InputDialog";
	
	
	public DialogBackgroundPanel(View view, ViewActions vActions) {
		this.view = view;
		this.vActions = vActions;
		
		setVisible(false);
		setOpaque(false);
		
		addMouseListener(new MouseAdapter(){}); // der Mouseadapter sperrt die dahinterliegenden Objekte
		
		dialog = new JPanel(){
			@Override
			public void paintComponent(Graphics g) {
				// Bild dynamisch zeichnen
				g.drawImage(dialogBG, 0, 0, getWidth(), getHeight(), this);
			}
		};
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(dialog);
	}
	
	
	private void calculateVGap(JPanel dialog){
		dialog.setLocation(dialog.getX(), (getHeight()-dialog.getHeight()) /2);
	}
	
	
	protected void setDialogSize(int width, int height){
		setDialogSize(new Dimension(width, height));
	}
	
	protected void setDialogSize(Dimension size){
		dialog.setPreferredSize(size);
		calculateVGap(dialog);
		
		repaint();
	}
	
	
	protected void getBluredScreenShot() throws IOException, AWTException{
		Rectangle panelPosition = new Rectangle();
		panelPosition.setLocation(view.getLocationOnScreen().x+view.getActualPanel().getLocation().x,
								  view.getLocationOnScreen().y + view.getTopBar().getHeight());
		panelPosition.setSize(view.getActualPanel().getSize());
			        
        screenShot = new BoxBlurFilter(10, 10, 2).filter(new Robot().createScreenCapture(panelPosition),null);
    }
	
	
	protected void setDialogBackground(Image dialogBG){
		this.dialogBG = dialogBG;
	}
	
	
	public void showDialog(){
		try {
			getBluredScreenShot();
		} catch (IOException | AWTException e) {e.printStackTrace();}
		
		setVisible(true);
		
		synchronized (vActions) {
			vActions.setDialogShown(true);
			vActions.setCanceled(false);
		}
	}
	
	public void disappear(){
		setVisible(false);
		
		synchronized (vActions) {
			vActions.setCanceled(true);
			
			vActions.notifyAll();
		}
	}
	
	public void close(){
		setVisible(false);
		
		synchronized (vActions) {
			vActions.setDialogShown(false);
			
			vActions.notifyAll();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		calculateVGap(dialog);
		
		int w = getWidth();
		int h = getHeight();
		
		if(w > view.getWidth())
			w = view.getWidth();
		if(h > view.getHeight())
			h = view.getHeight();
		
		// Hintergrund aufhellen
		int brightness = (int) (255 - 255 * 0.75f);
        g.setColor(new Color(0, 0, 0, brightness));
		
        // Hintergrund zeichnen
	    g.drawImage(screenShot, 0, 0, w, h, this);
	    g.fillRect(0, 0, w, h);
	}
}