package com.mdms.app.mgmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.mdms.app.mgmt.model.GetListUserRegistrationJsonModel;
import com.mdms.app.mgmt.model.UserRegistrationJsonModel;
import com.mdms.app.mgmt.service.UserProfileRegistrationService;


@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class UserProfileRegistrationController {

	
	Logger logger=LoggerFactory.getLogger(UserProfileRegistrationController.class);
	
	@Autowired
	UserProfileRegistrationService registrationServiceObj;
	
	@RequestMapping(method=RequestMethod.POST, value="/userregistration")
	public String UserRegistration(@RequestBody UserRegistrationJsonModel userObj){
		
		logger.info("Controller : UserRegistrationController || Method : UserRegistration ||user_id: "+userObj.getUser_id());
	
		String response= registrationServiceObj.saveUserDetails(userObj);
		//code to send otp, on hold because of Api for sending otp
		
		logger.info("Controller : UserRegistrationController || Method : UserRegistration ||user_id: "+userObj.getUser_id());

		return response;
		
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/getlistofitems")
	public GetListUserRegistrationJsonModel getListUserRegistration(){
		
		
		GetListUserRegistrationJsonModel response= registrationServiceObj.getListUserRegistration();
		//code to send otp, on hold because of Api for sending otp
		
		logger.info("Controller : UserRegistrationController || Method : getListUserRegistration ");

		return response;
		
	}
	
}
