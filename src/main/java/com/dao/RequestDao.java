package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Request;

public class RequestDao {
	public static boolean saveRequest(Request request) throws SQLException {
		String fullName = request.getFullName();
		String email = request.getEmail();
		String phone = request.getPhone();
		String message = request.getMessage();
		
		String saveRequestQuery = "INSERT INTO dashboard (fullName, email, phone, message) VALUES (?, ?, ?, ?)";
		PreparedStatement preparedStatement = databaseConnection(saveRequestQuery);
		preparedStatement.setString(1, fullName);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, phone);
        preparedStatement.setString(4, message);
        int updateCount = preparedStatement.executeUpdate();
        preparedStatement.close();
		return updateCount > 0;
	}

	private static PreparedStatement databaseConnection(String saveRequestQuery) {
		final String url = "jdbc:mysql://localhost:3306/terapia";
		final String username = "root";
		final String password = "root";
		PreparedStatement preparedStatement = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            preparedStatement = connection.prepareStatement(saveRequestQuery);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return preparedStatement;
	}

	public List<Request> fetchAllRequests() {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Request> allRequests = new ArrayList<>();
		String getAllRequestQuery = "SELECT * FROM dashboard";

		try {
			preparedStatement = databaseConnection(getAllRequestQuery);
			resultSet = preparedStatement.executeQuery();
	
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String fullName = resultSet.getString("fullname");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				String message = resultSet.getString("message");
				String time = resultSet.getString("timestamp");
		
				Request request = new Request();
				request.setId(id);
				request.setFullName(fullName);
				request.setEmail(email);
				request.setPhone(phone);
				request.setMessage(message);
				request.setTimeStamp(time);
				allRequests.add(request);
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return allRequests;
	}
}

