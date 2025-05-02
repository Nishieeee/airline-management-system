package com.mycompany.airlinesgui.View;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.mycompany.airlinesgui.Controller.CreateAirport;
import com.mycompany.airlinesgui.Model.Airport;
import com.mycompany.airlinesgui.Model.Database;

public class AddNewAirport {
	
	public AddNewAirport(Database database, SidePanel sPanel, int index) {
		JFrame frame = new JFrame(350, 225);
		
		JPanel panel = new JPanel(new GridLayout(3, 1, 15, 15));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		panel.add(new JLabel("Add new Airport", 25, Constants.blue, 1));
		JTextField city = new JTextField("City", 15);
		panel.add(city);
		JButton submit = new JButton("Submit", 18, 18);
		panel.add(submit);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		panel.requestFocus();
		
		submit.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				 if (city.isEmpty()) {
					 new Alert("Please enter city");
					 return;
				 }
				 Airport a = new Airport();
				 a.setCity(city.getText().toString());
				 if (new CreateAirport(database, a).isCreated()) {
					 frame.dispose();
					 // To refresh data
					 sPanel.setSelected(sPanel.getSideButtons()[index]);
				 }
			}
		});
	}

}
