package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.model.Admin;
public class AdminDao {
	public static boolean isValidUser(Admin admin) {
		String userName = admin.getAdminName();
		String password = admin.getPassword();
		return fetchFromDatabase(userName, password);
	}
	
	public static boolean fetchFromDatabase(String userName, String password) {
		final String url = "jdbc:mysql://localhost:3306/terapia";
 
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, "root", "root");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM logininfo";
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            if(resultSet.getString(1).equals(userName) && resultSet.getString(2).equals(password)) {
            	return true;
            } 
            connection.close();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return false;
	}
}

