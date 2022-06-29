package com.example.shopzzite.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopzzite.helper.UserFoundExecption;
import com.example.shopzzite.model.User;
import com.example.shopzzite.model.UserRole;
import com.example.shopzzite.repository.RoleRepository;
import com.example.shopzzite.repository.UserRepository;
import com.example.shopzzite.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	
	//creating user
	@Override
	public User createuser(User user, Set<UserRole> userRoles) throws Exception {
	
		User local= this.userRepository.findByUsername(user.getUsername());
		if(local!=null)
		{
			System.out.println("user already exist!!");
			throw new UserFoundExecption();
			
		}
		else
		{
			//user create
			for(UserRole ur: userRoles)
			{
				roleRepository.save(ur.getRole());
			}
			user.getUserRole().addAll(userRoles);
			local=this.userRepository.save(user);
			
		}
		return local;
	}


	//getting user by username
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}


	@Override
	public void deleteUser(Long userId) {
		 this.userRepository.deleteById(userId);
		
	}


	@Override
	public List<User> getallUser() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}




	
}
