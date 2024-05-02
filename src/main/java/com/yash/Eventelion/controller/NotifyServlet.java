package com.yash.Eventelion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.Eventelion.dao.SubmissionDao;
import com.yash.Eventelion.daoimple.SubmissionDaoImple;
import com.yash.Eventelion.model.Submission;
import com.yash.Eventelion.service.SubmissionService;
import com.yash.Eventelion.serviceimple.SubmissionServiceImple;

/**
 * Servlet implementation class AddTaskUserServlet
 */
@WebServlet("/NotifyServlet")
public class NotifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubmissionService submissionService;
	SubmissionDao submissionDao = new SubmissionDaoImple();
	
	public void init() throws ServletException 
	{
		this.submissionService = new SubmissionServiceImple(submissionDao);

	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		submissionService.feedback(request.getParameter("UserName"), request.getParameter("Subject"), request.getParameter("Body"));
		List<Submission> taskList = submissionService.getSubmissionList(); 
	    String RedirectVal = "DisplaySubmissions";
		request.setAttribute("Valid",RedirectVal);
		request.setAttribute("taskList",taskList);
	    request.setAttribute("User",request.getParameter("User"));	
		request.setAttribute("Desig",request.getParameter("Desig"));		
		request.getRequestDispatcher("/components/ValidationsRedirect.jsp").forward(request, response);
	
	}

}
