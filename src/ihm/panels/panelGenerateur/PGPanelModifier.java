package ihm.panels.panelGenerateur;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Controleur;


public class PGPanelModifier extends JPanel
{
    private Controleur ctrl;

    private JPanel panelList;

    private JLabel lblTitre;
    private JLabel lblNoeuds;
    private JLabel lblArretes;
    private JLabel lblObjectifs;


    public PGPanelModifier(Controleur ctrl)
    {
        this.ctrl = ctrl;

        /*------------------------*/
        /* Créations des éléments */
        /*------------------------*/
        /* Créations du panel */
        this.panelList = new JPanel(new GridLayout(1, 3));

        /* Créations des labels */
        this.lblTitre   = new JLabel(" Modifier l'élément chosit");

        this.lblNoeuds    = new JLabel("Noeuds"   , JLabel.CENTER);
        this.lblArretes   = new JLabel("Arretes"  , JLabel.CENTER);
        this.lblObjectifs = new JLabel("Objectifs", JLabel.CENTER);


        /*---------------------*/
        /* Ajouts des éléments */
        /*---------------------*/
        /* Ajouts des labels au panelList */
        this.panelList.add(this.lblNoeuds   );
        this.panelList.add(this.lblArretes  );
        this.panelList.add(this.lblObjectifs);

        /* Ajouts du panelList au panel (this) */
        this.add(panelList);


        /*---------------*/
        /* Groupe Layout */
        /*---------------*/
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent
            (
                this.lblTitre, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE
            )
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup
            (
                layout.createSequentialGroup()
                .addComponent(this.lblTitre, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
            )
        );


        this.appliquerTheme();
    }


    /**
     * Applique le thème à tout les composants du panel
     */
    public void appliquerTheme()
	{
		Color background     = this.ctrl.getTheme().get("background").get(0);
        Color titleForeColor = this.ctrl.getTheme().get("titles"    ).get(0);
		Color titleBackColor = this.ctrl.getTheme().get("titles"    ).get(1);
        Color labelForeColor = this.ctrl.getTheme().get("labels"    ).get(0);
		Color labelBackColor = this.ctrl.getTheme().get("labels"    ).get(1);


        this.setBackground(background);

        /* PanelList */
        this.setOpaque(true);
        this.panelList.setBackground(background);

        /* Label Titre */
        this.lblTitre.setOpaque(true);
        this.lblTitre.setForeground(titleForeColor);
        this.lblTitre.setBackground(titleBackColor);

        /* Label Noeuds */
        this.lblNoeuds   .setOpaque(true);
        this.lblNoeuds   .setForeground(labelForeColor);
        this.lblNoeuds   .setBackground(labelBackColor);

        /* Label Arretes */
        this.lblArretes  .setOpaque(true);
        this.lblArretes  .setForeground(labelForeColor);
        this.lblArretes  .setBackground(labelBackColor);

        /* Label Objectifs */
        this.lblObjectifs.setOpaque(true);
        this.lblObjectifs.setForeground(labelForeColor);
        this.lblObjectifs.setBackground(labelBackColor);
	}
}
