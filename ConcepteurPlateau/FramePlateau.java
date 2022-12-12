import javax.swing.*;
import java.awt.BorderLayout;

public class FramePlateau extends JFrame
{
	private ControleurGUI ctrl;
	
	private JPanel panelJoueurs;
	
	public FramePlateau(ControleurGUI ctrl)
	{
		this.ctrl = ctrl;

		this.setTitle("Générateur de plateau");
		this.setLocation(50, 50);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		// Positionnement du composent
		this.add(this.panelJoueurs, BorderLayout.NORTH);

		this.pack();
		this.setVisible ( true );
	}

	public void afficherPopUp(String message)
	{
		JOptionPane.showMessageDialog(this, message);
	}
}