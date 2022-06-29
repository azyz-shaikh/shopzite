package com.example.shopzzite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopzzite.model.AddToCart;

public interface AddToCartRepository extends JpaRepository<AddToCart, Integer> {
	
}
