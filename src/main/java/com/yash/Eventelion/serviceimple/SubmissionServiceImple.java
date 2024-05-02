package com.yash.Eventelion.serviceimple;

import java.util.List;

import com.yash.Eventelion.dao.SubmissionDao;
import com.yash.Eventelion.model.Submission;
import com.yash.Eventelion.service.SubmissionService;

public class SubmissionServiceImple implements SubmissionService {

	private SubmissionDao submissionDao;
	public SubmissionServiceImple(SubmissionDao submissionDao) {
		// TODO Auto-generated constructor stub
		this.submissionDao = submissionDao;
	}

	@Override
	public void submit(Integer Id) {
		// TODO Auto-generated method stub
		submissionDao.migrate(Id);

	}

	@Override
	public void remove(Integer Id) {
		// TODO Auto-generated method stub
         submissionDao.delete(Id);
	}

	@Override
	public List<Submission> getSubmissionList() {
		// TODO Auto-generated method stub
		return submissionDao.getsubmissions();
	}

	@Override
	public void feedback(String UserName, String Subject, String Body) {
		// TODO Auto-generated method stub
		submissionDao.notify(UserName, Subject, Body);
	}

	@Override
	public List<Submission> getSubmissionListUser(String UserName) {
		// TODO Auto-generated method stub
		return submissionDao.getsubmissionbyUserName(UserName);
	}

	@Override
	public void update(String Task, Integer Id) {
		// TODO Auto-generated method stub
		submissionDao.update(Task, Id);
	}

}
