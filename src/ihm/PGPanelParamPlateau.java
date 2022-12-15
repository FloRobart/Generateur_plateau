package ihm;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Color;
import controleur.Controleur;

public class PGPanelParamPlateau extends javax.swing.JPanel {

    private Controleur ctrl;
    /**
     * Creates new form PGPanelParamPlateau
     */
    public PGPanelParamPlateau(Controleur ctrl) {
        this.ctrl = ctrl;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblParamPlateau = new javax.swing.JLabel();
        lblDimension = new javax.swing.JLabel();
        lblbImageFond = new javax.swing.JLabel();
        lblCouleurFond = new javax.swing.JLabel();
        lblPolice = new javax.swing.JLabel();
        txtX = new javax.swing.JTextField();
        txtY = new javax.swing.JTextField();
        txtPathImg = new javax.swing.JTextField();
        btnParcourirImg = new javax.swing.JButton();
        btnChoisirCouleur = new javax.swing.JButton();
        btnChoisirFont = new javax.swing.JButton();
        lblCouleurCourant = new javax.swing.JLabel();
        txtPathPolice = new javax.swing.JTextField();

        setBackground(new java.awt.Color(68, 71, 90));

        lblParamPlateau.setBackground(new java.awt.Color(49, 51, 63));
        lblParamPlateau.setForeground(new java.awt.Color(255, 255, 255));
        lblParamPlateau.setText("Parametre du Plateau");
        lblParamPlateau.setOpaque(true);

        lblDimension.setBackground(new java.awt.Color(73, 81, 99));
        lblDimension.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDimension.setForeground(new java.awt.Color(255, 255, 255));
        lblDimension.setText("Dimension");

        lblbImageFond.setBackground(new java.awt.Color(73, 81, 99));
        lblbImageFond.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblbImageFond.setForeground(new java.awt.Color(255, 255, 255));
        lblbImageFond.setText("Image Fond");

        lblCouleurFond.setBackground(new java.awt.Color(47, 49, 63));
        lblCouleurFond.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCouleurFond.setForeground(new java.awt.Color(255, 255, 255));
        lblCouleurFond.setText("Couleur de fond");

        lblPolice.setBackground(new java.awt.Color(73, 81, 99));
        lblPolice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPolice.setForeground(new java.awt.Color(255, 255, 255));
        lblPolice.setText("Police d'écriture");

        txtX.setBackground(new java.awt.Color(47, 49, 63));
        txtX.setForeground(new java.awt.Color(255, 255, 255));
        txtX.setText(" X:");
        txtX.setBorder(null);
        txtX.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtX.setOpaque(true);
        txtX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXActionPerformed(evt);
            }
        });

        txtY.setBackground(new java.awt.Color(47, 49, 63));
        txtY.setForeground(new java.awt.Color(255, 255, 255));
        txtY.setText(" Y:");
        txtY.setBorder(null);
        txtY.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtY.setOpaque(true);
        txtY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYActionPerformed(evt);
            }
        });

        txtPathImg.setBackground(new java.awt.Color(47, 49, 63));
        txtPathImg.setForeground(new java.awt.Color(255, 255, 255));
        txtPathImg.setText(" Parcourir");
        txtPathImg.setBorder(null);
        txtPathImg.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtPathImg.setOpaque(true);
        txtPathImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPathImgActionPerformed(evt);
            }
        });

        btnParcourirImg.setBackground(new java.awt.Color(0, 0, 0));
        btnParcourirImg.setForeground(new java.awt.Color(255, 255, 255));
        btnParcourirImg.setText("...");
        btnParcourirImg.setBorder(null);
        btnParcourirImg.setOpaque(true);
        btnParcourirImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParcourirImgActionPerformed(evt);
            }
        });

        btnChoisirCouleur.setBackground(new java.awt.Color(0, 0, 0));
        btnChoisirCouleur.setForeground(new java.awt.Color(255, 255, 255));
        btnChoisirCouleur.setText("...");
        btnChoisirCouleur.setBorder(null);
        btnChoisirCouleur.setOpaque(true);
        btnChoisirCouleur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoisirCouleurActionPerformed(evt);
            }
        });

        btnChoisirFont.setBackground(new java.awt.Color(0, 0, 0));
        btnChoisirFont.setForeground(new java.awt.Color(255, 255, 255));
        btnChoisirFont.setText("...");
        btnChoisirFont.setBorder(null);
        btnChoisirFont.setOpaque(true);
        btnChoisirFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoisirFontActionPerformed(evt);
            }
        });

        lblCouleurCourant.setBackground(new java.awt.Color(47, 49, 63));
        lblCouleurCourant.setForeground(new java.awt.Color(255, 255, 255));
        lblCouleurCourant.setText("Choisir votre couleur");
        lblCouleurCourant.setOpaque(true);

        txtPathPolice.setBackground(new java.awt.Color(47, 49, 63));
        txtPathPolice.setForeground(new java.awt.Color(255, 255, 255));
        txtPathPolice.setText(" Parcourir");
        txtPathPolice.setBorder(null);
        txtPathPolice.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtPathPolice.setOpaque(true);
        txtPathPolice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPathPoliceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDimension)
                            .addComponent(lblbImageFond))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(txtY, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCouleurCourant, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(txtPathPolice, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPathImg))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnParcourirImg, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnChoisirCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnChoisirFont, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(lblPolice)
                    .addComponent(lblCouleurFond))
                .addContainerGap(49, Short.MAX_VALUE))
            .addComponent(lblParamPlateau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblParamPlateau, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDimension)
                    .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtY, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblbImageFond)
                    .addComponent(txtPathImg, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnParcourirImg, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCouleurFond)
                    .addComponent(btnChoisirCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCouleurCourant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPolice)
                    .addComponent(btnChoisirFont, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPathPolice, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        lblCouleurCourant.getAccessibleContext().setAccessibleName("lblCouleurCourant");
    }// </editor-fold>                        

    /*
     * 
     * Les méthodes appelés par les listeners
     * Component nom : ?
     * Fonction appelée sera  : ?ActionPerformed
     */
    private void txtXActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void txtYActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void txtPathImgActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void txtPathPoliceActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void btnParcourirImgActionPerformed(java.awt.event.ActionEvent evt) {                                                
        JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png", "jpeg");
		fileChooser.setFileFilter(filter);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION)
		{
			return;
		}
    }                                               

    private void btnChoisirCouleurActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        Color color = JColorChooser.showDialog(this, "Choisissez une couleur", Color.WHITE);
		if (color != null) 
		 	this.ctrl.setCouleur(color);
    }                                                 

    private void btnChoisirFontActionPerformed(java.awt.event.ActionEvent evt) {                                               
        JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png", "jpeg");
		fileChooser.setFileFilter(filter);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION)
		{
			//A completer
            return;
		}
    }                                              


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnChoisirCouleur;
    private javax.swing.JButton btnChoisirFont;
    private javax.swing.JButton btnParcourirImg;
    private javax.swing.JLabel lblCouleurCourant;
    private javax.swing.JLabel lblCouleurFond;
    private javax.swing.JLabel lblDimension;
    private javax.swing.JLabel lblParamPlateau;
    private javax.swing.JLabel lblPolice;
    private javax.swing.JLabel lblbImageFond;
    private javax.swing.JTextField txtPathImg;
    private javax.swing.JTextField txtPathPolice;
    private javax.swing.JTextField txtX;
    private javax.swing.JTextField txtY;
    // End of variables declaration         

}


