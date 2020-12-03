package com.spring.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.entity.ProductAttribute;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Integer>{

	public ProductAttribute findById(int id);
}
