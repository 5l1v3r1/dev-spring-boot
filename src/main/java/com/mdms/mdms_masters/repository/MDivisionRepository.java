package com.mdms.mdms_masters.repository;

import org.springframework.data.repository.CrudRepository;
import com.mdms.mdms_masters.model.MDivision;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface MDivisionRepository extends CrudRepository<MDivision,String> {

	
	@Query(value="Select * from mdms_masters.m_division", nativeQuery = true)
	List<MDivision> getAllDivision();
		
	@Query(value="Select division_sr_no from mdms_masters.m_division where division_code=?1 ", nativeQuery = true)
	int getDivsionCode(String division);
	
	
}
