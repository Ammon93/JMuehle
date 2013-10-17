package de.dhbw.muehle.gui.viewactions;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import de.dhbw.muehle.gui.ViewController;

public class ViewVA {

	private ViewController vController;
	
	private Rectangle bounds;
	
	
	
	public ViewVA(ViewController vController) {
		this.vController = vController;
	}
	

	
	/**
	 * ActionListener
	 */
//	{
		public class btnClose implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		
		public class btnMax implements ActionListener{
			
			private boolean max;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(max){
					vController.frame.setBounds(bounds);
					max = false;
				}else{
					bounds = vController.frame.getBounds();
					vController.frame.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
					max = true;
				}
				vController.frame.validate();
				vController.frame.repaint();
			}
		}
		
		public class btnMin implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.frame.setExtendedState(Frame.ICONIFIED);
			}
		}
//	}
	
		

		
	/**
	 * ResizeAdapter
	 */
//	{
		public static class ResizeAdapter extends MouseAdapter implements SwingConstants {
			private boolean resizing = false;
			private int prevX = -1;
			private int prevY = -1;

			private int resizeSide = 0;

			public static void install(Component component, int resizeSide) {
				ResizeAdapter wra = new ResizeAdapter(resizeSide);
				component.addMouseListener(wra);
				component.addMouseMotionListener(wra);
			}

			public ResizeAdapter(int resizeSide) {
				super();
				this.resizeSide = resizeSide;
			}

			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					resizing = true;
				}
				prevX = e.getXOnScreen();
				prevY = e.getYOnScreen();
			}

			public void mouseDragged(MouseEvent e) {
				if (prevX != -1 && prevY != -1 && resizing) {
					Window w = SwingUtilities.getWindowAncestor(e.getComponent());
					Rectangle rect = w.getBounds();

					Dimension dim;
					
					// Checking for minimal width and height
					int xInc = e.getXOnScreen() - prevX;
					int yInc = e.getYOnScreen() - prevY;
					

					// Resizing window if any changes are done
					if (xInc != 0 || yInc != 0) {
						if (resizeSide == SwingConstants.NORTH_WEST) {
							w.setBounds(rect.x + xInc, rect.y + yInc,
									rect.width - xInc, rect.height - yInc);
						} else if (resizeSide == SwingConstants.NORTH) {
							w.setBounds(rect.x, rect.y + yInc, rect.width, rect.height
									- yInc);
						} else if (resizeSide == SwingConstants.NORTH_EAST) {
							w.setBounds(rect.x, rect.y + yInc, rect.width + xInc,
									rect.height - yInc);
						} else if (resizeSide == SwingConstants.WEST) {
							w.setBounds(rect.x + xInc, rect.y, rect.width - xInc,
									rect.height);
						} else if (resizeSide == SwingConstants.EAST) {
							w.setBounds(rect.x, rect.y, rect.width + xInc, rect.height);
						} else if (resizeSide == SwingConstants.SOUTH_WEST) {
							w.setBounds(rect.x + xInc, rect.y, rect.width - xInc,
									rect.height + yInc);
						} else if (resizeSide == SwingConstants.SOUTH) {
							w.setBounds(rect.x, rect.y, rect.width, rect.height + yInc);
						} else if (resizeSide == SwingConstants.SOUTH_EAST) {
							w.setBounds(rect.x, rect.y, rect.width + xInc, rect.height
									+ yInc);
						}
						prevX = e.getXOnScreen();
						prevY = e.getYOnScreen();
					}
				}
			}

			public void mouseReleased(MouseEvent e) {
				resizing = false;
			}
		}
//	}
		
		
		
	/**
	 * MoveAdapter
	 */
//	{
		public static class MoveAdapter extends MouseAdapter{
			
			private Point initialClick;
			
			
			public static void install(Component component) {
				MoveAdapter wra = new MoveAdapter();
				component.addMouseListener(wra);
				component.addMouseMotionListener(wra);
			}
			
			
			
			public void mousePressed(MouseEvent e) {
	            initialClick = e.getPoint();
	        }
			
			
	        public void mouseDragged(MouseEvent e) {
	        	Window w = SwingUtilities.getWindowAncestor(e.getComponent());
	        	
	            // Ort des Fensters ermitteln
	            int fensterX = w.getLocation().x;
	            int fensterY = w.getLocation().y;

	            // Bewegung der Maus seit dem ersten Klick verfolgen
	            int mausRelativX = (fensterX + e.getX()) - (fensterX + initialClick.x);
	            int mausRelativY = (fensterY + e.getY()) - (fensterY + initialClick.y);

	            // Bewege Fenster zu dieser Position
	            int X = fensterX + mausRelativX;
	            int Y = fensterY + mausRelativY;
	            w.setLocation(X, Y);
	        }
		}
//	}
}