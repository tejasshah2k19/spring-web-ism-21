package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserRepository userRepo;
//	@GetMapping("/users")
//	public ModelAndView getAllUsers() {
//
// 
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("users",null);
//		mv.setStatus(HttpStatus.ACCEPTED);
//		mv.setViewName("ListAllUsers");
//		return mv;
//	}

	@GetMapping(value = { "/users", "/" })
	public String getAllUsers(Model model) {

		model.addAttribute("users", userRepo.findAll());
		return "ListAllUsers";
	}

	@GetMapping("/users/{userId}")
	public String getUserById(@PathVariable("userId") Long userId, Model model) {
		model.addAttribute("user", userRepo.getById(userId));
		return "ViewUser";
	}

	@GetMapping("/usersbyfirstname/{firstName}")
	public String getUserById(@PathVariable("firstName") String firstName, Model model) {
		model.addAttribute("user", userRepo.findByFirstName(firstName));
		return "ViewUser";
	}

}
