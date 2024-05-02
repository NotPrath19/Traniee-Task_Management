package com.yash.Eventelion.serviceimple;
import java.util.ArrayList;

import com.yash.Eventelion.dao.ApprovalDao;
import com.yash.Eventelion.model.Approval;
import com.yash.Eventelion.service.ApprovalService;
import com.yash.Eventelion.utility.MailUtil;

public class ApprovalServiceImple implements ApprovalService
{
private ApprovalDao approvalDao;
public ApprovalServiceImple(ApprovalDao approvalDao)
{
this.approvalDao= approvalDao;
}

@Override
public void grantApproval(int Id) {
	Approval user = approvalDao.getApprovalById(Id);
	MailUtil.sendEmail(user.getEmail(),"Admin Signup Request", "Approved");
	approvalDao.migrate(Id);
}
@Override
public void revokeApproval(int Id) {
	// TODO Auto-generated method stub
	Approval user = approvalDao.getApprovalById(Id);
	MailUtil.sendEmail(user.getEmail(),"Admin Signup Request", "Denied");
	approvalDao.delete(Id);
	
}
@Override
public ArrayList<Approval> showApproval() {
	// TODO Auto-generated method stub
	return approvalDao.getApproval();
}

}