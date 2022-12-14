package ihm;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.Controleur;

public class FrameModif extends JFrame
{
    private static Controleur ctrl;
    private PanelNoeud panelNoeud;
    private PanelArrete panelArrete;
    
    public FrameModif(Controleur ctrl)
    {
        
        this.setTitle("Modifier l'élément choisit");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.panelNoeud = new PanelNoeud(ctrl);
        //this.add(this.panelNoeud);

        this.panelArrete = new PanelArrete();
        this.add(this.panelArrete);

        this.setVisible(true);
        
    }

    public static void main(String[] args) {
        FrameModif frame = new FrameModif(ctrl);
    }
    
}
