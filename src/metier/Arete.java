package metier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Arete 
{
	private Noeud         noeud1;
	private Noeud         noeud2;
	private int           distance;
	private Color         couleur;
	private List<Troncon> troncons;

	public Arete(Noeud noeud1, Noeud noeud2, int distance, Color c)
	{
		this.noeud1   = noeud1;
		this.noeud2   = noeud2;
		this.distance = distance;
		this.couleur  = c;
		this.troncons = new ArrayList<Troncon>();
	}

	public Noeud         getNoeud1  () { return this.noeud1;   }
	public Noeud         getNoeud2  () { return this.noeud2;   }
	public int           getDistance() { return this.distance; }
	public Color         getCouleur () { return this.couleur;  }
	public List<Troncon> getTroncons() { return this.troncons; }

	public void setdistance(int distance) 
	{ 
		this.distance = distance; 
	}
	public void setCouleur(Color c) 
	{ 
		this.couleur = c; 
	}

	public void genererTroncon()
	{
		
	}
}
