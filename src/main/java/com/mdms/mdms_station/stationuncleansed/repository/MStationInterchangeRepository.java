package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.MStationInterchange;
public interface MStationInterchangeRepository extends CrudRepository<MStationInterchange,String>{

	@Query(value="Select * from mdms_station.m_station_interchange", nativeQuery = true)
	List<MStationInterchange> getStationInterchange();

}
