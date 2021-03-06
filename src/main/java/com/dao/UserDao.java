package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bean.RoleBean;
import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public int saveUser(final UserBean user) {
		// exeu -> state -->
		// exeq --> read

//		stmt.update("insert into users (firstName,email,password) values (?,?,?)", user.getFirstName(), user.getEmail(),
//				user.getPassword()); // insert ->  1 
//	

		// method local inner class ---> final
		KeyHolder keyHolder = new GeneratedKeyHolder();
		stmt.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into users (firstName,email,password,roleId) values (?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, user.getFirstName());
				pstmt.setString(2, user.getEmail());
				pstmt.setString(3, user.getPassword());
				pstmt.setInt(4, user.getRole().getRoleId());
				return pstmt;
			}
		}, keyHolder);
		int userId = keyHolder.getKey().intValue();
		System.out.println(userId);
		return userId;
	}

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

	public List<UserBean> getUsers() {

		List<UserBean> users = stmt.query("select * from users", new UserRowMapper());
		return users;
	}

	public List<UserBean> getUsers1() {
		List<UserBean> users = stmt.query("select r.rolename,u.* from users u inner join role r on u.roleid = r.roleid",
				new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return users;
	}

	class UserRowMapper implements RowMapper<UserBean> {

		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			UserBean user = new UserBean();
			user.setUserId(rs.getInt("userId"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setFirstName(rs.getString("firstName"));
//			user.setRoleName(rs.getString("roleName"));

			RoleBean role = new RoleBean();
			role.setRoleId(rs.getInt("roleId"));
			role.setRoleName(rs.getString("roleName"));
			user.setRole(role);

			return user;
		}

	}

	public boolean delUser(int userId) {
		stmt.update("delete from users where userId = ?", userId);
		return false;
	}

	public UserBean getDataByUserId(int userId) {
		UserBean user = null;
		try {
			user = stmt.queryForObject("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return user;
	}

	public boolean checkDuplicateEmail(String email) {

		List<UserBean> users = stmt.query("select * from users,role where email like ? and role.roleId = users.roleId",
				new UserRowMapper(), email);
		System.out.println(users.size());
		if (users.size() == 0)
			return false;
		else
			return true;
	}

}
