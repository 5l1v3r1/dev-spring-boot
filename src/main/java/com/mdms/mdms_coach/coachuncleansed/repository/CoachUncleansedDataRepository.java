package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.Collection;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.DashBoardCoachCountDepoWiseModel;
import com.mdms.dahsboard.model.DashBoardLocoCountShedWiseModel;
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
   
// Shilpi 15-03-2021
   
	@Query(value="SELECT owning_depot , COUNT(*)  as draft_forward_approval_count FROM  mdms_coach.coach_uncleansed_data WHERE owning_depot=?1 AND (status='D' OR Status='R') GROUP BY owning_depot",nativeQuery=true)
	Collection<DashBoardCoachCountDepoWiseModel> getDraftCoachApprovalSingledepo(String owning_depot);
	
	
	@Query(value="SELECT  owning_depot  ,COUNT(*)  as pending_approval FROM mdms_coach.coach_uncleansed_data WHERE owning_depot=?1 AND status='U'GROUP BY owning_depot ",nativeQuery=true)
		Collection<DashBoardCoachCountDepoWiseModel> getCoachPendingSingledepo(String owning_depot);
	
	//Shilpi 16-04-2021 hyper link depot wise
	
	@Query(value="SELECT * FROM  mdms_coach.coach_uncleansed_data WHERE owning_depot=?1 AND (status='D' OR Status='R')",nativeQuery=true)
	List<CoachUncleansedData> getDraftCoachApprovalHyperdepo(String owning_depot);
	
	
	@Query(value="SELECT  * FROM mdms_coach.coach_uncleansed_data WHERE owning_depot=?1 AND status='U'",nativeQuery=true)
		List<CoachUncleansedData> getCoachPendingHyperdepo(String owning_depot);
	
	
	// Shilpi 19-04-2021 Zonal coach depot
	   
		@Query(value="SELECT owning_depot , COUNT(*)  as draft_forward_approval_count FROM  mdms_coach.coach_uncleansed_data WHERE owning_rly=?1 AND (status='D' OR Status='R') GROUP BY owning_depot",nativeQuery=true)
		Collection<DashBoardCoachCountDepoWiseModel> getDraftCoachApprovalZonedepo(String owning_rly);
		
		
		@Query(value="SELECT  owning_depot  ,COUNT(*)  as pending_approval FROM mdms_coach.coach_uncleansed_data WHERE owning_rly=?1 AND status='U'GROUP BY owning_depot ",nativeQuery=true)
			Collection<DashBoardCoachCountDepoWiseModel> getCoachPendingZonedepo(String owning_rly);
		

		
		
}
