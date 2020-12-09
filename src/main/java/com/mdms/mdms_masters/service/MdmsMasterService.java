package com.mdms.mdms_masters.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.mdms_masters.model.MDivision;
import com.mdms.mdms_masters.repository.MDivisionRepository;

@Service
public class MdmsMasterService {
	
	@Autowired
	MDivisionRepository divsn_repo;
private String div_code;
	private String zone_code;
	public List<MDivision> getAllDivision() {
		// TODO Auto-generated method stub
		return divsn_repo.getAllDivision();
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


	
	}

	

