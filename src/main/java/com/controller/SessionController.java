package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.UserEntity;
import com.repository.UserRepository;

@Controller
public class SessionController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/signup")
	public String signup() {
		System.out.println("signup()");
		return "Signup";
	}
	@PostMapping("/saveuser")
	public String saveUser(UserEntity user) {
		//user -> 
		userRepository.save(user);
		return "Login";
	}
}
