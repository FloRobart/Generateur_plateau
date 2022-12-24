package ihm;
import java.awt.dnd.*; //Drag and Drop pakcage
import java.awt.dnd.DragGestureListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.datatransfer.*;

import controleur.Controleur;


public class PGPanelAjouterElements extends JPanel 
{
    private Controleur ctrl;

    private JButton btnListElements;
    private JLabel imgArrete;
    private JLabel imgNoeud;
    private JLabel imgObjectif;
    private JLabel lblAjouterElements;
    private JLabel lblArrete;
    private JLabel lblNoeud;
    private JLabel lblObjectif;


    public PGPanelAjouterElements(Controleur ctrl)
    {
        this.ctrl = ctrl;

        initComponents();
        dragAndDropSettings();
    }

    private void dragAndDropSettings() 
    {
        DragSource ds = new DragSource();
        MonDragGestureListener dlistener = new MonDragGestureListener();
        ds.createDefaultDragGestureRecognizer(imgNoeud, DnDConstants.ACTION_COPY, dlistener);
    }


    private void initComponents()
    {
        this.lblAjouterElements = new JLabel ();
        this.imgArrete          = new JLabel ();
        this.imgNoeud           = new JLabel ();
        this.imgObjectif        = new JLabel ();
        this.lblNoeud           = new JLabel ();
        this.lblArrete          = new JLabel ();
        this.lblObjectif        = new JLabel ();
        this.btnListElements    = new JButton();

        this.setPreferredSize(new Dimension(403, 215));

        this.lblAjouterElements.setText(" Ajouter éléments");

        this.imgArrete.setHorizontalAlignment(SwingConstants.CENTER);            
        this.imgArrete.setIcon(new ImageIcon(getClass().getResource("/images/arete.png")));

        this.imgNoeud.setHorizontalAlignment(SwingConstants.CENTER);
        this.imgNoeud.setIcon(new ImageIcon(getClass().getResource("/images/noeud.png")));

        this.imgObjectif.setHorizontalAlignment(SwingConstants.CENTER);
        this.imgObjectif.setIcon(new ImageIcon(getClass().getResource("/images/objectif.png")));

        this.lblNoeud.setText("Noeud");
        this.lblNoeud.setFont(new Font("Segoe UI", 1, 12));
        this.lblNoeud.setHorizontalAlignment(SwingConstants.CENTER);

        this.lblArrete.setText("Arrête");
        this.lblArrete.setFont(new Font("Segoe UI", 1, 12));
        this.lblArrete.setHorizontalAlignment(SwingConstants.CENTER);

        this.lblObjectif.setText("Objectifs");
        this.lblObjectif.setFont(new Font("Segoe UI", 1, 12));
        this.lblObjectif.setHorizontalAlignment(SwingConstants.CENTER);

        this.btnListElements.setText("List éléments");
        this.btnListElements.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnListElementsActionPerformed(e);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.lblAjouterElements, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(this.imgNoeud, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.lblNoeud, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(this.btnListElements, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(this.imgArrete, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.lblArrete, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(this.imgObjectif, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.lblObjectif, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
            .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(this.lblAjouterElements, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(this.imgArrete, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.imgNoeud, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.imgObjectif, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18,18,18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.lblArrete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(this.lblObjectif)
                    .addComponent(this.lblNoeud))
                .addGap(18, 18, 18)
                .addComponent(this.btnListElements, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        this.appliquerTheme();
    }

    private void btnListElementsActionPerformed(ActionEvent evt){}                                               

    
    class MonDragGestureListener implements DragGestureListener
    {
        public void dragGestureRecognized(DragGestureEvent event) 
        {
            JLabel label = (JLabel) event.getComponent();
            final Icon ico = label.getIcon();


            Transferable transferable = new Transferable()
            {
                @Override
                public DataFlavor[] getTransferDataFlavors()
                {
                    return new DataFlavor[]{DataFlavor.imageFlavor};
                }

                @Override
                public boolean isDataFlavorSupported(DataFlavor flavor)
                {
                    if (!isDataFlavorSupported(flavor))
                    {
                        return false;
                    }
                    return true;
                }

                @Override
                public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException
                {
                    return ico;
                }
            };
            event.startDrag(null, transferable);
        }
    }


    /**
     * Applique le thème à tout les composants du panel
     */
    public void appliquerTheme()
	{
		Color background     = this.ctrl.getTheme().get("background").get(0);
        Color titleForeColor = this.ctrl.getTheme().get("titles"    ).get(0);
		Color titleBackColor = this.ctrl.getTheme().get("titles"    ).get(1);
        Color labelForeColor = this.ctrl.getTheme().get("labels"    ).get(0);
		Color labelBackColor = this.ctrl.getTheme().get("labels"    ).get(1);
        Color btnForeColor   = this.ctrl.getTheme().get("bottuns"   ).get(0);
		Color btnBackColor   = this.ctrl.getTheme().get("bottuns"   ).get(1);

        this.setBackground(background);

        
        this.lblAjouterElements.setOpaque(true);
        this.lblAjouterElements.setBackground(titleBackColor);
        this.lblAjouterElements.setForeground(titleForeColor);

        this.lblNoeud.setBackground(labelBackColor);
        this.lblNoeud.setForeground(labelForeColor);

        this.lblArrete.setBackground(labelBackColor);
        this.lblArrete.setForeground(labelForeColor);
        
        this.lblObjectif.setBackground(labelBackColor);
        this.lblObjectif.setForeground(labelForeColor);

        this.btnListElements.setBorder(null);
        this.btnListElements.setBackground(btnBackColor);
        this.btnListElements.setForeground(btnForeColor);
	}
}

