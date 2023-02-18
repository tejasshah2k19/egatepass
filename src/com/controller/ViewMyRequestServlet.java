package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PassBean;
import com.dao.PassDao;

@WebServlet("/ViewMyRequestServlet")
public class ViewMyRequestServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Cookie c[] = request.getCookies();
		int userId = -1;
		for (Cookie x : c) {
			if (x.getName().equals("userId")) {
				userId = Integer.valueOf(x.getValue());
			}
		}
		
		PassDao passDao = new PassDao();
		
		ArrayList<PassBean> pastRequest= passDao.getAllMyRequest(userId); 
		
		request.setAttribute("pastRequest", pastRequest);

		RequestDispatcher rd  = request.getRequestDispatcher("MyPastRequest.jsp");
		rd.forward(request, response);
		
		
		
		
	
	}
}
