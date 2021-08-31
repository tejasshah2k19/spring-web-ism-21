package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CartBean;
import com.bean.CustomerBean;
import com.bean.ResponseBean;
import com.dao.CartDao;
import com.dao.CustomerDao;

@RestController
@RequestMapping("/api/customers/")
public class CartController {

	@Autowired
	CartDao cartDao;

	@Autowired
	CustomerDao customerDao;

	@PostMapping("/addtocart")
	public ResponseBean<String> addToCart(@RequestBody CartBean cart, @RequestHeader("authToken") String authToken) {
		ResponseBean<String> resp = new ResponseBean<>();

		CustomerBean customer = customerDao.getCustomerByToken(authToken);
		if (customer == null) {
			resp.setData("Invalid Access");
			resp.setMessage("Please Login before access");
			resp.setStatus(-1);
		} else {
			cart.setCustomerId(customer.getCustomerId());
			cartDao.addCart(cart);

			resp.setData("Item Added into Cart");
			resp.setMessage("success");
			resp.setStatus(200);
		}
		return resp;

	}

	@GetMapping("/mycart")
	public ResponseBean<List<CartBean>> getCart(@RequestHeader("authToken") String authToken) {
		ResponseBean<List<CartBean>> resp = new ResponseBean<>();

		CustomerBean customer = customerDao.getCustomerByToken(authToken);
		if (customer == null) {
			resp.setData(null);
			resp.setMessage("Please Login before access");
			resp.setStatus(-1);
		} else {
			List<CartBean> carts = cartDao.getMyCart(customer.getCustomerId());
			resp.setData(carts);
			resp.setMessage("carts reterieved");
			resp.setStatus(200);
		}
		return resp;
	}

}
