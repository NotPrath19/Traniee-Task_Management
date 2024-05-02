package com.yash.Eventelion.model;

public class Submission {
	private int Id;
	private String UserName;
	private String Tasks;
	private String Date;
	private String StartTime;
	private String EndTime;
	private String SubmittedAt;
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
	public String getSubmittedAt() {
		return SubmittedAt;
	}
	public void setSubmittedAt(String submittedAt) {
		SubmittedAt = submittedAt;
	}
	
}
