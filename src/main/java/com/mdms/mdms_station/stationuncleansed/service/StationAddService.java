package com.mdms.mdms_station.stationuncleansed.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedData;
import com.mdms.mdms_station.stationuncleansed.repository.StationCleansedDataRepository;
import com.mdms.mdms_station.stationuncleansed.repository.StationUncleansedDataRepository;
@Service
public class StationAddService {
@Autowired	
StationCleansedDataRepository stn_clnsd_repo;

@Autowired
StationUncleansedDataRepository stn_unclsnd_repo;


	public String checkStncodeExit(String stncode) throws Exception {
		String returnstmt=null;
		String sc;
		 sc=stn_clnsd_repo.checkStnCodeExist(stncode);	
		try {		 
			if(sc!=null)
			{
				returnstmt="true";

		}	else
		{
			returnstmt="false";
			return returnstmt; 
		
		}}catch(Exception e)
		{
			}
		return returnstmt;
		}
	
public String saveCmiCleansedDraft(StationUncleansedData stationdraftcmi)throws Exception {
	
	boolean ispresent;
	String returnstmt="";
	try {
	ispresent=stn_unclsnd_repo.findById(stationdraftcmi.getStn_Id()).isPresent();//Check if record is already present	
	if(ispresent)
	{
//1.that record is already saved as draft 
		
		String status=stn_clnsd_repo.findById(stationdraftcmi.getStn_Id()).get().getCmi_status();
		String useridcmi=stn_clnsd_repo.findById(stationdraftcmi.getStn_Id()).get().getUser_id_cmi();		
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
				  stn_unclsnd_repo.updateCleansedDraftCmi( userid,  cmi_station_code ,  cmi_valid_from ,  cmi_valid_upto , stationdraftcmi.getStation_numeric_code(),
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
		
	
		
	else returnstmt="INVALID TRANSACTION";	
	}
	
	else
	{
//		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		    Date date = new Date();  
		  
		stationdraftcmi.setTxn_date_cmi(date);
		
		if(stn_unclsnd_repo.save(stationdraftcmi)!=null) {
		
		returnstmt="DRAFT SAVED SUCCESSFULLY";
		
	}
		else
		{
				returnstmt="FAILED TO SAVE DRAFT";
		}}}
				catch(Exception e)
				{
					System.out.printf(e.getMessage(),e.getStackTrace());
					return "EXCEPTION OCCURRED!!!";
				}

	return returnstmt;
		

 
}

@Transactional(rollbackOn = Exception.class)
public String forwardToDCM(StationUncleansedData stationdataapprovebydcm) throws Exception{	 
	 boolean ispresent;
		String returnstmt="";
		try {
		ispresent=stn_unclsnd_repo.findById(stationdataapprovebydcm.getStn_Id()).isPresent();		
		if(ispresent)
		{String status=stn_unclsnd_repo.findById(stationdataapprovebydcm.getStn_Id()).get().getCmi_status();
			if(status.equals("D")) {
			String cmi_station_code=stationdataapprovebydcm.getStn_Id().getStation_code();
			Date cmi_valid_from=stationdataapprovebydcm.getStn_Id().getStation_valid_from();
			Date cmi_valid_upto=stationdataapprovebydcm.getStn_Id().getStation_valid_upto();
			String userid=stationdataapprovebydcm.getUser_id_cmi();
//			String station_status="U";
			String cmi_status="U";
			  Date date = new Date();  
			  stn_unclsnd_repo.updateCleansedDraftCmi( userid,  cmi_station_code ,  cmi_valid_from ,  cmi_valid_upto , stationdataapprovebydcm.getStation_numeric_code(),
					  stationdataapprovebydcm.getStation_name(),	stationdataapprovebydcm.getTraffic_type(),stationdataapprovebydcm.getTranshipment_flag() ,
					  stationdataapprovebydcm.getStation_class() ,stationdataapprovebydcm.getJunction_flag(), stationdataapprovebydcm.getInterchange_flag() , 
					  stationdataapprovebydcm.getState(), stationdataapprovebydcm.getPincode() , stationdataapprovebydcm.getDistrict(),stationdataapprovebydcm.getTehsil(), 
					  stationdataapprovebydcm.getStation_short_name(), stationdataapprovebydcm.getInterlocking_standard() , stationdataapprovebydcm.getWorking_division(),
					  stationdataapprovebydcm.getWeight_bridge(), stationdataapprovebydcm.getSiding() ,  stationdataapprovebydcm.getBooking_type() , cmi_status, date ,stationdataapprovebydcm.getBooking_resource());
		returnstmt="RECORD FORWARDED TO DCM SUCCESSFULLY";
			}
			
			
			
		}
		else
		{
			
			   Date date = new Date();  
				  
			   stationdataapprovebydcm.setTxn_date_cmi(date);
				
			   stn_unclsnd_repo.save(stationdataapprovebydcm);
				
				returnstmt="RECORD FORWARDED TO DCM SUCCESSFULLY";
		}
		
		
		

return returnstmt;
		}catch(Exception e)
		{
			System.out.printf(e.getMessage(),e.getStackTrace());
			return "Exception Occurred!!!";
			
		}
}
}

