package com.yash.Eventelion.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.yash.Eventelion.utility.DbUtil;

public class CrudDBUtilTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultset=null;
		int a;
		System.out.println("CRUD Test");
		a = sc.nextInt();
		switch(a)
		{
		case 1 :
			try {
				connection = DbUtil.getConnection();
				String sql="Insert Into test(id,user) values (?,?)";
				prepareStatement = DbUtil.createPreparedStatement(connection, sql);
				prepareStatement.setString(1,"5");
				prepareStatement.setString(2,"Delete");
				prepareStatement.executeUpdate();
				System.out.println("Success");
			} catch (Exception e) {
				// TODO: handle exception
			} finally 
			{
	         DbUtil.closePreparedStatement(prepareStatement);
	         DbUtil.closeConnection(connection);
			}
			break;
		case 2:

			try {
				connection = DbUtil.getConnection();
				String sql=" Select * From test";
				prepareStatement = DbUtil.createPreparedStatement(connection, sql);
				resultset=DbUtil.executeResultSet(prepareStatement);
				while (resultset.next()) 
				{
					System.out.println(resultset.getString(1)+""+resultset.getString(2));	
				}
				System.out.println("Success");
			} catch (Exception e) {
				// TODO: handle exception
			} finally 
			{
	         DbUtil.closePreparedStatement(prepareStatement);
	         DbUtil.closeResultSet(resultset);
	         DbUtil.closeConnection(connection);
			}
			break;
		case 3:

		try {
			connection = DbUtil.getConnection();
			String sql="UPDATE test SET user = ? WHERE id = ?";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setString(1,"Update");
			prepareStatement.setString(2,"3");
			prepareStatement.executeUpdate();
			System.out.println("Success");
		} catch (Exception e) {
			// TODO: handle exception
		} finally 
		{
         DbUtil.closePreparedStatement(prepareStatement);
         DbUtil.closeConnection(connection);
		}
		break;
	     
		case 4:

			try {
				connection = DbUtil.getConnection();
				String sql="  DELETE FROM test WHERE id = ?";
				prepareStatement = DbUtil.createPreparedStatement(connection, sql);
				prepareStatement.setString(1,"5");
				prepareStatement.executeUpdate();
				System.out.println("Success");
			} catch (Exception e) {
				// TODO: handle exception
			} finally 
			{
	         DbUtil.closePreparedStatement(prepareStatement);
	         DbUtil.closeConnection(connection);
			}
			break;
		}
		
        
sc.close();
	}

}
