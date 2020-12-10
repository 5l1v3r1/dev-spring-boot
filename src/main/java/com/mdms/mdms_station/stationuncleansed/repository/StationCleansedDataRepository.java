package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.StationCleansedData;
import com.mdms.mdms_station.stationuncleansed.model.StationPKey;

import antlr.collections.List;


public interface StationCleansedDataRepository extends CrudRepository <StationCleansedData,StationPKey>{	

	@Query(value="select * FROM mdms_station.station_uncleansed_data where  station_code=?1", nativeQuery = true)
	StationCleansedData findByStncode(String stationdatadcm);
	
	@Query(value="select station_code  from mdms_station.station_cleansed_data where station_code=?1",nativeQuery=true)
	String   checkStnCodeExist(String stncode);
	
	
	


	
}


