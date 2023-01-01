package ihm.panels.panelGenerateur;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controleur.Controleur;
import ihm.customComponent.TextFieldWithHint;


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
    private TextFieldWithHint txtX;
    private TextFieldWithHint txtY;

    private Controleur ctrl;


    public PGPanelParamPlateau(Controleur ctrl)
    {
        this.ctrl = ctrl;

        this.lblParamPlateau   = new JLabel           ();
        this.lblDimension      = new JLabel           ();
        this.lblbImageFond     = new JLabel           ();
        this.lblCouleurFond    = new JLabel           ();
        this.lblPolice         = new JLabel           ();
        this.txtX              = new TextFieldWithHint("X", ctrl);
        this.txtY              = new TextFieldWithHint("Y", ctrl);
        this.btnParcourirImg   = new JButton          ();
        this.btnChoisirCouleur = new JButton          ();
        this.btnChoisirFont    = new JButton          ();


        /* Titre (Parametre du Plateau) */
        this.lblParamPlateau.setText      (" Parametre du Plateau");

        /* Dimension */
        this.lblDimension.setText      ("Dimension");
        this.lblDimension.setFont      (new Font("Segoe UI", 1, 12));

        /* Image de fond */
        this.lblbImageFond.setText      ("Image de fond");
        this.lblbImageFond.setFont      (new Font("Segoe UI", 1, 12));

        /* Couleur de fond */
        this.lblCouleurFond.setText      ("Couleur de fond");
        this.lblCouleurFond.setFont      (new Font("Segoe UI", 1, 12));

        /* Police d'écriture */
        this.lblPolice.setText      ("Police d'écriture");
        this.lblPolice.setFont      (new Font("Segoe UI", 1, 12));

        /* Zone de saisie X */
        this.txtX.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtXActionPerformed(e);
            }
        });

        /* Zone de saisie Y */
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
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("JPG & JPEG & GIF & PNG Images", "jpg", "gif", "png", "jpeg"));
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(false);
		int result = fc.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION)
		{
			BufferedImage img;
			try
			{
				img = ImageIO.read(new File(fc.getSelectedFile().getAbsolutePath()));
                this.ctrl.setImagePlateau(img);
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
		 	this.ctrl.setCouleurPlateau(color);
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

        /* Titre (Parametre du Plateau) */
        this.lblParamPlateau.setOpaque    (true);
        this.lblParamPlateau.setForeground(titleForeColor);
        this.lblParamPlateau.setBackground(titleBackColor);

        /* Dimention */
        this.lblDimension.setForeground(labelForeColor);
        this.lblDimension.setBackground(labelBackColor);

        /* Image de fond */
        this.lblbImageFond.setForeground(labelForeColor);
        this.lblbImageFond.setBackground(labelBackColor);

        /* Couleur de fond */
        this.lblCouleurFond.setForeground(labelForeColor);
        this.lblCouleurFond.setBackground(labelBackColor);

        /* Police d'écriture */
        this.lblPolice.setForeground(labelForeColor);
        this.lblPolice.setBackground(labelBackColor);

        /* Zone de saisie X */
        this.txtX.setOpaque    (true);
        this.txtX.setBorder    (null);
        this.txtY.setForeground(placeholderColor);
        this.txtX.setBackground(saisiBackColor  );
        this.txtX.setForegroundColor (saisiForeColor  );
        this.txtX.setPlaceholderColor(placeholderColor);
        this.txtX.setDisabledTextColor(new Color(255, 0, 0));

        /* Zone de saisie Y */
        this.txtY.setOpaque    (true);
        this.txtY.setBorder    (null);
        this.txtY.setForeground(placeholderColor);
        this.txtY.setBackground(saisiBackColor  );
        this.txtY.setForegroundColor (saisiForeColor  );
        this.txtY.setPlaceholderColor(placeholderColor);
        this.txtY.setDisabledTextColor(new Color(255, 0, 0));

        /* Bouton parcourir image */
        this.btnParcourirImg.setOpaque    (true);
        this.btnParcourirImg.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnParcourirImg.setForeground(btnForeColor);
        this.btnParcourirImg.setBackground(btnBackColor);

        /* Bouton de choix de la couleur */
        this.btnChoisirCouleur.setOpaque    (true);
        this.btnChoisirCouleur.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnChoisirCouleur.setBackground(btnBackColor);
        this.btnChoisirCouleur.setForeground(btnForeColor); 

        /* Bouton de choix de la police */
        this.btnChoisirFont.setOpaque    (true);
        this.btnChoisirFont.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnChoisirFont.setForeground(btnForeColor);
        this.btnChoisirFont.setBackground(btnBackColor);
	}
}