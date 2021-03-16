package com.mdms.loco.locouncleansed.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.DashBoardLocoCountShedWiseModel;
import com.mdms.loco.locouncleansed.model.LocoApprovedData;


public interface LocoApprovedDataRepository extends CrudRepository<LocoApprovedData,Long>{

	@Query(value="select * from mdms_loco.loco_approved_data where loco_owning_shed=?1 AND status='A'AND record_status='O'",nativeQuery=true)
	List<LocoApprovedData> getApprovedLoco(String eshedid);
	
	@Query(value="SELECT  loco_owning_shed as loco_Owningshed, COUNT(*)  as cleansed_count FROM  mdms_loco.loco_approved_data WHERE loco_owning_shed=?1 AND record_status='O' GROUP BY loco_owning_shed",nativeQuery=true)
	Collection<DashBoardLocoCountShedWiseModel> getLocoApprovedSingleshed(String eshedid);
	

}
