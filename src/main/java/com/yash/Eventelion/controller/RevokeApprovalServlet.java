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
 * Servlet implementation class RevokeApprovalServlet
 */
@WebServlet("/RevokeApprovalServlet")
public class RevokeApprovalServlet extends HttpServlet {
	private ApprovalService approvalService;
	ApprovalDao approvalDao = new ApprovalDaoImple();
	public void init() throws ServletException 
	{
		this.approvalService= new ApprovalServiceImple(approvalDao);
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevokeApprovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Id = Integer.parseInt(request.getParameter("Id"));
		approvalService.revokeApproval(Id);
        ArrayList<Approval> userList = approvalService.showApproval();
         
		String RedirectVal = "Denied";
		request.setAttribute("Valid",RedirectVal);
		request.setAttribute("userList",userList);	
		request.setAttribute("User",request.getParameter("User"));	
		request.setAttribute("Desig",request.getParameter("Desig"));
		request.getRequestDispatcher("/components/ValidationsRedirect.jsp").forward(request, response);
	}

}
