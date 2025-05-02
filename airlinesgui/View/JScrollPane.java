package com.mycompany.airlinesgui.View;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class JScrollPane extends javax.swing.JScrollPane {
	
	public JScrollPane(JComponent component) {
		super(component);
		setBackground(null);
		getViewport().setBackground(null);
		getViewport().setBorder(null);
		setBorder(null);
	}

}
