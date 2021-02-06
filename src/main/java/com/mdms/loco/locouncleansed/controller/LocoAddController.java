package com.mdms.loco.locouncleansed.controller;

import java.io.IOException;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataAddNewLoco;
import com.mdms.loco.locouncleansed.service.LocoAddService;


@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class LocoAddController {
	Logger logger=LoggerFactory.getLogger(LocoAddController.class);
	
	@Autowired
	 private LocoAddService obj_newlocoservice;

	@RequestMapping(method=RequestMethod.POST, value="/savedieselboardzonalloco")
	public String savedslnewloco(@RequestBody LocoUncleansedDataAddNewLoco dieselLocoBoardZonal) throws JSONException, JsonMappingException, IOException 
	{
		logger.info("----------/saveDieselBoardZonalNewLocoAddtion",dieselLocoBoardZonal);
		System.out.println(dieselLocoBoardZonal);
		return obj_newlocoservice.saveDieselBoardZonalData(dieselLocoBoardZonal);
			}
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/updatedieselboardzonalloco")
	public String updatedsllocobyboardzonaldata(@RequestBody LocoUncleansedDataAddNewLoco updatedieselLocoBoardZonal) throws JSONException, JsonMappingException, IOException 
	{
		logger.info("----------/updateDieselBoardZonalNewLocoAddtion",updatedieselLocoBoardZonal);
		System.out.println(updatedieselLocoBoardZonal);
		return obj_newlocoservice.updateDieselBoardZonalData(updatedieselLocoBoardZonal);
			}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/saveelectricboardzonalloco")
	public String saveelecnewloco(@RequestBody LocoUncleansedDataAddNewLoco dieselLocoBoardZonal) throws JSONException, JsonMappingException, IOException 
	{
		logger.info("----------/saveElectricBoardZonalNewLocoAddtion",dieselLocoBoardZonal);
		System.out.println(dieselLocoBoardZonal);
		return obj_newlocoservice.saveDieselBoardZonalData(dieselLocoBoardZonal);
			}
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/updateelectricboardzonalloco")
	public String updateelecbyboardzonaldata(@RequestBody LocoUncleansedDataAddNewLoco updateElectricLocoBoardZonal) throws JSONException, JsonMappingException, IOException 
	{
		logger.info("----------/updateElectricBoardZonalNewLocoAddtion",updateElectricLocoBoardZonal);
		System.out.println(updateElectricLocoBoardZonal);
		return obj_newlocoservice.updateElectricBoardZonalData(updateElectricLocoBoardZonal);
			}
	

}
