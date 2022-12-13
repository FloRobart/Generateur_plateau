package ihm;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.GridLayout;
import java.awt.Color;

import java.awt.event.*;
import java.io.File;
import java.awt.Graphics;
import java.awt.Image;

public class PanelGenerateur extends JPanel implements ActionListener
{

	// Attributs
	private JPanel        panelForm;
	private JPanel        panelMappe;
	private JPanel        panelParamPlateau;
	private JPanel        panelParamJeu;
	private JPanel        panelElements;
	private JPanel        panelModif;

	private JTextField    DimensionX;
	private JTextField    DimensionY;
	private JTextField    txtPolice;

	private JTextField    nbJoueursMin;
	private JTextField    nbJoueursMax;


	private int           nbCoul=0;
	private int           nbJoker=0;

	private JButton       btnPlusCoul;
	private JButton       btnMoinsCoul;
	private JButton       btnPlusJoker;
	private JButton       btnMoinsJoker;
	private JTextField    nbCarteCoul;
	private JTextField    nbCarteJoker;

	private JButton       btnModifPoints;
	private JButton	      btnModifCoul;
	private JButton       btnModifObjectif;

	private JButton       btnNoeud;
	private JButton       btnArete;
	private JButton       btnCarteObj;

	// Constructeur
	public PanelGenerateur()
	{
		this.setLayout(new GridLayout(1,1));
		//this.setBackground(new Color(40, 42, 54));
        
		this.panelForm         = new JPanel();
		this.panelMappe        = new JPanel();
		this.panelParamPlateau = new JPanel();
		this.panelParamJeu     = new JPanel();
		this.panelElements     = new JPanel();
		this.panelModif        = new JPanel();

		//PanelForm
		panelForm.setLayout(new GridLayout(8,1));
		panelForm.setBackground(new Color(40, 42, 54));


		/*---------------------------------------------------------------------- */
		/*PARAMÈTRE PLATEAU                                                      */
		/*---------------------------------------------------------------------- */
		panelParamPlateau.setLayout(new GridLayout(4,3));
		panelParamPlateau.setBackground(new Color(68, 71, 90));


		//dimensions
		this.DimensionX = new JTextField("X:", 2);
		this.DimensionX.setBackground(new Color(58, 60, 76));
		this.DimensionX.setForeground(Color.GRAY);
		

		this.DimensionY = new JTextField("Y:", 2);
		this.DimensionY.setBackground(new Color(58, 60, 76));
		this.DimensionY.setForeground(Color.GRAY);

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
		panelParamPlateau.add(lblDim);
		panelParamPlateau.add(this.DimensionX);
		panelParamPlateau.add(this.DimensionY);

		JLabel lblImg = new JLabel("Image fond");
		lblImg.setForeground(Color.WHITE);
		panelParamPlateau.add(lblImg);
		panelParamPlateau.add(btnFile);
		panelParamPlateau.add(new JLabel(" "));

		JLabel lblColor = new JLabel("Couleur de fond");
		lblColor.setForeground(Color.WHITE);
		panelParamPlateau.add(lblColor);
		panelParamPlateau.add(btnColor);
		panelParamPlateau.add(new JLabel(" "));

		JLabel lblPolice = new JLabel("Police");
		lblPolice.setForeground(Color.WHITE);
		panelParamPlateau.add(lblPolice);
		panelParamPlateau.add(this.txtPolice);
		panelParamPlateau.add(new JLabel(" "));
	
		/*---------------------------------------------------------------------- */
		/*PARAMÈTRE JEU                                                          */
		/*---------------------------------------------------------------------- */
		panelParamJeu.setLayout(new GridLayout(6,4));
		panelParamJeu.setBackground(new Color(68, 71, 90));

		//nombre de joueurs min
		this.nbJoueursMin  = new JTextField("Min", 4);
		this.nbJoueursMin.setBackground(new Color(58, 60, 76));
		this.nbJoueursMin.setForeground(Color.GRAY);
		//nombre de joueurs max
		this.nbJoueursMax  = new JTextField("Max", 4);
		this.nbJoueursMax.setBackground(new Color(58, 60, 76));
		this.nbJoueursMax.setForeground(Color.GRAY);
		//nombre de carte couleur
		this.nbCarteCoul   = new JTextField(""+nbCoul, 4);
		this.nbCarteCoul.setBackground(new Color(58, 60, 76));
		this.nbCarteCoul.setForeground(Color.GRAY);
		
		this.btnPlusCoul   = new JButton("+");
		this.btnPlusCoul.setBackground(new Color(217, 217, 217));

		this.btnMoinsCoul  = new JButton("-");
		this.btnMoinsCoul.setBackground(new Color(217, 217, 217));

		//nombre de carte joker
		this.nbCarteJoker  = new JTextField(""+nbJoker, 4);
		this.nbCarteJoker.setBackground(new Color(58, 60, 76));
		this.nbCarteJoker.setForeground(Color.GRAY);

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
		panelParamJeu.add(lblNbJoueurs);
		panelParamJeu.add(this.nbJoueursMin);
		panelParamJeu.add(this.nbJoueursMax);
		panelParamJeu.add(new JLabel(" "));

		JLabel lblCartes = new JLabel("Cartes wagon :");
		lblCartes.setForeground(Color.WHITE);
		panelParamJeu.add(lblCartes);
		panelParamJeu.add(new JLabel(""));
		panelParamJeu.add(new JLabel(""));	
		panelParamJeu.add(new JLabel(""));

		JLabel lblNbCarteCoul = new JLabel("cartes par couleurs");
		lblNbCarteCoul.setForeground(Color.WHITE);
		panelParamJeu.add(lblNbCarteCoul);
		panelParamJeu.add(this.btnMoinsCoul);
		panelParamJeu.add(this.nbCarteCoul);
		panelParamJeu.add(this.btnPlusCoul);

		JLabel lblNbCarteJoker = new JLabel("cartes multicouleurs");
		lblNbCarteJoker.setForeground(Color.WHITE);
		panelParamJeu.add(lblNbCarteJoker);
		panelParamJeu.add(this.btnMoinsJoker);
		panelParamJeu.add(this.nbCarteJoker);
		panelParamJeu.add(this.btnPlusJoker);

		JLabel lblImg2 = new JLabel("Image cartes");
		lblImg2.setForeground(Color.WHITE);
		panelParamJeu.add(lblImg2);
		panelParamJeu.add(btnImg);
		panelParamJeu.add(new JLabel(""));
		panelParamJeu.add(new JLabel(""));

		JLabel lblModif = new JLabel("Modifier");
		lblModif.setForeground(Color.WHITE);
		panelParamJeu.add(lblModif);
		panelParamJeu.add(this.btnModifCoul);
		panelParamJeu.add(this.btnModifPoints);
		panelParamJeu.add(this.btnModifObjectif);
		
		/*---------------------------------------------------------------------- */
		/*PANEL ELEMENTS                                                         */
		/*---------------------------------------------------------------------- */
		this.panelElements.setBackground(new Color(58, 60, 76));
		this.panelElements.setLayout(new GridLayout(1,3));

		this.btnNoeud = new JButton("Noeud");
		this.btnNoeud.setBackground(new Color(58,60,76));
		this.btnNoeud.setForeground(Color.WHITE);

		this.btnArete = new JButton("Arete");
		this.btnArete.setBackground(new Color(58,60,76));
		this.btnArete.setForeground(Color.WHITE);

		this.btnCarteObj = new JButton("Carte Objectif");
		this.btnCarteObj.setBackground(new Color(58,60,76));
		this.btnCarteObj.setForeground(Color.WHITE);

		//alignement des composants
		panelElements.add(this.btnNoeud);
		panelElements.add(this.btnArete);
		panelElements.add(this.btnCarteObj);

		/*---------------------------------------------------------------------- */
		/*PANEL MODIFIER ELEMENTS                                                */
		/*---------------------------------------------------------------------- */
		this.panelModif.setBackground(new Color(58, 60, 76));
		this.panelModif.add(new JLabel("Aucun Element selectionné"));

		/*---------------------------------------------------------------------- */
		/*PANEL FORM                                                             */
		/*---------------------------------------------------------------------- */
		JLabel lbl = new JLabel("Paramètre du plateau");
		lbl.setForeground(Color.WHITE);
		panelForm.add(lbl);
		panelForm.add(panelParamPlateau);

		JLabel lbl2 = new JLabel("Paramètre du jeu");
		lbl2.setForeground(Color.WHITE);
		panelForm.add(lbl2);
		panelForm.add(panelParamJeu);

		JLabel lbl3 = new JLabel("Ajouter éléments");
		lbl3.setForeground(Color.WHITE);
		panelForm.add(lbl3);
		panelForm.add(panelElements);

		JLabel lbl4 = new JLabel("Modifier l'élément choisit");
		lbl4.setForeground(Color.WHITE);
		panelForm.add(lbl4);
		panelForm.add(panelModif);

		/*---------------------------------------------------------------------- */
		/*PANEL                                                                  */
		/*---------------------------------------------------------------------- */
        this.add(panelForm);

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
			File selectedFile = fileChooser.getSelectedFile();
			//this.img = selectedFile.getAbsolutePath();
		} 
			
		
	}

	/*
	 * Méthode qui permet de sélectionner une couleur
	 */
	private void selectColor() 
	{
		Color color = JColorChooser.showDialog(this, "Choisissez une couleur", Color.WHITE);
		if (color != null) 
			this.panelMappe.setBackground(color);

	}

	/*
	 * Méthode qui permet de sélectionner un fichier (l'image de fond du plateau)
	 */
	private void selectFile() 
	{
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png", "jpeg");
		fileChooser.setFileFilter(filter);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION)
		{
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(this.btnPlusCoul))
		{
			nbCoul = Integer.parseInt(this.nbCarteCoul.getText());
			nbCoul++;
			this.nbCarteCoul.setText(Integer.toString(nbCoul));
		}

		if(e.getSource().equals(this.btnMoinsCoul))
		{
			if(nbCoul > 0)
			{
				nbCoul = Integer.parseInt(this.nbCarteCoul.getText());
				nbCoul--;
				this.nbCarteCoul.setText(Integer.toString(nbCoul));
			}
		}
		
		if(e.getSource() == this.btnPlusJoker)
		{
			nbJoker = Integer.parseInt(this.nbCarteJoker.getText());
			nbJoker++;
			this.nbCarteJoker.setText(Integer.toString(nbJoker));
		}


		if(e.getSource() == this.btnMoinsJoker)
		{
			if(nbJoker > 0)
			{
				nbJoker = Integer.parseInt(this.nbCarteJoker.getText());
				nbJoker--;
				this.nbCarteJoker.setText(Integer.toString(nbJoker));
			}
		}
	}

}