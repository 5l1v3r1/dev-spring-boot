package com.mdms.mdms_coach.coachuncleansed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.mdms_coach.coachuncleansed.model.CMMTypeLayout;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachType;
import com.mdms.mdms_coach.coachuncleansed.model.PRSTypeLayout;
import com.mdms.mdms_coach.coachuncleansed.repository.MCoachTypeRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.MDepotRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.MFitnessTypeRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.PRSTypeLayoutRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.CMMTypeLayoutRepository;
import com.mdms.mdms_coach.coachuncleansed.repository.MCoachTypePrsRepository;

@Service
public class CoachMetaMastersService {
	@Autowired
	MCoachTypeRepository coach_type_repo;
	
	@Autowired
	MDepotRepository depo_type_repo ;
	
	@Autowired
	MFitnessTypeRepository fitness_type_repo;
	
	@Autowired
	MCoachTypePrsRepository prs_type_repo;
	
	@Autowired
	CMMTypeLayoutRepository cmm_coach_layout_repo;
	
	@Autowired
	PRSTypeLayoutRepository prs_coach_layout_repo;
	

	public MCoachType getCoachTypeDetails(String coachtype) {
		
		 return coach_type_repo.getCoachTypeDetails(coachtype);
	}
	
	
	public List<String> getCoachTypes() {
		 return coach_type_repo.getCoachTypes();
	}

	public List<String> getCoachTypesCmm() {
		 return coach_type_repo.getCoachTypesCmm();
	}
	
	public List<String> getCoachTypesCmmLayout() {
		 return coach_type_repo.getCoachTypesCmmLayout();
	}

	
	public List<String> getCoachTypesPrsLayout() {
		 return prs_type_repo.getCoachTypesPrsLayout();
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
	public List<String> getDepot() {

	
		return depo_type_repo.getDepotTypes();
	}


	public List<String> getCoachTypesPrs() {
		
		return prs_type_repo.getCoachTypesPrs();
	}
	
	public List<CMMTypeLayout> getUnappCMMLayout() {
		
		return cmm_coach_layout_repo.getUnappCMMLayout();
	}


		public String approveCmmCoachLayout(String cmmcoachtype) {
		// TODO Auto-generated method stub
		String response=null;
		int i=0;
		i=cmm_coach_layout_repo.approveCmmCoachLayout(cmmcoachtype);
		if(i>0)
			response="RECORD APPROVED SUCCESSFULLY";
		else
			response="TRANSACTION ABORTED.RECORD NOT APPROVED";
		return response;
	}
	
		
public List<CMMTypeLayout> getAppCMMLayout() {
			
			return cmm_coach_layout_repo.getAppCMMLayout();
		}

		public List<PRSTypeLayout> getUnappPRSLayout() {
			
			return prs_coach_layout_repo.getUnappPRSLayout();
		}

		public String approvePrsCoachLayout(String prscoachtype) {
			// TODO Auto-generated method stub
			String response=null;
			int i=0;
			i=prs_coach_layout_repo.approvePrsCoachLayout(prscoachtype);
			if(i>0)
				response="RECORD APPROVED SUCCESSFULLY";
			else
				response="TRANSACTION ABORTED.RECORD NOT APPROVED";
			return response;
		}	
		
		
		
	public List<PRSTypeLayout> getAppPRSLayout() {
			
			return prs_coach_layout_repo.getAppPRSLayout();
		}
}
