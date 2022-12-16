package ihm;

import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import controleur.Controleur;
import metier.CarteObjectif;
import metier.Noeud;

public class PanelAjoutObjectif extends JPanel implements KeyListener, MouseListener
{
    private Controleur ctrl;
    private JList<String>     listObjectif;
    
    private JComboBox<String> cbA;
    private JComboBox<String> cbB;
    private JTextField        txtPoint;
    private JButton           btnAjout;
    private JButton           btnSupp;

    private ListModel<String>   listModel;
    private List<CarteObjectif> objectifs;

    private List<Noeud>         lstNoeudA;
    private List<Noeud>         lstNoeudB;

    public PanelAjoutObjectif(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setBackground(new Color(68, 71, 90));
        this.setLayout(new BorderLayout());

        /*Panel liste objectifs */
        JPanel panelListe = new JPanel();
        panelListe.setBackground(new Color(68, 71, 90));
        
        this.objectifs = this.ctrl.getMetier().getCarteObjectif();
        this.listModel = new DefaultListModel<String>();

        for (CarteObjectif c : this.objectifs) {
            ((DefaultListModel<String>) this.listModel).addElement(c.getNoeud1().getNom() + "-" + c.getNoeud2().getNom());
        }

        this.listObjectif = new JList<String>(this.listModel);

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

        this.lstNoeudA = this.ctrl.getMetier().getNoeuds();
        this.lstNoeudB = this.ctrl.getMetier().getNoeuds();

        String[] tabNoeudA = new String[lstNoeudA.size()];
        String[] tabNoeudB = new String[lstNoeudB.size()];

        for(int cpt =0; cpt < lstNoeudA.size(); cpt++)
        {
            tabNoeudA[cpt] = lstNoeudA.get(cpt).getNom();
            tabNoeudB[cpt] = lstNoeudB.get(cpt).getNom();
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
        this.btnAjout.addActionListener(e -> {
            ajouterObjectif();
        });

        this.btnSupp = new JButton("Supprimer");
        this.btnSupp.setBackground(new Color(58, 60, 76));
        this.btnSupp.setForeground(Color.WHITE);
        this.btnSupp.addActionListener(e -> {
            supprimerObjectif();
        });

        panelBoutons.add(this.btnAjout);
        panelBoutons.add(this.btnSupp);

        /*Panel global */
        this.add(panelListe, BorderLayout.WEST);
        this.add(panelInfos, BorderLayout.CENTER);
        this.add(panelBoutons, BorderLayout.SOUTH);

        this.listObjectif.addMouseListener(this);
    }

    private void supprimerObjectif() 
    {
        String[] noms = this.listModel.getElementAt(this.listObjectif.getSelectedIndex()).split("-");

        this.ctrl.getMetier().supprimerObjectif(noms[0], noms[1]);

        ((DefaultListModel<String>) this.listModel).removeElement(noms[0] + "-" + noms[1]);
        this.effacerForm();
    }

    private void ajouterObjectif()
    {
        String nom1     = (String) this.cbA.getSelectedItem();
        String nom2     = (String) this.cbB.getSelectedItem();
        int    point = Integer.parseInt(this.txtPoint.getText());

        ((DefaultListModel<String>) this.listModel).addElement(nom1 + "-" + nom2);
        if(!nom1.equals(nom2))
        {
            this.ctrl.getMetier().ajouterObjectif(nom1, nom2, point);
        }
        
       this.effacerForm();
    }

    private void effacerForm() 
    {
        this.cbA.setSelectedIndex(0);
        this.cbB.setSelectedIndex(0);
        this.txtPoint.setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        if(e.getSource() == this.listObjectif)
        {
            String[] noms = this.listModel.getElementAt(this.listObjectif.getSelectedIndex()).split("-");
            
            for(CarteObjectif c : this.objectifs)
            {
                if(c.getNoeud1().getNom().equals(noms[0]) && c.getNoeud2().getNom().equals(noms[1]))
                {
                    this.cbA.setSelectedItem(c.getNoeud1());
                    this.cbB.setSelectedItem(c.getNoeud2());
                    this.txtPoint.setText(String.valueOf(c.getPoints()));
                }
            }
        }  
        
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
