/*This controller provides all services for cleansing of station.
 * Data is first fetched from RBS Master and shown to user on the basis of its division.
 * User corrects the input forward for approving to its approving authority
 * Created By : Anshul, 21-10-2020
 * 
 */
package com.mdms.mdms_station.stationuncleansed.controller;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.mdms_station.stationuncleansed.model.StationTableRbs;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedData;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedTest;
import com.mdms.mdms_station.stationuncleansed.service.StationEditForwardService;



@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class StationEditForwardController {
	
	@Autowired
	private StationEditForwardService stn_edit_fwd_serv;
	
	Logger logger=LoggerFactory.getLogger(StationEditForwardController.class);
	
	@RequestMapping(method=RequestMethod.GET, value="/tblrbs")
	public List<String> getDivisionalStnCodeCmi(@RequestParam(value="division") String division){
		return stn_edit_fwd_serv.getDivisionalStnCodeCmi(division);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/stncoderbs")
	public  StationTableRbs getStationRecordRBS(@RequestParam(value="station_code") String station_code) throws Exception
	{
		return stn_edit_fwd_serv.getStationRecordRBS(station_code);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/stncodeunclnsd")
	public  StationUncleansedData getDraftFromUncleansedCmi(@RequestParam(value="useridcmi") String useridcmi , @RequestParam(value="station_code") String station_code ) throws Exception
	{
		
		return stn_edit_fwd_serv.getDraftFromUncleansedCmi(useridcmi,station_code);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/unclnsdcmidraft")
	public  String saveCmiDraft(@RequestBody StationUncleansedData stationdraftcmi) throws Exception
	{
//		System.out.println(stationdraftcmi.getStn_Id().getStation_code());
//		System.out.println(stationdraftcmi.getStn_Id().getStation_valid_from());
//		System.out.println(stationdraftcmi.getStn_Id().getStation_valid_upto());
		logger.error("controller : StationEditForwardController || Method : saveCmiDraft || input recieved stationdraftcmi: "+stationdraftcmi.getStn_Id().getStation_code());
		
		return stn_edit_fwd_serv.saveCmiDraft(stationdraftcmi);
	}
	

	
	@RequestMapping(method=RequestMethod.POST, value="/stnunclnsunaprvdcmi")
	public  String forwardToDcm(@RequestBody StationUncleansedData stationdatadcm) throws Exception
	{

		logger.error("controller : StationEditForwardController || Method : forwardToDcm || input recieved stationdatadcm: "+stationdatadcm.getStn_Id().getStation_code());
		
		return stn_edit_fwd_serv.forwardToDcm(stationdatadcm);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/stnunclnsunaprvdcm")
	public List<StationUncleansedData> fetchUnapprovedCmiRecords(@RequestParam(value="division_code") String division_code)
	{
		return stn_edit_fwd_serv.fetchUnapprovedCmiRecords(division_code);
	}
	

	
	
	@RequestMapping(method=RequestMethod.POST, value="/stnunclnsunaprvdcm1")
	public List<StationUncleansedTest> fetchUnapprovedCmiRecords1(@RequestParam(value="division_code") String division_code)
	{
		return stn_edit_fwd_serv.fetchUnapprovedCmiRecords1(division_code);
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/stnunclappdcm")
	public  String approvedByDcm(@RequestBody String stationdatadcm) throws Exception
	{

		logger.error("controller : StationEditForwardController || Method : forwardToDcm || input recieved approvedByDcm: "+stationdatadcm);
		
		return stn_edit_fwd_serv.approvedByDcm(stationdatadcm);
		
		
	}
}


