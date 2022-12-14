package ihm;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.Controleur;

public class FramePoint extends JFrame
{
    private Controleur ctrl;
    private JPanel panelPoint;

    private JTable tablePoint;
    private String[] tabEntetes;
    private Object[][] tabDonnees;
    
    public FramePoint(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setTitle("Modifier les points");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        /*PANEL POINT */
        this.panelPoint = new JPanel();
        JScrollPane spGrilleDonnees;

        //création du tableau de points 
        this.tabDonnees = new Object[5][2];
        for (int cpt=0; cpt < this.tabDonnees.length; cpt++)
        {
            this.tabDonnees[cpt][0] = cpt+1;
            this.tabDonnees[cpt][1] = cpt+1;
        }

        this.tabEntetes = new String[] {"Distance", "Points"}; 
        
        //création du tableau
        this.tablePoint = new JTable(this.tabDonnees, this.tabEntetes);
        this.tablePoint.setFillsViewportHeight(true);

        spGrilleDonnees = new JScrollPane(this.tablePoint);

        this.panelPoint.add(spGrilleDonnees);

        this.add(this.panelPoint);
        this.setVisible(false);
        
    }
}
