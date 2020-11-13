package com.mdms.app.mgmt.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mdms.PasswordSecurityConfiguration;
import com.mdms.app.mgmt.model.UserLoginDetailModel;
import com.mdms.app.mgmt.repository.UserLoginDetailRepository;


@Service
public class UserLoginService {
	
	
	 Logger logger=LoggerFactory.getLogger(UserLoginService.class);
	 
	 
	 @Autowired
	 UserLoginDetailRepository loginDetailObj;

	 private final PasswordEncoder passwordEncoder = new PasswordSecurityConfiguration().passwordEncoder();
public String verifyLogin(String user_id,String pwd) {
	
	String response = "failed";
	try {
	
	

	
			logger.info("Service : UserLoginService || Method : verifyLogin ||");
			
			
			List<UserLoginDetailModel> list  =	loginDetailObj.getDeatils(user_id);

			
			
<<<<<<< HEAD
			if((list.size()>0) ) {
				if(list.get(0).getUser_register_approval().equalsIgnoreCase("N")) {
					
					logger.info("Service : UserLoginService || Method : getUser_register_approval 'N'||");
				response = "Registered MDMS user is not approved by approving authority.";
					
				}else if(list.get(0).getUser_register_approval().equalsIgnoreCase("Y") ){
					
					logger.info("Service : UserLoginService || Method : getUser_register_approval 'Y'||");
				
				boolean result=passwordEncoder.matches(pwd,list.get(0).getEmp_password());
			if(result) {
				
				logger.info("Service : UserLoginService || Method : passwordEncoder.matches  'Y'||");
=======
			if(list.size()>0) {
				
				
				boolean result=passwordEncoder.matches(pwd,list.get(0).getEmp_password());
			if(result) {
>>>>>>> ef3574260e9ec6ab5b6df606ebd08b2a510cdcb0
				response="success";	
			}else {
				response="Wrong Password";	
			}
<<<<<<< HEAD
				}else {
					response  = "Failed";	
				}
				
=======
>>>>>>> ef3574260e9ec6ab5b6df606ebd08b2a510cdcb0
			
			}else {
				response="This UserId is not registered.Please Registered First.";
			}
}catch(Exception ex) {
	
	logger.info("Service : UserProfileRegistrationService || Method : saveUserDetails ||Exception pwd encryption" + ex.getMessage());

//	System.out.print(ex.getMessage());
}
	return response;
}



}
