package ihm;

import controleur.Controleur;
import javax.swing.JTabbedPane;

public class PGPanelExplorer extends javax.swing.JPanel
{
    private Controleur ctrl;
    /**
     * Creates new form PGPanelExplorer
     */
    public PGPanelExplorer(Controleur ctrl)
    {
        this.ctrl = ctrl;

        jTabbedPane1 = new JTabbedPane();
        pGPanelListN = new PGPanelListN(ctrl);
        pGPanelListA = new PGPanelListA(ctrl);
        pGPanelListO = new PGPanelListO(ctrl);

        setBackground(new java.awt.Color(68, 71, 93));

        jTabbedPane1.setName("");
        jTabbedPane1.addTab("Noeud", pGPanelListN);
        jTabbedPane1.addTab("Arrêtes", pGPanelListA);
        jTabbedPane1.addTab("Objectifs",  pGPanelListO);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("List Noeud");
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JTabbedPane jTabbedPane1;
    private  PGPanelListA pGPanelListA;
    private  PGPanelListN pGPanelListN;
    private  PGPanelListO pGPanelListO;
    // End of variables declaration                   
}