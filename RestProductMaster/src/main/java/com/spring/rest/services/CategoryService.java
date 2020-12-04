package com.spring.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.dao.CategoryRepository;
import com.spring.rest.entities.Category;


@Service
public class CategoryService {
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
		category.setCatId(id);
		categoryRepository.save(category);
	}
	
	
	public void deleteCategoryById(int id)
	{
		categoryRepository.deleteById(id);
	}
	
	
}
