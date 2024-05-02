package com.yash.Eventelion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.Eventelion.dao.UserDao;
import com.yash.Eventelion.daoimple.UserDaoImple;
import com.yash.Eventelion.service.UserService;
import com.yash.Eventelion.serviceimple.UserServiceImple;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserSignoutServlet")
public class UserSignoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
	UserDao userDao = new UserDaoImple();
	public void init() throws ServletException 
	{
		this.userService= new UserServiceImple(userDao);
	}
	
    public UserSignoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String UserName = request.getParameter("UserName");
         userService.signoutUser(UserName);
         int Status = userService.status(UserName);
         String RedirectVal = "Signout";
		request.setAttribute("Status",Status);
		request.setAttribute("Valid",RedirectVal);
		request.getRequestDispatcher("/components/ValidationsRedirect.jsp").forward(request, response);

		
	}

}
