package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controleur.Controleur;


public class MenuBarre extends JMenuBar implements ActionListener 
{
	private Controleur ctrl;

	private JMenuItem menuiFichierNouveau;
	private JMenuItem menuiFichierOuvrir;
	private JMenuItem menuiFichierEnregistrer;
	private JMenuItem menuiFichierEnregistrerSous;

	private JMenu menuiFichierExporter;
	private JMenuItem menuiFichierExporterGif;
	private JMenuItem menuiFichierExporterPng;
	private JMenuItem menuiFichierExporterJpeg;
	private JMenuItem menuiFichierExporterJpg;

	private JMenuItem menuiFichierQuitter;

	public MenuBarre(Controleur ctrl) 
	{
		this.ctrl = ctrl;
		this.setBackground(new Color(252, 160, 66));
		
		// Création des composants
		JMenu menuFichier = new JMenu("Fichier");
		menuFichier.setMnemonic('F');

		JMenu menuPreferences = new JMenu("Préférences");
		menuFichier.setMnemonic('P');

		JMenu menuAide = new JMenu("Aide");
		menuFichier.setMnemonic('A');

		this.menuiFichierNouveau = new JMenuItem("Nouveau");
		this.menuiFichierNouveau.setMnemonic('N');

		this.menuiFichierOuvrir = new JMenuItem("Ouvrir");
		this.menuiFichierOuvrir.setMnemonic('O');

		this.menuiFichierEnregistrer = new JMenuItem("Enregistrer");
		this.menuiFichierEnregistrer.setMnemonic('S');

		this.menuiFichierEnregistrerSous = new JMenuItem("Enregistrer Sous");
		this.menuiFichierEnregistrerSous.setMnemonic('S');

		this.menuiFichierExporter = new JMenu("Exporter");
		this.menuiFichierExporter.setMnemonic('E');

		this.menuiFichierExporterGif = new JMenu("gif");
		this.menuiFichierExporterPng = new JMenu("png");
		this.menuiFichierExporterJpeg = new JMenu("jpeg");
		this.menuiFichierExporterJpg = new JMenu("jpg");

		this.menuiFichierQuitter = new JMenuItem("Fermer");
		this.menuiFichierQuitter.setMnemonic('W');

		// Positionnement des composants
		menuFichier.add(this.menuiFichierNouveau);
		menuFichier.add(this.menuiFichierOuvrir);
		menuFichier.addSeparator();
		menuFichier.add(this.menuiFichierEnregistrer);
		menuFichier.add(this.menuiFichierEnregistrerSous);
		menuFichier.add(this.menuiFichierExporter);
		menuFichier.addSeparator();
		menuFichier.add(this.menuiFichierQuitter);
		this.add(menuFichier);

		this.add(menuPreferences);
		this.add(menuAide);

		// Intégration des raccourcis
		this.menuiFichierNouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK)); // pour CTRL+N
		
		this.menuiFichierOuvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK)); // pour CTRL+O
		
		this.menuiFichierEnregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK)); // pour CTRL+S
		
		this.menuiFichierEnregistrerSous.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK + 
			                                      InputEvent.SHIFT_DOWN_MASK )); // pour CTRL+SHIFT+S

		//this.menuiFichierExporter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK + InputEvent.SHIFT_DOWN_MASK )); // pour CTRL+SHIFT+E
		
		this.menuiFichierQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK)); // pour CTRL+W

		/*-------------------------------*/
		/* Activation des composants     */
		/*-------------------------------*/
		this.menuiFichierNouveau     .addActionListener(this);
		this.menuiFichierOuvrir      .addActionListener(this);
		this.menuiFichierEnregistrer    .addActionListener(this);
		this.menuiFichierEnregistrerSous    .addActionListener(this);
		this.menuiFichierExporter.addActionListener(this);
		this.menuiFichierExporterGif.addActionListener(this);
		this.menuiFichierExporterPng.addActionListener(this);
		this.menuiFichierExporterJpeg.addActionListener(this);
		this.menuiFichierExporterJpg.addActionListener(this);
		this.menuiFichierQuitter     .addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() instanceof JMenuItem) 
		{
			if (e.getSource() == this.menuiFichierNouveau) 
				this.ctrl.nouveau();

			if (e.getSource() == this.menuiFichierOuvrir) 
			{
				JFileChooser chooser = new JFileChooser(".");

				int res = chooser.showOpenDialog(this);
				if (res == JFileChooser.APPROVE_OPTION && chooser.getSelectedFile().getPath() != null)
					this.ctrl.ouvrir(new File(chooser.getSelectedFile().getPath()));
			}

			if (e.getSource() == this.menuiFichierEnregistrer) 
				this.ctrl.enregistrer();

			if (e.getSource() == this.menuiFichierEnregistrerSous) 
				this.ctrl.enregistrerSous();

			if (e.getSource() == this.menuiFichierExporter) 
				this.ctrl.exporterSous();

			if (e.getSource() == this.menuiFichierQuitter) 
				this.ctrl.frameDispose();
		}
	}
}