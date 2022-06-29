package com.example.shopzzite.helper;

public class UserNotFoundException extends Exception{
	public UserNotFoundException()
	{
		super("User with this usernmae does not exist!! please register");
	}
	public UserNotFoundException(String msg) {
		super(msg);
	}

}
