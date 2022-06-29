package com.example.shopzzite.helper;

public class UserFoundExecption extends Exception{
	public UserFoundExecption()
	{
		super("user already exist!!!");
	}
	public UserFoundExecption(String msg)
	{
		super(msg);
	}

}
