package com.example.shopzzite.helper;

public class ProductFoundException extends Exception {
	
	public ProductFoundException()
	{
		super("product with this product name already exist!!!");
	}
	public ProductFoundException(String msg)
	{
		super(msg);
	}


}
