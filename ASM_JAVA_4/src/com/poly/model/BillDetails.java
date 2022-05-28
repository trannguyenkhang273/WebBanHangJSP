package com.poly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BillDetails")
public class BillDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BillDetailsId")
	int billDetailsId;
	
	@Column(name="BillId")
	int billId;
	
	@Column(name="IdProduct")
	String idProduct;
	
	@Column(name="Quantity")
	int quantity;
	
	@Column(name="Price")
	double price;

	

	

	public BillDetails() {
		super();
	}

	public BillDetails( int billId, String idProduct, int quantity, double price) {
		super();
		this.billId = billId;
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.price = price;
	}

	public int getBillDetailsId() {
		return billDetailsId;
	}

	public void setBillDetailsId(int billDetailsId) {
		this.billDetailsId = billDetailsId;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
	
}
