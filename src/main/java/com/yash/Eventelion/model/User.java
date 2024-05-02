package com.yash.Eventelion.model;

public class User {
private String UserName;
private String Email;
private String MobileNo;
private String Password;
private String Designation;
private Integer ActiveStauts;
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getMobileNo() {
	return MobileNo;
}
public void setMobileNo(String mobileNo) {
	MobileNo = mobileNo;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getDesignation() {
	return Designation;
}
public void setDesignation(String designation) {
	Designation = designation;
}
public Integer getActiveStauts() {
	return ActiveStauts;
}
public void setActiveStauts(Integer activeStauts) {
	ActiveStauts = activeStauts;
}

}
