package com;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.UserEntity;

public class UserCRUD {
	SessionFactory sf = null;
	Scanner scr = new Scanner(System.in);

	public UserCRUD() {
		sf = new Configuration().configure().buildSessionFactory();
	}

	public static void main(String[] args) {
//		
//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sf = cfg.buildSessionFactory();
//		Session session = sf.openSession();

//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		System.out.println(cfg);
		Scanner scr = new Scanner(System.in);
		UserCRUD uc = new UserCRUD();// sf
		int choice = -1;

		while (true) {
			System.out.println(
					"1 For add user\n2 For List User\n3 For Update User\n4 For Delete User\n5 for GetUserByID\n0 for Exit\nEnter choice");
			choice = scr.nextInt();

			switch (choice) {
			case 1:
				uc.addUser();
				break;
			case 2:
				uc.listUsers();
				break;
			case 3:
				uc.updateUser();
				break;
			case 4:
				uc.deleteUser();
				break;
			case 5:
				uc.getDataById();
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Invalid Choice!!!!!");
			}
		}
	}

	void addUser() {

		System.out.println("Enter firstName email and password");
		String firstName = scr.next();
		String email = scr.next();
		String password = scr.next();

		UserEntity user = new UserEntity();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setPassword(password);

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(user);// insert query
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		session.close();
	}

	void getDataById() {
		System.out.println("Enter UserId");
		int userId = scr.nextInt();
		Session session = sf.openSession();

		UserEntity user = session.get(UserEntity.class, userId);
		if (user == null) {
			System.out.println("InvalidUserId");
		} else {
			System.out.println("User Detail : ");
			System.out.println("UserId : " + user.getUserId());
			System.out.println("FirstName : " + user.getFirstName());
			System.out.println("Email : " + user.getEmail());
			System.out.println("Password : " + user.getPassword());
		}
		session.close();
	}

	void deleteUser() {
		System.out.println("Enter UserId");
		int userId = scr.nextInt();
		Session session = sf.openSession();
		UserEntity user = session.get(UserEntity.class, userId);
		if (user == null) {
			System.out.println("InvalidUserId");
		} else {

			Transaction tx = session.beginTransaction();
			try {
				session.delete(user);//
				tx.commit();
				System.out.println("User Deleted.. ");

			} catch (Exception e) {
				tx.rollback();
				System.out.println("Sometinh went wrong !!! " + e.getMessage());
			}

		}
		session.close();

	}

	void updateUser() {
		System.out.println("Enter UserId");
		int userId = scr.nextInt();
		Session session = sf.openSession();
		UserEntity user = session.get(UserEntity.class, userId);
		if (user == null) {
			System.out.println("InvalidUserId");
		} else {

			Transaction tx = session.beginTransaction();

			System.out.println("Existing value : firstName : " + user.getFirstName());
			System.out.println("Do you want to update firstname?1 for yes?");
			int userChoice = scr.nextInt();
			if (userChoice == 1) {
				System.out.println("Enter new Firstname");
				user.setFirstName(scr.next());
			}

			System.out.println("Existing value : Email : " + user.getEmail());
			System.out.println("Do you want to update Email?1 for yes?");
			userChoice = scr.nextInt();
			if (userChoice == 1) {
				System.out.println("Enter new Email");
				user.setEmail(scr.next());
			}

			try {
				session.update(user);//
				tx.commit();
				System.out.println("User updated.. ");

			} catch (Exception e) {
				tx.rollback();
				System.out.println("Sometinh went wrong !!! " + e.getMessage());
			}

		}
		session.close();

	}

	void listUsers() {

		Session session = sf.openSession();			//select * from  users
		List<UserEntity> users = session.createQuery("From UserEntity", UserEntity.class).getResultList();

		System.out.println("UserId\tfirstName\temail\tpassword");
		for (UserEntity u : users) {
			System.out.println(
					u.getUserId() + "  \t" + u.getFirstName() + "   \t" + u.getEmail() + "  \t" + u.getPassword());
		}

		session.close();

	}

}
