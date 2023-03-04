package com.cdac.service;

import com.cdac.dto.Loginres;

public interface LoginServiceIntf {
	
	Loginres authenticateUser(String email, String password);
	
	Loginres generateOtp(String email);

	
}