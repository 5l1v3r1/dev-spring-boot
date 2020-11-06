package com.mdms.app.mgmt.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
		 String encodedPassword=""; 
		 //Hashing Password first
		 
		 
		 //System.out.print("pwd: "+ obj.getEmp_password());	 
		try {
				 encodedPassword = passwordEncoder.encode(obj.getEmp_password());
					logger.info("Service : UserProfileRegistrationService || Method : saveUserDetails ||");

//System.out.print("Encripted pwd: "+ encodedPassword);
		}catch(Exception ex) {
			
			logger.info("Service : UserProfileRegistrationService || Method : saveUserDetails ||Exception pwd encryption" + ex.getMessage());

		//	System.out.print(ex.getMessage());
		}
		 userLoginDetailObj.setEmp_password(encodedPassword);
		 userLoginDetailObj.setEmail(obj.getEmail());
		 userLoginDetailObj.setRole_type(obj.getRole_type());
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		  
		  
		
		 userLoginDetailObj.setTxn_timestamp(Timestamp.valueOf(formatter.format(new Date())));
		 userLoginDetailObj.setLast_password_change_txn_timestamp(Timestamp.valueOf(formatter.format(new Date())));
	
	
	
	
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
	registrationModelObj.setFrom_date(new Date());
	//registrationModelObj.setTo_date(new Date());
	registrationModelObj.setCreated_by(obj.getName());
	registrationModelObj.setEntity("Entity");
//	String result = null;
	UserLoginDetailModel response = null;
//	try {
//		result= profileRegistrationRepo.saveUser(registrationModelObj.getUser_id(),registrationModelObj.getName(),registrationModelObj.getDesignation(),registrationModelObj.getDepartment()
//			,registrationModelObj.getLoco_type(),registrationModelObj.getShed(),registrationModelObj.getFrom_date()
//			,registrationModelObj.getRole_type(),registrationModelObj.getUser_type(),registrationModelObj.getMobile_no(),registrationModelObj.getEmail(),
//			registrationModelObj.getCreated_by());
//	System.out.print("result:"+result);
//	}catch(Exception ex) {
//	ex.getMessage();
//	if(ex.getMessage().contains("user_profile_registration_detail_pkey")) {
//		return "User Already Exist";
//	}
//	}
	try {
	 UserProfileRegistrationDetailModel result=profileRegistrationRepo.save(registrationModelObj);
	 response=loginDetailRepo.save(userLoginDetailObj);
		logger.info("Service : UserRegistrationService || Method : saveUserDetails ||user_id: "+registrationModelObj.getUser_id());

	//save data in logindetails table
//		if(result!=null) {
//		 response=loginDetailRepo.save(userLoginDetailObj);
//		}
		
		
if(response!=null && result!=null) {
	
	logger.info("Service : UserProfileRegistrationService || Method : saveUserDetails ||Record Inserted Successfully " );

	return "Record Inserted Successfully";
}else {
	logger.info("Service : UserProfileRegistrationService || Method : saveUserDetails ||Record did not insert" );

	return "Record did not insert";
}
	}catch(Exception ex) {
		ex.getMessage();
		
		logger.info("Service : UserProfileRegistrationService || Method : saveUserDetails ||Exception " + ex.getMessage());

		return ex.getMessage();
	}
	
	 }
	 
	 
	 public GetListUserRegistrationJsonModel getListUserRegistration() {
			logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ");
	 
	GetListUserRegistrationJsonModel obj = new GetListUserRegistrationJsonModel();
	String userType="";
	String userRole="";
	String userDepartment=	"";
	String userDesignation=	 "";
	String zones="";
	String divisions="";
			String loco_types="";
	String sheds="";
	
		try {
		
		try {
	 userType=	 loginDetailRepo.getUserTypes();
		}catch(Exception ex) {
			
			logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET USERTYPE" + ex.getMessage());

			ex.getMessage();
		}
		
		try {
	 userRole=	 loginDetailRepo.getUserRoles();
		}catch(Exception ex) {
			logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET USEROLE" + ex.getMessage());

			ex.getMessage();
		}
		
		try {
	 userDepartment=	 loginDetailRepo.getDepartments();
		}catch(Exception ex) {
			logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET Departments" + ex.getMessage());

			ex.getMessage();
		}
		
		
		try {
	 userDesignation=	 loginDetailRepo.getDesignations();
		}catch(Exception ex) {
			logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET Designations" + ex.getMessage());

			ex.getMessage();
		}
	try {
	 zones=	 loginDetailRepo.getZones();
	}catch(Exception ex) {
		ex.getMessage();
		logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET zones" + ex.getMessage());

	}
	
	try {
	 divisions=	 loginDetailRepo.getDivisions();
	}catch(Exception ex) {
		ex.getMessage();
		logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET divisions" + ex.getMessage());

	}
	
	
	try {
	 loco_types=	 loginDetailRepo.getLocoTypes();
	}catch(Exception ex) {
		ex.getMessage();
		logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET locoTypes" + ex.getMessage());

	}
	
	try {
	 sheds=	 loginDetailRepo.getLocoSheds();
	}catch(Exception ex) {
		ex.getMessage();
		logger.info("Service : UserProfileRegistrationService || Method : getListUserRegistration ||Exception GET locoSheds" + ex.getMessage());

	}
	
	
	
	obj.setUser_role_list(userRole);
	obj.setUser_type_list(userType);
	obj.setDepartment_list(userDepartment);
	obj.setDesignation_list(userDesignation);
	obj.setDivision_list(divisions);
	obj.setZone_list(zones);
	obj.setLoco_shed_list(sheds);
	obj.setLoco_type_list(loco_types);	
	
	}catch(Exception ex) {
		
		ex.getMessage();
	}

		 return obj ;
		 
	 }
	 
	 public String findUserRecord(String user_id) {
		 
		 
			logger.info("Service : UserProfileRegistrationService || Method : findUserRecord ||userID " + user_id);

		 List<UserLoginDetailModel>  list= loginDetailRepo.getDeatils(user_id);
// System.out.print("list: "+list.size() +"||User_id: "+user_id);
		 if(list.size()>0) {
			 
				logger.info("Service : UserProfileRegistrationService || Method : findUserRecord ||Response User Already Exist");

			return "User Already Exist"; 
		 }else {
			 
				logger.info("Service : UserProfileRegistrationService || Method : findUserRecord ||Response User not exist");

			 return "User Not Exist";
		 }
		 
		
	 }
}
