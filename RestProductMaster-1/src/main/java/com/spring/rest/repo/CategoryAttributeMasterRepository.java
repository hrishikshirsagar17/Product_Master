package com.spring.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.entity.CategoryAttributeMaster;

public interface CategoryAttributeMasterRepository extends JpaRepository<CategoryAttributeMaster, Integer>{

	public CategoryAttributeMaster findById(int id);
}
