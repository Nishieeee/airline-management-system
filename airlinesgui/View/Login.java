package com.mycompany.airlinesgui.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Login extends com.mycompany.airlinesgui.View.JFrame {
    
    private com.mycompany.airlinesgui.View.JTextField usernameField;
    private com.mycompany.airlinesgui.View.JPasswordField passwordField; // Changed to JPasswordField
    private Runnable loginSuccessHandler;
    
    public Login() {
        // Frame setup - increased width
        super(400, 400);
        setTitle("AMS Login");
        setResizable(false);
        
        // Main panel with GridBagLayout for better control
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Constants.background);
        
        // Content panel to hold all components
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Constants.background);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Logo
        com.mycompany.airlinesgui.View.JLabel logoLabel = 
            new com.mycompany.airlinesgui.View.JLabel("AMS", 36, Constants.blue, Font.BOLD);
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(Constants.background);
        logoPanel.add(logoLabel);
        logoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Username field - increased width to 300
        com.mycompany.airlinesgui.View.JLabel usernameLabel = 
            new com.mycompany.airlinesgui.View.JLabel("Username", 14, Constants.blue, Font.BOLD);
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameField = new com.mycompany.airlinesgui.View.JTextField("Username", 15);
        usernameField.setMaximumSize(new Dimension(300, 35));
        usernameField.setPreferredSize(new Dimension(300, 35));
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Password field - increased width to 300
        com.mycompany.airlinesgui.View.JLabel passwordLabel = 
            new com.mycompany.airlinesgui.View.JLabel("Password", 14, Constants.blue, Font.BOLD);
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordField = new com.mycompany.airlinesgui.View.JPasswordField("Password", 15); // Changed to JPasswordField
        passwordField.setMaximumSize(new Dimension(300, 35));
        passwordField.setPreferredSize(new Dimension(300, 35));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Login button - matched width with input fields
        com.mycompany.airlinesgui.View.JButton loginButton = 
            new com.mycompany.airlinesgui.View.JButton("Login", 15, 14);
        loginButton.setMaximumSize(new Dimension(300, 35));
        loginButton.setPreferredSize(new Dimension(300, 35));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Add action listener
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword()); // Changed to get password
                
                if(authenticate(username, password)) {
                    if(loginSuccessHandler != null) {
                        loginSuccessHandler.run();
                    }
                } else {
                    new Alert("Invalid username or password");
                }
            }
        });
        
        // Add components with spacing
        contentPanel.add(logoPanel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        contentPanel.add(usernameLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPanel.add(usernameField);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        contentPanel.add(passwordLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPanel.add(passwordField);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        contentPanel.add(loginButton);
        
        // Add content panel to main panel
        mainPanel.add(contentPanel);
        
        // Add main panel to frame
        add(mainPanel);
        setVisible(true);
    }
    
    public void setLoginSuccessHandler(Runnable handler) {
        this.loginSuccessHandler = handler;
    }
    
    private boolean authenticate(String username, String password) {
        return username.equals("admin") && password.equals("admin123");
    }
}
