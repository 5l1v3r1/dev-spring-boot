package com.mdms.wagon.wagonuncleansed.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.wagon.wagonuncleansed.model.WagonUncleansedData;
import com.mdms.wagon.wagonuncleansed.repository.MWagonOwningRlyRepository;
@Service
public class MWagonSubMasterService {
	@Autowired
	private MWagonOwningRlyRepository obj_own_rlyrepo ;
	
	public List<String> getWagonOwningRlycode()
	{ 
		obj_own_rlyrepo.getWagonOwningRlycode();
	List<WagonUncleansedData> temp =new ArrayList<>();
	obj_own_rlyrepo.getWagonOwningRlycode();
	return obj_own_rlyrepo.getWagonOwningRlycode();
		}
}
