package com.mdms.mdms_station.stationuncleansed.repository;

import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.DashBoardStationCountDivisionWiseModel;
import com.mdms.mdms_station.stationuncleansed.model.StationCleansedData;
import com.mdms.mdms_station.stationuncleansed.model.StationPKey;

import antlr.collections.List;


public interface StationCleansedDataRepository extends CrudRepository <StationCleansedData,StationPKey>{	

	@Query(value="select * FROM mdms_station.station_uncleansed_data where  station_code=?1", nativeQuery = true)
	StationCleansedData findByStncode(String stationdatadcm);
	
	@Query(value="select station_code  from mdms_station.station_cleansed_data where station_code=?1",nativeQuery=true)
	String   checkStnCodeExist(String stncode);
	


	
	  @Query(value="select division_code, count(*) as cleansed_count " + 
		  		"from mdms_station.station_cleansed_data where zone_code=?1 group by division_code",nativeQuery=true)
	  Collection<DashBoardStationCountDivisionWiseModel> getTotalCleansedStationCountZoneDivisionWise(String zone_code);

	  
// Shilpi 23-03-2021
	 @Query(value="select zone_code,division_code, count(*) as cleansed_count " + 
		  		"from mdms_station.station_cleansed_data where zone_code=?1 group by 1,2 ORDER BY 2",nativeQuery=true)
	  Collection<DashBoardStationCountDivisionWiseModel> getTotalCleansedStationCountZoneWise(String zone_code);
	 
	 //Shilpi 04-03-2021
	  
	  @Query(value="select division_code, count(*) as cleansed_count " + 
		  		"from mdms_station.station_cleansed_data where division_code=?1 group by division_code",nativeQuery=true)
	  Collection<DashBoardStationCountDivisionWiseModel> getTotalCleansedStationCountSingleDivisionWise(String division_code);
 
	  //end changes
	


	//Shilpi 09-04-2021 zonal hyperlink
	  
	  @Query(value="select * from mdms_station.station_cleansed_data where division_code=?1 ",nativeQuery=true)
	  StationCleansedData getTotalCleansedStationHyperDivisionWise(String division_code);

}


