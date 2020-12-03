package com.spring.rest.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.entity.Category;


public interface CategoryRepository extends JpaRepository<Category,Integer>{

	public Category findById(int id);
}
