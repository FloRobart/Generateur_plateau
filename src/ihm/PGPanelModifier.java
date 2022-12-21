package ihm;
import javax.swing.*;
import java.awt.Color;

import controleur.Controleur;


public class PGPanelModifier extends JPanel
{
    private Controleur ctrl;

    private JLabel labelTitre;


    public PGPanelModifier(Controleur ctrl)
    {
        this.ctrl = ctrl;
        initComponents();
    }


                      
    private void initComponents()
    {
        Color background     = this.ctrl.getTheme().get("background").get(0);
        Color titleForeColor = this.ctrl.getTheme().get("titles"    ).get(0);
		Color titleBackColor = this.ctrl.getTheme().get("titles"    ).get(1);


        this.setBackground(background);

        this.labelTitre = new JLabel();
        this.labelTitre.setBackground(titleBackColor);
        this.labelTitre.setForeground(titleForeColor);
        this.labelTitre.setText(" Modifier l'élément chosit");
        this.labelTitre.setOpaque(true);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(labelTitre, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelTitre, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 278, Short.MAX_VALUE))
        );
    }                 
}
