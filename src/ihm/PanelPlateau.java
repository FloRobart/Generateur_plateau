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
import java.awt.Shape;

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
import java.awt.geom.RoundRectangle2D;
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


    public PanelPlateau(Controleur ctrl, int longueurFrame, int hauteurFrame)
    {
        this.ctrl = ctrl;
		

        this.lstNoeudOfIHM =  this.ctrl.getNoeuds();
		this.idNoeudDrag = null;

        this.initComponent();

        this.lblImagePlateau = new JLabel("");
        this.add(lblImagePlateau);

        /* Application du theme */
        this.appliquerTheme();
        
        //Drag and Drop features
        this.initTransferHandle();
        new MonDropTargetListener(this);
    }

    public void appliquerTheme()
    {
        this.setBackground(this.ctrl.getTheme().get("background").get(0));
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
                try {
                    tansferable.getTransferData(DataFlavor.imageFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
                return true;
            }
        };

        this.setTransferHandler(dnd);
    }

    public void majIHM()
    {
		this.repaint();
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
		this.tabNomNoeud = new Rectangle2D[this.lstNoeudOfIHM.size()];
		this.image = this.ctrl.getImagePlateau();

		int[] taillePlateau = this.ctrl.getTaillePlateau();
		g2.setColor(this.ctrl.getCouleurPlateau());
		g2.fillRect((int) xOffset, (int) yOffset, taillePlateau[0], taillePlateau[1]);
        g2.drawImage(image, (int) xOffset, (int) yOffset, this);
        g2.setFont(this.ctrl.getPolicePlateau());

		for (Arete arete : this.ctrl.getAretes())
		{
			Point n1, n2;
			// on calcul l'angle de rotation à partir de la tangante de notre angle
			double angle = Math.atan((double) (arete.getNoeud2().getY() - arete.getNoeud1().getY()) / 
			                                  (arete.getNoeud2().getX() - arete.getNoeud1().getX())  );

			// si la couleur 2 est null alors nous somme sur une arete simple
			// sinon nous sommes sur une arete double
			if (arete.getCouleur2() == null)
			{
				n1 = new Point(arete.getNoeud1().getX(), arete.getNoeud1().getY());
				n2 = new Point(arete.getNoeud2().getX(), arete.getNoeud2().getY());
				this.paintArete(g2, n1, n2, arete.getDistance(), arete.getCouleur1(), angle);
			}
			else
			{
				int adj = (int) (12 * Math.cos(angle + 1.57)); //90° = 1.57
				int opp = (int) (12 * Math.sin(angle + 1.57));

				n1 = new Point(arete.getNoeud1().getX() + adj, arete.getNoeud1().getY() + opp);
				n2 = new Point(arete.getNoeud2().getX() + adj, arete.getNoeud2().getY() + opp);
				this.paintArete(g2, n1, n2, arete.getDistance(), arete.getCouleur1(), angle);

				n1 = new Point(arete.getNoeud1().getX() - adj, arete.getNoeud1().getY() - opp);
				n2 = new Point(arete.getNoeud2().getX() - adj, arete.getNoeud2().getY() - opp);
				this.paintArete(g2, n1, n2, arete.getDistance(), arete.getCouleur2(), angle);
			}
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

	private void paintArete(Graphics2D g2, Point n1, Point n2, int d, Color c, double angle)
	{
		for (double cpt = 1 ; cpt < d + 1 ; cpt++)
		{
			// on récupère les coordonnées centrale de notre tronçon
			int x = (int) (this.xOffset + n1.getX() + ((n2.getX() - n1.getX()) * (cpt / (d + 1))));
			int y = (int) (this.yOffset + n1.getY() + ((n2.getY() - n1.getY()) * (cpt / (d + 1))));

			// on créer notre tronçon sans son angle
			RoundRectangle2D fig1 = new RoundRectangle2D.Double(x - 25, y - 10, 50, 20, 25, 25);

			// on créer un autre tronçon mais avec son angle cette fois-ci
			AffineTransform t = new AffineTransform();
			t.rotate(angle, fig1.getX()+25, fig1.getY()+10);
			Shape fig2 = t.createTransformedShape(fig1);

			// on dessine notre troncon
			g2.setColor(c);
			g2.fill(fig2);
			g2.setColor(Color.BLACK);
			g2.draw(fig2);
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
        private JPanel p;
        public MonDropTargetListener (JPanel panel)
        {
            p = panel;
            new DropTarget(panel, DnDConstants.ACTION_COPY, this, true, null);
        }
        @Override
        public void drop(DropTargetDropEvent event) 
        {
            try
            {
                ((Component) ((DropTarget) event.getSource()).getComponent()).getMousePosition();
                Transferable tr = event.getTransferable();
    
                if (event.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                    Icon ico = (Icon) tr.getTransferData(DataFlavor.imageFlavor);
    
                    if (ico != null) {
                        /* Action à faite quand on drop */
                        int x, y;
                        x = (int) event.getLocation().getX() - (int) xOffset;
                        y = (int) event.getLocation().getY() - (int) yOffset;  
                        lstNoeudOfIHM.add(new Noeud("Noeud Nouveau", x, y, 0, -20, Color.BLACK));                 
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
