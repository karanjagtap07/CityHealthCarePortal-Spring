package com.cdac.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Hospital;
import com.cdac.entity.User;
import com.cdac.repository.AdminRepository;
import com.cdac.repository.HospitalRepository;
import com.cdac.repository.RequestRepository;
import com.cdac.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserServiceIntf {

	@Autowired
	AdminRepository adminRepository;
	@Autowired
	RequestRepository requestRepository;
	@Autowired
	HospitalRepository hospitalRepository;
	@Autowired
	EmailService emailService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	EncryptService encryptService;
	@Autowired
	HospitalServiceIntf hospitalService;

	@Override
	public User saveUser(User user) {

		String sp = user.getPassword();
		try {
			String encryptPassword = encryptService.toHexString(encryptService.getSHA(sp));
			user.setPassword(encryptPassword);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Exception thrown for incorrect algorithm: " + e);
		}

		if (user.getEmail().equals((userRepository.findEmail(user.getEmail())))) {
			System.out.println("user already exist");
		} else {

			User u = userRepository.save(user);
			emailService.sendEmailForNewRegistration(user.getEmail());
			System.out.println("Mail Sent Successfully");
			return u;
		}
		return user;
	}

	/*
	 * @Override public User saveUser(User user) {
	 * 
	 * String sp = user.getPassword(); try { String encryptPassword =
	 * encryptService.toHexString(encryptService.getSHA(sp));
	 * user.setPassword(encryptPassword); }catch(NoSuchAlgorithmException e) {
	 * System.out.println("Exception thrown for incorrect algorithm: " + e); }
	 * emailService.sendEmailForNewRegistration(user.getEmail());
	 * System.out.println("Mail Sent Successfully");
	 * 
	 * return userRepository.save(user); }
	 */

	@Override
	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	@Override
	public Hospital findAmbulanceContactById(int hospid) {

		return hospitalRepository.findById(hospid).get();
	}

	@Override
	public Hospital findAllByHospitalId(int hospid) {

		return hospitalRepository.findById(hospid).get();
	}

	public void updatePassword(String password, String email) {

	}

	@Override
	public void deleteUser(String email) {
		userRepository.deleteByEmail(email);

	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
		
	}

	@Override
	public Long deleteByEmail(String email) {
		userRepository.deleteByEmail(email);
		return null;
	}


	

}	
