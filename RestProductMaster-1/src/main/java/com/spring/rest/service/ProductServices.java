package com.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.entity.Product;
import com.spring.rest.repo.ProductRepository;



@Service
public class ProductServices {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts()
	{
		List<Product> list = (List<Product>)productRepository.findAll();
		return list;
	}
	
	public Product getProductById(int id)
	{
		Product product = productRepository.findById(id);
		return product;
	}
	
	public Product addProduct(Product product)
	{
		Product result = productRepository.save(product);
		return result;
	}
	
	
	public void updateProductById(Product product, int id)
	{
		product.setId(id);
		productRepository.save(product);
	}
	
	public void deleteProductById(int id)
	{
		productRepository.deleteById(id);
	}
}
