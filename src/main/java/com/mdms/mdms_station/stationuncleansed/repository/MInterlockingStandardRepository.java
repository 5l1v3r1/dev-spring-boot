package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MInterlockingStandard;

public interface MInterlockingStandardRepository extends CrudRepository<MInterlockingStandard,String> {


	@Query(value="Select * from mdms_station.m_interlocking_standard", nativeQuery = true)
<<<<<<< HEAD
=======

	@Query(value="Select * from mdms_station.m_gauge", nativeQuery = true)

>>>>>>> 17c0ce0caec99abce83672b19e6c0daad78240b8
	List<MInterlockingStandard> getInterLock();

}
