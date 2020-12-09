package com.mdms.app.mgmt.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mdms.app.mgmt.model.LoginOtpModel;
import com.mdms.app.mgmt.model.MenuIdResponseModel;

import com.mdms.app.mgmt.model.UserLoginDetailModel;

import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.app.mgmt.service.LoginOtpService;
import com.mdms.app.mgmt.service.ShowMenuRightsService;
import com.mdms.app.mgmt.service.UserLoginService;
import com.mdms.app.mgmt.service.UserProfileRegistrationService;



//import com.mdms.app.mgmt.service.LoginOtpService;
//import com.mdms.app.mgmt.service.ShowMenuRightsService;
//import com.mdms.app.mgmt.service.UserLoginService;


//@CrossOrigin(origins = {"http://localhost:4200","http://cris-mdm-angular.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")




import com.mdms.app.mgmt.service.LoginOtpService;
import com.mdms.app.mgmt.service.ShowMenuRightsService;
import com.mdms.app.mgmt.service.UserLoginService;




import com.mdms.app.mgmt.service.LoginOtpService;
import com.mdms.app.mgmt.service.ShowMenuRightsService;
import com.mdms.app.mgmt.service.UserLoginService;

@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class UserLoginController {
	
	@Autowired
	private UserLoginService userLoginService;
	
	
	@Autowired
	private ShowMenuRightsService menuRightService;
	

	@Autowired
	UserProfileRegistrationService profileRegistrationService;
	


	Logger logger=LoggerFactory.getLogger(UserLoginController.class);

	@RequestMapping(method=RequestMethod.POST, value="/userlogin")
	public MenuIdResponseModel userLogin(@RequestParam("user_id") String user_id,@RequestParam("password") String password){
		
		
		MenuIdResponseModel obj=new MenuIdResponseModel();
		logger.info("Controller : UserLoginController || Method : userLogin || user_id: "+user_id +" ||password: " +password);
		List<String> response= new ArrayList<String>();
	
		try {
		String 	result=userLoginService.verifyLogin(user_id,password);
		
		
	if(result.equalsIgnoreCase("success")) {
		
		
		 response= menuRightService.showMenuRights(user_id);
	String user_type=	 menuRightService.getUserType(user_id);
	UserProfileRegistrationDetailModel registrationObj=profileRegistrationService.getUserDetail(user_id);
	System.out.println("username"+registrationObj.getUname());
	obj.setDivision(registrationObj.getDivision());
	obj.setDesignation(registrationObj.getDesignation());
obj.setUser_role(registrationObj.getRole_type());
obj.setUname(registrationObj.getUname());
obj.setZone(registrationObj.getZone());
obj.setUser_id(user_id);

obj.setSenior_id(profileRegistrationService.seniorID(registrationObj.getDesignation(), registrationObj.getDivision()));

	
	obj.setUser_type(user_type);
		if(response.size()>0)
		{
		
		obj.setMenuid_list(response);
		obj.setStatus("success");
		obj.setMessage("credentials are correct");
		
		
		 logger.info("Controller : UserLoginController || Method : userLogin ||showMenuRights:user_id "+user_id +" ||menuId list size"+ response.size() +"|| credentails are right");

		}else {
			
			
			obj.setMenuid_list(response);
			obj.setStatus("success");
			obj.setMessage("no menu rights for this user");
			 logger.info("Controller : UserLoginController || Method : userLogin ||showMenuRights:user_id "+user_id +" ||no menu rights");

		}
		

	}else {
		
		obj.setMenuid_list(response);
		obj.setStatus("failed");
		obj.setMessage(result);
		 logger.info("Controller : UserLoginController || Method : userLogin ||showMenuRights:user_id "+user_id +" ||credentials are wrong");

		
	}
		}catch(Exception ex) {
			ex.getMessage();
			 logger.info("Controller : UserLoginController || Method : userLogin ||showMenuRights:user_id "+user_id +" || Exception "+ex.getMessage());
		
		}
	
	
		return obj;
		
		
		
		
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value ="/resetpassword")
	public String resetpassword(@RequestBody UserLoginDetailModel obj_resetpwd)
	{
		logger.info("Controller : UserLoginController || Method : resetpassword || password:" +obj_resetpwd.getEmp_password() +" || user_id: "+obj_resetpwd.getUser_id()+"" );
		System.out.println("pwd"+ obj_resetpwd.getEmp_password());
		System.out.println("id"+ obj_resetpwd.getUser_id());	
	String flag = userLoginService.resetPassword(obj_resetpwd);
	return flag;
	}
 
	

}
