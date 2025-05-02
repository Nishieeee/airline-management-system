package com.mycompany.airlinesgui.View;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.mycompany.airlinesgui.Model.Database;

@SuppressWarnings("serial")
public class JFrame extends javax.swing.JFrame {
	
	public JFrame(Database db) {
		super("Airline Managment System");
		getContentPane().setBackground(Constants.background);
		setSize(1000, 625);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(null);
		
		SideButton[] sideButtons = new SideButton[5];
		sideButtons[0] = new SideButton("Flights", "flight");
		sideButtons[1] = new SideButton("Passengers", "passenger");
		sideButtons[2] = new SideButton("Employees", "stuff");
		sideButtons[3] = new SideButton("Planes", "plane");
		sideButtons[4] = new SideButton("Airports", "airport");
		
		SidePanel sidePanel = new SidePanel(sideButtons, panel, db);
		sidePanel.setSelected(sideButtons[0]);
		
		SideButton add = new SideButton("Add New", "add");
		add.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switch (sidePanel.getSelected().getText()) {
				case "Flights":
					new AddNewFlight(db, sidePanel, 0);
					break;
				case "Passengers":
					new AddNewPassenger(db, sidePanel, 1);
					break;
				case "Employees":
					new AddNewEmployee(db, sidePanel, 2);
					break;
				case "Planes":
					new AddNewPlane(db, sidePanel, 3);
					break;
				case "Airports":
					new AddNewAirport(db, sidePanel, 4);
					break;
				}
			}
		});
		
		SideButton quit = new SideButton("Quit", "quit");
		quit.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				dispose();
			}
		});

		sidePanel.add(add);
		sidePanel.add(quit);
		panel.add(sidePanel, BorderLayout.WEST);
		
		getContentPane().add(panel);
		setVisible(true);
	}
	
	public JFrame(int width, int heigth) {
		super("Airline Management System");
		getContentPane().setBackground(Constants.background);
		setSize(width, heigth);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
