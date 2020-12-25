package com.mdms.dashboard.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.DashBoardStationCountDivisionWiseModel;
import com.mdms.dahsboard.model.DashboardStationModel;

public interface StationDashboardRepo  {
	  @Query(value="SELECT division_code,count(*) as total_division_count FROM mdms_masters.m_division group by division_code",nativeQuery=true)
	  Collection<DashBoardStationCountDivisionWiseModel> getTotalStationCountDivisionWise();

	  
	  @Query(value=" select division_code,count(*) as uncleansed_count from (select distinct  division_code, stn_code FROM mdms_station.station_table_rbs as a join mdms_masters.m_division as b \r\n" + 
	  		"	  				on a.div_ser_no= b.division_sr_no except select division_code,station_code FROM mdms_station.station_uncleansed_data) AS uncleansed group by division_code\r\n" + 
	  		"	  	",nativeQuery=true)
	  Collection<DashBoardStationCountDivisionWiseModel> getUncleansedStationCountDivisionWise();

}
