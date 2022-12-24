package ihm;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

import controleur.Controleur;


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
    private JLabel     lblImgCarte;
    private JLabel     lblModif;
    private JLabel     lblMultiCoul;
    private JLabel     lblNbCarteParCoul;
    private JLabel     lblNbJoueurs;
    private JLabel     lblParamJeu;
    private JLabel     lblCartesWagon;

    private JTextField txtMaxNbJoueur;
    private JTextField txtMinJoueur;
    private JTextField txtNbCarteParCoul;
    private JTextField txtNbJoker;



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
        this.txtMinJoueur         = new JTextField();
        this.txtMaxNbJoueur       = new JTextField();
        this.txtNbJoker           = new JTextField();
        this.txtNbCarteParCoul    = new JTextField();
        this.btnPlusJoker         = new JButton   ();
        this.btnCouleurs          = new JButton   ();
        this.btnPoints            = new JButton   ();
        this.btnObjectifs         = new JButton   ();
        this.btnPlusCoul          = new JButton   ();
        this.btnMoinsJoker        = new JButton   ();
        this.btnMoinsCoul         = new JButton   ();
        this.btnChoisirImg             = new JButton   ();


        this.lblParamJeu.setText(" Parametre du jeu");

        this.lblNbJoueurs.setFont(new Font("Segoe UI", 1, 12));
        this.lblNbJoueurs.setText("Nombre de joueurs");

        this.lblModif.setFont(new Font("Segoe UI", 1, 12));
        this.lblModif.setText("Modifier");

        this.lblMultiCoul.setFont(new Font("Segoe UI", 1, 12));
        this.lblMultiCoul.setText("multicouleurs");

        this.lblNbCarteParCoul.setFont(new Font("Segoe UI", 1, 12));
        this.lblNbCarteParCoul.setText("nb couleurs");

        this.lblImgCarte.setFont(new Font("Segoe UI", 1, 12));
        this.lblImgCarte.setText("image cartes");

        lblCartesWagon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCartesWagon.setForeground(new java.awt.Color(255, 255, 255));
        lblCartesWagon.setText("Cartes wagon");

        this.txtMinJoueur.setText("Min");
        this.txtMinJoueur.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtMinJoueurActionPerformed(e);
            }
        });


        this.txtMaxNbJoueur.setText("Max");
        this.txtMaxNbJoueur.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtMaxNbJoueurActionPerformed(e);
            }
        });


        this.txtNbJoker.setText("10");
        this.txtNbJoker.setHorizontalAlignment(JTextField.CENTER);
        this.txtNbJoker.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtNbJokerActionPerformed(e);
            }
        });


        this.txtNbCarteParCoul.setText("10");
        this.txtNbCarteParCoul.setHorizontalAlignment(JTextField.CENTER);
        this.txtNbCarteParCoul.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtNbCarteParCoulActionPerformed(e);
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


        this.btnChoisirImg.setText("Choisir une image");
        this.btnChoisirImg.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnChoisirImgActionPerformed(e);
            }
        });


        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblParamJeu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNbJoueurs)
                            .addComponent(lblCartesWagon))
                        .addGap(15, 15, 15)
                        .addComponent(txtMinJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaxNbJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblModif)
                        .addGap(43, 43, 43)
                        .addComponent(btnCouleurs, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnObjectifs, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblImgCarte)
                            .addGap(55, 55, 55)
                            .addComponent(btnChoisirImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblMultiCoul)
                                    .addGap(52, 52, 52)
                                    .addComponent(btnMoinsJoker))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNbCarteParCoul)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnMoinsCoul)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtNbCarteParCoul, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnPlusCoul))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtNbJoker, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnPlusJoker))))))
                .addContainerGap(15, Short.MAX_VALUE))
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
                    .addComponent(btnChoisirImg))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModif)
                    .addComponent(btnCouleurs, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObjectifs, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        this.appliquerTheme();
    }


    private void txtMinJoueurActionPerformed        (ActionEvent e) {}
    private void txtMaxNbJoueurActionPerformed      (ActionEvent e) {}
    private void txtNbJokerActionPerformed          (ActionEvent e) {}
    private void txtNbCarteParCoulActionPerformed   (ActionEvent e) {}


    private void btnCouleursActionPerformed (ActionEvent e) { new FrameCouleur(ctrl); }
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
        String filePath = "";
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("JPG & JPEG & GIF & PNG Images", "jpg", "gif", "png", "jpeg"));
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fc.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION)
		{
			File file = fc.getSelectedFile();
			filePath  = file.getAbsolutePath();
			BufferedImage img;
			try 
			{
				img = ImageIO.read(new File(filePath));
				this.ctrl.setImageFond(img);
			}
            catch(IOException ex)
            {
                ex.printStackTrace();
                System.out.println("Erreur lors de la lecture de l'image");
            }
        }
    }


    /**
     * Applique le thème à tout les composants du panel
     */
    public void appliquerTheme()
	{
		Color background     = this.ctrl.getTheme().get("background").get(0);
        Color titleForeColor = this.ctrl.getTheme().get("titles"    ).get(0);
		Color titleBackColor = this.ctrl.getTheme().get("titles"    ).get(1);
        Color labelForeColor = this.ctrl.getTheme().get("labels"    ).get(0);
		Color labelBackColor = this.ctrl.getTheme().get("labels"    ).get(1);
        Color saisiForeColor = this.ctrl.getTheme().get("saisies"   ).get(0);
		Color saisiBackColor = this.ctrl.getTheme().get("saisies"   ).get(1);
        Color btnForeColor   = this.ctrl.getTheme().get("bottuns"   ).get(0);
		Color btnBackColor   = this.ctrl.getTheme().get("bottuns"   ).get(1);


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

        this.txtMinJoueur.setBorder(null);
        this.txtMinJoueur.setBackground(saisiBackColor);
        this.txtMinJoueur.setForeground(saisiForeColor);

        this.txtMaxNbJoueur.setBorder(null);
        this.txtMaxNbJoueur.setBackground(saisiBackColor);
        this.txtMaxNbJoueur.setForeground(saisiForeColor);

        this.txtNbJoker.setBorder(null);
        this.txtNbJoker.setBackground(saisiBackColor);
        this.txtNbJoker.setForeground(saisiForeColor);

        this.txtNbCarteParCoul.setBorder(null);
        this.txtNbCarteParCoul.setBackground(saisiBackColor);
        this.txtNbCarteParCoul.setForeground(saisiForeColor);

        this.btnCouleurs.setBorder(null);
        this.btnCouleurs.setBackground(btnBackColor);
        this.btnCouleurs.setForeground(btnForeColor);

        this.btnPoints.setBorder(null);
        this.btnPoints.setBackground(btnBackColor);
        this.btnPoints.setForeground(btnForeColor);

        this.btnObjectifs.setBorder(null);
        this.btnObjectifs.setBackground(btnBackColor);
        this.btnObjectifs.setForeground(btnForeColor);

        this.btnPlusCoul.setBorder(null);
        this.btnPlusCoul.setBackground(btnBackColor);
        this.btnPlusCoul.setForeground(btnForeColor);

        this.btnMoinsJoker.setBorder(null);
        this.btnMoinsJoker.setBackground(btnBackColor);
        this.btnMoinsJoker.setForeground(btnForeColor);

        this.btnPlusJoker.setBorder(null);
        this.btnPlusJoker.setBackground(btnBackColor);
        this.btnPlusJoker.setForeground(btnForeColor);

        this.btnMoinsCoul.setBorder(null);
        this.btnMoinsCoul.setBackground(btnBackColor);
        this.btnMoinsCoul.setForeground(btnForeColor);

        this.btnChoisirImg.setBorder(null);
        this.btnChoisirImg.setBackground(btnBackColor);
        this.btnChoisirImg.setForeground(btnForeColor);
	}
}