package controleur;
import java.awt.Color;
import java.io.File;
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
        
        if (this.ihm != null)
            this.ihm.dispose();
        this.ihm = new FramePlateau(this);
    }

	public Metier getMetier() { return this.metier; }

	//methodes

	public void ouvrir(String fichier) 
    {
		this.metier = new Metier(new File(fichier));
		
        this.ihm.dispose();
        this.ihm = new FramePlateau(this);
    }

    public void enregistrer    () { this.ihm.enregistrer (); }
	public void enregistrerSous() { this.ihm.enregistrer (); }
    public void exporterSous   (String formatImage) { this.ihm.exporterSous(formatImage); }
    public void frameDispose   () { this.ihm.dispose     (); }


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
	 * Ajouter un noeud
	 * @param nom : Nom du noeud(ville)
	 * @param posX : Position X du noeud
	 * @param posY	: Position Y du noeud
	 * @param posNomX : Position X du nom du noeud
	 * @param posNomY : Position Y du nom du noeud
	 * @param couleur : Couleur du noeud
	 */
	public void ajouterNoeud(String nom, int posX, int posY, int posNomX, int posNomY, Color couleur) 
	{
		this.metier.ajouterNoeud(nom, posX, posY, posNomX, posNomY, couleur);
    }

	/**
	 * suppression d'un noeud
	 * @param nom : Nom du noeud(ville)
	 */
	public void supprimerNoeud(String nom)
	{
		this.metier.supprimerNoeud(nom);
    }

	/**
	 * Ajouter une arete
	 * @param nom1 : nom du premier noeud
	 * @param nom2 : nom du deuxième noeud
	 * @param distance : nombre de tronçons
	 * @param couleur1 : couleur de la voie
	 * @param couleur2 : couleur de la deuxième voie si double voie
	*/
	public void ajouterArete(String nom1, String nom2, int distance, Color couleur1, Color couleur2) 
	{
		this.metier.ajouterArete(nom1, nom2, distance, couleur1, couleur2);
	}

    public void supprimerArete(String nom1, String nom2) 
	{
		this.metier.supprimerArete(nom1, nom2);
    }
	
	public List<Noeud> getNoeuds() { return this.metier.getNoeuds(); }
	public List<Arete> getAretes() { return this.metier.getAretes();}

	/**
	 * Main
	 * @param args : Tableau de String
	 */
	public static void main(String[] args) { new Controleur(); }
	
    
    
}