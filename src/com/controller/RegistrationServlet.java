package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.constants.Role;
import com.dao.UserDao;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String enrollmentNum = request.getParameter("enrollmentNum");

		UserBean userBean = new UserBean();

		userBean.setFirstName(firstName);
		userBean.setEmail(email);
		userBean.setPassword(password);
		userBean.setEnrollmentNum(enrollmentNum);
		userBean.setRole(Role.STUDENT.role);// 4
		userBean.setApprove(false);

		new UserDao().addUser(userBean);

		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);

	}
}
