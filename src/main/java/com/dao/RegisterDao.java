package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Register;

public class RegisterDao {
	public static boolean saveRegisterRequest(Register register) throws SQLException {
		String firstName = register.getFirstName();
		String lastName = register.getLastName();
		String userEmail = register.getUserEmail();
		String userPhone = register.getUserPhone();
		String userPassword = register.getUserPassword();
		String userAddress = register.getUserAddress();
		String pinCode = register.getPinCode();
		
		String saveRegisterQuery = "INSERT INTO REGISTER (firstName, lastName, Email, Phone, Password, "
				+ "Address, pinCode) VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement prepareStatement = databaseConnection(saveRegisterQuery);
		
		prepareStatement.setString(1, firstName);
		prepareStatement.setString(2, lastName);
		prepareStatement.setString(3, userEmail);
		prepareStatement.setString(4, userPhone);
		prepareStatement.setString(5, userPassword);
		prepareStatement.setString(6, userAddress);
		prepareStatement.setString(7, pinCode);
		
		int updateCount = prepareStatement.executeUpdate();
		prepareStatement.close();
		return updateCount > 0;
	}
	
	public static PreparedStatement databaseConnection(String saveRegisterQuery) {
		final String url = "jdbc:mysql://localhost:3306/terapia";
		final String userName = "root";
		final String password = "root";
		PreparedStatement prepareStatement = null;
		try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection(url, userName, password);
	            prepareStatement = connection.prepareStatement(saveRegisterQuery);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	    return prepareStatement;	
	}
}
