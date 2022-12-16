package ihm;

import java.awt.Color;

import javax.swing.*;
import java.awt.GridLayout;
public class PGPanelAjouterElements extends javax.swing.JPanel {


    public PGPanelAjouterElements()
    {
        initComponents();
        dragAndDropSettings();
    }

    private void dragAndDropSettings() 
    {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblAjouterElements = new javax.swing.JLabel();
        imgArrete = new javax.swing.JLabel();
        imgNoeud = new javax.swing.JLabel();
        imgObjectif = new javax.swing.JLabel();
        lblNoeud = new javax.swing.JLabel();
        lblArrete = new javax.swing.JLabel();
        lblObjectif = new javax.swing.JLabel();
        btnListElements = new javax.swing.JButton();

        setBackground(new java.awt.Color(68, 71, 90));
        setPreferredSize(new java.awt.Dimension(403, 215));

        lblAjouterElements.setBackground(new java.awt.Color(49, 51, 63));
        lblAjouterElements.setForeground(new java.awt.Color(255, 255, 255));
        lblAjouterElements.setText(" Ajouter éléments");
        lblAjouterElements.setOpaque(true);

        imgArrete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgArrete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arete.png"))); // NOI18N
        imgArrete.setPreferredSize(new java.awt.Dimension(60, 60));

        imgNoeud.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgNoeud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/noeud.png"))); // NOI18N

        imgObjectif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgObjectif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/objectif.png"))); // NOI18N

        lblNoeud.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNoeud.setForeground(new java.awt.Color(255, 255, 255));
        lblNoeud.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNoeud.setText("Noeud");

        lblArrete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblArrete.setForeground(new java.awt.Color(255, 255, 255));
        lblArrete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArrete.setText("Arrête");

        lblObjectif.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblObjectif.setForeground(new java.awt.Color(255, 255, 255));
        lblObjectif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblObjectif.setText("Objectifs");

        btnListElements.setBackground(new java.awt.Color(40, 42, 54));
        btnListElements.setForeground(new java.awt.Color(255, 255, 255));
        btnListElements.setText("List éléments");
        btnListElements.setBorder(null);
        btnListElements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListElementsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAjouterElements, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblObjectif, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imgNoeud, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNoeud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnListElements, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(imgArrete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblArrete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(61, 61, 61)
                        .addComponent(imgObjectif, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAjouterElements, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imgArrete, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgNoeud, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgObjectif, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArrete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblObjectif)
                    .addComponent(lblNoeud))
                .addGap(18, 18, 18)
                .addComponent(btnListElements, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );
    }// </editor-fold>                        

    private void btnListElementsActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnListElements;
    private javax.swing.JLabel imgArrete;
    private javax.swing.JLabel imgNoeud;
    private javax.swing.JLabel imgObjectif;
    private javax.swing.JLabel lblAjouterElements;
    private javax.swing.JLabel lblArrete;
    private javax.swing.JLabel lblNoeud;
    private javax.swing.JLabel lblObjectif;
    // End of variables declaration                   
}