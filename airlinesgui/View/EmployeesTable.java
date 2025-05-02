package com.mycompany.airlinesgui.View;

import java.util.ArrayList;

import com.mycompany.airlinesgui.Controller.ReadAllEmployees;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Employee;

@SuppressWarnings("serial")
public class EmployeesTable extends JTable {
	
	public EmployeesTable(Database db, SidePanel sPanel) {
		String[] header = {"ID", "Name", "Tel", "Email", "Salary", "Job Title"};
		
		ArrayList<Employee> employees = new ReadAllEmployees(db).getEmployees();
		String[][] data = new String[employees.size()][6];
		for (int i=0;i<employees.size();i++) {
			data[i] = employees.get(i).getData();
		}
		setTableData(data, header);
		addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int row = rowAtPoint(e.getPoint());
				int col = columnAtPoint(e.getPoint());
				if (row>=0 && col>=0 && e.getClickCount()==2) {
					new EmployeeEditor(employees.get(row), db, sPanel);
				}
			}
		});
		setColWidths(new int[] {10, 80, 80, 80, 40, 70});
	}

}
