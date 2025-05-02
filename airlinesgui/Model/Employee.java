package com.mycompany.airlinesgui.Model;

public class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String Tel;
	private double salary;
	private String position;
	
	public Employee() {}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getName() {
		return firstName+" "+lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setTel(String Tel) {
		this.Tel = Tel;
	}
	
	public String getTel() {
		return Tel;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double getSalaray() {
		return salary;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getPosition() {
		return position;
	}
	
	public String[] getData() {
		return new String[] {
			String.valueOf(id),
			firstName+" "+lastName,
			Tel,
			email,
			salary+"$",
			position
		};
	}

}
