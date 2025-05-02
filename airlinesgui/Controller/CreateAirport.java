package com.mycompany.airlinesgui.Controller;

import java.util.ArrayList;

import com.mycompany.airlinesgui.Model.Airport;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.View.Alert;

public class CreateAirport {
	
	private boolean created = false;
	
	public CreateAirport(Database database, Airport airport) {
		int id;
		ArrayList<Airport> airports = new ReadAllAirports(database).getAirports();
		if (airports.size()!=0) {
			id = airports.get(airports.size()-1).getID()+1;
		} else {
			id = 0;
		}
		
		airport.setID(id);
		
		String insert = "INSERT INTO `airports`(`id`, `city`) VALUES ('"+
				airport.getID()+"','"+airport.getCity()+"');";
		try {
			database.getStatement().execute(insert);
			created = true;
		} catch (Exception e) {
			new Alert(e.getMessage());
			created = false;
		}
		
	}
	
	public boolean isCreated() {
		return created;
	}

}
