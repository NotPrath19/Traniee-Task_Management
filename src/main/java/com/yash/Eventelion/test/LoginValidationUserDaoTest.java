package com.yash.Eventelion.test;
import com.yash.Eventelion.dao.UserDao;
import com.yash.Eventelion.daoimple.UserDaoImple;





public class LoginValidationUserDaoTest {
	
	public static void main(String[] args) {
		
		String user;
		 UserDao userDao = new UserDaoImple(); 
		 user = userDao.Validation("Prath19", "");
		 
				 System.out.println(user);
	}

}
