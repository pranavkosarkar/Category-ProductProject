package com.example.CategoryProductProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CategoryProductProject.entity.Category;
import com.example.CategoryProductProject.entity.Product;

public interface CategoryRepository extends JpaRepository <Category,Integer>
{
	public Category findByProduct(Product pro);
}
