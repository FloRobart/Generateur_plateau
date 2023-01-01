package ihm;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controleur.Controleur;


public class FramePoint extends JFrame implements ActionListener
{
    private Controleur ctrl;
    private JPanel     panelPoint;

    private JTable     tablePoint;
    private String[]   tabEntetes;
    private Object[][] tabDonnees;

    private JButton    btnAjouter;
    private JButton    btnSupprimer;
    private JButton    btnOk;

    private int        index=0;
    
    public FramePoint(Controleur ctrl)
    {
        this.ctrl = ctrl;

        this.setTitle("Modifier les points");
        this.setSize(500, 200);
        this.setLocation(500, 300);
        this.setLayout(new BorderLayout());

        /*PANEL POINT */
        this.panelPoint = new JPanel();
        this.panelPoint.setBackground(new Color(68, 71, 90));
        JScrollPane spGrilleDonnees;

        //création du tableau de points 
        List<Integer> listPoint = this.ctrl.getMetier().getPoints();
        this.tabDonnees = new Object[100][2];

        for (int cpt=0; cpt < listPoint.size(); cpt++)
        {
            this.tabDonnees[cpt][0] = cpt+1;
            this.tabDonnees[cpt][1] = listPoint.get(cpt);
        }

        this.tabEntetes = new String[] {"Distance", "Points"}; 
        
        //création du tableau
        this.tablePoint = new JTable(this.tabDonnees, this.tabEntetes);
        this.tablePoint.setFillsViewportHeight(true);
        this.tablePoint.setBackground(new Color(68, 71, 90));
        this.tablePoint.setForeground(Color.WHITE);
        this.tablePoint.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        this.tablePoint.setFillsViewportHeight(true);

        spGrilleDonnees = new JScrollPane(this.tablePoint);
        spGrilleDonnees.setVerticalScrollBar(new JScrollBar());
        spGrilleDonnees.setWheelScrollingEnabled(true);
        spGrilleDonnees.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

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
        this.setVisible(false);

        this.btnAjouter.addActionListener(this);
        this.btnSupprimer.addActionListener(this);
        this.btnOk.addActionListener(this);
        
    }

    public void majIHM()
	{
		new FramePoint(ctrl);
		this.dispose();
	}

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == this.btnAjouter)
        {   
            this.tabDonnees[this.index][0] = this.index+1;
            this.tabDonnees[this.index][1] = this.index+1;
            this.index++;
            this.tablePoint.updateUI();
            this.ctrl.setNbPoint(this.index);
            
        }
        if (e.getSource() == this.btnSupprimer) 
        {
            this.tabDonnees[this.index-1][0] = null;
            this.tabDonnees[this.index-1][1] = null;
            this.index--;
            this.tablePoint.updateUI();
            this.ctrl.supprimerPoint();
        }

        if (e.getSource() == this.btnOk) 
        {
            this.setVisible(false);
        }

    }
}
