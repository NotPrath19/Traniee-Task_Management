package com.yash.Eventelion.dao;
import java.util.ArrayList;

import com.yash.Eventelion.model.Task;
public interface TaskDao 
{
void save(Task task);
void delete(int Id);
void updateUserName(int Id,String NewUserName);
void updateTask(int Id,String NewTask);
void updateDate(int Id,String NewDate);
void updateStartTime(int Id,String NewStartTime);
void updateEndTime(int Id,String NewEndTime);
Task getTaskById(int Id);
ArrayList<String> getDesigUser();
ArrayList<Task> getTaskForAdmin();
ArrayList<Task> getTaskByUserName(String UserName);
ArrayList<Task> getTaskByTask(String Tasks);
ArrayList<Task> getTaskByDate(String Date);
ArrayList<Task> getTaskByDateAdmin();
ArrayList<Task> getTaskByDateUser(String UserName);
ArrayList<Task> getTaskByStartTime(String StartTime);
ArrayList<Task> getTaskByEndTime(String EndTime);
ArrayList<Task> filter(String Input);
String remindAll();
void sendReminder(String UserName,String Task,String Endtime);
}
