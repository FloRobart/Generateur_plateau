package ihm;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import java.awt.BorderLayout;
import controleur.Controleur;
import metier.Noeud;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class PanelNoeud extends JPanel implements KeyListener, MouseListener
{
    private Controleur ctrl;

    private JList<String>      listNoeuds;
    
    private JTextField txtPosX;
    private JTextField txtPosY;
    private JTextField txtNom;
    private JTextField txtPosNomX;
    private JTextField txtPosNomY;
    private JButton    btnCouleur;

    private JButton    btnAjouter;
    private JButton    btnSupprimer;

    private Color      couleur;

    private ListModel<String>  listModel;
    private List<Noeud>       noeuds;

    public PanelNoeud(Controleur ctrl) 
    {
        this.ctrl = ctrl;
        this.setBackground(new Color(68, 71, 90));
        this.setLayout(new BorderLayout());

        /*Panel liste villes */
        JPanel panelListe = new JPanel();
        panelListe.setBackground(new Color(68, 71, 90));


        this.noeuds = this.ctrl.getMetier().getNoeuds();
        this.listModel = new DefaultListModel<String>();

        for (Noeud n : this.noeuds) {
            ((DefaultListModel<String>) this.listModel).addElement(n.getNom());
        }
        
        this.listNoeuds = new JList<String>(listModel);

        this.listNoeuds.setBackground(new Color(58, 60, 76));
        this.listNoeuds.setForeground(Color.WHITE);
        this.listNoeuds.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(this.listNoeuds);

        panelListe.add(scrollPane);
  
        
        /*Panel infos villes */
        JPanel panelInfos = new JPanel();
        panelInfos.setBackground(new Color(68, 71, 90));
        
        GroupLayout layout = new GroupLayout(panelInfos);
        panelInfos.setLayout(layout);

        this.txtPosX = new JTextField();
        this.txtPosX.setBackground(new Color(58, 60, 76));
        this.txtPosX.setForeground(Color.GRAY);

        this.txtPosX.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
               if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE ) {
                  txtPosX.setEditable(true);
               }else
               {
                  txtPosX.setEditable(false);
               }
               
            }
         });


        this.txtPosY = new JTextField(8);
        this.txtPosY.setBackground(new Color(58, 60, 76));
        this.txtPosY.setForeground(Color.GRAY);
        this.txtPosY.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
               if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE ) {
                  txtPosY.setEditable(true);
               }else
               {
                  txtPosY.setEditable(false);
               }
               
            }
         });


        this.txtNom = new JTextField(8);
        this.txtNom.setBackground(new Color(58, 60, 76));
        this.txtNom.setForeground(Color.GRAY);

        this.txtPosNomX = new JTextField();
        this.txtPosNomX.setBackground(new Color(58, 60, 76));
        this.txtPosNomX.setForeground(Color.GRAY);

        this.txtPosNomX.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
               if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE ) {
                  txtPosNomX.setEditable(true);
               }else
               {
                  txtPosNomX.setEditable(false);
               }
               
            }
         });



        this.txtPosNomY = new JTextField(8);
        this.txtPosNomY.setBackground(new Color(58, 60, 76));
        this.txtPosNomY.setForeground(Color.GRAY);

        this.txtPosNomY.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
               if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE ) {
                  txtPosNomY.setEditable(true);
               }else
               {
                  txtPosNomY.setEditable(false);
               }
               
            }
         });

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
            addComponent(labelNom).addComponent(labelPos).addComponent(labelPosNom).addComponent(labelCouleur));

        hGroup.addGroup(layout.createParallelGroup().
            addComponent(txtNom).addComponent(txtPosX).addComponent(txtPosNomX).addComponent(btnCouleur));
        
        hGroup.addGroup(layout.createParallelGroup().
            addComponent(txtPosY).addComponent(txtPosNomY));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(labelNom).addComponent(txtNom));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(labelPos).addComponent(txtPosX).addComponent(txtPosY));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(labelPosNom).addComponent(txtPosNomX).addComponent(txtPosNomY));
        
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
            addComponent(labelCouleur).addComponent(btnCouleur));
        
        layout.setVerticalGroup(vGroup);

        /*Panel boutons */
        JPanel panelBoutons = new JPanel();
        panelBoutons.setBackground(new Color(68, 71, 90));
        
        this.btnAjouter = new JButton("Ajouter");
        this.btnAjouter.setBackground(new Color(58, 60, 76));
        this.btnAjouter.setForeground(Color.WHITE);
        this.btnAjouter.addActionListener(e -> {
            ajouterNoeud();
        });
        
        this.btnSupprimer = new JButton("Supprimer");
        this.btnSupprimer.setBackground(new Color(58, 60, 76));
        this.btnSupprimer.setForeground(Color.WHITE);
        this.btnSupprimer.addActionListener(e -> {
            supprimerNoeud();
        });

        panelBoutons.add(this.btnAjouter);
        panelBoutons.add(this.btnSupprimer);

        /*Ajout des panels*/
        this.add(panelListe, BorderLayout.WEST);
        this.add(panelInfos, BorderLayout.CENTER);
        this.add(panelBoutons, BorderLayout.SOUTH);



    }

    /**
     * Methode permettant de supprimer un noeud
     */
    private void supprimerNoeud() 
    {
        String nom = this.listModel.getElementAt(this.listNoeuds.getSelectedIndex());
        this.ctrl.getMetier().supprimerNoeud(nom);
        ((DefaultListModel<String>) this.listModel).removeElement(nom);
    }

    /**
     * Methode permettant d'ajouter un noeud
     */
    private void ajouterNoeud() 
    {
        String nom = this.txtNom.getText();
        int posX = Integer.parseInt(this.txtPosX.getText());
        int posY = Integer.parseInt(this.txtPosY.getText());
        int posNomX = Integer.parseInt(this.txtPosNomX.getText());
        int posNomY = Integer.parseInt(this.txtPosNomY.getText());

        ((DefaultListModel<String>) this.listModel).addElement(nom);

        this.ctrl.getMetier().ajouterNoeud(nom, posX, posY, posNomX, posNomY, this.couleur);

        this.txtNom.setText("");
        this.txtPosX.setText("");
        this.txtPosY.setText("");
        this.txtPosNomX.setText("");
        this.txtPosNomY.setText("");
        
    }

    private void selectColor() 
    {
        this.couleur = JColorChooser.showDialog(this, "Choisir une couleur", Color.BLACK);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
