package com.mdms.dashboard.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;

@Service
public class SuperUserDashboardService {
	 Logger logger=LoggerFactory.getLogger(SuperUserDashboardService.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public HashMap<String, Integer> getTotalAssets() {
		logger.info("Service : SuperUserDashboardService || Method: getTotalAssets");

 HashMap<String, Integer> map = new HashMap<>();
		 
 try {
		 final String no_stations = "SELECT count(DISTINCT stn_code) FROM mdms_station.station_table_rbs ";
		    final int total_stations = (int)jdbcTemplate.queryForObject(no_stations,Integer.class);

		    final String no_loco = "SELECT count(*) FROM mdms_station.station_table_rbs";
		    final int total_loco = (int)jdbcTemplate.queryForObject(no_loco,Integer.class);
		    final String no_coach = "SELECT count(coach_id) FROM mdms_coach.coach_data_cmm";
		    final int total_coach = (int)jdbcTemplate.queryForObject(no_coach,Integer.class);
//		    final String no_wagon = "SELECT count(*) FROM mdms_station.station_table_rbs";
//		    final int total_wagon = (int)jdbcTemplate.queryForObject(no_wagon,Integer.class);


		    map.put("total_stations", total_stations);
		    map.put("total_loco", total_loco);
		    map.put("total_coach", total_coach);
//		    map.put("total_wagon", total_wagon);
		    return map;
	}
	  catch(Exception e) {
	    	logger.error("Service : SuperUserDashboardService || Method: getTotalAssets|| Exception : " +e.getMessage());
			e.getMessage();
			return null;
	    }
	}

}
