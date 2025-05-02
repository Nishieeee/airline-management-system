package com.mycompany.airlinesgui.View;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Alert {
	
	public Alert(String content) {
		JFrame frame = new JFrame("Airline Management System");
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		
		JPanel panel = new JPanel(new BorderLayout(5, 5));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		panel.setBackground(Constants.background);
		
		// 1 for bold text style
		panel.add(new JLabel("Alert", 24, Constants.blue, 1),
				BorderLayout.NORTH);
		
		panel.add(new JLabel(content, 18, Constants.black, 1),
				BorderLayout.CENTER);
		
		frame.getContentPane().add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
