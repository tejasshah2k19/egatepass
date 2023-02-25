package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
import com.service.EmailService;

public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");

		// db check
		// select * from users where email = ?
		UserDao userDao = new UserDao();
		UserBean userBean = userDao.findByEmail(email);

		RequestDispatcher rd = null; 
		if (userBean == null) {
			request.setAttribute("error", "Invalid Email");
			rd = request.getRequestDispatcher("ForgetPassword.jsp");
		} else {
			int otp = (int) (Math.random() * 100000); //
			userBean.setOtp(otp);//email otp 
			userDao.updateOtp(userBean);
			
			//mail send 
			EmailService emailService = new EmailService();
			emailService.sendOtpForForgetPassword(email, otp);
			rd = request.getRequestDispatcher("ChangePassword.jsp");
		}
		rd.forward(request, response);
	}

}
