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
	String   checkIfExists(String stncode);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE mdms_station.station_cleansed_data\r\n" + 
			"	SET station_numeric_code=?5, station_name=?6, traffic_type=?7, transhipment_flag=?8, station_class=?9, junction_flag=?10, interchange_flag=?11, state=?12, pincode=?13, district=?14, tehsil=?15, "+
			 "station_short_name=?16,interlocking_standard=?17, working_division=?18,  weight_bridge=?19, siding=?20, booking_type=?21, cmi_status=?22,  txn_date_cmi=?23 ,booking_resource=?24 \r\n" + 
			"	WHERE user_id_cmi =?1 AND station_code =?2 AND station_valid_from =?3  AND station_valid_upto=?4",nativeQuery = true)
	int updateCleansedDraftCmi(String userid, String cmi_station_code, Date cmi_valid_from, Date cmi_valid_upto , long numeric_code , String station_name,
			String traffic, String transhipment , String stationclass , String junctionf, String interchngf , String state, String pincode , String district , String tehsil , 
			String shortname, String intrlckstd , String wrkngdvsn , int weighbridge, String siding ,  String bookingtype , String cmistatus, Date dt ,String booking_resource );

	
	@Modifying
	@Transactional
	@Query(value="UPDATE mdms_station.station_cleansed_data SET cmi_status='U' \r\n" + 
			"	where station_code=?1",nativeQuery = true)
	int forwardByCMI(String station_code);

	
}


