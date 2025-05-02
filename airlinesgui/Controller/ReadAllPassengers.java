package com.mycompany.airlinesgui.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Passenger;
import com.mycompany.airlinesgui.View.Alert;

public class ReadAllPassengers {
	
	private ArrayList<Passenger> passengers;
	
	public ReadAllPassengers(Database database) {
		try {
			String get = "SELECT * FROM `passengers`;";
			ResultSet rs = database.getStatement().executeQuery(get);
			passengers = new ArrayList<>();
			
			while (rs.next()) {
				Passenger p = new Passenger();
				p.setId(Integer.parseInt(rs.getString("id")));
				p.setFirstName(rs.getString("firstName"));
				p.setLastName(rs.getString("lastName"));
				p.setTel(rs.getString("Tel"));
				p.setEmail(rs.getString("email"));
				passengers.add(p);
			}
		} catch (SQLException e) {
			new Alert(e.getMessage());
		}
	}
	
	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

}
