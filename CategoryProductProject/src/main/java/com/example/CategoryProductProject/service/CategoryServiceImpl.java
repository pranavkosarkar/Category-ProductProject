package com.example.CategoryProductProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.CategoryProductProject.entity.Category;
import com.example.CategoryProductProject.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository repo;

	@Override
	public ResponseEntity<List<Category>> getAllCategories(int pageSize) {
		// TODO Auto-generated method stub
		Pageable p = PageRequest.ofSize(pageSize);
		Page<Category> pageCat = repo.findAll(p);
		return new ResponseEntity<List<Category>>(pageCat.getContent(), HttpStatus.OK);
	}

	@Override
	public String createNewCategory(Category cat) {
		// TODO Auto-generated method stub
		repo.save(cat);
		return "Category created in database";
	}

	@Override
	public ResponseEntity<Category> getById(int id) {
		// TODO Auto-generated method stub
		Optional<Category> cat = repo.findById(id);
		if (cat.isEmpty())
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Category>(cat.get(), HttpStatus.FOUND);
	}

	@Override
	public String updateById(int id, Category cat) {
		// TODO Auto-generated method stub
		Optional<Category> category = repo.findById(id);
		if (category.isEmpty())
			return "Category details does not exist for id" + id;
		else {
			Category catExist = category.get();
			catExist.setId(cat.getId());
			catExist.setName(cat.getName());
			catExist.setProduct(cat.getProduct());
			repo.save(catExist);
			return "Category details updated";
		}
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		Optional<Category> cat = repo.findById(id);
		if (cat.isEmpty())
			return "Category details does not exist for id" + id;
		else {
			repo.delete(cat.get());
			return "Category deleted successfully";

		}
	}

}
