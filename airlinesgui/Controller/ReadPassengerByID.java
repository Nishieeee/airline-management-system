package com.mycompany.airlinesgui.Controller;

import java.sql.ResultSet;

import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Passenger;
import com.mycompany.airlinesgui.View.Alert;
import java.sql.SQLException;

public class ReadPassengerByID {
	
	private Passenger p;
	
	public ReadPassengerByID(int ID, Database database) {
		String get = "SELECT `id`, `firstName`, `lastName`, `Tel`, `email`"
				+ " FROM `passengers` WHERE `id` = "+ID+" ;";
		try {
			ResultSet rs = database.getStatement().executeQuery(get);
			rs.next();
			p = new Passenger();
			p.setId(ID);
			p.setFirstName(rs.getString("firstName"));
			p.setLastName(rs.getString("lastName"));
			p.setTel(rs.getString("Tel"));
			p.setEmail(rs.getString("email"));	
		} catch (SQLException e) {
                    Alert alert = new Alert(e.getMessage());
		}
	}
	
	public Passenger getPassenger() {
		return p;
	}

}
