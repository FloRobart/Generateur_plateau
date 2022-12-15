package ihm;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controleur.Controleur;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class PGPanelParamPlateau extends JPanel
{
    private Controleur ctrl;
	private JTextField txtX;
    private JTextField txtY;
    private JTextField txtPolice;

    public PGPanelParamPlateau(Controleur ctrl)
    {
        this.ctrl = ctrl;
		
		this.setLayout(new GridLayout(4,3));
		this.setBackground(new Color(68, 71, 90));


		//dimensions
		this.txtX = new JTextField("X:", 2);
		this.txtX.setBackground(new Color(58, 60, 76));
		this.txtX.setForeground(Color.GRAY);
		

		this.txtY = new JTextField("Y:", 2);
		this.txtY.setBackground(new Color(58, 60, 76));
		this.txtY.setForeground(Color.GRAY);

		//image de fond
		JButton btnFile = new JButton("ouvrir fichier");
		btnFile.setBackground(new Color(58, 60, 76));
		btnFile.setForeground(Color.GRAY);
        add(btnFile);
        btnFile.addActionListener(e -> {
            selectFile();
        });

<<<<<<< HEAD
		//couleur de fond
		JButton btnColor = new JButton("choisir couleur");
		btnColor.setBackground(new Color(58, 60, 76));
		btnColor.setForeground(Color.GRAY);
		add(btnColor);
		btnColor.addActionListener(e -> {
			selectColor();
		});

		//police
		this.txtPolice = new JTextField(10);
		this.txtPolice.setBackground(new Color(58, 60, 76));
		this.txtPolice.setForeground(Color.GRAY);

		//alignement des composants
		JLabel lblDim = new JLabel("Dimensions");
		lblDim.setForeground(Color.WHITE);
		this.add(lblDim);
		this.add(this.txtX);
		this.add(this.txtY);

		//Label image
		JLabel lblImg = new JLabel("Image fond");
		lblImg.setForeground(Color.WHITE);
		this.add(lblImg);
		this.add(btnFile);
		this.add(new JLabel(" "));

		//Label Color
		JLabel lblColor = new JLabel("Couleur de fond");
		lblColor.setForeground(Color.WHITE);
		this.add(lblColor);
		this.add(btnColor);
		this.add(new JLabel(" "));

		//Label Police
		JLabel lblPolice = new JLabel("Police");
		lblPolice.setForeground(Color.WHITE);
		this.add(lblPolice);
		this.add(this.txtPolice);
		this.add(new JLabel(" "));        
    }
	
    private void selectColor() 
	{
		Color color = JColorChooser.showDialog(this, "Choisissez une couleur", Color.WHITE);
=======
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDimension)
                            .addComponent(lblbImageFond))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(txtY, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCouleurCourant, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(txtPathPolice, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPathImg))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnParcourirImg, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnChoisirCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnChoisirFont, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(lblPolice)
                    .addComponent(lblCouleurFond))
                .addContainerGap(49, Short.MAX_VALUE))
            .addComponent(lblParamPlateau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblParamPlateau, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDimension)
                    .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtY, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblbImageFond)
                    .addComponent(txtPathImg, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnParcourirImg, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCouleurFond)
                    .addComponent(btnChoisirCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCouleurCourant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPolice)
                    .addComponent(btnChoisirFont, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPathPolice, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        lblCouleurCourant.getAccessibleContext().setAccessibleName("lblCouleurCourant");
    }// </editor-fold>                        

    /*
     * 
     * Les méthodes appelés par les listeners
     * Component nom : ?
     * Fonction appelée sera  : ?ActionPerformed
     */
    private void txtXActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void txtYActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void txtPathImgActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void txtPathPoliceActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void btnParcourirImgActionPerformed(java.awt.event.ActionEvent evt) {                                                
        JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png", "jpeg");
		fileChooser.setFileFilter(filter);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION)
		{
			return;
		}
    }                                               

    private void btnChoisirCouleurActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        Color color = JColorChooser.showDialog(this, "Choisissez une couleur", Color.WHITE);
>>>>>>> 656507758fe013ee721c6aa7e11e0f0aba69d636
		if (color != null) 
		 	this.ctrl.setCouleur(color);

	}
    private void selectFile() 
	{
		String filePath = "";
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png", "jpeg");
		fileChooser.setFileFilter(filter);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION)
		{
			File file = fileChooser.getSelectedFile();
			filePath  = file.getAbsolutePath();
			BufferedImage img;
			try 
			{
				img = ImageIO.read(new File(filePath));
				this.ctrl.setImageFond(img);
			} catch (IOException e) {e.printStackTrace();}
		}
	}
}