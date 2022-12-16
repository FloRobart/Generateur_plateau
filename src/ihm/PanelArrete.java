package ihm;

import java.awt.Color;
import java.awt.BorderLayout;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import metier.Noeud;


public class PanelArrete extends JPanel implements KeyListener, MouseListener
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

    private List<Noeud>       lstNoeudA;
    private List<Noeud>       lstNoeudB;

    public PanelArrete(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setBackground(new Color(68, 71, 90));
        this.setLayout(new BorderLayout());

        /*Panel liste aretes */
        JPanel panelListe = new JPanel();
        panelListe.setBackground(new Color(68, 71, 90));

        this.aretes = this.ctrl.getMetier().getAretes();
        this.listModel = new DefaultListModel<String>();

        for (Arete a : this.aretes) {
            ((DefaultListModel<String>) this.listModel).addElement(a.getNoeud1().getNom() + "-" + a.getNoeud2().getNom());
        }
        
        this.listAretes = new JList<String>(this.listModel);

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


        lstNoeudA = this.ctrl.getMetier().getNoeuds();
        lstNoeudB = this.ctrl.getMetier().getNoeuds();
        
        String[] tabNoeudA = new String[lstNoeudA.size()];
        String[] tabNoeudB = new String[lstNoeudB.size()];
        
        for(int cpt =0; cpt < lstNoeudA.size(); cpt++)
        {
            tabNoeudA[cpt] = lstNoeudA.get(cpt).getNom();
            tabNoeudB[cpt] = lstNoeudB.get(cpt).getNom();
        }

        cbA = new JComboBox<String>(tabNoeudA);
        cbB = new JComboBox<String>(tabNoeudB);

        cbA.setVisible(true);
        cbB.setVisible(true);

        this.btnCoul1 = new JButton("Couleur");
        this.btnCoul1.setBackground(null);
        add(this.btnCoul1);
        this.btnCoul1.addActionListener(e -> {
            selectColor1();
        });

        this.btnCoul2 = new JButton("Couleur");
        this.btnCoul2.setBackground(null);
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

        this.listAretes.addMouseListener(this);
            
    }

    /**
     * Methode permettant de supprimer une arete
     */
    private void supprimerArete() 
    {
        String[] noms = this.listModel.getElementAt(this.listAretes.getSelectedIndex()).split("-");

        this.ctrl.getMetier().supprimerArete(noms[0], noms[1]);

        ((DefaultListModel<String>) this.listModel).removeElement(noms[0] + "-" + noms[1]);
        this.effacerForm();
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
        if(!nom1.equals(nom2))
        {
            if(this.couleur2 == null)
            this.ctrl.getMetier().ajouterArete(nom1, nom2, distance, couleur1, null);

            this.ctrl.getMetier().ajouterArete(nom1, nom2, distance, this.couleur1, this.couleur2);
        }
        
        this.effacerForm();
    }


    private void effacerForm() 
    {
        this.cbA.setSelectedIndex(0);
        this.cbB.setSelectedIndex(0);
        this.btnCoul1.setBackground(null);
        this.btnCoul2.setBackground(null);
        this.txtDistance.setText("");
    }

    private void selectColor1() 
    {
        this.couleur1 = JColorChooser.showDialog(this, "Choisir une couleur", Color.BLACK);
        this.btnCoul1.setBackground(this.couleur1);
    }
    private void selectColor2() 
    {
        this.couleur2 = JColorChooser.showDialog(this, "Choisir une couleur", Color.BLACK);
        this.btnCoul2.setBackground(this.couleur2);
    }


    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        if(e.getSource() == this.listAretes)
        {
            String[] noms = this.listModel.getElementAt(this.listAretes.getSelectedIndex()).split("-");
            
            for(Arete a : this.aretes)
            {
                if(a.getNoeud1().getNom().equals(noms[0]) && a.getNoeud2().getNom().equals(noms[1]))
                {
                    this.cbA.setSelectedItem(a.getNoeud1());
                    this.cbB.setSelectedItem(a.getNoeud2());
                    this.txtDistance.setText(String.valueOf(a.getDistance()));
                    this.btnCoul1.setBackground(a.getCouleur1());
                    this.btnCoul2.setBackground(a.getCouleur2());
                }
            }
        }   
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
