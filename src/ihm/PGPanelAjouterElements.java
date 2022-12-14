package ihm;

import java.awt.Color;

import javax.swing.*;
import java.awt.GridLayout;
public class PGPanelAjouterElements extends JPanel
{
    private JButton       btnNoeud;
	private JButton       btnArete;
	private JButton       btnCarteObj;
    
    public PGPanelAjouterElements()
    {
		this.setBackground(new Color(58, 60, 76));
		this.setLayout(new GridLayout(1,3));

		Icon iconNoeud = new ImageIcon("./donnees/images/noeud.png");
		this.btnNoeud = new JButton("Noeud",iconNoeud);
		this.btnNoeud.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.btnNoeud.setHorizontalTextPosition(SwingConstants.CENTER); 
		this.btnNoeud.setBackground(new Color(58,60,76));
		this.btnNoeud.setForeground(Color.WHITE);

		Icon iconArete = new ImageIcon("./donnees/images/arete.png");
		this.btnArete = new JButton("Arete",iconArete);
		this.btnArete.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.btnArete.setHorizontalTextPosition(SwingConstants.CENTER); 
		this.btnArete.setBackground(new Color(58,60,76));
		this.btnArete.setForeground(Color.WHITE);

		Icon iconObjectif = new ImageIcon("./donnees/images/objectif.png");
		this.btnCarteObj = new JButton("Carte Objectif", iconObjectif);
		this.btnCarteObj.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.btnCarteObj.setHorizontalTextPosition(SwingConstants.CENTER); 
		this.btnCarteObj.setBackground(new Color(58,60,76));
		this.btnCarteObj.setForeground(Color.WHITE);

		//alignement des composants
		this.add(this.btnNoeud);
		this.add(this.btnArete);
		this.add(this.btnCarteObj);
    }
}
