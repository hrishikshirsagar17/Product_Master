package com.spring.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

	public Product findById(int id);

}
