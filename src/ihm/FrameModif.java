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
    private PanelAjoutObjectif panelAjoutObjectif;
    
    public FrameModif(Controleur ctrl)
    {
        this.setTitle("Modifier l'élément choisit");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.panelNoeud = new PanelNoeud(ctrl);
        this.add(this.panelNoeud);

        this.panelArrete = new PanelArrete(ctrl);
        //this.add(this.panelArrete);

        this.panelAjoutObjectif = new PanelAjoutObjectif(ctrl);
        //this.add(this.panelAjoutObjectif);

        this.setVisible(true);
        
    }

    public static void main(String[] args) {
        Controleur ctrl = new Controleur();
        FrameModif frame = new FrameModif(ctrl);
    }
}
