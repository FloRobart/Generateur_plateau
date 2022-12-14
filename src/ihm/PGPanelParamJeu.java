package ihm;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

public class PGPanelParamJeu extends JPanel implements ActionListener
{   
    private JTextField    txtNbJoueursMin;
	private JTextField    txtNbJoueursMax;
    private JTextField    txtNbCarteCoul;
	private JTextField    txtNbCarteJoker;

    
	private JButton       btnPlusCoul;
	private JButton       btnMoinsCoul;
	private JButton       btnPlusJoker;
	private JButton       btnMoinsJoker;

    private JButton       btnModifPoints;
	private JButton	      btnModifCoul;
	private JButton       btnModifObjectif;

    private int           nbCoul=0;
	private int           nbJoker=0;

    public PGPanelParamJeu()
    {
        this.setLayout(new GridLayout(6,4));
		this.setBackground(new Color(68, 71, 90));

		//nombre de joueurs min
		this.txtNbJoueursMin  = new JTextField("Min", 4);
		this.txtNbJoueursMin.setBackground(new Color(58, 60, 76));
		this.txtNbJoueursMin.setForeground(Color.GRAY);
		//nombre de joueurs max
		this.txtNbJoueursMax  = new JTextField("Max", 4);
		this.txtNbJoueursMax.setBackground(new Color(58, 60, 76));
		this.txtNbJoueursMax.setForeground(Color.GRAY);
		//nombre de carte couleur
		this.txtNbCarteCoul   = new JTextField(""+nbCoul, 4);
		this.txtNbCarteCoul.setBackground(new Color(58, 60, 76));
		this.txtNbCarteCoul.setForeground(Color.GRAY);
		
		this.btnPlusCoul   = new JButton("+");
		this.btnPlusCoul.setBackground(new Color(217, 217, 217));

		this.btnMoinsCoul  = new JButton("-");
		this.btnMoinsCoul.setBackground(new Color(217, 217, 217));

		//nombre de carte joker
		this.txtNbCarteJoker  = new JTextField(""+nbJoker, 4);
		this.txtNbCarteJoker.setBackground(new Color(58, 60, 76));
		this.txtNbCarteJoker.setForeground(Color.GRAY);

		this.btnPlusJoker  = new JButton("+");
		this.btnPlusJoker.setBackground(new Color(217, 217, 217));	

		this.btnMoinsJoker = new JButton("-");
		this.btnMoinsJoker.setBackground(new Color(217, 217, 217));
		
		//image cartes
		JButton btnImg = new JButton("Rechercher l'image");
		btnImg.setBackground(new Color(58, 60, 76));
		btnImg.setForeground(Color.GRAY);
        add(btnImg);
        btnImg.addActionListener(e -> {
            selectImg();
        });

		//couleur 
		this.btnModifCoul     = new JButton("Couleurs");
		this.btnModifCoul.setBackground(new Color(58, 60, 76));
		this.btnModifCoul.setForeground(Color.WHITE);

		//points
		this.btnModifPoints   = new JButton("Points");
		this.btnModifPoints.setBackground(new Color(58, 60, 76));
		this.btnModifPoints.setForeground(Color.WHITE);

		//objectifs
		this.btnModifObjectif = new JButton("Objectifs");
		this.btnModifObjectif.setBackground(new Color(58, 60, 76));
		this.btnModifObjectif.setForeground(Color.WHITE);

		//alignement des composants
		JLabel lblNbJoueurs = new JLabel("Nombre de joueurs");
		lblNbJoueurs.setForeground(Color.WHITE);
		this.add(lblNbJoueurs);
		this.add(this.txtNbJoueursMin);
		this.add(this.txtNbJoueursMax);
		this.add(new JLabel(" "));

		JLabel lblCartes = new JLabel("Cartes wagon :");
		lblCartes.setForeground(Color.WHITE);
		this.add(lblCartes);
		this.add(new JLabel(""));
		this.add(new JLabel(""));	
		this.add(new JLabel(""));

		JLabel lblNbCarteCoul = new JLabel("cartes par couleurs");
		lblNbCarteCoul.setForeground(Color.WHITE);
		this.add(lblNbCarteCoul);
		this.add(this.btnMoinsCoul);
		this.add(this.txtNbCarteCoul);
		this.add(this.btnPlusCoul);

		JLabel lblNbCarteJoker = new JLabel("cartes multicouleurs");
		lblNbCarteJoker.setForeground(Color.WHITE);
		this.add(lblNbCarteJoker);
		this.add(this.btnMoinsJoker);
		this.add(this.txtNbCarteJoker);
		this.add(this.btnPlusJoker);

		JLabel lblImg2 = new JLabel("Image cartes");
		lblImg2.setForeground(Color.WHITE);
		this.add(lblImg2);
		this.add(btnImg);
		this.add(new JLabel(""));
		this.add(new JLabel(""));

		JLabel lblModif = new JLabel("Modifier");
		lblModif.setForeground(Color.WHITE);
		this.add(lblModif);
		this.add(this.btnModifCoul);
		this.add(this.btnModifPoints);
		this.add(this.btnModifObjectif);


        this.btnPlusCoul.addActionListener(this);
		this.btnMoinsCoul.addActionListener(this);
		this.btnPlusJoker.addActionListener(this);
		this.btnMoinsJoker.addActionListener(this);
    }
    /*
	 * Méthode qui permet de sélectionner une image
	 */
	private void selectImg() 
	{
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png", "jpeg");
		fileChooser.setFileFilter(filter);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION)
		{
			//File selectedFile = fileChooser.getSelectedFile();
			//this.img = selectedFile.getAbsolutePath();
		} 
			
		
	}
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource().equals(this.btnPlusCoul))
		{
			nbCoul = Integer.parseInt(this.txtNbCarteCoul.getText());
			nbCoul++;
			this.txtNbCarteCoul.setText(Integer.toString(nbCoul));
		}

		if(e.getSource().equals(this.btnMoinsCoul))
		{
			if(nbCoul > 0)
			{
				nbCoul = Integer.parseInt(this.txtNbCarteCoul.getText());
				nbCoul--;
				this.txtNbCarteCoul.setText(Integer.toString(nbCoul));
			}
		}
		
		if(e.getSource() == this.btnPlusJoker)
		{
			nbJoker = Integer.parseInt(this.txtNbCarteJoker.getText());
			nbJoker++;
			this.txtNbCarteJoker.setText(Integer.toString(nbJoker));
		}


		if(e.getSource() == this.btnMoinsJoker)
		{
			if(nbJoker > 0)
			{
				nbJoker = Integer.parseInt(this.txtNbCarteJoker.getText());
				nbJoker--;
				this.txtNbCarteJoker.setText(Integer.toString(nbJoker));
			}
		}
    }
}
