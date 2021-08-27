package com.mdms.wagon.wagonuncleansed.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdms.wagon.wagonuncleansed.model.WagonDataIrwms;

public interface WagonDataIrwmsRepository extends CrudRepository<WagonDataIrwms,Long> {
	// Developer : ritu - service to fetch IRWMS wagon number based on own_rly and wagon_type  27.8.21
		@Query(value="select vehicleno from mdms_wagon.wagon_data_irwms where owningrly=?1 and vehicletype =?2", nativeQuery=true)
		List<BigInteger> getIrwmsWagonNumber(String ownrly, String wagontype);


}
