package com.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	ArrayList<UserBean> users = new ArrayList<UserBean>();

	
	public void insertUser(UserBean user) {
		users.add(user);
	}
	
	public ArrayList<UserBean> getAllUsers(){
		return users;
	}
}



















