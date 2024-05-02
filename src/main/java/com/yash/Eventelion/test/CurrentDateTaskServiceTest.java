package com.yash.Eventelion.test;

import java.util.ArrayList;

import com.yash.Eventelion.dao.TaskDao;
import com.yash.Eventelion.daoimple.TaskDaoImple;
import com.yash.Eventelion.model.Task;
import com.yash.Eventelion.service.TaskService;
import com.yash.Eventelion.serviceimple.TaskServiceImple;


public class CurrentDateTaskServiceTest {
	public static void main(String[] args) {
		
TaskDao taskDao = new TaskDaoImple();
TaskService taskService = new TaskServiceImple(taskDao);
ArrayList<Task> taskList = taskService.displayCurrentTaskAdmin();
System.out.println(taskList);


	
	}
}
