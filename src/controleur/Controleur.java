package controleur;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import ihm.frames.FramePlateau;
import metier.Arete;
//import metier.Metier;
import metier.Metier;
import metier.Noeud;
import metier.CarteObjectif;

import java.awt.image.BufferedImage;


public class Controleur
{
	private FramePlateau ihm;
	private Metier       metier;

	// Constructeur
    public Controleur()
    {
        this.nouveau();
    }

	// Methodes
    public void nouveau() 
    {
        this.metier = new Metier(this);
        
        if (this.ihm != null)
            this.ihm.dispose();
        this.ihm = new FramePlateau(this);
    }

	public void ouvrir(File fichier) 
    {
		this.metier = new Metier(this, fichier);
		
        this.ihm.dispose();
        this.ihm = new FramePlateau(this);
    }

    public void enregistrer    ()                   { this.ihm.enregistrer (); }
	public void enregistrerSous()                   { this.ihm.enregistrer (); }
    public void exporterSous   (String formatImage) { this.ihm.exporterSous(formatImage); }
    public void frameDispose   ()                   { this.ihm.dispose     (); }

	public void genererTxt(String type, String nomFichier)
	{
		this.ihm.dispose();
	}

	/* Getters */
	public Metier getMetier() { return this.metier; } // à enlever

	public int[]         getTaillePlateau () { return this.metier.getTaillePlateau (); }
	public BufferedImage getImagePlateau  () { return this.metier.getImagePlateau  (); }
	public Color         getCouleurPlateau() { return this.metier.getCouleurPlateau(); }
	public Font          getPolicePlateau () { return this.metier.getPolicePlateau (); }

	public int getNbJoueursMin     () { return this.metier.getNbJoueursMin     (); }
	public int getNbJoueursMax     () { return this.metier.getNbJoueursMax     (); }
	public int getNbCarteCoul      () { return this.metier.getNbCarteCoul      (); }
	public int getNbCarteLocomotive() { return this.metier.getNbCarteLocomotive(); }
	public int getNbJetonJoueur    () { return this.metier.getNbJetonJoueur    (); }
	public int getNbJetonFin       () { return this.metier.getNbJetonFin       (); }

	public List<Color>         getCouleurs            () { return this.metier.getCouleurs            (); }
	public BufferedImage       getImageVersoCouleur   () { return this.metier.getImageVersoCouleur   (); }
	public BufferedImage       getImageRectoLocomotive() { return this.metier.getImageRectoLocomotive(); }
	public List<BufferedImage> getImagesRectoCouleur  () { return this.metier.getImagesRectoCouleur  (); }
	public List<Integer>       getPoints              () { return this.metier.getPoints              (); }

	public BufferedImage       getImageVersoObjectif() { return this.metier.getImageVersoObjectif(); }
	public List<CarteObjectif> getCarteObjectif     () { return this.metier.getCarteObjectif     (); }
	public List<Noeud>         getNoeuds            () { return this.metier.getNoeuds            (); }
	public List<Arete>         getAretes            () { return this.metier.getAretes            (); }

	public HashMap<String, List<Color>> getTheme() { return this.metier.getTheme(); }
	
	/* Setters */
	public void setTaillePlateauX(int x)             { this.metier.setTaillePlateauX(x); this.majIHMPlateau(); }
	public void setTaillePlateauY(int y)             { this.metier.setTaillePlateauY(y); this.majIHMPlateau(); }
	public void setCouleurPlateau(Color c)           { this.metier.setCouleurPlateau(c); this.majIHMPlateau(); }
	public void setImagePlateau  (BufferedImage img) { this.metier.setImagePlateau(img); this.majIHMPlateau(); }
	public void setPolicePlateau (Font f)            { this.metier.setPolicePlateau (f); this.majIHMPlateau(); }

	public void setNbJoueursMin     (int val) { this.metier.setNbJoueursMin     (val); }
	public void setNbJoueursMax     (int val) { this.metier.setNbJoueursMax     (val); }
	public void setNbCarteCoul      (int val) { this.metier.setNbCarteCoul      (val); }
	public void setNbCarteLocomotive(int val) { this.metier.setNbCarteLocomotive(val); }
	public void setNbJetonJoueur    (int val) { this.metier.setNbJetonJoueur    (val); }
	public void setNbJetonFin       (int val) { this.metier.setNbJetonFin       (val); }

	public void setImageVersoCouleur   (BufferedImage img) { this.metier.setImageVersoCouleur   (img); }
	public void setImageRectoLocomotive(BufferedImage img) { this.metier.setImageRectoLocomotive(img); }
	public void setImageRectoCouleur(int ind, BufferedImage img) { this.metier.setImageRectoCouleur(ind, img); }
	public void setImageVersoObjectif  (BufferedImage img) { this.metier.setImageVersoObjectif  (img); }

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

	

	

	/**
	 * permet d'afficher la bonne frame en fonction du paramètre qui lui est passé
	 * @param frame : String permettant d'identifer la frame à afficher
	 */
	public void afficher(String frame) 
	{
		switch (frame)
		{
			case "couleur"  : this.ihm.afficher("couleur" ); break;
			case "objectif" : this.ihm.afficher("objectif"); break;	
			case "points"   : this.ihm.afficher("points"  ); break;
			default         : break;
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

    public void majIHMPlateau() 
	{
		this.ihm.majIHM();
    }
    
}