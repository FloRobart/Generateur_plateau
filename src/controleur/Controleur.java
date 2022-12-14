package controleur;
import java.awt.Color;
import java.io.File;

import ihm.FramePlateau;
//import metier.Metier;
import metier.Metier;

public class Controleur
{
	private FramePlateau ihm;
	private Metier       metier;

	public Controleur()
	{
		this.ihm     = new FramePlateau(this);
		this.metier  = null;
	}

	public Metier getMetier() { return this.metier; }

	//methodes
	public void nouveau() 
    {
		this.metier = new Metier();
		
        this.ihm.dispose();
        this.ihm = new FramePlateau(this);
    }

    public void ouvrir(File fichier) 
    {
		//this.metier = new Metier(fichier);
		//System.out.println(this.metier);
		/*
        this.ihm.dispose();
        this.ihm = new FrameCuves(this);*/
    }

    public void enregistrer    () { this.ihm.enregistrer (); }
	public void enregistrerSous() { this.ihm.enregistrer (); }
    public void exporterSous   () { this.ihm.exporterSous(); }
    public void frameDispose   () { this.ihm.dispose     (); }


	public void genererTxt(String type, String nomFichier)
	{
		this.ihm.dispose();
	}

    public void setCouleur(Color color) {

		this.ihm.setCouleur(color);
    }

	public void afficher(String frame) 
	{
		switch (frame) {
			case "couleur": this.ihm.afficher("couleur"); break;
			case "objectif": this.ihm.afficher("objectif"); break;	
			case "points": this.ihm.afficher("points"); break;
			default:
				break;
		}
	}


	/**
	 * Main
	 * @param args : Tableau de String
	 */
	public static void main(String[] args) { new Controleur(); }
}