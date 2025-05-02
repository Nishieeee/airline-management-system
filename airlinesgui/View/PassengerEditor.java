package com.mycompany.airlinesgui.View;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.mycompany.airlinesgui.Controller.DeletePassenger;
import com.mycompany.airlinesgui.Controller.EditPassenger;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Passenger;

public class PassengerEditor {
	
	public PassengerEditor(Database db, Passenger p, SidePanel sPanel) {
		JFrame frame = new JFrame(600, 370);
		
		JPanel panel = new JPanel(new GridLayout(5, 2, 15, 15));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		panel.add(new JLabel("First Name", 18, Constants.blue, 1));
		JTextField firstName = new JTextField("First Name", 15);
		panel.add(firstName);
		panel.add(new JLabel("Last Name", 18, Constants.blue, 1));
		JTextField lastName = new JTextField("Last Name", 15);
		panel.add(lastName);
		panel.add(new JLabel("Phone Number", 18, Constants.blue, 1));
		JTextField tel = new JTextField("Phone Number", 15);
		panel.add(tel);
		panel.add(new JLabel("Email", 18, Constants.blue, 1));
		JTextField email = new JTextField("Email", 15);
		panel.add(email);
		JButton delete = new JButton("Delete", 18, 18);
		panel.add(delete);
		JButton submit = new JButton("Submit", 18, 18);
		panel.add(submit);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		panel.requestFocus();
		
		firstName.setText(p.getFirstName());
		lastName.setText(p.getLastName());
		email.setText(p.getEmail());
		tel.setText(p.getTel());
		firstName.setForeground(Constants.black);
		lastName.setForeground(Constants.black);
		email.setForeground(Constants.black);
		tel.setForeground(Constants.black);
		
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
				 p.setFirstName(firstName.getText());
				 p.setLastName(lastName.getText());
				 p.setTel(tel.getText());
				 p.setEmail(email.getText());
				 if (new EditPassenger(db, p).isEdited()) {
					 frame.dispose();
					 // To refresh data
					 sPanel.setSelected(sPanel.getSideButtons()[1]);
				 }
			}
		});
		
		delete.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (new DeletePassenger(db, p).isDeleted()) {
					 frame.dispose();
					 // To refresh data
					 sPanel.setSelected(sPanel.getSideButtons()[1]);
				 }
			}
		});
	}

}
