<<<<<<< HEAD
=======

>>>>>>> ef3574260e9ec6ab5b6df606ebd08b2a510cdcb0
package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MStationJunction;

public interface MStationJunctionRepository extends CrudRepository<MStationJunction,String> {

	@Query(value="Select * from mdms_station.m_station_junction", nativeQuery = true)
	List<MStationJunction> getStationJunction();
	

}
