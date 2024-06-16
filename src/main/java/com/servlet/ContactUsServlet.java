package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RequestDao;
import com.model.Request;

@WebServlet("/ContactUsServlet")
public class ContactUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String message = request.getParameter("message");
		
		Request requestModel = new Request();
		
		requestModel.setFullName(fullName);
		requestModel.setEmail(email);
		requestModel.setPhone(phone);
		requestModel.setMessage(message);
		
		try {
			boolean saveRequest = RequestDao.saveRequest(requestModel);
			if(saveRequest) {
				out.println("<h1>Thanks for your Intrest, Please Visit Again !</h1>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
