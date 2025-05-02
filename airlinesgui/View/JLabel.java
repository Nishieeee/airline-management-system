package com.mycompany.airlinesgui.View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;

@SuppressWarnings({ "serial" })
public class JLabel extends javax.swing.JLabel {
	
	public JLabel(String text, int size, Color color, int style) {
		super(text);
		setFont(new Font("Segoe UI", style, size));
		setForeground(color);
		setHorizontalAlignment(CENTER);
	}
	
	public void setPaddng(int padding) {
		setBorder(BorderFactory.
				createEmptyBorder(padding, padding, padding, padding));
	}

}
