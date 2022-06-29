package com.example.shopzzite;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.shopzzite.model.Role;
import com.example.shopzzite.model.User;
import com.example.shopzzite.model.UserRole;
import com.example.shopzzite.service.UserService;

@SpringBootApplication
public class ShopzziteApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ShopzziteApplication.class, args);	
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*User user=new User();
		user.setUsername("admin");
		user.setPassword(this.bCryptPasswordEncoder.encode("admin123"));
		user.setEmail("admin@gmail.com");
		Role role1= new Role();
		
		role1.setRoleId(1L);
		role1.setRoleName("ADMIN");
		Set<UserRole> userRoleSet= new HashSet<>();
		UserRole userRole= new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		userRoleSet.add(userRole);
   User user1=this.userService.createuser(user,userRoleSet);
   System.out.println(user1.getUsername());*/
		
		
	}
	
	

}
