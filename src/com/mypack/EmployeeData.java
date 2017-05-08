package com.mypack;

public class EmployeeData {
	private int id;
	private String name;
	private String password;
	private String email;
	private String country;
	

public void setId(int id){
		this.id=id;
	}
public int getId(){
	return id;
}
public void setName(String name){
	this.name=name;
}
public String getName(){
	return name;
}
public void setPassword(String password){
	this.password=password;
}
public String getPassword(){
	return password;
}
public void setEmail(String email){
	this.email=email;
}
public String getEmail(){
	return email;
}
public void setCountry(String country){
	this.country=country;
}
public String getCountry(){
	return country;
}

}