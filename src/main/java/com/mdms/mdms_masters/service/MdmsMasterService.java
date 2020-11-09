package com.mdms.mdms_masters.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.mdms_masters.model.MDivision;
import com.mdms.mdms_masters.repository.MDivisionRepository;

@Service
public class MdmsMasterService {
	
	@Autowired
	MDivisionRepository divsn_repo;

	public List<MDivision> getAllDivision() {
		// TODO Auto-generated method stub
		return divsn_repo.getAllDivision();
	}

}
