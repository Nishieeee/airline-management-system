package com.mycompany.airlinesgui.Controller;

import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Passenger;
import com.mycompany.airlinesgui.View.Alert;

public class DeletePassenger {
	
	private boolean deleted = false;
	
	public DeletePassenger(Database database, Passenger passenger) {
		String delete = "DELETE FROM `passengers` WHERE `id`="+
				passenger.getId()+";";
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
