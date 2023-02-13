package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.PassBean;
import com.util.DbConnection;

public class PassDao {

	public void addPassRequest(PassBean pass) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("insert into pass (userId,reason,outtime,approve,passDate) values (?,?,?,?,?)");
			pstmt.setInt(1, pass.getUserId());
			pstmt.setString(2, pass.getReason());
			pstmt.setString(3, pass.getOutTime());
			pstmt.setBoolean(4, pass.getApprove());
			pstmt.setString(5, pass.getPassDate());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
