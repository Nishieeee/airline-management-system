package com.mycompany.airlinesgui.View;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.mycompany.airlinesgui.Controller.DeleteAirport;
import com.mycompany.airlinesgui.Controller.EditAirport;
import com.mycompany.airlinesgui.Model.Airport;
import com.mycompany.airlinesgui.Model.Database;

public class AirportEditor {
	
	public AirportEditor(Database db, Airport a, SidePanel sPanel) {
		JFrame frame = new JFrame(600, 180);
		
		JPanel panel = new JPanel(new GridLayout(2, 2, 15, 15));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		panel.add(new JLabel("City:", 18, Constants.black, 1));
		JTextField city = new JTextField("City", 15);
		panel.add(city);
		JButton delete = new JButton("Delete", 18, 18);
		panel.add(delete);
		JButton submit = new JButton("Submit", 18, 18);
		panel.add(submit);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		panel.requestFocus();
		
		city.setText(a.getCity());
		city.setForeground(Constants.black);
		
		submit.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (city.isEmpty()) {
					 new Alert("Please enter city");
					 return;
				 }
				 a.setCity(city.getText());
				 if (new EditAirport(db, a).isEdited()) {
					 frame.dispose();
					 // To refresh data
					 sPanel.setSelected(sPanel.getSideButtons()[4]);
				 }
			}
		});
		
		delete.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (new DeleteAirport(db, a).isDeleted()) {
					 frame.dispose();
					 // To refresh data
					 sPanel.setSelected(sPanel.getSideButtons()[4]);
				 }
			}
		});
	}

}
