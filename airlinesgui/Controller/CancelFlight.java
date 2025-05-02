package com.mycompany.airlinesgui.Controller;

import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Flight;
import com.mycompany.airlinesgui.View.Alert;

public class CancelFlight {
	
	private boolean cancelled = false;
	
	public CancelFlight(Database database, Flight flight) {
		String delete = "DELETE FROM `flights` WHERE `id` = "+flight.getID()+" ;";
		try {
			database.getStatement().execute(delete);
			cancelled = true;
		} catch (Exception e) {
			new Alert(e.getMessage());
			cancelled = false;
		}
	}
	
	public boolean isCancelled() {
		return cancelled;
	}

}
