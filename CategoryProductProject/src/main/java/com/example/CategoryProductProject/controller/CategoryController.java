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
import com.example.CategoryProductProject.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryService repo;

	@GetMapping("/api/categories")
	public ResponseEntity<List<Category>> getAllCategory(
			@RequestParam(value="page", defaultValue="1",required=false)int page) {
		return repo.getAllCategories(page);
	}

	@PostMapping("/api/categories")
	public String createCategory(@RequestBody Category cat) {
		return repo.createNewCategory(cat);
	}

	@GetMapping("/api/categories/{id}")
	public ResponseEntity<Category> readCategory(@PathVariable int id) {
		return repo.getById(id);
	}

	@PutMapping("/api/categories/{id}")
	public String updateCategory(@PathVariable int id, @RequestBody Category cat) {
		return repo.updateById(id, cat);
	}

	@DeleteMapping("/api/categories/{id}")
	public String deleteCategory(@PathVariable int id) {
		return repo.deleteById(id);
	}
}
