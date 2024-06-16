package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.User;

/**
 * Servlet implementation class UserLogInServlet
 */
@WebServlet("/UserLogInServlet")
public class UserLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		
		try {
			if(UserDao.isValidUser(user)) {
				out.println("<h1>Login Successfull!!!</h1>");
			}
			else {
				out.println("<h1>Opps!! Wrong user or password</h1>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
