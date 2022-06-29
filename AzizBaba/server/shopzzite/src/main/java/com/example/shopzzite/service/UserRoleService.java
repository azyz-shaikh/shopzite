package com.example.shopzzite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shopzzite.model.User;
import com.example.shopzzite.model.UserRole;

public interface UserRoleService {
	
	public List<UserRole> getallUserRole();

}
