package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;

import controleur.Controleur;
import ihm.customComponent.TextFieldWithHint;
import metier.Noeud;


public class PGPanelListN extends JPanel 
{
    private Controleur ctrl;

    private JButton           btnAjouter;
    private JButton           btnCouleur;
    private JButton           btnSupprimer;
    private JList<Noeud>      jList1;
    private JLabel            lblCouleur;
    private JLabel            lblNom;
    private JLabel            lblPosition;
    private JLabel            lblPositionNom;
    private JScrollPane       lstNoeud;
    private TextFieldWithHint txtNom;
    private TextFieldWithHint txtPosNomX;
    private TextFieldWithHint txtPosNomY;
    private TextFieldWithHint txtPosX;
    private TextFieldWithHint txtPosY;
    /**
     * Creates new form PGPanelListN
     */
    public PGPanelListN(Controleur ctrl)
    {   
        this.ctrl = ctrl;

        this.lstNoeud       = new JScrollPane      (     );
        this.jList1         = new JList<Noeud>     (     );
        this.lblNom         = new JLabel           (     );
        this.lblPosition    = new JLabel           (     );
        this.lblPositionNom = new JLabel           (     );
        this.lblCouleur     = new JLabel           (     );
        this.txtNom         = new TextFieldWithHint("New", ctrl);
        this.txtPosY        = new TextFieldWithHint("Y"  , ctrl);
        this.txtPosX        = new TextFieldWithHint("X"  , ctrl);
        this.txtPosNomX     = new TextFieldWithHint("X"  , ctrl);
        this.txtPosNomY     = new TextFieldWithHint("Y"  , ctrl);
        this.btnCouleur     = new JButton          (     );
        this.btnAjouter     = new JButton          (     );
        this.btnSupprimer   = new JButton          (     );


        this.jList1.setModel(new AbstractListModel<Noeud>()
        {
            List<Noeud> lstNoeuds = ctrl.getNoeuds();

            public int getSize()
            {
                return lstNoeuds.size();
            }

            public Noeud getElementAt(int index)
            {
                return lstNoeuds.get(index);
            }
        });

        this.lstNoeud.setViewportView(jList1);

        this.lblNom.setText("Nom");
        this.lblNom.setFont(new Font("Segoe UI", 1, 12));

        this.lblPosition.setText("Position");
        this.lblPosition.setFont(new Font("Segoe UI", 1, 12));

        this.lblPositionNom.setText("Position Nom");
        this.lblPositionNom.setFont(new Font("Segoe UI", 1, 12));

        this.lblCouleur.setText("Couleur");
        this.lblCouleur.setFont(new Font("Segoe UI", 1, 12));

        this.txtNom.setColumns(9);
        this.txtNom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });

        this.txtPosY.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtPosYActionPerformed(evt);
            }
        });

        this.txtPosX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtPosXActionPerformed(evt);
            }
        });

        this.txtPosNomX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtPosNomXActionPerformed(evt);
            }
        });

        this.txtPosNomY.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtPosNomYActionPerformed(evt);
            }
        });

        this.btnCouleur.setText("Couleur");
        this.btnCouleur.setFocusPainted(false);
        this.btnCouleur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCouleurActionPerformed(evt);
            }
        });

        this.btnAjouter.setText("Ajouter");
        this.btnAjouter.setFocusPainted(false);
        this.btnAjouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        this.btnSupprimer.setText("Supprimer");
        this.btnSupprimer.setFocusPainted(false);
        this.btnSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
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
                        .addGap(20,20,20)
                        .addComponent(this.btnSupprimer, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(this.lstNoeud, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(this.lblNom)
                            .addComponent(this.lblPosition)
                            .addComponent(this.lblCouleur))
                        .addGap(49, 49, 49))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.lblPositionNom)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.btnAjouter, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.btnCouleur, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(this.txtPosNomX, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(this.txtPosNomY, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(this.txtPosX, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(this.txtPosY, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10,15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(this.lblNom)
                            .addComponent(this.txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(this.lblPosition)
                            .addComponent(this.txtPosX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.txtPosY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(this.lblPositionNom)
                            .addComponent(this.txtPosNomX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.txtPosNomY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(this.lblCouleur)
                            .addComponent(this.btnCouleur)))
                    .addComponent(this.lstNoeud, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.btnSupprimer, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.btnAjouter, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }

    private void txtNomActionPerformed      (ActionEvent e){}
    private void txtPosXActionPerformed     (ActionEvent e){}
    private void txtPosYActionPerformed     (ActionEvent e){}
    private void txtPosNomXActionPerformed  (ActionEvent e){}
    private void txtPosNomYActionPerformed  (ActionEvent e){}
    private void btnCouleurActionPerformed  (ActionEvent e){}
    private void btnSupprimerActionPerformed(ActionEvent e){}

    private boolean isFormValide ()
    {
        try
        {
            Integer.parseInt(this.txtPosX   .getText());
            Integer.parseInt(this.txtPosY   .getText());
            Integer.parseInt(this.txtPosNomX.getText());
            Integer.parseInt(this.txtPosNomY.getText());
            return true;
        }
        catch (NumberFormatException e) {return false;}
    }

    private void btnAjouterActionPerformed(ActionEvent e)
    {
        if (isFormValide())
        {
            this.ctrl.ajouterNoeud(this.txtNom.getText(), Integer.parseInt(this.txtPosX.getText()), 
                                   Integer.parseInt(this.txtPosY.getText()), Integer.parseInt(this.txtPosNomX.getText()), Integer.parseInt(this.txtPosNomY.getText()), 
                                   this.btnCouleur.getBackground());
            this.jList1.updateUI();
        }


    }


    public void appliquerTheme()
    {
        HashMap<String, List<Color>> theme = this.ctrl.getTheme();

        Color background       = theme.get("background").get(0);
        Color labelForeColor   = theme.get("labels"    ).get(0);
		Color labelBackColor   = theme.get("labels"    ).get(1);
        Color saisiForeColor   = theme.get("saisies"   ).get(0);
		Color saisiBackColor   = theme.get("saisies"   ).get(1);
        Color placeholderColor = theme.get("saisies"   ).get(2);
        Color btnForeColor     = theme.get("bottuns"   ).get(0);
		Color btnBackColor     = theme.get("bottuns"   ).get(1);


        this.setBackground(background);

        this.lstNoeud      .setForeground(labelForeColor);
        this.lstNoeud      .setBackground(labelBackColor);

        this.jList1        .setForeground         (saisiForeColor);
        this.jList1        .setBackground         (background    );
        this.jList1        .setSelectionForeground(background    );

        this.lblNom        .setForeground(labelForeColor);
        this.lblNom        .setBackground(labelBackColor);

        this.lblPosition   .setForeground(labelForeColor);
        this.lblPosition   .setBackground(labelBackColor);

        this.lblPositionNom.setForeground(labelForeColor);
        this.lblPositionNom.setBackground(labelBackColor);

        this.lblCouleur    .setForeground(labelForeColor);
        this.lblCouleur    .setBackground(labelBackColor);

        this.btnCouleur    .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnCouleur    .setForeground(btnForeColor);
        this.btnCouleur    .setBackground(btnBackColor);

        this.btnAjouter    .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnAjouter    .setForeground(btnForeColor);
        this.btnAjouter    .setBackground(btnBackColor);

        this.btnSupprimer  .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnSupprimer  .setForeground(btnForeColor);
        this.btnSupprimer  .setBackground(btnBackColor);

        this.txtNom        .setOpaque(true);
        this.txtNom        .setBorder(null);
        this.txtNom        .setForeground(placeholderColor);
        this.txtNom        .setBackground(saisiBackColor);
        this.txtNom        .setForegroundColor (saisiForeColor  );
        this.txtNom        .setPlaceholderColor(placeholderColor);
        this.txtNom        .setDisabledTextColor(new Color(255, 0, 0));

        this.txtPosY       .setOpaque(true);
        this.txtPosY       .setBorder(null);
        this.txtPosY       .setForeground(placeholderColor);
        this.txtPosY       .setBackground(saisiBackColor);
        this.txtPosY       .setForegroundColor (saisiForeColor  );
        this.txtPosY       .setPlaceholderColor(placeholderColor);
        this.txtPosY       .setDisabledTextColor(new Color(255, 0, 0));

        this.txtPosX       .setOpaque(true);
        this.txtPosX       .setBorder(null);
        this.txtPosX       .setForeground(placeholderColor);
        this.txtPosX       .setBackground(saisiBackColor);
        this.txtPosX       .setForegroundColor (saisiForeColor  );
        this.txtPosX       .setPlaceholderColor(placeholderColor);
        this.txtPosX       .setDisabledTextColor(new Color(255, 0, 0));

        this.txtPosNomX    .setOpaque(true);
        this.txtPosNomX    .setBorder(null);
        this.txtPosNomX    .setForeground(placeholderColor);
        this.txtPosNomX    .setBackground(saisiBackColor);
        this.txtPosNomX    .setForegroundColor (saisiForeColor  );
        this.txtPosNomX    .setPlaceholderColor(placeholderColor);
        this.txtPosNomX    .setDisabledTextColor(new Color(255, 0, 0));

        this.txtPosNomY    .setOpaque(true);
        this.txtPosNomY    .setBorder(null);
        this.txtPosNomY    .setForeground(placeholderColor);
        this.txtPosNomY    .setBackground(saisiBackColor);
        this.txtPosNomY    .setForegroundColor (saisiForeColor  );
        this.txtPosNomY    .setPlaceholderColor(placeholderColor);
        this.txtPosNomY    .setDisabledTextColor(new Color(255, 0, 0));
    }
}