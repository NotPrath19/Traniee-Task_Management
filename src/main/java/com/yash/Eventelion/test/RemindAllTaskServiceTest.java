package com.yash.Eventelion.test;

import com.yash.Eventelion.dao.TaskDao;
import com.yash.Eventelion.daoimple.TaskDaoImple;
import com.yash.Eventelion.service.TaskService;
import com.yash.Eventelion.serviceimple.TaskServiceImple;


public class RemindAllTaskServiceTest {
	public static void main(String[] args) {
		
TaskDao taskDao = new TaskDaoImple();
TaskService taskService = new TaskServiceImple(taskDao);
taskService.remindAll();


	
	}
}
