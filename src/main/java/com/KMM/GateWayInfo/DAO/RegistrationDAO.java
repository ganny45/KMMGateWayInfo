package com.KMM.GateWayInfo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.KMM.GateWayInfo.Bean.User;

public interface RegistrationDAO extends JpaRepository<User, Integer> {
	
	public User findByEmail(String email);
	
	public User findByEmailAndPassword(String email,String password);
}
