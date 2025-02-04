package com.example.CategoryProductProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CategoryProductProject.entity.Product;

public interface ProductRepository extends JpaRepository <Product,Integer>
{

}
