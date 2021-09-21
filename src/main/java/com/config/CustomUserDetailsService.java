package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.entity.UserEntity;
import com.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	// List
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//if(username.contains("@") ) {
			//findByEmail 
		//}else{ findByUsername()
		
		UserEntity user = userRepo.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid credentials");
		}
		return new CustomUserDetails(user);
		// ArrayList
	}

}
