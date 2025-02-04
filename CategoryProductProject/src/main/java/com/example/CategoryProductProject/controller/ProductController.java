package com.example.CategoryProductProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CategoryProductProject.entity.Category;
import com.example.CategoryProductProject.entity.Product;
import com.example.CategoryProductProject.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService repo;
	
	@GetMapping("/api/products")
	public ResponseEntity<List <Product>> getAllProduct(
			@RequestParam(value="page", defaultValue="1",required=false)int page)
	{
		return repo.getAllProducts(page);
	}
	
	@PostMapping("/api/products")
	public String createProduct(@RequestBody Product pro)
	{
		return repo.createNewProduct(pro);	
	}
	
	@GetMapping("/api/products/{id}")
	public String readProduct (@PathVariable int id)
	{
		return repo.getById(id);
	}
	
	@PutMapping("/api/products/{id}")
	public String updateProduct (@PathVariable int id,@RequestBody Product pro)
	{
		return repo.updateById(id, pro);
	}
	
	@DeleteMapping("/api/products/{id}")
	public String deleteProduct (@PathVariable int id)
	{
		return repo.deleteById(id);
	}
}
