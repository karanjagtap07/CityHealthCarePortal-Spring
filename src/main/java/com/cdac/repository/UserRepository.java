package com.cdac.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.cdac.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	Optional<User> findByEmailAndPassword(String email, String password);
	Optional<User> findByEmail(String email);
	
	@Query("select email from User u where u.email=:email")
	String findEmail(String email);
	
	@Modifying
	@Query("update User u set  u.password=:password where u.email=:email")
	void updatePassword(String password,String email);
    
	/*
	 * @Transactional
	 * 
	 * @Modifying
	 * 
	 * @Query("delete from User u where u.email=:email") void
	 * deleteByEmail(@Param("email") String email);
	 */
	
	Long deleteByEmail(String email);
}


