package com.example.shopzzite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopzzite.model.Category;
import com.example.shopzzite.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public List<Product> findBycategory(Category category);
	
	public Product findBypName(String pName);
	

}