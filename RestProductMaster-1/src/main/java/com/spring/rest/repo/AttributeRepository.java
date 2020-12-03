package com.spring.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.rest.entity.AttributeMaster;

@Repository
public interface AttributeRepository extends JpaRepository<AttributeMaster, Integer>{

	public AttributeMaster findById(int id);
}
