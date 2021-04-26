package com.mdms.dashboard.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.dahsboard.model.RbUserCount;
import com.mdms.dahsboard.model.ZonalUsersAssetModel;
import com.mdms.dashboard.service.SuperUserDashboardService;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")

@RestController

public class SuperUserDashboardController {
	Logger logger=LoggerFactory.getLogger(SuperUserDashboardController.class);
	
	@Autowired
	SuperUserDashboardService su_dash_servc;
	
	@RequestMapping(method=RequestMethod.POST, value="/getTotalAsset")
	public HashMap<String,Integer> getTotalAssets(){
		
		logger.info("controller : SuperUserDashboardController || Method : getTotalAssets");
		return su_dash_servc.getTotalAssets();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/regusercount")
	public  ArrayList<HashMap<String,String>> getRegisteredUserCount(){
		
		logger.info("controller : SuperUserDashboardController || Method : getRegisteredUserCount");
		return su_dash_servc.getRegisteredUserCount();
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/assetstats")
	public 	ArrayList<HashMap<String,String>> getAssetRecords() {
		
		logger.info("controller : SuperUserDashboardController || Method : getAssetRecords");
		return su_dash_servc.getAssetRecords();
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/zonewiseusers")
	public 	List<ZonalUsersAssetModel> getZoneWiseUsers(@RequestBody String usertype) {
		
		logger.info("controller : SuperUserDashboardController || Method : getZoneWiseUsers");
		return su_dash_servc.getZoneWiseUsers(usertype);
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/zonewiserec")
	public 	List<ZonalUsersAssetModel> getZoneWiseRecords(@RequestBody String usertype) {
		
		logger.info("controller : SuperUserDashboardController || Method : getZoneWiseRecords");
		return su_dash_servc.getZoneWiseRecords(usertype);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/coachtypemappingcount")
	public 	ArrayList<HashMap<String,String>> getCoachAssetRecords() {
		
		logger.info("controller : SuperUserDashboardController || Method : getCoachAssetRecords");
		return su_dash_servc.getCoachAssetRecords();
		
	}

}
