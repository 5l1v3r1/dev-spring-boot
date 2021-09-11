package com.mdms.wagon.wagonuncleansed.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.wagon.wagonuncleansed.model.WagonUncleansedData;
import com.mdms.wagon.wagonuncleansed.repository.MWagonOwningRlyRepository;
import com.mdms.wagon.wagonuncleansed.repository.MWagonTypeRepository;
@Service
public class MWagonSubMasterService {
	@Autowired
	private MWagonOwningRlyRepository obj_own_rlyrepo ;
	
	@Autowired
	private MWagonTypeRepository obj_wgntype_repo ;
	
	
	public List<String> getWagonOwningRlycode()
	{ 
		obj_own_rlyrepo.getWagonOwningRlycode();
	List<String> temp =new ArrayList<>();
	obj_own_rlyrepo.getWagonOwningRlycode();
	return obj_own_rlyrepo.getWagonOwningRlycode();
		}
	
	
	
	public List<String> getWagonTypecode()
	{ 
		obj_wgntype_repo.getWagonTypecode();
	List<String> temp =new ArrayList<>();
	obj_wgntype_repo.getWagonTypecode();
	return obj_wgntype_repo.getWagonTypecode();
		}
}
