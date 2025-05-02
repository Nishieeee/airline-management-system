package com.mycompany.airlinesgui.View;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.mycompany.airlinesgui.Model.Flight;

public class ShowFlightPassengers {
	
	public ShowFlightPassengers(Flight f) {
		JFrame frame = new JFrame(700, 625);
		JPanel panel = new JPanel(new BorderLayout(15, 15));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		panel.add(new JLabel("Flight Passengers", 25, Constants.blue, 1)
				, BorderLayout.NORTH);
		
		String[] header = {"ID", "Name", "Tel", "Email"};
		String[][] data = new String[f.getPassengers().length][4];
		for (int i=0;i<f.getPassengers().length;i++) {
			if (f.getPassengers()[i]!=null)
				data[i] = f.getPassengers()[i].getData();
		}
		
		panel.add(new JScrollPane(new JTable(data, header)), BorderLayout.CENTER);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}

}
