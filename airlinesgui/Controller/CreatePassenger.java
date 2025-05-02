package com.mycompany.airlinesgui.Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Passenger;
import com.mycompany.airlinesgui.View.Alert;

public class CreatePassenger {
	
	private boolean created = false;
	
	public CreatePassenger(Database database, Passenger p) {
		
		
		ArrayList<Passenger> passengers = new ReadAllPassengers(database)
				.getPassengers();
		int id;
		if (passengers.size() !=0) {
			id = passengers.get(passengers.size()-1).getId()+1;
		} else {
			id = 0;
		}
		p.setId(id);
		
		String insert = "INSERT INTO `passengers`(`id`, `firstName`, `lastName`,"
				+ " `Tel`, `email`) VALUES ('"+p.getId()+"','"+p.getFirstName()+"','"
				+p.getLastName()+"','"+p.getTel()+"','"+p.getEmail()+"');";
		try {
			database.getStatement().execute(insert);
			created = true;
		} catch (SQLException e) {
			created = false;
			new Alert(e.getMessage());
		}
		
	}
	
	public boolean isCreated() {
		return created;
	}

}
