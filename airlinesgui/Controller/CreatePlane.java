package com.mycompany.airlinesgui.Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mycompany.airlinesgui.Model.Airplane;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.View.Alert;

public class CreatePlane {
	
	private boolean created = false;
	
	public CreatePlane(Database database, Airplane airplane) {	
		int id;
		ArrayList<Airplane> planes = new ReadAllPlanes(database).getPlanes();
		if (planes.size()!=0) {
			id = planes.get(planes.size()-1).getId()+1;	
		} else {
			id = 0;
		}
		airplane.setId(id);
		
		String insert = "INSERT INTO `airplanes`(`id`, `EconomyCapacity`, "
				+ "`BusinessCapacity`, `model`) VALUES ('"+airplane.getId()+"','"+
				airplane.getEconomyCapacity()+"','"+airplane.getBusinessCapacity()+"','"+
				airplane.getModel()+"');";
		try {
			database.getStatement().execute(insert);
			created = true;
		} catch (SQLException e) {
			new Alert(e.getMessage());
			created = false;
		}
	}
	
	public boolean isCreated() {
		return created;
	}

}
