package ihm;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

import controleur.Controleur;

import metier.Arete;
import metier.Noeud;

import java.awt.datatransfer.*;
import java.awt.dnd.*; 

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.List;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Component;


public class PanelPlateau extends JPanel implements MouseWheelListener, MouseListener, MouseMotionListener
{
    private Controleur ctrl;
    private JLabel lblImagePlateau;
    private List<Noeud> lstNoeudOfIHM;

	private Ellipse2D[]   tabNoeud;
	private Integer       idNoeudDrag;
	private Rectangle2D[] tabNomNoeud;
	private Integer       idNomNoeudDrag;

    private BufferedImage image;

    private double zoomFactor = 1;
    private double prevZoomFactor = 1;
    private boolean zoomer;
    private boolean dragger;
    private boolean released;
    private double xOffset = 0;
    private double yOffset = 0;
    private int xDiff;
    private int yDiff;
    private Point startPoint;


    public PanelPlateau(Controleur ctrl, BufferedImage image, int longueurFrame, int hauteurFrame)
    {
        this.ctrl = ctrl;
		

        lstNoeudOfIHM =  this.ctrl.getNoeuds();
		this.idNoeudDrag = null;


        this.image = image;
		this.setBackground(new Color(255, 183, 110));
        initComponent();
        this.lblImagePlateau = new JLabel("");
        this.add(lblImagePlateau);
        
        //Drag and Drop features
        initTransferHandle();
        new MonDropTargetListener(this);
    }


    private void initTransferHandle() 
    {
        TransferHandler dnd = new TransferHandler()
        {
            @Override
            public boolean canImport(TransferSupport support) {
                if (!support.isDrop()) {
                    return false;
                }
                //only Strings
                if (!support.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean importData(TransferSupport support) {
                if (!canImport(support)) {
                    return false;
                }

                Transferable tansferable = support.getTransferable();
                Icon ico;
                try {
                    ico = (Icon) tansferable.getTransferData(DataFlavor.imageFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
                return true;
            }
        };

        this.setTransferHandler(dnd);
    }

    public void setCouleur(Color color)
    {
		this.setBackground(color);
	}

    public BufferedImage getImage()
    {
        return this.image;
    }

    public void setImageFond(BufferedImage img)
    {
        this.image = img;
        repaint();
    }

    private void initComponent() 
    {
        this.addMouseWheelListener(this);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) 
    {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        if (zoomer) 
        {
			AffineTransform at = new AffineTransform();

            double xRel = MouseInfo.getPointerInfo().getLocation().getX() - getLocationOnScreen().getX();
            double yRel = MouseInfo.getPointerInfo().getLocation().getY() - getLocationOnScreen().getY();

            double zoomDiv = zoomFactor / prevZoomFactor;

            xOffset = (zoomDiv) * (xOffset) + (1 - zoomDiv) * xRel;
            yOffset = (zoomDiv) * (yOffset) + (1 - zoomDiv) * yRel;

            at.translate(xOffset, yOffset);
            at.scale(zoomFactor, zoomFactor);
            prevZoomFactor = zoomFactor;
            g2.transform(at);
            zoomer = false;
        }

        if (dragger) 
        {
            AffineTransform at = new AffineTransform();
			//System.out.println("------------------\n" + xOffset + " " + yOffset + " | " + xDiff + " " + yDiff);
            at.translate(xOffset + xDiff, yOffset + yDiff);
			//System.out.println(xOffset + " " + yOffset + " | " + xDiff + " " + yDiff);
            at.scale(zoomFactor, zoomFactor);
            g2.transform(at);

            if (released) 
            {
				xOffset += xDiff;
                yOffset += yDiff;
                dragger = false;
            }
        }

        // All drawings go here
		this.tabNoeud = new Ellipse2D[this.lstNoeudOfIHM.size()];
		this.idNomNoeudDrag = null;
		this.tabNomNoeud = new Rectangle2D[this.lstNoeudOfIHM.size()];
        g2.drawImage(image, (int) xOffset, (int) yOffset, this);

        g2.setFont(this.ctrl.getPolicePlateau());

		for (Arete arete : this.ctrl.getAretes())
		{
			g2.setColor(arete.getCouleur1());

			int x1 = (int) xOffset + arete.getNoeud1().getX();
			int y1 = (int) yOffset + arete.getNoeud1().getY();
			int x2 = (int) xOffset + arete.getNoeud2().getX();
			int y2 = (int) yOffset + arete.getNoeud2().getY();

			g2.drawLine(x1, y1, x2, y2);
		}

		int i = 0;
        for (Noeud noeud : lstNoeudOfIHM)
        {
			int midX = (int) xOffset + noeud.getX();
			int midY = (int) yOffset + noeud.getY();

			g2.setColor(Color.BLACK);
			g2.fillOval(midX-12, midY-12, 24, 24);

            g2.setColor(noeud.getCouleur());
            g2.fillOval(midX-10, midY-10, 20, 20);

			this.tabNoeud[i] = new Ellipse2D.Double(midX-12, midY-12, 24, 24);

			g2.setColor(Color.WHITE);
			g2.fillRect(midX + noeud.getXNom() - (noeud.getNom().length() * 3), 
			            midY + noeud.getYNom() - 7, 
			            noeud.getNom().length() * 6, 
						14);

			this.tabNomNoeud[i++] = new Rectangle2D.Double(midX + noeud.getXNom() - (noeud.getNom().length() * 3), 
			                                               midY + noeud.getYNom() - 7, 
			                                               noeud.getNom().length() * 6, 
			                                               14);

			g2.setColor(Color.BLACK);
            g2.drawString(noeud.getNom(), 
			              midX + noeud.getXNom() - (noeud.getNom().length() * 3), 
			              midY + noeud.getYNom() + 4);
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) 
    {

        zoomer = true;

        //Zoom in
        if (e.getWheelRotation() < 0 && zoomFactor < 3)
        {
            zoomFactor *= 1.1;
            repaint();
        }
        //Zoom out
        if (e.getWheelRotation() > 0 && zoomFactor > 0.5)
        {
            zoomFactor /= 1.1;
            repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) 
    {
		if (SwingUtilities.isLeftMouseButton(e))
		{
			if (this.idNoeudDrag != null)
				this.ctrl.setPositionNoeud(this.idNoeudDrag, e.getX() - (int) xOffset, e.getY() - (int) yOffset);

			if (this.idNomNoeudDrag != null)
			{
				int x = e.getX() - this.lstNoeudOfIHM.get(this.idNomNoeudDrag).getX() - (int) xOffset; 
				int y = e.getY() - this.lstNoeudOfIHM.get(this.idNomNoeudDrag).getY() - (int) yOffset; 

				this.ctrl.setPositionNomNoeud(this.idNomNoeudDrag, x, y);
			}
				
			
			this.repaint();
		}

		if (SwingUtilities.isRightMouseButton(e))
		{
			Point curPoint = e.getLocationOnScreen();
			double prevXOffset = xOffset + curPoint.x - startPoint.x;
			double prevYOffset = yOffset + curPoint.y - startPoint.y;

			if (prevXOffset < 400 && prevXOffset > (-this.image.getWidth()  /2 - 400)*zoomFactor &&
				prevYOffset < 300 && prevYOffset > (-this.image.getHeight() /2 - 300)*zoomFactor    )
			{
				xDiff = curPoint.x - startPoint.x;
				yDiff = curPoint.y - startPoint.y;
				repaint();
			}

			dragger = true;
		}
       
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) 
    {
		if (SwingUtilities.isLeftMouseButton(e))
		{
			for (int i = 0 ; i < this.tabNoeud.length ; i++)
				if (this.tabNoeud[i].contains(e.getPoint()))
					this.idNoeudDrag = i;

			for (int i = 0 ; i < this.tabNomNoeud.length ; i++)
				if (this.tabNomNoeud[i].contains(e.getPoint()))
					this.idNomNoeudDrag = i;
		}

		if (SwingUtilities.isRightMouseButton(e))
		{
			released = false;
			startPoint = MouseInfo.getPointerInfo().getLocation();
		}
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
		if (SwingUtilities.isLeftMouseButton(e))
		{
			this.idNoeudDrag = null;
			this.idNomNoeudDrag = null;
		}
			

		if (SwingUtilities.isRightMouseButton(e))
		{
			released = true;
			repaint();
		}
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e){}

    class MonDropTargetListener extends DropTargetAdapter
    {
        private DropTarget dropTarget;
        private JPanel p;
        public MonDropTargetListener (JPanel panel)
        {
            p = panel;
            dropTarget = new DropTarget(panel, DnDConstants.ACTION_COPY, this, true, null);
        }
        @Override
        public void drop(DropTargetDropEvent event) 
        {
            try {
                DropTarget test = (DropTarget) event.getSource();
                Component ca = (Component) test.getComponent();
                Point dropPoint = ca.getMousePosition();
                Transferable tr = event.getTransferable();
    
                if (event.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                    Icon ico = (Icon) tr.getTransferData(DataFlavor.imageFlavor);
    
                    if (ico != null) {
                        /* Action à faite quand on drop */
                        int x, y;
                        x = (int) event.getLocation().getX();
                        y = (int) event.getLocation().getY();  
                        lstNoeudOfIHM.add(new Noeud("Test Drop", x, y, x-10, y-10, Color.BLACK));                 
                        p.revalidate();
                        p.repaint();
                        event.dropComplete(true);
                    }
                } else {
                    event.rejectDrop();
                }
            } catch (Exception e) {
                e.printStackTrace();
                event.rejectDrop();
            }
        }
    }
}
