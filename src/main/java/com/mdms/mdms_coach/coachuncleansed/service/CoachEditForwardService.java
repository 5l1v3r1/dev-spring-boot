package com.mdms.mdms_coach.coachuncleansed.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;



@Service
public class CoachEditForwardService {
	
	Logger logger=LoggerFactory.getLogger(CoachEditForwardService.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean editForwardCoach() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<String> getCoachesByDepot() {
		 final String getCoachIdsByDepot = "SELECT count(*) FROM mdms_common_schema.rbs_data_latest";
		    final List<String> coachIds = jdbcTemplate.queryForList(getCoachIdsByDepot, String.class);
		return coachIds;
	}

}
