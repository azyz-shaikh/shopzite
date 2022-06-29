package com.example.shopzzite.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

import com.example.shopzzite.model.Category;
import com.example.shopzzite.model.Product;



public interface ProductService {

	
	public Product addProduct(Product product) throws Exception;
	public Product updateProduct(Product product);
	public Set<Product> getProducts();
	public Product getProduct(int productId);
	public void deleteProduct(int productId);
	
	public List<Product> getproductofcategory(Category category);
	
	
	
	
	

}
