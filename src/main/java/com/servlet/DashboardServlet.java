package com.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.dao.RequestDao;
import com.model.Admin;
import com.model.Request;

@SuppressWarnings("serial")
@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
private RequestDao requestDao = new RequestDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		Admin admin = new Admin();
		admin.setAdminName(userName);
		admin.setPassword(password);
		
		if(AdminDao.isValidUser(admin)) {
			//response.sendRedirect("viewDashboard.jsp");
			List<Request> activeRequests = requestDao.fetchAllRequests();
			session.setAttribute("activeRequests", activeRequests);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewDashboard.jsp");
			requestDispatcher.forward(request, response);
		}else {
	        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
	        requestDispatcher.include(request, response);
		}
		
		if (session == null) {
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

