package ihm.frames;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controleur.Controleur;
import ihm.customComponent.GrillePoints;


public class FramePoint extends JFrame implements ActionListener
{
	private Controleur ctrl;

	private JTable      tblPoint;
	private JScrollPane spPoint;
	private JButton     btnAjouter;
	private JButton     btnSupprimer;
	private JButton     btnOk;
	
	public FramePoint(Controleur ctrl)
	{
		this.ctrl = ctrl;

		this.setTitle("Modifier les points");
		this.setSize(500, 200);
		this.setLocation(500, 300);
		this.setLayout(new BorderLayout());

		// Création des panels
		JPanel panelPoint  = new JPanel(new BorderLayout());
		JPanel panelButton = new JPanel();

		panelPoint .setBackground(new Color(68, 71, 90));
		panelButton.setBackground(new Color(68, 71, 90));
		
		// Création des composants
		this.tblPoint = new JTable(new GrillePoints(this.ctrl));
		this.tblPoint.setFillsViewportHeight(true);

		this.spPoint = new JScrollPane(this.tblPoint);
		this.spPoint.setVerticalScrollBar(new JScrollBar());
		this.spPoint.setWheelScrollingEnabled(true);
		this.spPoint.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		this.btnAjouter = new JButton("Ajouter");
		this.btnAjouter.setBackground(new Color(68, 71, 90));
		this.btnAjouter.setForeground(Color.WHITE);

		this.btnSupprimer = new JButton("Supprimer");
		this.btnSupprimer.setBackground(new Color(68, 71, 90));
		this.btnSupprimer.setForeground(Color.WHITE);

		this.btnOk = new JButton("Ok");
		this.btnOk.setBackground(new Color(68, 71, 90));
		this.btnOk.setForeground(Color.WHITE);

		// Positionnement des composants
		panelPoint.add(this.spPoint, BorderLayout.CENTER);

		panelButton.add(this.btnAjouter);
		panelButton.add(this.btnSupprimer);
		panelButton.add(this.btnOk);

		this.add(panelPoint , BorderLayout.CENTER);
		this.add(panelButton, BorderLayout.SOUTH );

		// Activation des composants
		this.btnAjouter  .addActionListener(this);
		this.btnSupprimer.addActionListener(this);
		this.btnOk       .addActionListener(this);

		this.setVisible(true);        
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btnAjouter)
		{   
			this.ctrl.ajouterPoint();
			this.tblPoint.setModel(new GrillePoints(ctrl));
		}
		if (e.getSource() == this.btnSupprimer) 
		{
			this.ctrl.supprimerPoint();
			this.tblPoint.setModel(new GrillePoints(ctrl));
		}

		if (e.getSource() == this.btnOk) 
		{
			this.dispose();
		}

	}
}

