package com.mdms.loco.locouncleansed.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.loco.locouncleansed.model.LocoApprovedData;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
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
	
	 public List<LocoApprovedData> getApprovedLocos(LocoApprovedData obj_approved) {
//			// TODO Auto-generated method stub
			System.out.println("getGoldendlocos");
			String shedid=obj_approved.getElec_locoOwningShed();
			approved_repo.getApprovedLoco(shedid);
			List<LocoApprovedData> approvedLoco= new ArrayList<>();
			approved_repo.getApprovedLoco(shedid)
			.forEach(approvedLoco::add);
			System.out.println(" End GetGoldenLocos");
			return approved_repo.getApprovedLoco(shedid);
		}
	 
		public List<LocoApprovedData> getLocoApprovedHypershed( LocoApprovedData objelecmodel) {
//			// TODO Auto-generated method stub
			System.out.println("getDraftUnapprovedLocos");
			String shedid=objelecmodel.getElec_locoOwningShed();
			approved_repo.getLocoApprovedHypershed(shedid);
			List<LocoApprovedData> uncleaseLoco= new ArrayList<>();
			approved_repo.getLocoApprovedHypershed(shedid)
			.forEach(uncleaseLoco::add);
			System.out.println(" End getuncleansedunapprovedocos");
			return approved_repo.getLocoApprovedHypershed(shedid);
//			return uncleaseLoco;
		}

}
