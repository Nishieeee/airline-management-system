package com.mycompany.airlinesgui.Controller;

import java.sql.ResultSet;

import com.mycompany.airlinesgui.Model.Airplane;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.View.Alert;

public class ReadPlaneByID {
	
	private Airplane plane;
	
	public ReadPlaneByID(int ID, Database database) {
		plane = new Airplane();
		String get = "SELECT `id`, `EconomyCapacity`, `BusinessCapacity`, `model` "
				+ "FROM `airplanes` WHERE `id` = "+ID+" ;";
		try {
			ResultSet rs = database.getStatement().executeQuery(get);
			rs.next();
			plane.setId(rs.getInt("id"));
			plane.setEconomyCapacity(rs.getInt("EconomyCapacity"));
			plane.setBusinessCapacity(rs.getInt("BusinessCapacity"));
			plane.setModel(rs.getString("model"));
		} catch (Exception e) {
			new Alert(e.getMessage());
		}
	}
	
	public Airplane getAirplane() {
		return plane;
	}

}
