package com.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.entity.ProductAttribute;
import com.spring.rest.repo.ProductAttributeRepository;

@Service
public class ProductAttributeServices {

	@Autowired
	private ProductAttributeRepository productAttributeRepository;
	
	public List<ProductAttribute> getAllProductAttributes()
	{
		List<ProductAttribute> list=(List<ProductAttribute>)productAttributeRepository.findAll();
		return list;
	}
	
	public ProductAttribute getProductById(int id)
	{
		ProductAttribute product = productAttributeRepository.findById(id);
		return product;
	}
	
	public ProductAttribute addProductAttribute(ProductAttribute productAttribute)
	{
		ProductAttribute result = productAttributeRepository.save(productAttribute);
		return result;
	}
	
	
	public void updateProductAttributeById(ProductAttribute productAttribute, int id)
	{
		productAttribute.setId(id);
		productAttributeRepository.save(productAttribute);
	}
	
	public void deleteProductAttributeById(int id)
	{
		productAttributeRepository.deleteById(id);
	}
}
