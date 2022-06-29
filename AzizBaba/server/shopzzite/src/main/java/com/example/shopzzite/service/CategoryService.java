package com.example.shopzzite.service;

import java.util.List;
import java.util.Set;

import com.example.shopzzite.model.Category;

public interface CategoryService {
	
	public Category addCategory(Category category) throws Exception;
	public Category updateCategory(Category category);
	public List<Category> getCategories();
	public Category getCategory(int categoryId);
	public void deleteCategory(int categoryId);

}
