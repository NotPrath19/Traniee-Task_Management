package com.yash.Eventelion.utility;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class MailUtil {
//	EmailId-prathmeshranadive1901@gmail.com	Pass-Test@Email
	public static void sendEmail(String To,String Subject,String Body)
	{
		final String username ="prathmeshranadive1901@gmail.com";
		final String password="qvms glzm uagu ywxf";
		Properties props = new Properties();	
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		

		Session session = Session.getDefaultInstance(props, new Authenticator() 
		{ protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username,password);}
		});
		try {
			Message message =new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
			message.setSubject(Subject);
			message.setText(Body);
			Transport.send(message);
		}
		catch (MessagingException e) {
		e.printStackTrace();
		}
	}
}
