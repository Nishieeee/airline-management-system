package com.mycompany.airlinesgui.View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class JTable extends javax.swing.JTable {
	
	Color headerColor = Constants.blue;
	Color accent = Constants.blue_light;
	
	public JTable(String[][] data, String[] header) {
		super(data, header);
		
		setRowHeight(40);
		setBackground(null);
		
		// To set table cells not editable
		DefaultTableModel tableModel = new DefaultTableModel(data, header) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		setModel(tableModel);
		
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(javax.swing.JTable
					table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected,
						hasFocus, row, column);
				setHorizontalAlignment(CENTER);
				setFont(new Font("Segoe UI", 1, 16));
				
				// To remove the border on cell click
				if (hasFocus) setBorder(null);
				
				// To set the alternating row color
				// (even rows [White], odd rows [accent])
				if (row%2==0) {
					setBackground(Constants.white);
				} else {
					setBackground(accent);
				}
				return this;
			}
		};
		
		for (int i=0;i<getColumnModel().getColumnCount();i++) {
			getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
		}
		
		// To change header style
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(javax.swing.JTable
					table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected,
						hasFocus, row, column);
				setHorizontalAlignment(CENTER);
				setFont(new Font("SansSerif", 1, 17));
				setBackground(headerColor);
				setForeground(Constants.white);
				setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
				return this;
			}
		};
		getTableHeader().setDefaultRenderer(headerRenderer);
		
		// To add external border to the header
		getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 1, 2, headerColor));
		setBorder(BorderFactory.createMatteBorder(1, 2, 2, 2, headerColor));
		setGridColor(headerColor);
		
		// To disable row selection
		setRowSelectionAllowed(false);
		
	}
	
	public JTable() {
		setRowHeight(40);
		setBackground(null);
		
		// To change header style
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(javax.swing.JTable
					table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected,
						hasFocus, row, column);
				setHorizontalAlignment(CENTER);
				setFont(new Font("SansSerif", 1, 17));
				setBackground(headerColor);
				setForeground(Constants.white);
				setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
				return this;
			}
		};
		getTableHeader().setDefaultRenderer(headerRenderer);
		
		// To add external border to the header
		getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 1, 2, headerColor));
		setBorder(BorderFactory.createMatteBorder(1, 2, 2, 2, headerColor));
		setGridColor(headerColor);
		
		// To disable row selection
		setRowSelectionAllowed(false);
		
	}
	
	public void setTableData(String[][] data, String[] header) {
		// To set table cells not editable
		DefaultTableModel tableModel = new DefaultTableModel(data, header) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		setModel(tableModel);
				
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(javax.swing.JTable
					table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected,
						hasFocus, row, column);
				setHorizontalAlignment(CENTER);
				setFont(new Font("Segoe UI", 1, 16));
				
				// To remove the border on cell click
				if (hasFocus) setBorder(null);
				
				// To set the alternating row color
				// (even rows [White], odd rows [accent])
				if (row%2==0) {
					setBackground(Constants.white);
				} else {
					setBackground(accent);
				}
				return this;
			}
		};
		
		for (int i=0;i<getColumnModel().getColumnCount();i++) {
			getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
		}
	}
	
	public void setColWidths(int[] h) {
//		if (getColumnCount()!=h.length) return;
		for (int i=0;i<getColumnCount();i++) {
			getColumnModel().getColumn(i).setPreferredWidth(h[i]);
		}
	}

}
