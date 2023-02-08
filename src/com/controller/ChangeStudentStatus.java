package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

@WebServlet("/ChangeStudentStatus")
public class ChangeStudentStatus extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer userId = Integer.parseInt(request.getParameter("userId"));
		Boolean currentStatus = Boolean.parseBoolean(request.getParameter("currentStatus"));
		
		UserDao userDao = new UserDao();
		userDao.changeStudentStatus(userId,currentStatus);

		//no data 
		response.sendRedirect("ListStudentServlet");
		
	}
}
