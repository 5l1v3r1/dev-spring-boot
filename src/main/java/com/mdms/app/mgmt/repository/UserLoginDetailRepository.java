package com.mdms.app.mgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mdms.app.mgmt.model.UserLoginDetailModel;


public interface UserLoginDetailRepository extends CrudRepository<UserLoginDetailModel,String>{
	
	@Query(value="SELECT * from mdms_app_mgmt.user_login_detail where user_id=?1",nativeQuery=true)
	  List<UserLoginDetailModel> getDeatils(String userId);
	
	


	@Procedure(value="mdms_app_mgmt.f_get_user_type_list")
	String getUserTypes();

	

	@Procedure(value="mdms_app_mgmt.f_get_user_role_list")
	String getUserRoles();

	

	@Procedure(value="mdms_masters.f_get_departments_list")
	String getDepartments();

	

	@Procedure(value="mdms_masters.f_get_designation_list")
	String getDesignations();

	
	@Procedure(value="mdms_masters.f_get_zone_list")
	String getZones();

	
	@Procedure(value="mdms_masters.f_get_division_list")
	String getDivisions();

	
	@Procedure(value="mdms_loco.f_get_loco_type_list")
	String getLocoTypes();

	
	@Procedure(value="mdms_loco.f_get_loco_shed_list")
	String getLocoSheds();

	
}

