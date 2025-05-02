package com.mycompany.airlinesgui.View;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

@SuppressWarnings({ "serial", "unused" })
public class JTextField extends javax.swing.JTextField {
	
	private Shape shape;
	private int radius;
	private String hint;
	
	public JTextField(String hint, int radius) {
		super();
		this.radius = radius;
		this.hint = hint;
		setFont(new Font("Segoe UI", 1, 18));
		setOpaque(false);
		setText(hint);
		setForeground(Constants.textFieldHint);
		setBorder(BorderFactory.createEmptyBorder(TOP, 20, BOTTOM, 20));
		
		addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (getText().equals("")) {
					setText(hint);
					setForeground(Constants.textFieldHint);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (getText().equals(hint)) {
					setText("");
					setForeground(Constants.black);
				}
			}
		});
	}
	
	//for rounded corners
	protected void paintComponent(Graphics g) {
		g.setColor(Constants.white);
		g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
		super.paintComponent(g);
	}
	
	//for rounded borders
	protected void paintBorder(Graphics g) {
		g.setColor(Constants.white);
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
	}
	
	public boolean contains(int x, int y) {
		if (shape==null || shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.
					Float(0, 0, getWidth()-1, getHeight()-1, radius, radius);
		}
		return shape.contains(x, y);
	}
	
	public boolean isEmpty() {
		return getText().equals(hint) || getText().equals("");
	}

}
