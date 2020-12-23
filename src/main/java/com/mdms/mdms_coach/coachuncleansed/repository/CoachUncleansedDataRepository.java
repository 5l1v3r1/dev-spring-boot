package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_coach.coachuncleansed.model.CoachUncleansedData;

public interface CoachUncleansedDataRepository extends CrudRepository<CoachUncleansedData, Long> {
	
	@Query(value="SELECT * FROM mdms_coach.coach_uncleansed_data WHERE owning_depot=?1 AND status='U'",nativeQuery = true)
	List<CoachUncleansedData> fetchUnapprovedCoachRecords(String depot);

}
