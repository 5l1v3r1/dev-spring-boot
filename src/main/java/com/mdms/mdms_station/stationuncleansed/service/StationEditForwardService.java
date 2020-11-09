package com.mdms.mdms_station.stationuncleansed.service;

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
	
	 
	 
}
