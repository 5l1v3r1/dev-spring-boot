package com.mdms.mdms_coach.coachuncleansed.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mdms.mdms_coach.coachuncleansed.model.CoachDataCMM;
import com.mdms.mdms_coach.coachuncleansed.model.CoachUncleansedData;
import com.mdms.mdms_coach.coachuncleansed.repository.CoachCMMDataRepository;



@Service
public class CoachEditForwardService {
	
	@Autowired
	private CoachCMMDataRepository coachEditForwardRepo;
<<<<<<< HEAD
=======

>>>>>>> ef3574260e9ec6ab5b6df606ebd08b2a510cdcb0
	Logger logger=LoggerFactory.getLogger(CoachEditForwardService.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

<<<<<<< HEAD
	
=======

	public boolean editForwardCoach() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<String> getCoachesByDepot() {
		 final String getCoachIdsByDepot = "SELECT count(*) FROM mdms_common_schema.rbs_data_latest";
		return null;

	}

//-------------------------------------------return coachIds for a particular depot--------------------------------------------
	



////-------------------------------------------return coachIds for a particular depot--------------------------------------------
//	public List<String> getCoachesByDepot(String depotId) {
//		 final String getCoachIdsByDepot = "SELECT coach_id FROM mdms_coach.coach_data_cmm where base_depot=\'"+depotId+"\'";
//
//=======
//	

>>>>>>> ef3574260e9ec6ab5b6df606ebd08b2a510cdcb0
	
//-------------------------------------------return coachIds for a particular depot--------------------------------------------
	public List<String> getCoachesByDepot(String depotId) {
		 final String getCoachIdsByDepot = "SELECT coach_id FROM mdms_coach.coach_data_cmm where base_depot=\'"+depotId+"\'";
<<<<<<< HEAD
=======

>>>>>>> ef3574260e9ec6ab5b6df606ebd08b2a510cdcb0
		    final List<String> coachIds = jdbcTemplate.queryForList(getCoachIdsByDepot, String.class);
		return coachIds;
	}

<<<<<<< HEAD
=======

>>>>>>> ef3574260e9ec6ab5b6df606ebd08b2a510cdcb0
//-------------------------------------------return coachDetails for a particular coach--------------------------------------------

	public Optional<CoachDataCMM> getCoachByCoachId(String coachId) {
		
		Optional<CoachDataCMM> coachDetails=coachEditForwardRepo.findByCoachId(coachId);
		return coachDetails;
	}
	
	
//-------------------------------------------coach Details forwarded/saved as draft after cleaning of record--------------------------------------------
	
	public String editForwardCoach(CoachUncleansedData coachUncleansedData) {
		// TODO Auto-generated method stub
		String response="sff";
		return response;
	}


}
