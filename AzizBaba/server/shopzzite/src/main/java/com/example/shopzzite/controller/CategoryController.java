package com.example.shopzzite.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopzzite.model.Category;
import com.example.shopzzite.model.User;
import com.example.shopzzite.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	

	//add category
	
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) throws Exception
	{
		Category category1=  this.categoryService.addCategory(category);
		return ResponseEntity.ok(category1);
		
	}
	
	//get category which is single
	
	@GetMapping("/{categoryId}")
	
	public Category getCategory(@PathVariable("categoryId")int categoryId)
	{
		return this.categoryService.getCategory(categoryId);
	}
	
	
	//get all category
	
	/*@GetMapping("/")
	
	
	public ResponseEntity<?> getCategories()
	{
		return ResponseEntity.ok(this.categoryService.getCategories());
	}*/
	
	
	//update
	
	@PutMapping("/")
	
	public Category updateCategory(@RequestBody Category category)
	{
		return this.categoryService.updateCategory(category);
	}
	
	
	//delete
	
	@DeleteMapping("/{categoryId}")
	
	public void deleteCategory(@PathVariable("categoryId")int categoryId)
	{
		this.categoryService.deleteCategory(categoryId);
	}
	
	
	@GetMapping(path="getcat")
	public List<Category> getallcaCategories()
	{
		return categoryService.getCategories();
	}
	

}
