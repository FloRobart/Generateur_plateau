package ihm;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.GroupLayout;

import controleur.Controleur;

public class PanelNoeud extends JPanel
{
    private Controleur ctrl;

    private JTextField txtPosX;
    private JTextField txtPosY;
    private JTextField txtNom;
    private JTextField txtPosNomX;
    private JTextField txtPosNomY;
    private JButton    btnCouleur;

    public PanelNoeud(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setBackground(new Color(68, 71, 90));
        
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        this.txtPosX = new JTextField();
        this.txtPosX.setBackground(new Color(58, 60, 76));
        this.txtPosX.setForeground(Color.GRAY);

        this.txtPosY = new JTextField(8);
        this.txtPosY.setBackground(new Color(58, 60, 76));
        this.txtPosY.setForeground(Color.GRAY);

        this.txtNom = new JTextField(8);
        this.txtNom.setBackground(new Color(58, 60, 76));
        this.txtNom.setForeground(Color.GRAY);

        this.txtPosNomX = new JTextField();
        this.txtPosNomX.setBackground(new Color(58, 60, 76));
        this.txtPosNomX.setForeground(Color.GRAY);

        this.txtPosNomY = new JTextField(8);
        this.txtPosNomY.setBackground(new Color(58, 60, 76));
        this.txtPosNomY.setForeground(Color.GRAY);

        this.btnCouleur = new JButton("Couleur");
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
            addComponent(labelPos).addComponent(labelNom).addComponent(labelPosNom).addComponent(labelCouleur));

        hGroup.addGroup(layout.createParallelGroup().
            addComponent(txtPosX).addComponent(txtNom).addComponent(txtPosNomX).addComponent(btnCouleur));
        
        hGroup.addGroup(layout.createParallelGroup().
            addComponent(txtPosY).addComponent(txtPosNomY));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(labelPos).addComponent(txtPosX).addComponent(txtPosY));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(labelNom).addComponent(txtNom));
        
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(labelPosNom).addComponent(txtPosNomX).addComponent(txtPosNomY));
        
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(labelCouleur).addComponent(btnCouleur));
        
        layout.setVerticalGroup(vGroup);




    }

    private void selectColor() 
    {
        Color color = JColorChooser.showDialog(this, "Choisir une couleur", Color.BLACK);
        System.out.println(color);

    }
}
