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
import com.yash.Eventelion.model.Task;
import com.yash.Eventelion.service.TaskService;
import com.yash.Eventelion.serviceimple.TaskServiceImple;

/**
 * Servlet implementation class AddTaskUserServlet
 */
@WebServlet("/DisplayAdminScheduleServlet")
public class DisplayAdminScheduleServlet extends HttpServlet {
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
    public DisplayAdminScheduleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Task> taskList = new ArrayList<Task>();
		taskList = taskService.displayTaskForAdmin();
	    String RedirectVal = "DisplayTaskAdmin";
		request.setAttribute("Valid",RedirectVal);
		request.setAttribute("taskList",taskList);
		request.getRequestDispatcher("/components/ValidationsRedirect.jsp").forward(request, response);
	
	}

}
