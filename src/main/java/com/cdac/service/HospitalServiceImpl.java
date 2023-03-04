package com.cdac.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Doctorinfo;
import com.cdac.entity.Hospital;
import com.cdac.repository.AdminRepository;
import com.cdac.repository.DoctorinfoRepository;
import com.cdac.repository.HospitalRepository;
import com.cdac.repository.UserRepository;

@Service
@Transactional
public class HospitalServiceImpl implements HospitalServiceIntf {

	@Autowired
	HospitalRepository hospitalRepository;
	
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	DoctorinfoRepository doctorinfoRepository;
	@Autowired
	EncryptService encryptService;
	
	@Override
	public Hospital savehospital(Hospital hosp) {
		String sp = hosp.getPassword();
		try {
		String encryptPassword = encryptService.toHexString(encryptService.getSHA(sp));
		hosp.setPassword(encryptPassword);
		}catch(NoSuchAlgorithmException e) {
			 System.out.println("Exception thrown for incorrect algorithm: " + e);
		}
		return hospitalRepository.save(hosp);
	}
	
	@Override
	public List<Hospital> getAllHospital() {
		return hospitalRepository.findAll();
	}
	
	@Override
	public Hospital getHospitalById(int id) {
		try {
			
		return hospitalRepository.findById(id).get();
		}catch(NoSuchElementException e) {
			return new Hospital();
		}
	}
	
	@Override
	public Doctorinfo savedoctorinfo(Doctorinfo d, int id) {
		Hospital hos = hospitalRepository.findById(id).get();
		
		Doctorinfo info = new Doctorinfo(d.getName(), d.getEmail(), d.getQualification(), d.getSpecialization(),hos);
		
		return doctorinfoRepository.save(info);
	}
	
	@Override
	public void updateBed(Hospital hosp, int id) {
		//List<Hospital> lis =hospitalRepository.findBedByHospitalId(id);
	
		//if(hosp.getVentilator()==(0)) {
		//	hosp.setVentilator(	lis.get(0).getVentilator());	
		//}
		//if(hosp.getNormal()==(0)) {
	//		hosp.setNormal(	lis.get(0).getNormal());	
	//	}
	//	if(hosp.getOxygen()==(0)) {
	//		hosp.setOxygen(	lis.get(0).getOxygen());	
	//	}
		
		hospitalRepository.updatebed(id, hosp.getVentilator(), hosp.getOxygen(), hosp.getNormal());
		
	}

	@Override
	public void updateBlood(Hospital h, int id) {
		hospitalRepository.updateblood(id, h.getA_pos(), h.getA_neg(), h.getB_pos(), h.getB_neg(),
				h.getAb_pos(), h.getAb_neg(), h.getO_pos(), h.getO_neg());
	}

	@Override
	public void updateOxygen(Hospital hosp,int id) {
		hospitalRepository.updateoxygen(id, hosp.getOxygenavailable());
	}
	
	@Override
	public Hospital getBedByHospitalname(String hosname) {
		return hospitalRepository.findByHospitalname(hosname);
	}

	@Override
	public Hospital getBloodByHospitalname(String hosname) {
		return hospitalRepository.findByHospitalname(hosname);
	}

	@Override
	public Hospital getOxygenByHospitalname(String hosname) {
		return hospitalRepository.findByHospitalname(hosname);
	}
	
	 /*@Override
		public Bed updateBed(Bed bed) {
			Bed b = bedRepository.findById(bed.getBedid()).get();
			b.setNormal(bed.getNormal());
			b.setOxygen(bed.getOxygen());
			b.setVentilator(bed.getVentilator());
			return bedRepository.save(b);
		}
		@Override
		public Blood updateBlood(Blood blood) {
			Blood bl = bloodRepository.findById(blood.getBloodid()).get();
			bl.setApos(blood.getApos());
			bl.setAneg(blood.getAneg());
			bl.setBpos(blood.getBpos());
			bl.setBneg(blood.getBneg());
			bl.setAbpos(blood.getAbpos());
			bl.setAbneg(blood.getAbneg());
			bl.setOpos(blood.getOpos());
			bl.setOneg(blood.getOneg());
			return bloodRepository.save(bl);
		}
		@Override
		public Oxygen updateOxygen(Oxygen oxygen) {
			Oxygen o = oxygenRepository.findById(oxygen.getOxygenid()).get();
			o.setOxygenavailable(oxygen.getOxygenavailable());
			return oxygenRepository.save(o);
		}*/

}
