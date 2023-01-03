  package ihm.panels.panelGenerateur;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.ListModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.Controleur;
import ihm.customComponent.TextFieldWithHint;
import ihm.frames.FrameCouleurChooser;
import metier.Arete;
import metier.Noeud;


public class PGPanelListA extends JPanel
{
    private Controleur        ctrl;

    private JButton           btnAjouter;
    private JButton           btnCouleur1;
    private JButton           btnCouleur2;
    private JButton           btnSupprimer;
    private JCheckBox         cb2Sens;
    private JComboBox<Noeud> comboBoxListNoeudA;
    private JComboBox<Noeud> comboBoxListNoeudB;
    private JList<Arete>     jListAretes;
    private JScrollPane       jScrollPane1;
    private JLabel            lbl2Sens;
    private JLabel            lblCouleur1;
    private JLabel            lblCouleur2;
    private JLabel            lblDistance;
    private JLabel            lblNoeudA;
    private JLabel            lblNoeudB;
    private TextFieldWithHint txtDistance;

    private List<Noeud>       lstNoeudA;
    private List<Noeud>       lstNoeudB;

    private Color             couleur1;
    private Color             couleur2;

    private ListModel<Arete> listModel;

	private int couleurAttendu = 1;


    /**
     * Creates new form PGPanelListA
     */
    public PGPanelListA(Controleur ctrl)
    {
        this.ctrl               = ctrl;

        this.jScrollPane1       = new JScrollPane      ();
        this.jListAretes        = new JList<Arete>    ();
        this.lblNoeudA          = new JLabel           ();
        this.lblNoeudB          = new JLabel           ();
        this.lbl2Sens           = new JLabel           ();
        this.lblCouleur1        = new JLabel           ();
        this.lblDistance        = new JLabel           ();
        this.lblCouleur2        = new JLabel           ();
        this.comboBoxListNoeudA = new JComboBox<Noeud>();
        this.comboBoxListNoeudB = new JComboBox<Noeud>();
        this.cb2Sens            = new JCheckBox        ();
        this.txtDistance        = new TextFieldWithHint("Distance", ctrl);
        this.btnCouleur1        = new JButton          ();
        this.btnCouleur2        = new JButton          ();
        this.btnAjouter         = new JButton          ();
        this.btnSupprimer       = new JButton          ();
        this.lstNoeudA          = ctrl.getNoeuds       ();
        this.lstNoeudB          = ctrl.getNoeuds       ();
        this.listModel          = new DefaultListModel<>();


        /* jListAretes */
		List<Arete> lstAretes = ctrl.getAretes();
        for (Arete a : lstAretes) {
            ((DefaultListModel<Arete>) this.listModel).addElement(a);
        }
        this.jListAretes.setModel(new AbstractListModel<Arete>()
        {
            List<Arete> lstAretes = ctrl.getAretes();

            public int getSize()
            {
                return lstAretes.size();
            }

            public Arete getElementAt(int index)
            {
                return lstAretes.get(index);
            }
        });

		this.jListAretes.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
				Arete areteSelected = jListAretes.getSelectedValue();

				if (areteSelected == null && lstAretes.size() != 0) 
					areteSelected = lstAretes.get(0);
				
				if (areteSelected != null)
				{
					List<Noeud> lstNoeuds = ctrl.getNoeuds();

        			comboBoxListNoeudA.setSelectedIndex(lstNoeuds.indexOf(areteSelected.getNoeud1()));
        			comboBoxListNoeudB.setSelectedIndex(lstNoeuds.indexOf(areteSelected.getNoeud2()));
					txtDistance.setText("" + areteSelected.getDistance());
					btnCouleur1.setBackground(areteSelected.getCouleur1());

					if (areteSelected.getCouleur2() != null)
					{
						cb2Sens.setSelected(true);
						btnCouleur2.setBackground(areteSelected.getCouleur2());
					}
					else
					{
						cb2Sens.setSelected(false);
						btnCouleur2.setBackground(null);
					}
				}
				else
				{
					//this.effacerForm();
				}
			}
		});


        /* Ajout de la list1 dans un JScrollPane */
        this.jScrollPane1.setViewportView(jListAretes);

        /* lblNoeudA */
        this.lblNoeudA.setText("Noeud A");
        this.lblNoeudA.setFont(new Font("Segoe UI", 1, 12));

        /* lblNoeudB */
        this.lblNoeudB.setText("Noeud B");
        this.lblNoeudB.setFont(new Font("Segoe UI", 1, 12));

        /* lbl2Sens */
        this.lbl2Sens.setText("2 sens");
        this.lbl2Sens.setFont(new Font("Segoe UI", 1, 12));

        /* lblCouleurAB */
        this.lblCouleur1.setText("Couleur 1");
        this.lblCouleur1.setFont(new Font("Segoe UI", 1, 12));

        /* lblDistance */
        this.lblDistance.setText("Distance");
        this.lblDistance.setFont(new Font("Segoe UI", 1, 12));

        /* lblCouleurBA */
        this.lblCouleur2.setText("Couleur 2");
        this.lblCouleur2.setFont(new Font("Segoe UI", 1, 12));

        /* comboBoxListNoeudA */
        Noeud[] tabNoeudA = lstNoeudA.toArray(new Noeud[0]);
        Noeud[] tabNoeudB = lstNoeudB.toArray(new Noeud[0]);
  

        this.comboBoxListNoeudA.setModel(new DefaultComboBoxModel<>(tabNoeudA));
        this.comboBoxListNoeudA.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                comboBoxListNoeudAActionPerformed(evt);
            }
        });

        this.comboBoxListNoeudB.setModel(new DefaultComboBoxModel<>(tabNoeudB));
        this.comboBoxListNoeudB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                comboBoxListNoeudBActionPerformed(evt);
            }
        });

        this.cb2Sens.setSelected(false);
        this.cb2Sens.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                cb2SensActionPerformed(evt);
            }
        });

        this.txtDistance.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) 
            {
               txtDistanceKeyPressed(ke);
            }
         });

        this.btnCouleur1.setText("Couleur");
        this.btnCouleur1.setFocusPainted(false);
        this.btnCouleur1.addActionListener(e ->
        {
            selectColor1();
        });

        this.btnCouleur2.setText("Couleur");
        this.btnCouleur2.setFocusPainted(false);
		this.btnCouleur2.setEnabled(false);
        this.btnCouleur2.addActionListener(e ->
        {
            selectColor2();
        });

        this.btnAjouter.setText("Ajouter");
        this.btnAjouter.setFocusPainted(false);
        this.btnAjouter.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                btnAjouterActionPerformed(evt);
            }
        });

        this.btnSupprimer.setText("Supprimer");
        this.btnSupprimer.setFocusPainted(false);
        this.btnSupprimer.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                btnSupprimerActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(this.btnSupprimer, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(this.btnAjouter, GroupLayout.DEFAULT_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(this.jScrollPane1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(this.lbl2Sens)
                        .addGap(47, 47, 47)
                        .addComponent(this.cb2Sens))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(this.lblNoeudA)
                            .addGap(32, 32, 32)
                            .addComponent(this.comboBoxListNoeudA, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(this.lblNoeudB)
                            .addGap(33, 33, 33)
                            .addComponent(this.comboBoxListNoeudB, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(this.lblDistance)
                        .addGap(34, 34, 34)
                        .addComponent(this.txtDistance, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(this.lblCouleur2)
                            .addGap(18, 18, 18)
                            .addComponent(this.btnCouleur2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(this.lblCouleur1)
                            .addGap(18, 18, 18)
                            .addComponent(this.btnCouleur1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10,10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(this.lblNoeudA)
                            .addComponent(this.comboBoxListNoeudA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.lblDistance)
                            .addComponent(this.txtDistance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(this.lblNoeudB)
                            .addComponent(this.comboBoxListNoeudB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.lblCouleur1)
                            .addComponent(this.btnCouleur1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(this.lbl2Sens)
                                .addComponent(this.cb2Sens, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addComponent(this.lblCouleur2))
                            .addComponent(this.btnCouleur2)))
                    .addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.btnAjouter, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.btnSupprimer, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                )
        );

       
        /*Mouse listener */ 
        MouseListener mouseListener = new MouseAdapter() {
            public void mousePressed(MouseEvent e) 
            {
                if(e.getSource() == jListAretes)
                {/*
                    String[] noms = listModel.getElementAt(jListAretes.getSelectedIndex()).split("-");
                    
                    for(Arete a : ctrl.getAretes())
                    {
                        if(a.getNoeud1().getNom().equals(noms[0]) && a.getNoeud2().getNom().equals(noms[1]))
                        {
                            comboBoxListNoeudA.setSelectedItem(a.getNoeud1());
                            comboBoxListNoeudB.setSelectedItem(a.getNoeud2());
                            txtDistance.setText(String.valueOf(a.getDistance()));
                            btnCouleur1.setBackground(a.getCouleur1());
                            btnCouleur2.setBackground(a.getCouleur2());
                            cb2Sens.setSelected(a.is2Sens());
                        }
                    }*/
                }   
            }
        };
        
        this.appliquerTheme();
    }                      

    private void selectColor1() 
    {
		new FrameCouleurChooser(ctrl, this.getClass().getName());
		this.couleurAttendu = 1;
    }


    private void selectColor2() 
    {
        new FrameCouleurChooser(ctrl, this.getClass().getName());
		this.couleurAttendu = 2;
    }


    private void btnAjouterActionPerformed(ActionEvent e)
    {
        /*String nom1     = (String) this.comboBoxListNoeudA.getSelectedItem();
        String nom2     = (String) this.comboBoxListNoeudB.getSelectedItem();
        int    distance = Integer.parseInt(this.txtDistance.getText());
        
        if(!nom1.equals(nom2))
        {
            if(!this.cb2Sens.isSelected())
                this.ctrl.ajouterArete(nom1, nom2, distance, couleur1, null);

            this.ctrl.ajouterArete(nom1, nom2, distance, this.couleur1, this.couleur2);
        }

        ((DefaultListModel<Arete>) this.listModel).addElement(a.get + " - " + nom2);
        this.jListAretes.setModel(this.listModel);
*/
        this.effacerForm(); 
    }


    private void btnSupprimerActionPerformed      (ActionEvent e)
    {
        /*String[] noms = this.listModel.getElementAt(this.jListAretes.getSelectedIndex()).split("-");

        this.ctrl.supprimerArete(noms[0], noms[1]);

        ((DefaultListModel<Arete>) this.listModel).removeElement(noms[0] + "-" + noms[1]);
        this.jListAretes.setModel(this.listModel);

        this.effacerForm();*/
    }

    private void cb2SensActionPerformed(ActionEvent e)
	{
		if (this.cb2Sens.isSelected())
		{
			this.btnCouleur2.setEnabled(true);
		}
		else
		{
			this.btnCouleur2.setEnabled(false);
			this.btnCouleur2.setBackground(null);
		}
	}
    
    private void txtDistanceKeyPressed(KeyEvent ke) 
    {
        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE )
        {
            txtDistance.setEditable(true);
        }
        else
        {
            txtDistance.setEditable(false);
        }
    }

    private void comboBoxListNoeudBActionPerformed(ActionEvent e){}
    private void comboBoxListNoeudAActionPerformed(ActionEvent e){}

    private void effacerForm() 
    {
        this.txtDistance.setText("");
        this.comboBoxListNoeudA.setSelectedIndex(0);
        this.comboBoxListNoeudB.setSelectedIndex(0);
        this.cb2Sens.setSelected(false);
        this.btnCouleur1.setBackground(this.ctrl.getTheme().get("bottuns").get(1));
        this.btnCouleur2.setBackground(this.ctrl.getTheme().get("bottuns").get(1));
    }



    public void appliquerTheme()
    {
        HashMap<String, List<Color>> theme = this.ctrl.getTheme();

        Color background       = theme.get("background"  ).get(0);
        Color titleForeColor   = theme.get("titles"      ).get(0);
        Color labelForeColor   = theme.get("labels"      ).get(0);
		Color labelBackColor   = theme.get("labels"      ).get(1);
        Color saisiForeColor   = theme.get("saisies"     ).get(0);
		Color saisiBackColor   = theme.get("saisies"     ).get(1);
        Color placeholderColor = theme.get("saisies"     ).get(2);
        Color btnForeColor     = theme.get("bottuns"     ).get(0);
		Color btnBackColor     = theme.get("bottuns"     ).get(1);


        this.setForeground(titleForeColor);
        this.setBackground(background);
    
        this.jListAretes            .setForeground         (saisiForeColor);
        this.jListAretes            .setBackground         (background    );
        this.jListAretes            .setSelectionForeground(background    );

        this.lblNoeudA         .setForeground(labelForeColor);
        this.lblNoeudA         .setBackground(labelBackColor);

        this.lblNoeudB         .setForeground(labelForeColor);
        this.lblNoeudB         .setBackground(labelBackColor);
        
        this.lbl2Sens          .setForeground(labelForeColor);
        this.lbl2Sens          .setBackground(labelBackColor);
        
        this.lblCouleur1       .setForeground(labelForeColor);
        this.lblCouleur2       .setBackground(labelBackColor);

        this.lblDistance       .setForeground(labelForeColor);
        this.lblDistance       .setBackground(labelBackColor);
        
        this.lblCouleur2       .setForeground(labelForeColor);
        this.lblCouleur2       .setBackground(labelBackColor);
        
        this.comboBoxListNoeudA.setBorder(null);
        this.comboBoxListNoeudA.setForeground(saisiForeColor);
        this.comboBoxListNoeudA.setBackground(saisiBackColor);
        
        this.comboBoxListNoeudB.setBorder(null);
        this.comboBoxListNoeudB.setForeground(saisiForeColor);
        this.comboBoxListNoeudB.setBackground(saisiBackColor);
        
        this.cb2Sens           .setOpaque    (false);
        this.cb2Sens           .setForeground(saisiForeColor);
        
        this.txtDistance       .setOpaque(true);
        this.txtDistance       .setBorder(null);
        this.txtDistance       .setForeground(placeholderColor);
        this.txtDistance       .setBackground(saisiBackColor  );
        this.txtDistance       .setForegroundColor (saisiForeColor  );
        this.txtDistance       .setPlaceholderColor(placeholderColor);
        this.txtDistance       .setDisabledTextColor(new Color(255, 0, 0));
        
        this.btnCouleur1       .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnCouleur1       .setForeground(btnForeColor);
        this.btnCouleur1       .setBackground(btnBackColor);
        
        this.btnCouleur2       .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnCouleur2       .setForeground(btnForeColor);
        this.btnCouleur2       .setBackground(btnBackColor);
        
        this.btnAjouter        .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnAjouter        .setForeground(btnForeColor);
        this.btnAjouter        .setBackground(btnBackColor);
        
        this.btnSupprimer      .setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.btnSupprimer      .setForeground(btnForeColor);
        this.btnSupprimer      .setBackground(btnBackColor);
    }

	public void envoyerCouleur(Color c)
	{
		if (this.couleurAttendu == 1)
		{
			this.couleur1 = c;
			this.btnCouleur1.setBackground(c);
		}
		else
		{
			this.couleur2 = c;
			this.btnCouleur2.setBackground(c);
		}
	}

}