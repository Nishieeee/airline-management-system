package com.mycompany.airlinesgui.View;

import java.awt.Font;

import javax.swing.SwingConstants;

@SuppressWarnings({ "rawtypes", "serial" })
public class JComboBox extends javax.swing.JComboBox {
	
	@SuppressWarnings("unchecked")
	public JComboBox(String[] items) {
		super(items);
		setFont(new Font("Segoe UI", 1, 18));
		setBackground(Constants.white);
		setForeground(Constants.black);
		((javax.swing.JLabel) getRenderer()).setHorizontalAlignment(
				SwingConstants.CENTER);
	}

}
