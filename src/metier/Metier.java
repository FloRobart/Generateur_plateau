package metier;

import java.awt.Color;
import java.awt.Font;
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

	private int           nbJoueursMin;
	private int           nbJoueursMax;
	private int           nbCarteCoul;
	private int           nbCarteLocomotive;
	private BufferedImage imageCarte;
	private List<Color>   couleurs;
	private List<Integer> points;

	private List<CarteObjectif> carteObjectif;
	private List<Noeud>         noeuds;
	private List<Arete>         aretes;
	
	public Metier()
	{
		this.taillePlateau = new int[2];
		this.couleurs      = new ArrayList<Color>();
		this.points        = new ArrayList<Integer>();
		this.carteObjectif = new ArrayList<CarteObjectif>();
		this.noeuds        = new ArrayList<Noeud>();
		this.aretes        = new ArrayList<Arete>();


		this.noeuds.add(new Noeud("Mon noeud 1", 10, 10, 5, 5, Color.CYAN));
		this.noeuds.add(new Noeud("Mon noeud 2", 50, 50, 45, 45, Color.RED));
		this.noeuds.add(new Noeud("Mon noeud 3", 20, 40, 15, 35, Color.CYAN));
		this.noeuds.add(new Noeud("Mon noeud 4", 40, 30, 35, 25, Color.GREEN));
		this.noeuds.add(new Noeud("Mon noeud 5", 80, 50, 75, 45, Color.ORANGE));

		this.carteObjectif.add(new CarteObjectif(this.noeuds.get(0), this.noeuds.get(1), 10));
		this.carteObjectif.add(new CarteObjectif(this.noeuds.get(1), this.noeuds.get(2), 5));
		this.carteObjectif.add(new CarteObjectif(this.noeuds.get(2), this.noeuds.get(3), 5));
		this.carteObjectif.add(new CarteObjectif(this.noeuds.get(1), this.noeuds.get(3), 15));
		

	}

	public Metier(File fichier)
	{
		this();

		this.lireFichier(fichier);
		this.ecrireFichier("renvoi2"); // a tester
	}

	public int[]               getTaillePlateau    () { return this.taillePlateau;     }
	public BufferedImage       getImagePlateau     () { return this.imagePlateau;      }
	public Color               getCouleurPlateau   () { return this.couleurPlateau;    }
	public Font                getPolicePlateau    () { return this.policePlateau;     }
	public int                 getNbJoueursMin     () { return this.nbJoueursMin;      }
	public int                 getNbJoueursMax     () { return this.nbJoueursMax;      }
	public int                 getNbCarteCoul      () { return this.nbCarteCoul;       }
	public int                 getNbCarteLocomotive() { return this.nbCarteLocomotive; }
	public BufferedImage       getImageCarte       () { return this.imageCarte;        }
	public List<Color>         getCouleurs         () { return this.couleurs;          }
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
			this.imageCarte        = this.base64ToImage(information.getChild("image-carte").getText());  
			
			Element plateau = racine.getChild("plateau");
			
			/* <liste-couleurs> */
			List<Element> listCouleurs = plateau.getChild("liste-couleurs").getChildren("couleur");
			Iterator<Element> itCouleurs = listCouleurs.iterator();
			
			while(itCouleurs.hasNext())
			{
				Element couleur = (Element)itCouleurs.next();
				this.couleurs.add(Color.decode(couleur.getText()));
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

				Color couleur = Color.decode(arete.getChild("couleur").getText());

				int distance = Integer.parseInt(arete.getChild("distance").getText());

				this.aretes.add(new Arete(n1, n2, distance, couleur));
			}

			/* <liste-objectifs> */
			List<Element> listObjectifs = plateau.getChild("liste-objectifs").getChildren("objectif");
			Iterator<Element> itObjectifs = listObjectifs.iterator();

			while(itObjectifs.hasNext())
			{
				Element objectif = (Element)itObjectifs.next();

				Element noeud = objectif.getChild("noeud");
				Noeud n1 = this.noeuds.get(Integer.parseInt(noeud.getAttributeValue("n1"))-1);
				Noeud n2 = this.noeuds.get(Integer.parseInt(noeud.getAttributeValue("n2"))-1);

				int points = Integer.parseInt(objectif.getChild("points").getText());

				this.carteObjectif.add(new CarteObjectif(n1, n2, points));
			}
		} catch (Exception e){ System.out.println(e); }
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

			Element imageCarte = new Element("image-carte");
			information.addContent(imageCarte);
			imageCarte.setText(this.imageToBase64(this.imageCarte));

	
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

			/*
			 * <tableau-points>
			<distance id="1">1</distance>
			<distance id="2">2</distance>
			<distance id="3">3</distance>
			<distance id="4">4</distance>
			<distance id="5">5</distance>
		</tableau-points>
			 */

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

				Element couleur = new Element("couleur");
				arret.addContent(couleur);
				couleur.setText(this.colorToHexa(this.aretes.get(i).getCouleur()));

				Element distance = new Element("distance");
				arret.addContent(distance);
				distance.setText(Integer.toString(this.aretes.get(i).getDistance()));

				Element troncons = new Element("liste-troncons");
				arret.addContent(troncons);

				for (int j = 0; j < this.aretes.get(i).getTroncons().size(); j++)
				{
					Element troncon = new Element("troncon");
					troncons.addContent(troncon);
				}


			}

			/* <liste-objectifs> */
			Element objectifs = new Element("liste-objectifs");
			racine.addContent(objectifs);

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
			}

			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, new FileOutputStream(nomFichier));
		} catch (Exception e){
			e.printStackTrace();
		}



	}

	private String imageToBase64(BufferedImage image) throws IOException 
	{
        ByteArrayOutputStream out = new ByteArrayOutputStream(8192);
        ImageIO.write(image, "png", out);
        return Base64.getEncoder().encodeToString(out.toByteArray());
    }

	private BufferedImage base64ToImage(String base64) throws IOException 
	{
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
		return "#" + Integer.toHexString(color.getRGB()).substring(2);
	}

	public String toString()
	{
		String s = "";

		s += "taillePlateau : " + this.taillePlateau[0] + "x " + this.taillePlateau[1] + "y\n";
		s += "imagePlateau : " + this.imagePlateau + "\n";
		s += "couleurPlateau : " + this.couleurPlateau + "\n";
		s += "points : " + this.points + "\n";
		s += "policePlateau : " + this.policePlateau + "\n";
		s += "nbJoueursMin : " + this.nbJoueursMin + "\n";
		s += "nbJoueursMax : " + this.nbJoueursMax + "\n";
		s += "nbCarteCoul : " + this.nbCarteCoul + "\n";
		s += "nbCarteLocomotive : " + this.nbCarteLocomotive + "\n";
		s += "imageCarte : " + this.imageCarte + "\n";

		return s;
	}
}
