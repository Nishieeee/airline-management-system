package com.mycompany.airlinesgui.View;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JButton extends JLabel {
	
	private Shape shape;
	private int radius;
	
	public JButton(String text, int radius, int size) {
		super(text);
		this.radius = radius;
		setFont(new Font("Segoe UI", 1, size));
		setOpaque(false);
		setForeground(Constants.white);
		setHorizontalAlignment(CENTER);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	//for rounded corners
	protected void paintComponent(Graphics g) {
		g.setColor(Constants.blue);
		g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
		super.paintComponent(g);
	}
	
	//for rounded borders
	protected void paintBorder(Graphics g) {
		g.setColor(Constants.blue);
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
	}
	
	public boolean contains(int x, int y) {
		if (shape==null || shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.
					Float(0, 0, getWidth()-1, getHeight()-1, 45, 45);
		}
		return shape.contains(x, y);
	}

}
