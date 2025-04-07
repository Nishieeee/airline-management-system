/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.airplanemanagementsystem;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class passengerController {

    /**
     *
     * @param database
     * @param s
     * @throws java.sql.SQLException
     */
    public static void AddNewPassenger(Database database, Scanner s) throws SQLException {
        
        System.out.println("Enter First Name: ");
        String firstName = s.next();
        
        System.out.println("Enter Last Name: ");
        String lastName = s.next();
        
        System.out.println("Enter tel no.: ");
        String tel = s.next();
        
        System.out.println("Enter Email: ");
        String email = s.next();
        
        Passenger passenger = new Passenger();
        passenger.setFirstName(firstName);
        passenger.setLastName(lastName);
        passenger.setTel(tel);
        passenger.setEmail(email);
        ArrayList<Passenger> passengers = database.getAllPassengers();
        int id;
        if (!passengers.isEmpty()) {
            id = passengers.get(passengers.size() - 1).getId() + 1;
        } else {
            id = 0;
        }
        passenger.setId(id);
        database.AddPassenger(passenger);
        System.out.println("Passenger Added Successfully.");
    }
    
    public static void EditPassenger(Database database, Scanner s) throws SQLException {
        System.out.println("Enter passenger id(int):  (-1 to show all passengers)");
        int id = s.nextInt();
        
        if(id == -1) {
            printAllPassengers(database);
            System.out.println("Enter passenger id(int): "); 
            id = s.nextInt();
        }
        
        System.out.println("What woul you like to edit?");
        System.out.println("[1] I would like to change my FirstName");
        System.out.println("[2] I would like to change my LastName");
        System.out.println("[3] I would like to change my Tel");
        System.out.println("[4] I would like to change my email");
        System.out.println("[5] cancel");
        int opt = s.nextInt();
        
        
        switch(opt) {
            case 1 -> {
                System.out.println("Enter New FirstName: ");
                String newFirstName = s.nextLine();
            }
            case 2 -> {
                System.out.println("Enter New LastName: ");
                String newLastName = s.nextLine();
            }
            case 3 -> {
                System.out.println("Enter New Tel no.: ");
                String newTel = s.nextLine();
            }
            case 4 -> {
                System.out.println("Enter New email: ");
                String newEmail = s.nextLine();
            }
            default -> {
                System.out.println("Invalid Input.");
            }
                
        }
    }
    
    public static void printAllPassengers(Database database) throws SQLException {
        ArrayList<Passenger> passengers = database.getAllPassengers();
        System.out.println("\n--Passengers--\n");
        for(Passenger p : passengers) {
            System.out.println("id: " + p.getId());
            System.out.println("FirstName: " + p.getFirstName());
            System.out.println("LastName: " + p.getLastName());
            System.out.println("tel: " + p.getTel());
            System.out.println("email: " + p.getEmail());
        }
        System.out.println("-------------------------------------");
    }
}
