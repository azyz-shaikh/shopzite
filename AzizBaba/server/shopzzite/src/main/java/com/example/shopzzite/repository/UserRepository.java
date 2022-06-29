package com.example.shopzzite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopzzite.model.User;
import com.example.shopzzite.model.UserRole;

public interface UserRepository extends  JpaRepository<User, Long> {

	public User findByUsername(String username);
	



}
