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

import com.spring.rest.entities.AttributeMaster;
import com.spring.rest.services.AttributeMasterService;

@RestController
public class AttributeMasterController {

	@Autowired
	private AttributeMasterService attributeService;
	@GetMapping("/attributes")
	public ResponseEntity<List<AttributeMaster>> getAttributes()
	{
		 List<AttributeMaster> list = attributeService.getAllAttributes();
		 if(list.size()<=0)
		 {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 
			return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/attributes/{id}")
	public ResponseEntity<AttributeMaster> getAttributeById(@PathVariable("id") int id)
	{
		AttributeMaster attribute=null;
		try
		{
			attribute = attributeService.getAttributeById(id);
		if(attribute==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		catch(Exception e)
		{
			System.out.println("Not Found...");
			e.printStackTrace();
		}
		
		return ResponseEntity.of(Optional.of(attribute));
	}
	
	@PostMapping("/attributes")
	public ResponseEntity<AttributeMaster> addAttribute(@RequestBody AttributeMaster attribute)
	{
		AttributeMaster att=null;
		try {
			att=attributeService.addAttribute(attribute);
			 return ResponseEntity.status(HttpStatus.CREATED).body(attribute);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	
	@PutMapping("/attributes/{id}")
	public ResponseEntity<Void> updateAttribute(@RequestBody AttributeMaster attribute ,@PathVariable int id)
	{
		try
		{
			attributeService.updateAttributeById(attribute, id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/attributes/{id}")
	public ResponseEntity<Void> deleteAttribute(@PathVariable int id)
	{
		try
		{
			attributeService.deleteAttributeById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
