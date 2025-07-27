package com.example.Aadhar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity 
public class Aadharreg {
@Id @GeneratedValue
int Id;
String name;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getAadharnumber() {
	return aadharnumber;
}
public void setAadharnumber(String aadharnumber) {
	this.aadharnumber = aadharnumber;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
@Override
public String toString() {
	return "Aadharreg [Id=" + Id + ", name=" + name + ", gender=" + gender + ", aadharnumber=" + aadharnumber + ", dob="
			+ dob + ", address=" + address + ", state=" + state + ", phonenumber=" + phonenumber + "]";
}
String gender;
String aadharnumber;
String dob ;
String address;
String state;
int phonenumber;
public int getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(int phonenumber) {
	this.phonenumber = phonenumber;
}
}