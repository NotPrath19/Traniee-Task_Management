package com.yash.Eventelion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.Eventelion.dao.ApprovalDao;
import com.yash.Eventelion.daoimple.ApprovalDaoImple;
import com.yash.Eventelion.model.Approval;
import com.yash.Eventelion.service.ApprovalService;
import com.yash.Eventelion.serviceimple.ApprovalServiceImple;

/**
 * Servlet implementation class ApprovalDisplayServlet
 */
@WebServlet("/DisplayApprovalServlet")
public class DisplayApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ApprovalService approvalService;
	ApprovalDao approvalDao = new ApprovalDaoImple();
	public void init() throws ServletException 
	{
		this.approvalService= new ApprovalServiceImple(approvalDao);
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayApprovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Approval> userList = approvalService.showApproval();
		
		String RedirectVal = "ApproveDisplay";
		request.setAttribute("Valid",RedirectVal);
		request.setAttribute("userList",userList);		
		request.getRequestDispatcher("/components/ValidationsRedirect.jsp").forward(request, response);
		
	}

}
