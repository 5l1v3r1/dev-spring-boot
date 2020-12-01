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


	
	@Query(value="select * FROM mdms_station.station_uncleansed_data where user_id_dti=?1 and dti_status='D' and station_code=?2", nativeQuery = true)
	StationUncleansedData getDraftFromUncleansedDti(String useriddti, String station_code);

	@Modifying
	@Transactional
	@Query(value="UPDATE mdms_station.station_uncleansed_data\r\n" + 
			"	SET station_numeric_code=?5, station_name=?6, traffic_type=?7, transhipment_flag=?8, station_class=?9, junction_flag=?10, interchange_flag=?11, state=?12, pincode=?13, district=?14, tehsil=?15, "+
			 "station_short_name=?16,interlocking_standard=?17, working_division=?18,  weight_bridge=?19, siding=?20, booking_type=?21, cmi_status=?22,  txn_date_cmi=?23 , booking_resource=?24 \r\n" + 
			"	WHERE user_id_cmi =?1 AND station_code =?2 AND station_valid_from =?3  AND station_valid_upto=?4",nativeQuery = true)
	int updateDraftCmi(String userid, String cmi_station_code, Date cmi_valid_from, Date cmi_valid_upto , long numeric_code , String station_name,
			String traffic, String transhipment , String stationclass , String junctionf, String interchngf , String state, String pincode , String district , String tehsil , 
			String shprtname, String intrlckstd , String wrkngdvsn , int weighbridge, String siding ,  String bookingtype , String cmistatus, Date dt ,String booking_resource );

	@Query(value="select * FROM mdms_station.station_uncleansed_data where  cmi_status='U' and division_code=?1", nativeQuery = true)
	List<StationUncleansedData>fetchUnapprovedCmiRecords(String division_code);

	@Query(value="select * FROM mdms_station.station_uncleansed_data where  dti_status='U' and division_code=?1", nativeQuery = true)
	List<StationUncleansedData>fetchUnapprovedDtiRecords(String division_code);
	
	
			@Modifying
			@Transactional
			@Query(value="UPDATE mdms_station.station_uncleansed_data SET cmi_status='A' \r\n" + 
					"	where station_code=?1",nativeQuery = true)
	int approvedByDcm(String station_code);

			
			@Modifying
			@Transactional
			@Query(value="UPDATE mdms_station.station_uncleansed_data SET dti_status='A' \r\n" + 
					"	where station_code=?1",nativeQuery = true)
	int approvedByDom(String station_code);
			
			@Modifying
			@Transactional
			@Query(value="UPDATE mdms_station.station_uncleansed_data\r\n" + 
					"	SET gauge_code=?5, station_category=?6, interchange_flag=?7, traction=?8, interlocking_standard=?9, junction_flag=?10, no_of_lines=?11, operating_station_signal=?12 ,  txn_date_dti=?13 ,dti_status=?14" + 
					"	WHERE user_id_dti =?1 AND station_code =?2 AND station_valid_from =?3  AND station_valid_upto=?4",nativeQuery = true)
			int updateDraftDti(String userid, String dti_station_code, Date dti_valid_from, Date dti_valid_upto,String gauge_code, String station_category,
					String interchange_flag , String traction , String interlocking_standard , String junction_flag , String no_of_lines , String operating_station_signal,
					Date date,String dti_status);


			
			

			@Modifying
			@Transactional
			@Query(value="UPDATE mdms_station.station_uncleansed_data\r\n" + 
					"	SET station_numeric_code=?5, station_name=?6, traffic_type=?7, transhipment_flag=?8, station_class=?9, junction_flag=?10, interchange_flag=?11, state=?12, pincode=?13, district=?14, tehsil=?15, "+
					 "station_short_name=?16,interlocking_standard=?17, working_division=?18,  weight_bridge=?19, siding=?20, booking_type=?21, cmi_status=?22,  txn_date_cmi=?23 ,user_id_cmi=?1 , booking_resource=?24 \r\n" + 
					"	WHERE station_code =?2 AND station_valid_from =?3  AND station_valid_upto=?4",nativeQuery = true)
			int updateDraftCmiDti(String userid, String cmi_station_code, Date cmi_valid_from, Date cmi_valid_upto , long numeric_code , String station_name,
					String traffic, String transhipment , String stationclass , String junctionf, String interchngf , String state, String pincode , String district , String tehsil , 
					String shprtname, String intrlckstd , String wrkngdvsn , int weighbridge, String siding ,  String bookingtype , String cmistatus, Date dt , String booking_resource);
		
			@Modifying
			@Transactional
			@Query(value="UPDATE mdms_station.station_uncleansed_data SET gauge_code=?5, station_category=?6, interchange_flag=?7, traction=?8, interlocking_standard=?9, junction_flag=?10, no_of_lines=?11, operating_station_signal=?12 ,  txn_date_dti=?13 , user_id_dti=?1 ,dti_status=?14 " + 
					"	WHERE station_code =?2 AND station_valid_from =?3  AND station_valid_upto=?4",nativeQuery = true)
			int updateDraftDtiCmi(String userid, String dti_station_code, Date dti_valid_from, Date dti_valid_upto,String gauge_code, String station_category,
					String interchange_flag , String traction , String interlocking_standard , String junction_flag , String no_of_lines , String operating_station_signal,
					Date date ,String dti_status);


			
		
	
}


