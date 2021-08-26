package com.mdms.wagon.wagonuncleansed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.wagon.wagonuncleansed.model.MWagonOwningRly;
import com.mdms.wagon.wagonuncleansed.model.WagonUncleansedData;
import com.mdms.wagon.wagonuncleansed.service.MWagonSubMasterService;

@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class MWagonSubMasterController {

	@Autowired
private MWagonSubMasterService obj_wagonsubmaster;
	@RequestMapping(method=RequestMethod.POST, value = "/getWagonOwnRly")
	public List<String> getWagonOwningRlycode()
	{
	obj_wagonsubmaster.getWagonOwningRlycode();
	return obj_wagonsubmaster.getWagonOwningRlycode();
	}
	
	
}
