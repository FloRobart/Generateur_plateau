package metier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Arete 
{
	private Noeud noeud1;
	private Noeud noeud2;
	private int   distance;
	private Color couleur1;
	private Color couleur2;

	public Arete(Noeud noeud1, Noeud noeud2, int distance, Color c1, Color c2)
	{
		this.noeud1   = noeud1;
		this.noeud2   = noeud2;
		this.distance = distance;
		this.couleur1 = c1;
		this.couleur2 = c2;
	}

	public Noeud getNoeud1  () { return this.noeud1;   }
	public Noeud getNoeud2  () { return this.noeud2;   }
	public int   getDistance() { return this.distance; }
	public Color getCouleur1() { return this.couleur1; }
	public Color getCouleur2() { return this.couleur2; }

	public void setdistance(int distance) 
	{ 
		this.distance = distance; 
	}
	public void setCouleur1(Color c) 
	{ 
		this.couleur1 = c; 
	}
	public void setCouleur2(Color c) 
	{ 
		this.couleur2 = c; 
	}

	public void genererTroncon()
	{
		
	}

	public String toString()
	{
		return "Arete : " + this.noeud1 + " - " + this.noeud2 + " (" + this.distance + ")";
	}
}
