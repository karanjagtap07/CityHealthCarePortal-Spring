package com.cdac.service;

import java.util.List;

import com.cdac.entity.Doctorinfo;

public interface DoctorinfoServiceIntf {

	List<Doctorinfo> getAllDoctorinfos(int hospid);
	
	List<Doctorinfo> getAllDoctorinfosByName(String hosname);
	
}
