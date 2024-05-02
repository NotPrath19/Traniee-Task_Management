package com.yash.Eventelion.daoimple;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.yash.Eventelion.dao.ApprovalDao;
import com.yash.Eventelion.model.Approval;
import com.yash.Eventelion.utility.DbUtil;
public class ApprovalDaoImple implements ApprovalDao
{
	Connection connection = null;
	PreparedStatement prepareStatement = null;
	ResultSet resultset=null;
	
	
	
	@Override
	public Approval getApprovalById(int Id)
	{
		
		try {
			connection = DbUtil.getConnection();
			
			String sql=" Select * From approvals where Id = ? ";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setInt(1,Id);
			resultset=DbUtil.executeResultSet(prepareStatement);
			
			while (resultset.next()) 
			{
				Approval user = new Approval();
			    user.setId(resultset.getInt("Id"));
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
	public void insert(Approval user)
	{
		try {
			connection = DbUtil.getConnection();
			String sql="Insert Into users(UserName,Email,MobileNo,Password,Designation) values (?,?,?,?,?)";
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
         DbUtil.closeResultSet(resultset);
         DbUtil.closeConnection(connection);
		}
	}
	
	
	@Override
	public void delete(int Id) {
		try {
		
			connection = DbUtil.getConnection();
			String deletesql=" Delete From approvals where Id = ? ";
			prepareStatement = DbUtil.createPreparedStatement(connection, deletesql);
			prepareStatement.setInt(1,Id);
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
	

	@Override
	public void migrate(int Id) 
	{
     
			Approval user = new Approval();
	        user = getApprovalById(Id);   	
	        insert(user);
		    delete(Id);
       
	}
	@Override
	public ArrayList<Approval> getApproval() {
		try {
			connection = DbUtil.getConnection();
			String sql=" Select * From approvals";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			resultset=DbUtil.executeResultSet(prepareStatement);
			ArrayList<Approval> userList = new ArrayList<Approval>();
			while (resultset.next()) 
			{
			    Approval user = new Approval();
			    user.setId(resultset.getInt("Id"));
			    user.setUserName(resultset.getString("UserName"));
			    user.setEmail(resultset.getString("Email"));
			    user.setMobileNo(resultset.getString("MobileNo"));
			    user.setPassword(resultset.getString("Password"));
			    user.setDesignation(resultset.getString("Designation")); 
			    userList.add(user);
			}
			return userList;
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

	

	}

		
	
	


