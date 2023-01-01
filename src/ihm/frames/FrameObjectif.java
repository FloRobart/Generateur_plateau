package ihm.frames;

import javax.swing.JFrame;

import controleur.Controleur;
import ihm.panels.PanelAjoutObjectif;

public class FrameObjectif extends JFrame
{
    private Controleur ctrl;
    private PanelAjoutObjectif panelAjoutObjectif;
    
    public FrameObjectif(Controleur ctrl)
    {
        this.ctrl = ctrl;
    
        this.setTitle("Objectif");
        this.setSize(500, 300);
        this.setLocation(500, 300);
        
        this.panelAjoutObjectif = new PanelAjoutObjectif(this.ctrl);
        this.add(this.panelAjoutObjectif);

    }
}
