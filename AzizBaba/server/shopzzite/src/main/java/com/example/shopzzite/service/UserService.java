package com.example.shopzzite.service;

import java.util.List;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.shopzzite.model.User;
import com.example.shopzzite.model.UserRole;

public interface UserService {
	
	//creating user
	public User createuser(User user,Set<UserRole> userRoles) throws Exception;
	
	//get user by username
	
	public User getUser(String username);
	
	//delete by id
	
	public void deleteUser(Long userId);

	public List<User> getallUser();
	

	
		
		
	
}
