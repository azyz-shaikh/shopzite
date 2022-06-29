package com.example.shopzzite.controller;

import java.util.HashSet;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.SQLDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.shopzzite.helper.UserFoundExecption;
import com.example.shopzzite.model.Role;
import com.example.shopzzite.model.User;
import com.example.shopzzite.model.UserRole;
import com.example.shopzzite.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception
	{
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> roles= new HashSet<>();
		Role role= new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		UserRole userRole= new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		
		
		return this.userService.createuser(user, roles);
		
	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username")String username)
	{
		return this.userService.getUser(username);
		
	}
	
	//delete user by id
	
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId")Long UserId)
	{
		this.userService.deleteUser(UserId);
		
	}
	
	
	@GetMapping(path="getall")
	public List<User> getallUser()
	{
		return userService.getallUser();
	}
	
	
	
	
	
	
	
	
	
}
