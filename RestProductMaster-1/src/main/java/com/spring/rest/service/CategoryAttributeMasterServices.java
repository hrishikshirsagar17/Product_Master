package com.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.entity.Category;
import com.spring.rest.entity.CategoryAttributeMaster;
import com.spring.rest.repo.CategoryAttributeMasterRepository;

@Service
public class CategoryAttributeMasterServices {

	@Autowired
	private CategoryAttributeMasterRepository categoryRepository;
	
	public List<CategoryAttributeMaster> getAllCategories()
	{
		List<CategoryAttributeMaster> list = (List<CategoryAttributeMaster>)categoryRepository.findAll();
		return list;
	}
	
	public CategoryAttributeMaster getCategoryById(int id)
	{
		CategoryAttributeMaster category = categoryRepository.findById(id);
		return category;
	}
	
	public CategoryAttributeMaster addCategory(CategoryAttributeMaster category)
	{
		CategoryAttributeMaster result = categoryRepository.save(category);
		return result;
	}
	
	
	public void updateCategoryById(CategoryAttributeMaster category, int id)
	{
		CategoryAttributeMaster Data = categoryRepository.findById(category.getId());
		categoryRepository.save(Data);
	}
	
	
	public void deleteCategoryById(int id)
	{
		categoryRepository.deleteById(id);
	}
	
}
