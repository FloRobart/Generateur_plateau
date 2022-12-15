package ihm;

import javax.swing.JFrame;
import controleur.Controleur;
/*
 * FrameModif.java
 * Frame de test pour les panels de modification
 */
public class FrameModif extends JFrame
{
    private Controleur ctrl;
    private PanelNoeud panelNoeud;
    private PanelArrete panelArrete;
    private PanelAjoutObjectif panelModifObjectif;
    
    public FrameModif(Controleur ctrl)
    {
        this.setTitle("Modifier l'élément choisit");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.panelNoeud = new PanelNoeud(ctrl);
        //this.add(this.panelNoeud);

        this.panelArrete = new PanelArrete();
        //this.add(this.panelArrete);

        this.panelModifObjectif = new PanelAjoutObjectif(ctrl);
        //this.add(this.panelModifObjectif);

        this.setVisible(true);
        
    }
}
