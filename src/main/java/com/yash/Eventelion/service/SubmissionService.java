package com.yash.Eventelion.service;

import java.util.List;

import com.yash.Eventelion.model.Submission;

public interface SubmissionService {
void submit(Integer Id);
void remove(Integer Id);
void update(String Task, Integer Id);
List<Submission> getSubmissionList();
List<Submission> getSubmissionListUser(String UserName);
void feedback(String UserName,String Subject,String Body);

}
