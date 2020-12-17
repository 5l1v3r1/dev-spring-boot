package com.mdms.mdms_coach.coachuncleansed.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachType;
import com.mdms.mdms_coach.coachuncleansed.repository.MCoachTypeRepository;

@Service
public class CoachMetaMastersService {
	@Autowired
	MCoachTypeRepository coach_type_repo;

	public MCoachType getCoachTypeDetails(String coachtype) {
		
		 return coach_type_repo.getCoachTypeDetails(coachtype);
	}
	
	
	public List<String> getCoachTypes() {
		 return coach_type_repo.getCoachTypes();
	}


	public List<String> getCoachDepot() {
		 return coach_type_repo.getCoachDepots();
	}


	public List<String> getCoachCategory() {
		 return coach_type_repo.getCoachCategory();
	}


	public List<String> getCoachCouplingTpe() {
		return coach_type_repo.getCoachCouplingType();
	}


	public List<String> getFitnessType() {
		return coach_type_repo.getCoachFitnessType();
	}


	public List<String> getPowerGenType() {
		return coach_type_repo.getPowerGenType();
	}


	public List<String> getBrakeType() {
		return coach_type_repo.getBrakeType();
	}
	
	
	

}
