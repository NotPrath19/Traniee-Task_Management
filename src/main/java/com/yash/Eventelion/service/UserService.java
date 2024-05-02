package com.yash.Eventelion.service;
import com.yash.Eventelion.model.User;
public interface UserService {
public String registerUser(User user);
User getUser(String UserName);
Integer status(String UserName);
void signoutUser(String UserName);
void signoutAllUsers();
String loginValidation(String UserName,String Password);
}
