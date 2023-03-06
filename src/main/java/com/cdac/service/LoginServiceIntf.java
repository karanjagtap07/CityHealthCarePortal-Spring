package com.cdac.service;

import com.cdac.dto.Loginemail;
import com.cdac.dto.Loginotp;
import com.cdac.dto.Loginres;
import com.cdac.entity.User;

public interface LoginServiceIntf {
	
	Loginres authenticateUser(String email, String password);
	
	Loginemail generateOtp(String email);
	
	Loginotp verifyOtp(String uotp);
	
	void updatePassword(String password,String email);
	
}