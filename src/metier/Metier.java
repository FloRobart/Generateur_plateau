package metier;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
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

	private List<CarteObjectif> piocheCarteObjectif;
	private List<Noeud>         noeuds;
	private List<Arete>         aretes;
	
	public Metier()
	{
		this.taillePlateau       = new int[2];
		this.piocheCarteObjectif = new ArrayList<CarteObjectif>();
		this.noeuds              = new ArrayList<Noeud>();
		this.aretes              = new ArrayList<Arete>();

		this.lireFichier("nomFichier");
	}

	public int[]               getTaillePlateau      () { return this.taillePlateau;       }
	public BufferedImage       getImagePlateau       () { return this.imagePlateau;        }
	public Color               getCouleurPlateau     () { return this.couleurPlateau;      }
	public Font                getPolicePlateau      () { return this.policePlateau;       }
	public int                 getNbJoueursMin       () { return this.nbJoueursMin;        }
	public int                 getNbJoueursMax       () { return this.nbJoueursMax;        }
	public int                 getNbCarteCoul        () { return this.nbCarteCoul;         }
	public int                 getNbCarteLocomotive  () { return this.nbCarteLocomotive;   }
	public BufferedImage       getImageCarte         () { return this.imageCarte;          }
	public List<Color>         getCouleurs           () { return this.couleurs;            }
	public List<CarteObjectif> getPiocheCarteObjectif() { return this.piocheCarteObjectif; }
	public List<Noeud>         getNoeuds             () { return this.noeuds;              }
	public List<Arete>         getAretes             () { return this.aretes;              }

	/*
	 * <?xml version="1.0" encoding="UTF-8"?>
<jeu>
	<information>
		<dimension x="500" y="300"/>
		<image-fond>image_encoder_en_base64</image-fond>
		<couleur-fond>0x000000</couleur-fond>
		<police taille="12">police</police>
		<nombre-joueurs min="2" max="10"/>
		<nombre-carte couleur="12" multicouleur="15"/>
		<image-carte>image_encoder_en_base64</image-carte>
	</information>
	<plateau>
		<liste-noeuds>
			<noeud id="1">
				<position x="100" y="100"/>
				<nom>noeud1</nom>
				<position-nom x="120" y="120"/>
				<couleur>0x0000FF</couleur>
			</noeud>
			<noeud id="2">
				<position x="300" y="100"/>
				<nom>noeud2</nom>
				<position-nom x="320" y="120"/>
				<couleur>0xFF0000</couleur>
			</noeud>
		</liste-noeuds>
		<liste-aretes>
			<arret>
				<noeud n1="1" n2="2"/>
				<couleur>0x00FF00</couleur>
				<distance>3</distance>
				<liste-troncons>
					<troncon>
						
					</troncon>
					<troncon>
						
					</troncon>
					<troncon>
						
					</troncon>
				</liste-troncons>
			</arret>
		</liste-aretes>
		<liste-objectifs>
			<objectif>
				<noeud n1="1" n2="2"/>
				<points>3</points>
			</objectif>
		</liste-objectifs>
	</plateau>
</jeu>
	 */

	private void lireFichier(String nomFichier)
	{
		File fichier = new File(nomFichier);
		Document document;
		try {
			document = new SAXBuilder().build(fichier);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		// lire information
		Element information = document.getRootElement().getChild("information");
		this.nbJoueursMax = Integer.parseInt(information.getChild("nombre-joueurs").getAttributeValue("max"));
		this.nbJoueursMin = Integer.parseInt(information.getChild("nombre-joueurs").getAttributeValue("min"));

		String image_carte_base64 = information.getChild("image-carte").getText();
		byte[] image_carte = Base64.getDecoder().decode(image_carte_base64);
		try {
			this.imageCarte = ImageIO.read(new ByteArrayInputStream(image_carte));
		} catch (IOException e) {
			this.imageCarte = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
			this.imageCarte.getGraphics().drawString("Image carte non trouvée", 20, 20);
		}

		String image_plateau_base64 = information.getChild("image-fond").getText();
		byte[] image_plateau = Base64.getDecoder().decode(image_plateau_base64);
		try {
			this.imagePlateau = ImageIO.read(new ByteArrayInputStream(image_plateau));
		} catch (IOException e) {
			this.imagePlateau = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
			this.imagePlateau.getGraphics().drawString("Image plateau non trouvée", 20, 20);
		}

		this.couleurPlateau = new Color(Integer.parseInt(information.getChild("couleur-fond").getText(), 16));
		String font_name = information.getChild("police").getText();
		int font_size = Integer.parseInt(information.getChild("police").getAttributeValue("taille"));
		this.policePlateau = new Font(font_name, Font.PLAIN, font_size);

		this.nbCarteCoul = Integer.parseInt(information.getChild("nombre-carte").getAttributeValue("couleur"));

	}
	private void genererFichier(String nomFichier)
	{
		SAXBuilder builder = new SAXBuilder();
		Document document = new Document();
		Element jeu = new Element("jeu");
		document.setRootElement(jeu);

		Element information = new Element("information");
		jeu.addContent(information);

		Element dimension = new Element("dimension");

		dimension.setAttribute("x", Integer.toString(this.imagePlateau.getWidth()));
		dimension.setAttribute("y", Integer.toString(this.imagePlateau.getHeight()));
		information.addContent(dimension);

		Element image_fond = new Element("image-fond");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(this.imagePlateau, "png", baos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] imageBytes = baos.toByteArray();
		String imageString = Base64.getEncoder().encodeToString(imageBytes);
		image_fond.setText(imageString);
		information.addContent(image_fond);

		Element couleur_fond = new Element("couleur-fond");
		couleur_fond.setText(Integer.toHexString(this.couleurPlateau.getRGB()).substring(2));
		information.addContent(couleur_fond);

		Element police = new Element("police");
		police.setText(this.policePlateau.getName());
		police.setAttribute("taille", Integer.toString(this.policePlateau.getSize()));
		information.addContent(police);

		Element image_carte = new Element("image-carte");
		baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(this.imageCarte, "png", baos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		imageBytes = baos.toByteArray();
		imageString = Base64.getEncoder().encodeToString(imageBytes);
		image_carte.setText(imageString);
		information.addContent(image_carte);

		Element nombre_carte = new Element("nombre-carte");
		nombre_carte.setAttribute("couleur", Integer.toString(this.nbCarteCoul));
		information.addContent(nombre_carte);

		Element nombre_joueurs = new Element("nombre-joueurs");
		nombre_joueurs.setAttribute("min", Integer.toString(this.nbJoueursMin));
		nombre_joueurs.setAttribute("max", Integer.toString(this.nbJoueursMax));
		information.addContent(nombre_joueurs);

		Element plateau = new Element("plateau");
		jeu.addContent(plateau);

		Element liste_objectifs = new Element("liste-objectifs");
		plateau.addContent(liste_objectifs);


		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		try {
			xmlOutput.output(document, new FileWriter(nomFichier));
		} catch (IOException e) {
			e.printStackTrace();
		}




	}
}
