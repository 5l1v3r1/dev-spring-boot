/*This controller provides all services for cleansing of coach.
 * Data is first fetched from CMM Master and shown to user on the basis of its depot.
 * User corrects the data and forward it for approving to its approving authority
 * Created By : Firoz, 26-10-2020
 * 
 */


package com.mdms.mdms_coach.coachuncleansed.controller;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.mdms_coach.coachuncleansed.model.CoachTypeMapping;
import com.mdms.mdms_coach.coachuncleansed.model.CoachDataCMM;
import com.mdms.mdms_coach.coachuncleansed.model.CoachUncleansedData;
import com.mdms.mdms_coach.coachuncleansed.service.CoachEditForwardService;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedTest;

import com.mdms.mdms_coach.coachuncleansed.model.MDepo;
import com.mdms.mdms_coach.coachuncleansed.service.CoachEditForwardService;

import com.mdms.mdms_masters.model.MDivision;

import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedTest;


@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")



@RestController
public class CoachEditForwardController {
	@Autowired
	private CoachEditForwardService coachEditFwdServ;

	Logger logger=LoggerFactory.getLogger(CoachEditForwardController.class);

	//-------------------------------------------return coachIds for a particular depot--------------------------------------------
	
	@RequestMapping(method=RequestMethod.GET, value="/getCoachesByDepot")
	public List<String> getCoachesByDepot(@RequestParam (value="depotId")String depotId) {	
		
		logger.info("Controller : CoachEditForwardController || Method: getCoachesByDepot || getCoachForDepot: "+depotId);
		List<String> coachIds=coachEditFwdServ.getCoachesByDepot(depotId);
			return coachIds;	
	}
	
	//-------------------------------------------return coachDetails for a particular coach Id--------------------------------------------
	@RequestMapping(method=RequestMethod.GET, value="/getCoachByCoachId")
	public Optional<CoachDataCMM> getCoachByCoachId(@RequestParam String coachId) {	
		Optional<CoachDataCMM> coachDetails=coachEditFwdServ.getCoachByCoachId(coachId);
		logger.info("Controller : CoachEditForwardController || Method: getCoachesByDepot || getCoachDetailsforCoachId: "+coachId);
			return coachDetails;	
	}
	

	//-------------------------------------------coach Details forwarded/saved as draft after cleaning of record--------------------------------------------
	@RequestMapping(method=RequestMethod.POST, value="/unclndraft")
	public String EditForwardCoach(@RequestBody CoachUncleansedData coachUncleansedData) throws Exception {		
		String response=coachEditFwdServ.saveAsDraftCoach(coachUncleansedData);	
			return response;	


	}

	
	//-------------------------------------------coach Details forwarded/saved as draft after cleaning of record--------------------------------------------
		@RequestMapping(method=RequestMethod.GET, value="/unclncoachdraft")
		public CoachUncleansedData getCoachDraft(@RequestParam(value="userid") String userid, @RequestParam(value="coachid") Long coach_id) throws Exception {		
			logger.info("Controller : CoachEditForwardController || Method: getCoachDraft || userid: "+userid);
			CoachUncleansedData response=coachEditFwdServ.getCoachDraft(userid, coach_id);	
				return response;	


		}

	//-------------------------------------------return coach Depo List as per Zone--------------------------------------------

	
	@RequestMapping(method=RequestMethod.POST, value="/depoByZoneCode")
	public List<MDepo> findByZone(@RequestBody MDepo depo) {
		List<MDepo> temp=coachEditFwdServ.findByZoneCode(depo);
		 return coachEditFwdServ.findByZoneCode(depo);  
	
	}    

	
	
	//-------------------------------------------coach Details forwarded after cleaning of record--------------------------------------------
	@RequestMapping(method=RequestMethod.POST, value="/unclnapp")
	public String forwardForApprovalCoach(@RequestBody CoachUncleansedData coachUncleansedData) throws Exception {		
		String response=coachEditFwdServ.forwardForApprovalCoach(coachUncleansedData);	
			return response;	


	}
	
	//-------------------------------------------coach Details pending for approval after cleaning of record-----------------------------------------
	@RequestMapping(method=RequestMethod.POST, value="/unclnsunaprvdcoach")
	public List<CoachUncleansedData> fetchUnapprovedCoachRecords(@RequestParam(value="depot") String depot)
	{
		return coachEditFwdServ.fetchUnapprovedCoachRecords(depot);
	}
	

	@RequestMapping(method=RequestMethod.POST, value="/cochunclapp")
	public String approvedCoachRecords(@RequestBody Long coachid)
	{
		return coachEditFwdServ.approvedCoachRecords(coachid);
	}
	
	
	/* function definition – Map cmm-prs coach types
	Developer – Anshul ,24/06/2020
	*/
	@RequestMapping(method=RequestMethod.POST, value="/coachmap")
	 public int saveCoachType(@RequestBody List<CoachTypeMapping> coachtypemap){
		
		return coachEditFwdServ.saveCoachType(coachtypemap);
	}

	
}
