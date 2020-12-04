package com.spring.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.entities.AttributeMaster;

public interface AttributeMasterRepository  extends JpaRepository<AttributeMaster,Integer>{

	public AttributeMaster findById(int id);
}
