package com.mycompany.airlinesgui.View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.mycompany.airlinesgui.Controller.ReadAllPassengers;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Flight;
import com.mycompany.airlinesgui.Model.Passenger;

public class BookFlight {
	
	private Passenger passenger = null;
	
	public BookFlight(Flight f, Database db, SidePanel sPanel) {
		// Passenger - Business/Economy - NumOfSeats
		// Passenger (Selection by name) ==> {tel, email} (3 rows * 2 Cols)
		// Business/Economy (JComboBox) (1 row * 2 cols)
		// NumOfSeats (1 row * 2 cols)
		// + 1 row for title + 1 row for submit button ==> (BorderLayout)
		
		JFrame frame = new JFrame(500, 500);
		
		JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		mainPanel.add(new JLabel("Book Flight", 25, Constants.blue, 1),
				BorderLayout.NORTH);
		JButton submit = new JButton("Submit", 18, 18);
		submit.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		mainPanel.add(submit, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel(new GridLayout(5, 2, 15, 15));
		
		panel.add(new JLabel("Passenger", 18, Constants.black, 1));
		
		ArrayList<Passenger> passengers = 
				new ReadAllPassengers(db).getPassengers();
		String[] passengerNames = new String[passengers.size()+1];
		passengerNames[0] = "";
		for (int i=0;i<passengers.size();i++) {
			passengerNames[i+1] = passengers.get(i).getName();
		}
		JComboBox passengerName = new JComboBox(passengerNames);
		panel.add(passengerName);
		panel.add(new JLabel("Phone Number:", 18, Constants.black, 1));
		JLabel phoneNumber = new JLabel("", 18, Constants.black, 1);
		panel.add(phoneNumber);
		panel.add(new JLabel("Email:", 18, Constants.black, 1));
		JLabel email = new JLabel("", 18, Constants.black, 1);
		panel.add(email);
		
		passengerName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (passengerName.getSelectedIndex()==0) {
					passenger = null;
					phoneNumber.setText("");
					email.setText("");
				} else {
					passenger = passengers.get(passengerName.getSelectedIndex()-1);
					phoneNumber.setText(passenger.getTel());
					email.setText(passenger.getEmail());
				}
			}
		});
		
		panel.add(new JLabel("Ticket Type:", 18, Constants.black, 1));
		JComboBox ticketType = new JComboBox(
				new String[] {"", "Business", "Economy"});
		panel.add(ticketType);
		
		panel.add(new JLabel("Number of Seats:", 18, Constants.black, 1));
		JTextField seats = new JTextField("", 15);
		panel.add(seats);
		
		mainPanel.add(panel, BorderLayout.CENTER);
		frame.getContentPane().add(mainPanel);
		mainPanel.requestFocus();
		frame.setVisible(true);
		
		submit.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (passenger==null) {
					new Alert("Please select passenger");
					return;
				}
				if (ticketType.getSelectedItem().toString().equals("")) {
					new Alert("Please select ticket type");
					return;
				}
				try {
					Integer.parseInt(seats.getText());
				} catch (Exception e) {
					new Alert("Please enter number of seats (int)");
					return;
				}
				com.mycompany.airlinesgui.Controller.BookFlight book = new com.mycompany.airlinesgui.Controller.BookFlight(
						db, f, passenger, Integer.parseInt(seats.getText()),
						ticketType.getSelectedItem().toString());
				if (book.isBooked()) {
					new Alert("Booked successfully");
					// To refreah home table
					sPanel.setSelected(sPanel.getSideButtons()[0]);
					frame.dispose();
				}
			}
		});
	}

}
