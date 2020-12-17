package com.mdms.mdms_coach.coachuncleansed.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachType;

import com.mdms.mdms_coach.coachuncleansed.model.MFitnessType;
import com.mdms.mdms_coach.coachuncleansed.repository.MCoachTypeRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.MDepotRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.MFitnessTypeRepository;

@Service
public class CoachMetaMastersService {
	@Autowired
	MCoachTypeRepository coach_type_repo;
	
	@Autowired
	MDepotRepository depo_type_repo ;
	
	@Autowired
	MFitnessTypeRepository fitness_type_repo;

	public MCoachType getCoachTypeDetails(String coachtype) {
		
		 return coach_type_repo.getCoachTypeDetails(coachtype);
	}
	
	
	public List<String> getCoachTypes() {
		
		 return coach_type_repo.getCoachTypes();
	}


	public List<String> getDepot() {
	
		return depo_type_repo.getDepotTypes();
	}
	
	public List<MFitnessType> getFitnessType()
	{
		return fitness_type_repo.getAllFitnessType();
		
	}
	

}
