package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.UserBean;
import com.dao.UserDao;
import com.service.ImageService;

@Controller
public class RegistrationController {

	@Autowired
	UserDao userDao;

	@Autowired
	ImageService imgService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		System.out.println("calling signup....");
		model.addAttribute("user", new UserBean());
		return "Signup";
	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("user") UserBean user, BindingResult result,
			@RequestParam("profile") MultipartFile file, Model model) {

		if (result.hasErrors()) {
			System.out.println(result);
			model.addAttribute("user", user);
			return "Signup";
		} else {

			user.setProfilePath(imgService.uploadImage(file, "users"));
			// userDao.insertUser(user);
			userDao.saveUser(user);
			System.out.println("save user-------------------");

			model.addAttribute("myUser", user);
			return "Home";//
		}
	}

	@GetMapping("/users")
	public String listUsers(Model model) {
		model.addAttribute("users", userDao.getUsers1());
		return "ListUsers";
	}

	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") int userId) {
		boolean flag = userDao.deleteUser(userId);
		if (flag) {
			return "redirect:/users";

		} else {
			// model.addAttribute("error","Invalid UserId");
			return "ListUsers";
		}
	}

	@GetMapping("/deleteUserByPath/{userId}") // /12/33/sdfsdfsdf/sdfsdf/3434
	public String deleteUserByPath(@PathVariable("userId") int userId) {
		boolean flag = userDao.delUser(userId);

		return "redirect:/users";
	}

	@GetMapping("/edituser/{userId}")
	public String editUser(@PathVariable("userId") int userId, Model model) {
		UserBean user = userDao.getDataByPk(userId);
		model.addAttribute("user", user);
		return "EditUser";
	}

	@PostMapping("/updateuser")
	public String updateUser(UserBean user) {
		// code
		System.out.println(user.getEmail());
		return "redirect:/users";
	}

}
