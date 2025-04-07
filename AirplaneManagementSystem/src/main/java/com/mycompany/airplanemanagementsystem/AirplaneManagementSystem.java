/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.airplanemanagementsystem;

import java.sql.SQLException;
import java.util.Scanner;

public class AirplaneManagementSystem {
    
    
    
    public static void main(String[] Args) throws SQLException{
        Database database = new Database();
        Scanner s = new Scanner(System.in);
        
        int i = 0;
        do {
            System.out.println("--welcome to Airlinerist--");
            System.out.println("[1] Add New Passenger");
            System.out.println("[2] Edit Passenger");
            System.out.println("[3] Quit.");
            
            i = s.nextInt();
            
            switch(i) {
                
                case 1 -> passengerController.AddNewPassenger(database, s);
            }
        } while(i != 3);
        
    }
}
