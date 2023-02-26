package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.constants.Role;
import com.dao.UserDao;

@WebServlet("/LoginServlet1")
public class LoginServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// db check -> account active , credentials
		UserDao userDao = new UserDao();
		UserBean user = userDao.authenticate(email, password);
		RequestDispatcher rd = null;
		if (user == null) {
			// invalid credentials
			request.setAttribute("error", "Invalid Credentials");
			rd = request.getRequestDispatcher("Login.jsp");
		} else {
			// good to gos
			if (user.getRole() == Role.STUDENT.role) {
				// cookie -> userId set -->
				//String,String
				Cookie c = new Cookie("userId", user.getUserId()+"");
				//key:name->string 
				//value->string 
				c.setMaxAge(60*60*24*5);//5days 
				response.addCookie(c);
				
				
				rd = request.getRequestDispatcher("StudentDashboardServlet");
			} else if (user.getRole() == Role.ADMIN.role) {
				rd = request.getRequestDispatcher("AdminDashboard.jsp");
			} else if (user.getRole() == Role.FACULTY.role) {
				rd = request.getRequestDispatcher("FacultyDashboard.jsp");
			}
		}
		rd.forward(request, response);
	}
}
