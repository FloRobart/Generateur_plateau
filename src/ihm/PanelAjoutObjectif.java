package ihm;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Controleur;

public class PanelAjoutObjectif extends JPanel
{
    private Controleur ctrl;
    private JComboBox<String> cbA;
    private JComboBox<String> cbB;
    private JTextField        txtPoint;
    private JButton           btnAjout;

    public PanelAjoutObjectif(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setBackground(new Color(68, 71, 90));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        JLabel lblNoeudA, lblNoeudB, lblPoint;
        lblNoeudA = new JLabel("Noeud A");
        lblNoeudA.setForeground(Color.WHITE);
        lblNoeudB = new JLabel("Noeud B");
        lblNoeudB.setForeground(Color.WHITE);
        lblPoint = new JLabel("Point");
        lblPoint.setForeground(Color.WHITE);
       
        this.txtPoint = new JTextField();
        this.txtPoint.setBackground(new Color(58, 60, 76));
        this.txtPoint.setForeground(Color.GRAY);


        String[] tabNoeudA = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
        String[] tabNoeudB = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};

        cbA = new JComboBox<String>(tabNoeudA);
        cbB = new JComboBox<String>(tabNoeudB);

        cbA.setVisible(true);
        cbB.setVisible(true);

        this.btnAjout = new JButton("Ajouter");
        this.btnAjout.setBackground(new Color(58, 60, 76));
        this.btnAjout.setForeground(Color.WHITE);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup().
                addComponent(lblNoeudA).addComponent(lblNoeudB).addComponent(lblPoint));
        
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(cbA).addComponent(cbB).addComponent(txtPoint).addComponent(btnAjout));

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblNoeudA).addComponent(cbA));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblNoeudB).addComponent(cbB));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblPoint).addComponent(txtPoint));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(btnAjout));

        layout.setVerticalGroup(vGroup);
    }
}
