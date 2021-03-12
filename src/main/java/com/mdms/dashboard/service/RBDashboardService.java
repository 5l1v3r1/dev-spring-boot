package com.mdms.dashboard.service;

import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import com.mdms.app.mgmt.repository.UserProfileRegistrationRepository;

@Service
public class RBDashboardService {
	 Logger logger=LoggerFactory.getLogger(RBDashboardService.class);
	@Autowired
	UserProfileRegistrationRepository user_repo;
	private JdbcTemplate jdbcTemplate;
	public HashMap<String, Integer> getRegtrdCount() 
	{logger.info("Service : RBDashboardService || Method: getRegtrdCount");

	 HashMap<String, Integer> map = new HashMap<>();

		
		 try {
				final String station="SELECT count(*) FROM loco.electric_loco_master_approved WHERE cleansed_uid is not null GROUP BY loco_owning_shed";
				final int shedwiserecords= (int)jdbcTemplate.queryForObject(station,Integer.class);

	       map.put("shedwiserecords",shedwiserecords); 
			    return map;
			 }
			    catch(Exception e) {
			    	logger.error("Service : ElectricLocoDashboardService || Method: getCleansedElectricLocoshedwise|| Exception : " +e.getMessage());
					e.getMessage();
					return null;
			    }
	}
	
}
