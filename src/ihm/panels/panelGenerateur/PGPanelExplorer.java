package ihm.panels.panelGenerateur;

import controleur.Controleur;

import javax.swing.JTabbedPane;


public class PGPanelExplorer extends javax.swing.JPanel
{
    private Controleur ctrl;

    private JTabbedPane  jTabbedPane1;
    private PGPanelListA pGPanelListA;
    private PGPanelListN pGPanelListN;
    private PGPanelListO pGPanelListO;
    /**
     * Creates new form PGPanelExplorer
     */
    public PGPanelExplorer(Controleur ctrl)
    {
        this.ctrl = ctrl;

        this.jTabbedPane1 = new JTabbedPane();
        this.pGPanelListN = new PGPanelListN(ctrl);
        this.pGPanelListA = new PGPanelListA(ctrl);
        this.pGPanelListO = new PGPanelListO(ctrl);


        this.jTabbedPane1.setName("");
        this.jTabbedPane1.addTab("Noeud"    , this.pGPanelListN);
        this.jTabbedPane1.addTab("Arrêtes"  , this.pGPanelListA);
        this.jTabbedPane1.addTab("Objectifs", this.pGPanelListO);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(this.jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(this.jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        this.jTabbedPane1.getAccessibleContext().setAccessibleName("List Noeud");

        this.appliquerTheme();
    }

    public void appliquerTheme()
    {
        this.setBackground(this.ctrl.getTheme().get("background").get(0));

        this.pGPanelListA.appliquerTheme();
        this.pGPanelListN.appliquerTheme();
        this.pGPanelListO.appliquerTheme();
    }

	public void majListes()
	{
		//this.pGPanelListA.majListes();
		this.pGPanelListN.majIHM();
		//this.pGPanelListO.majListes();
	}

	public void selectNoeud(int index)
	{
		this.pGPanelListN.selectNoeud(index);
		
	}
}