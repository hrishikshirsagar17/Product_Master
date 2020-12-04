package com.spring.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entities.ProductAttribute;
import com.spring.rest.services.ProductAttributeServices;



@RestController
public class ProductAttributeController {
	@Autowired
	private ProductAttributeServices services;

	@GetMapping("/prodservices")
	public ResponseEntity<List<ProductAttribute>> getProducts()
	{
		 List<ProductAttribute> list = services.getAllProductAttributes();
		 if(list.size()<=0)
		 {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 
			return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/prodservices/{id}")
	public ResponseEntity<ProductAttribute> getCategoryById(@PathVariable("id") int id)
	{
		ProductAttribute product=null;
		try
		{
			product = services.getProductById(id);
		if(product==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		catch(Exception e)
		{
			System.out.println("Not Found...");
			e.printStackTrace();
		}
		
		return ResponseEntity.of(Optional.of(product));
	}
	
	@PostMapping("/prodservices")
	public ResponseEntity<ProductAttribute> addProductAttribute(@RequestBody ProductAttribute product)
	{
		ProductAttribute prod=null;
		try {
			prod=services.addProductAttribute(product);
			 return ResponseEntity.status(HttpStatus.CREATED).body(product);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	
	@PutMapping("/prodservices/{id}")
	public ResponseEntity<Void> updateProductAttributeById(@RequestBody ProductAttribute product ,@PathVariable int id)
	{
		try
		{
			services.updateProductAttributeById(product, id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/prodservices/{id}")
	public ResponseEntity<Void> deleteProductAttributeById(@PathVariable int id)
	{
		try
		{
			services.deleteProductAttributeById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	

}
