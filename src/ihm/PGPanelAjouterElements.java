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
		this.add(this.btnNoeud);
		this.add(this.btnArete);
		this.add(this.btnCarteObj);
    }
}
