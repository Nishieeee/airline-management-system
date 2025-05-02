package com.mycompany.airlinesgui.View;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.mycompany.airlinesgui.Controller.CreatePlane;
import com.mycompany.airlinesgui.Model.Airplane;
import com.mycompany.airlinesgui.Model.Database;

public class AddNewPlane {
	
	public AddNewPlane(Database database, SidePanel sPanel, int index) {
		// Economy Capacity, Business Capacity, Model
		
		JFrame frame = new JFrame(350, 380);
		
		JPanel panel = new JPanel(new GridLayout(5, 1, 15, 15));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		panel.add(new JLabel("Add new Plane", 25, Constants.blue, 1));
		JTextField eCap = new JTextField("Economy Capacity", 15);
		panel.add(eCap);
		JTextField bCap = new JTextField("Business Capacity", 15);
		panel.add(bCap);
		JTextField model = new JTextField("Model", 15);
		panel.add(model);
		JButton submit = new JButton("Submit", 18, 18);
		panel.add(submit);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		panel.requestFocus();
		
		submit.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				 if (eCap.isEmpty()) {
					 new Alert("Please enter economy capacity");
					 return;
				 }
				 try {
					 Integer.parseInt(eCap.getText());
				 } catch (Exception e) {
					new Alert("Economy Capacity must be (int)");
					return;
				}
				 if (bCap.isEmpty()) {
					 new Alert("Please enter business capacity");
					 return;
				 }
				 try {
					 Integer.parseInt(bCap.getText());
				 } catch (Exception e) {
					new Alert("Business Capacity must be (int)");
					return;
				}
				 if (model.isEmpty()) {
					 new Alert("Please enter model");
					 return;
				 }
				Airplane airplane = new Airplane();
				airplane.setEconomyCapacity(Integer.parseInt(eCap.getText()));
				airplane.setBusinessCapacity(Integer.parseInt(bCap.getText()));
				airplane.setModel(model.getText());
				 if (new CreatePlane(database, airplane).isCreated()) {
					 frame.dispose();
					 // To refresh data
					 sPanel.setSelected(sPanel.getSideButtons()[index]);
				 }
			}
		});
		
	}
	
}
