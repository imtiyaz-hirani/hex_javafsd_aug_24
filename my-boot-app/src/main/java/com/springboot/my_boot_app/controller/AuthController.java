package com.springboot.my_boot_app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my_boot_app.dto.MessageDto;
import com.springboot.my_boot_app.model.User;
import com.springboot.my_boot_app.service.SecurityUserService;

@RestController
public class AuthController {

	@Autowired
	private SecurityUserService securityUserService;
	
	@GetMapping("/auth/login")
	public ResponseEntity<?> login(Principal principal, MessageDto dto) {
		/* 
		 * if spring comes here then it has already checked username/password 
		   Now, we must take user details from spring 
		   
		   NOTE: Spring will never share password, it will however share username using which we 
		   can fetch user info.
		 */
		try {
		String username = principal.getName(); //this is the username of loggedIn user
		User user = (User) securityUserService.loadUserByUsername(username);
		return ResponseEntity.ok(user);
		}
		catch(Exception e) {
			dto.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		}
	}
}
