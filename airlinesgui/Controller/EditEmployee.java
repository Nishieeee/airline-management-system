package com.mycompany.airlinesgui.Controller;

import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Employee;
import com.mycompany.airlinesgui.View.Alert;

public class EditEmployee {
	
	private boolean edited = false;
	
	public EditEmployee(Database database, Employee employee) {
		String update = "UPDATE `employees` SET `id`='"+employee.getId()+
				"',`firstName`='"+employee.getFirstName()+"',`lastName`='"+
				employee.getLastName()+"',`Tel`='"+employee.getTel()+"',`email`='"
				+employee.getEmail()+"',`salary`='"+employee.getSalaray()+
				"',`position`='"+employee.getPosition()+"' WHERE `id` = "+
				employee.getId()+";";
		try{
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
