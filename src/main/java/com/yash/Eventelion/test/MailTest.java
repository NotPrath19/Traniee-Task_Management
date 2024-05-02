package com.yash.Eventelion.test;
import com.yash.Eventelion.utility.MailUtil;
public class MailTest {
public static void main(String[] args) {
	try {
		MailUtil.sendEmail("bansalritik25@gmail.com","CrudProject", "Hello");
		System.out.println("Works");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
