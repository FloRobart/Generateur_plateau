  package ihm.panels.panelGenerateur;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.HashMap;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.ListModel;
import javax.swing.border.BevelBorder;

import controleur.Controleur;
import ihm.customComponent.TextFieldWithHint;
import metier.Arete;
import metier.Noeud;


public class PGPanelListA extends JPanel
{
    private Controleur        ctrl;

    private JButton           btnAjouter;
    private JButton           btnCouleurAB;
    private JButton           btnCouleurBA;
    private JButton           btnSupprimer;
    private JCheckBox         cb2Sens;
    private JComboBox<String> comboBoxListNoeudA;
    private JComboBox<String> comboBoxListNoeudB;
    private JList<String>     jListAretes;
    private JScrollPane       jScrollPane1;
    private JLabel            lbl2Sens;
    private JLabel            lblCouleurAB;
    private JLabel            lblCouleurBA;
    private JLabel            lblDistance;
    private JLabel            lblNoeudA;
    private JLabel            lblNoeudB;
    private TextFieldWithHint txtDistance;

    private List<Noeud>       lstNoeudA;
    private List<Noeud>       lstNoeudB;

    private Color             couleurAB;
    private Color             couleurBA;

    private ListModel<String> listModel;


    /**
     * Creates new form PGPanelListA
     */
    public PGPanelListA(Controleur ctrl)
    {
        this.ctrl               = ctrl;

        this.jScrollPane1       = new JScrollPane      ();
        this.jListAretes        = new JList<String>    ();
        this.lblNoeudA          = new JLabel           ();
        this.lblNoeudB          = new JLabel           ();
        this.lbl2Sens           = new JLabel           ();
        this.lblCouleurAB       = new JLabel           ();
        this.lblDistance        = new JLabel           ();
        this.lblCouleurBA       = new JLabel           ();
        this.comboBoxListNoeudA = new JComboBox<String>();
        this.comboBoxListNoeudB = new JComboBox<String>();
        this.cb2Sens            = new JCheckBox        ();
        this.txtDistance        = new TextFieldWithHint("Distance", ctrl);
        this.btnCouleurAB       = new JButton          ();
        this.btnCouleurBA       = new JButton          ();
        this.btnAjouter         = new JButton          ();
        this.btnSupprimer       = new JButton          ();
        this.lstNoeudA          = ctrl.getNoeuds       ();
        this.lstNoeudB          = ctrl.getNoeuds       ();
        this.listModel          = new DefaultListModel<>();


        /* jListAretes */

        for (Arete a : this.ctrl.getAretes()) {
            ((DefaultListModel<String>) this.listModel).addElement(a.toString());
        }
        this.jListAretes.setModel(new AbstractListModel<String>()
        {
            ListModel<String> lstAretes = listModel;

            public int getSize()
            {
                return lstAretes.getSize();
            }

            public String getElementAt(int index)
            {
                return lstAretes.getElementAt(index);
            }
        });



        /* Ajout de la list1 dans un JScrollPane */
        this.jScrollPane1.setViewportView(jListAretes);

        /* lblNoeudA */
        this.lblNoeudA.setText("Noeud A");
        this.lblNoeudA.setFont(new Font("Segoe UI", 1, 12));

        /* lblNoeudB */
        this.lblNoeudB.setText("Noeud B");
        this.lblNoeudB.setFont(new Font("Segoe UI", 1, 12));

        /* lbl2Sens */
        this.lbl2Sens.setText("2 sens");
        this.lbl2Sens.setFont(new Font("Segoe UI", 1, 12));

        /* lblCouleurAB */
        this.lblCouleurAB.setText("Couleur AB");
        this.lblCouleurAB.setFont(new Font("Segoe UI", 1, 12));

        /* lblDistance */
        this.lblDistance.setText("Distance");
        this.lblDistance.setFont(new Font("Segoe UI", 1, 12));

        /* lblCouleurBA */
        this.lblCouleurBA.setText("Couleur BA");
        this.lblCouleurBA.setFont(new Font("Segoe UI", 1, 12));

        /* comboBoxListNoeudA */
        String[] tabNoeudA = new String[lstNoeudA.size()];
        String[] tabNoeudB = new String[lstNoeudB.size()];
        for (int i = 0; i < lstNoeudA.size(); i++)
        {
            tabNoeudA[i] = lstNoeudA.get(i).getNom();
            tabNoeudB[i] = lstNoeudB.get(i).getNom();
        }

        this.comboBoxListNoeudA.setModel(new DefaultComboBoxModel<>(tabNoeudA));
        this.comboBoxListNoeudA.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                comboBoxListNoeudAActionPerformed(evt);
            }
        });

        this.comboBoxListNoeudB.setModel(new DefaultComboBoxModel<>(tabNoeudB));
        this.comboBoxListNoeudB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                comboBoxListNoeudBActionPerformed(evt);
            }
        });

        this.cb2Sens.setSelected(false);
        this.cb2Sens.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                cb2SensActionPerformed(evt);
            }
        });

        this.txtDistance.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) 
            {
               txtDistanceKeyPressed(ke);
            }
         });

        this.btnCouleurAB.setText("Couleur");
        this.btnCouleurAB.setFocusPainted(false);
        this.btnCouleurAB.addActionListener(e ->
        {
            selectColorAB();
        });

        this.btnCouleurBA.setText("Couleur");
        this.btnCouleurBA.setFocusPainted(false);
        this.btnCouleurBA.addActionListener(e ->
        {
            selectColorBA();
        });

        this.btnAjouter.setText("Ajouter");
        this.btnAjouter.setFocusPainted(false);
        this.btnAjouter.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                btnAjouterActionPerformed(evt);
            }
        });

        this.btnSupprimer.setText("Supprimer");
        this.btnSupprimer.setFocusPainted(false);
        this.btnSupprimer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                btnSupprimerActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(this.btnSupprimer, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(this.btnAjouter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(this.jScrollPane1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(this.lbl2Sens)
                        .addGap(47, 47, 47)
                        .addComponent(this.cb2Sens))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(this.lblNoeudA)
                            .addGap(32, 32, 32)
                            .addComponent(this.comboBoxListNoeudA, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(this.lblNoeudB)
                            .addGap(33, 33, 33)
                            .addComponent(this.comboBoxListNoeudB, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(this.lblDistance)
                        .addGap(34, 34, 34)
                        .addComponent(this.txtDistance, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(this.lblCouleurBA)
                            .addGap(18, 18, 18)
                            .addComponent(this.btnCouleurBA, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(this.lblCouleurAB)
                            .addGap(18, 18, 18)
                            .addComponent(this.btnCouleurAB, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10,10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(this.lblNoeudA)
                            .addComponent(this.comboBoxListNoeudA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.lblDistance)
                            .addComponent(this.txtDistance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(this.lblNoeudB)
                            .addComponent(this.comboBoxListNoeudB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.lblCouleurAB)
                            .addComponent(this.btnCouleurAB))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.lbl2Sens)
                                .addComponent(this.cb2Sens, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addComponent(this.lblCouleurBA))
                            .addComponent(this.btnCouleurBA)))
                    .addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.btnAjouter, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.btnSupprimer, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                )
        );

       
        /*Mouse listener */ 
        MouseListener mouseListener = new MouseAdapter() {
            public void mousePressed(MouseEvent e) 
            {
                if(e.getSource() == jListAretes)
                {
                    String[] noms = listModel.getElementAt(jListAretes.getSelectedIndex()).split("-");
                    
                    for(Arete a : ctrl.getAretes())
                    {
                        if(a.getNoeud1().getNom().equals(noms[0]) && a.getNoeud2().getNom().equals(noms[1]))
                        {
                            comboBoxListNoeudA.setSelectedItem(a.getNoeud1());
                            comboBoxListNoeudB.setSelectedItem(a.getNoeud2());
                            txtDistance.setText(String.valueOf(a.getDistance()));
                            btnCouleurAB.setBackground(a.getCouleur1());
                            btnCouleurBA.setBackground(a.getCouleur2());
                            cb2Sens.setSelected(a.is2Sens());
                        }
                    }
                }   
            }
        };
        
        this.appliquerTheme();
    }                      

    private void selectColorBA() 
    {
        this.couleurBA = JColorChooser.showDialog(this, "Choisir une couleur", Color.BLACK);
        this.btnCouleurBA.setBackground(this.couleurBA);
    }


    private void selectColorAB() 
    {
        this.couleurAB = JColorChooser.showDialog(this, "Choisir une couleur", Color.BLACK);
        this.btnCouleurAB.setBackground(this.couleurAB);
    }


    private void btnAjouterActionPerformed        (ActionEvent e)
    {
        String nom1     = (String) this.comboBoxListNoeudA.getSelectedItem();
        String nom2     = (String) this.comboBoxListNoeudB.getSelectedItem();
        int    distance = Integer.parseInt(this.txtDistance.getText());
        
        if(!nom1.equals(nom2))
        {
            if(!this.cb2Sens.isSelected())
                this.ctrl.ajouterArete(nom1, nom2, distance, couleurAB, null);

            this.ctrl.ajouterArete(nom1, nom2, distance, this.couleurAB, this.couleurBA);
        }

        ((DefaultListModel<String>) this.listModel).addElement(nom1 + " - " + nom2);
        this.jListAretes.setModel(this.listModel);

        this.effacerForm(); 
    }


    private void btnSupprimerActionPerformed      (ActionEvent e)
    {
        String[] noms = this.listModel.getElementAt(this.jListAretes.getSelectedIndex()).split("-");

        this.ctrl.supprimerArete(noms[0], noms[1]);

        ((DefaultListModel<String>) this.listModel).removeElement(noms[0] + "-" + noms[1]);
        this.jListAretes.setModel(this.listModel);

        this.effacerForm();
    }
    private void cb2SensActionPerformed           (ActionEvent e){}
    
    private void txtDistanceKeyPressed(KeyEvent ke) 
    {
        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE )
        {
            txtDistance.setEditable(true);
        }
        else
        {
            txtDistance.setEditable(false);
        }
    }

    private void comboBoxListNoeudBActionPerformed(ActionEvent e){}
    private void comboBoxListNoeudAActionPerformed(ActionEvent e){}

    private void effacerForm() 
    {
        this.txtDistance.setText("");
        this.comboBoxListNoeudA.setSelectedIndex(0);
        this.comboBoxListNoeudB.setSelectedIndex(0);
        this.cb2Sens.setSelected(false);
        this.btnCouleurAB.setBackground(this.ctrl.getTheme().get("bottuns").get(1));
        this.btnCouleurBA.setBackground(this.ctrl.getTheme().get("bottuns").get(1));
    }



    public void appliquerTheme()
    {
        HashMap<String, List<Color>> theme = this.ctrl.getTheme();

        Color background       = theme.get("background"  ).get(0);
        Color titleForeColor   = theme.get("titles"      ).get(0);
        Color labelForeColor   = theme.get("labels"      ).get(0);
		Color labelBackColor   = theme.get("labels"      ).get(1);
        Color saisiForeColor   = theme.get("saisies"     ).get(0);
		Color saisiBackColor   = theme.get("saisies"     ).get(1);
        Color placeholderColor = theme.get("saisies"     ).get(2);
        Color btnForeColor     = theme.get("bottuns"     ).get(0);
		Color btnBackColor     = theme.get("bottuns"     ).get(1);


        this.setForeground(titleForeColor);
        this.setBackground(background);
    
        this.jListAretes            .setForeground         (saisiForeColor);
        this.jListAretes            .setBackground         (background    );
        this.jListAretes            .setSelectionForeground(background    );

        this.lblNoeudA         .setForeground(labelForeColor);
        this.lblNoeudA         .setBackground(labelBackColor);

        this.lblNoeudB         .setForeground(labelForeColor);
        this.lblNoeudB         .setBackground(labelBackColor);
        
        this.lbl2Sens          .setForeground(labelForeColor);
        this.lbl2Sens          .setBackground(labelBackColor);
        
        this.lblCouleurAB      .setForeground(labelForeColor);
        this.lblCouleurAB      .setBackground(labelBackColor);

        this.lblDistance       .setForeground(labelForeColor);
        this.lblDistance       .setBackground(labelBackColor);
        
        this.lblCouleurBA      .setForeground(labelForeColor);
        this.lblCouleurBA      .setBackground(labelBackColor);
        
        this.comboBoxListNoeudA.setBorder(null);
        this.comboBoxListNoeudA.setForeground(saisiForeColor);
        this.comboBoxListNoeudA.setBackground(saisiBackColor);
        
        this.comboBoxListNoeudB.setBorder(null);
        this.comboBoxListNoeudB.setForeground(saisiForeColor);
        this.comboBoxListNoeudB.setBackground(saisiBackColor);
        
        this.cb2Sens           .setOpaque    (false);
        this.cb2Sens           .setForeground(saisiForeColor);
        
        this.txtDistance       .setOpaque(true);
        this.txtDistance       .setBorder(null);
        this.txtDistance       .setForeground(placeholderColor);
        this.txtDistance       .setBackground(saisiBackColor  );
        this.txtDistance       .setForegroundColor (saisiForeColor  );
        this.txtDistance       .setPlaceholderColor(placeholderColor);
        this.txtDistance       .setDisabledTextColor(new Color(255, 0, 0));
        
        this.btnCouleurAB      .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnCouleurAB      .setForeground(btnForeColor);
        this.btnCouleurAB      .setBackground(btnBackColor);
        
        this.btnCouleurBA      .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnCouleurBA      .setForeground(btnForeColor);
        this.btnCouleurBA      .setBackground(btnBackColor);
        
        this.btnAjouter        .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnAjouter        .setForeground(btnForeColor);
        this.btnAjouter        .setBackground(btnBackColor);
        
        this.btnSupprimer      .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnSupprimer      .setForeground(btnForeColor);
        this.btnSupprimer      .setBackground(btnBackColor);
    }

}