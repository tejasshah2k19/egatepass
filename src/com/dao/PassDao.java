package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
			pstmt.setInt(4, pass.getApprove());
			pstmt.setString(5, pass.getPassDate());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<PassBean> getAllMyRequest(int userId) {
		ArrayList<PassBean> pastRequest = new ArrayList<PassBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from pass where userId = ? order by passId desc ");
			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();// select --> read

			while(rs.next()) {
				PassBean pass = new PassBean();
				
				pass.setUserId( rs.getInt("userId"));
				pass.setApprove(rs.getInt("approve"));
				pass.setOutTime(rs.getString("outtime"));
				pass.setPassDate(rs.getString("passDate"));
				pass.setPassId(rs.getInt("passId"));
				pass.setReason(rs.getString("reason"));
				
				pastRequest.add(pass);
			}
			
			return pastRequest;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
