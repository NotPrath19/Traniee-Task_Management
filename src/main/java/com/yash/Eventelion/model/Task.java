package com.yash.Eventelion.model;

public class Task {
	private int Id;
	private String UserName;
	private String Tasks;
	private String Date;
	private String StartTime;
	private String EndTime;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getTasks() {
		return Tasks;
	}
	public void setTasks(String tasks) {
		Tasks = tasks;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
}
