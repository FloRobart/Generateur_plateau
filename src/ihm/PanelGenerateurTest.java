package ihm;
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;

import controleur.Controleur;
public class PanelGenerateurTest extends JPanel 
{	
	/**
	 * Constructeur de la classe PanelGenerateurTest
	 * @param ctrl
	 */
    public PanelGenerateurTest(Controleur ctrl)
    {
		PGPanelParamPlateau     panelParamPlateau       = new PGPanelParamPlateau();
        PGPanelParamJeu         panelParamJeu           = new PGPanelParamJeu(ctrl);
        PGPanelAjouterElements  panelAjouterElements    = new PGPanelAjouterElements();
        PGPanelModifier         panelModif              = new PGPanelModifier();
        this.setLayout(new GridLayout(8,1));
		this.setBackground(new Color(40, 42, 54));
        
        JLabel lbl = new JLabel("Paramètre du plateau");
		lbl.setForeground(Color.WHITE);
		this.add(lbl);
		this.add(panelParamPlateau);

		JLabel lbl2 = new JLabel("Paramètre du jeu");
		lbl2.setForeground(Color.WHITE);
		this.add(lbl2);
		this.add(panelParamJeu);

		JLabel lbl3 = new JLabel("Ajouter éléments");
		lbl3.setForeground(Color.WHITE);
		this.add(lbl3);
		this.add(panelAjouterElements);

		JLabel lbl4 = new JLabel("Modifier l'élément choisit");
		lbl4.setForeground(Color.WHITE);
		this.add(lbl4);
		this.add(panelModif);       
    }
}
