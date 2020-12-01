/*This service provides all services for cleansing of station.
 * Data is first fetched from RBS Master and shown to user on the basis of its division.
 * User corrects the input forward for approving to its approving authority
 * Created By : Anshul, 21-10-2020
 * 
 */

package com.mdms.mdms_station.stationuncleansed.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.SimpleDateFormat;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.mdms_station.stationuncleansed.repository.StationCleansedDataRepository;
import com.mdms.mdms_station.stationuncleansed.repository.StationTableRbsRepository;
import com.mdms.mdms_station.stationuncleansed.repository.StationUncleansedDataRepository;
import com.mdms.mdms_station.stationuncleansed.repository.StationUncleansedTestRepository;
import com.mdms.mdms_masters.repository.MDivisionRepository;
import com.mdms.mdms_station.stationuncleansed.model.StationCleansedData;
import com.mdms.mdms_station.stationuncleansed.model.StationTableRbs;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedData;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedTest;


@Service
public class StationEditForwardService {
	@Autowired
	StationUncleansedDataRepository stn_unclsnd_repo;
	
	@Autowired
	StationTableRbsRepository stn_tbl_rbs_repo;
	
	@Autowired 
	MDivisionRepository divsn_repo;
	
@Autowired
	
	StationCleansedDataRepository stn_clnsd_repo;
	
	@Autowired
	
	StationUncleansedTestRepository stn_uncl_repo;
	
/*
 
 */
	
	public List<String> getDivisionalStnCodeCmi(String division){
		
		int divno=	divsn_repo.getDivsionCode(division);
			
		return stn_tbl_rbs_repo.getDivisionalStnCodeCmi(divno);
	}
	
	
	public List<String> getDivisionalStnCodeDti(String division) {
		int divno=	divsn_repo.getDivsionCode(division);
		
		return stn_tbl_rbs_repo.getDivisionalStnCodeDti(divno);
	} 
	
	
	 @Transactional(rollbackOn = Exception.class)
	public StationTableRbs getStationRecordRBS(String station_code) throws Exception
	{
		return stn_tbl_rbs_repo.getStationRecordRBS(station_code);
	}
	 
	 
	 public StationUncleansedData getDraftFromUncleansedCmi(String useridcmi, String station_code) throws Exception
		{
			return stn_unclsnd_repo.getDraftFromUncleansedCmi(useridcmi,station_code);
		}
	 
	 
	 public StationUncleansedData getDraftFromUncleansedDti(String useriddti, String station_code) throws Exception
		{
			return stn_unclsnd_repo.getDraftFromUncleansedDti(useriddti,station_code);
		}

	
	 @Transactional(rollbackOn = Exception.class)
	 public String saveCmiDraft(StationUncleansedData stationdraftcmi)throws Exception {
		
		boolean ispresent;
		String returnstmt="";
		try {
		ispresent=stn_unclsnd_repo.findById(stationdraftcmi.getStn_Id()).isPresent();//Check if record is already present
		// If record is already present their are two cases:
		
		if(ispresent)
		{
//1.that record is already saved as draft 
			
			String status=stn_unclsnd_repo.findById(stationdraftcmi.getStn_Id()).get().getCmi_status();
			String useridcmi=stn_unclsnd_repo.findById(stationdraftcmi.getStn_Id()).get().getUser_id_cmi();
			
			if(status.equals("D"))
				
			{//by the same user.
				if(useridcmi.equals(stationdraftcmi.getUser_id_cmi()))
				{
					//if this is the same user
					String cmi_station_code=stationdraftcmi.getStn_Id().getStation_code();
					Date cmi_valid_from=stationdraftcmi.getStn_Id().getStation_valid_from();
					Date cmi_valid_upto=stationdraftcmi.getStn_Id().getStation_valid_upto();
					String userid=stationdraftcmi.getUser_id_cmi();
					  Date date = new Date();  
				stn_unclsnd_repo.updateDraftCmi( userid,  cmi_station_code ,  cmi_valid_from ,  cmi_valid_upto , stationdraftcmi.getStation_numeric_code(),
						stationdraftcmi.getStation_name(),	stationdraftcmi.getTraffic_type(),stationdraftcmi.getTranshipment_flag() ,
						stationdraftcmi.getStation_class() ,stationdraftcmi.getJunction_flag(), stationdraftcmi.getInterchange_flag() , 
						stationdraftcmi.getState(), stationdraftcmi.getPincode() , stationdraftcmi.getDistrict(),stationdraftcmi.getTehsil(), 
						stationdraftcmi.getStation_short_name(), stationdraftcmi.getInterlocking_standard() , stationdraftcmi.getWorking_division(),
						stationdraftcmi.getWeight_bridge(), stationdraftcmi.getSiding() , stationdraftcmi.getBooking_type() , stationdraftcmi.getCmi_status(), date ,stationdraftcmi.getBooking_resource()  );
				returnstmt="DRAFT UPDATED SUCCESSFULLY";	
				
				}
				
				//2.that record is already saved as draft by the OTHER user.
				else
					returnstmt="TRANSACTION ABORTED . THIS DRAFT IS ALREADY SAVED BY OTHER USER.";
				
			}
			
		else if(status.equals("N"))
			{
				// 3. this record is already initiated by dti. so update attributes but reply message as draft created
	     		String cmi_station_code=stationdraftcmi.getStn_Id().getStation_code();
				Date cmi_valid_from=stationdraftcmi.getStn_Id().getStation_valid_from();
				Date cmi_valid_upto=stationdraftcmi.getStn_Id().getStation_valid_upto();
				String userid=stationdraftcmi.getUser_id_cmi();
				  Date date = new Date();  
			stn_unclsnd_repo.updateDraftCmiDti( userid,  cmi_station_code ,  cmi_valid_from ,  cmi_valid_upto , stationdraftcmi.getStation_numeric_code(),
					stationdraftcmi.getStation_name(),	stationdraftcmi.getTraffic_type(),stationdraftcmi.getTranshipment_flag() ,
					stationdraftcmi.getStation_class() ,stationdraftcmi.getJunction_flag(), stationdraftcmi.getInterchange_flag() , 
					stationdraftcmi.getState(), stationdraftcmi.getPincode() , stationdraftcmi.getDistrict(),stationdraftcmi.getTehsil(), 
					stationdraftcmi.getStation_short_name(), stationdraftcmi.getInterlocking_standard() , stationdraftcmi.getWorking_division(),
					stationdraftcmi.getWeight_bridge(), stationdraftcmi.getSiding() , stationdraftcmi.getBooking_type() , stationdraftcmi.getCmi_status(), date ,stationdraftcmi.getBooking_resource() );
			returnstmt="DRAFT CREATED SUCCESSFULLY";	
			}
			
		else returnstmt="INVALID TRANSACTION";	
		}
		
		else
		{
//			 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			    Date date = new Date();  
			  
			stationdraftcmi.setTxn_date_cmi(date);
			
			stn_unclsnd_repo.save(stationdraftcmi);
			
			returnstmt="DRAFT CREATED SUCCESSFULLY";	
			
		}
	
	return returnstmt;
		}catch(Exception e)
		{
			return "EXCEPTION OCCURRED!!!";
		}
	}
	
	 

	 @Transactional(rollbackOn = Exception.class)
	 public String forwardToDcm(StationUncleansedData stationdatadcm) throws Exception{
		 
		 boolean ispresent;
			String returnstmt="";
			try {
			ispresent=stn_unclsnd_repo.findById(stationdatadcm.getStn_Id()).isPresent();
			
			if(ispresent)
			{String status=stn_unclsnd_repo.findById(stationdatadcm.getStn_Id()).get().getCmi_status();
				if(status.equals("D")) {
				String cmi_station_code=stationdatadcm.getStn_Id().getStation_code();
				Date cmi_valid_from=stationdatadcm.getStn_Id().getStation_valid_from();
				Date cmi_valid_upto=stationdatadcm.getStn_Id().getStation_valid_upto();
				String userid=stationdatadcm.getUser_id_cmi();
				String station_status="U";
				  Date date = new Date();  
			stn_unclsnd_repo.updateDraftCmi( userid,  cmi_station_code ,  cmi_valid_from ,  cmi_valid_upto , stationdatadcm.getStation_numeric_code(),
					stationdatadcm.getStation_name(),	stationdatadcm.getTraffic_type(),stationdatadcm.getTranshipment_flag() ,
					stationdatadcm.getStation_class() ,stationdatadcm.getJunction_flag(), stationdatadcm.getInterchange_flag() , 
					stationdatadcm.getState(), stationdatadcm.getPincode() , stationdatadcm.getDistrict(),stationdatadcm.getTehsil(), 
					stationdatadcm.getStation_short_name(), stationdatadcm.getInterlocking_standard() , stationdatadcm.getWorking_division(),
					stationdatadcm.getWeight_bridge(), stationdatadcm.getSiding() , stationdatadcm.getBooking_type() , station_status, date ,stationdatadcm.getBooking_resource());
			returnstmt="RECORD FORWARDED TO DCM SUCCESSFULLY";
				}
				
				else if(status.equals("N"))
				{	String station_status="U";
					// 3. this record is already initiated by dti. so update attributes but reply message as draft created
		     		String cmi_station_code=stationdatadcm.getStn_Id().getStation_code();
					Date cmi_valid_from=stationdatadcm.getStn_Id().getStation_valid_from();
					Date cmi_valid_upto=stationdatadcm.getStn_Id().getStation_valid_upto();
					String userid=stationdatadcm.getUser_id_cmi();
					  Date date = new Date();  
				stn_unclsnd_repo.updateDraftCmiDti( userid,  cmi_station_code ,  cmi_valid_from ,  cmi_valid_upto , stationdatadcm.getStation_numeric_code(),
						stationdatadcm.getStation_name(),	stationdatadcm.getTraffic_type(),stationdatadcm.getTranshipment_flag() ,
						stationdatadcm.getStation_class() ,stationdatadcm.getJunction_flag(), stationdatadcm.getInterchange_flag() , 
						stationdatadcm.getState(), stationdatadcm.getPincode() , stationdatadcm.getDistrict(),stationdatadcm.getTehsil(), 
						stationdatadcm.getStation_short_name(), stationdatadcm.getInterlocking_standard() , stationdatadcm.getWorking_division(),
						stationdatadcm.getWeight_bridge(), stationdatadcm.getSiding() , stationdatadcm.getBooking_type() , station_status, date ,stationdatadcm.getBooking_resource() );
				returnstmt="RECORD FORWARDED TO DCM SUCCESSFULLY";	
				}
				
				
				
			}
			else
			{
				
				   Date date = new Date();  
					  
				   stationdatadcm.setTxn_date_cmi(date);
					
					stn_unclsnd_repo.save(stationdatadcm);
					
					returnstmt="RECORD FORWARDED TO DCM SUCCESSFULLY";	
				
			}
			
			
			
	 
	 return returnstmt;
			}catch(Exception e)
			{
				return "Exception Occurred!!!";
				
			}
	 }
	 
	 
	 public List<StationUncleansedData> fetchUnapprovedCmiRecords(String division_code) {
		 
	return	 stn_unclsnd_repo.fetchUnapprovedCmiRecords(division_code);
		 
	 }
	 
	 
	 public List<StationUncleansedTest> fetchUnapprovedCmiRecords1(String division_code) {
		 
			return	 stn_uncl_repo.fetchUnapprovedCmiRecords1(division_code);
				 
			 }

	 
	 @Transactional(rollbackOn = Exception.class)
	public String approvedByDcm(String stationdatadcm) throws Exception {
String returnstmt=null;
try {
		int i= stn_unclsnd_repo.approvedByDcm(stationdatadcm);
//				stationdatadcm.getStn_Id().getStation_valid_from(),stationdatadcm.getStn_Id().getStation_valid_upto());
if(i>0)
{
	StationCleansedData stncldata=stn_clnsd_repo.findByStncode(stationdatadcm);
	if(stncldata.getDti_status().equals('A'))
		{stn_clnsd_repo.save(stncldata);
			returnstmt="RECORD APPROVED SUCCESSFULLY AND ADDED TO GOLDEN MASTER";}
	else
			returnstmt="RECORD APPROVED SUCCESSFULLY";

}	else
	returnstmt="RECORD NOT APPROVED. CONTACT THE ADMINISTRATOR";
	return returnstmt; 
	
}catch(Exception e)
{
	return "Exception Occurred !!!";}}
	
	
	
	public String approvedByDom(String stationdatadcm) {
String returnstmt=null;
try {
		int i= stn_unclsnd_repo.approvedByDom(stationdatadcm);
//				stationdatadcm.getStn_Id().getStation_valid_from(),stationdatadcm.getStn_Id().getStation_valid_upto());
if(i>0)
{
	StationCleansedData stncldata=stn_clnsd_repo.findByStncode(stationdatadcm);
	if(stncldata.getCmi_status().equals('A'))
		{stn_clnsd_repo.save(stncldata);
			returnstmt="RECORD APPROVED SUCCESSFULLY AND ADDED TO GOLDEN MASTER";}
	else
			returnstmt="RECORD APPROVED SUCCESSFULLY";

}
else
	returnstmt="RECORD NOT APPROVED. CONTACT THE ADMINISTRATOR";
	return returnstmt; 
}
catch(Exception e)
{
	return "Exception Occurred!!!";
	}}
	
	
	@Transactional(rollbackOn = Exception.class)
	public String saveDtiDraft(StationUncleansedData stationdraftdti) throws Exception {
		boolean ispresent;
		String returnstmt="";
		
		try {
		ispresent=stn_unclsnd_repo.findById(stationdraftdti.getStn_Id()).isPresent();//Check if record is already present
		// If record is already present their are two cases:
		
		if(ispresent)
		{
//1.that record is already saved as draft
			String status=stn_unclsnd_repo.findById(stationdraftdti.getStn_Id()).get().getDti_status();
			String useriddti=stn_unclsnd_repo.findById(stationdraftdti.getStn_Id()).get().getUser_id_dti();
			
			if(status.equals("D"))
				
			{//by the same user.
				if(useriddti.equals(stationdraftdti.getUser_id_dti()))
				{
					//if this is the same user
					String dti_station_code=stationdraftdti.getStn_Id().getStation_code();
					Date dti_valid_from=stationdraftdti.getStn_Id().getStation_valid_from();
					Date dti_valid_upto=stationdraftdti.getStn_Id().getStation_valid_upto();
					String userid=stationdraftdti.getUser_id_dti();
					  Date date = new Date();  
				stn_unclsnd_repo.updateDraftDti(userid,  dti_station_code,  dti_valid_from,  dti_valid_upto, stationdraftdti.getGauge_code(), stationdraftdti.getStation_category(),
						stationdraftdti.getInterchange_flag() , stationdraftdti.getTraction() , stationdraftdti.getInterlocking_standard()  , stationdraftdti.getJunction_flag() , 
						stationdraftdti.getNo_of_lines() , stationdraftdti.getOperating_station_signal(),date,stationdraftdti.getDti_status());
				returnstmt="DRAFT UPDATED SUCCESSFULLY";	
				
				}
				
				//2.that record is already saved as draft by the OTHER user.
				else
					returnstmt="TRANSACTION ABORTED . THIS DRAFT IS ALREADY SAVED BY OTHER USER.";
				
			}
			
		else if(status.equals("N"))
			{
				// 3. this record is already initiated by cmi. so update attributes but reply message as draft created
	     		String dti_station_code=stationdraftdti.getStn_Id().getStation_code();
				Date dti_valid_from=stationdraftdti.getStn_Id().getStation_valid_from();
				Date dti_valid_upto=stationdraftdti.getStn_Id().getStation_valid_upto();
				String userid=stationdraftdti.getUser_id_dti();
				  Date date = new Date();  
			stn_unclsnd_repo.updateDraftDtiCmi( userid,  dti_station_code,  dti_valid_from,  dti_valid_upto, stationdraftdti.getGauge_code(), stationdraftdti.getStation_category(),
					stationdraftdti.getInterchange_flag() , stationdraftdti.getTraction() , stationdraftdti.getInterlocking_standard()  , stationdraftdti.getJunction_flag() , 
					stationdraftdti.getNo_of_lines() , stationdraftdti.getOperating_station_signal(),date,stationdraftdti.getDti_status() );
			returnstmt="DRAFT CREATED SUCCESSFULLY";	
			}
				
		else returnstmt="INVALID TRANSACTION";	
		}
		
		else
		{
//			 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			
//			System.out.println(stationdraftdti.getOperating_station_signal());
			    Date date = new Date();  
		       stationdraftdti.setTxn_date_dti(date);
		    	stn_unclsnd_repo.save(stationdraftdti);
			
			returnstmt="DRAFT CREATED SUCCESSFULLY";	
			
		}
	
	return returnstmt;
		}
		catch(Exception e)
		{
			return "Exception Occurred";
		}
	 }

	@Transactional(rollbackOn = Exception.class)
	public String forwardToDom(StationUncleansedData stationdatadom) throws Exception {
		 boolean ispresent;
			String returnstmt="";
			try {
			ispresent=stn_unclsnd_repo.findById(stationdatadom.getStn_Id()).isPresent();
			
			if(ispresent)
			{
				String status=stn_unclsnd_repo.findById(stationdatadom.getStn_Id()).get().getDti_status();
				if(status.equals("D"))
				{
					String dti_station_code=stationdatadom.getStn_Id().getStation_code();
					Date dti_valid_from=stationdatadom.getStn_Id().getStation_valid_from();
					Date dti_valid_upto=stationdatadom.getStn_Id().getStation_valid_upto();
					String userid=stationdatadom.getUser_id_dti();
					String station_status="U";
					Date date = new Date();  
					stn_unclsnd_repo.updateDraftDti(userid,  dti_station_code,  dti_valid_from,  dti_valid_upto, stationdatadom.getGauge_code(), stationdatadom.getStation_category(),
							stationdatadom.getInterchange_flag() , stationdatadom.getTraction() , stationdatadom.getInterlocking_standard()  , stationdatadom.getJunction_flag() , 
							stationdatadom.getNo_of_lines() , stationdatadom.getOperating_station_signal(),date,station_status);
					returnstmt="RECORD FORWARDED TO DOM SUCCESSFULLY";	
		
				}
				
				else if(status.equals("N"))
				{	String station_status="U";
					// 3. this record is already initiated by dti. so update attributes but reply message as draft created
		     		String dti_station_code=stationdatadom.getStn_Id().getStation_code();
					Date dti_valid_from=stationdatadom.getStn_Id().getStation_valid_from();
					Date dti_valid_upto=stationdatadom.getStn_Id().getStation_valid_upto();
					String userid=stationdatadom.getUser_id_cmi();
					
					  Date date = new Date();  
				stn_unclsnd_repo.updateDraftDtiCmi( userid,  dti_station_code,  dti_valid_from,  dti_valid_upto, stationdatadom.getGauge_code(), stationdatadom.getStation_category(),
						stationdatadom.getInterchange_flag() , stationdatadom.getTraction() , stationdatadom.getInterlocking_standard()  , stationdatadom.getJunction_flag() , 
						stationdatadom.getNo_of_lines() , stationdatadom.getOperating_station_signal(),date,station_status);
				returnstmt="RECORD FORWARDED TO DOM SUCCESSFULLY";	
				}
				
				else returnstmt="INVALID TRANSACTION";	
				
			}
			else
			{
				
				   Date date = new Date();  
					  
				   stationdatadom.setTxn_date_dti(date);
					
					stn_unclsnd_repo.save(stationdatadom);
					
					returnstmt="RECORD FORWARDED TO DOM SUCCESSFULLY";	
				
			}
			
			
			
	 
	 return returnstmt;
			}
			catch(Exception e)
			{
				return "Exception Occurred !!!";
			}
		
	}


	public List<StationUncleansedData> fetchUnapprovedDtiRecords(String division_code) {
		return	 stn_unclsnd_repo.fetchUnapprovedDtiRecords(division_code);
	}

}


