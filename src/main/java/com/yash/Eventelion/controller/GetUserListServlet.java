package com.yash.Eventelion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.Eventelion.dao.TaskDao;
import com.yash.Eventelion.daoimple.TaskDaoImple;
import com.yash.Eventelion.service.TaskService;
import com.yash.Eventelion.serviceimple.TaskServiceImple;

/**
 * Servlet implementation class AddTaskUserServlet
 */
@WebServlet("/GetUserListServlet")
public class GetUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskService taskService;
	TaskDao taskDao = new TaskDaoImple();
	public void init() throws ServletException 
	{
		this.taskService= new TaskServiceImple(taskDao);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> userList = new ArrayList<String>();
	    userList = taskService.getUserNameList();
	    String RedirectVal = "GetUserList";
		request.setAttribute("Valid",RedirectVal);
		request.setAttribute("userList",userList);
	    request.setAttribute("User",request.getParameter("User"));	
		request.setAttribute("Desig",request.getParameter("Desig"));		
		request.getRequestDispatcher("/components/ValidationsRedirect.jsp").forward(request, response);
	
	}

}
