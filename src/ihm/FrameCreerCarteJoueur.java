package ihm;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controleur.Controleur;

public class FrameCreerCarteJoueur extends JFrame implements ActionListener
{
    private Controleur ctrl;

    private JPanel panelParametrageCarte;
    private JPanel panelVisualisatonCarte;
    private JPanel panelActionCarte;

    private List lstCarte;

    private JButton btnAjouter;
    private JButton btnModifier;
    private JButton btnSupprimer;
    private JButton btnVerso;

    private JLabel lblCarteWagon;


    public FrameCreerCarteJoueur(Controleur ctrl)
    {
        this.ctrl = ctrl;

        //Paramètres de la frame
        Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int longueurEcran = dimEcran.width*9/10;
        int hauteurEcran = dimEcran.height*9/10;
        this.setLocation(longueurEcran* 3/11, hauteurEcran* 3/11);
        this.setSize(longueurEcran* 6/10, hauteurEcran* 6/10);
        this.setLayout( new BorderLayout());

        //Creation des composants
        this.panelParametrageCarte = new JPanel();
        this.panelParametrageCarte.setLayout(new GridLayout(4,1));

        this.panelVisualisatonCarte = new JPanel();
        this.lblCarteWagon = new JLabel();

        this.panelActionCarte = new JPanel();

        this.lstCarte = new List();
        this.lstCarte.add("Salut");
        this.lstCarte.add("Salut");
        this.lstCarte.add("Bonjour");

        this.btnAjouter = new JButton("Ajouter");
        this.btnModifier= new JButton("Modifier");
        this.btnSupprimer = new JButton("Supprimer");
        this.btnVerso = new JButton("Carte verso");

        //Ajout des composants au ActionListener
        this.lstCarte.addActionListener(this);
        this.btnVerso.addActionListener(this);

        this.btnAjouter.addActionListener(this);
        this.btnModifier.addActionListener(this);
        this.btnSupprimer.addActionListener(this);

        //Ajout des composants
        this.panelVisualisatonCarte.add(this.lblCarteWagon);

        this.panelParametrageCarte.add(this.lstCarte);
        //image
        //image predef
        //couleur
        this.panelParametrageCarte.add(this.btnVerso);

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
        
    }
}
