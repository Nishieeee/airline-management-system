package com.mycompany.airlinesgui.View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.mycompany.airlinesgui.Controller.ReadAllEmployees;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.Model.Employee;
import com.mycompany.airlinesgui.Model.Flight;

public class EditFlightStaff {
	
	private String[] availableStuffNames;
	private Employee[] stuff;
	private ArrayList<Employee> allEmployees;
	private JComboBox[] employeesNames;
	private ArrayList<String> selectedEmployees;
	
	public EditFlightStaff(Database db, Flight f, SidePanel sPanel) {
		// 10 Employees
		// Employee (Selection by name) ==> {email, tel, position}
		// 1 Button Submit
		// 1 Title
		// 12 Row
		
		JFrame frame = new JFrame(700, 700);
		JPanel panel = new JPanel(new GridLayout(13, 1, 15, 15));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
		panel.add(new JLabel("Edit Flight Stuff", 25, Constants.blue, 1));
		
		allEmployees = new ReadAllEmployees(db).getEmployees();
		
		JPanel header = new JPanel(new GridLayout(1, 4, 15, 15));
		header.add(new JLabel("Name", 18, Constants.black, 1));
		header.add(new JLabel("Email", 18, Constants.black, 1));
		header.add(new JLabel("Tel.", 18, Constants.black, 1));
		header.add(new JLabel("Position", 18, Constants.black, 1));
		panel.add(header);
		
		JPanel[] panels = new JPanel[10];
		employeesNames = new JComboBox[10];
		JLabel[] emails = new JLabel[10];
		JLabel[] tels = new JLabel[10];
		JLabel[] positions = new JLabel[10];
		stuff = new Employee[10];
		
		selectedEmployees = new ArrayList<>();
		availableStuffNames = new String[allEmployees.size()+1];
		availableStuffNames[0] = "";
		for (int i=0;i<allEmployees.size();i++) {
			availableStuffNames[i+1] = allEmployees.get(i).getName();
		}
		
		for (int i=0;i<10;i++) {
			final int finalI = i;
			panels[i] = new JPanel(new GridLayout(1, 4, 15, 15));
			employeesNames[i] = new JComboBox(availableStuffNames);
			panels[i].add(employeesNames[i]);
			emails[i] = new JLabel("", 18, Constants.black, 1);
			panels[i].add(emails[i]);
			tels[i] = new JLabel("", 18, Constants.black, 1);
			panels[i].add(tels[i]);
			positions[i] = new JLabel("", 18, Constants.black, 1);
			panels[i].add(positions[i]);
			panel.add(panels[i]);
			employeesNames[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (stuff[finalI]!=null) {
						selectedEmployees.remove(stuff[finalI].getName());
						stuff[finalI] = null;
						emails[finalI].setText("");
						tels[finalI].setText("");
						positions[finalI].setText("");
					}
					if (employeesNames[finalI].getSelectedIndex()!=0) {
						if (!selectedEmployees.contains(employeesNames[finalI]
								.getSelectedItem().toString()) ) {
							Employee selected = allEmployees.get(
									employeesNames[finalI].getSelectedIndex()-1);
							stuff[finalI] = selected;
							selectedEmployees.add(employeesNames[finalI]
									.getSelectedItem().toString());
							emails[finalI].setText(selected.getEmail());
							tels[finalI].setText(selected.getTel());
							positions[finalI].setText(selected.getPosition());
						} else {
							new Alert("This employee is already selected");
							employeesNames[finalI].setSelectedIndex(0);
							emails[finalI].setText("");
							tels[finalI].setText("");
							positions[finalI].setText("");
						}
					}
				}
			});
		}
		
		JButton submit = new JButton("Submit", 18, 18);
		panel.add(submit);
		
		panel.requestFocus();
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		
		submit.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				for (int i=0;i<10;i++) {
					if (stuff[i]==null) {
						new Alert("Please select employee ("+(i+1)+")");
						return;
					}
				}
				f.setStaff(stuff);
				if (new com.mycompany.airlinesgui.Controller.EditFlightStaff(db, f).isEdited()) {
					new Alert("Stuff edited successfully");
					sPanel.setSelected(sPanel.getSideButtons()[0]);
					frame.dispose();
				}
			}
		});
	}

}
