package com.yash.Eventelion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.Eventelion.dao.TaskDao;
import com.yash.Eventelion.dao.UserDao;
import com.yash.Eventelion.daoimple.TaskDaoImple;
import com.yash.Eventelion.daoimple.UserDaoImple;
import com.yash.Eventelion.service.TaskService;
import com.yash.Eventelion.service.UserService;
import com.yash.Eventelion.serviceimple.TaskServiceImple;
import com.yash.Eventelion.serviceimple.UserServiceImple;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/startups")
public class StartupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TaskService taskService;
	private UserService userService;
	TaskDao taskDao = new TaskDaoImple();
	UserDao userDao = new UserDaoImple();
	public void init() throws ServletException 
	{
		this.taskService= new TaskServiceImple(taskDao);
        this.userService= new UserServiceImple(userDao);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		taskService.remindAll();
		userService.signoutAllUsers();
		String RedirectVal = "Notified";
		request.setAttribute("Valid",RedirectVal);
		request.getRequestDispatcher("/components/ValidationsRedirect.jsp").forward(request, response);
		
	}
		
	}


