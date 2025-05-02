package com.mycompany.airlinesgui.Controller;

import com.mycompany.airlinesgui.Model.Airplane;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.View.Alert;

public class EditPlane {
	
	private boolean edited = false;
	
	public EditPlane(Database database, Airplane p) {
		String update = "UPDATE `airplanes` SET `id`='"+p.getId()+
				"',`EconomyCapacity`='"+p.getEconomyCapacity()+
				"',`BusinessCapacity`='"+p.getBusinessCapacity()+
				"',`model`='"+p.getModel()+"' WHERE `id` = "+p.getId()+" ;";
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
