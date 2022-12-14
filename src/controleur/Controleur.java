package controleur;
import java.awt.Color;
import java.io.File;

import ihm.FramePlateau;
import ihm.PanelGenerateur;

public class Controleur
{
	private FramePlateau ihm;
	private PanelGenerateur  metier;

	public Controleur()
	{
		this.ihm     = new FramePlateau(this);
		this.metier  = null;
	}

	public void creerMetier(int nbCuves)
	{
		this.metier = new PanelGenerateur(this);
	}

	//modificateurs


	//methodes
	public void nouveau() 
    {
        this.ihm.setEnabled(false);
        new FramePlateau(this);
    }

    public void finNouveau()
    {
        this.ihm.setEnabled(true);
        this.ihm.setState(this.ihm.NORMAL);
    }

    public void ouvrir(File fichier) 
    {
		/*
        this.metier = new Structure(fichier);
        this.metier.optimiserPositions();

        this.ihm.dispose();
        this.ihm = new FrameCuves(this);*/
    }

    public void enregistrer    () { this.ihm.enregistrer (); }
	public void enregistrerSous    () { this.ihm.enregistrer (); }
    public void exporterSous() { this.ihm.exporterSous(); }
    public void frameDispose() { this.ihm.dispose     (); }


	public void genererTxt(String type, String nomFichier)
	{
		this.ihm.dispose();
	}

	//accesseurs

	public static void main(String[] args) { new Controleur(); }

    public void setCouleur(Color color) {

		this.ihm.setCouleur(color);
    }   
}