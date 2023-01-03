package ihm.frames;

import javax.swing.JFrame;
import controleur.Controleur;
import ihm.panels.PanelAjoutObjectif;
import ihm.panels.PanelArete;
import ihm.panels.PanelNoeud;
/*
 * FrameModif.java
 * Frame de test pour les panels de modification
 */
public class FrameModif extends JFrame
{
    public FrameModif(Controleur ctrl)
    {
        this.setTitle("Modifier l'élément choisit");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        new PanelNoeud(ctrl);
        //this.add(this.panelNoeud);

        new PanelArete(ctrl);
        //this.add(this.panelArrete);

        new PanelAjoutObjectif(ctrl);
        //this.add(this.panelAjoutObjectif);

        //this.setVisible(true);
        
    }

   /* public static void main(String[] args) {
        Controleur ctrl = new Controleur();
         FrameModif frame = new FrameModif(ctrl);
    }*/
}
