package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.UserBean;
import com.constants.Role;
import com.util.DbConnection;

public class UserDao {

	public void addUser(UserBean userBean) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"insert into users (firstName,email,password,enrollmentNum,role,approve) values (?,?,?,?,?,?) ");
			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2, userBean.getEmail());
			pstmt.setString(3, userBean.getPassword());
			pstmt.setString(4, userBean.getEnrollmentNum());
			pstmt.setInt(5, userBean.getRole());
			pstmt.setBoolean(6, userBean.isApprove());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<UserBean> getAllStudents() {
		ArrayList<UserBean> students = new ArrayList<UserBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where role = ? ");
			pstmt.setInt(1, Role.STUDENT.role);

			ResultSet rs = pstmt.executeQuery(); // cursor
			while (rs.next()) {
				UserBean user = new UserBean();
				user.setUserId(rs.getInt("userId"));
				user.setFirstName(rs.getString("firstName"));
				user.setEmail(rs.getString("email"));
				user.setEnrollmentNum(rs.getString("enrollmentNum"));
				user.setApprove(rs.getBoolean("approve"));
				students.add(user);

			}
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void changeStudentStatus(Integer userId, Boolean currentStatus) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set approve = ? where userId = ? ");
			pstmt.setBoolean(1, !currentStatus);
			pstmt.setInt(2, userId);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserBean authenticate(String email, String password) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("select * from users where email = ? and password = ? and approve = ?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			pstmt.setBoolean(3, true);

			ResultSet rs = pstmt.executeQuery();//
			if (rs.next()) {
				UserBean user = new UserBean();
				user.setUserId(rs.getInt("userId"));
				user.setEmail(rs.getString("email"));
				user.setRole(rs.getInt("role"));
				user.setFirstName(rs.getString("firstName"));
				return user;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
