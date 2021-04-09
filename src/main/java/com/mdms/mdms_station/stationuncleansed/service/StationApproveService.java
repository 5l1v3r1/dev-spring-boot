package com.mdms.mdms_station.stationuncleansed.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mdms.mdms_station.stationuncleansed.model.StationCleansedData;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedData;
import com.mdms.mdms_station.stationuncleansed.repository.MStationJunctionRepository;
import com.mdms.mdms_station.stationuncleansed.repository.StationCleansedDataRepository;
import com.mdms.mdms_station.stationuncleansed.repository.StationUncleansedDataRepository;

// Shilpi 09-04-2021

public class StationApproveService {
	
	@Autowired
	StationCleansedDataRepository stn_cln;

	public List<StationCleansedDataRepository> getTotalCleansedStationHyperDivisionWise( StationCleansedData objelecmodel) {
		System.out.println("getUncleanstnHyperDivision");
		String division_code=objelecmodel.getDivision_code();
		stn_cln.getTotalCleansedStationHyperDivisionWise(division_code);
		List<StationUncleansedDataRepository> uncleasependingstn= new ArrayList<>();
		stn_cln.getTotalCleansedStationHyperDivisionWise(division_code)
		.forEach(uncleasependingstn::add);
		System.out.println(" End getuncleansedpending");
		return stn_unclsnd_repo.getPendingApprovalStationHyperDivisionWise(division_code);
	}
}
