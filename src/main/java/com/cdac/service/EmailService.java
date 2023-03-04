package com.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender sendMail;
	
	public void sendEmailForNewRegistration(String email) 
	{
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("chcp.response.info@gmail.com");
		message.setTo(email);
		message.setSubject("Registration Mail !!  Successfully Registered");
		message.setText("Thank You for Registering With Us! Welcome to City Health Care Portal");
		sendMail.send(message);
		System.out.println("mail sent");
	}
	
	
	public void sendEmailForOtp(String email,char[] otp) 
	{
		SimpleMailMessage message = new SimpleMailMessage();
		String str = new String(otp);
		message.setFrom("chcp.response.info@gmail.com");
		message.setTo(email);
		message.setSubject("Registration Mail !!  Successfully Registered");
		message.setText("OTP for change password is : "+str);
		sendMail.send(message);
		System.out.println("mail sent");
	}
	}
