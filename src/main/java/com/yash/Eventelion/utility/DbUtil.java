package com.yash.Eventelion.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
	private static final String url = "jdbc:mysql://localhost:3306/eventelion2.0";
	private static final String user = "root";
	private static final String pass = "root";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private DbUtil() {
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}

	public static void closeConnection(Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static PreparedStatement createPreparedStatement(Connection connection, String sql) throws SQLException {
		return connection.prepareStatement(sql);
	}

	public static void closePreparedStatement(PreparedStatement prepareStatement) {
		try {
			if (prepareStatement != null && !prepareStatement.isClosed()) {
				prepareStatement.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static ResultSet executeResultSet(PreparedStatement preparedStatement) throws SQLException {
		 
		 return preparedStatement.executeQuery();
		
	}

	public static void closeResultSet(ResultSet resultset) {
		try {
			if (resultset != null && ! resultset.isClosed()) {
				resultset.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
