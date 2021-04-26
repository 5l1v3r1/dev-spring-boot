package com.mdms.mdms_coach.coachuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.DashBoardCoachCountDepoWiseModel;
import com.mdms.mdms_coach.coachuncleansed.model.CoachTypeMapping;

public interface CoachTypeMappingRepository extends CrudRepository<CoachTypeMapping,String>{
	
	@Query(value="select count(*) as cleansed_count from (SELECT * FROM mdms_coach.coach_type_mapping) as aa",nativeQuery=true)
	List<DashBoardCoachCountDepoWiseModel> getCoachmapcount();

}
