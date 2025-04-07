/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.airplanemanagementsystem;

/**
 *
 * @author PC
 */

public class Passenger {
    
    private int id;
    private String firstName;
    private String lastName;
    private String tel;
    private String email;
  
    public Passenger() {
        
    }
    //id
    public void setId(int _id) {
        this.id = _id;
    }
    public int getId() {
        return this.id;
    }
    //fN
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    //lN
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return this.lastName;
    }
    //tel
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getTel() {
        return this.tel;
    }
    //email
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }
}

