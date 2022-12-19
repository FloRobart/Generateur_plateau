package ihm;

import java.awt.Color;
import java.awt.Font;
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
    private JLabel     lblCouleurCourant;
    private JLabel     lblCouleurFond;
    private JLabel     lblDimension;
    private JLabel     lblParamPlateau;
    private JLabel     lblPolice;
    private JLabel     lblbImageFond;
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
        this.txtX              = new JTextField();
        this.txtY              = new JTextField();
        this.txtPathImg        = new JTextField();
        this.btnParcourirImg   = new JButton   ();
        this.btnChoisirCouleur = new JButton   ();
        this.btnChoisirFont    = new JButton   ();
        this.lblCouleurCourant = new JLabel    ();
        this.txtPathPolice     = new JTextField();

        setBackground(new Color(68, 71, 90));

        this.lblParamPlateau.setBackground(new Color( 49,  51,  63));
        this.lblParamPlateau.setForeground(new Color(255, 255, 255));
        this.lblParamPlateau.setText      ("Parametre du Plateau");
        this.lblParamPlateau.setOpaque    (true);

        this.lblDimension.setBackground(new Color(73, 81, 99));
        this.lblDimension.setFont      (new Font("Segoe UI", 1, 12));
        this.lblDimension.setForeground(new Color(255, 255, 255));
        this.lblDimension.setText      ("Dimension");

        this.lblbImageFond.setBackground(new Color(73, 81, 99));
        this.lblbImageFond.setFont      (new Font("Segoe UI", 1, 12));
        this.lblbImageFond.setForeground(new Color(255, 255, 255));
        this.lblbImageFond.setText      ("Image Fond");

        this.lblCouleurFond.setBackground(new Color(47, 49, 63));
        this.lblCouleurFond.setFont      (new Font("Segoe UI", 1, 12));
        this.lblCouleurFond.setForeground(new Color(255, 255, 255));
        this.lblCouleurFond.setText      ("Couleur de fond");

        this.lblPolice.setBackground(new Color(73, 81, 99));
        this.lblPolice.setFont      (new Font("Segoe UI", 1, 12));
        this.lblPolice.setForeground(new Color(255, 255, 255));
        this.lblPolice.setText      ("Police d'écriture");

        this.txtX.setBackground       (new Color(47, 49, 63));
        this.txtX.setForeground       (new Color(255, 255, 255));
        this.txtX.setText             (" X:");
        this.txtX.setBorder           (null);
        this.txtX.setDisabledTextColor(new Color(255, 255, 255));
        this.txtX.setOpaque           (true);
        this.txtX.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                txtXActionPerformed(e);
            }
        });

        this.txtY.setBackground(new Color(47, 49, 63));
        this.txtY.setForeground(new Color(255, 255, 255));
        this.txtY.setText(" Y:");
        this.txtY.setBorder(null);
        this.txtY.setDisabledTextColor(new Color(255, 255, 255));
        this.txtY.setOpaque(true);
        this.txtY.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                txtYActionPerformed(e);
            }
        });

        this.txtPathImg.setBackground(new Color(47, 49, 63));
        this.txtPathImg.setForeground(new Color(255, 255, 255));
        this.txtPathImg.setText(" Parcourir");
        this.txtPathImg.setBorder(null);
        this.txtPathImg.setDisabledTextColor(new Color(255, 255, 255));
        this.txtPathImg.setOpaque(true);
        this.txtPathImg.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                txtPathImgActionPerformed(e);
            }
        });

        this.btnParcourirImg.setBackground(new Color(0, 0, 0));
        this.btnParcourirImg.setForeground(new Color(255, 255, 255));
        this.btnParcourirImg.setText("...");
        this.btnParcourirImg.setBorder(null);
        this.btnParcourirImg.setOpaque(true);
        this.btnParcourirImg.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                btnParcourirImgActionPerformed(e);
            }
        });

        this.btnChoisirCouleur.setBackground(new Color(0, 0, 0));
        this.btnChoisirCouleur.setForeground(new Color(255, 255, 255));
        this.btnChoisirCouleur.setText("...");
        this.btnChoisirCouleur.setBorder(null);
        this.btnChoisirCouleur.setOpaque(true);
        this.btnChoisirCouleur.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                btnChoisirCouleurActionPerformed(e);
            }
        });

        this.btnChoisirFont.setBackground(new Color(0, 0, 0));
        this.btnChoisirFont.setForeground(new Color(255, 255, 255));
        this.btnChoisirFont.setText("...");
        this.btnChoisirFont.setBorder(null);
        this.btnChoisirFont.setOpaque(true);
        this.btnChoisirFont.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                btnChoisirFontActionPerformed(e);
            }
        });

        this.lblCouleurCourant.setBackground(new Color(47, 49, 63));
        this.lblCouleurCourant.setForeground(new Color(255, 255, 255));
        this.lblCouleurCourant.setText("Choisir votre couleur");
        this.lblCouleurCourant.setOpaque(true);

        this.txtPathPolice.setBackground(new Color(47, 49, 63));
        this.txtPathPolice.setForeground(new Color(255, 255, 255));
        this.txtPathPolice.setText(" Parcourir");
        this.txtPathPolice.setBorder(null);
        this.txtPathPolice.setDisabledTextColor(new Color(255, 255, 255));
        this.txtPathPolice.setOpaque(true);
        this.txtPathPolice.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                txtPathPoliceActionPerformed(e);
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
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(this.lblCouleurCourant, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(this.txtPathPolice, GroupLayout.Alignment.TRAILING)
                                    .addComponent(this.txtPathImg))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(this.btnParcourirImg, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.btnChoisirCouleur, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.btnChoisirFont, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))))
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
                    .addComponent(this.txtPathImg, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.btnParcourirImg, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.lblCouleurFond)
                    .addComponent(this.btnChoisirCouleur, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.lblCouleurCourant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.lblPolice)
                    .addComponent(this.btnChoisirFont, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.txtPathPolice, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        this.lblCouleurCourant.getAccessibleContext().setAccessibleName("lblCouleurCourant");
    }


    private void txtXActionPerformed         (java.awt.event.ActionEvent e) {}
    private void txtYActionPerformed         (java.awt.event.ActionEvent e) {}
    private void txtPathImgActionPerformed   (java.awt.event.ActionEvent e) {}
    private void txtPathPoliceActionPerformed(java.awt.event.ActionEvent e) {}


    private void btnParcourirImgActionPerformed(java.awt.event.ActionEvent e) 
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

    private void btnChoisirCouleurActionPerformed(java.awt.event.ActionEvent e)
    {
        Color color = JColorChooser.showDialog(this, "Choisissez une couleur", Color.WHITE);
		if (color != null) 
		 	this.ctrl.setCouleur(color);
    }                                                 

    private void btnChoisirFontActionPerformed(java.awt.event.ActionEvent e)
    {                                               
        JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("JPG & JPEG & GIF & PNG Images", "jpg", "gif", "png", "jpeg"));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) { return; }
    }
}