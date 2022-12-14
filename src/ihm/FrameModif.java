package ihm;

import javax.swing.JFrame;
import controleur.Controleur;
/*
 * FrameModif.java
 * Frame de test pour les panels de modification
 */
public class FrameModif extends JFrame
{
    private static Controleur ctrl;
    private PanelNoeud panelNoeud;
    private PanelArrete panelArrete;
    private PanelModifObjectif panelModifObjectif;
    
    public FrameModif(Controleur ctrl)
    {
        
        this.setTitle("Modifier l'élément choisit");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.panelNoeud = new PanelNoeud(ctrl);
        //this.add(this.panelNoeud);

        this.panelArrete = new PanelArrete();
        //this.add(this.panelArrete);

        this.panelModifObjectif = new PanelModifObjectif();
        //this.add(this.panelModifObjectif);

        this.setVisible(true);
        
    }

    public static void main(String[] args) {
        FrameModif frame = new FrameModif(ctrl);
    }
    
}
