package ihm.panels;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import java.awt.BorderLayout;
import controleur.Controleur;
import ihm.customComponent.TextFieldOnlyInteger;
import ihm.customComponent.TextFieldWithHint;
import metier.Noeud;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class PanelNoeud extends JPanel
{
    private Controleur ctrl;

	private JTextField           txtNom;
    private TextFieldOnlyInteger txtPosX;
    private TextFieldOnlyInteger txtPosY;
    private TextFieldOnlyInteger txtPosNomX;
    private TextFieldOnlyInteger txtPosNomY;
    private JButton              btnCouleur;
    private JButton              btnAjouter;

    private Color      couleur;

    public PanelNoeud(Controleur ctrl) 
    {
        this.ctrl = ctrl;
        this.setBackground(new Color(68, 71, 90));
        this.setLayout(new BorderLayout());

        /*Panel liste villes */
        JPanel panelListe = new JPanel();
        panelListe.setBackground(new Color(68, 71, 90));        
        
        /*Panel infos villes */
        JPanel panelInfos = new JPanel();
        panelInfos.setBackground(new Color(68, 71, 90));
        
        GroupLayout layout = new GroupLayout(panelInfos);
        panelInfos.setLayout(layout);

		this.txtNom = new TextFieldWithHint("Nouveau Noeud",ctrl);
        this.txtNom.setBackground(new Color(58, 60, 76));
		this.txtNom.setForeground(Color.WHITE);

        this.txtPosX = new TextFieldOnlyInteger("X",this.ctrl);
        this.txtPosX.setBackground(new Color(58, 60, 76));
        this.txtPosX.setForeground(Color.GRAY);



        this.txtPosY = new TextFieldOnlyInteger("Y",this.ctrl);
        this.txtPosY.setBackground(new Color(58, 60, 76));
        this.txtPosY.setForeground(Color.GRAY);

        this.txtPosNomX = new TextFieldOnlyInteger("PosNomX",this.ctrl);
        this.txtPosNomX.setBackground(new Color(58, 60, 76));
        this.txtPosNomX.setForeground(Color.GRAY);



        this.txtPosNomY = new TextFieldOnlyInteger("PosNomY",this.ctrl);
        this.txtPosNomY.setBackground(new Color(58, 60, 76));
        this.txtPosNomY.setForeground(Color.GRAY);


        this.btnCouleur = new JButton("Couleur");
        this.btnCouleur.setBackground(null);
        add(this.btnCouleur);
        this.btnCouleur.addActionListener(e -> {
            selectColor();
        });

        JLabel labelPos, labelNom, labelPosNom, labelCouleur;
        labelPos = new JLabel("Position");
        labelPos.setForeground(Color.WHITE);
        labelNom = new JLabel("Nom");
        labelNom.setForeground(Color.WHITE);
        labelPosNom = new JLabel("Position Nom");
        labelPosNom.setForeground(Color.WHITE);
        labelCouleur = new JLabel("Couleur");
        labelCouleur.setForeground(Color.WHITE);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup().
            addComponent(labelNom).addComponent(labelPos).addComponent(labelPosNom).addComponent(labelCouleur));

        hGroup.addGroup(layout.createParallelGroup().
            addComponent(txtNom).addComponent(txtPosX).addComponent(txtPosNomX).addComponent(btnCouleur));
        
        hGroup.addGroup(layout.createParallelGroup().addComponent(txtNom).
            addComponent(txtPosY).addComponent(txtPosNomY));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(labelNom).addComponent(txtNom));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(labelPos).addComponent(txtPosX).addComponent(txtPosY));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(labelPosNom).addComponent(txtPosNomX).addComponent(txtPosNomY));
        
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(labelCouleur).addComponent(btnCouleur));
        
        layout.setVerticalGroup(vGroup);

        /*Panel boutons */
        JPanel panelBoutons = new JPanel();
        panelBoutons.setBackground(new Color(68, 71, 90));
        
        this.btnAjouter = new JButton("Ajouter");
        this.btnAjouter.setBackground(new Color(58, 60, 76));
        this.btnAjouter.setForeground(Color.WHITE);
        this.btnAjouter.addActionListener(e -> {
            ajouterNoeud();
        });


        panelBoutons.add(this.btnAjouter);

        /*Ajout des panels*/
        this.add(panelListe, BorderLayout.WEST);
        this.add(panelInfos, BorderLayout.CENTER);
        this.add(panelBoutons, BorderLayout.SOUTH);
    }

    /**
     * efface le formulaire suite à l'ajout ou la suppression d'un noeud
     */
    private void effacerForm()
    {
        this.txtNom.setText("");
        this.txtPosX.setText("");
        this.txtPosY.setText("");
        this.txtPosNomX.setText("");
        this.txtPosNomY.setText("");
        this.btnCouleur.setBackground(null);
    }

    /**
     * Methode permettant d'ajouter un noeud
     */
    private void ajouterNoeud() 
    {
		boolean erreur  = false;
		String  nom     = "";
		int     posX    = 0;
		int     posY    = 0;
		int     posNomX = 0; 
		int     posNomY = 0;;

		// test nom
		if(this.txtNom.getText().equals(""))
		{
			this.txtNom.setBackground(Color.RED);
			JOptionPane.showMessageDialog(this, "Veuillez entrer un nom", "Erreur", JOptionPane.ERROR_MESSAGE);
			erreur = true;
		}
		else
		{
			nom = this.txtNom.getText();
			this.txtNom.setBackground(new Color(58, 60, 76));
		}
    
		// test position X
		try 
		{
			posX = Integer.parseInt(this.txtPosX.getText());
			this.txtPosX.setBackground(new Color(58, 60, 76));
		} 
		catch (NumberFormatException e) 
		{
			this.txtPosX.setBackground(Color.RED);
			JOptionPane.showMessageDialog(this, "Veuillez entrer une position X valide", "Erreur", JOptionPane.ERROR_MESSAGE);
			erreur = true;
		}

		// test position Y
		try
		{
			posY = Integer.parseInt(this.txtPosY.getText());
			this.txtPosY.setBackground(new Color(58, 60, 76));
		}
		catch (NumberFormatException e)
		{
			this.txtPosY.setBackground(Color.RED);
			JOptionPane.showMessageDialog(this, "Veuillez entrer une position Y valide", "Erreur", JOptionPane.ERROR_MESSAGE);
			erreur = true;
		}

		// test position X du nom
		try
		{
			posNomX = Integer.parseInt(this.txtPosNomX.getText());
			this.txtPosNomX.setBackground(new Color(58, 60, 76));
		}
		catch (NumberFormatException e)
		{
			this.txtPosNomX.setBackground(Color.RED);
			JOptionPane.showMessageDialog(this, "Veuillez entrer une position X du nom valide", "Erreur", JOptionPane.ERROR_MESSAGE);
			erreur = true;
		}

		// test position Y du nom
		try
		{
			posNomY = Integer.parseInt(this.txtPosNomY.getText());
			this.txtPosNomY.setBackground(new Color(58, 60, 76));
		}
		catch (NumberFormatException e)
		{
			this.txtPosNomY.setBackground(Color.RED);
			JOptionPane.showMessageDialog(this, "Veuillez entrer une position Y du nom valide", "Erreur", JOptionPane.ERROR_MESSAGE);
			erreur = true;
		}

		// test couleur
		if(this.couleur == null)
		{
			this.btnCouleur.setBackground(Color.RED);
			JOptionPane.showMessageDialog(this, "Veuillez choisir une couleur", "Erreur", JOptionPane.ERROR_MESSAGE);
			erreur = true;
		}

		if(!erreur)
		{
			this.ctrl.ajouterNoeud(nom, posX, posY, posNomX, posNomY, this.couleur);
       		this.effacerForm();
		}  
    }

    private void selectColor() 
    {
        this.couleur = JColorChooser.showDialog(this, "Choisir une couleur", Color.BLACK);
        this.btnCouleur.setBackground(couleur);
    }
}
