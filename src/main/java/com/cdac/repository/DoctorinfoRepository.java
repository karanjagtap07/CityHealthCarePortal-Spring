package com.cdac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.entity.Doctorinfo;
import com.cdac.entity.Hospital;

@Repository
public interface DoctorinfoRepository extends JpaRepository<Doctorinfo, Integer>{
	
	List<Doctorinfo> findByHospital(Hospital hospital);
	
	
}
