package com.poly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ImagePlus")
public class ImagePlus {
	@Id
	@Column(name="IdImagePlus")
	String idImagePlus;
	
	@Column(name="IdProduct")
	String idProduct;
	
	@Column(name="images")
	String images;

	public String getdImagePlus() {
		return idImagePlus;
	}

	public void setdImagePlus(String idImagePlus) {
		this.idImagePlus = idImagePlus;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	
	
	
}
