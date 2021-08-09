package com.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class UserBean {

	int userId;

	@NotBlank(message="Please Enter FirstName")
	String firstName;

	@NotBlank(message="Please Enter Email")
	String email;

	String password;

	public UserBean() {
		userId = (int) (Math.random() * 1000000);// 0 265623.21314655323 * 1000000
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
