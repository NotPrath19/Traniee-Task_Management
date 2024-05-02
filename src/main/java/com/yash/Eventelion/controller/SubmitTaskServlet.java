package com.yash.Eventelion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.Eventelion.dao.SubmissionDao;
import com.yash.Eventelion.dao.TaskDao;
import com.yash.Eventelion.daoimple.SubmissionDaoImple;
import com.yash.Eventelion.daoimple.TaskDaoImple;
import com.yash.Eventelion.model.Task;
import com.yash.Eventelion.service.SubmissionService;
import com.yash.Eventelion.service.TaskService;
import com.yash.Eventelion.serviceimple.SubmissionServiceImple;
import com.yash.Eventelion.serviceimple.TaskServiceImple;

/**
 * Servlet implementation class AddTaskUserServlet
 */
@WebServlet("/SubmitTaskServlet")
public class SubmitTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubmissionService submissionService;
	SubmissionDao submissionDao = new SubmissionDaoImple();
	private TaskService taskService;
	TaskDao taskDao = new TaskDaoImple();
	public void init() throws ServletException 
	{
		this.submissionService = new SubmissionServiceImple(submissionDao);
		this.taskService= new TaskServiceImple(taskDao);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		submissionService.submit(Integer.parseInt(request.getParameter("Id")));
		ArrayList<Task> taskList = new ArrayList<Task>();
		taskList = taskService.displayTaskForUser(request.getParameter("User")); 
	    String RedirectVal = "SubmittedTask";
		request.setAttribute("Valid",RedirectVal);
		request.setAttribute("taskList",taskList);
	    request.setAttribute("User",request.getParameter("User"));	
		request.setAttribute("Desig",request.getParameter("Desig"));		
		request.getRequestDispatcher("/components/ValidationsRedirect.jsp").forward(request, response);
	
	}

}
