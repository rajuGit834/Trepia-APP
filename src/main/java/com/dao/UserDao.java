package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.User;

public class UserDao {
	public static boolean isValidUser(User user) throws ClassNotFoundException, SQLException {
		String userName = user.getUserName();
		String password = user.getPassword();
		return fetchFromDatabase(userName, password);
	}
	
	public static boolean fetchFromDatabase(String userName, String password) throws ClassNotFoundException, SQLException {
		final String url = "jdbc:mysql://localhost:3306/terapia";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, "root", "root");
			Statement statement = connection.createStatement();
			String query = "SELECT EMAIL, PASSWORD FROM REGISTER";
			ResultSet resultset = statement.executeQuery(query);
			resultset.next();
			if(resultset.getString(1).equals(userName) && resultset.getString(2).equals(password)) {
				return true;
			}
			connection.close();
		}
		catch (Exception e) {
        	e.printStackTrace();
        }
		return false;	
	}
}
