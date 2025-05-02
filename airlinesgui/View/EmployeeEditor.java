package com.mycompany.airlinesgui.View;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.mycompany.airlinesgui.Controller.DeleteEmployee;
import com.mycompany.airlinesgui.Controller.EditEmployee;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Employee;

public class EmployeeEditor {
	
	public EmployeeEditor(Employee employee, Database db, SidePanel sPanel) {
		JFrame frame = new JFrame(600, 470);
		
		JPanel panel = new JPanel(new GridLayout(7, 2, 15, 15));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		panel.add(new JLabel("First Name", 18, Constants.blue, 1));
		JTextField firstName = new JTextField("First Name", 15);
		panel.add(firstName);
		panel.add(new JLabel("Last Name", 18, Constants.blue, 1));
		JTextField lastName = new JTextField("Last Name", 15);
		panel.add(lastName);
		panel.add(new JLabel("Email", 18, Constants.blue, 1));
		JTextField email = new JTextField("Email", 15);
		panel.add(email);
		panel.add(new JLabel("Phone Number", 18, Constants.blue, 1));
		JTextField tel = new JTextField("Phone Number", 15);
		panel.add(tel);
		panel.add(new JLabel("Salary", 18, Constants.blue, 1));
		JTextField salary = new JTextField("Salary", 15);
		panel.add(salary);
		panel.add(new JLabel("Position", 18, Constants.blue, 1));
		JTextField position = new JTextField("Position", 15);
		panel.add(position);
		JButton delete = new JButton("Delete", 18, 18);
		panel.add(delete);
		JButton submit = new JButton("Submit", 18, 18);
		panel.add(submit);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		panel.requestFocus();
		
		firstName.setText(employee.getFirstName());
		lastName.setText(employee.getLastName());
		email.setText(employee.getEmail());
		tel.setText(employee.getTel());
		salary.setText(String.valueOf(employee.getSalaray()));
		position.setText(employee.getPosition());
		firstName.setForeground(Constants.black);
		lastName.setForeground(Constants.black);
		email.setForeground(Constants.black);
		tel.setForeground(Constants.black);
		salary.setForeground(Constants.black);
		position.setForeground(Constants.black);
		
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
				 try {
					 Double.parseDouble(salary.getText());
				 } catch (Exception exception) {
					 new Alert("Please enter salary (double)");
					 return;
				 }
				 if (position.isEmpty()) {
					 new Alert("Please enter position");
					 return;
				 }
				 employee.setFirstName(firstName.getText());
				 employee.setLastName(lastName.getText());
				 employee.setEmail(email.getText());
				 employee.setTel(tel.getText());
				 employee.setSalary(Double.parseDouble(salary.getText()));
				 employee.setPosition(position.getText());
				 if (new EditEmployee(db, employee).isEdited()) {
					 frame.dispose();
					 // To refresh data
					 sPanel.setSelected(sPanel.getSideButtons()[2]);
				 }
			}
		});
		
		delete.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (new DeleteEmployee(db, employee).isDeleted()) {
					 frame.dispose();
					 // To refresh data
					 sPanel.setSelected(sPanel.getSideButtons()[2]);
				 }
			}
		});
	}

}
