package com.spring.rest.entity;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

public class CategoryAttributeMaster implements Serializable{

	private static final long serialVersionUID = -5256964752749862543L;
	
	@Id
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(nullable = false,referencedColumnName = "att")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private AttributeMaster attributeMaster;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(nullable = false,referencedColumnName = "category_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Category category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AttributeMaster getAttributeMaster() {
		return attributeMaster;
	}

	public void setAttributeMaster(AttributeMaster attributeMaster) {
		this.attributeMaster = attributeMaster;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
