package com.yash.Eventelion.dao;

import java.util.List;

import com.yash.Eventelion.model.Submission;

public interface SubmissionDao {
  
	void save(Integer id);
	void migrate(Integer id);
	void delete(Integer id);
	void notify(String UserName,String Subject,String Body);
	
	void update(String Task, Integer Id);
    List<Submission> getsubmissions();
    List<Submission> getsubmissionbyUserName(String UserName);

}
