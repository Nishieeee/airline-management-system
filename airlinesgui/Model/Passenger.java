package com.mycompany.airlinesgui.Model;

public class Passenger {
	
	private int id;
	private String firstName;
	private String lastName;
	private String Tel;
	private String email;
	
	public Passenger() {}
	
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
	
	public void setTel(String Tel) {
		this.Tel = Tel;
	}
	
	public String getTel() {
		return Tel;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String[] getData() {
		return new String[] {
				String.valueOf(getId()),
				getFirstName()+" "+getLastName(),
				getTel(),
				getEmail()
		};
	}

}
