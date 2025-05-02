package com.mycompany.airlinesgui.AirlineManagementSystem;

import java.sql.SQLException;

import javax.swing.SwingUtilities;
import com.mycompany.airlinesgui.Model.Database;
import com.mycompany.airlinesgui.View.JFrame;
import com.mycompany.airlinesgui.View.Login;
import com.mycompany.airlinesgui.View.Alert;

public class Main {

    public static void main(String[] args) throws SQLException {
        Database database = new Database();
        
        // Create and show login window
        SwingUtilities.invokeLater(() -> {
            Login loginWindow = new Login();
            
            // Set login success handler
            loginWindow.setLoginSuccessHandler(() -> {
                loginWindow.dispose(); // Close login window
                
                // Start main application
                SwingUtilities.invokeLater(() -> {
                    new JFrame(database);
                });
            });
        });
    }
}
