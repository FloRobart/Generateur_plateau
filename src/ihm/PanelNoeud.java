package ihm;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.GroupLayout;
import java.awt.BorderLayout;
import controleur.Controleur;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelNoeud extends JPanel implements KeyListener
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

    public PanelNoeud(Controleur ctrl) 
    {
        this.ctrl = ctrl;
        this.setBackground(new Color(68, 71, 90));
        this.setLayout(new BorderLayout());

        /*Panel liste villes */
        JPanel panelListe = new JPanel();
        panelListe.setBackground(new Color(68, 71, 90));

        String[] data = {"villeefhkjgkblvn1", "ville2", "ville3", "ville4", "ville5", "ville6", "ville7", "ville8", "ville9", "ville10"};
        this.listNoeuds = new JList<String>(data);

        this.listNoeuds.setBackground(new Color(58, 60, 76));
        this.listNoeuds.setForeground(Color.WHITE);

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
               if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                  txtPosX.setEditable(true);
               } else {
                  txtPosX.setEditable(false);
               }
            }
         });



        this.txtPosY = new JTextField(8);
        this.txtPosY.setBackground(new Color(58, 60, 76));
        this.txtPosY.setForeground(Color.GRAY);

        this.txtNom = new JTextField(8);
        this.txtNom.setBackground(new Color(58, 60, 76));
        this.txtNom.setForeground(Color.GRAY);

        this.txtPosNomX = new JTextField();
        this.txtPosNomX.setBackground(new Color(58, 60, 76));
        this.txtPosNomX.setForeground(Color.GRAY);

        this.txtPosNomY = new JTextField(8);
        this.txtPosNomY.setBackground(new Color(58, 60, 76));
        this.txtPosNomY.setForeground(Color.GRAY);

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

    private void supprimerNoeud() {
    }

    private void ajouterNoeud() {
    }

    private void selectColor() 
    {
        Color color = JColorChooser.showDialog(this, "Choisir une couleur", Color.BLACK);
        System.out.println(color);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
