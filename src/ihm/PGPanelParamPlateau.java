package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import controleur.Controleur;


public class PGPanelParamPlateau extends JPanel
{
    private JButton    btnChoisirCouleur;
    private JButton    btnChoisirFont;
    private JButton    btnParcourirImg;
    private JLabel     lblCouleurFond;
    private JLabel     lblDimension;
    private JLabel     lblParamPlateau;
    private JLabel     lblPolice;
    private JLabel     lblbImageFond;
    private JTextField txtCouleurCourant;
    private JTextField txtPathImg;
    private JTextField txtPathPolice;
    private JTextField txtX;
    private JTextField txtY;

    private Controleur ctrl;


    public PGPanelParamPlateau(Controleur ctrl)
    {
        this.ctrl = ctrl;

        this.lblParamPlateau   = new JLabel    ();
        this.lblDimension      = new JLabel    ();
        this.lblbImageFond     = new JLabel    ();
        this.lblCouleurFond    = new JLabel    ();
        this.lblPolice         = new JLabel    ();
        this.txtCouleurCourant = new JTextField();
        this.txtX              = new JTextField();
        this.txtY              = new JTextField();
        this.txtPathImg        = new JTextField();
        this.txtPathPolice     = new JTextField();
        this.btnParcourirImg   = new JButton   ();
        this.btnChoisirCouleur = new JButton   ();
        this.btnChoisirFont    = new JButton   ();


        /* Titre (Parametre du Plateau) */
        this.lblParamPlateau.setText      (" Parametre du Plateau");

        /* Dimension */
        this.lblDimension.setFont      (new Font("Segoe UI", 1, 12));
        this.lblDimension.setText      ("Dimension");

        /* Image de fond */
        this.lblbImageFond.setFont      (new Font("Segoe UI", 1, 12));
        this.lblbImageFond.setText      ("Image Fond");

        /* Couleur de fond */
        this.lblCouleurFond.setFont      (new Font("Segoe UI", 1, 12));
        this.lblCouleurFond.setText      ("Couleur de fond");

        /* Police d'écriture */
        this.lblPolice.setFont      (new Font("Segoe UI", 1, 12));
        this.lblPolice.setText      ("Police d'écriture");

        /* Zone de saisie X */
        this.txtX.setText             ("X:");
        this.txtX.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtXActionPerformed(e);
            }
        });

        /* Zone de saisie Y */
        this.txtY.setText("Y:");
        this.txtY.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtYActionPerformed(e);
            }
        });

        /* Bouton parcourir image */
        this.btnParcourirImg.setText("Choisir une image");
        this.btnParcourirImg.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnParcourirImgActionPerformed(e);
            }
        });

        /* Bouton de choix de la couleur */
        this.btnChoisirCouleur.setText("Choisir une couleur");
        this.btnChoisirCouleur.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnChoisirCouleurActionPerformed(e);
            }
        });

        /* Bouton de choix de la police */
        this.btnChoisirFont.setText("Choisir une police");
        this.btnChoisirFont.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnChoisirFontActionPerformed(e);
            }
        });


        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(this.lblDimension)
                            .addComponent(this.lblbImageFond))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(this.txtX, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(this.txtY, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(this.btnParcourirImg, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.btnChoisirCouleur, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.btnChoisirFont, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(this.lblPolice)
                    .addComponent(this.lblCouleurFond))
                .addContainerGap(49, Short.MAX_VALUE))
            .addComponent(this.lblParamPlateau, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );


        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(this.lblParamPlateau, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.lblDimension)
                    .addComponent(this.txtX, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.txtY, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.lblbImageFond)
                    .addComponent(this.btnParcourirImg, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.lblCouleurFond)
                    .addComponent(this.btnChoisirCouleur, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.lblPolice)
                    .addComponent(this.btnChoisirFont, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );


        this.appliquerTheme();
    }


    private void txtXActionPerformed         (ActionEvent e) {}
    private void txtYActionPerformed         (ActionEvent e) {}


    private void btnParcourirImgActionPerformed(ActionEvent e) 
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

    private void btnChoisirCouleurActionPerformed(ActionEvent e)
    {
        Color color = JColorChooser.showDialog(this, "Choisissez une couleur", Color.WHITE);
		if (color != null) 
		 	this.ctrl.setCouleur(color);
    }                                                 

    private void btnChoisirFontActionPerformed(ActionEvent e)
    {                                               
        JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("JPG & JPEG & GIF & PNG Images", "jpg", "gif", "png", "jpeg"));
        fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) { return; }
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

        /* Titre (Parametre du Plateau) */
        this.lblParamPlateau.setBackground(titleBackColor);
        this.lblParamPlateau.setForeground(titleForeColor);
        this.lblParamPlateau.setOpaque    (true);

        /* Dimention */
        this.lblDimension.setBackground(labelBackColor);
        this.lblDimension.setForeground(labelForeColor);

        /* Image de fond */
        this.lblbImageFond.setBackground(labelBackColor);
        this.lblbImageFond.setForeground(labelForeColor);

        /* Couleur de fond */
        this.lblCouleurFond.setBackground(labelBackColor);
        this.lblCouleurFond.setForeground(labelForeColor);

        /* Police d'écriture */
        this.lblPolice.setBackground(labelBackColor);
        this.lblPolice.setForeground(labelForeColor);

        /* Zone de saisie X */
        this.txtX.setBackground(saisiBackColor);
        this.txtX.setForeground(saisiForeColor);
        this.txtX.setBorder    (null);
        this.txtX.setOpaque    (true);
        this.txtX.setDisabledTextColor(new Color(255, 0, 0));

        /* Zone de saisie Y */
        this.txtY.setBackground(saisiBackColor);
        this.txtY.setForeground(saisiForeColor);
        this.txtY.setBorder    (null);
        this.txtY.setOpaque    (true);
        this.txtY.setDisabledTextColor(new Color(255, 0, 0));

        /* Bouton parcourir image */
        this.btnParcourirImg.setBackground(btnBackColor);
        this.btnParcourirImg.setForeground(btnForeColor);
        this.btnParcourirImg.setBorder    (null);
        this.btnParcourirImg.setOpaque    (true);

        /* Bouton de choix de la couleur */
        this.btnChoisirCouleur.setBackground(btnBackColor);
        this.btnChoisirCouleur.setForeground(btnForeColor);
        this.btnChoisirCouleur.setBorder    (null);
        this.btnChoisirCouleur.setOpaque    (true);

        /* Bouton de choix de la police */
        this.btnChoisirFont.setBackground(btnBackColor);
        this.btnChoisirFont.setForeground(btnForeColor);
        this.btnChoisirFont.setBorder    (null);
        this.btnChoisirFont.setOpaque    (true);
	}
}