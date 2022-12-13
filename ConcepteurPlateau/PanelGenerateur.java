import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

import java.awt.Color;

public class PanelGenerateur extends JPanel
{

	// Attributs
	private JTextField    DimensionX;
	private JTextField    DimensionY;
	private JFileChooser  imgFond;
	private JColorChooser couleurFond;

	private JTextField    nbJoueursMin;
	private JTextField    nbJoueursMax;

	private JButton       btnPlusCoul;
	private JButton       btnMoinsCoul;
	private JButton       btnPlusJoker;
	private JButton       btnMoinsJoker;
	private JTextField    nbCarteCoul;
	private JTextField    nbCarteJoker;

	private JButton       btnModifPoints;
	private JButton	      btnModifCoul;


	// Constructeur
	public PanelGenerateur()
	{
		this.setLayout(new GridLayout(1,2));
		this.setBackground(new Color(40, 42, 54));

		JPanel panelForm         = new JPanel();
		JPanel panelMappe        = new JPanel();
		JPanel panelParamPlateau = new JPanel();
		JPanel panelParamJeu     = new JPanel();

		//PanelForm
		panelForm.setLayout(new GridLayout(4,1));

		//Paramètre du plateau
		panelParamPlateau.add(new JLabel("Paramètre du plateau"));
		
		this.DimensionX = new JTextField("x:", 4);
		this.DimensionY = new JTextField("y:", 4);

		this.imgFond = new JFileChooser("./");
		this.couleurFond = new JColorChooser();

		panelParamPlateau.add(new JLabel("Dimension"));
		panelParamPlateau.add(this.DimensionX);
		panelParamPlateau.add(this.DimensionY);
		panelParamPlateau.add(new JLabel("Image fond"));
		panelParamPlateau.add(this.imgFond);
		panelParamPlateau.add(new JLabel("Couleur fond"));
		panelParamPlateau.add(this.couleurFond);



		//Paramètre du jeu
		panelParamJeu.add(new JLabel("Paramètre du jeu"));

		this.nbJoueursMin = new JTextField("Min:", 4);
		this.nbJoueursMax = new JTextField("Max:", 4);

		this.btnMoinsCoul = new JButton("-");
		this.btnPlusCoul  = new JButton("+");

		this.btnMoinsJoker = new JButton("-");
		this.btnPlusJoker  = new JButton("+");

		this.nbCarteCoul  = new JTextField("0", 4);
		this.nbCarteJoker = new JTextField("0", 4);

		this.btnModifPoints = new JButton("Modifier points");
		this.btnModifCoul   = new JButton("Modifier couleurs");

		panelParamJeu.add(new JLabel("Nombre de joueurs"));
		panelParamJeu.add(this.nbJoueursMin);
		panelParamJeu.add(this.nbJoueursMax);
		panelParamJeu.add(new JLabel("Cartes wagon : "));
		panelParamJeu.add(new JLabel("Cartes par couleurs "));
		panelParamJeu.add(this.btnMoinsCoul);
		panelParamJeu.add(this.nbCarteCoul);
		panelParamJeu.add(this.btnPlusCoul);
		panelParamJeu.add(new JLabel("Cartes multicouleurs "));
		panelParamJeu.add(this.btnMoinsJoker);
		panelParamJeu.add(this.nbCarteJoker);
		panelParamJeu.add(this.btnPlusJoker);
		panelParamJeu.add(this.btnModifPoints);
		panelParamJeu.add(this.btnModifCoul);


		panelForm.add(panelParamPlateau);
		panelForm.add(panelParamJeu);


		
	}

	// Fabrique


	// Accesseurs

	// Modificateurs


	// Methodes

}
