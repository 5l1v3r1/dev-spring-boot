/*Created By : Ritu, 19-07-2021 */
package com.mdms.wagon.wagonuncleansed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.mdms.wagon.wagonuncleansed.model.WagonUncleansedData;
public interface WagonUncleansedRepository extends CrudRepository<WagonUncleansedData,Long>{	
	// Developer : ritu - service to fetch cleansed record based on status (D/R/U) 19.5.21
	@Query(value="select * from mdms_wagon.wagon_uncleansed_data where base_depo_station=?1 and status=?2", nativeQuery=true)
	List<WagonUncleansedData> getWagonCleansedRecord(String basedepo , String status);


}
