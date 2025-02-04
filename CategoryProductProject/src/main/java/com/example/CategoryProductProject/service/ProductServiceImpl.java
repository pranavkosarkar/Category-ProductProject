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
import com.example.CategoryProductProject.entity.Product;
import com.example.CategoryProductProject.repository.CategoryRepository;
import com.example.CategoryProductProject.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository repo;
	@Autowired
	CategoryRepository cato;

	@Override
	public ResponseEntity<List<Product>> getAllProducts(int pageSize) {
		// TODO Auto-generated method stub
		Pageable p = PageRequest.ofSize(pageSize);
		Page<Product> pagePro = repo.findAll(p);
		return new ResponseEntity<List<Product>>(pagePro.getContent(), HttpStatus.OK);
	}

	@Override
	public String createNewProduct(Product pro) {
		// TODO Auto-generated method stub
		repo.save(pro);
		return "Product created in database";

	}

	@Override
	public String getById(int id) {
		// TODO Auto-generated method stub
		Optional<Product> pro = repo.findById(id);
		if (pro.isEmpty())
                return "Product with id= "+id+" does not exists";
			else {
				Category cat = cato.findByProduct(pro.get());
			return "Product Details\n"
					+"Id: "+pro.get().getId()
		            +"\nName: "+pro.get().getName()
		            +"\nPrice: "+pro.get().getPrice()
		            +"\nCategory id: "+cat.getId()
		            +"\nCategory name: "+cat.getName();
			}
	}

	@Override
	public String updateById(int id, Product pro) {
		// TODO Auto-generated method stub
		Optional<Product> product = repo.findById(id);
		if (product.isEmpty())
			return "Category details does not exist for id" + id;
		else {
			Product proExist = product.get();
			proExist.setId(pro.getId());
			proExist.setName(pro.getName());
			proExist.setPrice(pro.getPrice());
			repo.save(proExist);
			return "Product details updated successfully";
		}

	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		Optional<Product> cat = repo.findById(id);
		if (cat.isEmpty())
			return "Category details does not exist for id" + id;
		else
			repo.delete(cat.get());
		return "Product deleted successfully";

	}

}
