package com.yash.Eventelion.serviceimple;
import com.yash.Eventelion.dao.UserDao;
import com.yash.Eventelion.model.User;
import com.yash.Eventelion.service.UserService;

public class UserServiceImple implements UserService
{
private UserDao userDao;
public UserServiceImple(UserDao userDao)
{
this.userDao=userDao;
}
@Override
public String registerUser(User user) 
{
	 return userDao.save(user);
}

@Override
public User getUser(String UserName) {
	return userDao.getUser(UserName);
}
@Override
public String loginValidation(String UserName,String Password) {
	
	return userDao.Validation(UserName,Password);
}
@Override
public Integer status(String UserName) {
	// TODO Auto-generated method stub
	return userDao.getUserStatus(UserName);
}
@Override
public void signoutUser(String UserName) {
	// TODO Auto-generated method stub
	userDao.setStatusInActive(UserName);
	
}
@Override
public void signoutAllUsers() {
	// TODO Auto-generated method stub
	userDao.setStatusAllInActive();
}

}