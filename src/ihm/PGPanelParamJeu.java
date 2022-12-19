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
    private JLabel     lblCartesWagon;
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
    private JTextField txtPathImgCarteWagon;



	/**
     * Creates new form PGPanelParamJeu
     * @param ctrl : Controleur faisant le lien avec l'IHM
     */
    public PGPanelParamJeu(Controleur ctrl)
    {
		this.ctrl = ctrl;
        this.initComponents();
    }


    /**
     * cette méthode est appelée par le constructeur pour initialiser le formulaire
     * ATTENTION : NE PAS modifier ce code
     */
    private void initComponents()
    {
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
        this.txtPathImgCarteWagon = new JTextField();
        this.btnPlusJoker         = new JButton   ();
        this.btnCouleurs          = new JButton   ();
        this.btnPoints            = new JButton   ();
        this.btnObjectifs         = new JButton   ();
        this.btnPlusCoul          = new JButton   ();
        this.btnMoinsJoker        = new JButton   ();
        this.btnMoinsCoul         = new JButton   ();
        this.jButton1             = new JButton   ();

        this.setBackground(new Color(68, 71, 90));

        this.lblParamJeu.setBackground(new Color(49, 51, 63));
        this.lblParamJeu.setForeground(new Color(255, 255, 255));
        this.lblParamJeu.setText(" Parametre du jeu");
        this.lblParamJeu.setOpaque(true);

        this.lblNbJoueurs.setFont(new Font("Segoe UI", 1, 12));
        this.lblNbJoueurs.setForeground(new Color(255, 255, 255));
        this.lblNbJoueurs.setText("Nombre de joueurs");

        this.lblModif.setFont(new Font("Segoe UI", 1, 12));
        this.lblModif.setForeground(new Color(255, 255, 255));
        this.lblModif.setText("Modifier");

        this.lblMultiCoul.setForeground(new Color(255, 255, 255));
        this.lblMultiCoul.setText(" multicouleurs");

        this.lblNbCarteParCoul.setForeground(new Color(255, 255, 255));
        this.lblNbCarteParCoul.setText(" nb couleurs");

        this.lblImgCarte.setForeground(new Color(255, 255, 255));
        this.lblImgCarte.setText("image cartes");

        this.lblCartesWagon.setFont(new Font("Segoe UI", 1, 12));
        this.lblCartesWagon.setForeground(new Color(255, 255, 255));
        this.lblCartesWagon.setText("Cartes wagon");

        this.txtMinJoueur.setBackground(new Color(53, 55, 70));
        this.txtMinJoueur.setForeground(new Color(255, 255, 255));
        this.txtMinJoueur.setText("Min");
        this.txtMinJoueur.setBorder(null);
        this.txtMinJoueur.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtMinJoueurActionPerformed(e);
            }
        });


        this.txtMaxNbJoueur.setBackground(new Color(53, 55, 70));
        this.txtMaxNbJoueur.setForeground(new Color(255, 255, 255));
        this.txtMaxNbJoueur.setText("Max");
        this.txtMaxNbJoueur.setBorder(null);
        this.txtMaxNbJoueur.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtMaxNbJoueurActionPerformed(e);
            }
        });


        this.txtNbJoker.setBackground(new Color(53, 55, 70));
        this.txtNbJoker.setForeground(new Color(255, 255, 255));
        this.txtNbJoker.setText("10");
        this.txtNbJoker.setBorder(null);
        this.txtNbJoker.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtNbJokerActionPerformed(e);
            }
        });


        this.txtNbCarteParCoul.setBackground(new Color(53, 55, 70));
        this.txtNbCarteParCoul.setForeground(new Color(255, 255, 255));
        this.txtNbCarteParCoul.setText("10");
        this.txtNbCarteParCoul.setBorder(null);
        this.txtNbCarteParCoul.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtNbCarteParCoulActionPerformed(e);
            }
        });


        this.txtPathImgCarteWagon.setBackground(new Color(53, 55, 70));
        this.txtPathImgCarteWagon.setForeground(new Color(255, 255, 255));
        this.txtPathImgCarteWagon.setText("Parcourir");
        this.txtPathImgCarteWagon.setBorder(null);
        this.txtPathImgCarteWagon.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtPathImgCarteWagonActionPerformed(e);
            }
        });


        this.btnCouleurs.setBackground(new Color(40, 42, 54));
        this.btnCouleurs.setForeground(new Color(255, 255, 255));
        this.btnCouleurs.setText("Couleurs");
        this.btnCouleurs.setBorder(null);
        this.btnCouleurs.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnCouleursActionPerformed(e);
            }
        });


        this.btnPoints.setBackground(new Color(40, 42, 54));
        this.btnPoints.setForeground(new Color(255, 255, 255));
        this.btnPoints.setText("Points");
        this.btnPoints.setBorder(null);
        this.btnPoints.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnPointsActionPerformed(e);
            }
        });


        this.btnObjectifs.setBackground(new Color(40, 42, 54));
        this.btnObjectifs.setForeground(new Color(255, 255, 255));
        this.btnObjectifs.setText("Objectifs");
        this.btnObjectifs.setBorder(null);
        this.btnObjectifs.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnObjectifsActionPerformed(e);
            }
        });


        this.btnPlusCoul.setText("+");
        this.btnPlusCoul.setToolTipText("+");
        this.btnPlusCoul.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnPlusCoulActionPerformed(e);
            }
        });


        this.btnMoinsJoker.setText("-");
        this.btnMoinsJoker.setToolTipText("+");
        this.btnMoinsJoker.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnMoinsJokerActionPerformed(e);
            }
        });


        this.btnPlusJoker.setText("+");
        this.btnPlusJoker.setToolTipText("+");
        this.btnPlusJoker.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnPlusJokerActionPerformed(e);
            }
        });


        this.btnMoinsCoul.setText("-");
        this.btnMoinsCoul.setToolTipText("+");
        this.btnMoinsCoul.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnMoinsCoulActionPerformed(e);
            }
        });


        this.jButton1.setBackground(new Color(0, 0, 0));
        this.jButton1.setForeground(new Color(255, 255, 255));
        this.jButton1.setText("...");
        this.jButton1.setBorder(null);
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
                            .addComponent(this.lblCartesWagon)
                            .addComponent(this.lblNbCarteParCoul))
                        .addGap(15, 15, 15)
                        .addComponent(this.txtMinJoueur, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(this.txtMaxNbJoueur, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(this.lblModif)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(this.btnCouleurs, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(this.lblMultiCoul)
                                .addGap(52, 52, 52)
                                .addComponent(this.btnMoinsJoker))
                            .addComponent(this.btnMoinsCoul))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(this.btnObjectifs, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(this.btnPoints, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
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
                        .addGap(55, 55, 55)
                        .addComponent(this.txtPathImgCarteWagon, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(this.jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                        .addComponent(this.lblCartesWagon)
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
                    .addComponent(this.txtPathImgCarteWagon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
    }


    private void txtMinJoueurActionPerformed        (ActionEvent e) {}
    private void txtMaxNbJoueurActionPerformed      (ActionEvent e) {}
    private void txtNbJokerActionPerformed          (ActionEvent e) {}
    private void txtNbCarteParCoulActionPerformed   (ActionEvent e) {}
    private void txtPathImgCarteWagonActionPerformed(ActionEvent e) {}


    private void btnCouleursActionPerformed (ActionEvent e) { this.ctrl.afficher("couleur" ); }
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
}