package com.example.shopzzite.service;
import java.util.*;

import com.example.shopzzite.model.AddToCart;

public interface CartService {
	List<AddToCart> addcartbyuserIdAndProductId(int productId, int userId);
	List<AddToCart>getCartByUserId(int id);
	List<AddToCart>removeCartByUserId(int cartId,int userId);
	}