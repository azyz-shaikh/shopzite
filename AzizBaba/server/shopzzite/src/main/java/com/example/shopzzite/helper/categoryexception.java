package com.example.shopzzite.helper;

public class categoryexception extends Exception {

	public categoryexception()
	{
		super("category with this  name already exist!!!");
	}
	public categoryexception (String msg)
	{
		super(msg);
	}
}
