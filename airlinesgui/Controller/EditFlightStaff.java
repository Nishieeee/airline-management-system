package com.mycompany.airlinesgui.Controller;

import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Employee;
import com.mycompany.airlinesgui.Model.Flight;
import com.mycompany.airlinesgui.View.Alert;

public class EditFlightStaff {
	
	private boolean edited = false;
	
	public EditFlightStaff(Database database, Flight flight) {
		
		StringBuilder bd = new StringBuilder();
		for (Employee e : flight.getStaff()) {
			if (e!=null) bd.append(e.getId()).append("<%%/>");
		}
		
		String update = "UPDATE `flights` SET `stuff`='"+bd.toString()+
				"' WHERE `id` = "+flight.getID()+" ;";
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
