package com.mdms.loco.locouncleansed.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.dahsboard.model.DashBoardLocoCountShedWiseModel;
import com.mdms.dahsboard.model.DashBoardStationCountDivisionWiseModel;
import com.mdms.loco.locouncleansed.model.LocoDataFois;
public interface LocoDataFoisRepository extends CrudRepository<LocoDataFois,Long>{	
	@Query(value="SELECT loco_no FROM  mdms_loco.loco_data_fois WHERE loco_owning_shed_code =?1  AND status IS Null",nativeQuery=true)
	List<Integer> getLocono(String shedid);
	
	@Query(value="SELECT loco_traction_code FROM  mdms_loco.loco_data_fois WHERE loco_no=?1 ",nativeQuery=true)
   	String getLocoTractioncode(int locono);
	
	@Query(value="SELECT * FROM  mdms_loco.loco_data_fois WHERE loco_no=?1 ",nativeQuery=true)
   	List<LocoDataFois> getallLocodata(int locono);
	
	@Transactional	
	@Modifying
	@Query(value="UPDATE   mdms_loco.loco_data_fois SET status='C' WHERE loco_no =?1", nativeQuery=true)
	int updatestatus(int locono);
	
	//update transfer shed detail- loco transfer
    @Transactional
	  @Modifying	  
	  @Query(value="UPDATE  mdms_loco.loco_data_fois SET loco_owning_zone_code=?1 , loco_owning_shed_code=?2 , status='' WHERE loco_no=?3",nativeQuery = true)
      int locoTrfFromElecShed(String zone, String shed, int lno);
    
   @Query(value="SELECT * FROM loco.loco_existing_uncleansed_master_data WHERE loco_traction_code='D' AND  status IS NULL ",nativeQuery=true)
   	List<LocoDataFois> getallDLocoUncleanseddata();

    @Query(value="SELECT * FROM loco.loco_existing_uncleansed_master_data WHERE loco_traction_code='E' AND  status IS NULL ",nativeQuery=true)
   	List<LocoDataFois> getallELocoUncleanseddata();

    @Query(value="SELECT * FROM loco.loco_existing_uncleansed_master_data WHERE loco_owning_shed_code=?1 AND loco_traction_code='D' AND  status IS NULL ",nativeQuery=true)
   	List<LocoDataFois> getDLocoUncleanseddataByShed(String shedid);
    
    @Query(value="SELECT * FROM loco.loco_existing_uncleansed_master_data WHERE loco_owning_shed_code=?1 AND loco_traction_code='E' AND  status IS NULL ",nativeQuery=true)
   	List<LocoDataFois> getELocoUncleanseddataByShed(String shedid);

    // Shilpi 08-03-2021
    
    @Query(value="SELECT loco_owning_shed_code as loco_Owningshed ,count(*) as total_loco_count FROM  mdms_loco.loco_data_fois WHERE loco_owning_shed_code=?1 GROUP BY loco_owning_shed_code",nativeQuery=true)
    Collection<DashBoardLocoCountShedWiseModel> getLocoSingleShed(String shedid);
       
    @Query(value="SELECT loco_owning_shed_code as loco_Owningshed ,count(*) as uncleansed_count FROM  mdms_loco.loco_data_fois WHERE loco_owning_shed_code=?1 and status is null GROUP BY loco_owning_shed_code",nativeQuery=true)
    Collection<DashBoardLocoCountShedWiseModel> getUncleansedLocoSingleShed(String shedid);
    
    //Shilpi 18-03-2021 --FOR ZONE WISE
    
    @Query(value="SELECT loco_owning_zone_code as loco_owning_zone_code, loco_owning_shed_code as loco_Owningshed ,count(*) as total_loco_count FROM  mdms_loco.loco_data_fois WHERE loco_owning_zone_code=?1 GROUP BY loco_owning_zone_code,loco_owning_shed_code ORDER BY 2",nativeQuery=true)
    Collection<DashBoardLocoCountShedWiseModel> getLocoZoneShed(String loco_owning_zone_code);
    
    @Query(value="SELECT loco_owning_zone_code as loco_owning_zone_code, loco_owning_shed_code as loco_Owningshed ,count(*) as uncleansed_count FROM  mdms_loco.loco_data_fois WHERE loco_owning_zone_code=?1 and status is null GROUP BY  loco_owning_zone_code ,loco_owning_shed_code ORDER BY 2 ",nativeQuery=true)
    Collection<DashBoardLocoCountShedWiseModel> getUncleansedLocoZoneShed(String loco_owning_zone_code);
  
}
