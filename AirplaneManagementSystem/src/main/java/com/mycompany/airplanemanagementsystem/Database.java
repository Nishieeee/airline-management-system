/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.airplanemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class Database {
    private final String url = "jdbc:mysql://localhost:3306/airlinemanagementsystem";
    private final  String user = "root";
    private final String password = "";
    private final Statement statement;
    
    public Database() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    
    public void AddPassenger(Passenger p) throws SQLException {
        String insert = "INSERT INTO `passengers`(`id`, `FirstName`, `LastName`, `Tel`, `email`) VALUES ('"+p.getId()+"','"+p.getFirstName()+"','"+p.getLastName()+"','"+p.getTel()+"','"+p.getEmail()+"');";
        statement.execute(insert);
        
    }
    public ArrayList<Passenger> getAllPassengers() throws SQLException {
        String get = "SELECT * FROM `passengers`;";
        ResultSet rs = statement.executeQuery(get);
        ArrayList<Passenger> passengers = new ArrayList<>();
        
        while (rs.next()) {
            Passenger p = new Passenger();
            p.setId(rs.getInt("id"));
            p.setFirstName(rs.getString("firstName"));
            p.setLastName(rs.getString("lastName"));
            p.setTel(rs.getString("Tel"));
            p.setEmail(rs.getString("email"));
            passengers.add(p);
        }
        return passengers;
    }

}
