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