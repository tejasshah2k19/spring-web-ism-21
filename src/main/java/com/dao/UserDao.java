package com.dao;

import java.util.ArrayList;
import java.util.function.Predicate;

import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	ArrayList<UserBean> users = new ArrayList<UserBean>();

	public void insertUser(UserBean user) {
		users.add(user);
	}

	public ArrayList<UserBean> getAllUsers() {
		return users;
	}

	public boolean deleteUser(int userId) {
		// Stream api
		// lambda
		System.out.println(users.size());

//		Predicate<UserBean> p = x => x.userId == userId; 
//		users.removeIf();

		for (UserBean user : users) {
			if (user.getUserId() == userId) {

				users.remove(user);
				return true;
			}
		}
		//
		System.out.println(users.size());
		return false;
	}

	public UserBean getDataByPk(int userId) {
		for (UserBean user : users) {
			if (user.getUserId() == userId) {
				return user;
			}
		}

		return null;
	}
}
