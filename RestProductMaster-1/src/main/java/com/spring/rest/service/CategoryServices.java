package com.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.entity.Category;
import com.spring.rest.repo.CategoryRepository;



@Service
public class CategoryServices {
	@Autowired
	private CategoryRepository categoryRepository;
	public List<Category> getAllCategories()
	{
		List<Category> list = (List<Category>)categoryRepository.findAll();
		return list;
	}
	
	public Category getCategoryById(int id)
	{
		Category category = categoryRepository.findById(id);
		return category;
	}
	
	public Category addCategory(Category category)
	{
		Category result = categoryRepository.save(category);
		return result;
	}
	
	
	public void updateCategoryById(Category category, int id)
	{
		category.setCategory_id(id);
		categoryRepository.save(category);
	}
	
	
	public void deleteCategoryById(int id)
	{
		categoryRepository.deleteById(id);
	}
	
}
