package com.example.CategoryProductProject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.CategoryProductProject.entity.Category;

public interface CategoryService {

	public ResponseEntity<List<Category>> getAllCategories(int pageSize);

	public String createNewCategory(Category cat);

	public ResponseEntity<Category> getById(int id);

	public String updateById(int id, Category cat);

	public String deleteById(int id);
}
