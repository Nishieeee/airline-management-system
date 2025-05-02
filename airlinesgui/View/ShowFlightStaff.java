package com.mycompany.airlinesgui.View;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.mycompany.airlinesgui.Model.Flight;

public class ShowFlightStaff {

	public ShowFlightStaff(Flight f) {
		JFrame frame = new JFrame(700, 625);
		JPanel panel = new JPanel(new BorderLayout(15, 15));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		panel.add(new JLabel("Flight Staff", 25, Constants.blue, 1)
				, BorderLayout.NORTH);
		
		String[] header = {"ID", "Name", "Tel", "Email", "Salary", "Job Title"};
		String[][] data = new String[f.getStaff().length][6];
		if (f.getStaff().length==10) {
			for (int i=0;i<f.getStaff().length;i++) {
				if (f.getStaff()[i]!=null) data[i] = f.getStaff()[i].getData();
			}
		}
		
		panel.add(new JScrollPane(new JTable(data, header)), BorderLayout.CENTER);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
}
