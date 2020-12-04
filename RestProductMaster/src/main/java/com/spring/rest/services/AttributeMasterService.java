package com.spring.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.dao.AttributeMasterRepository;
import com.spring.rest.entities.AttributeMaster;


@Service
public class AttributeMasterService {
	@Autowired
	private AttributeMasterRepository repository;

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
		product.setAttId(id);
		repository.save(product);
	}
	
	public void deleteAttributeById(int id)
	{
		repository.deleteById(id);
	}
}
