package ihm;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controleur.Controleur;

public class FrameCouleur extends JFrame implements ActionListener
{
    private Controleur ctrl;
    private JPanel     panelCouleur;
    private Color[]    tabCoul = { Color.RED,  Color.CYAN, Color.GREEN,   Color.YELLOW, Color.PINK, Color.ORANGE}; 
    private JButton[]  tabBtnCoul;
    private JButton    btnPlus;
    private JButton    btnOK;


    public FrameCouleur(Controleur ctrl)
    {
        this.ctrl = ctrl;

        this.setTitle("Modifier les couleurs");
        this.setSize(300, 300);
        this.setLocation(500, 300);
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(68, 71, 90));

        /*PANEL COULEUR */
        this.panelCouleur = new JPanel();
        this.panelCouleur.setLayout(new GridLayout(2,5, 5, 5));
        this.panelCouleur.setBackground(new Color(68, 71, 90));

        this.tabBtnCoul = new JButton[tabCoul.length];

        this.btnPlus = new JButton("+");
        add(btnPlus);
		btnPlus.addActionListener(e -> {
			selectColor();
		});

        for (int cpt=0; cpt < this.tabBtnCoul.length; cpt++)
        {
            this.tabBtnCoul[cpt] = new JButton();
            this.tabBtnCoul[cpt].setBackground(tabCoul[cpt]);
        }

       
        //Posiotionnement des composants
        for (int cpt=0; cpt < this.tabBtnCoul.length; cpt++)
        {
            this.panelCouleur.add(this.tabBtnCoul[cpt]);
        }

        this.panelCouleur.add(this.btnPlus);

        // activation des composants
        for (int cpt=0; cpt < this.tabBtnCoul.length; cpt++)
        {
            this.tabBtnCoul[cpt].addActionListener(this);
        }

        /*Panel Ok */
        JPanel panelOk = new JPanel();
        this.btnOK = new JButton("OK");
        

        panelOk.add(this.btnOK);


        this.add(this.panelCouleur, BorderLayout.CENTER);
        this.add(panelOk, BorderLayout.SOUTH);

        this.setVisible(false);

        this.btnOK.addActionListener(this);

    }

    public void afficher()
    {
        this.setVisible(true);
    }

    private void selectColor() 
    {
        Color color = JColorChooser.showDialog(this, "Choisir une couleur", Color.BLACK);
        System.out.println(color);
        this.btnPlus.setBackground(color);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == this.btnOK)
        {
            this.setVisible(false);
        }
        
    }
    

    
}
