package com.mdms.app.mgmt.repository;

import java.util.Date;
import java.util.List;


import java.util.Optional;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mdms.app.mgmt.model.MasterUserLoginDetail;
import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;
import com.mdms.mdms_masters.model.MDepartment;


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
	

	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND zone=?2 AND division=?3 AND department=?4 AND (from_date between ?5 and ?6)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getCustomizeUserRecords(String utype ,String zone,String division,String department, Date from_to,Date to_date);
	
@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE  user_type=?1 AND (from_date between ?2 and ?3)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getReportdatewise(String utype, Date from_date,Date to_date);

	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND zone=?2 AND shed=?3",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getLocoUserRecordszoneandshedwise(String utype ,String zone,String shed);
	
@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE  user_type=?1 AND zone=?2 AND (from_date between ?3 and ?4)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getReportzonaluserdatewise(String utype, String zone,Date from_date,Date to_date);

@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE  user_type=?1 AND zone=?2 AND division=?3 AND (from_date between ?4 and ?5)",nativeQuery=true)
List<UserProfileRegistrationDetailModel> getReportdivisionuserdatewise(String utype,String zone,String division, Date from_date,Date to_date);
	


	
	@Query(value="SELECT distinct department FROM  mdms_app_mgmt.user_profile_registration_detail", nativeQuery = true)
	List<String> findRegisteredDept(); 
	
	@Query(value="SELECT * FROM mdms_app_mgmt.user_profile_registration_detail WHERE  department=?1 AND user_type=?2 ",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserReportdeprtwise(String department, String utype );
	
	@Query(value="SELECT * FROM mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND department=?2 AND (from_date between ?3 and ?4)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel>userreportdateanddeprtwise(String utype, String department, Date from_to,Date to_date);

	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND division=?2 ",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserReportdivisiontwise(String utype,String division);
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE user_type=?1 AND zone=?2",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserReportzonewise(String utype,String zone);
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where division=?1 and user_type=?2 and(coalesce(department,'')=?3 OR \r\n" + 
			"						coalesce(designation,'')=?4)",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getuserreportsingledivandsingdeprt(String division,String utype,String department,String desig);	

	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail WHERE  zone=?1 AND department=?2 AND user_type=?3 ",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getuserreportsinglezoneandsingledeprt(String zone,String department, String utype);

	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_type=?1 and zone=?2 and division=?3 ",nativeQuery=true)
	List<UserProfileRegistrationDetailModel> getUserReportzoneanddivisiontwise(String utype,String zone,String division);
	
	
//	@Query(value="SELECT  a.*,b.description\n"
//			+ "	FROM mdms_app_mgmt.user_profile_registration_detail as a\n"
//			+ "	join mdms_app_mgmt.m_user_role as b on a.role_type=b.role_type where user_type=?1 and zone=?2 and division=?3\n"
//			+ ""			
//			+ "	 ",nativeQuery=true)
//	List<UserProfileRegistrationDetailModel> getUserReportzoneanddivisiontwise(String utype,String zone,String division);
}
