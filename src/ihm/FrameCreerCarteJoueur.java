package ihm;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Color;

import controleur.Controleur;


public class FrameCreerCarteJoueur extends JFrame implements ActionListener
{
    private JPanel panelParametrageCarte;
    private JPanel panelVisualisatonCarte;
    private JPanel panelActionCarte;

    private List lstCarte;
    private List lstCartePredefini;

    private JButton btnAjouter;
    private JButton btnModifier;
    private JButton btnSupprimer;
    private JButton btnVerso;
    private JButton btnChoisirImage;
    private JButton btnChoisirCouleur;

    private JLabel lblCarteWagon;


    public FrameCreerCarteJoueur(Controleur ctrl)
    {
        //Paramètres de la frame
        this.setTitle("Concepteur de cartes");
        Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int longueurEcran = dimEcran.width*9/10;
        int hauteurEcran = dimEcran.height*9/10;
        this.setLocation(longueurEcran* 3/11, hauteurEcran* 3/11);
        this.setSize(longueurEcran* 6/10, hauteurEcran* 6/10);
        this.setLayout( new BorderLayout());

        //Creation des composants
        this.panelParametrageCarte = new JPanel();
        this.panelParametrageCarte.setLayout(new BorderLayout());

        this.panelVisualisatonCarte = new JPanel();
        this.lblCarteWagon = new JLabel("");

        this.panelActionCarte = new JPanel();

        this.lstCarte = new List();
        this.lstCarte.add("Salut");
        this.lstCarte.add("Salut");
        this.lstCarte.add("Bonjour");

        this.lstCartePredefini = new List();
        this.lstCartePredefini.add("1");
        this.lstCartePredefini.add("1");

        this.btnAjouter = new JButton("Ajouter");
        this.btnModifier= new JButton("Modifier");
        this.btnSupprimer = new JButton("Supprimer");
        this.btnVerso = new JButton("Carte verso");
        this.btnChoisirImage = new JButton("Choisissez l'image de la carte");
        this.btnChoisirCouleur = new JButton ("Choisissez la couleur de la carte");

        //Ajout des composants au ActionListener
        this.lstCarte.addActionListener(this);
        this.btnVerso.addActionListener(this);

        this.btnAjouter.addActionListener(this);
        this.btnModifier.addActionListener(this);
        this.btnSupprimer.addActionListener(this);
        this.btnChoisirImage.addActionListener(this);
        this.btnChoisirCouleur.addActionListener(this);

        //Ajout des composants
        this.panelVisualisatonCarte.add(this.lblCarteWagon);

        this.panelParametrageCarte.add(this.lstCarte, BorderLayout.NORTH);
        this.panelParametrageCarte.add(this.btnChoisirImage, BorderLayout.NORTH);
        //image predef
        this.panelParametrageCarte.add(this.btnChoisirCouleur);
        this.panelParametrageCarte.add(this.btnVerso, BorderLayout.SOUTH);

        this.panelActionCarte.add(this.btnAjouter, BorderLayout.SOUTH);
        this.panelActionCarte.add(this.btnModifier, BorderLayout.SOUTH);
        this.panelActionCarte.add(this.btnSupprimer, BorderLayout.SOUTH);

        this.add(this.panelParametrageCarte, BorderLayout.WEST);
        this.add(this.panelVisualisatonCarte, BorderLayout.CENTER);
        this.add(this.panelActionCarte, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if ( e.getSource() == this.btnChoisirCouleur )
        {
            Color color = JColorChooser.showDialog(this, "Choisissez une couleur", Color.WHITE);
            if (color != null) 
                this.panelVisualisatonCarte.setBackground(color);
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
        }
    }
}
