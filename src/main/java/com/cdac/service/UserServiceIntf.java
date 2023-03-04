package com.cdac.service;

import java.util.List;

import com.cdac.entity.Hospital;
import com.cdac.entity.User;

public interface UserServiceIntf {

	User saveUser(User user);
	
	List<User> getAllUser();
	
	Hospital findAmbulanceContactById(int hospid);
	
	Hospital findAllByHospitalId(int hospid);
	
	void deleteUser(String email);
	
	void delete(User user);
	
	Long deleteByEmail(String email);
}
