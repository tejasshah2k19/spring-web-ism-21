package com.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class RegistrationController {

	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		System.out.println("calling signup....");
		return "Signup";
	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUser(UserBean user,Model model) {
	
		//local
		
		userDao.insertUser(user);
	
		System.out.println("save user-------------------");

		model.addAttribute("myUser", user);
		return "Home";//
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {

		model.addAttribute("users",userDao.getAllUsers());
		return "ListUsers";
	}

}












