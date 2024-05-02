package com.yash.Eventelion.service;
import java.util.ArrayList;

import com.yash.Eventelion.model.Approval;
public interface ApprovalService {
	void grantApproval(int Id);
	void revokeApproval(int Id);
	ArrayList<Approval> showApproval();
}
