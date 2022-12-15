package ihm;

import java.awt.Color;
import java.awt.BorderLayout;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/*Avec la JList, il faudra utiliser le MouseListener avec MousePressed */

public class PanelArrete extends JPanel implements KeyListener
{
    
    private JList<String>     listArretes;
    
    private JComboBox<String> cbA;
    private JComboBox<String> cbB;
    private JButton           btnCoul;
    private JTextField        txtDistance;

    private JButton           btnAjouter;
    private JButton           btnSupprimer;

    public PanelArrete()
    {
        this.setBackground(new Color(68, 71, 90));
        this.setLayout(new BorderLayout());

        /*Panel liste aretes */
        JPanel panelListe = new JPanel();
        panelListe.setBackground(new Color(68, 71, 90));

        String[] data = {"arete 1", "arete 2", "arete 3", "arete 4", "arete 5", "arete 6", "arete 7", "arete 8", "arete 9", "arete 10"};
        this.listArretes = new JList<String>(data);

        this.listArretes.setBackground(new Color(58, 60, 76));
        this.listArretes.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(this.listArretes);
        panelListe.add(scrollPane);



        /*Panel info aretes */
        JPanel panelInfos = new JPanel();
        panelInfos.setBackground(new Color(68, 71, 90));

        GroupLayout layout = new GroupLayout(panelInfos);
        panelInfos.setLayout(layout);

        JLabel lblNoeudA, lblNoeudB, lblCoul, lblDistance;
        lblNoeudA = new JLabel("Noeud A");
        lblNoeudA.setForeground(Color.WHITE);
        lblNoeudB = new JLabel("Noeud B");
        lblNoeudB.setForeground(Color.WHITE);
        lblCoul = new JLabel("Couleur");
        lblCoul.setForeground(Color.WHITE);
        lblDistance = new JLabel("Distance");
        lblDistance.setForeground(Color.WHITE);

        this.txtDistance = new JTextField();
        this.txtDistance.setBackground(new Color(58, 60, 76));
        this.txtDistance.setForeground(Color.GRAY);

        this.txtDistance.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
               if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE ) {
                  txtDistance.setEditable(true);
               }else
               {
                  txtDistance.setEditable(false);
               }
               
            }
         });


        String[] tabNoeudA = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
        String[] tabNoeudB = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};

        cbA = new JComboBox<String>(tabNoeudA);
        cbB = new JComboBox<String>(tabNoeudB);

        cbA.setVisible(true);
        cbB.setVisible(true);

        this.btnCoul = new JButton("Couleur");
        add(this.btnCoul);
        this.btnCoul.addActionListener(e -> {
            selectColor();
        });

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup().
                addComponent(lblNoeudA).addComponent(lblNoeudB).addComponent(lblCoul).addComponent(lblDistance));
        
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(cbA).addComponent(cbB).addComponent(this.btnCoul).addComponent(txtDistance));

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblNoeudA).addComponent(cbA));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblNoeudB).addComponent(cbB));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblCoul).addComponent(this.btnCoul));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblDistance).addComponent(txtDistance));

        layout.setVerticalGroup(vGroup);

        /*Panel boutons */
        JPanel panelBoutons = new JPanel();
        panelBoutons.setBackground(new Color(68, 71, 90));

        this.btnAjouter = new JButton("Ajouter");
        this.btnAjouter.setBackground(new Color(58, 60, 76));
        this.btnAjouter.setForeground(Color.WHITE);

        this.btnSupprimer = new JButton("Supprimer");
        this.btnSupprimer.setBackground(new Color(58, 60, 76));
        this.btnSupprimer.setForeground(Color.WHITE);

        panelBoutons.add(this.btnAjouter);
        panelBoutons.add(this.btnSupprimer);


        /*Ajout des panels*/
        this.add(panelListe, BorderLayout.WEST);
        this.add(panelInfos, BorderLayout.CENTER);
        this.add(panelBoutons, BorderLayout.SOUTH);
            
    }


    private void selectColor() 
    {
        Color color = JColorChooser.showDialog(this, "Choisir une couleur", Color.BLACK);
        System.out.println(color);
    }


    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    
}
