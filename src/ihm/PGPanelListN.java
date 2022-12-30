package ihm;
import java.util.List;
import ihm.customComponent.*;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import controleur.Controleur;
import metier.Noeud;
import java.awt.event.*;

public class PGPanelListN extends javax.swing.JPanel 
{
    private Controleur ctrl;
    /**
     * Creates new form PGPanelListN
     */
    public PGPanelListN(Controleur ctrl)
    {   
        this.ctrl = ctrl;
        lstNoeud = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<Noeud>();
        lblNom = new javax.swing.JLabel();
        lblPosition = new javax.swing.JLabel();
        lblPositionNom = new javax.swing.JLabel();
        lblCouleur = new javax.swing.JLabel();
        txtNom      = new TextFieldWithHint("New");
        txtPosY     = new TextFieldWithHint("Y");
        txtPosX     = new TextFieldWithHint("X");
        txtPosNomX  = new TextFieldWithHint("X");
        txtPosNomY  = new TextFieldWithHint("Y");
        btnCouleur = new javax.swing.JButton();
        btnAjouter = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();

        setBackground(new java.awt.Color(68, 71, 90));

        jList1.setModel(new AbstractListModel<Noeud>() {
            List<Noeud> lstNoeud = ctrl.getNoeuds();
            public int getSize() { return lstNoeud.size();}
            public Noeud getElementAt(int index) {return lstNoeud.get(index);}
            
        });
        lstNoeud.setViewportView(jList1);

        lblNom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNom.setForeground(new java.awt.Color(255, 255, 255));
        lblNom.setText("Nom");

        lblPosition.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPosition.setForeground(new java.awt.Color(255, 255, 255));
        lblPosition.setText("Position");

        lblPositionNom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPositionNom.setForeground(new java.awt.Color(255, 255, 255));
        lblPositionNom.setText("Position Nom");

        lblCouleur.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCouleur.setForeground(new java.awt.Color(255, 255, 255));
        lblCouleur.setText("Couleur");

        txtNom.setBackground(new java.awt.Color(40, 42, 54));
        txtNom.setForeground(new java.awt.Color(255, 255, 255,100));
        txtNom.setColumns(9);
        txtNom.setBorder(null);
        txtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });
        
        txtPosY.setBackground(new java.awt.Color(40, 42, 54));
        txtPosY.setForeground(new java.awt.Color(255, 255, 255,100));
        txtPosY.setBorder(null);
        txtPosY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPosYActionPerformed(evt);
            }
        });

        txtPosX.setBackground(new java.awt.Color(40, 42, 54));
        txtPosX.setForeground(new java.awt.Color(255, 255, 255,100));
        txtPosX.setBorder(null);
        txtPosX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPosXActionPerformed(evt);
            }
        });

        txtPosNomX.setBackground(new java.awt.Color(40, 42, 54));
        txtPosNomX.setForeground(new java.awt.Color(255, 255, 255,100));
        txtPosNomX.setBorder(null);
        txtPosNomX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPosNomXActionPerformed(evt);
            }
        });

        txtPosNomY.setBackground(new java.awt.Color(40, 42, 54));
        txtPosNomY.setForeground(new java.awt.Color(255, 255, 255,100));
        txtPosNomY.setBorder(null);
        txtPosNomY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPosNomYActionPerformed(evt);
            }
        });
        btnCouleur.setFocusPainted(false);
        btnCouleur.setBackground(new java.awt.Color(255, 102, 153));
        btnCouleur.setText(" ");
        btnCouleur.setBorder(null);
        btnCouleur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCouleurActionPerformed(evt);
            }
        });
        btnAjouter.setFocusPainted(false);
        btnAjouter.setBackground(new java.awt.Color(40, 42, 54));
        btnAjouter.setForeground(new java.awt.Color(255, 255, 255));
        btnAjouter.setText("Ajouter");
        btnAjouter.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });
        btnSupprimer.setFocusPainted(false);
        btnSupprimer.setBackground(new java.awt.Color(40, 42, 54));
        btnSupprimer.setForeground(new java.awt.Color(255, 255, 255));
        btnSupprimer.setText("Supprimer");
        btnSupprimer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20,20,20)
                        .addComponent(btnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lstNoeud, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNom)
                            .addComponent(lblPosition)
                            .addComponent(lblCouleur))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPositionNom)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPosNomX, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPosNomY, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPosX, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPosY, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10,15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNom)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPosition)
                            .addComponent(txtPosX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPosY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPositionNom)
                            .addComponent(txtPosNomX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPosNomY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCouleur)
                            .addComponent(btnCouleur)))
                    .addComponent(lstNoeud, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        
    }                                      

    private void txtPosXActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void txtPosYActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void txtPosNomXActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void txtPosNomYActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void btnCouleurActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          
    private boolean isFormValide ()
    {
        try
        {
            int posX,posY,posNomX,posNomY;
            posX    = Integer.parseInt(txtPosX.getText());
            posY    = Integer.parseInt(txtPosY.getText());
            posNomX = Integer.parseInt(txtPosNomX.getText());
            posNomY = Integer.parseInt(txtPosNomY.getText());
            return true;
        }
        catch (NumberFormatException e) {return false;}
    }
    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        if (isFormValide())
        {
            this.ctrl.ajouterNoeud(this.txtNom.getText(), Integer.parseInt(this.txtPosX.getText()), 
                                   Integer.parseInt(this.txtPosY.getText()), Integer.parseInt(this.txtPosNomX.getText()), Integer.parseInt(this.txtPosNomY.getText()), 
                                   this.btnCouleur.getBackground());
            this.jList1.updateUI();
        }


    }                                          

    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnCouleur;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JList<Noeud> jList1;
    private javax.swing.JLabel lblCouleur;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblPositionNom;
    private javax.swing.JScrollPane lstNoeud;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPosNomX;
    private javax.swing.JTextField txtPosNomY;
    private javax.swing.JTextField txtPosX;
    private javax.swing.JTextField txtPosY;
    // End of variables declaration        
    
    public void appliquerTheme()
    {
        
    }
}