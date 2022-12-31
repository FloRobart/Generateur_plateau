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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;

import controleur.Controleur;
import ihm.customComponent.TextFieldWithHint;


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
    private TextFieldWithHint txtPoint;

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
        this.txtPoint           = new  TextFieldWithHint("Point", ctrl);
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
        this.btnAjouter.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        this.btnSupprimer.setText("Supprimer");
        this.btnSupprimer.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        this.comboBoxListNoeudB.setModel(new  DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        this.comboBoxListNoeudB.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                comboBoxListNoeudBActionPerformed(evt);
            }
        });

        this.lblNoeudA.setText("Noeud A");
        this.lblNoeudA.setFont(new Font("Segoe UI", 1, 12));

        this.lblNoeudB.setText("Noeud B");
        this.lblNoeudB.setFont(new Font("Segoe UI", 1, 12));

        this.comboBoxListNoeudA.setFocusable(false);
        this.comboBoxListNoeudA.setModel(new  DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        this.comboBoxListNoeudA.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                comboBoxListNoeudAActionPerformed(evt);
            }
        });

        this.txtPoint.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                txtPointActionPerformed(evt);
            }
        });

        this.lblPoint.setText("Point");
        this.lblPoint.setFont(new Font("Segoe UI", 1, 12));

        this.lblRecto.setText("Recto");
        this.lblRecto.setFont(new Font("Segoe UI", 1, 12));

        this.lblVerso.setText("Verso");
        this.lblVerso.setFont(new Font("Segoe UI", 1, 12));

        this.btnImgRecto.setText("Image");
        this.btnImgRecto.setFocusPainted(false);
        this.btnImgRecto.addActionListener(new  ActionListener()
        {
            public void actionPerformed( ActionEvent evt)
            {
                btnImgRectoActionPerformed(evt);
            }
        });

        this.btnImgVerso.setText("Image");
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
        HashMap<String, List<Color>> theme = this.ctrl.getTheme();

        Color background       = theme.get("background").get(0);
        Color title            = theme.get("titles"    ).get(0);
        Color labelForeColor   = theme.get("labels"    ).get(0);
		Color labelBackColor   = theme.get("labels"    ).get(1);
        Color saisiForeColor   = theme.get("saisies"   ).get(0);
		Color saisiBackColor   = theme.get("saisies"   ).get(1);
        Color placeholderColor = theme.get("saisies"   ).get(2);
        Color btnForeColor     = theme.get("bottuns"   ).get(0);
		Color btnBackColor     = theme.get("bottuns"   ).get(1);


        /* Couleur de fond du panel */
        this.setBackground(background);

        /* ScrollPane contenant la liste des noeuds */
        this.jList1.setForeground(title);
        this.jList1.setBackground(background);
        

        /* Bouton ajouter */
        this.btnAjouter        .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnAjouter        .setForeground(btnForeColor);
        this.btnAjouter        .setBackground(btnBackColor);

        /* Bouton supprimer */
        this.btnSupprimer      .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnSupprimer      .setForeground(btnForeColor);
        this.btnSupprimer      .setBackground(btnBackColor);

        /* Liste des noeuds A */
        this.comboBoxListNoeudB.setBorder(null);
        this.comboBoxListNoeudB.setForeground(saisiForeColor);
        this.comboBoxListNoeudB.setBackground(saisiBackColor);

        /* Label noeuds A */
        this.lblNoeudA         .setBorder(null);
        this.lblNoeudA         .setForeground(labelForeColor);
        this.lblNoeudA         .setBackground(labelBackColor);

        /* Label noeuds B */
        this.lblNoeudB         .setBorder(null);
        this.lblNoeudB         .setForeground(labelForeColor);
        this.lblNoeudB         .setBackground(labelBackColor);

        /* Liste des noeuds B */
        this.comboBoxListNoeudA.setBorder(null);
        this.comboBoxListNoeudA.setForeground(saisiForeColor);
        this.comboBoxListNoeudA.setBackground(saisiBackColor);

        /* TexteField des points */
        this.txtPoint          .setBorder(null);
        this.txtPoint          .setForeground(placeholderColor);
        this.txtPoint          .setBackground(saisiBackColor  );
        this.txtPoint          .setForegroundColor (saisiForeColor  );
        this.txtPoint          .setPlaceholderColor(placeholderColor);

        /* Label des points */
        this.lblPoint          .setBorder(null);
        this.lblPoint          .setForeground(labelForeColor);
        this.lblPoint          .setBackground(labelBackColor);

        /* Label recto */
        this.lblRecto          .setBorder(null);
        this.lblRecto          .setForeground(labelForeColor);
        this.lblRecto          .setBackground(labelBackColor);

        /* Label verso */
        this.lblVerso          .setBorder(null);
        this.lblVerso          .setForeground(labelForeColor);
        this.lblVerso          .setBackground(labelBackColor);

        /* Bouton image recto */
        this.btnImgRecto       .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnImgRecto       .setForeground(btnForeColor);
        this.btnImgRecto       .setBackground(btnBackColor);

        /* Bouton image verso */
        this.btnImgVerso       .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnImgVerso       .setForeground(btnForeColor);
        this.btnImgVerso       .setBackground(btnBackColor);
    }
}