package com.mdms.loco.locouncleansed.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.LocoUncleansedData;

public interface LocoUncleansedDataRepository extends CrudRepository<LocoUncleansedData,Long>{

	@Query(value="select  domain_type_name from mdms_loco.m_loco_domain_type", nativeQuery=true)
	List<String> findnomitype();

	@Query(value="select  control_type_name from mdms_loco.m_loco_control_type", nativeQuery=true)
	List<String> findctrltype();
	
	@Query(value="select  mfd_name from mdms_loco.m_loco_manufacturer", nativeQuery=true)
	List<String> findlocomake();
	
	@Transactional
	@Modifying
	@Query(value ="UPDATE mdms_loco.loco_uncleansed_data\r\n" + 
			"	SET loco_type=?1, loco_commissioning_date=?2, loco_owning_shed=?3, loco_manufacturer=?4,  loco_receiving_date=?5, "
			+ "loco_axle_load=?6, loco_hauling_power=?7, loco_owning_zone=?8, loco_traction_code=?9, "
			+ "loco_brake_type=?10, loco_control_type=?11, loco_entry_date=?12, loco_permanent_domain=?13, "
			+ "loco_gauge_type=?14, loco_traction_motor_type=?15, is_gps_enabled=?16, loco_lease_type=?17, "
			+ "status=?18, remarks=?19,"
			+ " loco_manufacturing_country=?20,loco_manufacturing_date=?21 , flag_type=?22 WHERE loco_no=?23",nativeQuery=true)
	int updateDslDraftRecord(String var1,Date var2,String var3,String var4, Date var5,double var6,String var7,String var8,String var9,  String var10,String var11,Date var12,String var13,String var14,String var15,Boolean var16,String var17,String var18, String var19 ,String var20, Date var21, String var22, int locono);	
 
	
}
