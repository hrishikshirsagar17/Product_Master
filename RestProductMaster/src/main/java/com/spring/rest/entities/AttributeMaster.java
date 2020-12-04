package com.spring.rest.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class AttributeMaster implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int attId;
	private String name;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "AttributeCatMaster",
		joinColumns = { @JoinColumn(name = "AttributeId")},
		inverseJoinColumns = { @JoinColumn (name = "CatId")})
	private Set<Category> catagory= new HashSet<>();
	public AttributeMaster() {
		super();
	}
	public int getAttId() {
		return attId;
	}
	public void setAttId(int attId) {
		this.attId = attId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Category> getCatagory() {
		return catagory;
	}
	public void setCatagory(Set<Category> atts) {
		this.catagory = atts;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "AttributesMster [attId=" + attId + ", name=" + name + ", catagory=" + catagory + "]";
	}
	public AttributeMaster(int attId, String name, Set<Category> atts) {
		super();
		this.attId = attId;
		this.name = name;
		this.catagory = atts;
	}
	


	
	

}
