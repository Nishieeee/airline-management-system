package com.mycompany.airlinesgui.Controller;

import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Passenger;
import com.mycompany.airlinesgui.View.Alert;

public class EditPassenger {
	
	private boolean edited = false;
	
	public EditPassenger(Database database, Passenger passenger) {	
		String update = "UPDATE `passengers` SET `id`='"+passenger.getId()+
				"',`firstName`='"+passenger.getFirstName()+"',`lastName`='"
				+passenger.getLastName()+"',`Tel`='"+passenger.getTel()+
				"',`email`='"+passenger.getEmail()+"' WHERE `id` = '"+
				passenger.getId()+"';";
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
