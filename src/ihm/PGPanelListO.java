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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;

import controleur.Controleur;


public class PGPanelListO extends  JPanel
{
    private Controleur        ctrl;
    private JButton           btnAjouter;
    private JButton           btnImgRecto;
    private JButton           btnImgVerso;
    private JButton           btnSupprimer;
    private JComboBox<String> comboBoxListNoeudA;
    private JComboBox<String> comboBoxListNoeudB;
    private JList<String>     jList1;
    private JLabel            lblNoeudA;
    private JLabel            lblNoeudB;
    private JLabel            lblPoint;
    private JLabel            lblRecto;
    private JLabel            lblVerso;
    private JScrollPane       jspNoeud;
    private JTextField        txtPoint;

    /**
     * Creates new form PGPanelListO
     */
    public PGPanelListO(Controleur ctrl)
    {
        this.ctrl               = ctrl;
        this.jspNoeud           = new  JScrollPane      ();
        this.jList1             = new  JList<String>    ();
        this.btnAjouter         = new  JButton          ();
        this.btnSupprimer       = new  JButton          ();
        this.comboBoxListNoeudB = new  JComboBox<String>();
        this.lblNoeudA          = new  JLabel           ();
        this.lblNoeudB          = new  JLabel           ();
        this.comboBoxListNoeudA = new  JComboBox<String>();
        this.txtPoint           = new  JTextField       ();
        this.lblPoint           = new  JLabel           ();
        this.lblRecto           = new  JLabel           ();
        this.lblVerso           = new  JLabel           ();
        this.btnImgRecto        = new  JButton          ();
        this.btnImgVerso        = new  JButton          ();


        this.jList1.setModel(new  AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "item 6", "item 7", "item 8" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        this.jspNoeud.setViewportView(jList1);

        
        this.btnAjouter.setText("Ajouter");
        this.btnAjouter.setBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED));
        this.btnAjouter.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        this.btnSupprimer.setBackground(new Color(40, 42, 54));
        this.btnSupprimer.setForeground(new Color(255, 255, 255));
        this.btnSupprimer.setText("Supprimer");
        this.btnSupprimer.setBorder( BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnSupprimer.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        this.comboBoxListNoeudB.setBackground(new Color(40, 42, 54));
        this.comboBoxListNoeudB.setForeground(new Color(255, 255, 255));
        this.comboBoxListNoeudB.setModel(new  DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        this.comboBoxListNoeudB.setBorder(null);
        this.comboBoxListNoeudB.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                comboBoxListNoeudBActionPerformed(evt);
            }
        });

        this.lblNoeudA.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        this.lblNoeudA.setForeground(new Color(255, 255, 255));
        this.lblNoeudA.setText("Noeud A");

        this.lblNoeudB.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        this.lblNoeudB.setForeground(new Color(255, 255, 255));
        this.lblNoeudB.setText("Noeud B");

        this.comboBoxListNoeudA.setBackground(new Color(40, 42, 54));
        this.comboBoxListNoeudA.setForeground(new Color(255, 255, 255));
        this.comboBoxListNoeudA.setModel(new  DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        this.comboBoxListNoeudA.setBorder(null);
        this.comboBoxListNoeudA.setFocusable(false);
        this.comboBoxListNoeudA.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                comboBoxListNoeudAActionPerformed(evt);
            }
        });

        this.txtPoint.setBackground(new Color(40, 42, 54));
        this.txtPoint.setForeground(new Color(255, 255, 255));
        this.txtPoint.setBorder(null);
        this.txtPoint.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                txtPointActionPerformed(evt);
            }
        });

        this.lblPoint.setFont(new Font("Segoe UI", 1, 12));
        this.lblPoint.setText("Point");

        this.lblRecto.setFont(new Font("Segoe UI", 1, 12));
        this.lblRecto.setText("Recto");

        this.lblVerso.setFont(new Font("Segoe UI", 1, 12));
        this.lblVerso.setText("Verso");

        this.btnImgRecto.setText("Image");
        this.btnImgRecto.setBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED));
        this.btnImgRecto.setFocusPainted(false);
        this.btnImgRecto.addActionListener(new  ActionListener()
        {
            public void actionPerformed( ActionEvent evt)
            {
                btnImgRectoActionPerformed(evt);
            }
        });

        this.btnImgVerso.setBackground(new Color(40, 42, 54));
        this.btnImgVerso.setForeground(new Color(255, 255, 255));
        this.btnImgVerso.setText("Image");
        this.btnImgVerso.setBorder( BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnImgVerso.setFocusPainted(false);
        this.btnImgVerso.addActionListener(new  ActionListener()
        {
            public void actionPerformed( ActionEvent evt)
            {
                btnImgVersoActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                    .addComponent(this.btnSupprimer, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.jspNoeud, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.TRAILING, false)
                    .addGroup( GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(this.lblNoeudA)
                        .addGap(32, 32, 32)
                        .addComponent(this.comboBoxListNoeudA, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup( GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(this.lblNoeudB)
                        .addGap(33, 33, 33)
                        .addComponent(this.comboBoxListNoeudB, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(this.lblPoint)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(this.txtPoint, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(this.lblRecto)
                            .addComponent(this.lblVerso))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(this.btnImgVerso, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.btnImgRecto, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(this.btnAjouter, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.jspNoeud, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(this.lblNoeudA)
                            .addComponent(this.comboBoxListNoeudA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.lblRecto)
                            .addComponent(this.btnImgRecto))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(this.lblNoeudB)
                            .addComponent(this.comboBoxListNoeudB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.lblVerso)
                            .addComponent(this.btnImgVerso))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                            .addComponent(this.txtPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.lblPoint))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.btnSupprimer, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.btnAjouter, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        this.appliquerTheme();
    }                 

    private void btnAjouterActionPerformed        (ActionEvent evt){}
    private void btnSupprimerActionPerformed      (ActionEvent evt){}
    private void comboBoxListNoeudBActionPerformed(ActionEvent evt){}
    private void comboBoxListNoeudAActionPerformed(ActionEvent evt){}
    private void txtPointActionPerformed          (ActionEvent evt){}
    private void btnImgRectoActionPerformed       (ActionEvent evt){}
    private void btnImgVersoActionPerformed       (ActionEvent evt){}
    
    public void appliquerTheme()
    {
        Color background     = this.ctrl.getTheme().get("background").get(0);
        Color labelForeColor = this.ctrl.getTheme().get("labels"    ).get(0);
		Color labelBackColor = this.ctrl.getTheme().get("labels"    ).get(1);
        Color saisiForeColor = this.ctrl.getTheme().get("saisies"   ).get(0);
		Color saisiBackColor = this.ctrl.getTheme().get("saisies"   ).get(1);
        Color btnForeColor   = this.ctrl.getTheme().get("bottuns"   ).get(0);
		Color btnBackColor   = this.ctrl.getTheme().get("bottuns"   ).get(1);


        /* Couleur de fond du panel */
        this.setBackground(background);

        /* ScrollPane contenant la liste des noeuds */
        //this.jspNoeud          .setForeground(saisiForeColor);
        this.jspNoeud          .setBackground(saisiBackColor);
        
        // changer la couleur de fond du scrollpane
        this.jspNoeud.getViewport().setOpaque(true);
        this.jspNoeud.getViewport().setBackground(Color.RED);
        

        /* Bouton ajouter */
        this.btnAjouter        .setForeground(btnForeColor);
        this.btnAjouter        .setBackground(btnBackColor);

        /* Bouton supprimer */
        this.btnSupprimer      .setForeground(btnForeColor);
        this.btnSupprimer      .setBackground(btnBackColor);

        /* Liste des noeuds A */
        this.comboBoxListNoeudB.setForeground(saisiForeColor);
        this.comboBoxListNoeudB.setBackground(saisiBackColor);

        /* Label noeuds A */
        this.lblNoeudA         .setForeground(labelForeColor);
        this.lblNoeudA         .setBackground(labelBackColor);

        /* Label noeuds B */
        this.lblNoeudB         .setForeground(labelForeColor);
        this.lblNoeudB         .setBackground(labelBackColor);

        /* Liste des noeuds B */
        this.comboBoxListNoeudA.setForeground(saisiForeColor);
        this.comboBoxListNoeudA.setBackground(saisiBackColor);

        /* TexteField des points */
        this.txtPoint          .setForeground(saisiForeColor);
        this.txtPoint          .setBackground(saisiBackColor);

        /* Label des points */
        this.lblPoint          .setForeground(labelForeColor);
        this.lblPoint          .setBackground(labelBackColor);

        /* Label recto */
        this.lblRecto          .setForeground(labelForeColor);
        this.lblRecto          .setBackground(labelBackColor);

        /* Label verso */
        this.lblVerso          .setForeground(labelForeColor);
        this.lblVerso          .setBackground(labelBackColor);

        /* Bouton image recto */
        this.btnImgRecto       .setForeground(btnForeColor);
        this.btnImgRecto       .setBackground(btnBackColor);

        /* Bouton image verso */
        this.btnImgVerso       .setForeground(btnForeColor);
        this.btnImgVerso       .setBackground(btnBackColor);
    }
}