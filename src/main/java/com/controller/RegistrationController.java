package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.UserBean;

@Controller
public class RegistrationController {

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		System.out.println("calling signup....");
		return "Signup";
	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUser(UserBean user,HttpServletRequest request) {
		System.out.println("save user-------------------");
		System.out.println(user.getFirstName());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		request.setAttribute("myUser", user);
		return "Home";//
	}

}












