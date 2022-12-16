package ihm;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controleur.Controleur;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

public class PGPanelParamJeu extends javax.swing.JPanel {

    
	private Controleur ctrl;
	private int        nbCarteWagon=0;
	private int        nbJoker=0;
	/**
     * Creates new form PGPanelParamJeu
     */
    public PGPanelParamJeu(Controleur ctrl) {
		this.ctrl = ctrl;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. 
     */                    
    private void initComponents() {

        lblParamJeu = new javax.swing.JLabel();
        lblNbJoueurs = new javax.swing.JLabel();
        lblModif = new javax.swing.JLabel();
        lblMultiCoul = new javax.swing.JLabel();
        lblNbCarteParCoul = new javax.swing.JLabel();
        lblImgCarte = new javax.swing.JLabel();
        lblCartesWagon = new javax.swing.JLabel();
        txtMinJoueur = new javax.swing.JTextField();
        txtMaxJoueur = new javax.swing.JTextField();
        txtNbJoker = new javax.swing.JTextField();
        txtNbCarteParCoul = new javax.swing.JTextField();
        //txtPathImgCarteWagon = new javax.swing.JTextField();
        btnPlusJoker = new javax.swing.JButton();
        btnCouleurs = new javax.swing.JButton();
        btnPoints = new javax.swing.JButton();
        btnObjectifs = new javax.swing.JButton();
        btnPlusCoul = new javax.swing.JButton();
        btnMoinsJoker = new javax.swing.JButton();
        btnMoinsCoul = new javax.swing.JButton();
        jButtonCarteWagon = new javax.swing.JButton();

        setBackground(new java.awt.Color(68, 71, 90));

        lblParamJeu.setBackground(new java.awt.Color(49, 51, 63));
        lblParamJeu.setForeground(new java.awt.Color(255, 255, 255));
        lblParamJeu.setText(" Parametre du jeu");
        lblParamJeu.setOpaque(true);

        lblNbJoueurs.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNbJoueurs.setForeground(new java.awt.Color(255, 255, 255));
        lblNbJoueurs.setText("Nombre de joueurs");

        lblModif.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblModif.setForeground(new java.awt.Color(255, 255, 255));
        lblModif.setText("Modifier");

        lblMultiCoul.setForeground(new java.awt.Color(255, 255, 255));
        lblMultiCoul.setText("nb carte multicolore");

        lblNbCarteParCoul.setForeground(new java.awt.Color(255, 255, 255));
        lblNbCarteParCoul.setText("nb carte par couleur");

        lblImgCarte.setForeground(new java.awt.Color(255, 255, 255));
        lblImgCarte.setText("image cartes");

        lblCartesWagon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCartesWagon.setForeground(new java.awt.Color(255, 255, 255));
        lblCartesWagon.setText("Cartes wagon");

        txtMinJoueur.setBackground(new java.awt.Color(53, 55, 70));
        txtMinJoueur.setForeground(new java.awt.Color(255, 255, 255));
        txtMinJoueur.setText("Min");
        txtMinJoueur.setBorder(null);
        txtMinJoueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinJoueurActionPerformed(evt);
            }
        });

        txtMaxJoueur.setBackground(new java.awt.Color(53, 55, 70));
        txtMaxJoueur.setForeground(new java.awt.Color(255, 255, 255));
        txtMaxJoueur.setText("Max");
        txtMaxJoueur.setBorder(null);
        txtMaxJoueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaxJoueurActionPerformed(evt);
            }
        });

        txtNbJoker.setBackground(new java.awt.Color(53, 55, 70));
        txtNbJoker.setForeground(new java.awt.Color(255, 255, 255));
        txtNbJoker.setText("10");
        txtNbJoker.setBorder(null);
        txtNbJoker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNbJokerActionPerformed(evt);
            }
        });

        txtNbCarteParCoul.setBackground(new java.awt.Color(53, 55, 70));
        txtNbCarteParCoul.setForeground(new java.awt.Color(255, 255, 255));
        txtNbCarteParCoul.setText("10");
        txtNbCarteParCoul.setBorder(null);
        txtNbCarteParCoul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNbCarteParCoulActionPerformed(evt);
            }
        });

        /*txtPathImgCarteWagon.setBackground(new java.awt.Color(53, 55, 70));
        txtPathImgCarteWagon.setForeground(new java.awt.Color(255, 255, 255));
        txtPathImgCarteWagon.setText("Parcourir");
        txtPathImgCarteWagon.setBorder(null);
        txtPathImgCarteWagon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPathImgCarteWagonActionPerformed(evt);
            }
        });*/


        btnCouleurs.setBackground(new java.awt.Color(40, 42, 54));
        btnCouleurs.setForeground(new java.awt.Color(255, 255, 255));
        btnCouleurs.setText("Couleurs");
        btnCouleurs.setBorder(null);
        btnCouleurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCouleursActionPerformed(evt);
            }
        });

        btnPoints.setBackground(new java.awt.Color(40, 42, 54));
        btnPoints.setForeground(new java.awt.Color(255, 255, 255));
        btnPoints.setText("Points");
        btnPoints.setBorder(null);
        btnPoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPointsActionPerformed(evt);
            }
        });

        btnObjectifs.setBackground(new java.awt.Color(40, 42, 54));
        btnObjectifs.setForeground(new java.awt.Color(255, 255, 255));
        btnObjectifs.setText("Objectifs");
        btnObjectifs.setBorder(null);
        btnObjectifs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObjectifsActionPerformed(evt);
            }
        });

        btnPlusCoul.setText("+");
        btnPlusCoul.setToolTipText("+");
        btnPlusCoul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusCoulActionPerformed(evt);
            }
        });
        btnMoinsJoker.setText("-");
        btnMoinsJoker.setToolTipText("+");
        btnMoinsJoker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoinsJokerActionPerformed(evt);
            }
        });
        btnPlusJoker.setText("+");
        btnPlusJoker.setToolTipText("+");
        btnPlusJoker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusJokerActionPerformed(evt);
            }
        });
        btnMoinsCoul.setText("-");
        btnMoinsCoul.setToolTipText("+");
        btnMoinsCoul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoinsCoulActionPerformed(evt);
            }
        });

        jButtonCarteWagon.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCarteWagon.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCarteWagon.setText("...");
        jButtonCarteWagon.setBorder(null);
        jButtonCarteWagon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarteWagonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblParamJeu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNbJoueurs)
                            .addComponent(lblCartesWagon)
                            .addComponent(lblNbCarteParCoul))
                        .addGap(15, 15, 15)
                        .addComponent(txtMinJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaxJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblModif)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCouleurs, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMultiCoul)
                                .addGap(52, 52, 52)
                                .addComponent(btnMoinsJoker))
                            .addComponent(btnMoinsCoul))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnObjectifs, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNbCarteParCoul, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPlusCoul))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNbJoker, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPlusJoker))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImgCarte)
                        .addGap(55, 55, 55)
                        //.addComponent(txtPathImgCarteWagon, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButtonCarteWagon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblParamJeu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNbJoueurs)
                    .addComponent(txtMinJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCartesWagon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNbCarteParCoul))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNbCarteParCoul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMoinsCoul, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPlusCoul, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMultiCoul)
                    .addComponent(txtNbJoker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPlusJoker, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoinsJoker, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImgCarte)
                    //.addComponent(txtPathImgCarteWagon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCarteWagon))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCouleurs, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnObjectifs, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblModif))
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void txtMinJoueurActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void txtMaxJoueurActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void txtNbJokerActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void txtNbCarteParCoulActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    /*private void txtPathImgCarteWagonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }*/                                                   

    private void btnCouleursActionPerformed(java.awt.event.ActionEvent evt) 
	{                                            
        this.ctrl.afficher("couleur");
    }                                           

    private void btnPointsActionPerformed(java.awt.event.ActionEvent evt) 
	{                                          
        this.ctrl.afficher("points");
    }                                         

    private void btnObjectifsActionPerformed(java.awt.event.ActionEvent evt) 
	{                                             
        this.ctrl.afficher("objectif");
    }                                            

    private void btnMoinsCoulActionPerformed(java.awt.event.ActionEvent evt) 
	{ 
		this.nbCarteWagon = Integer.parseInt(txtNbCarteParCoul.getText());
		if (this.nbCarteWagon > 0)
		{	
			this.nbCarteWagon--;
			txtNbCarteParCoul.setText(Integer.toString(this.nbCarteWagon));
		}
		else
		{
			this.nbCarteWagon = 0;
			txtNbCarteParCoul.setText(Integer.toString(this.nbCarteWagon));
		}
        
    }                                            
    private void btnPlusCoulActionPerformed(java.awt.event.ActionEvent evt)
	{
		this.nbCarteWagon = Integer.parseInt(txtNbCarteParCoul.getText());
		this.nbCarteWagon++;
		txtNbCarteParCoul.setText(Integer.toString(this.nbCarteWagon));

		if (this.nbCarteWagon < 0)
		{
			this.nbCarteWagon = 0;
			txtNbCarteParCoul.setText(Integer.toString(this.nbCarteWagon));
		}
    }
    private void btnMoinsJokerActionPerformed(java.awt.event.ActionEvent evt)
	{
		this.nbJoker = Integer.parseInt(txtNbJoker.getText());
		if (this.nbJoker > 0)
		{
			this.nbJoker--;
			txtNbJoker.setText(Integer.toString(this.nbJoker));
		}
		else
		{
			this.nbJoker = 0;
			txtNbJoker.setText(Integer.toString(this.nbJoker));
		}

    }
    private void btnPlusJokerActionPerformed(java.awt.event.ActionEvent evt)
	{
		this.nbJoker = Integer.parseInt(txtNbJoker.getText());
		this.nbJoker++;
		txtNbJoker.setText(Integer.toString(this.nbJoker));

		if (this.nbJoker < 0)
		{
			this.nbJoker = 0;
			txtNbJoker.setText(Integer.toString(this.nbJoker));
		}
    }
    private void jButtonCarteWagonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new FrameCreerCarteJoueur (this.ctrl);
    }                                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCouleurs;
    private javax.swing.JButton btnMoinsCoul;
    private javax.swing.JButton btnMoinsJoker;
    private javax.swing.JButton btnObjectifs;
    private javax.swing.JButton btnPlusCoul;
    private javax.swing.JButton btnPlusJoker;
    private javax.swing.JButton btnPoints;
    private javax.swing.JButton jButtonCarteWagon;
    private javax.swing.JLabel lblCartesWagon;
    private javax.swing.JLabel lblImgCarte;
    private javax.swing.JLabel lblModif;
    private javax.swing.JLabel lblMultiCoul;
    private javax.swing.JLabel lblNbCarteParCoul;
    private javax.swing.JLabel lblNbJoueurs;
    private javax.swing.JLabel lblParamJeu;
    private javax.swing.JTextField txtMaxJoueur;
    private javax.swing.JTextField txtMinJoueur;
    private javax.swing.JTextField txtNbCarteParCoul;
    private javax.swing.JTextField txtNbJoker;
    //private javax.swing.JTextField txtPathImgCarteWagon;
    // End of variables declaration                   
}