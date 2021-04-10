package com.mdms.mdms_station.stationuncleansed.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.mdms_station.stationuncleansed.model.StationCleansedData;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedData;
import com.mdms.mdms_station.stationuncleansed.repository.MStationJunctionRepository;
import com.mdms.mdms_station.stationuncleansed.repository.StationCleansedDataRepository;
import com.mdms.mdms_station.stationuncleansed.repository.StationUncleansedDataRepository;

// Shilpi 09-04-2021
@Service
public class StationApproveService {
	
	@Autowired	
	StationCleansedDataRepository stn_clnsd_repo;
	
public StationCleansedData getTotalCleansedStationHyperDivisionWise(StationCleansedData division_code) throws Exception
{
	String divcode=division_code.getDivision_code();
	return stn_clnsd_repo.getTotalCleansedStationHyperDivisionWise(divcode);
}
}
