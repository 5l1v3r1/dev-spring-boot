package com.mdms.loco.locouncleansed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.loco.locouncleansed.model.LocoApprovedData;
import com.mdms.loco.locouncleansed.repository.LocoApprovedDataRepository;
@Service
public class LocoApproveService {	
	@Autowired 
	private LocoApprovedDataRepository approved_repo;
	public boolean adddata(LocoApprovedData objcleansed) {
		try{
			
			objcleansed.setElec_Remarks("Approved");
			objcleansed.setElec_Status("A");		
			
		if(approved_repo.save(objcleansed) != null)
					return true;				
				
			}
	catch(Exception e){
		
		System.out.println(e);
		
		}
		return false;
	}
	


}
