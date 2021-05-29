package com.KMM.GateWayInfo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KMM.GateWayInfo.Bean.User;
import com.KMM.GateWayInfo.Service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService regService;
	
	@RequestMapping("/")
	public String index() {
		return "Spring-boot Start";
	}

	@RequestMapping("/registerUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempemailid = user.getEmail();
		if (tempemailid != null && !"".equals(tempemailid)) {

			User userObj = regService.fetchUserbyEmail(tempemailid);
			if (userObj != null) {
				throw new Exception("User with this " + tempemailid + " exists.");
			}

		}
		User userObj = null;
		userObj = regService.saveUser(user);
		return userObj;
	}

	@RequestMapping("/loginUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempemailid = user.getEmail();
		String temppassword = user.getPassword();
		User userObj = null;

		if (tempemailid != null && temppassword != null) {
			userObj = regService.fetchUserbyEmailAndPassword(tempemailid, temppassword);
		}
		if (userObj == null) {
			throw new Exception("Entered Email and Password do not exists.");
		}
		return userObj;
	}

}
