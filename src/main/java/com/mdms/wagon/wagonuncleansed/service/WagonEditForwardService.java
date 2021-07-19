package com.mdms.wagon.wagonuncleansed.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdms.wagon.wagonuncleansed.model.WagonUncleansedData;
import com.mdms.wagon.wagonuncleansed.repository.WagonUncleansedRepository;
@Service
public class WagonEditForwardService {
@Autowired
private WagonUncleansedRepository repo_uncleansed;

public List<WagonUncleansedData> getWagonCleansedRecord(WagonUncleansedData objwagon)
{ 
String basedepo= objwagon.getBase_depo_station();
String status=objwagon.getStatus();
repo_uncleansed.getWagonCleansedRecord(basedepo,status);
List<WagonUncleansedData> temp =new ArrayList<>();
repo_uncleansed.getWagonCleansedRecord(basedepo,status).forEach(temp::add);
return repo_uncleansed.getWagonCleansedRecord(basedepo,status);
	}
}
