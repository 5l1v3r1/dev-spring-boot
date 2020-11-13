package com.mdms.mdms_station.stationuncleansed.service;

<<<<<<< HEAD
public class StationEditForwardService {

=======
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.SimpleDateFormat;  
import java.util.Date;      
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.mdms_station.stationuncleansed.repository.StationTableRbsRepository;
import com.mdms.mdms_station.stationuncleansed.repository.StationUncleansedDataRepository;
import com.mdms.mdms_masters.repository.MDivisionRepository;
import com.mdms.mdms_station.stationuncleansed.model.StationTableRbs;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedData;


@Service
public class StationEditForwardService {
	@Autowired
	StationUncleansedDataRepository stn_unclsnd_repo;
	
	@Autowired
	StationTableRbsRepository stn_tbl_rbs_repo;
	
	@Autowired 
	MDivisionRepository divsn_repo;
	
	
	
	public List<String> getDivisionalStnCodeCmi(String division){
		
		int divno=	divsn_repo.getDivsionCode(division);
			
		return stn_tbl_rbs_repo.getDivisionalStnCodeCmi(divno);
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

	
	 @Transactional(rollbackOn = Exception.class)
	 public String saveCmiDraft(StationUncleansedData stationdraftcmi) {
		
		boolean ispresent;
		String returnstmt="";
		ispresent=stn_unclsnd_repo.findById(stationdraftcmi.getStn_Id()).isPresent();
		if(ispresent)
		{

			String status=stn_unclsnd_repo.findById(stationdraftcmi.getStn_Id()).get().getCmi_status();
			
			if(status.equals("D"))
			
			{
				String cmi_station_code=stationdraftcmi.getStn_Id().getStation_code();
				Date cmi_valid_from=stationdraftcmi.getStn_Id().getStation_valid_from();
				Date cmi_valid_upto=stationdraftcmi.getStn_Id().getStation_valid_upto();
				String userid=stationdraftcmi.getUser_id_cmi();
				  Date date = new Date();  
			stn_unclsnd_repo.updateDraft( userid,  cmi_station_code ,  cmi_valid_from ,  cmi_valid_upto , stationdraftcmi.getStation_numeric_code(),
					stationdraftcmi.getStation_name(),	stationdraftcmi.getTraffic_type(),stationdraftcmi.getTranshipment_flag() ,
					stationdraftcmi.getStation_class() ,stationdraftcmi.getJunction_flag(), stationdraftcmi.getInterchange_flag() , 
					stationdraftcmi.getState(), stationdraftcmi.getPincode() , stationdraftcmi.getDistrict(),stationdraftcmi.getTehsil(), 
					stationdraftcmi.getStation_short_name(), stationdraftcmi.getInterlocking_standard() , stationdraftcmi.getWorking_division(),
					stationdraftcmi.getWeight_bridge(), stationdraftcmi.getSiding() , stationdraftcmi.getBooking_type() , stationdraftcmi.getCmi_status(), date );
			returnstmt="Draft Updated Successfully";	
				
			}
			
			

			//update
			returnstmt="Draft Updated Successfully";	

			
		}
		
		else
		{
//			 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			    Date date = new Date();  
			  
			stationdraftcmi.setTxn_date_cmi(date);
			
			stn_unclsnd_repo.save(stationdraftcmi);
			
			returnstmt="Draft Created Successfully";	
			
		}
		
		
		
		return returnstmt;
	}
	
	 

	 @Transactional(rollbackOn = Exception.class)
	 public String forwardToDcm(StationUncleansedData stationdatadcm) {
		 
		 boolean ispresent;
			String returnstmt="";
			ispresent=stn_unclsnd_repo.findById(stationdatadcm.getStn_Id()).isPresent();
			String status=stn_unclsnd_repo.findById(stationdatadcm.getStn_Id()).get().getCmi_status();
			if(ispresent && status.equals("D"))
			{
				
				String cmi_station_code=stationdatadcm.getStn_Id().getStation_code();
				Date cmi_valid_from=stationdatadcm.getStn_Id().getStation_valid_from();
				Date cmi_valid_upto=stationdatadcm.getStn_Id().getStation_valid_upto();
				String userid=stationdatadcm.getUser_id_cmi();
				String station_status="U";
				  Date date = new Date();  
			stn_unclsnd_repo.updateDraft( userid,  cmi_station_code ,  cmi_valid_from ,  cmi_valid_upto , stationdatadcm.getStation_numeric_code(),
					stationdatadcm.getStation_name(),	stationdatadcm.getTraffic_type(),stationdatadcm.getTranshipment_flag() ,
					stationdatadcm.getStation_class() ,stationdatadcm.getJunction_flag(), stationdatadcm.getInterchange_flag() , 
					stationdatadcm.getState(), stationdatadcm.getPincode() , stationdatadcm.getDistrict(),stationdatadcm.getTehsil(), 
					stationdatadcm.getStation_short_name(), stationdatadcm.getInterlocking_standard() , stationdatadcm.getWorking_division(),
					stationdatadcm.getWeight_bridge(), stationdatadcm.getSiding() , stationdatadcm.getBooking_type() , station_status, date );
			returnstmt="Record Forwarded To DCM Successfully";
				
			}
			else
			{
				
				   Date date = new Date();  
					  
				   stationdatadcm.setTxn_date_cmi(date);
					
					stn_unclsnd_repo.save(stationdatadcm);
					
					returnstmt="Record Forwarded To DCM Successfully";	
				
			}
			
			
			
	 
	 return returnstmt;
	 }
	 
	 

	 
>>>>>>> ef3574260e9ec6ab5b6df606ebd08b2a510cdcb0
}
