package com.yash.Eventelion.serviceimple;

import java.util.ArrayList;

import com.yash.Eventelion.dao.TaskDao;
import com.yash.Eventelion.model.Task;
import com.yash.Eventelion.service.TaskService;

public class TaskServiceImple implements TaskService {

	private TaskDao taskDao;
	public TaskServiceImple(TaskDao taskDao)
	{
	this.taskDao= taskDao;
	}
	@Override
	public void addTask(Task task) {
		// TODO Auto-generated method stub
      taskDao.save(task);
	}

	

	@Override
	public void removeTask(int Id) {
		// TODO Auto-generated method stub
       taskDao.delete(Id);
	}

	@Override
	public ArrayList<Task> getSearchTask(String Input) {
		// TODO Auto-generated method stub
     return taskDao.filter(Input);
	}
	@Override
	public void updateTask(int Id,String NewTask,String NewDate,String NewStartTime,String NewEndTime) {
		// TODO Auto-generated method stub
		taskDao.updateTask(Id, NewTask);
		taskDao.updateDate(Id, NewDate);
		taskDao.updateStartTime(Id, NewStartTime);
		taskDao.updateEndTime(Id, NewEndTime);
	}
	@Override
	public void updateUserName(int Id, String UserNAme) {
		// TODO Auto-generated method stub
		taskDao.updateUserName(Id, UserNAme);
	}
	@Override
	public ArrayList<String> getUserNameList() {
		// TODO Auto-generated method stub
		return taskDao.getDesigUser();
	}
	@Override
	public ArrayList<Task> displayTaskForAdmin() {
		// TODO Auto-generated method stub
		return taskDao.getTaskForAdmin();
	}
	@Override
	public ArrayList<Task> displayTaskForUser(String UserName) {
		// TODO Auto-generated method stub
		return taskDao.getTaskByUserName(UserName);
	}
	@Override
	public ArrayList<Task> displayCurrentTaskAdmin() {
		// TODO Auto-generated method stub
		return taskDao.getTaskByDateAdmin();
	}
	@Override
	public ArrayList<Task> displayCurrentTaskUser(String UserName) {
		// TODO Auto-generated method stub
		return taskDao.getTaskByDateUser(UserName);
	}
	@Override
	public void sendReminder(String UserName,String Task,String Endtime) {
		// TODO Auto-generated method stub
		taskDao.sendReminder(UserName,Task,Endtime);
	}
	@Override
	public String remindAll() {
		// TODO Auto-generated method stub
		return taskDao.remindAll();
	}
	
}
