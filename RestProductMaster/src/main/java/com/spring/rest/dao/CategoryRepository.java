package com.spring.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.entities.Category;


public interface CategoryRepository extends JpaRepository<Category,Integer>{
	
	public Category findById(int id);
}
