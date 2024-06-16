package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.model.Appointment;


@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("fullname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String date = request.getParameter("date");
		String department = request.getParameter("department");
		String message = request.getParameter("message");
		
		Appointment appointment = new Appointment();
		
		appointment.setFullName(name);
		appointment.setEmail(email);
		appointment.setPhone(phone);
		appointment.setGender(gender);
		appointment.setDate(date);
		appointment.setDepartment(department);
		appointment.setMessage(message);
		
		try {
			if(AppointmentDao.saveDataInDatabse(appointment)) {
				response.sendRedirect("index.jsp");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Appointment> allAppointments = AppointmentDao.fetchAllAppointment();
		session.setAttribute("allAppointments", allAppointments);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewAppointments.jsp");
		requestDispatcher.forward(request, response);
	}

}
