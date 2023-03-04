package com.cdac.service;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class OtpService
{
	
	static char[] generateOtp()
	{
		System.out.print("Your new password is : ");

		// A strong password has Cap_chars, Lower_chars,
		// numeric value and symbols. So we are using all of
		// them to generate our password
		
		String numbers = "0123456789";
		String values =  numbers;
   
		Random randomNumber = new Random();

		char[] password = new char[6];

		for (int i = 0; i < 6; i++)
		{
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int
			password[i] = values.charAt(randomNumber.nextInt(values.length()));

		}
		return password;
	}
}