package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Appointment;


public class AppointmentDao {
	public static boolean saveDataInDatabse(Appointment appointment) throws ClassNotFoundException, SQLException {
		
		String fullName = appointment.getFullName();
		String email = appointment.getEmail();
		String phone = appointment.getPhone();
		String gender = appointment.getGender();
		String date = appointment.getDate();
		String department = appointment.getDepartment();
		String message = appointment.getMessage();
		
		String saveQuery = "INSERT INTO APPOINTMENT(FULLNAME, EMAIL, PHONE, GENDER, DATE, DEPARTMENT, MESSAGE) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement prepareStatement = databaseConnection(saveQuery);
		prepareStatement.setString(1, fullName);
		prepareStatement.setString(2, email);
		prepareStatement.setString(3, phone);
		prepareStatement.setString(4, gender);
		prepareStatement.setString(5, date);
		prepareStatement.setString(6, department);
		prepareStatement.setString(7, message);
		
		int updateCount = prepareStatement.executeUpdate();
		prepareStatement.close();
		return updateCount > 0;
	}
	
	public static PreparedStatement databaseConnection(String saveQuery) throws ClassNotFoundException, SQLException {
		final String url = "jdbc:mysql://localhost:3306/terapia";
		final String username = "root";
		final String password = "root";
		PreparedStatement prepareStatement = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		prepareStatement = connection.prepareStatement(saveQuery);
		return prepareStatement;
		
	}

	public static List<Appointment> fetchAllAppointment() {
		List<Appointment> allAppointments = new ArrayList<>();
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		String getAllRequest = "SELECT * FROM APPOINTMENT";
		
		try {
			prepareStatement = databaseConnection(getAllRequest);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String fullName = resultSet.getString("fullname");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				String gender = resultSet.getString("gender");
				String date = resultSet.getString("date");
				String department = resultSet.getString("department");
				String message = resultSet.getString("message");
				String time = resultSet.getString("time");
		
				Appointment appointment = new Appointment();
				appointment.setId(id);
				appointment.setFullName(fullName);
				appointment.setEmail(email);
				appointment.setPhone(phone);
				appointment.setGender(gender);
				appointment.setDate(date);
				appointment.setDepartment(department);
				appointment.setMessage(message);
				appointment.setTime(time);
				
				allAppointments.add(appointment);
				
			}
			resultSet.close();
			prepareStatement.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allAppointments;
	}
	
}
