package ihm;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

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
    private JButton    jButton1;
    private JLabel     lblImgCarte;
    private JLabel     lblModif;
    private JLabel     lblMultiCoul;
    private JLabel     lblNbCarteParCoul;
    private JLabel     lblNbJoueurs;
    private JLabel     lblParamJeu;
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
        this.jButton1             = new JButton   ();


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


        this.jButton1.setText("Choisir une image");
        this.jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                jButton1ActionPerformed(e);
            }
        });


        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.lblParamJeu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(this.lblNbJoueurs)
                            .addComponent(this.lblNbCarteParCoul))
                        .addGap(18, 18, 18) // ancienne valeurs (15, 15, 15)
                        .addComponent(this.txtMinJoueur, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(this.txtMaxNbJoueur, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(this.lblModif)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(this.btnCouleurs, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(this.lblMultiCoul)
                                .addGap(18, 18, 18) // ancienne valeurs (52, 52, 52)
                                .addComponent(this.btnMoinsJoker))
                            .addComponent(this.btnMoinsCoul))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(this.btnObjectifs, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(this.btnPoints, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(this.txtNbCarteParCoul, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(this.btnPlusCoul))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(this.txtNbJoker, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(this.btnPlusJoker))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(this.lblImgCarte)
                        .addGap(18, 18, 18) // ancienne valeurs (55, 55, 55)
                        .addGap(0, 0, 0)
                        .addComponent(this.jButton1, 150, 150, 150)))
                .addContainerGap(78, Short.MAX_VALUE))
        );


        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(this.lblParamJeu, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.lblNbJoueurs)
                    .addComponent(this.txtMinJoueur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.txtMaxNbJoueur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(this.lblNbCarteParCoul))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.txtNbCarteParCoul, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.btnMoinsCoul, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.btnPlusCoul, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.lblMultiCoul)
                    .addComponent(this.txtNbJoker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.btnPlusJoker, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.btnMoinsJoker, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.lblImgCarte)
                    .addComponent(this.jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.btnPoints, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.btnCouleurs, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.btnObjectifs, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
                    .addComponent(this.lblModif))
                .addContainerGap(39, Short.MAX_VALUE))
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


    private void jButton1ActionPerformed(ActionEvent e)
    {                                         
        //new FrameCreerCarteJoueur(this.ctrl);
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

        this.jButton1.setBorder(null);
        this.jButton1.setBackground(btnBackColor);
        this.jButton1.setForeground(btnForeColor);
	}
}