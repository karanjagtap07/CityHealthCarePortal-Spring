package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Cookie;
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

import com.cdac.dto.Loginemail;
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
	public ResponseEntity<?> authenticateUser(@RequestBody Loginreq loginreq) {
		return ResponseEntity.ok(loginService.authenticateUser(loginreq.getEmail(), loginreq.getPassword()));
	}

	@PostMapping("/generateotp/{email}")
	private ResponseEntity<?> generateOtp(@PathVariable String email) {
		loginService.generateOtp(email);
		return ResponseEntity.ok(loginService.generateOtp(email));
		//return new ResponseEntity<>("Sent OTP", HttpStatus.OK);

	}

	@PostMapping("/verifyotp/{uotp}")
	private ResponseEntity<String> verifyOtp(@PathVariable String uotp) {
		System.out.println(uotp);
		loginService.verifyOtp(uotp);
		return new ResponseEntity<>("OTP Verified", HttpStatus.OK);

	}

	@PutMapping("/changepassword/{password}/{e}")
	private ResponseEntity<String> changePassword(@PathVariable String password,@PathVariable String e) {
		loginService.updatePassword(password, e);
		System.out.println(password+" "+e);
		return new ResponseEntity<>("Password Changed", HttpStatus.OK);
	}

}
