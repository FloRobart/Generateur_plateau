package ihm.customComponent;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import controleur.Controleur;

public class GrillePoints extends AbstractTableModel
{
	private Controleur ctrl;

	private String[]   tabEntetes;
	private Object[][] tabDonnees;

	public GrillePoints (Controleur ctrl)
	{
		this.ctrl = ctrl;
		List<Integer> lstPoints = ctrl.getPoints();

		tabDonnees = new Object[lstPoints.size()][4];

		if (lstPoints.size() > 0)
			for ( int lig = 0 ; lig < lstPoints.size() ; lig++)
			{
				tabDonnees[lig][0] = lig + 1;
				tabDonnees[lig][1] = lstPoints.get(lig);
			}
		
		this.tabEntetes = new String[] { "Distance", "Points" };
	}

	public int    getColumnCount()                 { return this.tabEntetes.length;      }
	public int    getRowCount   ()                 { return this.tabDonnees.length;      }
	public String getColumnName (int col)          { return this.tabEntetes[col];        }
	public Object getValueAt    (int row, int col) { return this.tabDonnees[row][col];   }
	public Class  getColumnClass(int c)            { return getValueAt(0, c).getClass(); }

	public boolean isCellEditable(int row, int col)
	{
		return col == 1;
	}

	public void setValueAt(Object value, int row, int col)
	{
		this.ctrl.setPoint(row, (Integer) value);
		this.tabDonnees[row][col] = value;
		this.fireTableCellUpdated(row, col);
	}
}
