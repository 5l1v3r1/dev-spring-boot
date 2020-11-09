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


import com.mdms.mdms_station.stationuncleansed.model.MGauge;
import com.mdms.mdms_station.stationuncleansed.model.MGisDetail;
import com.mdms.mdms_station.stationuncleansed.model.MInterlockingStandard;
import com.mdms.mdms_station.stationuncleansed.model.MOperatingStationSignal;
import com.mdms.mdms_station.stationuncleansed.model.MStationCategory;
import com.mdms.mdms_station.stationuncleansed.model.MStationClass;
import com.mdms.mdms_station.stationuncleansed.model.MStationInterchange;
import com.mdms.mdms_station.stationuncleansed.model.MStationJunction;
import com.mdms.mdms_station.stationuncleansed.model.MStationStatus;
import com.mdms.mdms_station.stationuncleansed.model.MTraction;
import com.mdms.mdms_station.stationuncleansed.model.MTrafficType;
import com.mdms.mdms_station.stationuncleansed.service.StationMetaMastersService;

@CrossOrigin(origins = {"http://localhost:4200","http://cris-mdm-angular.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class CoachMetaMastersController {
	
	
	@Autowired
	private StationMetaMastersService stn_meta_serv;
	

	Logger logger=LoggerFactory.getLogger(CoachMetaMastersController.class);
	

//	@RequestMapping(method=RequestMethod.POST, value="/gauge")
//	public List<MGauge> getAllGauge(){
//		return stn_meta_serv.getAllGauge();
//	}
//	
//	
//	@RequestMapping(method=RequestMethod.GET, value="/gis")
//	public List<MGisDetail> getLatLong(@RequestParam("station_code")String station_code){
//		return stn_meta_serv.getLatLong(station_code);
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/interlck")
//	public List<MInterlockingStandard> getInterLock(){
//		return stn_meta_serv.getInterLock();
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
