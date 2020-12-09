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

import com.mdms.mdms_station.stationuncleansed.service.StationAddService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class StationAddController {
	@Autowired
	private StationAddService stn_add_serv;
	
	Logger logger=LoggerFactory.getLogger(StationAddController.class);
	
	@RequestMapping(method=RequestMethod.POST, value="/gldenmstr")
	public String checkIfExists(@RequestBody String station_code) throws Exception {
		 logger.error("controller : StationAddController || Method : checkStnCode || input recieved checkStnCode: "+station_code);		 
	return stn_add_serv.checkIfExists(station_code);	
	}
	
	
	
}
