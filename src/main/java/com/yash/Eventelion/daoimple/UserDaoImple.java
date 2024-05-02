package com.yash.Eventelion.daoimple;
import com.yash.Eventelion.utility.DbUtil;
import com.yash.Eventelion.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yash.Eventelion.dao.UserDao;
public class UserDaoImple implements UserDao 
{
	Connection connection = null;
	PreparedStatement prepareStatement = null;
	ResultSet resultset=null;
	
	public void setStatusActive(String UserName)
	{
    try {
			
			connection = DbUtil.getConnection();
			String sql="UPDATE users SET ActiveStauts = ? WHERE (UserName = ?)";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			
			prepareStatement.setInt(1,1);
			prepareStatement.setString(2,UserName);
			prepareStatement.executeUpdate();
			
						
		} catch (Exception e) {
			// TODO: handle exception
		} finally 
		{
		
         DbUtil.closePreparedStatement(prepareStatement);
         DbUtil.closeResultSet(resultset);
         DbUtil.closeConnection(connection);
		}
	
	}
	
	public void  setStatusInActive(String UserName)
	{
		 try {
				
				connection = DbUtil.getConnection();
				String sql="UPDATE users SET ActiveStauts = ? WHERE (UserName = ?)";
				prepareStatement = DbUtil.createPreparedStatement(connection, sql);
				
				prepareStatement.setInt(1,0);
				prepareStatement.setString(2,UserName);
				prepareStatement.executeUpdate();
				
							
			} catch (Exception e) {
				// TODO: handle exception
			} finally 
			{
			
	         DbUtil.closePreparedStatement(prepareStatement);
	         DbUtil.closeResultSet(resultset);
	         DbUtil.closeConnection(connection);
			}	
	}
	public int getUserStatus(String UserName)
	{
		try {
			connection = DbUtil.getConnection();
			String sql=" Select ActiveStauts From users where UserName = ?";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setString(1,UserName);
			resultset=DbUtil.executeResultSet(prepareStatement);
			while (resultset.next()) {
			    return resultset.getInt("ActiveStauts");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally 
		{
         DbUtil.closePreparedStatement(prepareStatement);
         DbUtil.closeResultSet(resultset);
         DbUtil.closeConnection(connection);
		}
		return 0;
	}
	public void requestApproval(User user) 
	{
		try {
			connection = DbUtil.getConnection();
			String sql="Insert Into approvals (UserName,Email,MobileNo,Password,Designation) values (?,?,?,?,?)";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setString(1,user.getUserName());
			prepareStatement.setString(2,user.getEmail());
			prepareStatement.setString(3,user.getMobileNo());
			prepareStatement.setString(4,user.getPassword());
			prepareStatement.setString(5,user.getDesignation());
			prepareStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally 
		{
         DbUtil.closePreparedStatement(prepareStatement);
         DbUtil.closeConnection(connection);
		}
	
	}
	@Override
	public String save(User user) {
		String Status="All Fields Are Required";
		try {
		
			if(user.getDesignation().equals("User"))
			{	
				Status="Registered Succefully";
			connection = DbUtil.getConnection();
			String sql="Insert Into users(UserName,Email,MobileNo,Password,Designation) values (?,?,?,?,?)";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setString(1,user.getUserName());
			prepareStatement.setString(2,user.getEmail());
			prepareStatement.setString(3,user.getMobileNo());
			prepareStatement.setString(4,user.getPassword());
			prepareStatement.setString(5,user.getDesignation());
			prepareStatement.executeUpdate();
			
			}
			else if(user.getDesignation().equals("Admin"))
			{
				Status="Approval Pending";
				requestApproval(user);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally 
		{
         DbUtil.closePreparedStatement(prepareStatement);
         DbUtil.closeConnection(connection);
		}
		
		return Status;
		
	
	}

	@Override
	public  User getUser(String UserName) {
		try {
			connection = DbUtil.getConnection();
			String sql=" Select * From users where UserName = ?";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setString(1,UserName);
			resultset=DbUtil.executeResultSet(prepareStatement);
			while (resultset.next()) {
			    User user = new User();
			    user.setUserName(resultset.getString("UserName"));
			    user.setEmail(resultset.getString("Email"));
			    user.setMobileNo(resultset.getString("MobileNo"));
			    user.setPassword(resultset.getString("Password"));
			    user.setDesignation(resultset.getString("Designation")); 
			    return user;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally 
		{
         DbUtil.closePreparedStatement(prepareStatement);
         DbUtil.closeResultSet(resultset);
         DbUtil.closeConnection(connection);
		}
		return null;
	}

	@Override
	public String Validation(String UserName, String Password) {
		try {
			User user = new User();
			user=getUser(UserName);
			if(user.getUserName().equals(UserName)||user.getEmail().equals(UserName))
			{
			if(user.getPassword().equals(Password))
			{
				setStatusActive(UserName);
				return "User";
			
			}
			else
			{
				return "WrongPassword";
			}
			}
			else
			{
				return "NotAUser";
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally 
		{
         DbUtil.closePreparedStatement(prepareStatement);
         DbUtil.closeResultSet(resultset);
         DbUtil.closeConnection(connection);
		}
	
		return "NotAUser";
	}

	@Override
	public void setStatusAllInActive() {
		// TODO Auto-generated method stub
		 try {
				
				connection = DbUtil.getConnection();
				String sql="UPDATE users SET ActiveStauts = ? WHERE (UserName != '')";
				prepareStatement = DbUtil.createPreparedStatement(connection, sql);
				
				prepareStatement.setInt(1,0);
				prepareStatement.executeUpdate();
				
							
			} catch (Exception e) {
				// TODO: handle exception
			} finally 
			{
			
	         DbUtil.closePreparedStatement(prepareStatement);
	         DbUtil.closeResultSet(resultset);
	         DbUtil.closeConnection(connection);
			}	
		
	}

}
