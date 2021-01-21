package com.mdms.loco.locouncleansed.controller;




import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.loco.locouncleansed.model.LocoApprovedData;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
import com.mdms.loco.locouncleansed.service.LocoApproveService;

@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class LocoApproveController {
Logger logger=LoggerFactory.getLogger(LocoApproveController.class);
	
	@Autowired
	 private LocoApproveService obj_cleasedservice;
	@RequestMapping(method=RequestMethod.POST,value="/savelocogoldenrecord")
		public boolean adddata(@RequestBody LocoApprovedData objcleansed){		
		boolean flag= obj_cleasedservice.adddata(objcleansed);
				return true;}	
	
	 @RequestMapping(method=RequestMethod.POST, value = "/locogoldenrecords")
 	public List<LocoApprovedData> geteUnapprovedLoco(@RequestBody LocoApprovedData obj_approved){
 		System.out.println("shedid"+ obj_approved.getElec_locoOwningShed());
 		return obj_cleasedservice.getApprovedLocos(obj_approved);
			
 	}
 	

}
