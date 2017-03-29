package model;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Email {
	
	   
	
	public void sendEmail(String emailId){
		
		System.out.println("In email ");

    // Recipient's email ID needs to be mentioned.
    String to = emailId;
    
    String[] recepient={emailId};

    // Sender's email ID needs to be mentioned
    //Graders enter your gmail id and password to test the application
    String from = "ysuraj76@gmail.com";
    String pass ="enter password";
    
    // Assuming you are sending email from localhost
    String host = "smtp.gmail.com";

    Properties properties = System.getProperties();
    
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.user", from);
    properties.put("mail.smtp.password", pass);
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.auth", "true");

 

    try {
    	// Get the default Session object.
        Session session = Session.getInstance(properties);
       // Create a default MimeMessage object.
       MimeMessage message = new MimeMessage(session);
       

       // Set From: header field of the header.
       message.setFrom(new InternetAddress(from));

       // Set To: header field of the header.
       message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

       // Set Subject: header field
       message.setSubject("Regsitration Successful for the website A2Z corp!");

       // Now set the actual message
       message.setText("Congrats you have been sucessfully Registered");

       // Send message
       Transport transport = session.getTransport("smtp");
       transport.connect(host, from, pass);
       transport.sendMessage(message,message.getAllRecipients());
      // Transport.send(message);
       transport.close();
       
       System.out.println("Sent message successfully....");
    }catch (MessagingException mex) {
       mex.printStackTrace();
    }
}

	   

}
