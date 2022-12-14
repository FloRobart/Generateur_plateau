package ihm;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.filechooser.FileSystemView;

import controleur.Controleur;


public class FramePlateau extends JFrame
{
	private Controleur ctrl;
	
	private PanelGenerateurTest panelGenerateur;
	private PanelPlateau panelPlateau;

	private FrameCouleur  frameCouleur;
	private FrameObjectif frameObjectif;

	public FramePlateau(Controleur ctrl)
	{
		this.ctrl = ctrl;

		Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int longueurEcran = dimEcran.width * 9/10;
        int hauteurEcran = dimEcran.height * 9/10;

		this.setTitle("Générateur de plateau");
		this.setLocation(50, 50);
		this.setSize(longueurEcran, hauteurEcran);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(new MenuBarre(this.ctrl));
	
        try {
            BufferedImage img = ImageIO.read(new File("./donnees/images/les_aventuriers_du_rail.jpg"));
            this.panelPlateau = new PanelPlateau(this.ctrl, img, longueurEcran, hauteurEcran);
        }
        catch (Exception e) {e.printStackTrace();}

		JPanel panel = new JPanel();
        panel.setSize(longueurEcran*1/2,hauteurEcran*1/2);
		panel.setLayout(new GridLayout(1,1));
        panel.add(this.panelPlateau);

		this.panelGenerateur = new PanelGenerateurTest(this.ctrl);

		//Create a split pane with the two scroll panes in it.
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelGenerateur, panel);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);

		//Provide minimum sizes for the two components in the split pane
		Dimension minimumSize = new Dimension(longueurEcran*1/6,hauteurEcran);
		panel.setMinimumSize(minimumSize);
		panelGenerateur.setMinimumSize(minimumSize);

		/*frames modif */
		this.frameCouleur = new FrameCouleur(this.ctrl);
		this.frameObjectif = new FrameObjectif(this.ctrl);

		this.add(splitPane);
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

	public void setCouleur(Color color) {
		this.panelPlateau.setBackground(color);
	}

	public void afficher(String frame) 
	{
		switch (frame) 
		{
			case "couleur":
				this.frameCouleur.setVisible(true);
				break;
			case "objectif":
				this.frameObjectif.setVisible(true);
				break;
			
			default:
				break;
		}
	}
}
