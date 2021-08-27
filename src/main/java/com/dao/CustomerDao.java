package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CustomerBean;

@Repository
public class CustomerDao {

	@Autowired
	JdbcTemplate stmt;

	public void addCustomer(CustomerBean customer) {
		stmt.update("insert into customer (firstName,email,password) values (?,?,?)", customer.getFirstName(),
				customer.getEmail(), customer.getPassword());
	}

	public CustomerBean authenticate(String email, String password) {

		CustomerBean customer = null;

		try {
			customer = stmt.queryForObject("select * from customer where email like ? and password like ?",
					new BeanPropertyRowMapper<CustomerBean>(CustomerBean.class), email, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return customer;
	}

	public void updateToken(int customerId, String token) {
		stmt.update("update customer set token = ? where customerId = ?", token, customerId);
	}

	public CustomerBean getCustomerByToken(String token) {
		CustomerBean customer = null;

		try {
			customer = stmt.queryForObject("select * from customer where token like ? ",
					new BeanPropertyRowMapper<CustomerBean>(CustomerBean.class), token);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return customer;
	}

}
