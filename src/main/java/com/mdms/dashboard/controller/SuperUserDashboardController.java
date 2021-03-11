package com.mdms.dashboard.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
