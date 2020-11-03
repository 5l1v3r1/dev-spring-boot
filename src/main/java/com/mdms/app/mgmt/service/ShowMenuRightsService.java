package com.mdms.app.mgmt.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.app.mgmt.model.UserProfileRegistrationDetailModel;


import com.mdms.app.mgmt.repository.ShowListOfMenuRightsRepository;
import com.mdms.app.mgmt.repository.UserProfileRegistrationRepository;

@Service
public class ShowMenuRightsService {
	
	
	
	@Autowired
	private UserProfileRegistrationRepository profileRepo;
	
	@Autowired
	private ShowListOfMenuRightsRepository menuRightRepo;
	
	
	 Logger logger=LoggerFactory.getLogger(ShowMenuRightsService.class);
	
	
		
	 
	 public List<Integer>  showMenuRights(String user_id) {
	 List<UserProfileRegistrationDetailModel> response=profileRepo.getUserRoleAndType(user_id);
		logger.info("Service : ShowMenuRightsService || Method : showMenuRights,getUserRoleAndType ||user_id: "+user_id+"||roleAndTypeListSize:"+response.size());

	List<Integer> menus_list= menuRightRepo.getMenuRightsList(response.get(0).getRole_type(),response.get(0).getUser_type());
	logger.info("Service : ShowMenuRightsService || Method : showMenuRights ,getMenuRightsList||user_id: "+user_id+"||MenuIdList:"+menus_list.size());

	return menus_list;
	 }

}
