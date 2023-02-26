package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;

public class StudentDashboardServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//

		// count-> totalPass , accept,reject,pending
		//
		//
		StudentDao studentDao = new StudentDao();
		Cookie c[] = request.getCookies();
		int userId = -1;
		for (Cookie x : c) {
			if (x.getName().equals("userId")) {
				userId = Integer.valueOf(x.getValue());
			}
		}
		
		int totalPassRequest = studentDao.getAllMyRequest(userId).size();
		int totalAcceptedRequest = studentDao.getAllMyRequestByStatus(userId,1).size();
		int totalRejectedRequest = studentDao.getAllMyRequestByStatus(userId,2).size();
		int totalPendingRequest = studentDao.getAllMyRequestByStatus(userId,0).size();
		
		
		request.setAttribute("totalPassRequest", totalPassRequest);
		request.setAttribute("totalAcceptedRequest", totalAcceptedRequest);
		request.setAttribute("totalRejectedRequest", totalRejectedRequest);
		request.setAttribute("totalPendingRequest", totalPendingRequest);
		
		 RequestDispatcher rd = request.getRequestDispatcher("StudentDashboard.jsp");
		 rd.forward(request, response);
		
	}

}
