package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.UserEntity;
import com.repository.UserRepository;

@RestController
public class UserApiController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public List<UserEntity> getAllUsers(){
		
		List<UserEntity> users = userRepository.findAll();
		
		return users;
	}
}
