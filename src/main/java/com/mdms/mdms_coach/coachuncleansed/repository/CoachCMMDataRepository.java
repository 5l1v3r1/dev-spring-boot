package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_coach.coachuncleansed.model.CoachDataCMM;


public interface CoachCMMDataRepository extends CrudRepository<CoachDataCMM, String> {	
	@Query(value="Select * from mdms_coach.coach_data_cmm where coach_id=?1", nativeQuery = true)
	Optional<CoachDataCMM> findByCoachId(String coachId);

}
