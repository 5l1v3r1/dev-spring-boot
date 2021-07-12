package com.mdms.loco.locouncleansed.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mdms.loco.locouncleansed.model.BoardZonalApproval;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataAddNewLoco;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
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
	public String updateelecbyboardzonaldata(@RequestBody BoardZonalApproval updateElectricLocoBoardZonal) throws JSONException, JsonMappingException, IOException 
	{
		logger.info("----------/updateElectricBoardZonalNewLocoAddtion",updateElectricLocoBoardZonal);
		System.out.println(updateElectricLocoBoardZonal);
		return obj_newlocoservice.updateElectricBoardZonalData(updateElectricLocoBoardZonal);
			}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/checkloconoexist")
	public boolean checklocono(@RequestBody LocoUncleansedDataAddNewLoco objlocono) {
		int locono=objlocono.getLoco_no();
	boolean flag= obj_newlocoservice.checkloconoexist(locono);
	return flag;
	}   

//	@RequestMapping(method=RequestMethod.POST, value="/updateelectricboardzonalloco")
//	public String updateelecbyboardzonaldata(@RequestBody BoardZonalApproval updateElectricLocoBoardZonal) throws JSONException, JsonMappingException, IOException 
//	{
//		logger.info("----------/updateElectricBoardZonalNewLocoAddtion",updateElectricLocoBoardZonal);
//		System.out.println(updateElectricLocoBoardZonal);
//		return obj_newlocoservice.updateElectricBoardZonalData(updateElectricLocoBoardZonal);
//			}
	
	
//	@RequestMapping(method=RequestMethod.POST, value="/checkloconoexist")
//	public boolean checklocono(@RequestBody LocoUncleansedDataAddNewLoco objlocono) {
//		int locono=objlocono.getLoco_no();
//	boolean flag= obj_newlocoservice.checkloconoexist(locono);
//	return flag;
//	}   


	@RequestMapping(method=RequestMethod.POST, value="/updateelectricshedloco")
	public String updateelecbyShed(@RequestBody LocoUncleansedDataElectric updateElectricLocoShedUser) throws JSONException, JsonMappingException, IOException 
	{
		logger.info("----------/updateElectricShedNewLocoAddtion",updateElectricLocoShedUser);
		System.out.println(updateElectricLocoShedUser);
		return obj_newlocoservice.updateElectricShedData(updateElectricLocoShedUser);
			}
	
	@RequestMapping(method=RequestMethod.POST, value="/updatedieselshedloco")
	public String updateelecbyShed(@RequestBody LocoUncleansedDataAddNewLoco updateDieselLocoShedUser) throws JSONException, JsonMappingException, IOException 
	{
		logger.info("----------/updateDieselShedNewLocoAddtion",updateDieselLocoShedUser);
		System.out.println(updateDieselLocoShedUser);
		return obj_newlocoservice.updateDieselShedData(updateDieselLocoShedUser);
			}
	

	 @RequestMapping(method=RequestMethod.POST, value = "/zonalUnapprovedLoco")
 	public List<LocoUncleansedDataAddNewLoco> getZonalUnapprovedLoco(@RequestBody LocoUncleansedDataElectric obj_zonalunapproved){
 		System.out.println("zoneid"+ obj_zonalunapproved.getElec_locoOwningZone());
 		return obj_newlocoservice.getUnapprovedZonalLocos(obj_zonalunapproved);
			
 	}

//	 @RequestMapping(method=RequestMethod.POST, value = "/zonalUnapprovedLoco")
// 	public List<LocoUncleansedDataAddNewLoco> getZonalUnapprovedLoco(@RequestBody LocoUncleansedDataElectric obj_zonalunapproved){
// 		System.out.println("zoneid"+ obj_zonalunapproved.getElec_locoOwningZone());
// 		return obj_newlocoservice.getUnapprovedZonalLocos(obj_zonalunapproved);
//			
// 	}

	 
	 @RequestMapping(method=RequestMethod.POST, value = "/savenewlocogoldenrecord")
 	public String saveNewGoldenRecord(@RequestBody LocoUncleansedDataAddNewLoco obj_newgoldenloco){
 		System.out.println("zoneid"+ obj_newgoldenloco.getLoco_owning_shed());
 		return obj_newlocoservice.savegoldenrecord(obj_newgoldenloco);
			
 	}

	 

	 @RequestMapping(method=RequestMethod.POST, value = "/zonalapprovedLoco")
 	public List<LocoUncleansedDataAddNewLoco> getZonalUnapprovedLoco(@RequestBody LocoUncleansedDataAddNewLoco obj_zonalunapproved){
 		System.out.println("zoneid"+ obj_zonalunapproved.getLoco_owning_zone());
 		return obj_newlocoservice.getApprovedZonalLocos(obj_zonalunapproved);
			
 	}

	
	  @RequestMapping(method=RequestMethod.POST, value = "/getloconumber")
	  public List<Integer> getLocoNumber(@RequestBody LocoUncleansedDataAddNewLoco objnewloco){	  
		 	 
	  return obj_newlocoservice.getLocoNumber(objnewloco.getLoco_owning_shed());
	  }
	 
	
	 
	  @RequestMapping(method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, value = "/getlocodetails")
	   public List<LocoUncleansedDataAddNewLoco> getLocoDetailBasedOnLocoNo(@RequestBody LocoUncleansedDataAddNewLoco locoUncleansedDataAddNewLoco){
		  
		  System.out.println(locoUncleansedDataAddNewLoco.getLoco_no());
		 return obj_newlocoservice.getLocoDetailOnLocoNo(locoUncleansedDataAddNewLoco.getLoco_no());
		 
	 }
	 
	 
	 
}
