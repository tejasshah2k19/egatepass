package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.PassBean;
import com.util.DbConnection;

public class StudentDao {

	//total PAss Request 
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
			
			return pastRequest;//size() 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pastRequest;
	}

	public ArrayList<PassBean> getAllMyRequestByStatus(int userId,int statusId) {
		ArrayList<PassBean> pastRequest = new ArrayList<PassBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from pass where userId = ? and approve = ? order by passId desc ");
			pstmt.setInt(1, userId);
			pstmt.setInt(2, statusId);// 1 2 0 
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
			
			return pastRequest;//size() 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pastRequest;
	}


}
