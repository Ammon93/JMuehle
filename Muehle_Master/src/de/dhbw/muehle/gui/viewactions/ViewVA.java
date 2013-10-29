package de.dhbw.muehle.gui.viewactions;

import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import de.dhbw.muehle.gui.View;

/**
 * Hier werden alle Listener für die {@link View} implementiert
 * @author Ammon
 */
public class ViewVA extends ViewActions{
	
	private Rectangle bounds;
	
	private boolean maximized;
	

	
	/**
	 * ActionListener
	 */
//	{
		public class btnClose extends ABtnClose{
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		
		public class btnMax extends ABtnMax{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(maximized){
					vController.getView().setBounds(bounds);
					maximized = false;
				}else{
					bounds = vController.getView().getBounds();
					vController.getView().setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
					maximized = true;
				}
				vController.getView().revalidate();
				vController.getView().repaint();
			}
		}
		
		public class btnMin extends ABtnMin{
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.getView().setExtendedState(Frame.ICONIFIED);
			}
		}
//	}
	
		

		
	/**
	 * ResizeAdapter
	 */
//	{
		public class ResizeAdapter extends AViewResizeAdapter {
			private boolean resizing = false;
			private int prevX = -1;
			private int prevY = -1;

			private int resizeSide = 0;
			

			public ResizeAdapter(JComponent component, int resizeSide) {
				super();
				this.resizeSide = resizeSide;
				component.addMouseListener(this);
				component.addMouseMotionListener(this);
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
					
					if(maximized)
						maximized = false;
				}
			}

			public void mouseReleased(MouseEvent e) {
				resizing = false;
				vController.resizePanel(vController.getView().getActualPanel());
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseMoved(MouseEvent e) {
			}
		}
//	}
		
		
		
	/**
	 * MoveAdapter
	 */
//	{
		public class MoveAdapter extends AViewMoveAdapter{
			
			private Point initialClick;
			
			
			public MoveAdapter(JComponent component) {
				component.addMouseListener(this);
				component.addMouseMotionListener(this);
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



			@Override
			public void mouseClicked(MouseEvent e) {
			}



			@Override
			public void mouseReleased(MouseEvent e) {
			}



			@Override
			public void mouseEntered(MouseEvent e) {
			}



			@Override
			public void mouseExited(MouseEvent e) {
			}



			@Override
			public void mouseMoved(MouseEvent e) {
			}
		}
//	}
}