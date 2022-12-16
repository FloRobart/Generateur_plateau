package metier;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Metier 
{
	private int[]         taillePlateau;
	private BufferedImage imagePlateau;
	private Color         couleurPlateau;
	private Font          policePlateau;

	private int nbJoueursMin;
	private int nbJoueursMax;
	private int nbCarteCoul;
	private int nbCarteLocomotive;
	private int nbJetonJoueur;
	private int nbJetonFin;

	private List<Color>         couleurs;
	private BufferedImage       imageVersoCouleur;
	private BufferedImage       imageRectoLocomotive;
	private List<BufferedImage> imagesRectoCouleur;

	private List<Integer> points;

	private BufferedImage       imageVersoObjectif;
	private List<CarteObjectif> carteObjectif;

	private List<Noeud>         noeuds;
	private List<Arete>         aretes;
	
	public Metier()
	{
		this.taillePlateau      = new int[2];
		this.couleurs           = new ArrayList<Color>();
		this.imagesRectoCouleur = new ArrayList<BufferedImage>();
		this.points             = new ArrayList<Integer>();
		this.carteObjectif      = new ArrayList<CarteObjectif>();
		this.noeuds             = new ArrayList<Noeud>();
		this.aretes             = new ArrayList<Arete>();
/*
		this.policePlateau = new Font("Arial", Font.PLAIN, 12);
		this.couleurPlateau = Color.WHITE;
		this.nbJoueursMin = 2;
		this.nbJoueursMax = 5;
		this.nbCarteCoul = 12;
		this.nbCarteLocomotive = 14;
		this.taillePlateau[0] = 1000;
		this.taillePlateau[1] = 1000;
		this.imagePlateau = new BufferedImage(this.taillePlateau[0], this.taillePlateau[1], BufferedImage.TYPE_INT_RGB);
*/


		this.noeuds.add(new Noeud("Mon noeud 1", 100, 100, 50, 50, Color.CYAN));
		this.noeuds.add(new Noeud("Mon noeud 2", 500, 500, 450, 450, Color.RED));
		this.noeuds.add(new Noeud("Mon noeud 3", 200, 400, 150, 350, Color.CYAN));
		this.noeuds.add(new Noeud("Mon noeud 4", 400, 300, 350, 250, Color.GREEN));
		this.noeuds.add(new Noeud("Mon noeud 5", 800, 500, 750, 450, Color.ORANGE));

		this.aretes.add(new Arete(this.noeuds.get(0), this.noeuds.get(3), 3, Color.BLUE, Color.gray));
		

/*		this.carteObjectif.add(new CarteObjectif(this.noeuds.get(0), this.noeuds.get(1), 10, null));
		this.carteObjectif.add(new CarteObjectif(this.noeuds.get(1), this.noeuds.get(2),  5, null));
		this.carteObjectif.add(new CarteObjectif(this.noeuds.get(2), this.noeuds.get(3),  5, null));
		this.carteObjectif.add(new CarteObjectif(this.noeuds.get(1), this.noeuds.get(3), 15, null));
*/

	}

	public Metier(File fichier)
	{
		this();

		this.lireFichier(fichier);
		System.out.println(this);
	}

	public int[]               getTaillePlateau    () { return this.taillePlateau;     }
	public BufferedImage       getImagePlateau     () { return this.imagePlateau;      }
	public Color               getCouleurPlateau   () { return this.couleurPlateau;    }
	public Font                getPolicePlateau    () { return this.policePlateau;     }
	public int                 getNbJoueursMin     () { return this.nbJoueursMin;      }
	public int                 getNbJoueursMax     () { return this.nbJoueursMax;      }
	public int                 getNbCarteCoul      () { return this.nbCarteCoul;       }
	public int                 getNbCarteLocomotive() { return this.nbCarteLocomotive; }
	public int                 getNbJetonJoueur    () { return this.nbJetonJoueur;     }
	public int                 getNbJetonFin       () { return this.nbJetonFin;        }
	public List<Color>         getCouleurs         () { return this.couleurs;          }
	public BufferedImage       getImageVersoCouleur() { return this.imageVersoCouleur; }
	public BufferedImage       getImageRectoLocomotive() { return this.imageRectoLocomotive; }
	public List<BufferedImage> getImagesRectoCouleur() { return this.imagesRectoCouleur; }
	public List<Integer>       getPoints           () { return this.points;            }
	public BufferedImage       getImageVersoObjectif() { return this.imageVersoObjectif; }
	public List<CarteObjectif> getCarteObjectif    () { return this.carteObjectif;     }
	public List<Noeud>         getNoeuds           () { return this.noeuds;            }
	public List<Arete>         getAretes           () { return this.aretes;            }

	private void lireFichier(File fichier)
	{
		SAXBuilder sxb = new SAXBuilder();

		try {
			Document document = sxb.build(fichier);

			/* <jeu> */
			Element racine = document.getRootElement();

			/* <information> */
			Element information = racine.getChild("information");

			Element dimension = information.getChild("dimension");
			this.taillePlateau[0] = Integer.parseInt(dimension.getAttributeValue("x"));
			this.taillePlateau[1] = Integer.parseInt(dimension.getAttributeValue("y"));
			this.imagePlateau     = this.base64ToImage(information.getChild("image-fond").getText()); 
			this.couleurPlateau   = hexaToColor(information.getChild("couleur-fond").getText());   
			this.policePlateau    = new Font (information.getChild("police").getText(), Font.PLAIN, 12);
			
			Element nbJoueurs = information.getChild("nombre-joueurs");
			this.nbJoueursMin = Integer.parseInt(nbJoueurs.getAttributeValue("min"));
			this.nbJoueursMax = Integer.parseInt(nbJoueurs.getAttributeValue("max"));

			Element nbCarte = information.getChild("nombre-carte");
			this.nbCarteCoul       = Integer.parseInt(nbCarte.getAttributeValue("couleur"));
			this.nbCarteLocomotive = Integer.parseInt(nbCarte.getAttributeValue("multicouleur"));

			Element nbJeton = information.getChild("nombre-jeton");
			this.nbJetonJoueur = Integer.parseInt(nbJeton.getAttributeValue("joueur"));
			this.nbJetonFin    = Integer.parseInt(nbJeton.getAttributeValue("fin"));
			
			Element plateau = racine.getChild("plateau");
			
			/* <liste-couleurs> */
			List<Element> listCouleurs = plateau.getChild("liste-couleurs").getChildren("couleur");
			Iterator<Element> itCouleurs = listCouleurs.iterator();
			
			while(itCouleurs.hasNext())
			{
				Element couleur = (Element)itCouleurs.next();
				this.couleurs.add(Color.decode(couleur.getText()));
			}

			/* <liste-image_cartes> */
			this.imageVersoCouleur = this.base64ToImage(plateau.getChild("liste-image-cartes")
										.getChild("image-verso").getText());

			List<Element> listImagesCartes = plateau.getChild("liste-image-cartes").getChildren("image-recto");
			Iterator<Element> itImagesCartes = listImagesCartes.iterator();

			this.imageRectoLocomotive = this.base64ToImage(itImagesCartes.next().getText());
			while(itImagesCartes.hasNext())
			{
				Element imageCarte = (Element)itImagesCartes.next();
				BufferedImage image = this.base64ToImage(imageCarte.getText());
				this.imagesRectoCouleur.add(image);
			}
			
			/* <tableau-points */
			 List<Element> listPoints = plateau.getChild("tableau-points").getChildren("distance");
			 Iterator<Element> itPoints = listPoints.iterator();

			 while(itPoints.hasNext())
			 {
				 Element point = (Element)itPoints.next();
				 this.points.add(Integer.parseInt(point.getText()));
			 }

			/* <liste-noeuds> */
			Noeud.reinitialiserId();
			List<Element> listNoeuds = plateau.getChild("liste-noeuds").getChildren("noeud");
			Iterator<Element> itNoeuds = listNoeuds.iterator();

			while(itNoeuds.hasNext())
			{
				Element noeud = (Element)itNoeuds.next();

				Element position = noeud.getChild("position");
				int x = Integer.parseInt(position.getAttributeValue("x"));
				int y = Integer.parseInt(position.getAttributeValue("y"));

				String nom = noeud.getChild("nom").getText();

				Element positionNom = noeud.getChild("position-nom");
				int xNom = Integer.parseInt(positionNom.getAttributeValue("x"));
				int yNom = Integer.parseInt(positionNom.getAttributeValue("y"));

				Color couleur = Color.decode(noeud.getChild("couleur").getText());

				this.noeuds.add(new Noeud(nom, x, y, xNom, yNom, couleur));
			}

			/* <liste-aretes> */
			List<Element> listAretes = plateau.getChild("liste-aretes").getChildren("arete");
			Iterator<Element> itAretes = listAretes.iterator();

			while(itAretes.hasNext())
			{
				Element arete = (Element)itAretes.next();

				Element noeud = arete.getChild("noeud");
				Noeud n1 = this.noeuds.get(Integer.parseInt(noeud.getAttributeValue("n1"))-1);
				Noeud n2 = this.noeuds.get(Integer.parseInt(noeud.getAttributeValue("n2"))-1);

				Color couleur1 = Color.decode(arete.getChild("couleur1").getText());

				Color couleur2;
				if(arete.getChild("couleur2").getText().equals("NULL"))
					couleur2 = null;
				else
					couleur2 = Color.decode(arete.getChild("couleur2").getText());

				int distance = Integer.parseInt(arete.getChild("distance").getText());

				this.aretes.add(new Arete(n1, n2, distance, couleur1, couleur2));
			}

			/* <liste-objectifs> */
			this.imageVersoObjectif = this.base64ToImage(racine.getChild("liste-objectifs")
										.getChild("image-verso").getText());

			List<Element> listObjectifs = racine.getChild("liste-objectifs").getChildren("objectif");
			Iterator<Element> itObjectifs = listObjectifs.iterator();

			while(itObjectifs.hasNext())
			{
				Element objectif = (Element)itObjectifs.next();

				Element noeud = objectif.getChild("noeud");
				Noeud n1 = this.noeuds.get(Integer.parseInt(noeud.getAttributeValue("n1"))-1);
				Noeud n2 = this.noeuds.get(Integer.parseInt(noeud.getAttributeValue("n2"))-1);

				int points = Integer.parseInt(objectif.getChild("points").getText());

				BufferedImage imageRecto = this.base64ToImage(objectif.getChild("image-recto").getText());

				this.carteObjectif.add(new CarteObjectif(n1, n2, points, imageRecto));
			}
		} catch (Exception e){ e.printStackTrace(); }
	}

	public void ecrireFichier(String nomFichier)
	{
		try {
			Document document = new Document();
			
			/* <jeu> */
			Element racine = new Element("jeu");
			document.setRootElement(racine);
			
			/* <information> */
			Element information = new Element("information");
			racine.addContent(information);

			Element dimension = new Element("dimension");
			information.addContent(dimension);
			dimension.setAttribute("x", Integer.toString(this.taillePlateau[0]));
			dimension.setAttribute("y", Integer.toString(this.taillePlateau[1]));

			Element imageFond = new Element("image-fond");
			information.addContent(imageFond);
			imageFond.setText(this.imageToBase64(this.imagePlateau));

			Element couleurFond = new Element("couleur-fond");
			information.addContent(couleurFond);
			couleurFond.setText(this.colorToHexa(this.couleurPlateau));

			Element police = new Element("police");
			information.addContent(police);
			police.setText(this.policePlateau.getFontName());

			Element nbJoueurs = new Element("nombre-joueurs");
			information.addContent(nbJoueurs);
			nbJoueurs.setAttribute("min", Integer.toString(this.nbJoueursMin));
			nbJoueurs.setAttribute("max", Integer.toString(this.nbJoueursMax));

			Element nbCarte = new Element("nombre-carte");
			information.addContent(nbCarte);
			nbCarte.setAttribute("couleur", Integer.toString(this.nbCarteCoul));
			nbCarte.setAttribute("multicouleur", Integer.toString(this.nbCarteLocomotive));

			Element nbJeton = new Element("nombre-jeton");
			information.addContent(nbJeton);
			nbJeton.setAttribute("joueur", Integer.toString(this.nbJetonJoueur));
			nbJeton.setAttribute("fin", Integer.toString(this.nbJetonFin));
	
			Element plateau = new Element("plateau");
			racine.addContent(plateau);

			/* <liste-couleurs> */
			Element couleurs = new Element("liste-couleurs");
			plateau.addContent(couleurs);

			for (int i = 0; i < this.couleurs.size(); i++)
			{
				Element couleur = new Element("couleur");
				couleurs.addContent(couleur);
				couleur.setAttribute("id", Integer.toString(i+1));
				couleur.setText(this.colorToHexa(this.couleurs.get(i)));
			}

			/* <liste-image-cartes> */
			Element imagesCartes = new Element("liste-image-cartes");
			plateau.addContent(imagesCartes);

			Element imageVersoCoul = new Element("image-verso");
			imagesCartes.addContent(imageVersoCoul);
			imageVersoCoul.setText(imageToBase64(this.imageVersoCouleur));

			Element imageRectoLoco = new Element("image-recto");
			imagesCartes.addContent(imageRectoLoco);
			imageRectoLoco.setAttribute("id", "locomotive");
			imageRectoLoco.setText(imageToBase64(this.imageRectoLocomotive));

			for (int i = 0; i < this.imagesRectoCouleur.size(); i++)
			{
				Element imageRecto = new Element("image-recto");
				imagesCartes.addContent(imageRecto);
				imageRecto.setAttribute("id", Integer.toString(i+1));
				imageRecto.setText(this.imageToBase64(this.imagesRectoCouleur.get(i)));
			}
			
			/* <tableau-points> */
			Element tabPoints = new Element("tableau-points");
			plateau.addContent(tabPoints);

			for (int i = 0; i < this.points.size(); i++)
			{
				Element distance = new Element("distance");
				tabPoints.addContent(distance);
				distance.setAttribute("id", Integer.toString(i+1));
				distance.setText(Integer.toString(this.points.get(i)));
			}

			/* <liste-noeuds> */
			Element noeuds = new Element("liste-noeuds");
			plateau.addContent(noeuds);

			for (int i = 0; i < this.noeuds.size(); i++)
			{
				Element noeud = new Element("noeud");
				noeuds.addContent(noeud);
				noeud.setAttribute("id", Integer.toString(i+1));
				
				Element position = new Element("position");
				noeud.addContent(position);
				position.setAttribute("x", Integer.toString(this.noeuds.get(i).getX()));
				position.setAttribute("y", Integer.toString(this.noeuds.get(i).getY()));

				Element nom = new Element("nom");
				noeud.addContent(nom);
				nom.setText(this.noeuds.get(i).getNom());

				Element position_nom = new Element("position-nom");
				noeud.addContent(position_nom);
				position_nom.setAttribute("x", Integer.toString(this.noeuds.get(i).getXNom()));
				position_nom.setAttribute("y", Integer.toString(this.noeuds.get(i).getYNom()));

				Element couleur = new Element("couleur");
				noeud.addContent(couleur);
				couleur.setText(this.colorToHexa(this.noeuds.get(i).getCouleur()));
			}

			/* <liste-aretes> */
			Element arrets = new Element("liste-aretes");
			plateau.addContent(arrets);

			for (int i = 0; i < this.aretes.size(); i++)
			{
				Element arret = new Element("arete");
				arrets.addContent(arret);

				Element noeud = new Element("noeud");
				arret.addContent(noeud);
				noeud.setAttribute("n1", Integer.toString(this.aretes.get(i).getNoeud1().getId()));
				noeud.setAttribute("n2", Integer.toString(this.aretes.get(i).getNoeud2().getId()));

				Element couleur1 = new Element("couleur1");
				arret.addContent(couleur1);
				couleur1.setText(this.colorToHexa(this.aretes.get(i).getCouleur1()));

				Element couleur2 = new Element("couleur2");
				arret.addContent(couleur2);
				if (this.aretes.get(i).getCouleur2() == null)
					couleur2.setText("NULL");
				else
					couleur2.setText(this.colorToHexa(this.aretes.get(i).getCouleur2()));

				Element distance = new Element("distance");
				arret.addContent(distance);
				distance.setText(Integer.toString(this.aretes.get(i).getDistance()));
			}

			/* <liste-objectifs> */
			Element objectifs = new Element("liste-objectifs");
			racine.addContent(objectifs);

			Element versoObjectif = new Element("image-verso");
			objectifs.addContent(versoObjectif);
			versoObjectif.setText(imageToBase64(this.imageVersoObjectif));

			for (int i = 0; i < this.carteObjectif.size(); i++)
			{
				Element objectif = new Element("objectif");
				objectifs.addContent(objectif);

				Element noeud = new Element("noeud");
				objectif.addContent(noeud);
				noeud.setAttribute("n1", Integer.toString(this.carteObjectif.get(i).getNoeud1().getId()));
				noeud.setAttribute("n2", Integer.toString(this.carteObjectif.get(i).getNoeud2().getId()));

				Element points = new Element("points");
				objectif.addContent(points);
				points.setText(Integer.toString(this.carteObjectif.get(i).getPoints()));

				Element rectoObjectif = new Element("image-recto");
				objectif.addContent(rectoObjectif);
				rectoObjectif.setText(imageToBase64(this.carteObjectif.get(i).getImageRecto()));
			}

			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, new FileOutputStream(nomFichier));
		} catch (Exception e){
			e.printStackTrace();
		}



	}

	private String imageToBase64(BufferedImage image) throws IOException 
	{
		if (image == null) return "NULL_IMAGE";
        ByteArrayOutputStream out = new ByteArrayOutputStream(8192);
        ImageIO.write(image, "png", out);
        return Base64.getEncoder().encodeToString(out.toByteArray());
    }

	private BufferedImage base64ToImage(String base64) throws IOException 
	{
		if (base64.equals("NULL_IMAGE"))
		{
			BufferedImage imageIO = new BufferedImage(10, 50, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = imageIO.createGraphics();
			g2d.setColor(Color.WHITE);
			g2d.fillRect(0, 0, 10, 50);
			g2d.drawString("Image invalide", 0, 10);
			g2d.dispose();
			return imageIO;
		}
		byte[] bytes = Base64.getDecoder().decode(base64);
		return ImageIO.read(new ByteArrayInputStream(bytes));
	}

	private Color hexaToColor(String hexa)
	{
		if (hexa.charAt(0) != '#') return null;

		return new Color( Integer.parseInt(hexa.substring(1, 3), 16),
		                  Integer.parseInt(hexa.substring(3, 5), 16),
		                  Integer.parseInt(hexa.substring(5, 7), 16) );
	}

	private String colorToHexa(Color color)
	{
		if (color == null) return "#0F0F0F";
		return "#" + Integer.toHexString(color.getRGB()).substring(2);
	}

	public String toString()
	{
		String s = "";

		s += "taillePlateau : " + this.taillePlateau[0] + "x " + this.taillePlateau[1] + "y\n\n";
		s += "imagePlateau : " + this.imagePlateau + "\n\n";
		s += "couleurPlateau : " + this.couleurPlateau + "\n\n";
		s += "policePlateau : " + this.policePlateau + "\n\n";
		s += "nbJoueursMin : " + this.nbJoueursMin + "\n\n";
		s += "nbJoueursMax : " + this.nbJoueursMax + "\n\n";
		s += "nbCarteCoul : " + this.nbCarteCoul + "\n\n";
		s += "nbCarteLocomotive : " + this.nbCarteLocomotive + "\n\n";
		s += "nbJetonJoueur : " + this.nbJetonJoueur + "\n\n";
		s += "nbJetonFin : " + this.nbJetonFin + "\n\n";
		s += "couleurs : " + this.couleurs + "\n\n";
		s += "imageVersoCouleur : " + this.imageVersoCouleur + "\n\n";
		s += "imageRectoLocomotive : " + this.imageRectoLocomotive + "\n\n";
		s += "imagesRectoCouleur : " + this.imagesRectoCouleur + "\n\n";
		s += "points : " + this.points + "\n\n";
		s += "imageVersoObjectif : " + this.imageVersoObjectif + "\n\n";
		s += "carteObjectif : " + this.carteObjectif + "\n\n";
		s += "noeuds : " + this.noeuds + "\n\n";
		s += "aretes : " + this.aretes + "\n\n";

		return s;
	}

	/**
	 * Ajoute un Noeud
	 * @param nom : nom du noeud
	 * @param posX : position X du noeud
	 * @param posY	: position Y du noeud
	 * @param posNomX : position X du nom du noeud
	 * @param posNomY : position Y du nom du noeud
	 * @param couleur : couleur du noeud
	 */
    public void ajouterNoeud(String nom, int posX, int posY, int posNomX, int posNomY, Color couleur) 
	{
		this.noeuds.add(new Noeud(nom, posX, posY, posNomX, posNomY, couleur));
    }


	/**
	 * Supprime un Noeud
	 * @param nom : nom du noeud
	 */
    public void supprimerNoeud(String nom) 
	{
		for (int i = 0; i < this.noeuds.size(); i++)
		{
			if (this.noeuds.get(i).getNom().equals(nom))
			{
				this.noeuds.remove(i);
				return;
			}
		}
    }

    public void ajouterArete(String nom1, String nom2, int distance, Color couleur1, Color couleur2) 
	{
		Noeud nA=null;
		Noeud nB=null;

		for (Noeud n : this.noeuds)
		{
			if (n.getNom().equals(nom1))
			{
				nA = n;
			}

			if(n.getNom().equals(nom2))
			{
				nB = n;
			}
		}

		this.aretes.add(new Arete(nA, nB, distance, couleur1, couleur2));
    }

    public void supprimerArete(String nom1, String nom2) 
	{
		for(Arete a : this.aretes)
		{
			if (a.getNoeud1().getNom().equals(nom1) && a.getNoeud2().getNom().equals(nom2))
			{
				this.aretes.remove(a);
				return;
			}
		}
    }
}
