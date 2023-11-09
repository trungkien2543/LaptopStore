package SMSmail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {
	public static String randomSMS() {
		int n = 6;
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < n; i++) {
	      sb.append(random.nextInt(10));
	    }
	    String randomString = sb.toString();
	    System.out.println("Random number string: " + randomString);
	    return randomString;
	}
	
	public static String send(String to) {
		
		final String user = "duyatmsuper@gmail.com";
		final String pass = "kafxxrneibbumjwh";
		
		String code = randomSMS();
		
		String sub = "Your order has been processing.";
		String msg = "<!DOCTYPE html>\n"
				+ "<html lang=\"en\">\n"
				+ "\n "
				+ "<head>\n"
				+ "</head>\n"
				+ "\n"
				+ "<body>\n"
				/*+ "   <h3 style=\"color: blue;\"> Your order has been processing.</h3>\n"*/
				+ "   <div  ><h1>Code: <b style=\"color: red;\">"
				+ code
				+ "</h1> </b>  </div>\n"
				+ "   <h3 style=\"color: blue;\"> Thanh you very much! </h3>\n"
				+ "\n"
				+ "</body>\n"
				+ "\n"
				+ "</html>";
		
		
		Properties props = System.getProperties();
		props.put("mail.debug", "true");
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override 
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setContent(msg, "text/html");
			
			Transport.send(message);
		} catch (MessagingException e) {
			return "-1";
		}
		return code;
	}
}
