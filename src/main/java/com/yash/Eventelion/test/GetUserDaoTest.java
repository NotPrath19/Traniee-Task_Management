package com.yash.Eventelion.test;

import com.yash.Eventelion.dao.UserDao;
import com.yash.Eventelion.daoimple.UserDaoImple;
import com.yash.Eventelion.model.User;


public class GetUserDaoTest {

	 public static void main(String[] args) {
	        // Test case for valid username
		 
	      UserDao userDao = new UserDaoImple();  
		  String UserName = "Prath19";
	  
	        User user = userDao.getUser(UserName);
          System.out.println(user.getUserName());
          System.out.println(user.getEmail());
          System.out.println(user.getMobileNo());
          System.out.println(user.getDesignation());
	       

}
}
