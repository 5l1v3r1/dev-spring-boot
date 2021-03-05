package com.mdms.mdms_coach.coachuncleansed.service;


import java.util.Date;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mdms.mdms_coach.coachuncleansed.model.CoachCleansedData;
import com.mdms.mdms_coach.coachuncleansed.model.CoachDataCMM;
import com.mdms.mdms_coach.coachuncleansed.model.CoachTypeMapping;
import com.mdms.mdms_coach.coachuncleansed.model.CoachUncleansedData;
import com.mdms.mdms_coach.coachuncleansed.repository.CoachCMMDataRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.CoachCleansedDataRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.CoachUncleansedDataRepository;

import com.mdms.mdms_coach.coachuncleansed.model.MDepo;
import com.mdms.mdms_coach.coachuncleansed.repository.MDepoRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.CoachTypeMappingRepository;
@Service
public class CoachEditForwardService {
	@Autowired
	private MDepoRepository mDepoRepo;

	@Autowired
	private CoachCMMDataRepository coach_cmm_repo;
	
	@Autowired
	private CoachUncleansedDataRepository coach_uncleansed_repo;

	@Autowired
	private  CoachCleansedDataRepository coach_cleansed_repo;
	
	@Autowired
	private  CoachTypeMappingRepository coach_map_repo;


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
	

	public String approvedCoachRecords(Long coachid) {
		String returnstmt="";
		int i=0;
		CoachCleansedData temp =new CoachCleansedData ();
		i = coach_uncleansed_repo.approveCoachRecord(coachid);
if(i>0)
{
	     temp= coach_cleansed_repo.getCleanCoachRecord(coachid);
			coach_cleansed_repo.saveCleanRecord(temp.getCoach_no(),temp.getCoach_id(), temp.getCoach_type(),temp.getOwning_rly(),temp.getCoach_owning_div(),
temp.getFitness_type(), temp.getBrake_type(),temp.getTare_weight() 	,temp.getMax_speed(), temp.getCoach_age(),
temp.getManufacturer(),temp.getIs_biotoilet_fitted(), temp.getBuilt_date(),temp.getCommissioning_date(),
temp.getMaintenance_depot(),temp.getNo_of_berths(),temp.getRfid_tag(),
temp.getCoach_status(),temp.getGauge(),temp.getCoupling_type(),temp.getOwning_depot(),temp.getAc_flag(),
temp.getVehicle_type(),temp.getPower_generation_type(),temp.getFactory_turnout_date(),
temp.getCoach_received_date(),temp.getDouble_decker_flag(),	temp.getCoach_capacity(),temp.getCoach_vestibule(),
temp.getUnderframe_no(),temp.getShell_no(),temp.getPu_order_id(), temp.getCoach_type_description(), 
temp.getRecord_status(),temp.getStatus(),temp.getUser_id(),temp.getTxn_date(),temp.getRemarks(),temp.getCoach_category());
	
			returnstmt="RECORD SAVED IN GOLDEN MASTER SUCCESSFULLY";
	
	}

else
	{returnstmt="RECORD NOT SAVED. SOME ERROR OCCURRED";}
		return returnstmt;
	}

	public CoachUncleansedData getCoachDraft(String userid, long coach_id) {
		
	
			return coach_uncleansed_repo.getCoachDraft(userid, coach_id);
		

	}




	public List<MDepo> findByZoneCode(MDepo depo) {
		String zone_code=depo.getZone_code();
		String div_code=depo.getDiv_code();
		System.out.print(zone_code);
		List<MDepo> tmp = new ArrayList<>();
		mDepoRepo.findByZoneCode(zone_code,div_code).forEach(tmp::add);
	    return tmp;
	}
	
	
	

	public int saveCoachType(List<CoachTypeMapping> coachtypemap) {
//		System.out.println(coachtypemap.size());
		int result=1;
	for(int i=0;i<coachtypemap.size();i++)
	{
		
		if(coach_map_repo.save(coachtypemap.get(i))==null)
			{result=0;
			break;
			}
		
		}

		
		return result;
	}


}
