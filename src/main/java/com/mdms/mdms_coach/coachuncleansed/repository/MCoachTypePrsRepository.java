package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_coach.coachuncleansed.model.MCoachTypePrs;

public interface MCoachTypePrsRepository extends CrudRepository<MCoachTypePrs,String>{
	@Query(value="select coach_code from mdms_coach.m_coach_type_prs ",nativeQuery = true)
	List<String> getCoachTypesPrs();
	
	@Query(value="select coach_code from mdms_coach.m_coach_type_prs except select coach_code from mdms_coach.prs_type_layout ",nativeQuery = true)
	List<String> getCoachTypesPrsLayout();
	

}
