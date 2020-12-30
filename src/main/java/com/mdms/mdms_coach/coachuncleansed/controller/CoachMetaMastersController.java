/*This controller provides all Station Meta Masters .
 * Gauge,Gis,Interlocking,Operating_signal,Category,Station Class,Interchange Junction,Status,Traction,Traffic Type
 * Created By : Anshul, 22-10-2020
 * 
 */
package com.mdms.mdms_coach.coachuncleansed.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.mdms.mdms_coach.coachuncleansed.model.MCoachType;
import com.mdms.mdms_coach.coachuncleansed.model.MDepot;
import com.mdms.mdms_coach.coachuncleansed.service.CoachMetaMastersService;

@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")


@RestController
public class CoachMetaMastersController {
	
	
	@Autowired
	private CoachMetaMastersService coach_meta_serv;
	


    Logger logger=LoggerFactory.getLogger(CoachMetaMastersController.class);

	@RequestMapping(method=RequestMethod.GET, value="/coachmaster")
	public MCoachType getCoachTypeDetails(@RequestParam (value="coachtype") String coachtype){
		return coach_meta_serv.getCoachTypeDetails(coachtype);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/coachtype")
	public List<String> getCoachTypes(){
		return coach_meta_serv.getCoachTypes();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/coachtypecmm")
	public List<String> getCoachTypesCmm(){
		return coach_meta_serv.getCoachTypesCmm();
	}
	

	@RequestMapping(method=RequestMethod.POST, value="/coachdepot")
	public List<String> getCoachDepot(){
		return coach_meta_serv.getCoachDepot();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/coachcategory")
	public List<String> getCoachCategory(){
		return coach_meta_serv.getCoachCategory();
	}
		@RequestMapping(method=RequestMethod.POST, value="/coachCouplingTpe")
		public List<String> getCoachCouplingTpe(){
			return coach_meta_serv.getCoachCouplingTpe();
	}
	
		@RequestMapping(method=RequestMethod.POST, value="/fitnesType")
		public List<String> getFitnessType(){
			return coach_meta_serv.getFitnessType();
	}
		@RequestMapping(method=RequestMethod.POST, value="/powerGenType")
		public List<String> getPowerGenType(){
			return coach_meta_serv.getPowerGenType();
	}
		
		@RequestMapping(method=RequestMethod.POST, value="/brakeType")
		public List<String> getBrakeType(){
			return coach_meta_serv.getBrakeType();
	}
		
		
		@RequestMapping(method=RequestMethod.POST, value="/coachtypeprs")
		public List<String> getCoachTypesPrs(){
			return coach_meta_serv.getCoachTypesPrs();
		}
		
//	
//	
//	@RequestMapping(method=RequestMethod.GET, value="/gis")
//	public List<MGisDetail> getLatLong(@RequestParam("station_code")String station_code){
//		return stn_meta_serv.getLatLong(station_code);
//	}

	
	
//	@RequestMapping(method=RequestMethod.POST, value="/depot")
//	public List<String> getDepot(){
//		return coach_meta_serv.getDepot();
//	}


//	
//	@RequestMapping(method=RequestMethod.POST, value="/oprtnsignal")
//	public List<MOperatingStationSignal> getOperatingSignal(){
//		return stn_meta_serv.getOperatingSignal();
//	}
//	
//	
//	@RequestMapping(method=RequestMethod.POST, value="/stnclass")
//	public List<MStationClass> getStationClass(){
//		return stn_meta_serv.getStationClass();
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/interchng")
//	public List<MStationInterchange> getStationInterchange(){
//		return stn_meta_serv.getStationInterchange();
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/junction")
//	public List<MStationJunction> getStationJunction(){
//		return stn_meta_serv.getStationJunction();
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/traction")
//	public List<MTraction> getTraction(){
//		return stn_meta_serv.getTraction();
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/traffictype")
//	public List<MTrafficType> getTraffic(){
//		return stn_meta_serv.getTraffic();
//	}

	




}
