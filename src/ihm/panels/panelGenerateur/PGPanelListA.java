package ihm.panels.panelGenerateur;

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


        this.appliquerTheme();
    }                      


    private void btnAjouterActionPerformed        (ActionEvent e){}
    private void btnSupprimerActionPerformed      (ActionEvent e){}
    private void cb2SensActionPerformed           (ActionEvent e){}
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