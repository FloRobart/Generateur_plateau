package ihm;

import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import controleur.Controleur;
import metier.Noeud;

public class PanelAjoutObjectif extends JPanel implements ActionListener, KeyListener
{
    private Controleur ctrl;
    private JList<String>     listObjectif;
    
    private JComboBox<String> cbA;
    private JComboBox<String> cbB;
    private JTextField        txtPoint;
    private JButton           btnAjout;
    private JButton           btnSupp;

    public PanelAjoutObjectif(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setBackground(new Color(68, 71, 90));
        this.setLayout(new BorderLayout());

        /*Panel liste objectifs */
        JPanel panelListe = new JPanel();
        panelListe.setBackground(new Color(68, 71, 90));
        
        String[] data = { "objectif 1","objectif 2", "objectif 3","objectif 4","objectif 5","objectif 6", "objectif 7","objectif 8","objectif 9","objectif 10"};
        this.listObjectif = new JList<String>(data);

        this.listObjectif.setBackground(new Color(58, 60, 76));
        this.listObjectif.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(this.listObjectif);
        panelListe.add(scrollPane);
        
        /*Panel info objectifs */
        JPanel panelInfos = new JPanel();
        panelInfos.setBackground(new Color(68, 71, 90));

        GroupLayout layout = new GroupLayout(panelInfos);
        panelInfos.setLayout(layout);

        JLabel lblNoeudA, lblNoeudB, lblPoint;
        lblNoeudA = new JLabel("Noeud A");
        lblNoeudA.setForeground(Color.WHITE);
        lblNoeudB = new JLabel("Noeud B");
        lblNoeudB.setForeground(Color.WHITE);
        lblPoint = new JLabel("Point");
        lblPoint.setForeground(Color.WHITE);
       
        this.txtPoint = new JTextField();
        this.txtPoint.setBackground(new Color(58, 60, 76));
        this.txtPoint.setForeground(Color.GRAY);

        this.txtPoint.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
               if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE ) {
                  txtPoint.setEditable(true);
               }else
               {
                  txtPoint.setEditable(false);
               }
               
            }
         });

        List<Noeud> noeuds = this.ctrl.getMetier().getNoeuds();

        String[] tabNoeudA   = new String[noeuds.size()]; //{ "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
        String[] tabNoeudB   = new String[noeuds.size()]; //{ "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};

        for (Noeud noeud : noeuds)
        {
            tabNoeudA[noeud.getId() - 1] = noeud.getNom();
            tabNoeudB[noeud.getId() - 1] = noeud.getNom();
        }
        cbA = new JComboBox<String>(tabNoeudA);
        cbB = new JComboBox<String>(tabNoeudB);

        cbA.setVisible(true);
        cbB.setVisible(true);


        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup().
                addComponent(lblNoeudA).addComponent(lblNoeudB).addComponent(lblPoint));
        
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(cbA).addComponent(cbB).addComponent(txtPoint));

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblNoeudA).addComponent(cbA));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblNoeudB).addComponent(cbB));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblPoint).addComponent(txtPoint));

        layout.setVerticalGroup(vGroup);

        /*Panel boutons */
        JPanel panelBoutons = new JPanel();
        panelBoutons.setBackground(new Color(68, 71, 90));

        this.btnAjout = new JButton("Ajouter");
        this.btnAjout.setBackground(new Color(58, 60, 76));
        this.btnAjout.setForeground(Color.WHITE);

        this.btnSupp = new JButton("Supprimer");
        this.btnSupp.setBackground(new Color(58, 60, 76));
        this.btnSupp.setForeground(Color.WHITE);

        panelBoutons.add(this.btnAjout);
        panelBoutons.add(this.btnSupp);

        /*Panel global */
        this.add(panelListe, BorderLayout.WEST);
        this.add(panelInfos, BorderLayout.CENTER);
        this.add(panelBoutons, BorderLayout.SOUTH);

        this.btnAjout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.btnAjout)
        {
            System.out.println("Ajout d'un objectif"); //a modifier
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

}
