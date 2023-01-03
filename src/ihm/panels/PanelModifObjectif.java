package ihm.panels;
import java.awt.Color;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.JButton;

import controleur.Controleur;
import metier.Noeud;
/**
 * PanelGererObjectif
 */
public class PanelModifObjectif extends JPanel
{
    private Controleur ctrl;

    private JComboBox<String> cbObjectif;
    private JComboBox<String> cbA;
    private JComboBox<String> cbB;
    private JTextField        txtPoint;
    private JButton           btnSupp;
    private JButton           btnOk;

    public PanelModifObjectif(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setBackground(new Color(68, 71, 90));

        JPanel panelHaut = new JPanel();
        panelHaut.setBackground(new Color(68, 71, 90));
        JPanel panelBas = new JPanel();
        panelBas.setBackground(new Color(68, 71, 90));

        GroupLayout layout = new GroupLayout(this);
        panelHaut.setLayout(layout);

        List<Noeud> noeuds = this.ctrl.getNoeuds();
        String[] tabObjectif = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
        String[] tabNoeudA   = new String[noeuds.size()]; //{ "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
        String[] tabNoeudB   = new String[noeuds.size()]; //{ "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};

        for (Noeud noeud : noeuds)
        {
            tabNoeudA[noeud.getId() - 1] = noeud.getNom();
            tabNoeudB[noeud.getId() - 1] = noeud.getNom();
        }


        cbObjectif = new JComboBox<String>(tabObjectif);
        cbA = new JComboBox<String>(tabNoeudA);
        cbB = new JComboBox<String>(tabNoeudB);

        cbObjectif.setVisible(true);
        cbA.setVisible(true);
        cbB.setVisible(true);

        this.txtPoint = new JTextField();
        this.txtPoint.setBackground(new Color(58, 60, 76));
        this.txtPoint.setForeground(Color.GRAY);
        
        JLabel lblObjectif, lblNoeudA, lblNoeudB, lblPoint;
        lblObjectif = new JLabel("Objectif");
        lblObjectif.setForeground(Color.WHITE);
        lblNoeudA   = new JLabel("Noeud A");
        lblNoeudA.setForeground(Color.WHITE);
        lblNoeudB   = new JLabel("Noeud B");
        lblNoeudB.setForeground(Color.WHITE);
        lblPoint    = new JLabel("Point");
        lblPoint.setForeground(Color.WHITE);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.ParallelGroup hGroup = layout.createParallelGroup();

        hGroup.addGroup(layout.createParallelGroup().
            addComponent(lblObjectif).
            addComponent(lblNoeudA).
            addComponent(lblNoeudB).
            addComponent(lblPoint)
        );
        hGroup.addGroup(layout.createParallelGroup().
            addComponent(cbObjectif).
            addComponent(cbA).
            addComponent(cbB).
            addComponent(txtPoint)
        );

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(lblObjectif).
            addComponent(cbObjectif)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(lblNoeudA).
            addComponent(cbA)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(lblNoeudB).
            addComponent(cbB)
        );
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(lblPoint).
            addComponent(txtPoint)
        );

        layout.setVerticalGroup(vGroup);
        
        this.btnOk = new JButton("OK");
        this.btnOk.setBackground(new Color(58, 60, 76));
        this.btnOk.setForeground(Color.GRAY);

        this.btnSupp = new JButton("Supprimer");
        this.btnSupp.setBackground(new Color(58, 60, 76));
        this.btnSupp.setForeground(Color.GRAY);

        panelBas.add(this.btnSupp);
        panelBas.add(this.btnOk);

        this.add(panelHaut);
        this.add(panelBas);

    }
    
}