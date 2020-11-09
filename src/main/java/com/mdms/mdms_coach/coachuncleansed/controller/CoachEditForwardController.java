/*This controller provides all services for cleansing of coach.
 * Data is first fetched from CMM Master and shown to user on the basis of its depot.
 * User corrects the data and forward it for approving to its approving authority
 * Created By : Firoz, 26-10-2020
 * 
 */


package com.mdms.mdms_coach.coachuncleansed.controller;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> d8cfe9c9310816ed15c1b02a398fb844488bae66

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> d8cfe9c9310816ed15c1b02a398fb844488bae66
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
=======
import com.mdms.mdms_coach.coachuncleansed.model.CoachDataCMM;
import com.mdms.mdms_coach.coachuncleansed.model.CoachUncleansedData;
>>>>>>> d8cfe9c9310816ed15c1b02a398fb844488bae66
import com.mdms.mdms_coach.coachuncleansed.service.CoachEditForwardService;


@RestController
public class CoachEditForwardController {
	@Autowired
	private CoachEditForwardService coachEditFwdServ;
	
	Logger logger=LoggerFactory.getLogger(CoachEditForwardController.class);
	
<<<<<<< HEAD
	@RequestMapping(method=RequestMethod.GET, value="/getCoachesByDepot")
	public List<String> getCoachesByDepot(@RequestParam String depotId) {	
		List<String> coachIds=coachEditFwdServ.getCoachesByDepot();
		logger.info("Controller : CoachEditForwardController || Method: getCoachesByDepot || getCoachForDepot: "+coachIds);
			return coachIds;	
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/editForwardCoach")
	public boolean EditForwardCoach() {
		
		boolean flag=coachEditFwdServ.editForwardCoach();
		
			return flag;	
=======
	
	//-------------------------------------------return coachIds for a particular depot--------------------------------------------
	
	@RequestMapping(method=RequestMethod.GET, value="/getCoachesByDepot")
	public List<String> getCoachesByDepot(@RequestParam String depotId) {	
		
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
	@RequestMapping(method=RequestMethod.POST, value="/editForwardCoach")
	public String EditForwardCoach(@RequestBody CoachUncleansedData coachUncleansedData) {		
		String response=coachEditFwdServ.editForwardCoach(coachUncleansedData);	
			return response;	
>>>>>>> d8cfe9c9310816ed15c1b02a398fb844488bae66
	}
	
}
