package com.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PassBean;
import com.dao.PassDao;

//new request 
@WebServlet("/ApplyForPassServlet")
public class ApplyForPassServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date d = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String today = df.format(d);

		String reason = request.getParameter("reason");
		String outTime = request.getParameter("outtime");

		// validation

		// cookie get

		Cookie c[] = request.getCookies();
		int userId = -1;
		for (Cookie x : c) {
			if (x.getName().equals("userId")) {
				userId = Integer.valueOf(x.getValue());
			}
		}

		RequestDispatcher rd = null;
		// dbsave
		if (userId == -1 || userId == 0) {
			request.setAttribute("error", "Please Login Before Access this Service");
			rd = request.getRequestDispatcher("Login.jsp");

		} else {
			PassBean pass = new PassBean();
			pass.setUserId(userId);
			pass.setReason(reason);
			pass.setPassDate(today);
			pass.setApprove(0);// 0 -> pending 
			pass.setOutTime(outTime);

			PassDao passDao = new PassDao();
			passDao.addPassRequest(pass);
			rd = request.getRequestDispatcher("StudentDashboardServlet");

		}
		rd.forward(request, response);
		// hod email

	}
}
