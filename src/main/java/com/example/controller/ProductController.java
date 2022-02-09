package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.repo.ProductRepository;

@RestController
public class ProductController {
	
	
	@Autowired
	private ProductRepository repo;
	
	@PostMapping(value="/product",consumes = "application/json")
	public ResponseEntity<String> addData(@RequestBody Product produc)
	{
		repo.save(produc);
		return new ResponseEntity<String>("Product Saved",HttpStatus.CREATED);
		
	}
	
	
	@GetMapping(value="/products",produces = "application/json")
	public ResponseEntity<List<Product>> getPro()
	{
		List<Product> product = repo.findAll();
		return new ResponseEntity<List<Product>>(product,HttpStatus.OK);
	}

}
