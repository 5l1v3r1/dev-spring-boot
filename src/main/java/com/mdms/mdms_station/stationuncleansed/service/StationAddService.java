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

	public String checkIfExists(String stncode) throws Exception {
		String returnstmt=null;
		String sc;
		 sc=stn_clnsd_repo.checkIfExists(stncode);	
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
	 public String saveCmiCleansedDraft(StationCleansedData stationdraftcmi)throws Exception {
			
			boolean ispresent;
			String returnstmt="";
			try {
			ispresent=stn_clnsd_repo.findById(stationdraftcmi.getStn_Id()).isPresent();//Check if record is already present	
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
						  stn_clnsd_repo.updateCleansedDraftCmi( userid,  cmi_station_code ,  cmi_valid_from ,  cmi_valid_upto , stationdraftcmi.getStation_numeric_code(),
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
//				 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
				    Date date = new Date();  
				  
				stationdraftcmi.setTxn_date_cmi(date);
				
				if(stn_clnsd_repo.save(stationdraftcmi)!=null) {
				
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
}

