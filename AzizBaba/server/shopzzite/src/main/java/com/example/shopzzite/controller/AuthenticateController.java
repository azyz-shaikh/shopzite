package com.example.shopzzite.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopzzite.config.JwtUtils;
import com.example.shopzzite.helper.UserNotFoundException;
import com.example.shopzzite.model.JwtRequest;
import com.example.shopzzite.model.JwtResponse;
import com.example.shopzzite.model.User;
import com.example.shopzzite.service.impl.UserDetailsServiceImpl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
@RestController
@CrossOrigin("*")
public class AuthenticateController {
	
	@Autowired
	private AuthenticationManager AuthenticationManager;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private JwtUtils jwtUtils;
	
	
	//generate token
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		
		
		try {
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			
		}
		catch(UserNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("user not found");
			
			
		}
		
	UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
	String token=	this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	
	
	private void authenticate(String username,String password) throws Exception
	{
		try {
			
			AuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
			

		}
		catch(DisabledException e)
		{
			
			throw new Exception ("user disabled exception"+e.getMessage());
			
		}
		
		catch(BadCredentialsException e)
		{
			throw new Exception("invalid credentials"+e.getMessage());
		}
		
		
	}
	
	//current user details 
	
	@GetMapping("/current-user")
	@CrossOrigin("*")

	public User getCurrentUser(Principal principal)
	{
		return ((User)this.userDetailsService.loadUserByUsername(principal.getName()));
		
	}
	

}
