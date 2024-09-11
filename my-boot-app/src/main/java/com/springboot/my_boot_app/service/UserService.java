package com.springboot.my_boot_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.my_boot_app.model.User;
import com.springboot.my_boot_app.repository.UserRepository;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	 
	public User adduser(User user) {
		 //encrypt the password 
		String plainText = user.getPassword();
		//encode this  
		String encryptedPassword  = passwordEncoder.encode(plainText);
		//attach this to User obj 
		user.setPassword(encryptedPassword);
		
		return userRepository.save(user);
	}

	

}
