package ihm;

import java.awt.*;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import controleur.Controleur;


public class FramePlateau extends JFrame
{
	private Controleur ctrl;
	
	private PanelGenerateur panelGenerateur;
	private PanelJoueur panelJoueur;
	
	public FramePlateau(Controleur ctrl)
	{
		this.ctrl = ctrl;

		this.setTitle("Générateur de plateau");
		//récuperer la dimension de l'écran
		Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
		int longueurEcran = dimEcran.width * 9/10;
		int hauteurEcran = dimEcran.height * 9/10;
		//régler la taille de la fram à 9/10 de la taille de l'écran
		this.setSize(longueurEcran, hauteurEcran);
		this.setLocation(longueurEcran/18, hauteurEcran/18);
		this.setLayout(new BorderLayout());
		this.setJMenuBar(new MenuBarre(this.ctrl));

		this.panelJoueur = new PanelJoueur();
		this.panelGenerateur = new PanelGenerateur();


		// Positionnement du composent
		this.add(this.panelJoueur);
		this.add(this.panelGenerateur);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible ( true );
	}

	//Méthodes 

	public void enregistrer() 
	{
		String nomFichier;

		// Importation du panel en image
		/*Dimension     d     = this.panelPlateau.getSize();
		BufferedImage image = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
		Graphics2D    g2d   = image.createGraphics();
		this.panelPlateau.print(g2d);
		g2d.dispose();

		// Choix du nom du fichier
		nomFichier = JOptionPane.showInputDialog("Entrez le nom du fichier");

		// Création du répertoire export si il n'existe pas déjà
		if (nomFichier != null) 
		{
			File f1 = new File("export");

			if (!f1.exists())
				f1.mkdir();

			// Enregistrement du fichier dans le répertoire export
			try 
			{
				ImageIO.write(image, "png", new File("export\\" + nomFichier + ".png"));
				JOptionPane.showMessageDialog(this, "Exportation réussi dans le dossier export");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Erreur lors de l'exportation");
			}
		}*/
	}

	

	public void exporterSous() 
	{
		// Ouvrir le menu pour choisir un répertoire de sauvegarde
		JFileChooser choose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		String filePath = "";

		int res = choose.showSaveDialog(null);

		if (res == JFileChooser.APPROVE_OPTION) 
		{
			// Choix du nom du fichier
			File file = choose.getSelectedFile();
			filePath  = file.getAbsolutePath();

			// Importation du panel en image
			/*Dimension     d     = this.panelPlateau.getSize();
			BufferedImage image = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
			Graphics2D    g2d   = image.createGraphics();
			this.panelPlateau.print(g2d);
			g2d.dispose();*/

			// Enregistrement du fichier dans le répertoire choisi
			/*try 
			{
				ImageIO.write(image, "png", new File(filePath + ".png"));
				JOptionPane.showMessageDialog(this, "Exportation réussi");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Erreur lors de l'exportation");
			}*/
		}
	}
}
