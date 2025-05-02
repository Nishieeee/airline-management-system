package com.mycompany.airlinesgui.Controller;

import com.mycompany.airlinesgui.Model.Airport;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.View.Alert;

public class DeleteAirport {
	
	private boolean deleted = false;
	
	public DeleteAirport(Database database, Airport a) {
		String delete = "DELETE FROM `airports` WHERE `id` = "+a.getID()+" ;";
		try {
			database.getStatement().execute(delete);
			deleted = true;
		} catch (Exception e) {
			new Alert(e.getMessage());
			deleted = false;
		}
	}
	
	public boolean isDeleted() {
		return deleted;
	}

}
