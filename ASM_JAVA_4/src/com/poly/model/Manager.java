package com.poly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Manager")
public class Manager {
	@Id
	@Column(name = "Username")
	String userName;
	@Column(name = "Password")
	String password;
	@Column(name = "Fullname")
	String fullName;
	@Column(name = "Role")
	String role;
	@Column(name = "PhoneNumber")
	String phoneNumber;
	@Column(name = "Email")
	String email;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Manager() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public Manager(String userName, String password, String fullName, String role, String phoneNumber, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
