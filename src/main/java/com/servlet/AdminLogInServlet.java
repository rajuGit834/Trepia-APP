package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.model.Admin;

@WebServlet("/AdminLogInServlet")
public class AdminLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.sendRedirect("login.jsp");
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		Admin admin = new Admin();
		admin.setAdminName(userName);
		admin.setPassword(password);
		
		if(AdminDao.isValidUser(admin)) {
			response.sendRedirect("viewDashboard.jsp");
		}else {
	        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
	        requestDispatcher.include(request, response);
		}
	}
}
