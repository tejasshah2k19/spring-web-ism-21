package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/deleteuser")
	public String deleteUser() {
		return "DeleteUser";
	}

	
	@GetMapping("/updateuser")
	public String updateUser() {
		return "UpdateUser";
	}

}


