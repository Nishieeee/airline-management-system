package com.mycompany.airlinesgui.Controller;

import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Flight;
import com.mycompany.airlinesgui.Model.Passenger;
import com.mycompany.airlinesgui.View.Alert;

public class BookFlight {
	
	private boolean booked = false;
	
	public BookFlight(Database database, Flight flight, Passenger passenger,
			int num, String type) {
		if (type.equals("Economy")) {
			flight.setBookedEconomy(flight.getBookedEconomy()+num);
		} else {
			flight.setBookedBusiness(flight.getBookedBusiness()+num);
		}
		
		Passenger[] passengers = flight.getPassengers();
		for (int i=0;i<passengers.length;i++) {
			if (passengers[i]==null) {
				passengers[i] = passenger;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (Passenger p : flight.getPassengers()) {
			if (p!=null) sb.append(p.getId()).append("<%%/>");
		}
		
		String update = "UPDATE `flights` SET `bookedEconomy`='"+
		flight.getBookedEconomy()+"',`bookedBusiness`='"+flight.getBookedBusiness()+
		"', `passengers`='"+sb.toString()+"' WHERE `id` = "+flight.getID()+" ;";
		try {
			database.getStatement().execute(update);
			booked = true;
		} catch (Exception e) {
			new Alert(e.getMessage());
			booked = false;
		}
	}
	
	public boolean isBooked() {
		return booked;
	}

}
