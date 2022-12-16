package ihm;

import java.awt.Color;
import java.awt.BorderLayout;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

import controleur.Controleur;
import metier.Arete;

/*Avec la JList, il faudra utiliser le MouseListener avec MousePressed */

public class PanelArrete extends JPanel implements KeyListener
{
    
    private Controleur        ctrl;
    private JList<String>     listAretes;
    
    private JComboBox<String> cbA;
    private JComboBox<String> cbB;
    private JButton           btnCoul1;
    private JButton           btnCoul2;
    private JTextField        txtDistance;

    private JButton           btnAjouter;
    private JButton           btnSupprimer;

    private Color             couleur1;
    private Color             couleur2;

    private ListModel<String> listModel;
    private List<Arete>       aretes;

    public PanelArrete(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setBackground(new Color(68, 71, 90));
        this.setLayout(new BorderLayout());

        /*Panel liste aretes */
        JPanel panelListe = new JPanel();
        panelListe.setBackground(new Color(68, 71, 90));

        this.aretes = this.ctrl.getAretes();
        this.listModel = new DefaultListModel<String>();

        for (Arete a : this.aretes) {
            ((DefaultListModel<String>) this.listModel).addElement(a.getNoeud1().getNom() + "-" + a.getNoeud2().getNom());
        }
        
        this.listAretes = new JList<String>(listModel);

        this.listAretes.setBackground(new Color(58, 60, 76));
        this.listAretes.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(this.listAretes);
        panelListe.add(scrollPane);



        /*Panel info aretes */
        JPanel panelInfos = new JPanel();
        panelInfos.setBackground(new Color(68, 71, 90));

        GroupLayout layout = new GroupLayout(panelInfos);
        panelInfos.setLayout(layout);

        JLabel lblNoeudA, lblNoeudB, lblCoul1, lblCoul2, lblDistance;
        lblNoeudA = new JLabel("Noeud A");
        lblNoeudA.setForeground(Color.WHITE);
        lblNoeudB = new JLabel("Noeud B");
        lblNoeudB.setForeground(Color.WHITE);
        lblCoul1 = new JLabel("Couleur1");
        lblCoul1.setForeground(Color.WHITE);
        lblCoul2 = new JLabel("Couleur2");
        lblCoul2.setForeground(Color.WHITE);

        lblDistance = new JLabel("Distance");
        lblDistance.setForeground(Color.WHITE);

        this.txtDistance = new JTextField();
        this.txtDistance.setBackground(new Color(58, 60, 76));
        this.txtDistance.setForeground(Color.GRAY);

        this.txtDistance.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
               if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE ) {
                  txtDistance.setEditable(true);
               }else
               {
                  txtDistance.setEditable(false);
               }
               
            }
         });


        String[] tabNoeudA = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
        String[] tabNoeudB = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};

        cbA = new JComboBox<String>(tabNoeudA);
        cbB = new JComboBox<String>(tabNoeudB);

        cbA.setVisible(true);
        cbB.setVisible(true);

        this.btnCoul1 = new JButton("Couleur");
        add(this.btnCoul1);
        this.btnCoul1.addActionListener(e -> {
            selectColor1();
        });

        this.btnCoul2 = new JButton("Couleur");
        add(this.btnCoul2);
        this.btnCoul2.addActionListener(e -> {
            selectColor2();
        });

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup().
                addComponent(lblNoeudA).addComponent(lblNoeudB).addComponent(lblCoul1).addComponent(lblCoul2).addComponent(lblDistance));
        
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(cbA).addComponent(cbB).addComponent(this.btnCoul1).addComponent(this.btnCoul2).addComponent(txtDistance));

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblNoeudA).addComponent(cbA));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblNoeudB).addComponent(cbB));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblCoul1).addComponent(this.btnCoul1));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblCoul2).addComponent(this.btnCoul2));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblDistance).addComponent(txtDistance));

        layout.setVerticalGroup(vGroup);

        /*Panel boutons */
        JPanel panelBoutons = new JPanel();
        panelBoutons.setBackground(new Color(68, 71, 90));

        this.btnAjouter = new JButton("Ajouter");
        this.btnAjouter.setBackground(new Color(58, 60, 76));
        this.btnAjouter.setForeground(Color.WHITE);
        this.btnAjouter.addActionListener(e -> {
            ajouterArete();
        });

        this.btnSupprimer = new JButton("Supprimer");
        this.btnSupprimer.setBackground(new Color(58, 60, 76));
        this.btnSupprimer.setForeground(Color.WHITE);
        this.btnSupprimer.addActionListener(e -> {
            supprimerArete();
        });

        panelBoutons.add(this.btnAjouter);
        panelBoutons.add(this.btnSupprimer);


        /*Ajout des panels*/
        this.add(panelListe, BorderLayout.WEST);
        this.add(panelInfos, BorderLayout.CENTER);
        this.add(panelBoutons, BorderLayout.SOUTH);
            
    }

    /**
     * Methode permettant de supprimer une arete
     */
    private void supprimerArete() 
    {
        String nom1 = this.listModel.getElementAt(this.listAretes.getSelectedIndex());
        String nom2 = this.listModel.getElementAt(this.listAretes.getSelectedIndex());

        this.ctrl.supprimerArete(nom1, nom2);

        ((DefaultListModel<String>) this.listModel).removeElement(nom1 + "-" + nom2);
    }     

    /**
     * Methode permettant d'ajouter une arete
     */
    private void ajouterArete() 
    {
        String nom1     = (String) this.cbA.getSelectedItem();
        String nom2     = (String) this.cbB.getSelectedItem();
        int    distance = Integer.parseInt(this.txtDistance.getText());

        ((DefaultListModel<String>) this.listModel).addElement(nom1 + "-" + nom2);

        if(this.couleur2 == null)
            this.ctrl.ajouterArete(nom1, nom2, distance, couleur1, null);

        this.ctrl.ajouterArete(nom1, nom2, distance, this.couleur1, this.couleur2);

    }


    private void selectColor1() 
    {
        Color color = JColorChooser.showDialog(this, "Choisir une couleur", Color.BLACK);
        this.couleur1 = color;
    }
    private void selectColor2() 
    {
        Color color = JColorChooser.showDialog(this, "Choisir une couleur", Color.BLACK);
        this.couleur2 = color;
    }


    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    
}
