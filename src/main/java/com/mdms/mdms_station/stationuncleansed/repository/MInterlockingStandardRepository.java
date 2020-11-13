package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MInterlockingStandard;

public interface MInterlockingStandardRepository extends CrudRepository<MInterlockingStandard,String> {

<<<<<<< HEAD
	
	@Query(value="Select * from mdms_station.m_gauge", nativeQuery = true)
=======

	@Query(value="Select * from mdms_station.m_interlocking_standard", nativeQuery = true)

>>>>>>> ef3574260e9ec6ab5b6df606ebd08b2a510cdcb0
	List<MInterlockingStandard> getInterLock();

}
