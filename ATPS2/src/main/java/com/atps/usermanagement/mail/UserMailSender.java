package com.atps.usermanagement.mail;

import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.atps.usermanagement.constants.AppConstants;
import com.atps.usermanagement.properties.AppProperties;
import com.atps.usermanagement.reader.MailTextReader;

@Component
public class UserMailSender {
	/**
	 * injecting javaMailSender object
	 */
	@Autowired
    private JavaMailSender javaMailSender;
	/**
	 * injecting MailTextReader object
	 */
	@Autowired
	MailTextReader reader;
	/**
	 * injecting AppProperties object 
	 */
	@Autowired
	AppProperties properties;
	
	MimeMessage message=null; 
	 MimeMessageHelper helper=null;
	
	private static Logger LOGGER = LogManager.getLogger(UserMailSender.class);
	
    public String sendUserMail(String firstName,String email,String pswd) {
    	
    try {
    	LOGGER.info("************try block of sendUserMail method of  UserMailSender execution started************");
	 message = javaMailSender.createMimeMessage();
    
    // Enable the multipart flag!
    helper = new MimeMessageHelper(message,true);
    
    helper.setTo(email);//"shrabaneebiswal100@gmail.com"
    helper.setText(reader.readFile(firstName,email,pswd));//newContent

    helper.setSubject("ATPS Notification");//(properties.getMessages().get(AppConstants.SUBJECT1));

    javaMailSender.send(message);
    }
    catch(Exception e) {
    	LOGGER.info("************catch block of sendUserMail method of  UserMailSender execution started************");
    	e.printStackTrace();
    }
    LOGGER.info("************sendUserMail method of  UserMailSender execution ended************");
    return "ddd";
    }
    
    /**
     * this method recieves password and email as param
     * sends the mail to customer with the password
     * @param pswd
     * @param email
     */
    public void mailWithUpdatedPassword(String pswd,String email) {
    	 try {
    	 message = javaMailSender.createMimeMessage();
    	 helper = new MimeMessageHelper(message,true);
    	 helper.setTo(email);//"shrabaneebiswal100@gmail.com"
    	    helper.setText(properties.getMessages().get("body")+"  "+pswd);//newContent
    	    helper.setSubject(properties.getMessages().get("subject2"));
    	    javaMailSender.send(message);
    	 }
    	 catch(Exception e) {
    	    	LOGGER.info("************catch block of mailWithUpdatedPassword method of  UserMailSender execution started************");
    	    	e.printStackTrace();
    	    }
    }
}
