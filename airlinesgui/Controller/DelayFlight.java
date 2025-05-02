package com.mycompany.airlinesgui.Controller;

import java.sql.SQLException;

import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Flight;
import com.mycompany.airlinesgui.View.Alert;

public class DelayFlight {
	
	private boolean delayed = false;
	
	public DelayFlight(Flight f, Database database) {
		String update = "UPDATE `flights` SET `isDelayed`='true' WHERE "
				+ "`id` = "+f.getID()+" ;";
		try {
			database.getStatement().execute(update);
			delayed = true;
		} catch (SQLException e) {
			new Alert(e.getMessage());
			delayed = false;
		}
	}
	
	public boolean isDelayed() {
		return delayed;
	}

}
