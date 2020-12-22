package com.mdms.mdms_coach.coachuncleansed.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mdms.mdms_coach.coachuncleansed.model.CoachDataCMM;
import com.mdms.mdms_coach.coachuncleansed.model.CoachUncleansedData;
import com.mdms.mdms_coach.coachuncleansed.repository.CoachCMMDataRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.CoachUncleansedDataRepository;



@Service
public class CoachEditForwardService {
	

	@Autowired
	private CoachCMMDataRepository coach_cmm_repo;
	
	@Autowired
	private CoachUncleansedDataRepository coach_uncleansed_repo;

	Logger logger=LoggerFactory.getLogger(CoachEditForwardService.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;



	public boolean editForwardCoach() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<String> getCoachesByDepot() {
		 final String getCoachIdsByDepot = "SELECT count(*) FROM mdms_common_schema.rbs_data_latest";
		return null;

	}




////-------------------------------------------return coachIds for a particular depot--------------------------------------------
//	public List<String> getCoachesByDepot(String depotId) {
//		 final String getCoachIdsByDepot = "SELECT coach_id FROM mdms_coach.coach_data_cmm where base_depot=\'"+depotId+"\'";
//
//=======
//	



//-------------------------------------------return coachIds for a particular depot--------------------------------------------
	public List<String> getCoachesByDepot(String depotId) {
		String depot=depotId.toUpperCase();
		 final String getCoachIdsByDepot = "select coach_id from mdms_coach.coach_data_cmm where base_depot=\'"+depotId+"\'"+" except select cast(coach_id as character varying) from \r\n" + 
		 		"	mdms_coach.coach_uncleansed_data where status in('U','A')";

		    final List<String> coachIds = jdbcTemplate.queryForList(getCoachIdsByDepot, String.class);
		return coachIds;
	}


//-------------------------------------------return coachDetails for a particular coach--------------------------------------------

	public Optional<CoachDataCMM> getCoachByCoachId(String coachId) {
		
		Optional<CoachDataCMM> coachDetails=coach_cmm_repo.findByCoachId(coachId);
		return coachDetails;
	}
	
	
//-------------------------------------------coach Details forwarded/saved as draft after cleaning of record--------------------------------------------
	 @Transactional(rollbackOn = Exception.class)
	public String saveAsDraftCoach(CoachUncleansedData coachUncleansedData)throws Exception {
	Long coachid=coachUncleansedData.getCoach_id();
		String response=null;
		boolean flag;
		flag=coach_uncleansed_repo.findById(coachid).isPresent();
		if(flag)
		{
			String userid=coach_uncleansed_repo.findById(coachid).get().getUser_id();
			if(userid.equals(coachUncleansedData.getUser_id()))
			{
				//update
				Date date = new Date();  
				coachUncleansedData.setTxn_date(date);
					coach_uncleansed_repo.save(coachUncleansedData);
				response="RECORD UPDATED SUCCESSFULLY";
			}
			else
				response="RECORD ALREADY SAVED BY ANOTHER USER";
		}
		else
		{Date date = new Date();  
		coachUncleansedData.setTxn_date(date);
			coach_uncleansed_repo.save(coachUncleansedData);
			response="RECORD SAVED SUCCESSFULLY";
		}
		return response;
	}
	
	
	 @Transactional(rollbackOn = Exception.class)
	
	public String forwardForApprovalCoach(CoachUncleansedData coachUncleansedData) throws Exception{
		Long coachid=coachUncleansedData.getCoach_id();
			String response=null;
			boolean flag;
			flag=coach_uncleansed_repo.findById(coachid).isPresent();
			if(flag)
			{
				String userid=coach_uncleansed_repo.findById(coachid).get().getUser_id();
				if(userid.equals(coachUncleansedData.getUser_id()))
				{
					//update
					Date date = new Date();  
					coachUncleansedData.setTxn_date(date);
						coach_uncleansed_repo.save(coachUncleansedData);
					response="RECORD UPDATED AND FORWARDED FOR APPROVAL SUCCESSFULLY";
				}
				else
					response="TRANSACTION ABORTED.RECORD ALREADY SAVED BY ANOTHER USER";
			}
			else
			{Date date = new Date();  
			coachUncleansedData.setTxn_date(date);
				coach_uncleansed_repo.save(coachUncleansedData);
				response="RECORD FORWARDED FOR APPROVAL SUCCESSFULLY";
			}
			return response;
		}

	public List<CoachUncleansedData> fetchUnapprovedCoachRecords(String depot) {
		
		 return coach_uncleansed_repo .fetchUnapprovedCoachRecords(depot);
	}
	
	


}
