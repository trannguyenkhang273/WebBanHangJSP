package com.poly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BillId")
	int BillId;
	
	@Column(name="Username")
	String username;
	@Column(name="TotalMoney")
	Double totalMoney;
	@Column(name="PhoneNumber")
	String phoneNumber;
	@Column(name="Email")
	String email;
	@Column(name="Address")
	String address;
	@Column(name="Paid")
	Boolean paid;
	public int getBillId() {
		return BillId;
	}
	public void setBillId(int billId) {
		BillId = billId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
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
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getPaid() {
		return paid;
	}
	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
	public Bill() {
		super();
	}
	
	public Bill( String username, double i, String phoneNumber, String email, String address,
			Boolean paid) {
		super();
		this.username = username;
		this.totalMoney = (double) i;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.paid = paid;
	}
}
