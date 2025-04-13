package com.example.demo.model;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String email;
    private String password;
    private String phno;
    private String address;
    private String landmark;
    private String city;
    private String state;
    private String pincode;

    // Default Constructor
  
// Constructor for user registration (without ID, address, etc.)
public User(String name, String email, String phno, String password) {
    this.name = name;
    this.email = email;
    this.phno = phno;
    this.password = password;
  
}

public User(int id, String name, String email,String password, String phno, String address) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.phno = phno;
    this.address = address;
   
}
public User(String name, String email,String password, String phno, String address) {
   
    this.name = name;
    this.email = email;
    this.password = password;
    this.phno = phno;
    this.address = address;
   
}

    // Parameterized Constructor
    public User(int id, String name, String email, String password, String phno, 
                String address, String landmark, String city, String state, String pincode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phno = phno;
        this.address = address;
        this.landmark = landmark;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhno() { return phno; }
    public void setPhno(String phno) { this.phno = phno; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getLandmark() { return landmark; }
    public void setLandmark(String landmark) { this.landmark = landmark; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }

    // Secure toString() - Hides password
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + 
               ", password=****, phno=" + phno + ", address=" + address + 
               ", landmark=" + landmark + ", city=" + city + ", state=" + state + 
               ", pincode=" + pincode + "]";
    }
}
