package ihm;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Color;

import controleur.Controleur;

public class FramePoint extends JFrame
{
    private Controleur ctrl;
    private JPanel panelPoint;

    private JTable tablePoint;
    private String[] tabEntetes;
    private Object[][] tabDonnees;

    private JButton   btnAjouter;
    private JButton   btnSupprimer;
    private JButton   btnOk;
    
    public FramePoint(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setTitle("Modifier les points");
        this.setSize(470, 200);
        this.setLocation(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        /*PANEL POINT */
        this.panelPoint = new JPanel();
        this.panelPoint.setBackground(new Color(68, 71, 90));
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
        this.tablePoint.setBackground(new Color(68, 71, 90));
        this.tablePoint.setForeground(Color.WHITE);

        spGrilleDonnees = new JScrollPane(this.tablePoint);
        spGrilleDonnees.setSize(200, 200);

        this.panelPoint.add(spGrilleDonnees);

        /*Panel button */
        JPanel panelButton = new JPanel();
        panelButton.setBackground(new Color(68, 71, 90));
        this.btnAjouter = new JButton("Ajouter");
        this.btnAjouter.setBackground(new Color(68, 71, 90));
        this.btnAjouter.setForeground(Color.WHITE);
        this.btnSupprimer = new JButton("Supprimer");
        this.btnSupprimer.setBackground(new Color(68, 71, 90));
        this.btnSupprimer.setForeground(Color.WHITE);
        this.btnOk = new JButton("Ok");
        this.btnOk.setBackground(new Color(68, 71, 90));
        this.btnOk.setForeground(Color.WHITE);

        panelButton.add(this.btnAjouter);
        panelButton.add(this.btnSupprimer);
        panelButton.add(this.btnOk);

        this.add(this.panelPoint, BorderLayout.CENTER);
        this.add(panelButton, BorderLayout.SOUTH);
        this.setVisible(true);
        
    }
}
