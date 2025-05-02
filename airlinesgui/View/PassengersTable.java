package com.mycompany.airlinesgui.View;

import java.util.ArrayList;

import com.mycompany.airlinesgui.Controller.ReadAllPassengers;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Passenger;

@SuppressWarnings("serial")
public class PassengersTable extends JTable {
	
	public PassengersTable(Database db, SidePanel sPanel) {
		String[] header = {"ID", "Name", "Tel", "Email"};
		
		ArrayList<Passenger> passengers = new ReadAllPassengers(db)
				.getPassengers();
		String[][] data = new String[passengers.size()][4];
		for (int i=0;i<passengers.size();i++) {
			data[i] = passengers.get(i).getData();
		}
		
		setTableData(data, header);
		addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int row = rowAtPoint(e.getPoint());
				int col = columnAtPoint(e.getPoint());
				if (row>=0 && col>=0 && e.getClickCount()==2) {
					new PassengerEditor(db, passengers.get(row), sPanel);
				}
			}
		});
		setColWidths(new int[] {10, 80, 80, 80});
	}

}
