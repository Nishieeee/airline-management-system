package com.mycompany.airlinesgui.Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Employee;
import com.mycompany.airlinesgui.View.Alert;

public class CreateEmployee {
	
	private boolean created = false;
	
	public CreateEmployee(Database database, Employee employee) {
		
		ArrayList<Employee> employees = new ReadAllEmployees(database)
				.getEmployees();
		int id;
		if (employees.size() !=0) {
			id = employees.get(employees.size()-1).getId()+1;
		} else {
			id = 0;
		}
		employee.setId(id);
		
		String insert = "INSERT INTO `employees`(`id`, `firstName`, `lastName`,"
				+ " `Tel`, `email`, `salary`, `position`) VALUES ('"+employee.getId()+"','"+
				employee.getFirstName()+"','"+employee.getLastName()+"','"+
				employee.getTel()+"','"+employee.getEmail()+"', '"+employee.getSalaray()+
				"', '"+employee.getPosition()+"');";
		try {
			database.getStatement().execute(insert);
			created = true;
		} catch (SQLException e) {
			created = false;
			new Alert(e.getMessage());
		}
	}
	
	public boolean isCreated() {
		return created;
	}

}
