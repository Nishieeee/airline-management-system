package com.mycompany.airlinesgui.Controller;

import com.mycompany.airlinesgui.Model.Airport;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.View.Alert;

public class EditAirport {
	
	private boolean edited = false;
	
	public EditAirport(Database database, Airport airport) {
		String update = "UPDATE `airports` SET `id`='"+airport.getID()+
				"',`city`='"+airport.getCity()+"' WHERE `id` = "+airport.getID()
				+" ;";
		try {
			database.getStatement().execute(update);
			edited = true;
		} catch (Exception e) {
			new Alert(e.getMessage());
			edited = false;
		}
	}
	
	public boolean isEdited() {
		return edited;
	}

}
