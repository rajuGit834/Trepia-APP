package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.model.Register;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String firstName = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String userEmail = request.getParameter("email");
		String userPhone = request.getParameter("phone");
		String userPassword = request.getParameter("password");
		String userAddress = request.getParameter("address");
		String pinCode = request.getParameter("pincode");
		
		Register register = new Register();
		
		register.setFirstName(firstName);
		register.setLastName(lastname);
		register.setUserEmail(userEmail);
		register.setUserPhone(userPhone);
		register.setUserPassword(userPassword);
		register.setUserAddress(userAddress);
		register.setPinCode(pinCode);
		try {
		    boolean saveRequest = RegisterDao.saveRegisterRequest(register);
		    if(saveRequest)
		    	out.println("<h1>You Are Registered Successfully Thannk You!!!</h1>");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}