package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import controleur.Controleur;


public class MenuBarre extends JMenuBar implements ActionListener 
{
	private Controleur ctrl;

	private JMenuItem menuiFichierNouveau;
	private JMenuItem menuiFichierOuvrir;
	private JMenuItem menuiFichierEnregistrer;
	private JMenuItem menuiFichierEnregistrerSous;

	private JMenuItem menuiFichierExporterSousGif;
	private JMenuItem menuiFichierExporterSousPng;
	private JMenuItem menuiFichierExporterSousJpeg;
	private JMenuItem menuiFichierExporterSousJpg;

	private JMenuItem menuiFichierFermer;

	private JMenuItem menuiPreferencesThemes;
	private JMenuItem menuiPreferencesThemesClair;
	private JMenuItem menuiPreferencesThemesSombre;

	public MenuBarre(Controleur ctrl) 
	{
		this.ctrl = ctrl;
		Color foregroundColor = this.ctrl.getTheme().get("menuBar").get(0);
		Color backgroundColor = this.ctrl.getTheme().get("menuBar").get(1);
		this.setBackground(backgroundColor);
		this.setForeground(foregroundColor);


		/*=========================*/
		/* Création des composants */
		/*=========================*/
		/*---------*/
		/* Fichier */
		/*---------*/
		JMenu menuFichier = new JMenu("Fichier");
		menuFichier.setMnemonic('F');
		menuFichier.setForeground(foregroundColor);
		menuFichier.setBackground(backgroundColor);

		/* Nouveau */
		this.menuiFichierNouveau = new JMenuItem("Nouveau");
		this.menuiFichierNouveau.setMnemonic('N');
		this.menuiFichierNouveau.setBackground(backgroundColor);
		this.menuiFichierNouveau.setForeground(foregroundColor);

		/* Ouvrir */
		this.menuiFichierOuvrir = new JMenuItem("Ouvrir");
		this.menuiFichierOuvrir.setMnemonic('O');
		this.menuiFichierOuvrir.setBackground(backgroundColor);
		this.menuiFichierOuvrir.setForeground(foregroundColor);

		/* Enregistrer */
		this.menuiFichierEnregistrer = new JMenuItem("Enregistrer");
		this.menuiFichierEnregistrer.setMnemonic('S');
		this.menuiFichierEnregistrer.setBackground(backgroundColor);
		this.menuiFichierEnregistrer.setForeground(foregroundColor);

		/* Enregistrer sous */
		this.menuiFichierEnregistrerSous = new JMenuItem("Enregistrer Sous");
		this.menuiFichierEnregistrerSous.setMnemonic('S');
		this.menuiFichierEnregistrerSous.setBackground(backgroundColor);
		this.menuiFichierEnregistrerSous.setForeground(foregroundColor);

		/* Exporter */
		JMenu menuExporterSous = new JMenu("Exporter");
		menuExporterSous.setOpaque(true);
		menuExporterSous.setMnemonic('E');
		menuExporterSous.setBackground(backgroundColor);
		menuExporterSous.setForeground(foregroundColor);


		this.menuiFichierExporterSousGif  = new JMenuItem("gif");
		this.menuiFichierExporterSousGif.setBackground(backgroundColor);
		this.menuiFichierExporterSousGif.setForeground(foregroundColor);

		this.menuiFichierExporterSousPng  = new JMenuItem("png");
		this.menuiFichierExporterSousPng.setBackground(backgroundColor);
		this.menuiFichierExporterSousPng.setForeground(foregroundColor);

		this.menuiFichierExporterSousJpeg = new JMenuItem("jpeg");
		this.menuiFichierExporterSousJpeg.setBackground(backgroundColor);
		this.menuiFichierExporterSousJpeg.setForeground(foregroundColor);

		this.menuiFichierExporterSousJpg  = new JMenuItem("jpg");
		this.menuiFichierExporterSousJpg.setBackground(backgroundColor);
		this.menuiFichierExporterSousJpg.setForeground(foregroundColor);

		/* Fermer */
		this.menuiFichierFermer = new JMenuItem("Fermer");
		this.menuiFichierFermer.setMnemonic('W');
		this.menuiFichierFermer.setBackground(backgroundColor);
		this.menuiFichierFermer.setForeground(foregroundColor);

		/*------------*/
		/* Préférence */
		/*------------*/
		JMenu menuPreferences = new JMenu("Préférences");
		menuPreferences.setMnemonic('P');
		menuPreferences.setForeground(foregroundColor);
		menuPreferences.setBackground(backgroundColor);

		this.menuiPreferencesThemes       = new JMenu    ("Thèmes ");
		this.menuiPreferencesThemes      .setOpaque(true);
		this.menuiPreferencesThemes      .setForeground(foregroundColor);
		this.menuiPreferencesThemes      .setBackground(backgroundColor);

		this.menuiPreferencesThemesClair  = new JMenuItem("Clair" );
		this.menuiPreferencesThemesClair .setForeground(foregroundColor);
		this.menuiPreferencesThemesClair .setBackground(backgroundColor);

		this.menuiPreferencesThemesSombre = new JMenuItem("Sombre");
		this.menuiPreferencesThemesSombre.setForeground(foregroundColor);
		this.menuiPreferencesThemesSombre.setBackground(backgroundColor);

		/*------*/
		/* Aide */
		/*------*/
		JMenu menuAide = new JMenu("Aide");
		menuAide.setMnemonic('A');
		menuAide.setForeground(foregroundColor);
		menuAide.setBackground(backgroundColor);



		/*===============================*/
		/* Positionnement des composants */
		/*===============================*/
		/* Fichier */
		menuFichier     .add(this.menuiFichierNouveau);
		menuFichier     .add(this.menuiFichierOuvrir);
		menuFichier     .addSeparator();
		menuFichier     .add(this.menuiFichierEnregistrer);
		menuFichier     .add(this.menuiFichierEnregistrerSous);
		menuExporterSous.add(this.menuiFichierExporterSousGif);
		menuExporterSous.add(this.menuiFichierExporterSousPng);
		menuExporterSous.add(this.menuiFichierExporterSousJpg);
		menuExporterSous.add(this.menuiFichierExporterSousJpeg);
		menuFichier     .add(menuExporterSous);
		menuFichier     .addSeparator();
		menuFichier     .add(this.menuiFichierFermer);
		this.add(menuFichier);

		/* Préférence */
		this.menuiPreferencesThemes.add(this.menuiPreferencesThemesClair);
		this.menuiPreferencesThemes.add(this.menuiPreferencesThemesSombre);
		menuPreferences.add(this.menuiPreferencesThemes);
		this.add(menuPreferences);

		/* Aide */
		this.add(menuAide);

		// Intégration des raccourcis
		this.menuiFichierNouveau        .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK)); // pour CTRL+N
		this.menuiFichierOuvrir         .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK)); // pour CTRL+O
		this.menuiFichierEnregistrer    .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK)); // pour CTRL+S
		this.menuiFichierEnregistrerSous.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK + InputEvent.SHIFT_DOWN_MASK )); // pour CTRL+SHIFT+S
		this.menuiFichierFermer         .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK)); // pour CTRL+W
		//menuExporterSous.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK + InputEvent.SHIFT_DOWN_MASK )); // pour CTRL+SHIFT+E


		/*============================*/
		/* Activations des composants */
		/*============================*/
		this.menuiFichierNouveau         .addActionListener(this);
		this.menuiFichierOuvrir          .addActionListener(this);
		this.menuiFichierEnregistrer     .addActionListener(this);
		this.menuiFichierEnregistrerSous .addActionListener(this);
		menuExporterSous                 .addActionListener(this);
		this.menuiFichierExporterSousGif .addActionListener(this);
		this.menuiFichierExporterSousPng .addActionListener(this);
		this.menuiFichierExporterSousJpeg.addActionListener(this);
		this.menuiFichierExporterSousJpg .addActionListener(this);
		this.menuiFichierFermer          .addActionListener(this);
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
				chooser.setFileFilter(new FileNameExtensionFilter("Fichier XML", "xml"));

				int res = chooser.showOpenDialog(this);
				if (res == JFileChooser.APPROVE_OPTION && chooser.getSelectedFile().getPath() != null)
				{
					File fichier = chooser.getSelectedFile();
					String extention = fichier.getName().substring(fichier.getName().lastIndexOf('.') + 1);

					if (extention.equals("xml"))
						this.ctrl.ouvrir(fichier);
					else
						JOptionPane.showMessageDialog(this, "Le fichier choisi doit-être au format XML", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
					
			}

			if (e.getSource() == this.menuiFichierEnregistrer) 
				this.ctrl.enregistrer();

			if (e.getSource() == this.menuiFichierEnregistrerSous) 
				this.ctrl.enregistrerSous();

			if (e.getSource() == this.menuiFichierExporterSousGif)
				this.ctrl.exporterSous("gif");

			if (e.getSource() == this.menuiFichierExporterSousPng) 
				this.ctrl.exporterSous("png");

			if (e.getSource() == this.menuiFichierExporterSousJpeg)
				this.ctrl.exporterSous("jpeg");

			if (e.getSource() == this.menuiFichierExporterSousJpg) 
				this.ctrl.exporterSous("jpg");

			if (e.getSource() == this.menuiFichierFermer) 
				this.ctrl.frameDispose();

			if (e.getSource() == this.menuiPreferencesThemesClair)
				this.ctrl.changerTheme("clair");
			
			if (e.getSource() == this.menuiPreferencesThemesSombre)
				this.ctrl.changerTheme("sombre");
		}
	}
}