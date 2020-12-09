package com.mdms.mdms_station.stationuncleansed.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.mdms_station.stationuncleansed.model.StationCleansedData;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedData;
import com.mdms.mdms_station.stationuncleansed.repository.StationCleansedDataRepository;
@Service
public class StationAddService {
@Autowired	
StationCleansedDataRepository stn_clnsd_repo;

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
	

	 @Transactional(rollbackOn = Exception.class)
	 public String updateCmiDraft(StationCleansedData stationdraftcmi)throws Exception {				
		String returnstmt="";	
		try {
					String cmi_station_code=stationdraftcmi.getStn_Id().getStation_code();
					Date cmi_valid_from=stationdraftcmi.getStn_Id().getStation_valid_from();
					Date cmi_valid_upto=stationdraftcmi.getStn_Id().getStation_valid_upto();
					String userid=stationdraftcmi.getUser_id_cmi();
					  Date date = new Date();  
				   stn_clnsd_repo.updateCleansedDraftCmi( userid,  cmi_station_code ,  cmi_valid_from ,  cmi_valid_upto , stationdraftcmi.getStation_numeric_code(),
						stationdraftcmi.getStation_name(),	stationdraftcmi.getTraffic_type(),stationdraftcmi.getTranshipment_flag() ,
						stationdraftcmi.getStation_class() ,stationdraftcmi.getJunction_flag(), stationdraftcmi.getInterchange_flag() , 
						stationdraftcmi.getState(), stationdraftcmi.getPincode() , stationdraftcmi.getDistrict(),stationdraftcmi.getTehsil(), 
						stationdraftcmi.getStation_short_name(), stationdraftcmi.getInterlocking_standard() , stationdraftcmi.getWorking_division(),
						stationdraftcmi.getWeight_bridge(), stationdraftcmi.getSiding() , stationdraftcmi.getBooking_type() , stationdraftcmi.getCmi_status(), date,stationdraftcmi.getBooking_resource() );
				returnstmt="DRAFT UPDATED SUCCESSFULLY";	
		}
		catch (Exception e)
		{
			System.out.printf(e.getMessage(),e.getStackTrace());
			returnstmt="FAILED TO UPDATE";	
		}
	return returnstmt;
		}
	
	
	

public String saveCmiCleansedDraft(StationCleansedData savedraftcmi)throws Exception {			
	String returnstmt="";		

	 
	    Date date = new Date();  
		try 	{	
			savedraftcmi.setTxn_date_cmi(date);
	
			System.out.println(savedraftcmi);
	if(stn_clnsd_repo.save(savedraftcmi)!=null)
	{
		returnstmt="DRAFT SAVED SUCCESSFULLY";
	}
		else
	{
			returnstmt="FAILED TO SAVE DRAFT";
	}}
			catch(Exception e)
			{
				System.out.printf(e.getMessage(),e.getStackTrace());
				return "EXCEPTION OCCURRED!!!";
			}

return returnstmt;
	
}
}

