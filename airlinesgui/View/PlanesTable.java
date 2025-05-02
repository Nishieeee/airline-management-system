package com.mycompany.airlinesgui.View;

import java.util.ArrayList;

import com.mycompany.airlinesgui.Controller.ReadAllPlanes;
import com.mycompany.airlinesgui.Model.Airplane;
import com.mycompany.airlinesgui.Model.Database;

@SuppressWarnings("serial")
public class PlanesTable extends JTable {
	
	public PlanesTable(Database db, SidePanel sPanel) {
		String[] header = {"ID", "Economy Capacity", "Business Capacity", "Model"};
		
		ArrayList<Airplane> planes = new ReadAllPlanes(db).getPlanes();
		String[][] data = new String[planes.size()][4];
		for (int i=0;i<planes.size();i++) {
			data[i] = planes.get(i).getData();
		}
		
		setTableData(data, header);
		addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int row = rowAtPoint(e.getPoint());
				int col = columnAtPoint(e.getPoint());
				if (row>=0 && col>=0 && e.getClickCount()==2) {
					new PlaneEditor(db, planes.get(row), sPanel);
				}
			}
		});
		setColWidths(new int[] {10, 40, 40, 100});
	}

}
