package com.yash.Eventelion.dao;
import java.util.ArrayList;

import com.yash.Eventelion.model.Approval;
public interface ApprovalDao 
{
Approval getApprovalById(int Id);

void insert(Approval user);
void migrate(int Id);
void delete(int Id);
ArrayList<Approval> getApproval();
}
