package com.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
	@GetMapping("/loginok")
	public String loginOk(Authentication authentication) {
		System.out.println(authentication);
		System.out.println("login ok ...");
		System.out.println(authentication.getAuthorities().iterator().next().getAuthority());

		return "redirect:/users/users";
	}
}
