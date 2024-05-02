package com.yash.Eventelion.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.Eventelion.dao.UserDao;
import com.yash.Eventelion.daoimple.UserDaoImple;
import com.yash.Eventelion.model.User;
import com.yash.Eventelion.service.UserService;
import com.yash.Eventelion.serviceimple.UserServiceImple;

/**
 * Servlet implementation class UserRegisterationServlet
 */
@WebServlet("/UserRegisterationServlet")
public class UserRegisterationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
private UserService userService;
UserDao userDao = new UserDaoImple();
public void init() throws ServletException 
{
	this.userService= new UserServiceImple(userDao);
}
	public UserRegisterationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	 /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		 String UserName=request.getParameter("UserName");
		 String Email=request.getParameter("Email");
		 String MobileNo=request.getParameter("MobileNo");
		 String Password=request.getParameter("Password");
		 String ConfirmPassword=request.getParameter("ConfirmPassword");
		 String Designation=request.getParameter("Designation");
		 String Status="";
		 if(Password.equals(ConfirmPassword))
		 {	 
		 User newUser = new User();
		 newUser.setUserName(UserName);
		 newUser.setEmail(Email);
		 newUser.setMobileNo(MobileNo);
		 newUser.setPassword(Password);
		 newUser.setDesignation(Designation);
		 Status= userService.registerUser(newUser);
		 }
		 else
		 {
			 Status="Password Does Not Match";
		 }
		request.setAttribute("Valid",Status);
		request.getRequestDispatcher("/components/ValidationsRedirect.jsp").forward(request, response);
 
			 
	}

}
