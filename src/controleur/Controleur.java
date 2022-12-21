package controleur;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import ihm.FramePlateau;
import metier.Arete;
import metier.CarteObjectif;
//import metier.Metier;
import metier.Metier;
import metier.Noeud;

import java.awt.image.BufferedImage;

public class Controleur
{
	private FramePlateau ihm;
	private Metier       metier;

    public Controleur()
    {
        this.nouveau();
    }
    public void nouveau() 
    {
        this.metier = new Metier();
        
        if (this.ihm != null)
            this.ihm.dispose();
        this.ihm = new FramePlateau(this);
    }

	/* Getters */
	public Metier getMetier() { return this.metier;}
	public Font getPolicePlateau() { return this.metier.getPolicePlateau(); }
	public List<Noeud> getNoeuds() { return this.metier.getNoeuds(); }
	public List<Arete> getAretes() { return this.metier.getAretes(); }
	

	/* Setters */
	public void setPositionNoeud(int id, int x, int y)
	{
		this.metier.setPositionNoeud(id, x, y);
	}

	public void setPositionNomNoeud(int id, int x, int y)
	{
		this.metier.setPositionNomNoeud(id, x, y);
	}

	//methodes

	public void ouvrir(File fichier) 
    {
		this.metier = new Metier(fichier);
		
        this.ihm.dispose();
        this.ihm = new FramePlateau(this);
    }

    public void enregistrer    ()                   { this.ihm.enregistrer (); }
	public void enregistrerSous()                   { this.ihm.enregistrer (); }
    public void exporterSous   (String formatImage) { this.ihm.exporterSous(formatImage); }
    public void frameDispose   ()                   { this.ihm.dispose     (); }
	
	
	public void changerTheme(String theme)
	{
		/* Changer le thème utilisé dans le fichier theme_sauvegarde.xml ET charger en mémoire le nouveau thème */
		this.metier.setThemeUsed(theme);
	}

	/* Met à jour l'IHM avec le nouveau thème */
	public void appliquerTheme()
	{
		this.ihm.appliquerTheme();
	}

	public HashMap<String, List<Color>> getTheme()
	{
		return this.metier.getTheme();
	}

	public void genererTxt(String type, String nomFichier)
	{
		this.ihm.dispose();
	}

    public void setCouleur(Color color) {

		this.ihm.setCouleur(color);
    }

	public void setImageFond(BufferedImage img) {

		this.ihm.setImageFond(img);
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