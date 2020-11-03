package com.mdms.app.mgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;


public interface UserProfileRegistrationRepository extends CrudRepository<UserProfileRegistrationDetailModel,String>{
	
	@Query(value="SELECT * from mdms_app_mgmt.user_profile_registration_detail where user_id=?1",nativeQuery=true)
	  List<UserProfileRegistrationDetailModel> getUserRoleAndType(String user_id);

}
