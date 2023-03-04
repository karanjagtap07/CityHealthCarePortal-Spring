package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.Loginreq;
import com.cdac.entity.Doctorinfo;
import com.cdac.entity.Hospital;
import com.cdac.service.LoginServiceIntf;

@RestController
@RequestMapping("login")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

	@Autowired
	LoginServiceIntf loginService;
	
	@PostMapping("/userlogin")
	public ResponseEntity<?> authenticateUser(@RequestBody Loginreq loginreq){
		return ResponseEntity.ok(loginService.authenticateUser(loginreq.getEmail(),loginreq.getPassword()));
	}
	
	
	@PostMapping("/generateotp/{email}")
	private ResponseEntity<String> generateOtp(@PathVariable String email) {
		loginService.generateOtp(email);
		return new ResponseEntity<>("Sent OTP",HttpStatus.OK); 
		
	}
	
	//forget password 
	/*
	 * @PutMapping("/forgotpassword/{email}/{otp}") private ResponseEntity<String>
	 * forgotPassword(@PathVariable String email,@PathVariable String otp) {
	 * 
	 * return new ResponseEntity<>("PASSWORD UPDATED",HttpStatus.OK); }
	 */
} 
