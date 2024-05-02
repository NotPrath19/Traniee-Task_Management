package com.yash.Eventelion.service;

import java.util.ArrayList;

import com.yash.Eventelion.model.Task;

public interface TaskService {
void addTask(Task task);
void updateTask(int Id,String NewTask,String NewDate,String NewStartTime,String NewEndTime);
void updateUserName(int Id,String UserName);
void removeTask(int Id);
ArrayList<Task> getSearchTask(String Input);
ArrayList<String> getUserNameList();
ArrayList<Task> displayTaskForAdmin();
ArrayList<Task> displayCurrentTaskAdmin();
ArrayList<Task> displayCurrentTaskUser(String UserName);
ArrayList<Task> displayTaskForUser(String UserName);
void sendReminder(String UserName,String Task,String Endtime);
String remindAll();
}
