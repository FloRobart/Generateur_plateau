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
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

import controleur.Controleur;
import ihm.customComponent.TextFieldWithHint;
import ihm.frames.FrameCouleur;


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

    private JTextField txtNbCarteParCoul;
    private JTextField txtNbJoker;

    private TextFieldWithHint txtMaxNbJoueur;
    private TextFieldWithHint txtMinJoueur;


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


        this.lblParamJeu.setText(" Parametre du jeu");

        this.lblNbJoueurs.setText("Nombre de joueurs");
        this.lblNbJoueurs.setFont(new Font("Segoe UI", 1, 12));

        this.lblModif.setText("Modifier");
        this.lblModif.setFont(new Font("Segoe UI", 1, 12));

        this.lblMultiCoul.setText("multicouleurs");
        this.lblMultiCoul.setFont(new Font("Segoe UI", 1, 12));

        this.lblNbCarteParCoul.setText("nb couleurs");
        this.lblNbCarteParCoul.setFont(new Font("Segoe UI", 1, 12));

        this.lblImgCarte.setText("image cartes");
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
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.lblParamJeu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(this.lblNbJoueurs)
                            .addComponent(this.lblCartesWagon))
                        .addGap(15, 15, 15)
                        .addComponent(this.txtMinJoueur, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(this.txtMaxNbJoueur, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(this.lblModif)
                        .addGap(43, 43, 43)
                        .addComponent(this.btnCouleurs, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(this.btnPoints, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(this.btnObjectifs, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(this.lblImgCarte)
                            .addGap(55, 55, 55)
                            .addComponent(this.btnChoisirImg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(this.lblMultiCoul)
                                    .addGap(52, 52, 52)
                                    .addComponent(this.btnMoinsJoker))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(this.lblNbCarteParCoul)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(this.btnMoinsCoul)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(this.txtNbCarteParCoul, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(this.btnPlusCoul))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(this.txtNbJoker, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(this.btnPlusJoker))))))
                )
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
                    .addComponent(this.btnChoisirImg))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.lblModif)
                    .addComponent(this.btnCouleurs, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.btnPoints, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.btnObjectifs, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
                )
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
				this.ctrl.setImagePlateau(img);
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