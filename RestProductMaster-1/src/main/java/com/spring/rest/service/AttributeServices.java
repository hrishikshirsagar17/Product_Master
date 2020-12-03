package com.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.entity.AttributeMaster;
import com.spring.rest.repo.AttributeRepository;

@Service
public class AttributeServices {

	@Autowired
	private AttributeRepository repository;
	
	
	public List<AttributeMaster> getAllAttributes()
	{
		List<AttributeMaster> list = (List<AttributeMaster>)repository.findAll();
		return list;
	}
	
	public AttributeMaster getAttributeById(int id)
	{
		AttributeMaster product = repository.findById(id);
		return product;
	}
	
	public AttributeMaster addAttribute(AttributeMaster product)
	{
		AttributeMaster result = repository.save(product);
		return result;
	}
	
	
	public void updateAttributeById(AttributeMaster product, int id)
	{
		product.setId(id);
		repository.save(product);
	}
	
	public void deleteAttributeById(int id)
	{
		repository.deleteById(id);
	}
}
