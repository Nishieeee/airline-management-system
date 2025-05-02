package com.mycompany.airlinesgui.View;

import java.util.ArrayList;

import com.mycompany.airlinesgui.Controller.ReadAllAirports;
import com.mycompany.airlinesgui.Model.Airport;
import com.mycompany.airlinesgui.Model.Database;

@SuppressWarnings("serial")
public class AirportsTable extends JTable {
	
	public AirportsTable(Database db, SidePanel sPanel) {
		String[] header = {"ID", "City"};
		
		ArrayList<Airport> airports = new ReadAllAirports(db).getAirports();
		String[][] data = new String[airports.size()][2];
		for (int i=0;i<airports.size();i++) {
			data[i] = airports.get(i).getData();
		}
		
		setTableData(data, header);
		addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int row = rowAtPoint(e.getPoint());
				int col = columnAtPoint(e.getPoint());
				if (row>=0 && col>=0 && e.getClickCount()==2) {
					new AirportEditor(db, airports.get(row), sPanel);
				}
			}
		});
		setColWidths(new int[] {10, 100});
	}

}
