package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import controleur.Controleur;


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
    private JList<String>     jList1;
    private JScrollPane       jScrollPane1;
    private JLabel            lbl2Sens;
    private JLabel            lblCouleurAB;
    private JLabel            lblCouleurBA;
    private JLabel            lblDistance;
    private JLabel            lblNoeudA;
    private JLabel            lblNoeudB;
    private JTextField        txtDistance;


    /**
     * Creates new form PGPanelListA
     */
    public PGPanelListA(Controleur ctrl)
    {
        this.ctrl               = ctrl;
        this.jScrollPane1       = new JScrollPane      ();
        this.jList1             = new JList<String>    ();
        this.lblNoeudA          = new JLabel           ();
        this.lblNoeudB          = new JLabel           ();
        this.lbl2Sens           = new JLabel           ();
        this.lblCouleurAB       = new JLabel           ();
        this.lblDistance        = new JLabel           ();
        this.lblCouleurBA       = new JLabel           ();
        this.comboBoxListNoeudA = new JComboBox<String>();
        this.comboBoxListNoeudB = new JComboBox<String>();
        this.cb2Sens            = new JCheckBox        ();
        this.txtDistance        = new JTextField       ();
        this.btnCouleurAB       = new JButton          ();
        this.btnCouleurBA       = new JButton          ();
        this.btnAjouter         = new JButton          ();
        this.btnSupprimer       = new JButton          ();


        /* jList1 */
        this.jList1.setModel(new AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        /* Ajout de la list1 dans un JScrollPane */
        this.jScrollPane1.setViewportView(jList1);

        /* lblNoeudA */
        this.lblNoeudA.setFont(new Font("Segoe UI", 1, 12));
        this.lblNoeudA.setText("Noeud A");

        /* lblNoeudB */
        this.lblNoeudB.setFont(new Font("Segoe UI", 1, 12));
        this.lblNoeudB.setText("Noeud B");

        /* lbl2Sens */
        this.lbl2Sens.setFont(new Font("Segoe UI", 1, 12));
        this.lbl2Sens.setText("2 sens");

        /* lblCouleurAB */
        this.lblCouleurAB.setFont(new Font("Segoe UI", 1, 12));
        this.lblCouleurAB.setText("Couleur AB");

        /* lblDistance */
        this.lblDistance.setFont(new Font("Segoe UI", 1, 12));
        this.lblDistance.setText("Distance");

        /* lblCouleurBA */
        this.lblCouleurBA.setFont(new Font("Segoe UI", 1, 12));
        this.lblCouleurBA.setText("Couleur BA");

        /* comboBoxListNoeudA */
        this.comboBoxListNoeudA.setBackground(new Color(40, 42, 54));
        this.comboBoxListNoeudA.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        this.comboBoxListNoeudA.setBorder(null);
        this.comboBoxListNoeudA.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                comboBoxListNoeudAActionPerformed(evt);
            }
        });

        comboBoxListNoeudB.setBackground(new Color(40, 42, 54));
        comboBoxListNoeudB.setForeground(new Color(255, 255, 255));
        comboBoxListNoeudB.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxListNoeudB.setBorder(null);
        comboBoxListNoeudB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                comboBoxListNoeudBActionPerformed(evt);
            }
        });

        cb2Sens.setBackground(new Color(68, 71, 90));
        cb2Sens.setSelected(true);
        cb2Sens.setBorder(null);
        cb2Sens.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                cb2SensActionPerformed(evt);
            }
        });

        txtDistance.setBackground(new Color(40, 42, 54));
        txtDistance.setForeground(new Color(255, 255, 255));
        txtDistance.setBorder(null);
        txtDistance.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                txtDistanceActionPerformed(evt);
            }
        });

        btnCouleurAB.setFocusPainted(false);
        btnCouleurAB.setText(" ");
        btnCouleurAB.setBorder(null);
        btnCouleurAB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                btnCouleurABActionPerformed(evt);
            }
        });

        btnCouleurBA.setFocusPainted(false);
        btnCouleurBA.setText(" ");
        btnCouleurBA.setBorder(null);
        btnCouleurBA.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                btnCouleurBAActionPerformed(evt);
            }
        });

        btnAjouter.setFocusPainted(false);
        btnAjouter.setBackground(new Color(40, 42, 54));
        btnAjouter.setForeground(new Color(255, 255, 255));
        btnAjouter.setText("Ajouter");
        btnAjouter.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAjouter.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                btnAjouterActionPerformed(evt);
            }
        });

        btnSupprimer.setFocusPainted(false);
        btnSupprimer.setBackground(new Color(40, 42, 54));
        btnSupprimer.setForeground(new Color(255, 255, 255));
        btnSupprimer.setText("Supprimer");
        btnSupprimer.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSupprimer.addActionListener(new ActionListener()
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
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSupprimer, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl2Sens)
                        .addGap(47, 47, 47)
                        .addComponent(cb2Sens))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblNoeudA)
                            .addGap(32, 32, 32)
                            .addComponent(comboBoxListNoeudA, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblNoeudB)
                            .addGap(33, 33, 33)
                            .addComponent(comboBoxListNoeudB, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btnAjouter, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDistance)
                        .addGap(34, 34, 34)
                        .addComponent(txtDistance, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCouleurBA)
                            .addGap(18, 18, 18)
                            .addComponent(btnCouleurBA, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCouleurAB)
                            .addGap(18, 18, 18)
                            .addComponent(btnCouleurAB, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNoeudA)
                            .addComponent(comboBoxListNoeudA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDistance)
                            .addComponent(txtDistance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNoeudB)
                            .addComponent(comboBoxListNoeudB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCouleurAB)
                            .addComponent(btnCouleurAB))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl2Sens)
                                .addComponent(cb2Sens, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCouleurBA))
                            .addComponent(btnCouleurBA)))
                    .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btnAjouter, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSupprimer, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }                      


    private void cb2SensActionPerformed           (ActionEvent e){}
    private void btnSupprimerActionPerformed      (ActionEvent e){}
    private void btnAjouterActionPerformed        (ActionEvent e){}
    private void btnCouleurBAActionPerformed      (ActionEvent e){}
    private void btnCouleurABActionPerformed      (ActionEvent e){}
    private void txtDistanceActionPerformed       (ActionEvent e){}
    private void comboBoxListNoeudBActionPerformed(ActionEvent e){}
    private void comboBoxListNoeudAActionPerformed(ActionEvent e){}


    public void appliquerTheme()
    {
        Color background     = this.ctrl.getTheme().get("background").get(0);
        Color titleForeColor = this.ctrl.getTheme().get("titles"    ).get(0);
        Color labelForeColor = this.ctrl.getTheme().get("labels"    ).get(0);
		Color labelBackColor = this.ctrl.getTheme().get("labels"    ).get(1);
        Color saisiForeColor = this.ctrl.getTheme().get("saisies"   ).get(0);
		Color saisiBackColor = this.ctrl.getTheme().get("saisies"   ).get(1);
        Color btnForeColor   = this.ctrl.getTheme().get("bottuns"   ).get(0);
		Color btnBackColor   = this.ctrl.getTheme().get("bottuns"   ).get(1);


        this.setForeground(titleForeColor);
        this.setBackground(background);
    
        this.jList1            .setForeground(saisiForeColor);
        this.jList1            .setBackground(background    );
        this.jList1            .setSelectionForeground(background);

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
        
        this.comboBoxListNoeudA.setForeground(saisiForeColor);
        this.comboBoxListNoeudA.setBackground(saisiBackColor);
        
        this.comboBoxListNoeudB.setForeground(saisiForeColor);
        this.comboBoxListNoeudB.setBackground(saisiBackColor);
        
        this.cb2Sens           .setForeground(saisiForeColor);
        this.cb2Sens           .setBackground(saisiForeColor);
        
        this.txtDistance       .setForeground(saisiForeColor);
        this.txtDistance       .setBackground(saisiBackColor);
        
        this.btnCouleurAB      .setForeground(btnForeColor);
        this.btnCouleurAB      .setBackground(btnBackColor);
        
        this.btnCouleurBA      .setForeground(btnForeColor);
        this.btnCouleurBA      .setBackground(btnBackColor);
        
        this.btnAjouter        .setForeground(btnForeColor);
        this.btnAjouter        .setBackground(btnBackColor);
        
        this.btnSupprimer      .setForeground(btnForeColor);
        this.btnSupprimer      .setBackground(btnBackColor);
    }
}