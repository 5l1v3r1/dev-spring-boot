/*This controller provides all Station Meta Masters .
 * Gauge,Gis,Interlocking,Operating_signal,Category,Station Class,Interchange Junction,Status,Traction,Traffic Type
 * Created By : Anshul, 22-10-2020
 * 
 */
package com.mdms.mdms_coach.coachuncleansed.controller;

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

import com.mdms.mdms_coach.coachuncleansed.model.CMMTypeLayout;

import com.mdms.mdms_coach.coachuncleansed.model.MCoachType;

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
	
	
	@RequestMapping(method=RequestMethod.POST, value="/cmmtypelayout")
	public List<String> getCoachTypesCmmLayout(){
		return coach_meta_serv.getCoachTypesCmmLayout();
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
		
		
		@RequestMapping(method=RequestMethod.POST, value="/sendlayouttypes")
		public List<CMMTypeLayout> getUnappCMMLayout(){
			return coach_meta_serv.getUnappCMMLayout();
		}
		
		
		@RequestMapping(method=RequestMethod.POST, value="/appcmmlayout")
		public String approveCmmCoachLayout(@RequestBody String cmmcoachtype){
			return coach_meta_serv.approveCmmCoachLayout(cmmcoachtype);
		}
		


}
