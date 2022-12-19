package ihm;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import controleur.Controleur;


public class PanelGenerateur extends JPanel 
{
    private PGPanelParamJeu pGPanelParamJeu;
    private PGPanelParamPlateau pGPanelParamPlateau;
	private PGPanelAjouterElements pGPanelAjouterElements;
    private PGPanelModifier pGPanelModifier;


	/**
	 * Constructeur de la classe PanelGenerateur
	 * @param ctrl
	 */
    public PanelGenerateur(Controleur ctrl)
    {
        this.pGPanelParamPlateau    = new PGPanelParamPlateau(ctrl);
        this.pGPanelParamJeu        = new PGPanelParamJeu(ctrl);
        this.pGPanelAjouterElements = new PGPanelAjouterElements();
        this.pGPanelModifier        = new PGPanelModifier();


        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(this.pGPanelParamPlateau, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(this.pGPanelParamJeu, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
                    .addComponent(this.pGPanelAjouterElements, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.pGPanelModifier, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(this.pGPanelParamPlateau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(this.pGPanelParamJeu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(this.pGPanelAjouterElements, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(this.pGPanelModifier, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }             
}