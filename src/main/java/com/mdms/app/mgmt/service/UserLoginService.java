package com.mdms.app.mgmt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mdms.PasswordSecurityConfiguration;


@Service
public class UserLoginService {
	
	
	 Logger logger=LoggerFactory.getLogger(UserLoginService.class);

	 private final PasswordEncoder passwordEncoder = new PasswordSecurityConfiguration().passwordEncoder();
public String userLogin(String user_id,String pwd) {
	
	try {
	String	 encodedPassword = passwordEncoder.encode(pwd);
			logger.info("Service : UserProfileRegistrationService || Method : saveUserDetails ||");

//System.out.print("Encripted pwd: "+ encodedPassword);
}catch(Exception ex) {
	
	logger.info("Service : UserProfileRegistrationService || Method : saveUserDetails ||Exception pwd encryption" + ex.getMessage());

//	System.out.print(ex.getMessage());
}
	return pwd;
}
}
