package com.example.shopzzite.service.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopzzite.helper.ProductFoundException;
import com.example.shopzzite.helper.categoryexception;
import com.example.shopzzite.model.Category;
import com.example.shopzzite.model.Product;
import com.example.shopzzite.repository.CategoryRepository;
import com.example.shopzzite.service.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) throws Exception
	{
		// TODO Auto-generated method stub
		Category catsi=this.categoryRepository.findBycategoryTitle(category.getCategoryTitle());
		if(catsi!=null)
		{
			System.out.println("found the categorytitle");
			throw new categoryexception();
			
		}
		
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
	  return this.categoryRepository.findAll();
	}

	@Override
	public Category getCategory(int categoryId) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(categoryId).get();
	}

	@Override
	public void deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		
		Category category= new Category();
		category.setCategoryId(categoryId);
		this.categoryRepository.delete(category);
		
	}

}
