package com.mycompany.airlinesgui.Controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mycompany.airlinesgui.Model.Airplane;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.View.Alert;

public class ReadAllPlanes {
	
	private ArrayList<Airplane> planes;
	
	public ReadAllPlanes(Database database) {
		try {
			planes = new ArrayList<>();
			String get = "SELECT * FROM `airplanes`;";
			ResultSet rs = database.getStatement().executeQuery(get);
			while (rs.next()) {
				Airplane a = new Airplane();
				a.setId(rs.getInt("id"));
				a.setEconomyCapacity(rs.getInt("EconomyCapacity"));
				a.setBusinessCapacity(rs.getInt("BusinessCapacity"));
				a.setModel(rs.getString("model"));
				planes.add(a);
			}
		} catch (Exception e) {
			new Alert(e.getMessage());
		}
	}
	
	public ArrayList<Airplane> getPlanes() {
		return planes;
	}

}
