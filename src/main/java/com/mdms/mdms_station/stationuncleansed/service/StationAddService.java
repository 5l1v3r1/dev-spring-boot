package com.mdms.mdms_station.stationuncleansed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	
}
