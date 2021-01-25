package com.mdms.app.mgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.app.mgmt.model.OldUserDetailModel;
import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;

public interface OldUserDetailRepository extends CrudRepository<OldUserDetailModel,Long> {
	

	@Query(value="SELECT * from mdms_app_mgmt.old_user_detail where old_user_id=?1",nativeQuery=true)
	 List<OldUserDetailModel> checkuserexistinoldregsitration(String olduser_id);
}
