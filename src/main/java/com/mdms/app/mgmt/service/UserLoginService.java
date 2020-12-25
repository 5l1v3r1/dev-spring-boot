package com.mdms.app.mgmt.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.mdms.PasswordSecurityConfiguration;
import com.mdms.app.mgmt.model.UserLoginDetailModel;
import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.app.mgmt.repository.UserLoginDetailRepository;
import com.mdms.app.mgmt.repository.UserProfileRegistrationRepository;
@Service
public class UserLoginService {	
	 Logger logger=LoggerFactory.getLogger(UserLoginService.class);	 
	 @Autowired
	 UserLoginDetailRepository loginDetailObj;	 
	 @Autowired
	 UserProfileRegistrationRepository  profileRegistrationRepoObj;
	 private final PasswordEncoder passwordEncoder = new PasswordSecurityConfiguration().passwordEncoder();
public String verifyLogin(String user_id,String pwd) {	
	String response = "failed";
	try {	
			logger.info("Service : UserLoginService || Method : verifyLogin ||");

			
			List<UserLoginDetailModel> list  =	loginDetailObj.getDeatils(user_id.toUpperCase());
			List<UserProfileRegistrationDetailModel> listUserProfileObj  =	profileRegistrationRepoObj.getUserDetail(user_id.toUpperCase());
			if((list.size()>0) && (listUserProfileObj.size()>0)) {
				if(listUserProfileObj.get(0).getUser_register_approval().equalsIgnoreCase("N")) {
					
					logger.info("Service : UserLoginService || Method : getUser_register_approval 'N'||");
				response = "Registered MDMS user is not approved by approving authority.";
					
				}else if(listUserProfileObj.get(0).getUser_register_approval().equalsIgnoreCase("Y") ){
					
					logger.info("Service : UserLoginService || Method : getUser_register_approval 'Y'||");
				
				boolean result=passwordEncoder.matches(pwd,list.get(0).getEmp_password());
			if(result) {
				
				logger.info("Service : UserLoginService || Method : passwordEncoder.matches  'Y'||");
				response="success";	
				
				
			}else {
				response="Wrong Password";	
			}

			}
				}
			
			else {
				response="This UserId is not registered.Please Registered First.";
			}
}catch(Exception ex) {
	
	logger.info("Service : UserProfileRegistrationService || Method : saveUserDetails ||Exception pwd encryption" + ex.getMessage());

//	System.out.print(ex.getMessage());
}
	return response;

}

public String resetPassword(UserLoginDetailModel obj_resetpwd) {
	String response = "not Reset";
	 String encodedPassword="";
	 try {
		 encodedPassword = passwordEncoder.encode(obj_resetpwd.getEmp_password());
		 
		 logger.info("Service : UserLoginService || Method : resetPassword ||NEW Password ");		 
		 String uid=obj_resetpwd.getUser_id();	
			loginDetailObj.updatePassword(encodedPassword, uid);
			response=  "NEW Password" ;	
}catch(Exception ex) {
	
	logger.info("Service : UserLoginService || Method : resetPassword ||Exception pwd encryption" + ex.getMessage());
	response="OLD Password";
//	System.out.print(ex.getMessage());
}
	return response;
	
}
}
