package ihm.panels.panelGenerateur;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

import controleur.Controleur;
import ihm.customComponent.TextFieldWithHint;
import ihm.frames.FrameCouleur;
import ihm.frames.FrameCreerCarteWagon;


public class PGPanelParamJeu extends JPanel
{
	private Controleur ctrl;
	private int        nbCarteWagon = 0;
	private int        nbJoker      = 0;

    private JButton    btnCouleurs;
    private JButton    btnMoinsCoul;
    private JButton    btnMoinsJoker;
    private JButton    btnObjectifs;
    private JButton    btnPlusCoul;
    private JButton    btnPlusJoker;
    private JButton    btnPoints;
    private JButton    btnChoisirImg;
    private JButton    btnMoinsJetonsParCouleur;    
    private JButton    btnMoinsJetonsPourFinir;
    private JButton    btnPlusJetonsParJoueur;
    private JButton    btnPlusJetonsPourFinir;
    private JButton    btnCartesWagon;
    private JLabel     lblImgCarte;
    private JLabel     lblModif;
    private JLabel     lblMultiCoul;
    private JLabel     lblNbCarteParCoul;
    private JLabel     lblNbJoueurs;
    private JLabel     lblParamJeu;
    private JLabel     lblCartesWagon;
    private JLabel lblJetonsPourFinir;
    private JLabel lblJetonsWagons;
    private JLabel lblJetonsParJoueur;
    private JLabel lblJetonsWagon;
    private JTextField txtNbCarteParCoul;
    private JTextField txtNbJoker;

    private TextFieldWithHint txtMaxNbJoueur;
    private TextFieldWithHint txtMinJoueur;
    private TextFieldWithHint txtJetonsPourFinir;
    private TextFieldWithHint txtJetonsParJoueur;


	/**
     * Creates new form PGPanelParamJeu
     * @param ctrl : Controleur faisant le lien avec l'IHM
     */
    public PGPanelParamJeu(Controleur ctrl)
    {
		this.ctrl = ctrl;

        this.lblParamJeu          = new JLabel    ();
        this.lblNbJoueurs         = new JLabel    ();
        this.lblModif             = new JLabel    ();
        this.lblMultiCoul         = new JLabel    ();
        this.lblNbCarteParCoul    = new JLabel    ();
        this.lblImgCarte          = new JLabel    ();
        this.lblCartesWagon       = new JLabel    ();
        this.lblJetonsWagons      = new JLabel();
        this.txtMinJoueur         = new TextFieldWithHint("Min", ctrl);
        this.txtMaxNbJoueur       = new TextFieldWithHint("Max", ctrl);
        this.txtNbJoker           = new JTextField();
        this.txtNbCarteParCoul    = new JTextField();
        this.btnPlusJoker         = new JButton   ();
        this.btnCouleurs          = new JButton   ();
        this.btnPoints            = new JButton   ();
        this.btnObjectifs         = new JButton   ();
        this.btnPlusCoul          = new JButton   ();
        this.btnMoinsJoker        = new JButton   ();
        this.btnMoinsCoul         = new JButton   ();
        this.btnChoisirImg        = new JButton   ();
        this.lblJetonsParJoueur   = new JLabel();
        this.lblJetonsPourFinir   = new JLabel();
        this.txtJetonsParJoueur    = new TextFieldWithHint("10", ctrl);
        this.txtJetonsPourFinir   = new TextFieldWithHint("10", ctrl);
        this.btnCartesWagon       = new JButton();
        this.btnMoinsJetonsParCouleur = new JButton()      ;
        this.btnMoinsJetonsPourFinir  = new JButton()      ;
        this.btnPlusJetonsParJoueur   = new JButton()      ;
        this.btnPlusJetonsPourFinir   = new JButton()      ;

        this.lblParamJeu.setText(" Parametre du jeu");

        this.lblNbJoueurs.setText("Nombre de joueurs");
        this.lblNbJoueurs.setFont(new Font("Segoe UI", 1, 12));

        this.lblModif.setText("Modifier");
        this.lblModif.setFont(new Font("Segoe UI", 1, 12));

        this.lblMultiCoul.setText("multicouleurs");
        this.lblMultiCoul.setFont(new Font("Segoe UI", 1, 12));

        this.lblNbCarteParCoul.setText("nb couleurs");
        this.lblNbCarteParCoul.setFont(new Font("Segoe UI", 1, 12));

        this.lblImgCarte.setText("Créer cartes wagon");
        this.lblImgCarte.setFont(new Font("Segoe UI", 1, 12));
        
        this.lblCartesWagon.setText("Cartes wagon");
        this.lblCartesWagon.setFont(new Font("Segoe UI", 1, 12));

        this.txtMinJoueur.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtMinJoueurActionPerformed(e);
            }
        });

        this.txtMaxNbJoueur.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtMaxNbJoueurActionPerformed(e);
            }
        });


        this.txtNbJoker.setText("10");
        this.txtNbJoker.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtNbJokerActionPerformed(e);
            }
        });


        this.txtNbCarteParCoul.setText("10");
        this.txtNbCarteParCoul.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtNbCarteParCoulActionPerformed(e);
            }
        });
        txtJetonsPourFinir.setBackground(new java.awt.Color(53, 55, 70));
        txtJetonsPourFinir.setForeground(new java.awt.Color(255, 255, 255));
        txtJetonsPourFinir.setText("10");
        txtJetonsPourFinir.setBorder(null);
        txtJetonsPourFinir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJetonsPourFinirActionPerformed(evt);
            }

        });

        txtJetonsParJoueur.setBackground(new java.awt.Color(53, 55, 70));
        txtJetonsParJoueur.setForeground(new java.awt.Color(255, 255, 255));
        txtJetonsParJoueur.setText("10");
        txtJetonsParJoueur.setBorder(null);
        txtJetonsParJoueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJetonsParJoueurActionPerformed(evt);
            }


        });

        this.btnCouleurs.setText("Couleurs");
        this.btnCouleurs.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnCouleursActionPerformed(e);
            }
        });


        this.btnPoints.setText("Points");
        this.btnPoints.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnPointsActionPerformed(e);
            }
        });


        this.btnObjectifs.setText("Objectifs");
        this.btnObjectifs.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnObjectifsActionPerformed(e);
            }
        });


        this.btnPlusCoul.setText("   +   ");
        this.btnPlusCoul.setToolTipText("+");
        this.btnPlusCoul.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnPlusCoulActionPerformed(e);
            }
        });


        this.btnMoinsJoker.setText("   -   ");
        this.btnMoinsJoker.setToolTipText("+");
        this.btnMoinsJoker.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnMoinsJokerActionPerformed(e);
            }
        });


        this.btnPlusJoker.setText("   +   ");
        this.btnPlusJoker.setToolTipText("+");
        this.btnPlusJoker.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnPlusJokerActionPerformed(e);
            }
        });


        this.btnMoinsCoul.setText("   -   ");
        this.btnMoinsCoul.setToolTipText("+");
        this.btnMoinsCoul.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnMoinsCoulActionPerformed(e);
            }
        });


        this.btnChoisirImg.setText("Définir image");
        this.btnChoisirImg.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnChoisirImgActionPerformed(e);
            }
        });
        btnPlusJetonsParJoueur.setText("   +   ");
        btnPlusJetonsParJoueur.setToolTipText("+");
        btnPlusJetonsParJoueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusJetonsParJoueurActionPerformed(evt);
            }
        });

        btnPlusJetonsPourFinir.setText("   +   ");
        btnPlusJetonsPourFinir.setToolTipText("+");
        btnPlusJetonsPourFinir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusJetonsPourFinirActionPerformed(evt);
            }
        });

        btnMoinsJetonsParCouleur.setText("   -   ");
        btnMoinsJetonsParCouleur.setToolTipText("-");
        btnMoinsJetonsParCouleur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoinsJetonsParCouleurActionPerformed(evt);
            }
        });

        btnMoinsJetonsPourFinir.setText("   -   ");
        btnMoinsJetonsPourFinir.setToolTipText("-");
        btnMoinsJetonsPourFinir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoinsJetonsPourFinirActionPerformed(evt);
            }
        });
        btnCartesWagon.setBackground(new java.awt.Color(40, 42, 54));
        btnCartesWagon.setForeground(new java.awt.Color(255, 255, 255));
        btnCartesWagon.setText("Cartes");
        btnCartesWagon.setBorder(null);
        btnCartesWagon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartesWagonActionPerformed(evt);
            }
        });
        lblJetonsPourFinir.setForeground(new java.awt.Color(255, 255, 255));
        lblJetonsPourFinir.setText("pour finir");

        lblJetonsParJoueur.setForeground(new java.awt.Color(255, 255, 255));
        lblJetonsParJoueur.setText("par joueur");

        lblJetonsWagons.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblJetonsWagons.setForeground(new java.awt.Color(255, 255, 255));
        lblJetonsWagons.setText("Jetons wagon");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblParamJeu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJetonsPourFinir)
                    .addComponent(lblJetonsWagons)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNbJoueurs)
                            .addComponent(lblCartesWagon))
                        .addGap(15, 15, 15)
                        .addComponent(txtMinJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaxNbJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblModif)
                            .addComponent(lblJetonsParJoueur)
                            .addComponent(lblNbCarteParCoul)
                            .addComponent(lblMultiCoul))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnMoinsJetonsParCouleur)
                                    .addComponent(btnMoinsJetonsPourFinir))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtJetonsPourFinir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnPlusJetonsPourFinir))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtJetonsParJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnPlusJetonsParJoueur))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCouleurs, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMoinsJoker)
                                .addGap(18, 18, 18)
                                .addComponent(txtNbJoker, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPlusJoker))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMoinsCoul)
                                .addGap(18, 18, 18)
                                .addComponent(txtNbCarteParCoul, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPlusCoul)))))
                .addGap(18, 18, 18)
                .addComponent(btnCartesWagon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblParamJeu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNbJoueurs)
                    .addComponent(txtMinJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxNbJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCartesWagon)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNbCarteParCoul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMoinsCoul, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPlusCoul, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNbCarteParCoul))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNbJoker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPlusJoker, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMoinsJoker, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMultiCoul))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblJetonsWagons)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJetonsParJoueur)
                    .addComponent(txtJetonsParJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPlusJetonsParJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoinsJetonsParCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJetonsPourFinir)
                    .addComponent(txtJetonsPourFinir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPlusJetonsPourFinir, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoinsJetonsPourFinir, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModif)
                    .addComponent(btnCouleurs, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCartesWagon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );



        this.appliquerTheme();
    }


    private void txtMinJoueurActionPerformed        (ActionEvent e) {}
    private void txtMaxNbJoueurActionPerformed      (ActionEvent e) {}
    private void txtNbJokerActionPerformed          (ActionEvent e) {}
    private void txtNbCarteParCoulActionPerformed   (ActionEvent e) {}


    private void btnCouleursActionPerformed (ActionEvent e) { new FrameCouleur(this.ctrl); }
    private void btnPointsActionPerformed   (ActionEvent e) { this.ctrl.afficher("points"  ); }
    private void btnObjectifsActionPerformed(ActionEvent e) { this.ctrl.afficher("objectif"); }


    private void btnMoinsCoulActionPerformed(ActionEvent e) 
	{ 
		this.nbCarteWagon = Integer.parseInt(this.txtNbCarteParCoul.getText());
		if (this.nbCarteWagon > 0)
		{	
			this.nbCarteWagon--;
			this.txtNbCarteParCoul.setText(Integer.toString(this.nbCarteWagon));
		}
		else
		{
			this.nbCarteWagon = 0;
			this.txtNbCarteParCoul.setText(Integer.toString(this.nbCarteWagon));
		}
    }
    

    private void txtJetonsParJoueurActionPerformed(ActionEvent evt) {
    }
    private void btnPlusCoulActionPerformed(ActionEvent e)
	{
		this.nbCarteWagon = Integer.parseInt(this.txtNbCarteParCoul.getText());
		this.nbCarteWagon++;
		this.txtNbCarteParCoul.setText(Integer.toString(this.nbCarteWagon));

		if (this.nbCarteWagon < 0)
		{
			this.nbCarteWagon = 0;
			this.txtNbCarteParCoul.setText(Integer.toString(this.nbCarteWagon));
		}
    }


    private void btnMoinsJokerActionPerformed(ActionEvent e)
	{
		this.nbJoker = Integer.parseInt(this.txtNbJoker.getText());
		if (this.nbJoker > 0)
		{
			this.nbJoker--;
			this.txtNbJoker.setText(Integer.toString(this.nbJoker));
		}
		else
		{
			this.nbJoker = 0;
			this.txtNbJoker.setText(Integer.toString(this.nbJoker));
		}
    }


    private void btnPlusJokerActionPerformed(ActionEvent e)
	{
		this.nbJoker = Integer.parseInt(this.txtNbJoker.getText());
		this.nbJoker++;
		this.txtNbJoker.setText(Integer.toString(this.nbJoker));

		if (this.nbJoker < 0)
		{
			this.nbJoker = 0;
			this.txtNbJoker.setText(Integer.toString(this.nbJoker));
		}
    }


    private void btnChoisirImgActionPerformed(ActionEvent e)
    {                                         
        new FrameCreerCarteWagon(this.ctrl);
    }


    private void txtJetonsPourFinirActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    private void txtJetonsParJoeurActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void btnPlusJetonsParJoueurActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    }                                                      

    private void btnPlusJetonsPourFinirActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    }                                                      

    private void btnMoinsJetonsParCouleurActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        // TODO add your handling code here:
    }                                                        

    private void btnMoinsJetonsPourFinirActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }                                                       

    private void btnCartesWagonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }      
    /**
     * Applique le thème à tout les composants du panel
     */
    public void appliquerTheme()
	{
        HashMap<String, List<Color>> theme = this.ctrl.getTheme();

		Color background       = theme.get("background").get(0);
        Color titleForeColor   = theme.get("titles"    ).get(0);
		Color titleBackColor   = theme.get("titles"    ).get(1);
        Color labelForeColor   = theme.get("labels"    ).get(0);
		Color labelBackColor   = theme.get("labels"    ).get(1);
        Color saisiForeColor   = theme.get("saisies"   ).get(0);
		Color saisiBackColor   = theme.get("saisies"   ).get(1);
        Color placeholderColor = theme.get("saisies"   ).get(2);
        Color btnForeColor     = theme.get("bottuns"   ).get(0);
		Color btnBackColor     = theme.get("bottuns"   ).get(1);


        this.setBackground(background);

        this.lblParamJeu.setOpaque(true);
        this.lblParamJeu.setBorder(null);
        this.lblParamJeu.setBackground(titleBackColor);
        this.lblParamJeu.setForeground(titleForeColor);

        this.lblNbJoueurs.setBorder(null);
        this.lblNbJoueurs.setBackground(labelBackColor);
        this.lblNbJoueurs.setForeground(labelForeColor);

        this.lblModif.setBorder(null);
        this.lblModif.setBackground(labelBackColor);
        this.lblModif.setForeground(labelForeColor);

        this.lblMultiCoul.setBorder(null);
        this.lblMultiCoul.setBackground(labelBackColor);
        this.lblMultiCoul.setForeground(labelForeColor);

        this.lblNbCarteParCoul.setBorder(null);
        this.lblNbCarteParCoul.setBackground(labelBackColor);
        this.lblNbCarteParCoul.setForeground(labelForeColor);

        this.lblImgCarte.setBorder(null);
        this.lblImgCarte.setBackground(labelBackColor);
        this.lblImgCarte.setForeground(labelForeColor);

        this.lblCartesWagon.setBorder(null);
        this.lblCartesWagon.setBackground(labelBackColor);
        this.lblCartesWagon.setForeground(labelForeColor);

        this.txtMinJoueur.setBorder(null);
        this.txtMinJoueur.setBackground(saisiBackColor  );
        this.txtMinJoueur.setForeground(placeholderColor);
        this.txtMinJoueur.setForegroundColor (saisiForeColor  );
        this.txtMinJoueur.setPlaceholderColor(placeholderColor);

        this.txtMaxNbJoueur.setBorder(null);
        this.txtMaxNbJoueur.setBackground(saisiBackColor  );
        this.txtMaxNbJoueur.setForeground(placeholderColor);
        this.txtMaxNbJoueur.setForegroundColor (saisiForeColor  );
        this.txtMaxNbJoueur.setPlaceholderColor(placeholderColor);

        this.txtJetonsParJoueur.setBorder(null);
        this.txtJetonsParJoueur.setBackground(saisiBackColor  );
        this.txtJetonsParJoueur.setForeground(placeholderColor);
        this.txtJetonsParJoueur.setForegroundColor (saisiForeColor  );
        this.txtJetonsParJoueur.setPlaceholderColor(placeholderColor);

        this.txtJetonsPourFinir.setBorder(null);
        this.txtJetonsPourFinir.setBackground(saisiBackColor  );
        this.txtJetonsPourFinir.setForeground(placeholderColor);
        this.txtJetonsPourFinir.setForegroundColor (saisiForeColor  );
        this.txtJetonsPourFinir.setPlaceholderColor(placeholderColor);
        this.txtNbJoker.setBorder(null);
        this.txtNbJoker.setCaretColor(saisiForeColor);
        this.txtNbJoker.setBackground(saisiBackColor);
        this.txtNbJoker.setForeground(saisiForeColor);
        this.txtNbJoker.setHorizontalAlignment(JTextField.CENTER);

        
        this.txtNbCarteParCoul.setBorder(null);
        this.txtNbCarteParCoul.setCaretColor(saisiForeColor);
        this.txtNbCarteParCoul.setBackground(saisiBackColor);
        this.txtNbCarteParCoul.setForeground(saisiForeColor);
        this.txtNbCarteParCoul.setHorizontalAlignment(JTextField.CENTER);

        this.btnCouleurs.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnCouleurs.setBackground(btnBackColor);
        this.btnCouleurs.setForeground(btnForeColor);

        this.btnPoints.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnPoints.setBackground(btnBackColor);
        this.btnPoints.setForeground(btnForeColor);

        this.btnObjectifs.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnObjectifs.setBackground(btnBackColor);
        this.btnObjectifs.setForeground(btnForeColor);

        this.btnPlusCoul.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnPlusCoul.setBackground(btnBackColor);
        this.btnPlusCoul.setForeground(btnForeColor);

        this.btnPlusJetonsParJoueur.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnPlusJetonsParJoueur.setBackground(btnBackColor);
        this.btnPlusJetonsParJoueur.setForeground(btnForeColor);

        this.btnPlusJetonsPourFinir.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnPlusJetonsPourFinir.setBackground(btnBackColor);
        this.btnPlusJetonsPourFinir.setForeground(btnForeColor);

        this.btnMoinsJetonsParCouleur.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnMoinsJetonsParCouleur.setBackground(btnBackColor);
        this.btnMoinsJetonsParCouleur.setForeground(btnForeColor);
        
        this.btnMoinsJetonsPourFinir.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnMoinsJetonsPourFinir.setBackground(btnBackColor);
        this.btnMoinsJetonsPourFinir.setForeground(btnForeColor);

        this.btnMoinsJoker.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnMoinsJoker.setBackground(btnBackColor);
        this.btnMoinsJoker.setForeground(btnForeColor);

        this.btnPlusJoker.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnPlusJoker.setBackground(btnBackColor);
        this.btnPlusJoker.setForeground(btnForeColor);

        this.btnMoinsCoul.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnMoinsCoul.setBackground(btnBackColor);
        this.btnMoinsCoul.setForeground(btnForeColor);

        this.btnChoisirImg.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnChoisirImg.setBackground(btnBackColor);
        this.btnChoisirImg.setForeground(btnForeColor);
	}
}