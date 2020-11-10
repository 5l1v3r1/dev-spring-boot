package com.mdms.mdms_station.stationuncleansed.repository;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.mdms_station.stationuncleansed.model.StationPKey;
import com.mdms.mdms_station.stationuncleansed.model.StationUncleansedData;

public interface StationUncleansedDataRepository extends CrudRepository <StationUncleansedData,StationPKey>{
	
	@Query(value="select * FROM mdms_station.station_uncleansed_data where user_id_cmi=?1 and cmi_status='D' and station_code=?2", nativeQuery = true)
	StationUncleansedData getDraftFromUncleansedCmi(String useridcmi, String station_code);

	@Modifying
	@Transactional
	@Query(value="UPDATE mdms_station.station_uncleansed_data\r\n" + 
			"	SET station_numeric_code=?5, station_name=?6, traffic_type=?7, transhipment_flag=?8, station_class=?9, junction_flag=?10, interchange_flag=?11, state=?12, pincode=?13, district=?14, tehsil=?15, "+
			 "station_short_name=?16,interlocking_standard=?17, working_division=?18,  weight_bridge=?19, siding=?20, booking_type=?21, cmi_status=?22,  txn_date_cmi=?23 \r\n" + 
			"	WHERE user_id_cmi =?1 AND station_code =?2 AND station_valid_from =?3  AND station_valid_upto=?4",nativeQuery = true)
	int updateDraft(String userid, String cmi_station_code, Date cmi_valid_from, Date cmi_valid_upto , long numeric_code , String station_name,
			String traffic, String transhipment , String stationclass , String junctionf, String interchngf , String state, String pincode , String district , String tehsil , 
			String shprtname, String intrlckstd , String wrkngdvsn , int weighbridge, String siding ,  String bookingtype , String cmistatus, Date dt );

}

