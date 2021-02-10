package com.mdms.loco.locouncleansed.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;

public interface LocoUncleansedDataElectricRepository extends CrudRepository <LocoUncleansedDataElectric,Long> {

	@Query(value="SELECT * FROM  mdms_loco.loco_uncleansed_data WHERE loco_no=?1 AND record_status='O' AND status='D' OR Status='R' ",nativeQuery=true)
	List<LocoUncleansedDataElectric> getDraftLoco(int elno);
	
	@Query(value="SELECT * FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_shed=?1 AND status='U' AND record_status='O'",nativeQuery=true)
	List<LocoUncleansedDataElectric> getUnapprovedLoco(String eshedid);
	
	@Query(value="SELECT * FROM  mdms_loco.loco_uncleansed_data WHERE  status='D' OR status='U'",nativeQuery=true)
	List<LocoUncleansedDataElectric> getAllShedData();
	
	@Query(value="DELETE   FROM  mdms_loco.loco_uncleansed_data WHERE loco_no=?1 ",nativeQuery=true)
	int  deletedraftloco(int elocono);
	
	@Transactional
	@Modifying
	@Query(value ="UPDATE mdms_loco.loco_uncleansed_data SET loco_type=?1,loco_manufacturer=?2, loco_control_type=?3, loco_permanent_domain=?4,loco_receiving_date=?5, loco_commissioning_date=?6,"
			+ " loco_auxilary=?7,loco_traction_motor_type=?8, loco_owning_zone=?9,"
			+ " loco_owning_shed=?10, loco_boogie_type=?11, loco_lease_type=?12,"
			+ " loco_brake_type=?13, loco_brake_sub_type=?14, loco_cabin_ac=?15, "
			+ "loco_entry_date=?16, is_gps_enabled=?17, status=?18,"
			+ "remarks=?19, loco_hotel_load=?20, flag_type=?21 WHERE loco_no=?22",nativeQuery=true)
	int updateEDraftRecord(String var1,String var2,String var3,String var4,Date var5,Date var6,String var7,String var8,String var9,String var10,  String var11,String var12,String var13,String var14,String var15,Date var16,String var17,String var18,String var19,String var20,String var21, int locono);	
 	

	@Transactional
	@Modifying
	@Query(value="UPDATE mdms_loco.loco_uncleansed_data SET status='A' WHERE loco_no =?1", nativeQuery=true)
	int updatestatus(int locono);

	
	@Transactional
	@Modifying
	@Query(value="\r\n" + 
			"	UPDATE mdms_loco.loco_uncleansed_data SET  loco_auxilary=?2,loco_boogie_type=?3, loco_brake_sub_type=?4, loco_brake_type=?5,\r\n" + 
			"	loco_cabin_ac=?6, loco_commissioned_shed_id=?7,loco_control_type=?8,loco_commissioning_date=?9,loco_entry_date=?10,loco_hotel_load=?11,\r\n" + 
			"	loco_manufacturer=?12,is_gps_enabled=?13,flag_type=?14,status=?15, user_id=?16, txn_date=?17 WHERE loco_no=?1", nativeQuery=true)
	int updateWithElectricLocoShedData(String locoAuxiliaryOutput, String locoBoogieType, String locoBrakeSubtype,
			String locoBrakeType, String locoCabac, String locoCommissionedShedId, String locoControlType,
			Date locoDateOfCommision, Date locoEntryDate, String locoHotelLoad,String locoManfacturer,String isGPSEnabled,String flagtype,
			String status,String userid,Date txndate,int locono);
	
	
	
}
