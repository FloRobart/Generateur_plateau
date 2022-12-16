package ihm;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controleur.Controleur;
import metier.Arete;
import metier.Metier;
import metier.Noeud;

import java.awt.Color;
import java.awt.image.BufferedImage;

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

public class PanelPlateau extends JPanel implements MouseWheelListener, MouseListener, MouseMotionListener
{
    Controleur ctrl;
    JPanel panelPlateau;
    JLabel lblImagePlateau;

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

        this.image = image;
		this.setBackground(new Color(255, 183, 110));
        initComponent();
        this.ctrl = ctrl;
        this.lblImagePlateau = new JLabel("");
        this.add(lblImagePlateau);
    }

    public void setCouleur(Color color) {
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

        g2.drawImage(image, 0, 0, this);


        Metier metier = this.ctrl.getMetier();
        g2.setFont(metier.getPolicePlateau());

        for (Noeud noeud : metier.getNoeuds())
        {
            g2.setColor(noeud.getCouleur());
            g2.fillOval(noeud.getX(), noeud.getY(), 10, 10);
            g2.drawString(noeud.getNom(), noeud.getXNom(), noeud.getYNom());
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
		if (SwingUtilities.isRightMouseButton(e))
		{
			released = false;
			startPoint = MouseInfo.getPointerInfo().getLocation();
		}
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
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
}
