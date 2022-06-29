package com.example.shopzzite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopzzite.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	public Category findBycategoryTitle(String categoryTitle);

}
