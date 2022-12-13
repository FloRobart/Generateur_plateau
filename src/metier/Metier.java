import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

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

	private void lireFichier(String nomFichier)
	{
		// TODO
	}
}
