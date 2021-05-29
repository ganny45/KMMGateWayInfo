package com.KMM.GateWayInfo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KMM.GateWayInfo.Bean.User;
import com.KMM.GateWayInfo.DAO.RegistrationDAO;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationDAO regDao;
	
	public User saveUser(User user) {
		
		return regDao.save(user);
		
	}
	
	public User fetchUserbyEmail(String email) {
		return regDao.findByEmail(email);
	}
	
	public User fetchUserbyEmailAndPassword(String email,String password) {
		
		return regDao.findByEmailAndPassword(email, password);
	}

}
