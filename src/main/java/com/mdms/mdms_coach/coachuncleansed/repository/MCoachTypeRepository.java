package com.mdms.mdms_coach.coachuncleansed.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.mdms.mdms_coach.coachuncleansed.model.MCoachType;

public interface MCoachTypeRepository  extends CrudRepository<MCoachType,String>{
@Query(value="select * from mdms_coach.m_coach_type_cmm where coach_type=?1",nativeQuery = true)
	MCoachType getCoachTypeDetails(String coachtype);

@Query(value="select coach_type from mdms_coach.m_coach_type_cmm ",nativeQuery = true)
List<String> getCoachTypes();
}
 
