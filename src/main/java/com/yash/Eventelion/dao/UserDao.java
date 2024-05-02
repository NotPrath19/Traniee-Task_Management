package com.yash.Eventelion.dao;
import com.yash.Eventelion.model.User;
public interface UserDao 
{
void requestApproval(User user);
String save(User user);
User getUser(String UserName);
void setStatusActive(String UserName);
void setStatusInActive(String UserName);
void setStatusAllInActive();
int getUserStatus(String UserName);
String Validation(String UserName, String Password);
}
