package com.mdms.app.mgmt.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mdms.app.mgmt.model.MasterUserLoginDetail;
import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;


public interface UserProfileRegistrationRepository extends CrudRepository<UserProfileRegistrationDetailModel,String>{
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_id=?1",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserRoleAndType(String user_id);
	
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_id=?1",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserDetail(String user_id);
	
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail ",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserProfiles();
	
	


	@Query(value="SELECT user_id from mdms_app_mgmt.user_profile_registration_detail where division=?1 and designation='DCM'",nativeQuery=true)
	  String getSeniorIdForCMI(String division);
	
	
	@Query(value="SELECT user_id from mdms_app_mgmt.user_profile_registration_detail where division=?1 and designation='DOM'",nativeQuery=true)
	 String getSeniorIdForDTI(String division);

	@Transactional
	@Query(value="INSERT INTO mdms_app_mgmt.user_profile_registration_detail(\r\n" + 
			"user_id, name, designation, department, loco_type, shed, from_date,role_type,user_type,mobile_no,email,created_by)\r\n" + 
			"			VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7,?8,?9,?10,?11,?12)", nativeQuery = true)
	
	String saveUser( String user_id, String name,String designation,String department,String loco_type,
			String shed,Date from_date,String role_type,String user_type,String mobile_no,String email,String created_by);
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_type=?1",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserRecords(String user_type);

	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_id=?1",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserControlRecords(String user_id);
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_id=?1",nativeQuery=true)
	 List<UserProfileRegistrationDetailModel> checkuserexistinregsitration(String user_id);
}
