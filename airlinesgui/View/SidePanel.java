package com.mycompany.airlinesgui.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.mycompany.airlinesgui.Model.Database;

@SuppressWarnings("serial")
public class SidePanel extends JPanel {
    
    private SideButton selected;
    private SideButton[] sideButtons;
    private JPanel mainPanel;
    private Database db;
    
    public SidePanel(SideButton[] sideButtons, JPanel mainPanel, Database db) {
        super();
        this.sideButtons = sideButtons;
        this.mainPanel = mainPanel;
        this.db = db;
        setBackground(Constants.blue);
        Dimension sideBarDim = new Dimension(182, 1000);
        setPreferredSize(sideBarDim);
        setMaximumSize(sideBarDim);
        setMinimumSize(sideBarDim);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        // Add AMS Logo Panel
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        logoPanel.setBackground(Constants.blue);
        logoPanel.setMaximumSize(new Dimension(182, 50));
        JLabel logoLabel = new JLabel("AMS", 24, Constants.white, 1);
        logoPanel.add(logoLabel);
        add(logoPanel);
        
        add(Box.createVerticalStrut(20)); // Reduced from 50 to 20 to accommodate logo
        
        for (SideButton sideButton: sideButtons) {
            add(sideButton);
            sideButton.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    selected = sideButton;
                    sideButton.setSelected(true);
                    update();
                }
            });
        }
    }
    
    public SideButton getSelected() {
        return selected;
    }
    
    public void setSelected(SideButton selected) {
        this.selected = selected;
        selected.setSelected(true);
        update();
    }
    
    private void update() {
        for (SideButton sideBtn: sideButtons) {
            if (sideBtn!=selected) {
                sideBtn.setSelected(false);
            }
        }
        
        switch (selected.getText()) {
        case "Flights":
            showPanel(new FlightsTable(db, this));
            break;
        case "Passengers":
            showPanel(new PassengersTable(db, this));
            break;
        case "Employees":
            showPanel(new EmployeesTable(db, this));
            break;
        case "Planes":
            showPanel(new PlanesTable(db, this));
            break;
        case "Airports":
            showPanel(new AirportsTable(db, this));
            break;
        }
    }
    
    private void showPanel(JTable table) {
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Constants.background);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
        
        JLabel title = new JLabel(selected.getText(), 25, Constants.blue, 1);
        title.setPaddng(20);
        centerPanel.add(title, BorderLayout.NORTH);
        
        centerPanel.add(new JScrollPane(table));
        
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.add(this, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.repaint();
    }
    
    public SideButton[] getSideButtons() {
        return sideButtons;
    }
}
