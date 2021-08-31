package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CustomerBean;
import com.bean.LoginBean;
import com.bean.ResponseBean;
import com.dao.CustomerDao;
import com.util.TokenGenerator;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	CustomerDao customerDao;

	@Autowired
	TokenGenerator tokenGenerator;

	@PostMapping("/signup")
	public ResponseBean<CustomerBean> addCustomer(@RequestBody CustomerBean customer) {

		ResponseBean<CustomerBean> res = new ResponseBean<>();
		customerDao.addCustomer(customer);
		res.setData(customer);
		res.setMessage("customer save");
		res.setStatus(200);
		return res;
	}

	@PostMapping("/authenticate")
	public ResponseBean<CustomerBean> authenticate(@RequestBody LoginBean login) {
		System.out.println("inside --authenticate-----");
		ResponseBean<CustomerBean> res = new ResponseBean<>();

		CustomerBean customer = customerDao.authenticate(login.getEmail(), login.getPassword());
		if (customer == null) {
			res.setStatus(-1);
			res.setData(customer);
			res.setMessage("Invalid Credentials");
		} else {
			String token = tokenGenerator.generateToken();
			customer.setToken(token);
			customerDao.updateToken(customer.getCustomerId(), token);
			res.setData(customer);
			res.setStatus(200);
			res.setMessage("authentication done");
		}

		return res;
	}

	@GetMapping("/getcustomerbytoke/{token}")
	public ResponseBean<CustomerBean> getCustomerByToken(@PathVariable("token") String token) {

		ResponseBean<CustomerBean> res = new ResponseBean<>();

		CustomerBean customer = customerDao.getCustomerByToken(token);

		if (customer == null) {
			res.setStatus(-1);
			res.setData(customer);
			res.setMessage("Invalid token");
		} else {
			res.setData(customer);
			res.setStatus(200);
			res.setMessage("customer retrieved...");
		}
		return res;
	}

}
