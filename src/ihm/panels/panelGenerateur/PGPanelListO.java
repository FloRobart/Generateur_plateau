package ihm.panels.panelGenerateur;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import controleur.Controleur;
import ihm.customComponent.TextFieldOnlyInteger;
import ihm.panels.PanelAjoutObjectif;
import metier.CarteObjectif;
import metier.Noeud;


public class PGPanelListO extends  JPanel
{
    private Controleur        ctrl;
    private JButton           btnAjouter;
    private JButton           btnImgRecto;
    private JButton           btnImgVerso;
    private JButton           btnSupprimer;
    private JComboBox<Noeud>  comboBoxListNoeudA;
    private JComboBox<Noeud>  comboBoxListNoeudB;
    private JList<CarteObjectif> jListObj;
    private JLabel            lblNoeudA;
    private JLabel            lblNoeudB;
    private JLabel            lblPoint;
    private JLabel            lblRecto;
    private JLabel            lblVerso;
    private JScrollPane       jspNoeud;
    private TextFieldOnlyInteger txtPoint;

    private List<Noeud>       lstNoeudA;
    private List<Noeud>       lstNoeudB;

    

    /**
     * Creates new form PGPanelListO
     */
    public PGPanelListO(Controleur ctrl)
    {
        this.ctrl               = ctrl;
        this.jspNoeud           = new  JScrollPane      ();
        this.jListObj           = new  JList<CarteObjectif>();
        this.btnAjouter         = new  JButton          ();
        this.btnSupprimer       = new  JButton          ();
        this.lblNoeudA          = new  JLabel           ();
        this.lblNoeudB          = new  JLabel           ();
        this.comboBoxListNoeudA = new  JComboBox<Noeud> ();
        this.comboBoxListNoeudB = new  JComboBox<Noeud> ();
        this.txtPoint           = new  TextFieldOnlyInteger(ctrl);
        this.lblPoint           = new  JLabel           ();
        this.lblRecto           = new  JLabel           ();
        this.lblVerso           = new  JLabel           ();
        this.btnImgRecto        = new  JButton          ();
        this.btnImgVerso        = new  JButton          ();
        this.lstNoeudA          = ctrl.getNoeuds();
        this.lstNoeudB          = ctrl.getNoeuds();

        List<CarteObjectif> lstObj = ctrl.getCarteObjectif();
        
        /*JListObj */
        this.jListObj.setModel(new AbstractListModel<CarteObjectif>() 
        {
            public int getSize() { return lstObj.size(); }
            public CarteObjectif getElementAt(int i) { return lstObj.get(i); }
        });

        this.jListObj.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
				CarteObjectif objSelected = jListObj.getSelectedValue();

				if (objSelected == null && lstObj.size() != 0) 
					objSelected = lstObj.get(0);
				
				if (objSelected != null)
				{
					List<Noeud> lstNoeuds = ctrl.getNoeuds();

        			comboBoxListNoeudA.setSelectedIndex(lstNoeuds.indexOf(objSelected.getNoeud1()));
        			comboBoxListNoeudB.setSelectedIndex(lstNoeuds.indexOf(objSelected.getNoeud2()));

					txtPoint.setText("" + objSelected.getPoints());
					
				}
				else
				{
					effacerForm();
				}
			}
		});

        /*Ajout de la JlistObjectif dans un JScrollPane */
        this.jspNoeud.setViewportView(jListObj);

        //btn Ajouter
        this.btnAjouter.setText("Ajouter");
        this.btnAjouter.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        //btn Supprimer
        this.btnSupprimer.setText("Supprimer");
        this.btnSupprimer.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        
        //lbl Noeud A et B
        this.lblNoeudA.setText("Noeud A");
        this.lblNoeudA.setFont(new Font("Segoe UI", 1, 12));

        this.lblNoeudB.setText("Noeud B");
        this.lblNoeudB.setFont(new Font("Segoe UI", 1, 12));

        /* comboBoxListNoeud */
        Noeud[] tabNoeudA = lstNoeudA.toArray(new Noeud[0]);
        Noeud[] tabNoeudB = lstNoeudB.toArray(new Noeud[0]);

        this.comboBoxListNoeudA.setModel(new DefaultComboBoxModel<>(tabNoeudA));
        this.comboBoxListNoeudA.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                comboBoxListNoeudActionPerformed(evt);
            }
        });

        this.comboBoxListNoeudB.setModel(new DefaultComboBoxModel<>(tabNoeudB));
        this.comboBoxListNoeudB.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                comboBoxListNoeudBctionPerformed(evt);
            }
        });

        this.txtPoint.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                txtPointActionPerformed(evt);
            }
        });

        this.lblPoint.setText("Point");
        this.lblPoint.setFont(new Font("Segoe UI", 1, 12));

        this.lblRecto.setText("Recto");
        this.lblRecto.setFont(new Font("Segoe UI", 1, 12));

        this.lblVerso.setText("Verso");
        this.lblVerso.setFont(new Font("Segoe UI", 1, 12));

        this.btnImgRecto.setText("Image");
        this.btnImgRecto.setFocusPainted(false);
        this.btnImgRecto.addActionListener(new ActionListener()
        {
            public void actionPerformed( ActionEvent evt)
            {
                btnImgRectoActionPerformed(evt);
            }
        });

        this.btnImgVerso.setText("Image");
        this.btnImgVerso.setFocusPainted(false);
        this.btnImgVerso.addActionListener(new ActionListener()
        {
            public void actionPerformed( ActionEvent evt)
            {
                btnImgVersoActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspNoeud, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblNoeudA)
                        .addGap(32, 32, 32)
                        .addComponent(comboBoxListNoeudA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblNoeudB)
                        .addGap(33, 33, 33)
                        .addComponent(comboBoxListNoeudB,0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblPoint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecto)
                    .addComponent(lblVerso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImgVerso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImgRecto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10,10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNoeudA)
                            .addComponent(comboBoxListNoeudA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRecto)
                            .addComponent(btnImgRecto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNoeudB)
                            .addComponent(comboBoxListNoeudB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVerso)
                            .addComponent(btnImgVerso))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPoint)))
                    .addComponent(jspNoeud, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                )
        );

        this.appliquerTheme();
    }                 

    protected void effacerForm() 
    {
        this.comboBoxListNoeudA.setSelectedIndex(0);
        this.comboBoxListNoeudB.setSelectedIndex(0);
        this.txtPoint.setText("");
    }

    private void btnAjouterActionPerformed (ActionEvent evt)
    {
        JDialog dialog = new JDialog(this.ctrl.getIHM(), "Ajouter un objectif");
        dialog.setSize(500, 250);
        dialog.setLocationRelativeTo(this.ctrl.getIHM());
        dialog.add(new PanelAjoutObjectif(ctrl));
        dialog.pack();
        dialog.setVisible(true);
    }

    private void btnSupprimerActionPerformed(ActionEvent evt)
    {
        CarteObjectif carte = this.jListObj.getSelectedValue();
        this.ctrl.supprimerObjectif(carte.getNoeud1().getNom(), carte.getNoeud2().getNom());
        this.ctrl.getIHM().majListes(); 
    }

    public void majIHM() 
    {    
        this.jListObj.setModel(new AbstractListModel<CarteObjectif>()
        {
            List<CarteObjectif> cartes = ctrl.getCarteObjectif();
            public int getSize() { return cartes.size(); }
            public CarteObjectif getElementAt(int i) { return cartes.get(i); }
        });

        this.comboBoxListNoeudA.setModel(new DefaultComboBoxModel<Noeud>(this.ctrl.getNoeuds().toArray(new Noeud[0])));
        this.comboBoxListNoeudB.setModel(new DefaultComboBoxModel<Noeud>(this.ctrl.getNoeuds().toArray(new Noeud[0])));
    }

    private void comboBoxListNoeudActionPerformed(ActionEvent evt)
    {
        CarteObjectif carte = this.jListObj.getSelectedValue();
        carte.setNoeud1(carte.getNoeud1());
        this.majIHM();
    }

    private void comboBoxListNoeudBctionPerformed(ActionEvent evt)
    {
        CarteObjectif carte = this.jListObj.getSelectedValue();
        carte.setNoeud2(carte.getNoeud2());
        this.majIHM();
    }

    private void txtPointActionPerformed(ActionEvent evt)
    {
        if (this.txtPoint.getText().length() > 0)
		{
			try
			{
				int point = Integer.parseInt(this.txtPoint.getText());
				if (point < 0)
				{
					JOptionPane.showMessageDialog(this, "Veuillez entrer un nombre supérieur à 0", "Erreur", JOptionPane.ERROR_MESSAGE);
					this.txtPoint.setText("" + this.jListObj.getSelectedValue().getPoints());
				}
				else
				{
					this.jListObj.getSelectedValue().setPoints(point);
					this.ctrl.majIHMPlateau();
				}
			}
			catch (NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(this, "Veuillez entrer un nombre entier", "Erreur", JOptionPane.ERROR_MESSAGE);
				this.txtPoint.setText("" + this.jListObj.getSelectedValue().getPoints());
			}
		}
    }

    private void btnImgRectoActionPerformed(ActionEvent evt)
    {
        String path = "";
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) 
        {
            File file = chooser.getSelectedFile();
            path = file.getAbsolutePath();
            try
            {
                CarteObjectif carte = this.jListObj.getSelectedValue();
                carte.setImageRecto(ImageIO.read(new File(path)));
            } catch (IOException e1) {e1.printStackTrace();}
            
            this.majIHM();
        }
    }
    private void btnImgVersoActionPerformed(ActionEvent evt)
    {
        String path = "";
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) 
        {
            File file = chooser.getSelectedFile();
            path = file.getAbsolutePath();
            try
            {
                CarteObjectif carte = this.jListObj.getSelectedValue();
                carte.setImageRecto(ImageIO.read(new File(path)));
            } catch (IOException e1) {e1.printStackTrace();}
            
            this.majIHM();
        }
    }
    
    public void appliquerTheme()
    {
        HashMap<String, List<Color>> theme = this.ctrl.getTheme();

        Color background       = theme.get("background").get(0);
        Color title            = theme.get("titles"    ).get(0);
        Color labelForeColor   = theme.get("labels"    ).get(0);
		Color labelBackColor   = theme.get("labels"    ).get(1);
        Color saisiForeColor   = theme.get("saisies"   ).get(0);
		Color saisiBackColor   = theme.get("saisies"   ).get(1);
        Color placeholderColor = theme.get("saisies"   ).get(2);
        Color btnForeColor     = theme.get("bottuns"   ).get(0);
		Color btnBackColor     = theme.get("bottuns"   ).get(1);


        /* Couleur de fond du panel */
        this.setBackground(background);

        /* ScrollPane contenant la liste des noeuds */
        this.jListObj.setForeground(title);
        this.jListObj.setBackground(background);
        

        /* Bouton ajouter */
        this.btnAjouter        .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnAjouter        .setForeground(btnForeColor);
        this.btnAjouter        .setBackground(btnBackColor);

        /* Bouton supprimer */
        this.btnSupprimer      .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnSupprimer      .setForeground(btnForeColor);
        this.btnSupprimer      .setBackground(btnBackColor);

        /* Liste des noeuds A */
        this.comboBoxListNoeudB.setBorder(null);
        this.comboBoxListNoeudB.setForeground(saisiForeColor);
        this.comboBoxListNoeudB.setBackground(saisiBackColor);

        /* Label noeuds A */
        this.lblNoeudA         .setBorder(null);
        this.lblNoeudA         .setForeground(labelForeColor);
        this.lblNoeudA         .setBackground(labelBackColor);

        /* Label noeuds B */
        this.lblNoeudB         .setBorder(null);
        this.lblNoeudB         .setForeground(labelForeColor);
        this.lblNoeudB         .setBackground(labelBackColor);

        /* Liste des noeuds B */
        this.comboBoxListNoeudA.setBorder(null);
        this.comboBoxListNoeudA.setForeground(saisiForeColor);
        this.comboBoxListNoeudA.setBackground(saisiBackColor);

        /* TexteField des points */
        this.txtPoint          .setBorder(null);
        this.txtPoint          .setForeground(placeholderColor);
        this.txtPoint          .setBackground(saisiBackColor  );
        this.txtPoint          .setForegroundColor (saisiForeColor  );
        this.txtPoint          .setPlaceholderColor(placeholderColor);

        /* Label des points */
        this.lblPoint          .setBorder(null);
        this.lblPoint          .setForeground(labelForeColor);
        this.lblPoint          .setBackground(labelBackColor);

        /* Label recto */
        this.lblRecto          .setBorder(null);
        this.lblRecto          .setForeground(labelForeColor);
        this.lblRecto          .setBackground(labelBackColor);

        /* Label verso */
        this.lblVerso          .setBorder(null);
        this.lblVerso          .setForeground(labelForeColor);
        this.lblVerso          .setBackground(labelBackColor);

        /* Bouton image recto */
        this.btnImgRecto       .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnImgRecto       .setForeground(btnForeColor);
        this.btnImgRecto       .setBackground(btnBackColor);

        /* Bouton image verso */
        this.btnImgVerso       .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnImgVerso       .setForeground(btnForeColor);
        this.btnImgVerso       .setBackground(btnBackColor);
    }

    public void selectObjectif(int index) 
    {
        this.jListObj.setSelectedIndex(index);
    }
}