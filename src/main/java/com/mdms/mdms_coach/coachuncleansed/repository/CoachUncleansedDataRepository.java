package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_coach.coachuncleansed.model.CoachUncleansedData;

public interface CoachUncleansedDataRepository extends CrudRepository<CoachUncleansedData, Long> {
	
	@Query(value="SELECT * FROM mdms_coach.coach_uncleansed_data WHERE owning_depot=?1 AND status='U'",nativeQuery = true)
	List<CoachUncleansedData> fetchUnapprovedCoachRecords(String depot);
	@Modifying
	@Transactional
	@Query(value="UPDATE mdms_coach.coach_uncleansed_data SET status='A' where coach_id=?1",nativeQuery = true)
	int approveCoachRecord(Long coachid);
	
   @Query(value="SELECT * FROM mdms_coach.coach_uncleansed_data WHERE user_id =?1 and coach_id=?2 and status='D'",nativeQuery = true)
	CoachUncleansedData getCoachDraft(String userid, long coach_id);
}
