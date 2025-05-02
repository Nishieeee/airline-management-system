package com.mycompany.airlinesgui.View;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.mycompany.airlinesgui.Controller.CreatePassenger;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Passenger;

public class AddNewPassenger {
	
	public AddNewPassenger(Database database, SidePanel sPanel, int index) {
		
		// First Name, Last Name, Tel, Email
		JFrame frame = new JFrame(350, 450);
		
		JPanel panel = new JPanel(new GridLayout(6, 1, 15, 15));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		panel.add(new JLabel("Add new Passenger", 25, Constants.blue, 1));
		JTextField firstName = new JTextField("First Name", 15);
		panel.add(firstName);
		JTextField lastName = new JTextField("Last Name", 15);
		panel.add(lastName);
		JTextField tel = new JTextField("Phone Number", 15);
		panel.add(tel);
		JTextField email = new JTextField("Email", 15);
		panel.add(email);
		JButton submit = new JButton("Submit", 18, 18);
		panel.add(submit);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		panel.requestFocus();
		
		submit.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (firstName.isEmpty()) {
					 new Alert("Please enter first name");
					 return;
				 }
				 if (lastName.isEmpty()) {
					 new Alert("Please enter last name");
					 return;
				 }
				 if (tel.isEmpty()) {
					 new Alert("Please enter phone number");
					 return;
				 }
				 if (email.isEmpty()) {
					 new Alert("Please enter email");
					 return;
				 }
				 Passenger p = new Passenger();
				 p.setFirstName(firstName.getText());
				 p.setLastName(lastName.getText());
				 p.setTel(tel.getText());
				 p.setEmail(email.getText());
				 if (new CreatePassenger(database, p).isCreated()) {
					 frame.dispose();
					 // To refresh data
					 sPanel.setSelected(sPanel.getSideButtons()[index]);
				 }
			}
		});
		
		
	}

}
