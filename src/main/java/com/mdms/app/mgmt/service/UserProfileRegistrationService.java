package com.mdms.app.mgmt.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mdms.PasswordSecurityConfiguration;
import com.mdms.app.mgmt.model.GetListUserRegistrationJsonModel;
import com.mdms.app.mgmt.model.UserLoginDetailModel;
import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.app.mgmt.model.UserRegistrationJsonModel;

import com.mdms.app.mgmt.repository.UserLoginDetailRepository;
import com.mdms.app.mgmt.repository.UserProfileRegistrationRepository;

@Service
public class UserProfileRegistrationService {

	
	@Autowired
	private UserLoginDetailRepository loginDetailRepo;
	
	@Autowired
	private UserProfileRegistrationRepository profileRegistrationRepo;
	
	
	 Logger logger=LoggerFactory.getLogger(UserProfileRegistrationService.class);
	 private final PasswordEncoder passwordEncoder = new PasswordSecurityConfiguration().passwordEncoder();
		
	 
	 public String  saveUserDetails(UserRegistrationJsonModel obj) {
		 UserLoginDetailModel userLoginDetailObj=new UserLoginDetailModel();
		 userLoginDetailObj.setUser_id(obj.getUser_id());
		 
		 //Hashing Password first
		 
		
				String encodedPassword = passwordEncoder.encode(obj.getEmp_password());
System.out.print("Encripted pwd: "+ encodedPassword);
		 userLoginDetailObj.setEmp_password(encodedPassword);
		 userLoginDetailObj.setEmail(obj.getEmail());
		 userLoginDetailObj.setRole_type(obj.getRole_type());
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		  
		  
		
		 userLoginDetailObj.setTxn_timestamp(Timestamp.valueOf(formatter.format(new Date())));
		 userLoginDetailObj.setLast_password_change_txn_timestamp(Timestamp.valueOf(formatter.format(new Date())));
	UserLoginDetailModel response=loginDetailRepo.save(userLoginDetailObj);
	
	
	
	//save data in userprofileregistration tbl
	
	
	UserProfileRegistrationDetailModel registrationModelObj= new UserProfileRegistrationDetailModel();
	registrationModelObj.setUser_id(obj.getUser_id());
	registrationModelObj.setUser_type(obj.getUser_type());
	registrationModelObj.setName(obj.getName());
	registrationModelObj.setEmail(obj.getEmail());
	registrationModelObj.setDepartment(obj.getDepartment());
	registrationModelObj.setDesignation(obj.getDesignation());
	registrationModelObj.setLoco_type(obj.getLoco_type());
	registrationModelObj.setMobile_no(obj.getMobile_no());
	registrationModelObj.setRole_type(obj.getRole_type());
	registrationModelObj.setShed(obj.getShed());
	registrationModelObj.setFrom_date(obj.getFrom_date());
	registrationModelObj.setTo_date(obj.getTo_date());
	registrationModelObj.setCreated_by(obj.getName());
	registrationModelObj.setEntity("Entity");
	UserProfileRegistrationDetailModel result=profileRegistrationRepo.save(registrationModelObj);
		logger.info("Service : UserRegistrationService || Method : saveUserDetails ||user_id: "+registrationModelObj.getUser_id());

if(response!=null && result!=null) {
	
}
	return "saved successfully";
	 }
	 
	 
	 public GetListUserRegistrationJsonModel getListUserRegistration() {
		 
	GetListUserRegistrationJsonModel obj = new GetListUserRegistrationJsonModel();
	String userType=	 loginDetailRepo.getUserType();
	String userRole=	 loginDetailRepo.getUserRole();
	String userDepartment=	 loginDetailRepo.getDepartment();
	String userDesignation=	 loginDetailRepo.getDesignation();
	
	
	obj.setUser_role_list(userRole);
	obj.setUser_type_list(userType);
	obj.setDepartment_list(userDepartment);
	obj.setDesignation_list(userDesignation);
	
		 return obj ;
		 
	 }
}
