package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Doctorinfo;
import com.cdac.entity.Hospital;
import com.cdac.repository.DoctorinfoRepository;
import com.cdac.repository.HospitalRepository;

@Service
public class DoctorinfoServiceImpl implements DoctorinfoServiceIntf{
	
	@Autowired
	HospitalRepository hospitalRepository;
	@Autowired
	DoctorinfoRepository doctorinfoRepository;
	
	@Override
	public List<Doctorinfo> getAllDoctorinfos(int hospid) {
		Hospital hospital = hospitalRepository.getById(hospid);
		return doctorinfoRepository.findByHospital(hospital);
	}

	@Override
	public List<Doctorinfo> getAllDoctorinfosByName(String hosname) {
		Hospital hospital = hospitalRepository.findByHospitalname(hosname);
		return doctorinfoRepository.findByHospital(hospital);
	}

}
