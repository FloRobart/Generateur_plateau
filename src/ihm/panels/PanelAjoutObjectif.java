package ihm.panels;

import java.awt.Color;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Toolkit;
import java.util.List;

import controleur.Controleur;
import ihm.customComponent.TextFieldWithHint;
import metier.CarteObjectif;
import metier.Noeud;

public class PanelAjoutObjectif extends JPanel
{
    private Controleur ctrl;
    
    private JComboBox<String> cbA;
    private JComboBox<String> cbB;
    private TextFieldWithHint txtPoint;
    private JButton           btnAjout;

    private List<Noeud>         lstNoeudA;
    private List<Noeud>         lstNoeudB;

    private JButton             btnRecto;
    private JButton             btnVerso;

    private BufferedImage               imgRecto;
    private BufferedImage               imgVerso;


    public PanelAjoutObjectif(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setBackground(new Color(68, 71, 90));
        this.setLayout(new BorderLayout());

        
        /*Panel info objectifs */
        JPanel panelInfos = new JPanel();
        panelInfos.setBackground(new Color(68, 71, 90));

        GroupLayout layout = new GroupLayout(panelInfos);
        panelInfos.setLayout(layout);

        JLabel lblNoeudA, lblNoeudB, lblPoint, lblRecto, lblVerso;
        lblNoeudA = new JLabel("Noeud A");
        lblNoeudA.setForeground(Color.WHITE);
        lblNoeudB = new JLabel("Noeud B");
        lblNoeudB.setForeground(Color.WHITE);
        lblPoint = new JLabel("Point");
        lblPoint.setForeground(Color.WHITE);
        lblRecto = new JLabel("Recto");
        lblRecto.setForeground(Color.WHITE);
        lblVerso = new JLabel("Verso");
        lblVerso.setForeground(Color.WHITE);

       
        this.txtPoint = new TextFieldWithHint("Point", ctrl);
        this.txtPoint.setBackground(new Color(58, 60, 76));
        this.txtPoint.setForeground(Color.GRAY);

        this.txtPoint.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
               if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE ) {
                  txtPoint.setEditable(true);
               }else
               {
                  txtPoint.setEditable(false);
               }
               
            }
         });

        this.lstNoeudA = this.ctrl.getMetier().getNoeuds();
        this.lstNoeudB = this.ctrl.getMetier().getNoeuds();

        String[] tabNoeudA = new String[lstNoeudA.size()];
        String[] tabNoeudB = new String[lstNoeudB.size()];

        for(int cpt =0; cpt < lstNoeudA.size(); cpt++)
        {
            tabNoeudA[cpt] = lstNoeudA.get(cpt).getNom();
            tabNoeudB[cpt] = lstNoeudB.get(cpt).getNom();
        }

        cbA = new JComboBox<String>(tabNoeudA);
        cbB = new JComboBox<String>(tabNoeudB);

        cbA.setVisible(true);
        cbB.setVisible(true);

        /*Image Recto */
        this.imgRecto = null;
        this.btnRecto = new JButton("image");
        this.btnRecto.setBackground(new Color(58, 60, 76));
        this.btnRecto.setForeground(Color.WHITE);
        this.btnRecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String path = "";
                JFileChooser chooser = new JFileChooser("./donnees/images");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF, PNG", "jpg", "gif", "png", "jpeg");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) 
                {
                    File file = chooser.getSelectedFile();
                    path = file.getAbsolutePath();
                    try
                    {
                        imgRecto = ImageIO.read(new File(path));
                    } catch (IOException e1) {e1.printStackTrace();}
                }
            }
        });

        /*Image Verso */
        this.btnVerso = new JButton("image");
        this.btnVerso.setBackground(new Color(58, 60, 76));
        this.btnVerso.setForeground(Color.WHITE);
        this.btnVerso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String path = "";
                JFileChooser chooser = new JFileChooser("./donnees/images");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF, PNG", "jpg", "gif", "png");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    path = file.getAbsolutePath();
                    try
                    {
                        imgVerso = ImageIO.read(new File(path));
                    } catch (IOException e1) {e1.printStackTrace();}
                }
            }
        });


        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup().
                addComponent(lblNoeudA).addComponent(lblNoeudB).addComponent(lblPoint).addComponent(lblRecto).addComponent(lblVerso));
        
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(cbA).addComponent(cbB).addComponent(txtPoint).addComponent(btnRecto).addComponent(btnVerso));

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblNoeudA).addComponent(cbA));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblNoeudB).addComponent(cbB));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblPoint).addComponent(txtPoint));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblRecto).addComponent(btnRecto));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblVerso).addComponent(btnVerso));

        layout.setVerticalGroup(vGroup);

        /*Panel boutons */
        JPanel panelBoutons = new JPanel();
        panelBoutons.setBackground(new Color(68, 71, 90));

        this.btnAjout = new JButton("Ajouter");
        this.btnAjout.setBackground(new Color(58, 60, 76));
        this.btnAjout.setForeground(Color.WHITE);
        this.btnAjout.addActionListener(e -> {
            ajouterObjectif();
        });

        panelBoutons.add(this.btnAjout);

        /*Panel global */
        this.add(panelInfos, BorderLayout.CENTER);
        this.add(panelBoutons, BorderLayout.SOUTH);

    }

    /**
     * Ajoute un objectif à la liste
     */
    private void ajouterObjectif()
    {
        boolean erreur = false;
        String nom1    = "";
        String nom2    = "";
        int    point   = 0;
        BufferedImage  recto   = null;
        BufferedImage  verso   = null;

        //test noeud
        if(this.cbA.getSelectedIndex() == this.cbB.getSelectedIndex())
        {
            this.cbA.setBackground(Color.RED);
            this.cbB.setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner deux noeuds différents", "Erreur", JOptionPane.ERROR_MESSAGE);
            erreur = true;
        }
        else
        {
            nom1 = this.cbA.getSelectedItem().toString();
            nom2 = this.cbB.getSelectedItem().toString();
            this.cbA.setBackground(Color.WHITE);
            this.cbB.setBackground(Color.WHITE);
        }
        
        //test point
        try
        {
            point = Integer.parseInt(this.txtPoint.getText());
            this.txtPoint.setBackground(new Color(58, 60, 76));
        }
        catch(NumberFormatException e)
        {
            this.txtPoint.setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "Veuillez saisir un nombre entier de point", "Erreur", JOptionPane.ERROR_MESSAGE);
            erreur = true;
        }

        //test image
        try
        {
            recto = this.imgRecto;
            verso = this.imgVerso;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une image", "Erreur", JOptionPane.ERROR_MESSAGE);
            erreur = true;
        }

        
        if(!erreur)
        {
            this.ctrl.ajouterObjectif(nom1, nom2, point, recto, verso);
            this.effacerForm();
        }
    }

    /**
     * Efface le formulaire suite à l'ajout ou la suppression d'un objectif
     */
    private void effacerForm() 
    {
        this.cbA.setSelectedIndex(0);
        this.cbB.setSelectedIndex(0);
        this.txtPoint.setText("");
        this.imgRecto = null;
        this.imgVerso = null;
    }


}
