/*This controller provides all services for adding new record in station golden master.
 * Created By : Anshul, 21-10-2020
 * 
 */
package com.mdms.mdms_station.stationuncleansed.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.mdms_station.stationuncleansed.model.StationCleansedData;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedData;
import com.mdms.mdms_station.stationuncleansed.service.StationAddService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class StationAddController {
	@Autowired
	private StationAddService stn_add_serv;
	
	Logger logger=LoggerFactory.getLogger(StationAddController.class);
	
	@RequestMapping(method=RequestMethod.POST, value="/checkstncodeexist")
	public String checkStnCode(@RequestBody String station_code) throws Exception {
		 logger.error("controller : StationAddController || Method : checkStnCode || input recieved checkStnCode: "+station_code);		 
	return stn_add_serv.checkStncodeExit(station_code);	
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/savecmicleanseddraft")
	public  String saveCmiCleansedDraft(@RequestBody StationCleansedData stationdraftcmi) throws Exception
	{	//	System.out.println(stationdraftcmi.getStn_Id().getStation_code());
//		System.out.println(stationdraftcmi.getStn_Id().getStation_valid_from());
//		System.out.println(stationdraftcmi.getStn_Id().getStation_valid_upto());

		logger.error("controller : StationAddController || Method : saveCmiCleansedDraft || input recieved stationdraftcmi: "+stationdraftcmi);	
		return  stn_add_serv.saveCmiCleansedDraft(stationdraftcmi);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/stnclnsunaprvdcmi")
	public  String forwardToDCM(@RequestBody StationCleansedData stationdataapprovebydcm) throws Exception
	{

		logger.error("controller : StationAddController || Method : forwardToDCM || input recieved stationdataapprovebydcm: "+stationdataapprovebydcm.getStn_Id().getStation_code());
		
		return stn_add_serv.forwardToDCM(stationdataapprovebydcm);
	}
	
}
