/*This controller provides all services for cleansing of coach.
 * Data is first fetched from CMM Master and shown to user on the basis of its depot.
 * User corrects the data and forward it for approving to its approving authority
 * Created By : Firoz, 26-10-2020
 * 
 */


package com.mdms.mdms_coach.coachuncleansed.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.mdms_coach.coachuncleansed.service.CoachEditForwardService;


@RestController
public class CoachEditForwardController {
	@Autowired
	private CoachEditForwardService coachEditFwdServ;
	
	Logger logger=LoggerFactory.getLogger(CoachEditForwardController.class);
	
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
	}
	
}
