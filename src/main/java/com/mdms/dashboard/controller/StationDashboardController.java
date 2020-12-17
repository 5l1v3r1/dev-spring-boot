package com.mdms.dashboard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.dahsboard.model.DashboardStationModel;
import com.mdms.dashboard.service.StationDashboardService;


@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class StationDashboardController {
	@Autowired
	private StationDashboardService stationServ_obj;
	
Logger logger=LoggerFactory.getLogger(StationDashboardController.class);

	
	@RequestMapping(method=RequestMethod.POST, value="/getStationStats")
	public HashMap<String,Integer> getStationStats(){
		
		logger.info("controller : StationDashboardController || Method : getStationStats");
		return stationServ_obj.getStationStats();
	}

		List<DashboardStationModel> list =new ArrayList<DashboardStationModel>();
		@RequestMapping(method=RequestMethod.POST, value="/getstationcountdivisionwise")
		public List<DashboardStationModel> getStationCountDivisionWise() {

			
			 list= stationServ_obj.getStationCountDivisionWise();

			
		//	list.forEach((n) -> System.out.println(n.getDivision_code())); 

			logger.info("Controller : DashBoardStationController || Method: getStationCountDivisionWise || getStationCountDivisionWise Query list return : "+list.size());

	return list;

			}
		
		
		

			
//			@Autowired
//			DashBoardStationService dashBoardStationServiceObj;
//			List<DashboardStationModel> list =new ArrayList<DashboardStationModel>();
//			@RequestMapping(method=RequestMethod.POST, value="/getstationcountdivisionwise")
//			public List<DashboardStationModel> getStationCountDivisionWise() {
//
//				
//				 list= dashBoardStationServiceObj.getStationCountDivisionWise();
//
//				
//			//	list.forEach((n) -> System.out.println(n.getDivision_code())); 
//
//				logger.info("Controller : DashBoardStationController || Method: getStationCountDivisionWise || getStationCountDivisionWise Query list return : "+list.size());
//
//		return list;
//
//				}
//			
	
}
