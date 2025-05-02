package com.mycompany.airlinesgui.View;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.mycompany.airlinesgui.Controller.CreateEmployee;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Employee;

public class AddNewEmployee {
	
	public AddNewEmployee(Database db, SidePanel sPanel, int index) {
		// First Name, Last Name, Email, Tel, Salary (double), Position
		JFrame frame = new JFrame(350, 550);
		JPanel panel = new JPanel(new GridLayout(8, 1, 15, 15));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		panel.add(new JLabel("Add new Employee", 25, Constants.blue, 1));
		JTextField firstName = new JTextField("First Name", 15);
		panel.add(firstName);
		JTextField lastName = new JTextField("Last Name", 15);
		panel.add(lastName);
		JTextField email = new JTextField("Email", 15);
		panel.add(email);
		JTextField tel = new JTextField("Phone Number", 15);
		panel.add(tel);
		JTextField salary = new JTextField("Salary", 15);
		panel.add(salary);
		JTextField position = new JTextField("Position", 15);
		panel.add(position);
		JButton submit = new JButton("Submit", 18, 18);
		panel.add(submit);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		panel.requestFocus();
		
		submit.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (firstName.isEmpty()) {
					 new Alert("Please enter first name");
					 return;
				 }
				 if (lastName.isEmpty()) {
					 new Alert("Please enter last name");
					 return;
				 }
				 if (email.isEmpty()) {
					 new Alert("Please enter email");
					 return;
				 }
				 if (tel.isEmpty()) {
					 new Alert("Please enter phone number");
					 return;
				 }
				 if (salary.isEmpty()) {
					 new Alert("Please enter Salary");
					 return;
				 }
				 try {
					 Double.parseDouble(salary.getText());
				 } catch (Exception exception) {
					 new Alert("Salary must be (double)");
					 return;
				 }
				 if (position.isEmpty()) {
					 new Alert("Please enter position");
					 return;
				 }
				 Employee employee = new Employee();
				 employee.setFirstName(firstName.getText());
				 employee.setLastName(lastName.getText());
				 employee.setEmail(email.getText());
				 employee.setTel(tel.getText());
				 employee.setSalary(Double.parseDouble(salary.getText()));
				 employee.setPosition(position.getText());
				 if (new CreateEmployee(db, employee).isCreated()) {
					 frame.dispose();
					 // To refresh data
					 sPanel.setSelected(sPanel.getSideButtons()[index]);
				 }
			}
		});
	}

}
