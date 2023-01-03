package ihm.frames;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.image.BufferedImage;


import controleur.Controleur;
public class FrameCreerCarteWagon extends JFrame implements ActionListener
{
    private Controleur ctrl;
    private int indiceCarte;

    private JPanel panelParametrageCarte;
    private JPanel panelVisualisatonCarte;
    private JPanel panelActionCarte;

    private List lstCarte;

    private JButton btnAjouter;
    private JButton btnSupprimer;
    private JButton btnQuitter;

    private JButton btnVerso;
    private JButton btnLocomotive;
    private JButton btnChoisirImage;
    private JButton btnChoisirCouleur;

    private JLabel lblCarteWagon;
    private Image image;

    public FrameCreerCarteWagon(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.indiceCarte = 1;

        //Paramètres de la frame
        this.setTitle("Concepteur de cartes wagon");
        Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int longueurEcran = dimEcran.width*9/10;
        int hauteurEcran = dimEcran.height*9/10;
        this.setLocation(longueurEcran* 3/11, hauteurEcran* 3/11);
        this.setSize(longueurEcran* 6/10, hauteurEcran* 6/10);
        this.setLayout( new BorderLayout());

        //Creation des composants
        this.panelParametrageCarte = new JPanel();
        this.panelParametrageCarte.setLayout(new GridLayout(5,1));

        this.panelVisualisatonCarte = new JPanel();
        this.panelVisualisatonCarte.setLayout(new GridLayout(3,3));
        this.lblCarteWagon = new JLabel("");

        this.panelActionCarte = new JPanel();

        this.lstCarte = new List();
        this.lstCarte.add("Salut");
        this.lstCarte.add("Salut");
        this.lstCarte.add("Bonjour");

        this.btnAjouter = new JButton("Ajouter");
        this.btnSupprimer = new JButton("Supprimer");
        this.btnQuitter = new JButton("Quitter");

        this.btnVerso = new JButton("Carte verso");
        this.btnLocomotive = new JButton("Carte Locomotive");
        this.btnChoisirImage = new JButton("Choisissez l'image de la carte");
        this.btnChoisirCouleur = new JButton ("Choisissez la couleur de la carte");

        //Ajout des composants au ActionListener
        this.lstCarte.addActionListener(this);

        this.btnAjouter.addActionListener(this);
        this.btnSupprimer.addActionListener(this);
        this.btnQuitter.addActionListener(this);

        this.btnVerso.addActionListener(this);
        this.btnLocomotive.addActionListener(this);
        this.btnChoisirImage.addActionListener(this);
        this.btnChoisirCouleur.addActionListener(this);

        //Ajout des composants
        this.panelVisualisatonCarte.add(new JLabel(""));
        this.panelVisualisatonCarte.add(new JLabel(""));
        this.panelVisualisatonCarte.add(new JLabel(""));
        this.panelVisualisatonCarte.add(new JLabel(""));
        this.panelVisualisatonCarte.add(this.lblCarteWagon);
        this.panelVisualisatonCarte.add(new JLabel(""));
        this.panelVisualisatonCarte.add(new JLabel(""));
        this.panelVisualisatonCarte.add(new JLabel(""));
        this.panelVisualisatonCarte.add(new JLabel(""));

        this.panelParametrageCarte.add(this.lstCarte);
        this.panelParametrageCarte.add(this.btnChoisirCouleur);
        this.panelParametrageCarte.add(this.btnChoisirImage);
        this.panelParametrageCarte.add(this.btnVerso);
        this.panelParametrageCarte.add(this.btnLocomotive);

        this.panelActionCarte.add(this.btnAjouter, BorderLayout.SOUTH);
        this.panelActionCarte.add(this.btnSupprimer, BorderLayout.SOUTH);
        this.panelActionCarte.add(this.btnQuitter, BorderLayout.SOUTH);

        this.add(this.panelParametrageCarte, BorderLayout.WEST);
        this.add(this.panelVisualisatonCarte, BorderLayout.CENTER);
        this.add(this.panelActionCarte, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if ( e.getSource() == btnAjouter )
        {
            String nomFichier;

            // Choix du nom du fichier
            nomFichier = JOptionPane.showInputDialog("Entrez le nom du fichier");

            if (nomFichier != null) 
            {
                File dossierWagon = new File(".\\donnees\\images\\cartes_joueurs\\wagon");

                if (!dossierWagon.exists())
                    dossierWagon.mkdir();

                // Importation du panel en image
                //this.lblCarteWagon.getIcon().getIconHeight(), this.lblCarteWagon.getIcon().getIconWidth()
                //this.panelVisualisatonCarte.getHeight(), this.panelVisualisatonCarte.getWidth()
                Dimension     d     = new Dimension (this.lblCarteWagon.getIcon().getIconHeight(), this.lblCarteWagon.getIcon().getIconWidth()) ;
                BufferedImage image = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
                Graphics2D    g2d   = image.createGraphics();

                /*this.panelVisualisatonCarte.setSize(this.lblCarteWagon.getIcon().getIconHeight(), this.lblCarteWagon.getIcon().getIconWidth());
                this.panelVisualisatonCarte.print(g2d);
                this.panelVisualisatonCarte.setSize(500, 500);*/
                this.panelVisualisatonCarte.print(g2d);
                g2d.dispose();

                // Enregistrement du fichier dans le répertoire choisi
                try 
                {
                    ImageIO.write(image, "png", new File(".\\donnees\\images\\cartes_joueurs\\wagon\\" + nomFichier + ".png"));
                    JOptionPane.showMessageDialog(this, "Exportation réussi dans le dossier wagon");
                } 
                catch (IOException ex) 
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Erreur lors de l'exportation");
                }
            }

            //En dessous est le vrai code final pour la méthode ajouter, ne pas toucher !!
            /*
            // Importation du panel en image
            Dimension     d     = new Dimension (this.lblCarteWagon.getIcon().getIconHeight(), this.lblCarteWagon.getIcon().getIconWidth()) ;
            BufferedImage image = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D    g2d   = image.createGraphics();
            this.panelVisualisatonCarte.print(g2d);
            g2d.dispose();

            this.lstCarte.add("Carte " + this.indiceCarte );
            this.ctrl.setImageRectoCouleur(indiceCarte, image);
            this.indiceCarte++;*/
        }

        if ( e.getSource() == btnSupprimer )
        {
            //Supprime la carte de la liste
            this.lstCarte.remove(this.lstCarte.getSelectedIndex());
            //this.ctrl.supprimerImageRectoCouleur(this.lstCarte.getSelectedIndex());
        }

        if ( e.getSource() == btnQuitter )  { this.dispose(); }

        if ( e.getSource() == this.btnChoisirCouleur )
        {
            List lstCouleurs = new List();
            for ( Color couleur : this.ctrl.getCouleurs())
            {
                lstCouleurs.add(couleur.toString());
            }
            this.panelVisualisatonCarte.setBackground(this.ctrl.getCouleurs().get(1));
        }

        if ( e.getSource() == this.btnChoisirImage )
        {
            String filePath = "";
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png", "jpeg");
            fileChooser.setFileFilter(filter);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION)
            {
                File file = fileChooser.getSelectedFile();
                filePath  = file.getAbsolutePath();
                BufferedImage img;
                try 
                {
                    img = ImageIO.read(new File(filePath));
                    this.lblCarteWagon.setIcon(new ImageIcon(img));
                } catch (IOException ex) {ex.printStackTrace();}
            }
            this.repaint();
        }
    }
}
