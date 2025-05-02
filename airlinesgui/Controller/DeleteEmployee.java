package com.mycompany.airlinesgui.Controller;

import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Employee;
import com.mycompany.airlinesgui.View.Alert;

public class DeleteEmployee {
	
	private boolean deleted = false;
	
	public DeleteEmployee(Database database, Employee e) {
		String delete = "DELETE FROM `employees` WHERE `id` = "+e.getId()+" ;";
		try {
			database.getStatement().execute(delete);
			deleted = true;
		} catch (Exception error) {
			new Alert(error.getMessage());
			deleted = false;
		}
	}
	
	public boolean isDeleted() {
		return deleted;
	}

}
