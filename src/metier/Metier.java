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

	private List<CarteObjectif> carteObjectif;
	private List<Noeud>         noeuds;
	private List<Arete>         aretes;
	
	public Metier(String nomFichier)
	{
		this.taillePlateau = new int[2];
		this.carteObjectif = new ArrayList<CarteObjectif>();
		this.noeuds        = new ArrayList<Noeud>();
		this.aretes        = new ArrayList<Arete>();

		this.lireFichier(nomFichier);
		//this.ecrireFichier(nomFichier); // a tester
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

	private void lireFichier(String nomFichier)
	{
		String lienFichier = "./" + nomFichier + ".xml";

		SAXBuilder sxb = new SAXBuilder();
		try {
			Document document = sxb.build(new File( lienFichier ));

			/* <jeu> */
			Element racine = document.getRootElement();

			/* <information> */
			Element information = racine.getChild("information");

			Element dimension = information.getChild("dimension");
			this.taillePlateau[0] = Integer.parseInt(dimension.getAttributeValue("x"));
			this.taillePlateau[1] = Integer.parseInt(dimension.getAttributeValue("y"));
			this.imagePlateau     = this.base64ToImage(information.getChild("image-fond").getText()); 
			this.couleurPlateau   = this.hexaToColor(information.getChild("couleur-fond").getText());   
			this.policePlateau    = new Font (information.getChild("police").getText(), Font.PLAIN, 12);
			
			Element nbJoueurs = information.getChild("nombre-joueurs");
			this.nbJoueursMin = Integer.parseInt(nbJoueurs.getAttributeValue("min"));
			this.nbJoueursMax = Integer.parseInt(nbJoueurs.getAttributeValue("max"));

			Element nbCarte        = information.getChild("nombre-carte");
			this.nbCarteCoul       = Integer.parseInt(nbCarte.getAttributeValue("couleur"));
			this.nbCarteLocomotive = Integer.parseInt(nbCarte.getAttributeValue("multicouleur"));
			this.imageCarte        = this.base64ToImage(information.getChild("image-carte").getText());  
			
			/* <liste-couleurs> */
			List listCouleurs = plateau.getChild("liste-couleurs").getChildren("couleur");
			Iterator itCouleurs = listCouleurs.iterator();
			
			while(itCouleurs.hasNext())
			{
				Element couleur = (Element)itCouleurs.next();
				this.couleurs.add(Color.decode(couleur.getText()));
			}
			
		} catch (Exception e){}
	}

	private void ecrireFichier(String nomFichier)
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

			/* <carte-objectif> */
			Element plateau = new Element("plateau");
			racine.addContent(plateau);

			Element carteObjectif = new Element("liste-objectifs");
			plateau.addContent(carteObjectif);

			Element aretes = new Element("liste-aretes");
			plateau.addContent(aretes);

			Element noeuds = new Element("liste-noeuds");
			plateau.addContent(noeuds);

			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, new FileOutputStream("./" + nomFichier + ".xml"));
			

		} catch (Exception e){}



	}

	private String imageToBase64(BufferedImage image) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream(8192);
        ImageIO.write(image, "png", out);
        return Base64.getEncoder().encodeToString(out.toByteArray());
    }

	private BufferedImage base64ToImage(String base64) throws IOException {
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
		s += "policePlateau : " + this.policePlateau + "\n";
		s += "nbJoueursMin : " + this.nbJoueursMin + "\n";
		s += "nbJoueursMax : " + this.nbJoueursMax + "\n";
		s += "nbCarteCoul : " + this.nbCarteCoul + "\n";
		s += "nbCarteLocomotive : " + this.nbCarteLocomotive + "\n";
		s += "imageCarte : " + this.imageCarte + "\n";

		return s;
	}
	

	public static void main(String[] args)
	{
		Metier m = new Metier("exemple");
		System.out.println(m);
	}
}
