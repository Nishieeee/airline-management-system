package com.mycompany.airlinesgui.Controller;

import java.sql.ResultSet;

import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Employee;
import com.mycompany.airlinesgui.View.Alert;

public class ReadEmployeeByID {
	
	private Employee p;
	
	public ReadEmployeeByID(int ID, Database database) {
		String get = "SELECT `id`, `firstName`, `lastName`, `Tel`, `email`,"
				+ " `salary`, "+ "`position` FROM `employees` WHERE `id` = "+
				ID+" ;";
		try {
			ResultSet rs = database.getStatement().executeQuery(get);	
			rs.next();
			p = new Employee();
			p.setId(Integer.parseInt(rs.getString("id")));
			p.setFirstName(rs.getString("firstName"));
			p.setLastName(rs.getString("lastName"));
			p.setTel(rs.getString("Tel"));
			p.setEmail(rs.getString("email"));
			p.setSalary(rs.getDouble("salary"));
			p.setPosition(rs.getString("position"));	
		} catch (Exception e) {
			new Alert(e.getMessage());
		}
	}
	
	public Employee getEmployee() {
		return p;
	}

}
