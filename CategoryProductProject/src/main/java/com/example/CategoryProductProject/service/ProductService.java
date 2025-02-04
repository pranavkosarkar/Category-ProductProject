package com.example.CategoryProductProject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.CategoryProductProject.entity.Product;

public interface ProductService {

	public ResponseEntity<List<Product>> getAllProducts(int pageSize);

	public String createNewProduct(Product pro);

	public String getById(int id);

	public String updateById(int id, Product pro);

	public String deleteById(int id);
}
