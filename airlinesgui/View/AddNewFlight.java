package com.mycompany.airlinesgui.View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.mycompany.airlinesgui.Controller.CreateFlight;
import com.mycompany.airlinesgui.Controller.ReadAllAirports;
import com.mycompany.airlinesgui.Controller.ReadAllPlanes;
import com.mycompany.airlinesgui.Model.Airplane;
import com.mycompany.airlinesgui.Model.Airport;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Flight;

public class AddNewFlight {
	
	private Airplane plane = null;
	private Airport originAirport = null;
	private Airport destinationAirport = null;
	
	public AddNewFlight(Database database, SidePanel sPanel, int index) {
	// Plane, Origin (Airport), Destination (Airport),
	//Departure Time (yyyy-MM-dd::HH:mm:ss), Arrival Time (yyyy-MM-dd::HH:mm:ss)
		
		JFrame frame = new JFrame(1000, 425);
		JPanel panel = new JPanel(new GridLayout(6, 1, 15, 15));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		panel.add(new JLabel("Add new Flight", 25, Constants.blue, 1));
		
		JPanel planePanel = new JPanel(new GridLayout(1, 6, 15, 15));
		ArrayList<Airplane> planes = new ReadAllPlanes(database).getPlanes();
		String[] planesModels = new String[planes.size()+1];
		planesModels[0] = "";
		for (int i=0;i<planes.size();i++) {
			planesModels[i+1] = planes.get(i).getModel();
		}
		planePanel.add(new JLabel("Airplane", 18, Constants.blue, 1));
		JComboBox planeModel = new JComboBox(planesModels);
		planePanel.add(planeModel);
		planePanel.add(new JLabel("Economy", 18, Constants.blue, 1));
		JLabel eCap = new JLabel("", 18, Constants.black, 1);
		planePanel.add(eCap);
		planePanel.add(new JLabel("Business", 18, Constants.blue, 1));
		JLabel bCap = new JLabel("", 18, Constants.black, 1);
		planePanel.add(bCap);
		planeModel.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (planeModel.getSelectedIndex()==0) {
					plane = null;
					eCap.setText("");
					bCap.setText("");
				} else {
					plane = planes.get(planeModel.getSelectedIndex()-1);
					eCap.setText(plane.getEconomyCapacity()+"");
					bCap.setText(plane.getBusinessCapacity()+"");
				}
			}
		});
		panel.add(planePanel);
		
		JPanel locsPanel = new JPanel(new GridLayout(1, 4, 15, 15));
		ArrayList<Airport> airports = new ReadAllAirports(database).getAirports();
		String[] airportsNames = new String[airports.size()+1];
		airportsNames[0] = "";
		for (int i=0;i<airports.size();i++) {
			airportsNames[i+1] = airports.get(i).getCity();
		}
		
		locsPanel.add(new JLabel("Origin", 18, Constants.blue, 1));
		JComboBox origin = new JComboBox(airportsNames);
		origin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (origin.getSelectedIndex()==0) {
					originAirport = null;
				} else {
					originAirport = airports.get(origin.getSelectedIndex()-1);
				}
			}
		});
		locsPanel.add(origin);
		
		locsPanel.add(new JLabel("Destinaton", 18, Constants.blue, 1));
		JComboBox destination = new JComboBox(airportsNames);
		destination.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (destination.getSelectedIndex()==0) {
					destinationAirport = null;
				} else {
					destinationAirport = airports.get(destination.getSelectedIndex()-1);
				}
			}
		});
		locsPanel.add(destination);
		panel.add(locsPanel);
		
		JPanel depPanel = new JPanel(new GridLayout(1, 7, 15, 15));
		depPanel.add(new JLabel("Departure", 18, Constants.blue, 1));
		JTextField dYear = new JTextField("Year", 15);
		depPanel.add(dYear);
		JTextField dMonth = new JTextField("Month", 15);
		depPanel.add(dMonth);
		JTextField dDay = new JTextField("Day", 15);
		depPanel.add(dDay);
		JTextField dHour = new JTextField("Hour", 15);
		depPanel.add(dHour);
		JTextField dMin = new JTextField("Min", 15);
		depPanel.add(dMin);
		JTextField dSec = new JTextField("Sec", 15);
		depPanel.add(dSec);
		panel.add(depPanel);
		
		JPanel arrPanel = new JPanel(new GridLayout(1, 7, 15, 15));
		arrPanel.add(new JLabel("Arrival", 18, Constants.blue, 1));
		JTextField aYear = new JTextField("Year", 15);
		arrPanel.add(aYear);
		JTextField aMonth = new JTextField("Month", 15);
		arrPanel.add(aMonth);
		JTextField aDay = new JTextField("Day", 15);
		arrPanel.add(aDay);
		JTextField aHour = new JTextField("Hour", 15);
		arrPanel.add(aHour);
		JTextField aMin = new JTextField("Min", 15);
		arrPanel.add(aMin);
		JTextField aSec = new JTextField("Sec", 15);
		arrPanel.add(aSec);
		panel.add(arrPanel);
		
		JButton submit = new JButton("Submit", 18, 18);
		panel.add(submit);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		panel.requestFocus();
		
		submit.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				 if (plane==null) {
					 new Alert("Please select airplane");
					 return;
				 }
				 if (originAirport==null) {
					 new Alert("Please select origin");
					 return;
				 }
				 if (destinationAirport==null) {
					 new Alert("Please select destination");
					 return;
				 }
				 try {
					 DateTimeFormatter.ofPattern("yyyy").parse(dYear.getText());
				 } catch (Exception e) {
					 new Alert("Please enter departure year in format (0000)");
					 return;
				 }
				 try {
					 DateTimeFormatter.ofPattern("MM").parse(dMonth.getText());
				 } catch (Exception e) {
					 new Alert("Please enter departure month in format (00)");
					 return;
				 }
				 try {
					 DateTimeFormatter.ofPattern("dd").parse(dDay.getText());
				 } catch (Exception e) {
					 new Alert("Please enter departure day in format (00)");
					 return;
				 }
				 try {
					 DateTimeFormatter.ofPattern("HH").parse(dHour.getText());
				 } catch (Exception e) {
					 new Alert("Please enter departure hour in format (00)");
					 return;
				 }
				 try {
					 DateTimeFormatter.ofPattern("mm").parse(dMin.getText());
				 } catch (Exception e) {
					 new Alert("Please enter departure min in format (00)");
					 return;
				 }
				 try {
					 DateTimeFormatter.ofPattern("ss").parse(dSec.getText());
				 } catch (Exception e) {
					 new Alert("Please enter departure sec in format (00)");
					 return;
				 }
				 
				 try {
					 DateTimeFormatter.ofPattern("yyyy").parse(aYear.getText());
				 } catch (Exception e) {
					 new Alert("Please enter arrival year in format (0000)");
					 return;
				 }
				 try {
					 DateTimeFormatter.ofPattern("MM").parse(aMonth.getText());
				 } catch (Exception e) {
					 new Alert("Please enter arrival month in format (00)");
					 return;
				 }
				 try {
					 DateTimeFormatter.ofPattern("dd").parse(aDay.getText());
				 } catch (Exception e) {
					 new Alert("Please enter arrival day in format (00)");
					 return;
				 }
				 try {
					 DateTimeFormatter.ofPattern("HH").parse(aHour.getText());
				 } catch (Exception e) {
					 new Alert("Please enter arrival hour in format (00)");
					 return;
				 }
				 try {
					 DateTimeFormatter.ofPattern("mm").parse(aMin.getText());
				 } catch (Exception e) {
					 new Alert("Please enter arrival min in format (00)");
					 return;
				 }
				 try {
					 DateTimeFormatter.ofPattern("ss").parse(aSec.getText());
				 } catch (Exception e) {
					 new Alert("Please enter arrival sec in format (00)");
					 return;
				 }
				 String deptD = dYear.getText()+"-"+dMonth.getText()
				 	+"-"+dDay.getText()+"::"+dHour.getText()+":"+dMin.getText()
				 	+":"+dSec.getText();
				 String arrD = aYear.getText()+"-"+aMonth.getText()
				 	+"-"+aDay.getText()+"::"+aHour.getText()+":"+aMin.getText()
				 	+":"+aSec.getText();
				 
				 DateTimeFormatter formatter = DateTimeFormatter.
						 ofPattern("yyyy-MM-dd::HH:mm:ss");
				 
				 LocalDateTime departureTime, arrivalTime;
				 try {
					 departureTime = LocalDateTime.parse(deptD, formatter);
				 } catch (Exception e) {
					new Alert("Invalid departure date time");
					return;
				}
				 try {
					 arrivalTime = LocalDateTime.parse(arrD, formatter);
				 } catch (Exception e) {
					new Alert("Invalid arrival time");
					return;
				}
				 
				 Flight flight = new Flight();
				flight.setAirplane(plane);
				flight.setOriginAirport(originAirport);
				flight.setDestinationAirport(destinationAirport);
				flight.setDepartureTime(departureTime);
				flight.setArrivalTime(arrivalTime);
				 if (new CreateFlight(database, flight).isCreated()) {
					 frame.dispose();
					 // To refresh data
					 sPanel.setSelected(sPanel.getSideButtons()[index]);
				 }
			}
		});
		
	}

}
