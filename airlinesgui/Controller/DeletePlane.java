package com.mycompany.airlinesgui.Controller;

import com.mycompany.airlinesgui.Model.Airplane;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.View.Alert;

public class DeletePlane {
	
	private boolean deleted = false;
	
	public DeletePlane(Database database, Airplane p) {
		String delete = "DELETE FROM `airplanes` WHERE `id` = "+p.getId()+" ;";
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
