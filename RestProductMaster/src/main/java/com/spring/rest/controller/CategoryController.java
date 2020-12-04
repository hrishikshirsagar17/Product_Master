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

import com.spring.rest.entities.Category;
import com.spring.rest.services.CategoryService;



@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getCategories()
	{
		 List<Category> list = categoryService.getAllCategories();
		 if(list.size()<=0)
		 {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 
			return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id)
	{
		Category category=null;
		try
		{
			category = categoryService.getCategoryById(id);
		if(category==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		catch(Exception e)
		{
			System.out.println("Not Found...");
			e.printStackTrace();
		}
		
		return ResponseEntity.of(Optional.of(category));
	}
	
	@PostMapping("/categories")
	public ResponseEntity<Category> addCategory(@RequestBody Category category)
	{
		Category cat=null;
		try {
			cat=categoryService.addCategory(category);
			 return ResponseEntity.status(HttpStatus.CREATED).body(category);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	
	@PutMapping("/categories/{id}")
	public ResponseEntity<Void> updateCategory(@RequestBody Category category ,@PathVariable int id)
	{
		try
		{
			categoryService.updateCategoryById(category, id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable int id)
	{
		try
		{
			categoryService.deleteCategoryById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
}