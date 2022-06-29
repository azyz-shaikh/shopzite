package com.example.shopzzite.controller;

import java.util.List;
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
import com.example.shopzzite.model.Product;
import com.example.shopzzite.repository.ProductRepository;
import com.example.shopzzite.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	ProductRepository productRepository;
	
	
	
	@PostMapping("/")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws Exception
	{
		
		Product product1=  this.productService.addProduct(product);
		return ResponseEntity.ok(product1);
		
	}
	
	//get category which is single
	
	@GetMapping("/{productId}")
	
	public Product getProduct(@PathVariable int productId)
	{
		return this.productService.getProduct(productId);
	}
	
	
	//get all category
	
	@GetMapping("/")
	
	
	public ResponseEntity<?> getProducts()
	{
		return ResponseEntity.ok(this.productService.getProducts());
	}
	
	
	//update
	
	@PutMapping("/")
	
	public Product updateProduct(@RequestBody Product product)
	{
		return this.productService.updateProduct(product);
	}
	
	
	
	/*@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable  int pId,@RequestBody Product products) {{
		
		
		Product product= productRepository.findById(pId).orElseThrow();
		
		
		
		product.setpName(products.getpName());
		product.setpPrice(products.getpPrice());
		product.setpDesc(products.getpDesc());
		
		product.setpPhoto(products.getpPhoto());
		
		Product updateproduct =productRepository.save(product);
		
		return ResponseEntity.ok(updateproduct);
		
		
		
	}

	}*/
	
	
	//delete
	
	@DeleteMapping("/{productId}")
	
	public void deleteProduct(@PathVariable("productId")int productId)
	{
		this.productService.deleteProduct(productId);
	}
	
	@GetMapping("/category/{categoryId}")

	public List<Product> getproductofcategory(@PathVariable("categoryId")int categoryId)
	{
		Category category= new Category();
		category.setCategoryId(categoryId);
	
		return this.productService.getproductofcategory(category);
		
	}
	
	

}
