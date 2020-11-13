package com.mdms.loco.locouncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.loco.locouncleansed.model.MLocoShed;



public interface MLocoShedRepository extends CrudRepository <MLocoShed,Long>{
	

	@Query(value="SELECT * FROM mdms_loco.m_loco_shed where shed_flag='E'",nativeQuery=true)
	List<MLocoShed> findAll();

	@Query(value="SELECT * FROM mdms_loco.m_loco_shed where shed_flag='D'",nativeQuery=true)
	List<MLocoShed> findDShed();

	
	@Query(value="select zone_code FROM mdms_loco.m_loco_shed WHERE shed_code=?1",nativeQuery=true)	
	String findzone(String shedcode);	
	

}
