package com.yash.Eventelion.daoimple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yash.Eventelion.dao.TaskDao;
import com.yash.Eventelion.dao.UserDao;
import com.yash.Eventelion.model.Task;
import com.yash.Eventelion.model.User;
import com.yash.Eventelion.utility.DbUtil;
import com.yash.Eventelion.utility.MailUtil;

public class TaskDaoImple implements TaskDao {

    UserDao userDao = new UserDaoImple(); 
	Connection connection = null;
	PreparedStatement prepareStatement = null;
	ResultSet resultset = null;

	@Override
	public void save(Task task) {
		try {
			connection = DbUtil.getConnection();
			String sql = "Insert Into tasks ( UserName ,Tasks ,Date ,StartTime ,EndTime ) values (?,?,?,?,?)";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			
			prepareStatement.setString(1, task.getUserName());
			prepareStatement.setString(2, task.getTasks());
			prepareStatement.setString(3, task.getDate());
			prepareStatement.setString(4, task.getStartTime());
			prepareStatement.setString(5, task.getEndTime());
			
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DbUtil.closePreparedStatement(prepareStatement);
			DbUtil.closeResultSet(resultset);
			DbUtil.closeConnection(connection);
		}
	}

	@Override
	public void delete(int Id) {
		try {

			connection = DbUtil.getConnection();
			String deletesql = " Delete From tasks where Id = ? ";
			prepareStatement = DbUtil.createPreparedStatement(connection, deletesql);
			prepareStatement.setInt(1, Id);
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DbUtil.closePreparedStatement(prepareStatement);
			DbUtil.closeResultSet(resultset);
			DbUtil.closeConnection(connection);
		}

	}
	@Override
	public Task getTaskById(int Id) 
	{
		try {
			connection = DbUtil.getConnection();
			
			String sql=" Select * From tasks where Id = ? ";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setInt(1,Id);
			resultset=DbUtil.executeResultSet(prepareStatement);
			
			while (resultset.next()) 
			{
				Task task = new Task();
				task.setId(resultset.getInt("Id"));
				task.setUserName(resultset.getString("UserName"));
				task.setTasks(resultset.getString("Tasks"));
				task.setDate(resultset.getString("Date"));
				task.setStartTime(resultset.getString("StartTime")); 
				task.setEndTime(resultset.getString("EndTime"));
			return task;
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
	public void updateUserName(int Id,String UserName) {
		
		try {
			
			connection = DbUtil.getConnection();
			String sql="UPDATE tasks SET UserName = ? WHERE (Id = ?)";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setString(1,UserName);
			prepareStatement.setInt(2,Id);
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
	public void updateTask(int Id,String NewTask) {
		
		try {
			
			connection = DbUtil.getConnection();
			String sql="UPDATE tasks SET Tasks = ? WHERE (Id = ?)";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			
			prepareStatement.setString(1,NewTask);
			prepareStatement.setInt(2,Id);
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
	public void updateDate(int Id,String NewDate) {
		
		try {
			
			connection = DbUtil.getConnection();
			String sql=" UPDATE tasks SET Date = ? WHERE (Id = ?)";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			
			prepareStatement.setString(1,NewDate);
			prepareStatement.setInt(2,Id);
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
       public void updateStartTime(int Id,String StartTime) {
		
		try {
			
			connection = DbUtil.getConnection();
			String sql=" UPDATE tasks SET StartTime = ? WHERE (Id = ?)";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			
			prepareStatement.setString(1,StartTime);
			prepareStatement.setInt(2,Id);
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
    public void updateEndTime(int Id,String EndTime) {
		
		try {
			
			connection = DbUtil.getConnection();
			String sql=" UPDATE tasks SET EndTime = ? WHERE (Id = ?)";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			
			prepareStatement.setString(1,EndTime);
			prepareStatement.setInt(2,Id);
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
	public ArrayList<String> getDesigUser() {
		try {
			connection = DbUtil.getConnection();
			String sql=" Select * From users where Designation = 'User' ";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			resultset=DbUtil.executeResultSet(prepareStatement);
			ArrayList<String> userList = new ArrayList<String>();
			while (resultset.next()) 
			{
			   String users =resultset.getString("UserName") ;
			 userList.add(users); 
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
	
	@Override
	public ArrayList<Task> getTaskForAdmin( )
	{
		ArrayList<String> user = getDesigUser();
		
		try {
			
			ArrayList<Task> taskList = new ArrayList<Task>();
			for(String userList : user)
			{
			connection = DbUtil.getConnection();
			String sql=" Select * From tasks where UserName= ?";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setString(1,userList);
			resultset=DbUtil.executeResultSet(prepareStatement);
			Task task = new Task();
			while (resultset.next()) 
			{
				
			    task.setId(resultset.getInt("Id"));
				task.setUserName(resultset.getString("UserName"));
				task.setTasks(resultset.getString("Tasks"));
				task.setDate(resultset.getString("Date"));
				task.setStartTime(resultset.getString("StartTime")); 
				task.setEndTime(resultset.getString("EndTime"));
			    
			    
			}
			taskList.add(task);
			}
			return taskList;
			
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
	public ArrayList<Task> getTaskByUserName(String UserName) {
		try {
			connection = DbUtil.getConnection();
			
			String sql=" Select * From tasks where UserName = ? ";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setString(1,UserName);
			resultset=DbUtil.executeResultSet(prepareStatement);
			ArrayList<Task> taskList = new ArrayList<Task>();
			while (resultset.next()) 
			{
				Task task = new Task();
				task.setId(resultset.getInt("Id"));
				task.setUserName(resultset.getString("UserName"));
				task.setTasks(resultset.getString("Tasks"));
				task.setDate(resultset.getString("Date"));
				task.setStartTime(resultset.getString("StartTime")); 
				task.setEndTime(resultset.getString("EndTime"));
			    taskList.add(task);
			}
			return taskList;
			
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
	public ArrayList<Task> getTaskByTask(String Task) {
		try {
			connection = DbUtil.getConnection();
			
			String sql=" Select * From tasks where Task = ? ";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setString(1,Task);
			resultset=DbUtil.executeResultSet(prepareStatement);
			ArrayList<Task> taskList = new ArrayList<Task>();
			while (resultset.next()) 
			{
				Task task = new Task();
				task.setId(resultset.getInt("Id"));
				task.setUserName(resultset.getString("UserName"));
				task.setTasks(resultset.getString("Tasks"));
				task.setDate(resultset.getString("Date"));
				task.setStartTime(resultset.getString("StartTime")); 
				task.setEndTime(resultset.getString("EndTime"));
			    taskList.add(task);
			}
			return taskList;
			
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
	public ArrayList<Task> getTaskByDate(String Date) {
		try {
			connection = DbUtil.getConnection();
			
			String sql=" Select * From tasks where Date = ? ";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setString(1,Date);
			resultset=DbUtil.executeResultSet(prepareStatement);
			ArrayList<Task> taskList = new ArrayList<Task>();
			while (resultset.next()) 
			{
				Task task = new Task();
				task.setId(resultset.getInt("Id"));
				task.setUserName(resultset.getString("UserName"));
				task.setTasks(resultset.getString("Tasks"));
				task.setDate(resultset.getString("Date"));
				task.setStartTime(resultset.getString("StartTime")); 
				task.setEndTime(resultset.getString("EndTime"));
			    taskList.add(task);
			}
			return taskList;
			
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
	public ArrayList<Task> getTaskByStartTime(String StartTime) {
		try {
			connection = DbUtil.getConnection();
			
			String sql=" Select * From tasks where StartTime = ? ";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setString(1,StartTime);
			resultset=DbUtil.executeResultSet(prepareStatement);
			ArrayList<Task> taskList = new ArrayList<Task>();
			while (resultset.next()) 
			{
				Task task = new Task();
				task.setId(resultset.getInt("Id"));
				task.setUserName(resultset.getString("UserName"));
				task.setTasks(resultset.getString("Tasks"));
				task.setDate(resultset.getString("Date"));
				task.setStartTime(resultset.getString("StartTime")); 
				task.setEndTime(resultset.getString("EndTime"));
			    taskList.add(task);
			}
			return taskList;
			
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
	public ArrayList<Task> getTaskByEndTime(String EndTime) {
		try {
			connection = DbUtil.getConnection();
			
			String sql=" Select * From tasks where EndTime = ? ";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setString(1,EndTime);
			resultset=DbUtil.executeResultSet(prepareStatement);
			ArrayList<Task> taskList = new ArrayList<Task>();
			while (resultset.next()) 
			{
				Task task = new Task();
				task.setId(resultset.getInt("Id"));
				task.setUserName(resultset.getString("UserName"));
				task.setTasks(resultset.getString("Tasks"));
				task.setDate(resultset.getString("Date"));
				task.setStartTime(resultset.getString("StartTime")); 
				task.setEndTime(resultset.getString("EndTime"));
			    taskList.add(task);
			}
			return taskList;
			
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
	public ArrayList<Task> filter(String Input) {
		ArrayList<Task> taskList = new ArrayList<Task>();
		taskList=getTaskByUserName(Input);
		if(taskList.isEmpty())
		{
	    taskList=getTaskByDate(Input);
		if(taskList.isEmpty())
		{
		taskList=getTaskByStartTime(Input);
		if(taskList.isEmpty())
		{
		taskList=getTaskByEndTime(Input);	
		if(taskList.isEmpty())
		{
	    taskList=getTaskByTask(Input);
		}
		else
		{
			return taskList;
		}
		}
		else
		{
			return taskList;
		}
		}
		else
		{
			return taskList;
		}
		}
		else
		{
			return taskList;
		}
		
		return getTaskForAdmin();
		
	}

	@Override
	public ArrayList<Task> getTaskByDateAdmin() {
		try {
			connection = DbUtil.getConnection();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		    Date date = new Date(); 
			String sql=" Select * From tasks where Date = ? ";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setString(1,(formatter.format(date).toString()));
			resultset=DbUtil.executeResultSet(prepareStatement);
			ArrayList<Task> taskList = new ArrayList<Task>();
			while (resultset.next()) 
			{
				Task task = new Task();
				task.setId(resultset.getInt("Id"));
				task.setUserName(resultset.getString("UserName"));
				task.setTasks(resultset.getString("Tasks"));
				task.setDate(resultset.getString("Date"));
				task.setStartTime(resultset.getString("StartTime")); 
				task.setEndTime(resultset.getString("EndTime"));
			    taskList.add(task);
			}
			return taskList;
			
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
	public ArrayList<Task> getTaskByDateUser(String UserName) {
		try {
			connection = DbUtil.getConnection();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		    Date date = new Date(); 
			String sql=" Select * From tasks where Date = ?  AND  UserName = ?";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setString(1,(formatter.format(date).toString()));
			prepareStatement.setString(2, UserName);
			resultset=DbUtil.executeResultSet(prepareStatement);
			ArrayList<Task> taskList = new ArrayList<Task>();
			while (resultset.next()) 
			{
				Task task = new Task();
				task.setId(resultset.getInt("Id"));
				task.setUserName(resultset.getString("UserName"));
				task.setTasks(resultset.getString("Tasks"));
				task.setDate(resultset.getString("Date"));
				task.setStartTime(resultset.getString("StartTime")); 
				task.setEndTime(resultset.getString("EndTime"));
			    taskList.add(task);
			}
			return taskList;
			
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
	public void sendReminder(String UserName,String Task,String Endtime) {
		// TODO Auto-generated method stub
		
		User user = userDao.getUser(UserName);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    Date date = new Date(); 
		MailUtil.sendEmail(user.getEmail(), "Reminder" , "You have the task '"+ Task +"' pending by '"+ Endtime +"' by today - '"+formatter.format(date).toString()+"'" );
			
		
		
	}
	@Override
	public String remindAll() {
		// TODO Auto-generated method stub
     List<Task> tasklist=getTaskByDateAdmin();
		if(tasklist.isEmpty())
		{
		return "Is Empty";
		}
		else
		{
			for(Task t : tasklist)
			{
			sendReminder(t.getUserName(), t.getTasks(), t.getEndTime());	
			}
			
			return "Sent";
		}
	}
}
