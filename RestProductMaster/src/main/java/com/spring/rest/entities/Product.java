package com.spring.rest.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.sun.istack.NotNull;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int productId;
	
	@NotNull
	private String name;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(nullable = false, referencedColumnName = "catId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Category cat;

	private double price;

	@Column(name = "Description")
	private String desc;

	public Product() {
		super();
	}

	public Product(int productId, String name, Category cat, double price, String desc) {
		super();
		this.productId = productId;
		this.name = name;
		this.cat = cat;
		this.price = price;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", cat=" + cat + ", price=" + price + ", desc="
				+ desc + "]";
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	



	
}
