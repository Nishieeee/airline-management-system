package com.mycompany.airlinesgui.Controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mycompany.airlinesgui.Model.Airport;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.View.Alert;

public class ReadAllAirports {
	
	private ArrayList<Airport> airports;
	
	public ReadAllAirports(Database database) {
		try {
			airports = new ArrayList<>();
			String select = "SELECT * FROM `airports`;";
			ResultSet rs = database.getStatement().executeQuery(select);
			while (rs.next()) {
				Airport a = new Airport();
				a.setID(rs.getInt("id"));
				a.setCity(rs.getString("city"));
				airports.add(a);
			}
		} catch (Exception e) {
			new Alert(e.getMessage());
		}
	}
	
	public ArrayList<Airport> getAirports() {
		return airports;
	}

}
