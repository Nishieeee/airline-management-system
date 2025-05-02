package com.mycompany.airlinesgui.View;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.mycompany.airlinesgui.Controller.DeletePlane;
import com.mycompany.airlinesgui.Controller.EditPlane;
import com.mycompany.airlinesgui.Model.Airplane;
import com.mycompany.airlinesgui.Model.Database;

public class PlaneEditor {
	
	public PlaneEditor(Database db, Airplane p, SidePanel sPanel) {
		JFrame frame = new JFrame(600, 320);
		
		JPanel panel = new JPanel(new GridLayout(4, 2, 15, 15));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		panel.add(new JLabel("Economy Capacity", 18, Constants.black, 1));
		JTextField eCap = new JTextField("Economy Capacity", 15);
		panel.add(eCap);
		panel.add(new JLabel("Business Capacity", 18, Constants.black, 1));
		JTextField bCap = new JTextField("Business Capacity", 15);
		panel.add(bCap);
		panel.add(new JLabel("Model", 18, Constants.black, 1));
		JTextField model = new JTextField("Model", 15);
		panel.add(model);
		JButton delete = new JButton("Delete", 18, 18);
		panel.add(delete);
		JButton submit = new JButton("Submit", 18, 18);
		panel.add(submit);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		panel.requestFocus();
		
		eCap.setText(String.valueOf(p.getEconomyCapacity()));
		bCap.setText(String.valueOf(p.getBusinessCapacity()));
		model.setText(p.getModel());
		eCap.setForeground(Constants.black);
		bCap.setForeground(Constants.black);
		model.setForeground(Constants.black);
		
		submit.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				 try {
					 Integer.parseInt(eCap.getText());
				 } catch (Exception e) {
					new Alert("Please enter economy capacity (int)");
					return;
				}
				 try {
					 Integer.parseInt(bCap.getText());
				 } catch (Exception e) {
					new Alert("Please enter business capacity (int)");
					return;
				}
				if (model.isEmpty()) {
					new Alert("Please enter model");
					return;
				}
				p.setEconomyCapacity(Integer.parseInt(eCap.getText()));
				p.setBusinessCapacity(Integer.parseInt(bCap.getText()));
				p.setModel(model.getText());
				 if (new EditPlane(db, p).isEdited()) {
					 frame.dispose();
					 // To refresh data
					 sPanel.setSelected(sPanel.getSideButtons()[3]);
				 }
			}
		});
		
		delete.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (new DeletePlane(db, p).isDeleted()) {
					 frame.dispose();
					 // To refresh data
					 sPanel.setSelected(sPanel.getSideButtons()[3]);
				 }
			}
		});
	}

}
