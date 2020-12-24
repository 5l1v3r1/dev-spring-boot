package com.mdms.mdms_masters.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.loco.locouncleansed.model.MLocoType;
import com.mdms.mdms_masters.model.MDesignation;
import com.mdms.mdms_masters.model.MDivision;
import com.mdms.mdms_masters.model.MZone;
import com.mdms.mdms_masters.repository.MDesignationRepository;
import com.mdms.mdms_masters.repository.MDivisionRepository;
import com.mdms.mdms_masters.repository.MZoneRepository;

@Service
public class MdmsMasterService {	
	@Autowired
	MDivisionRepository divsn_repo;
	@Autowired
	MZoneRepository zone_repo;	
	@Autowired
	MDesignationRepository desig_repo;
	
private String div_code;
	private String zone_code;
	public List<MDivision> getAllDivision() {
		// TODO Auto-generated method stub
		return divsn_repo.getAllDivision();
	}

	
	public List<String> getAllZone() {
		// TODO Auto-generated method stub
		return zone_repo.getAllZone();
	}


	public List<MDivision> findByZone(MDivision division) {
		zone_code=division.getZone_code();
		System.out.print(zone_code);
		List<MDivision> tmp = new ArrayList<>();
		divsn_repo.findByZoneCode(zone_code).forEach(tmp::add);
	    return tmp;
	}
	
	public String findByDivision(String division) throws Exception{		
		String zonecode;		
		 zonecode=divsn_repo.findByDivCode(division);
    return zonecode;
		
	}

//	public List<MDesignation> findDesignation(MDesignation desig) throws Exception
//	{		
//		List<MDesignation> temp=new ArrayList<>();
//		desig_repo.findDesignation(desig)
//		.forEach(temp::add);
//		return temp;  		
//	
//	
//	}
	public boolean verifyStnUserDesig(MDesignation userdesig) {
	   String udesigname=userdesig.getDesignation_name();       
	   String desig=desig_repo.findStnDesignation(udesigname);
	   if((desig!=null )&&(desig.equals(desig)) ){
	    	return true;
	       	
	    	
	    } else {
	    	return false;
	    }
	   
	}
	
	public boolean verifyCoachUserDesig(MDesignation userdesig) {
		   String udesigname=userdesig.getDesignation_name();       
		   String desig=desig_repo.findcoachDesignation(udesigname);
		   if((desig!=null )&&(desig.equals(desig)) ){
		    	return true;
		       	
		    	
		    } else {
		    	return false;
		    }
		   
		}
	public boolean verifyLocoUserDesig(MDesignation userdesig) {
		   String udesigname=userdesig.getDesignation_name();       
		   String desig=desig_repo.findLocoDesignation(udesigname);
		   if((desig!=null )&&(desig.equals(desig)) ){
		    	return true;
		       	
		    	
		    } else {
		    	return false;
		    }
		   
		}
}

	

