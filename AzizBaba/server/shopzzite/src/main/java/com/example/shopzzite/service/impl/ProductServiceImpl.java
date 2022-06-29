package com.example.shopzzite.service.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopzzite.helper.ProductFoundException;
import com.example.shopzzite.model.Category;
import com.example.shopzzite.model.Product;
import com.example.shopzzite.repository.ProductRepository;
import com.example.shopzzite.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) throws Exception {
		
		
		// TODO Auto-generated method stub
		Product localp=this.productRepository.findBypName(product.getpName());
		if(localp!=null)
		{
			System.out.println("found the product");
			throw new ProductFoundException();
			
		}
		
		
		return this.productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return this.productRepository.save(product);
	}

	@Override
	public Set<Product> getProducts() {
		// TODO Auto-generated method stub
		 return new LinkedHashSet<> (this.productRepository.findAll());
	}

	@Override
	public Product getProduct(int productId) {
		return this.productRepository.findById(productId).get();
	}

	@Override
	public void deleteProduct(int productId) {
		
		Product product= new Product();
		product.setpId(productId);
		this.productRepository.delete(product);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getproductofcategory(Category category) {
		// TODO Auto-generated method stub
		return this.productRepository.findBycategory(category);
	}

	

}
