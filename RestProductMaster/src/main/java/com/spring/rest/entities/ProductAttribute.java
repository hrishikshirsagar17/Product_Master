package com.spring.rest.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductAttribute implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(nullable = false, referencedColumnName = "attId")
	private AttributeMaster attribute;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(nullable = false, referencedColumnName = "productId")
	private Product product;
	private String value;

	public ProductAttribute(int id, AttributeMaster attribute, Product product, String value) {
		super();
		this.id = id;
		this.attribute = attribute;
		this.product = product;
		this.value = value;
	}

	@Override
	public String toString() {
		return "ProductAttribute [id=" + id + ", attribute=" + attribute + ", product=" + product + ", value=" + value
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AttributeMaster getAttribute() {
		return attribute;
	}

	public void setAttribute(AttributeMaster attribute) {
		this.attribute = attribute;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ProductAttribute() {
		super();
	}
}
