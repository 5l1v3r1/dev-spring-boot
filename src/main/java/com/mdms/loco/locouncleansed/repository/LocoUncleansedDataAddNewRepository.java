package com.mdms.loco.locouncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.LocoUncleansedDataAddNewLoco;

public interface LocoUncleansedDataAddNewRepository extends CrudRepository<LocoUncleansedDataAddNewLoco, Long> {

	@Query(value="SELECT loco_flag, loco_no, loco_type, loco_permanent_domain, loco_owning_shed, loco_owning_zone, loco_traction_code, loco_owning_division, loco_manufacturing_date, loco_receiving_date,\r\n" + 
			"loco_initial_cost, loco_poh_cost, loco_lease_type, loco_gauge_type, loco_hauling_power, loco_manufacturing_country, record_status, status, user_id,  txn_date, remarks, loco_entry_date, flag_type, loco_commissioning_date, loco_commissioned_shed_id, loco_axle_load, loco_axle_load_unit, loco_traction_motor_type, loco_boogie_type, loco_control_type, is_gps_enabled, loco_manufacturer,loco_hotel_load,loco_auxilary,loco_brake_type,loco_brake_sub_type,loco_cabin_ac FROM  mdms_loco.loco_uncleansed_data WHERE loco_owning_zone=?1 AND status='ZU' AND record_status='N'",nativeQuery=true)
	List<LocoUncleansedDataAddNewLoco> getUnapprovedZonalBoardLoco(String locozone);
}
