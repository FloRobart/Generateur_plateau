public class ControleurGUI 
{
	private FramePlateau ihm;
	private Plateau  metier;

	public ControleurGUI()
	{
		this.ihm     = new FramePlateau(this);
		this.metier  = null;
	}

	public void creerMetier(int nbCuves)
	{
		this.metier = new Plateau();
	}

	//modificateurs


	//methodes


	public void genererTxt(String type, String nomFichier)
	{
		
		this.ihm.dispose();
	}

	//accesseurs

	public static void main(String[] args) { new ControleurGUI(); }   
}