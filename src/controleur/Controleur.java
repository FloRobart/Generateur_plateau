package controleur;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import ihm.FramePlateau;
import metier.Arete;
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
		this.metier.addControleur(this);
        
        if (this.ihm != null)
            this.ihm.dispose();
        this.ihm = new FramePlateau(this);
    }

	/* Getters */
	public Metier getMetier() { return this.metier;}
	public int[] getTaillePlateau() { return this.metier.getTaillePlateau(); }
	public BufferedImage getImagePlateau() { return this.metier.getImagePlateau(); }
	public Color getCouleurPlateau() { return this.metier.getCouleurPlateau(); }
	public Font getPolicePlateau() { return this.metier.getPolicePlateau(); }
	public List<Noeud> getNoeuds() { return this.metier.getNoeuds(); }
	public List<Arete> getAretes() { return this.metier.getAretes(); }
	public List<Color> getCouleurs() {return this.metier.getCouleurs(); }
	

	/* Setters */
	public void setPositionNoeud(int id, int x, int y)
	{
		this.metier.setPositionNoeud(id, x, y);
	}

	public void setPositionNomNoeud(int id, int x, int y)
	{
		this.metier.setPositionNomNoeud(id, x, y);
	}

	public void ajouterCouleur(Color c)
	{
		this.metier.ajouterCouleur(c);
	}

	public void supprimerCouleur(Color c)
	{
		this.metier.supprimerCouleur(c);
	}

	public void setCouleurPlateau(Color c)
	{
		this.metier.setCouleurPlateau(c);
		this.ihm.majIHM();
    }

	public void setImagePlateau(BufferedImage img)
	{
		this.metier.setImagePlateau(img);
		this.ihm.setImageFond(img);
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
	 * Ajouter une ligne au tableau des scores
	 * @param index : Index de la ligne
	 */
	public void setNbPoint(int index) 
	{
		this.metier.setNbPoint(index);
	}

	/**
	 * Supprimer une ligne du tableau des scores
	 */
    public void supprimerPoint() 
	{
		this.metier.supprimerPoint();
    }

	/**
	 * Ajouter un objectif
	 * @param nom1 : Nom du premier noeud
	 * @param nom2 : Nom du second noeud
	 * @param point : Nombre de points
	 */
	public void ajouterObjectif(String nom1, String nom2, int point) 
	{
		this.metier.ajouterObjectif(nom1, nom2, point);
	}

	/**
	 * Supprimer un objectif
	 * @param string : Nom du premier noeud
	 * @param string2 : Nom du second noeud
	 */
    public void supprimerObjectif(String string, String string2) 
	{
		this.metier.supprimerObjectif(string, string2);
    }

	/**
	 * Ajouter une arête
	 * @param nom1 : Nom du premier noeud
	 * @param nom2 : Nom du second noeud 
	 * @param distance : Distance entre les deux noeuds 
	 * @param couleur1 : Couleur de l'arete 
	 * @param couleur2 : Couleur 2 de l'arete si double voie 
	 */
    public void ajouterArete(String nom1, String nom2, int distance, Color couleur1, Color couleur2) 
	{
		this.metier.ajouterArete(nom1, nom2, distance, couleur1, couleur2);
    }
	/**
	 * Supprimer une arête
	 * @param nom1 Nom du premier noeud
	 * @param nom2 Nom du second noeud
	 */
	public void supprimerArete(String nom1, String nom2)
	{
		this.metier.supprimerArete(nom1, nom2);
	}

	/**
	 * Supprimer un noeud
	 * @param nom : Nom du noeud
	 */
    public void supprimerNoeud(String nom) 
	{
		this.metier.supprimerNoeud(nom);
    }

	/**
	 * Ajouter un noeud
	 * @param nom : Nom du noeud
	 * @param posX : Position X du noeud
	 * @param posY : Position Y du noeud
	 * @param posNomX : Position X du nom du noeud
	 * @param posNomY : Position Y du nom du noeud
	 * @param couleur : Couleur du noeud
	 */
    public void ajouterNoeud(String nom, int posX, int posY, int posNomX, int posNomY, Color couleur) 
	{
		this.metier.ajouterNoeud(nom, posX, posY, posNomX, posNomY, couleur);
    }

	/**
	 * Main
	 * @param args : Tableau de String
	 */
	public static void main(String[] args) { new Controleur(); }
    
}