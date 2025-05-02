package com.mycompany.airlinesgui.View;

import java.util.ArrayList;

import com.mycompany.airlinesgui.Controller.ReadAllFlights;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Flight;

@SuppressWarnings("serial")
public class FlightsTable extends JTable {
	
	public FlightsTable(Database db, SidePanel sPanel) {	
		String[] header = {"ID", "Airplane", "Origin", "Destination",
				"Deptarture", "Arrival", "Status", "Eco",
				"Bus"};
		
		ArrayList<Flight> flights = new ReadAllFlights(db).getFlights();
		String[][] data = new String[flights.size()][9];
		for (int i=0;i<flights.size();i++) {
			data[i] = flights.get(i).getData();
		}
		
		setTableData(data, header);
		addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int row = rowAtPoint(e.getPoint());
				int col = columnAtPoint(e.getPoint());
				if (row>=0 && col>=0 && e.getClickCount()==2) {
					new FlightOptions(flights.get(row), db, sPanel);
				}
			}
		});
		setColWidths(new int[] {5, 70, 70, 70, 70, 70, 50, 5, 5});
	}

}
