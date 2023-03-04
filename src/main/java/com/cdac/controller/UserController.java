package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Doctorinfo;
import com.cdac.entity.User;
import com.cdac.repository.UserRepository;
import com.cdac.service.DoctorinfoServiceIntf;
import com.cdac.service.UserServiceIntf;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceIntf userService;
	@Autowired
	private DoctorinfoServiceIntf doctorinfoService;
	
	
	@PostMapping("/adduser")
	private ResponseEntity<String> saveuser(@RequestBody User user){
		userService.saveUser(user);
		return new ResponseEntity<>("SUCCESSFULLY ADDED",HttpStatus.CREATED);
	}
	@GetMapping("/doctorinfo/{hosname}")
	private List<Doctorinfo> getAllDoctorinfo(@PathVariable String hosname) {
		return doctorinfoService.getAllDoctorinfosByName(hosname);
	}
	
	@DeleteMapping("/deleteuser/{email}")
	private ResponseEntity<String> deleteuser(@PathVariable String email){	
		userService.deleteByEmail(email);
		System.out.println(email);
		return new ResponseEntity<>("SUCCESSFULLY DELETED",HttpStatus.OK);
	}
		
}
