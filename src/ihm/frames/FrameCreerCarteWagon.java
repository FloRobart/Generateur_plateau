package ihm.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.Controleur;

public class FrameCreerCarteWagon extends JFrame implements ActionListener
{
    private Controleur ctrl;

    private JPanel panelParametrageCarte;
    private JPanel panelVisualisationCarte;
    private JPanel panelVisualisation;
    private JPanel panelActionCarte;

    private JList<String> lstCarte;
    private ArrayList<String> alCartes;

    private JButton btnEnregistrer;
    private JButton btnSupprimer;
    private JButton btnQuitter;

    private JButton btnVerso;
    private JButton btnLocomotive;
    private JButton btnChoisirImage;

    private JLabel lblCarteWagon;

    private Dimension dimEcran;

    public FrameCreerCarteWagon(Controleur ctrl)
    {
        this.ctrl = ctrl;

        //Paramètres de la frame
        this.setTitle("Concepteur de cartes wagon");
        this.dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(0, 0);
        this.setSize(dimEcran.width, dimEcran.height); // Définition d'une taille minimum (obligatoire)
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Ouvre la fenêtre en pleine écran
        this.setLayout( new BorderLayout());

        //Creation des composants
        this.lstCarte = new JList<String>();
        this.panelParametrageCarte = new JPanel();
        this.panelParametrageCarte.setLayout(new GridLayout(2,1));

        this.panelVisualisation = new JPanel();

        this.panelVisualisationCarte = new JPanel();
        this.lblCarteWagon = new JLabel("");

        this.panelActionCarte = new JPanel();

        this.ctrl.setImageVersoCouleur(null);
        this.ctrl.setImageRectoLocomotive(null);

        this.alCartes = new ArrayList<String>();
        for(Color c : this.ctrl.getCouleurs())
            this.alCartes.add("Carte " + c.getRGB());

        this.alCartes.add("Verso");
        this.alCartes.add("Locomotive");

        this.lstCarte.setModel(new AbstractListModel<String>()
        {
            public int getSize() { return alCartes.size(); }
            public String getElementAt(int i) { return alCartes.get(i); }
        });
        this.lstCarte.setPreferredSize(new Dimension(60, 40));
        //
        this.lstCarte.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
				String carteSelected = lstCarte.getSelectedValue();

				if (carteSelected == null ) 
					carteSelected = lstCarte.get(0);
				
				if (carteSelected != null)
				{
					List<Color> lstColor = ctrl.getCouleurs();

					estUneMaj = true;
        			comboBoxListNoeudA.setSelectedIndex(lstNoeuds.indexOf(areteSelected.getNoeud1()));
        			comboBoxListNoeudB.setSelectedIndex(lstNoeuds.indexOf(areteSelected.getNoeud2()));
					estUneMaj = false;


					txtDistance.setText("" + areteSelected.getDistance());
					btnCouleur1.setBackground(areteSelected.getCouleur1());

					if (carteSelected.getCouleur2() != null)
					{
						cb2Sens.setSelected(true);
						btnCouleur2.setBackground(carteSelected.getCouleur2());
					}
					else
					{
						cb2Sens.setSelected(false);
						btnCouleur2.setBackground(null);
					}
				}
				else
				{
					effacerForm();
				}
			}
		});
        //
        this.btnEnregistrer   = new JButton("Enregistrer");
        this.btnSupprimer = new JButton("Supprimer");
        this.btnQuitter   = new JButton("Quitter");

        this.btnVerso          = new JButton("Carte verso");
        this.btnLocomotive     = new JButton("Carte Locomotive");
        this.btnChoisirImage   = new JButton("Choisissez l'image de la carte");

        //Ajout des composants au ActionListener
        this.lstCarte.addActionListener(this);

        this.btnEnregistrer.addActionListener(this);
        this.btnSupprimer.addActionListener(this);
        this.btnQuitter.addActionListener(this);

        this.btnVerso.addActionListener(this);
        this.btnLocomotive.addActionListener(this);
        this.btnChoisirImage.addActionListener(this);

        //Ajout des composants
        this.panelVisualisation.add(this.panelVisualisationCarte);

        this.panelVisualisationCarte.add(this.lblCarteWagon);

        this.panelParametrageCarte.add(this.lstCarte);
        this.panelParametrageCarte.add(this.btnChoisirImage);

        this.panelActionCarte.add(this.btnVerso);
        this.panelActionCarte.add(this.btnLocomotive);
        this.panelActionCarte.add(this.btnEnregistrer, BorderLayout.SOUTH);
        this.panelActionCarte.add(this.btnSupprimer, BorderLayout.SOUTH);
        this.panelActionCarte.add(this.btnQuitter, BorderLayout.SOUTH);

        this.add(this.panelParametrageCarte, BorderLayout.WEST);
        this.add(this.panelVisualisation, BorderLayout.CENTER);
        this.add(this.panelActionCarte, BorderLayout.SOUTH);

        this.appliquerTheme();
        this.setVisible(true);
    }

    //Action performed//*
    public void actionPerformed(ActionEvent e) 
    {
        if ( e.getSource() == lstCarte )
        {
            this.panelVisualisationCarte.setBackground(this.ctrl.getCouleurs().get(this.lstCarte.getSelectedIndex()));
            BufferedImage img = null;
            if ( this.lstCarte.getSelectedIndex() == this.alCartes.size()-2 )
                img = this.ctrl.getImageVersoCouleur();

            if ( this.lstCarte.getSelectedIndex() == this.alCartes.size()-1 )
                img = this.ctrl.getImageRectoLocomotive();

            if ( this.lstCarte.getSelectedIndex() != 0 && this.lstCarte.getSelectedIndex() != 1 )
                img = this.ctrl.getImagesRectoCouleur().get(this.lstCarte.getSelectedIndex());
            
            this.panelVisualisationCarte.setBackground(this.ctrl.getCouleurs().get(this.lstCarte.getSelectedIndex()));
            this.lblCarteWagon.setIcon(new ImageIcon(img));
            this.panelVisualisationCarte.setSize(img.getWidth(), img.getHeight());
            this.panelVisualisationCarte.setBackground(this.ctrl.getCouleurs().get(this.lstCarte.getSelectedIndex()));
        }

        if ( e.getSource() == btnEnregistrer )
        {
            // Importation du panel en image
            Dimension     d     = new Dimension (this.panelVisualisationCarte.getWidth(),this.panelVisualisationCarte.getHeight());
            BufferedImage image = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D    g2d   = image.createGraphics();
            this.panelVisualisationCarte.print(g2d);
            g2d.dispose();

            if ( this.lstCarte.getSelectedIndex() == this.alCartes.size()-2 )
                this.ctrl.setImageVersoCouleur(image);

            else if ( this.lstCarte.getSelectedIndex() == this.alCartes.size()-1 )
                this.ctrl.setImageRectoLocomotive(image);

            else
                this.ctrl.setImageRectoCouleur(this.lstCarte.getSelectedIndex(), image);
        }

        if ( e.getSource() == this.btnSupprimer )
        {
            //Supprime la carte de la liste
            this.lstCarte.remove(this.lstCarte.getSelectedIndex());
            if ( this.lstCarte.getSelectedIndex() == this.alCartes.size()-2 )
                this.ctrl.supprimerImageVersoCouleur();

            if (this.lstCarte.getSelectedIndex() == this.alCartes.size()-1 )
                this.ctrl.supprimerImageRectoLocomotive();

            else
                this.ctrl.supprimerImageRectoCouleur(this.lstCarte.getSelectedIndex());

        }

        if ( e.getSource() == this.btnQuitter )  { this.dispose(); }

        if ( e.getSource() == this.btnChoisirImage )
        {
            String filePath = "";
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png", "jpeg");
            fileChooser.setFileFilter(filter);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION)
            {
                File file = fileChooser.getSelectedFile();
                filePath  = file.getAbsolutePath();
                BufferedImage img;
                try 
                {
                    img = ImageIO.read(new File(filePath));
                    if ( img.getWidth() > 500 ||  img.getHeight() > 500 )
                    {
                        Image image = img.getScaledInstance((int) this.dimEcran.getWidth()* 9/10, (int)this.dimEcran.getHeight()* 9/10, Image.SCALE_DEFAULT);
                        this.lblCarteWagon.setIcon(new ImageIcon(image));
                        this.panelVisualisationCarte.setSize(image.getWidth(fileChooser), image.getHeight(fileChooser));
                    }
                    else if ( img.getWidth() < 100 ||  img.getHeight() < 100 )
                    {
                        Image image = img.getScaledInstance((int) this.dimEcran.getWidth()* 3/10, (int)this.dimEcran.getHeight()* 3/10, Image.SCALE_DEFAULT);
                        this.lblCarteWagon.setIcon(new ImageIcon(image));
                        this.panelVisualisationCarte.setSize(image.getWidth(fileChooser), image.getHeight(fileChooser));
                    }
                    else
                    {
                        this.lblCarteWagon.setIcon(new ImageIcon(img));
                        this.panelVisualisationCarte.setSize(img.getWidth(), img.getHeight());
                    }
                } catch (IOException ex) {ex.printStackTrace();}
            }

            Dimension     d     = new Dimension (this.panelVisualisationCarte.getWidth(),this.panelVisualisationCarte.getHeight());
            BufferedImage image = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D    g2d   = image.createGraphics();
            this.panelVisualisationCarte.print(g2d);
            g2d.dispose();
        }

        if ( e.getSource() == this.btnVerso )
        {  
            Dimension     d     = new Dimension (this.panelVisualisationCarte.getWidth(),this.panelVisualisationCarte.getHeight());
            BufferedImage image = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D    g2d   = image.createGraphics();
            this.panelVisualisationCarte.print(g2d);
            g2d.dispose();

            this.ctrl.setImageVersoCouleur(image);
        }

        if ( e.getSource() == this.btnLocomotive )
        {  
            Dimension     d     = new Dimension (this.panelVisualisationCarte.getWidth(),this.panelVisualisationCarte.getHeight());
            BufferedImage image = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D    g2d   = image.createGraphics();
            this.panelVisualisationCarte.print(g2d);
            g2d.dispose();

            this.ctrl.setImageRectoLocomotive(image);
        }
    }


    public void appliquerTheme()
    {
		Color background       = this.ctrl.getTheme().get("background").get(0);
        Color labelForeColor   = this.ctrl.getTheme().get("labels"    ).get(0);
		Color labelBackColor   = this.ctrl.getTheme().get("labels"    ).get(1);
        Color saisiForeColor   = this.ctrl.getTheme().get("saisies"   ).get(0);
        Color btnForeColor     = this.ctrl.getTheme().get("bottuns"   ).get(0);
		Color btnBackColor     = this.ctrl.getTheme().get("bottuns"   ).get(1);


        this.setForeground(labelForeColor);
        this.setBackground(background);

        this.panelParametrageCarte.setForeground(labelForeColor);
        this.panelParametrageCarte.setBackground(background);

        this.panelActionCarte.setForeground(labelForeColor);
        this.panelActionCarte.setBackground(background);

        this.lstCarte.setForeground(saisiForeColor);
        this.lstCarte.setBackground(background);

        this.btnEnregistrer.setForeground(btnForeColor);
        this.btnEnregistrer.setBackground(btnBackColor);

        this.btnSupprimer.setForeground(btnForeColor);
        this.btnSupprimer.setBackground(btnBackColor);

        this.btnQuitter.setForeground(btnForeColor);
        this.btnQuitter.setBackground(btnBackColor);

        this.btnVerso.setForeground(btnForeColor);
        this.btnVerso.setBackground(btnBackColor);

        this.btnLocomotive.setForeground(btnForeColor);
        this.btnLocomotive.setBackground(btnBackColor);

        this.btnChoisirImage.setForeground(btnForeColor);
        this.btnChoisirImage.setBackground(btnBackColor);

        //this.lblCarteWagon.setForeground(labelForeColor);
        //this.lblCarteWagon.setBackground(labelBackColor);
    }
}