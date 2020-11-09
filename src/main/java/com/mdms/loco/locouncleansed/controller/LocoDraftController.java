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


import com.mdms.loco.locouncleansed.model.LocoUncleansedData;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
import com.mdms.loco.locouncleansed.service.LocoDraftService;
@CrossOrigin(origins = {"http://localhost:4200","http://cris-mdm-angular.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class LocoDraftController {
Logger logger=LoggerFactory.getLogger(LocoDraftController.class);
	
	@Autowired
	 private LocoDraftService obj_uncleasedservice;
	
	
	//add eloco cleansed data in loco unclenased data table
	 
 	@RequestMapping(method=RequestMethod.POST, value="/addelectricdata")
 		public boolean adddata(@RequestBody LocoUncleansedDataElectric obj_electricclass) {
 		System.out.println("type"+obj_electricclass.getElec_locoType());
 		System.out.println("locono" + obj_electricclass.getElec_locoNo()); 		
 		boolean flag= obj_uncleasedservice.adddata(obj_electricclass);
 				return flag;		 		}
 	
 	
 	//add cleansed Diesel Loco data in loco unclenased data table
	 
 	@RequestMapping(method=RequestMethod.POST, value="/adddieselcleanseddata")
 		public boolean adddata(@RequestBody LocoUncleansedData dsluncleansed) {
 		System.out.println("saving dloco data ");
 		boolean flag= obj_uncleasedservice.adddata(dsluncleansed);
 				return flag;		 		}
 	
 	
 	@RequestMapping(method=RequestMethod.POST, value = "/cleansedDraftLocoService")
	public List<LocoUncleansedDataElectric> getDraftLoco(@RequestBody LocoUncleansedDataElectric objdraft ){
		System.out.println("shedid"+ objdraft.getElec_locoNo());
    return obj_uncleasedservice.getDraftLocos(objdraft);	
	}

 	
 	//delete draft loco from uncleansed table 
 	@RequestMapping(method=RequestMethod.POST, value="/deletedraftloco")
 	public boolean deletedraftloco(@RequestBody LocoUncleansedDataElectric obj_electricclass) {
 		boolean flag=obj_uncleasedservice.deletedraftloco(obj_electricclass);
 			return flag;
 	}
	
 	//update record - Electric Draft
 	@RequestMapping(method=RequestMethod.POST, value ="/updateEDraftService")
 	public boolean update_edraft(@RequestBody LocoUncleansedDataElectric obj_electricclass)
 	{
 		System.out.println("status"+ obj_electricclass.getElec_Status());
 		System.out.println("remarks"+ obj_electricclass.getElec_Remarks());
 		System.out.println("locono"+ obj_electricclass.getElec_locoNo());	
 		System.out.println("flagtype"+ obj_electricclass.getFlagType());
 		System.out.println("isgps"+ obj_electricclass.getIsGPSEnabled()); 		
 	boolean flag = obj_uncleasedservice.updaterecord(obj_electricclass);
 	return flag;
 	}
 	//update record - Diesel Draft Record
 		@RequestMapping(method=RequestMethod.POST, value ="/updateDDraftService")
 		public boolean update_ddraft(@RequestBody LocoUncleansedData obj_dieseldraft)
 		{
 			System.out.println("status"+ obj_dieseldraft.getvStatus());
 			System.out.println("gps"+ obj_dieseldraft.getIsGPSEnabledDiesel());
 			System.out.println("flagtype"+ obj_dieseldraft.getFlagTypeDiesel());
 			System.out.println("remarks"+ obj_dieseldraft.getdRemarks());
 			System.out.println("locono"+ obj_dieseldraft.getLoco_No());	
 		boolean flag = obj_uncleasedservice.updatediseldraftrecord(obj_dieseldraft);
 		return flag;
 		}
	

}
