package com.mycompany.airlinesgui.Controller;

import java.sql.ResultSet;

import com.mycompany.airlinesgui.Model.Airport;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.View.Alert;

public class ReadAirportByID {
	
	private Airport airport;
	
	public ReadAirportByID(int ID, Database database) {
		airport = new Airport();
		String select = "SELECT `id`, `city` FROM `airports` WHERE `id` = "+ID+" ;";
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			rs.next();
			airport.setID(rs.getInt("id"));
			airport.setCity(rs.getString("city"));
		} catch (Exception e) {
			new Alert(e.getMessage());
		}
	}
	
	public Airport getAirport() {
		return airport;
	}

}
