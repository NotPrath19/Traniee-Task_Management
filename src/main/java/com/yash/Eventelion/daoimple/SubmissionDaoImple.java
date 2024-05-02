package com.yash.Eventelion.daoimple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yash.Eventelion.dao.SubmissionDao;
import com.yash.Eventelion.dao.TaskDao;
import com.yash.Eventelion.dao.UserDao;
import com.yash.Eventelion.model.Submission;
import com.yash.Eventelion.model.Task;
import com.yash.Eventelion.model.User;
import com.yash.Eventelion.utility.DbUtil;
import com.yash.Eventelion.utility.MailUtil;

public class SubmissionDaoImple implements SubmissionDao {

	TaskDao taskDao = new TaskDaoImple();
	UserDao userDao = new UserDaoImple();
	Connection connection = null;
	PreparedStatement prepareStatement = null;
	ResultSet resultset = null;
	public SubmissionDaoImple() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Integer id) {
		// TODO Auto-generated method stub
		Task task = taskDao.getTaskById(id);
	
		try {
			connection = DbUtil.getConnection();
			String sql = "Insert Into submissions ( UserName ,Tasks ,Date ,StartTime ,EndTime ,SubmittedAt) values (?,?,?,?,?,?)";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			Date date = new Date(); 
			prepareStatement.setString(1, task.getUserName());
			prepareStatement.setString(2, task.getTasks());
			prepareStatement.setString(3, task.getDate());
			prepareStatement.setString(4, task.getStartTime());
			prepareStatement.setString(5, task.getEndTime());
			prepareStatement.setString(6, date.toString());
					
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
	public void migrate(Integer id) {
		// TODO Auto-generated method stub
		save(id);
		taskDao.delete(id);

	}
	
	@Override
	public List<Submission> getsubmissions() {
		// TODO Auto-generated method stub
		List<Submission> submissionsList = new ArrayList<Submission>();
		try {
			connection = DbUtil.getConnection();
			String sql=" Select * From submissions";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			resultset=DbUtil.executeResultSet(prepareStatement);
			
			while (resultset.next()) 
			{
				Submission submission = new Submission();
			   submission.setId(resultset.getInt("Id"));
			   submission.setUserName(resultset.getString("UserName"));
			   submission.setTasks(resultset.getString("Tasks"));
			   submission.setDate(resultset.getString("Date"));
			   submission.setStartTime(resultset.getString("StartTime"));
			   submission.setEndTime(resultset.getString("EndTime"));
			   submission.setSubmittedAt(resultset.getString("SubmittedAt"));
			   submissionsList.add(submission); 
			}
			return submissionsList;
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
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		try {

			connection = DbUtil.getConnection();
			String deletesql = " Delete From submissions where Id = ? ";
			prepareStatement = DbUtil.createPreparedStatement(connection, deletesql);
			prepareStatement.setInt(1, id);
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
	public void notify(String UserName, String Subject, String Body) {
		// 
        User user = userDao.getUser(UserName);
        MailUtil.sendEmail(user.getEmail(), Subject, Body);
     
	}

	@Override
	public List<Submission> getsubmissionbyUserName(String UserName) {
		// TODO Auto-generated method stub
		List<Submission> submissionsList = new ArrayList<Submission>();
		try {
			connection = DbUtil.getConnection();
			String sql=" Select * From submissions where UserName = ?";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			prepareStatement.setString(1, UserName);
			resultset=DbUtil.executeResultSet(prepareStatement);
			
			while (resultset.next()) 
			{
				Submission submission = new Submission();
			   submission.setId(resultset.getInt("Id"));
			   submission.setUserName(resultset.getString("UserName"));
			   submission.setTasks(resultset.getString("Tasks"));
			   submission.setDate(resultset.getString("Date"));
			   submission.setStartTime(resultset.getString("StartTime"));
			   submission.setEndTime(resultset.getString("EndTime"));
			   submission.setSubmittedAt(resultset.getString("SubmittedAt"));
			   submissionsList.add(submission); 
			}
			return submissionsList;
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
	public void update(String Task, Integer Id) {
		// TODO Auto-generated method stub
try {
	        Date date = new Date();
			connection = DbUtil.getConnection();
			String sql=" UPDATE submissions SET Tasks = ? WHERE (Id = ?)";
			prepareStatement = DbUtil.createPreparedStatement(connection, sql);
			
			prepareStatement.setString(1,Task+" ( Updated on "+date.toString()+ " ) ");
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


		
	



	

}
