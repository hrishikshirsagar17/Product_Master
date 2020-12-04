package com.spring.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.entities.ProductAttribute;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Integer> {

	public ProductAttribute findById(int id);

}
