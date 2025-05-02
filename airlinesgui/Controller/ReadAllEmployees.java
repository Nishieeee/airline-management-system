package com.mycompany.airlinesgui.Controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Employee;
import com.mycompany.airlinesgui.View.Alert;

public class ReadAllEmployees {
	
	private ArrayList<Employee> employees;
	
	public ReadAllEmployees(Database database) {
		try {
			String get = "SELECT * FROM `employees`;";
			ResultSet rs = database.getStatement().executeQuery(get);
			employees = new ArrayList<>();
			while (rs.next()) {
				Employee p = new Employee();
				p.setId(Integer.parseInt(rs.getString("id")));
				p.setFirstName(rs.getString("firstName"));
				p.setLastName(rs.getString("lastName"));
				p.setTel(rs.getString("Tel"));
				p.setEmail(rs.getString("email"));
				p.setSalary(Double.parseDouble(rs.getString("salary")));
				p.setPosition(rs.getString("position"));
				employees.add(p);
			}
		} catch (Exception e) {
			new Alert(e.getMessage());
		}
	}
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

}
