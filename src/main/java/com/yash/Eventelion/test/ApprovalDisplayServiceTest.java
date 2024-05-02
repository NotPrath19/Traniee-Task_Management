package com.yash.Eventelion.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.yash.Eventelion.dao.ApprovalDao;
import com.yash.Eventelion.daoimple.ApprovalDaoImple;
import com.yash.Eventelion.model.Approval;
import com.yash.Eventelion.service.ApprovalService;
import com.yash.Eventelion.serviceimple.ApprovalServiceImple;


public class ApprovalDisplayServiceTest {	
		
	public static void main(String[] args) {
		

	ApprovalDao approvalDao = new ApprovalDaoImple();
	ApprovalService approvalService =new ApprovalServiceImple(approvalDao);
	ArrayList<Approval> list = approvalService.showApproval();
	Iterator<Approval> it = list.iterator();
	Approval user = new Approval();
	while(it.hasNext())
	{
		user = it.next();
		System.out.println(user.getId()+user.getUserName()+user.getDesignation()+user.getEmail()+user.getMobileNo()+user.getPassword());
		
	}
		
	}

}
