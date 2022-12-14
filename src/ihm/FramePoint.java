package ihm;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import controleur.Controleur;

public class FramePoint extends JFrame
{
    private Controleur ctrl;
    private JPanel panelPoint;

    private JTable tablePoint;
    
    public FramePoint(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setTitle("Modifier les points");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        /*PANEL POINT */
        this.panelPoint = new JPanel();
        
        this.tablePoint = new JTable();


        this.setVisible(false);
        
    }
}
