package com.mycompany.airlinesgui.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mycompany.airlinesgui.View.Alert;

public class Database {
	
	private String url = "jdbc:mysql://localhost/airlinemanagementsystem";
	private String user = "root";
	private String pass = "";
	private Statement statement;
	
	public Database() {
		try {
			Connection connection = DriverManager.getConnection(url, user, pass);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
									ResultSet.CONCUR_READ_ONLY);
		} catch (Exception e) {
			new Alert(e.getMessage());
		}
	}
	
	public Statement getStatement() {
		return statement;
	}

}
