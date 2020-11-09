package com.mdms.mdms_station.stationuncleansed.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.StationPKey;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedData;

public interface StationUncleansedDataRepository extends CrudRepository <StationUncleansedData,StationPKey>{
	
	@Query(value="select * FROM mdms_station.station_uncleansed_data where user_id_cmi=?1 and cmi_status='D' and station_code=?2", nativeQuery = true)
	StationUncleansedData getDraftFromUncleansedCmi(String useridcmi, String station_code);

}