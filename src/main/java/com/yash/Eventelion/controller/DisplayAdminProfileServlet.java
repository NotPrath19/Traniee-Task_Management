package com.yash.Eventelion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.Eventelion.dao.TaskDao;
import com.yash.Eventelion.dao.UserDao;
import com.yash.Eventelion.daoimple.TaskDaoImple;
import com.yash.Eventelion.daoimple.UserDaoImple;
import com.yash.Eventelion.model.Task;
import com.yash.Eventelion.model.User;
import com.yash.Eventelion.service.TaskService;
import com.yash.Eventelion.service.UserService;
import com.yash.Eventelion.serviceimple.TaskServiceImple;
import com.yash.Eventelion.serviceimple.UserServiceImple;

/**
 * Servlet implementation class UserDisplayServlet
 */
@WebServlet("/DisplayAdminProfileServlet")
public class DisplayAdminProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private UserService userService;
	UserDao userDao = new UserDaoImple();
	private TaskService taskService;
	TaskDao taskDao = new TaskDaoImple();
	public void init() throws ServletException 
	{
		this.userService= new UserServiceImple(userDao);
		this.taskService= new TaskServiceImple(taskDao);
	}
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayAdminProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
    	 	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	String UserName = request.getParameter("User");
	User user = userService.getUser(UserName);
	ArrayList<Task> taskList = new ArrayList<Task>();
	taskList=taskService.displayCurrentTaskAdmin();
	String RedirectVal = "AdminProfileDisplay";
	request.setAttribute("Valid",RedirectVal);
	request.setAttribute("taskList",taskList);
	request.setAttribute("UserProfile",user);
	request.getRequestDispatcher("/components/ValidationsRedirect.jsp").forward(request, response);
	}
	
}
