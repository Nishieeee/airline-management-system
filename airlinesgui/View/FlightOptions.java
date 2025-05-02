package com.mycompany.airlinesgui.View;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.mycompany.airlinesgui.Controller.CancelFlight;
import com.mycompany.airlinesgui.Controller.DelayFlight;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Flight;

public class FlightOptions {
	
	public FlightOptions(Flight f, Database db, SidePanel sPanel) {
		// Delay, Book, setStuff, Cancel, show stuff, show passengers
		JFrame frame = new JFrame(350, 450);
		
		JPanel panel = new JPanel(new GridLayout(6, 1, 15, 15));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		JButton delay = new JButton("Delay", 18, 18);
		panel.add(delay);
		JButton book = new JButton("Book", 18, 18);
		panel.add(book);
		JButton editStuff = new JButton("Edit Stuff", 18, 18);
		panel.add(editStuff);
		JButton cancel = new JButton("Cancel", 18, 18);
		panel.add(cancel);
		JButton showStuff = new JButton("Stuff", 18, 18);
		panel.add(showStuff);
		JButton showPassengers = new JButton("Passengers", 18, 18);
		panel.add(showPassengers);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		panel.requestFocus();
		
		delay.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (new DelayFlight(f, db).isDelayed()) {
					 new Alert("Flight Delayed");
					 sPanel.setSelected(sPanel.getSideButtons()[0]);
					 frame.dispose();
				 }
			}
		});
		book.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 new BookFlight(f, db, sPanel);
				 frame.dispose();
			}
		});
		editStuff.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 new EditFlightStaff(db, f, sPanel);
				 frame.dispose();
			}
		});
		cancel.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (new CancelFlight(db, f).isCancelled()) {
					 new Alert("Flight Cancelled");
					 sPanel.setSelected(sPanel.getSideButtons()[0]);
					 frame.dispose();
				 }
			}
		});
		showStuff.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 new ShowFlightStaff(f);
				 frame.dispose();
			}
		});
		showPassengers.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ShowFlightPassengers(f);
				 frame.dispose();
			}
		});
	}

}
