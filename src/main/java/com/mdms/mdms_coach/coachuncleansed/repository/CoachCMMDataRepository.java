package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.DashBoardCoachCountDepoWiseModel;
import com.mdms.dahsboard.model.DashBoardLocoCountShedWiseModel;
import com.mdms.mdms_coach.coachuncleansed.model.CoachDataCMM;

public interface CoachCMMDataRepository extends CrudRepository<CoachDataCMM, String> {	

	@Query(value="Select * from mdms_coach.coach_data_cmm where coach_id=?1", nativeQuery = true)
	Optional<CoachDataCMM> findByCoachId(String coachId);
	
	//Shilpi 15-03-2021
	
	@Query(value="SELECT base_depot as owning_depot, count(*) as total_depot_count from mdms_coach.coach_data_cmm WHERE base_depot=?1 GROUP BY base_depot",nativeQuery=true)
    Collection<DashBoardCoachCountDepoWiseModel> getCoachSingleDepo(String owning_depot);
       
    @Query(value="SELECT base_depot as owning_depot,COUNT(coach_id) as uncleansed_count FROM (select cast(coach_id as integer),base_depot from mdms_coach.coach_data_cmm EXCEPT SELECT coach_id,owning_depot FROM mdms_coach.coach_cleansed_data ) AS AA where BASE_depot=?1 group by 1",nativeQuery=true)
    Collection<DashBoardCoachCountDepoWiseModel> getUncleansedCoachSingleDepo(String owning_depot);

}
