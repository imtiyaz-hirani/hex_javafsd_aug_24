package com.springboot.my_boot_app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.my_boot_app.model.User;
import com.springboot.my_boot_app.repository.UserRepository;

@Service
public class SecurityUserService  implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	private Logger logger = LoggerFactory.getLogger(SecurityUserService.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user  =  userRepository.getUserByUsername(username);
		logger.info("User fetched by Spring " + user);
		return user;
	}
}
