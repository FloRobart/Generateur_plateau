package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

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
import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;

import controleur.Controleur;
import ihm.customComponent.TextFieldWithHint;


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
    private TextFieldWithHint txtDistance;


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
        this.txtDistance        = new TextFieldWithHint("Distance", ctrl);
        this.btnCouleurAB       = new JButton          ();
        this.btnCouleurBA       = new JButton          ();
        this.btnAjouter         = new JButton          ();
        this.btnSupprimer       = new JButton          ();


        /* jList1 */
        this.jList1.setModel(new AbstractListModel<String>()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        /* Ajout de la list1 dans un JScrollPane */
        this.jScrollPane1.setViewportView(jList1);

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
        this.comboBoxListNoeudA.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        this.comboBoxListNoeudA.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                comboBoxListNoeudAActionPerformed(evt);
            }
        });

        this.comboBoxListNoeudB.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        this.comboBoxListNoeudB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                comboBoxListNoeudBActionPerformed(evt);
            }
        });

        this.cb2Sens.setSelected(true);
        this.cb2Sens.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                cb2SensActionPerformed(evt);
            }
        });

        this.txtDistance.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                txtDistanceActionPerformed(evt);
            }
        });

        this.btnCouleurAB.setText("Couleur");
        this.btnCouleurAB.setFocusPainted(false);
        this.btnCouleurAB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                btnCouleurABActionPerformed(evt);
            }
        });

        this.btnCouleurBA.setText("Couleur");
        this.btnCouleurBA.setFocusPainted(false);
        this.btnCouleurBA.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                btnCouleurBAActionPerformed(evt);
            }
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
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAjouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl2Sens)
                        .addGap(47, 47, 47)
                        .addComponent(cb2Sens))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblNoeudA)
                            .addGap(32, 32, 32)
                            .addComponent(comboBoxListNoeudA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblNoeudB)
                            .addGap(33, 33, 33)
                            .addComponent(comboBoxListNoeudB, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDistance)
                        .addGap(34, 34, 34)
                        .addComponent(txtDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCouleurBA)
                            .addGap(18, 18, 18)
                            .addComponent(btnCouleurBA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCouleurAB)
                            .addGap(18, 18, 18)
                            .addComponent(btnCouleurAB, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10,10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNoeudA)
                            .addComponent(comboBoxListNoeudA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDistance)
                            .addComponent(txtDistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNoeudB)
                            .addComponent(comboBoxListNoeudB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCouleurAB)
                            .addComponent(btnCouleurAB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl2Sens)
                                .addComponent(cb2Sens, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCouleurBA))
                            .addComponent(btnCouleurBA)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                )
        );


        this.appliquerTheme();
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
    
        this.jList1            .setForeground         (saisiForeColor);
        this.jList1            .setBackground         (background    );
        this.jList1            .setSelectionForeground(background    );

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