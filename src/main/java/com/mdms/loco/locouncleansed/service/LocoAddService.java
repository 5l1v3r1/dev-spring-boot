package com.mdms.loco.locouncleansed.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.loco.locouncleansed.model.LocoUncleansedData;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataAddNewLoco;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
import com.mdms.loco.locouncleansed.repository.LocoUncleansedDataElectricRepository;
import com.mdms.loco.locouncleansed.repository.LocoUncleansedDataRepository;
@Service
public class LocoAddService {
@Autowired
private LocoUncleansedDataRepository obj_dieselocoaddrepo;

@Autowired
private LocoUncleansedDataElectricRepository obj_electriclocorepo;
@Autowired
private LocoUncleansedDataElectricRepository obj_eleclocoaddrepo;

	
public String saveDieselBoardZonalData(LocoUncleansedDataAddNewLoco dieselLocoBoardZonal) {	
	try {
	String returnValue=null;	
	
	int locoNo = dieselLocoBoardZonal.getLoco_no();
	String locoPermanentDomain = dieselLocoBoardZonal.getLoco_permanent_domain();
	String locoType = dieselLocoBoardZonal.getLoco_type();
	String locoOwningZone = dieselLocoBoardZonal.getLoco_owning_zone();
	String locoOwningDivision = dieselLocoBoardZonal.getLoco_owning_division();
	Date locoMfgDt=dieselLocoBoardZonal.getLoco_manufacturing_date();
	String locOwningShed = dieselLocoBoardZonal.getLoco_owning_shed();
	String locoManufacturer=dieselLocoBoardZonal.getLoco_manufacturer();
	String locoLeasetype = dieselLocoBoardZonal.getLoco_lease_type();
	long locoInitialCost = dieselLocoBoardZonal.getLoco_initial_cost();
	long locoPOHCost = dieselLocoBoardZonal.getLoco_poh_cost();
String tractionCode=dieselLocoBoardZonal.getLoco_traction_code();
String gaugeType=dieselLocoBoardZonal.getLoco_gauge_type();
Long locoHaulingPower=dieselLocoBoardZonal.getLoco_hauling_power();
String locoMfgCountry=dieselLocoBoardZonal.getLoco_manufacturing_country();
	String status = dieselLocoBoardZonal.getStatus();
	String uid = dieselLocoBoardZonal.getUser_id();
	String recordstatus=dieselLocoBoardZonal.getRecord_status();
	Date locoEntryDt=dieselLocoBoardZonal.getLoco_entry_date();
	Date locotxndate=dieselLocoBoardZonal.getTxn_date();
	String remarks=dieselLocoBoardZonal.getRemarks();
	String locoflag=dieselLocoBoardZonal.getLoco_flag();
obj_dieselocoaddrepo.saveDieselBoardZonalLocoData(locoNo, locoPermanentDomain,
			locoType, locoOwningZone, locoOwningDivision, locoMfgDt, locOwningShed,locoManufacturer, locoLeasetype,
			locoInitialCost, locoPOHCost,tractionCode,gaugeType,locoHaulingPower,locoMfgCountry,locoEntryDt,recordstatus,status,uid,locotxndate,remarks,locoflag);
 returnValue = "Record saved as draft";
	return returnValue;
	}
	catch(Exception e){
		
		System.out.println(e);
		return "Failed To Saved Record";
	}
	
}

public String updateDieselBoardZonalData(LocoUncleansedDataAddNewLoco dieselLocoBoardZonal) {	
	try {
	String returnValue=null;
	String locoPermanentDomain = dieselLocoBoardZonal.getLoco_permanent_domain();
	String locoType = dieselLocoBoardZonal.getLoco_type();
	String locoOwningZone = dieselLocoBoardZonal.getLoco_owning_zone();
	String locoOwningDivision = dieselLocoBoardZonal.getLoco_owning_division();
	Date locoMfgDt=dieselLocoBoardZonal.getLoco_manufacturing_date();
	String locOwningShed = dieselLocoBoardZonal.getLoco_owning_shed();
	String locoManufacturer=dieselLocoBoardZonal.getLoco_manufacturer();
	String locoLeasetype = dieselLocoBoardZonal.getLoco_lease_type();
	long locoInitialCost = dieselLocoBoardZonal.getLoco_initial_cost();
	long locoPOHCost = dieselLocoBoardZonal.getLoco_poh_cost();
String tractionCode=dieselLocoBoardZonal.getLoco_traction_code();
String gaugeType=dieselLocoBoardZonal.getLoco_gauge_type();
Long locoHaulingPower=dieselLocoBoardZonal.getLoco_hauling_power();
String locoMfgCountry=dieselLocoBoardZonal.getLoco_manufacturing_country();
int locoNo = dieselLocoBoardZonal.getLoco_no();
	String status = dieselLocoBoardZonal.getStatus();	
	String uid=dieselLocoBoardZonal.getUser_id();
	Date locotxndate=dieselLocoBoardZonal.getTxn_date();	
obj_dieselocoaddrepo.updateDieselBoardZonalRecord( locoPermanentDomain,
			locoType, locoOwningZone, locoOwningDivision, locoMfgDt, locOwningShed,locoManufacturer, locoLeasetype,
			locoInitialCost, locoPOHCost,tractionCode,gaugeType,locoHaulingPower,locoMfgCountry,status,uid,locotxndate,locoNo);
 returnValue = "Record Approved Sucessfully";
	return returnValue;
	}
	catch(Exception e){
		
		System.out.println(e);
		return "Failed to Approved";
	}
	
}

public String saveElectricBoardZonalData(LocoUncleansedDataAddNewLoco electricLocoBoardZonal) {	
	try {
	String returnValue=null;	
	
	int locoNo = electricLocoBoardZonal.getLoco_no();
	String locoPermanentDomain = electricLocoBoardZonal.getLoco_permanent_domain();
	String locoType = electricLocoBoardZonal.getLoco_type();
	String locoOwningZone = electricLocoBoardZonal.getLoco_owning_zone();
	String locoOwningDivision = electricLocoBoardZonal.getLoco_owning_division();
	Date locoMfgDt=electricLocoBoardZonal.getLoco_manufacturing_date();
	String locOwningShed = electricLocoBoardZonal.getLoco_owning_shed();
	String locoManufacturer=electricLocoBoardZonal.getLoco_manufacturer();
	String locoLeasetype = electricLocoBoardZonal.getLoco_lease_type();
	long locoInitialCost = electricLocoBoardZonal.getLoco_initial_cost();
	long locoPOHCost = electricLocoBoardZonal.getLoco_poh_cost();
	Date locoRecdDt=electricLocoBoardZonal.getLoco_receiving_date();

	String status = electricLocoBoardZonal.getStatus();
	String uid = electricLocoBoardZonal.getUser_id();	
	String recordstatus=electricLocoBoardZonal.getRecord_status();
	Date locoEntryDt=electricLocoBoardZonal.getLoco_entry_date();
	Date locotxndate=electricLocoBoardZonal.getTxn_date();
	String remarks=electricLocoBoardZonal.getRemarks();
	String locoflag=electricLocoBoardZonal.getLoco_flag();	
obj_dieselocoaddrepo.saveElectricBoardZonalData(locoNo, locoPermanentDomain, locoType, locoOwningZone,
		locoOwningDivision, locoMfgDt, locOwningShed, locoLeasetype, locoInitialCost, locoPOHCost, locoRecdDt,locoEntryDt,recordstatus,status,uid,locotxndate,remarks,locoflag);
 returnValue = "Reocrd Saved Sucessfully";
	return returnValue;
	}
	catch(Exception e){
		
		System.out.println(e);
		return "Failed To Saved Record";
	}
	
}

public String updateElectricBoardZonalData(LocoUncleansedDataAddNewLoco updateelectricLocoBoardZonal) {	
	try {
	String returnValue=null;
	String locoPermanentDomain = updateelectricLocoBoardZonal.getLoco_permanent_domain();
	String locoType = updateelectricLocoBoardZonal.getLoco_type();
	String locoOwningZone = updateelectricLocoBoardZonal.getLoco_owning_zone();
	String locoOwningDivision = updateelectricLocoBoardZonal.getLoco_owning_division();
	Date locoMfgDt=updateelectricLocoBoardZonal.getLoco_manufacturing_date();
	String locOwningShed = updateelectricLocoBoardZonal.getLoco_owning_shed();
	String locoManufacturer=updateelectricLocoBoardZonal.getLoco_manufacturer();
	String locoLeasetype = updateelectricLocoBoardZonal.getLoco_lease_type();
	long locoInitialCost = updateelectricLocoBoardZonal.getLoco_initial_cost();
	long locoPOHCost = updateelectricLocoBoardZonal.getLoco_poh_cost();
	Date locoRecdDt=updateelectricLocoBoardZonal.getLoco_receiving_date();
	String status = updateelectricLocoBoardZonal.getStatus();
	String uid = updateelectricLocoBoardZonal.getUser_id();		
	Date locotxndate=updateelectricLocoBoardZonal.getTxn_date();
	int locoNo = updateelectricLocoBoardZonal.getLoco_no();		
obj_dieselocoaddrepo.updateElectricBoardZonalRecord(locoPermanentDomain, locoType, locoOwningZone,
		locoOwningDivision, locoMfgDt, locOwningShed, locoRecdDt,locoLeasetype, locoInitialCost, locoPOHCost, status,uid,locotxndate,locoNo);
 returnValue = "Record Approved Sucessfully";
	return returnValue;
	}
	catch(Exception e){
		
		System.out.println(e);
		return "Failed To Approve Record";
	}
	
}
public boolean checkloconoexist(int locono) {
	
	int tmp= obj_dieselocoaddrepo.checklocoNoExist(locono); 
	if(tmp==0)
	{
		return false;
	}
	  
	else
	    
	    {
	   
	    	return true;
	    }
		
	    

}


// service use to update diesel  shed attribute for new add loco- for save as draft as well as forward to unapproved record 
public String updateDieselShedData(LocoUncleansedDataAddNewLoco dieselLocoNewShedUser) {	
	try {
	String returnValue=null;	     	
	String locoBoogieType = dieselLocoNewShedUser.getLoco_boogie_type();
	String locoCommissionedShedId = dieselLocoNewShedUser.getLoco_commissioning_shed_id();
	String locoControlType = dieselLocoNewShedUser.getLoco_control_type();
	Date locoDateOfCommision = dieselLocoNewShedUser.getLoco_commissioning_date();
	Date locoEntryDate = dieselLocoNewShedUser.getLoco_entry_date();
	String locoManfacturer = dieselLocoNewShedUser.getLoco_manufacturer();
	String locoGPSEnableflag = dieselLocoNewShedUser.getIs_gps_enabled();
	String flagtype=dieselLocoNewShedUser.getFlag_type();
	String locoTractionMotorType = dieselLocoNewShedUser.getLoco_traction_motor_type();
	String axleload = dieselLocoNewShedUser.getLoco_axle_load();
	String axleloadunit=dieselLocoNewShedUser.getLoco_axle_load_unit();
	Date locorecddt=dieselLocoNewShedUser.getLoco_receiving_date();
	String status = dieselLocoNewShedUser.getStatus();	
	String uid=dieselLocoNewShedUser.getUser_id();
	Date locotxndate=dieselLocoNewShedUser.getTxn_date();	
	int locoNo = dieselLocoNewShedUser.getLoco_no();
obj_dieselocoaddrepo.updateWithDieselLocoShedData( locoBoogieType,
locoCommissionedShedId, locoControlType,locoDateOfCommision,locoEntryDate,locoManfacturer,
locoGPSEnableflag, flagtype,locoTractionMotorType ,axleload,axleloadunit,locorecddt,
		status,uid,locotxndate,locoNo);
 returnValue = "Record Saved Sucessfully";
	return returnValue;
	}
	catch(Exception e){
		
		System.out.println(e);
		return "Failed to Saved";
	}
	
}

//service use to update electric  shed attribute for new add loco- for save as draft as well as forward to unapproved record 
public String updateElectricShedData(LocoUncleansedDataElectric electricLocoNewShedUser) {	
	try {
	String returnValue=null;
	String locoAuxiliaryOutput = electricLocoNewShedUser.getElec_locoAuxiliaryOutput();
	String locoBoogieType = electricLocoNewShedUser.getElec_locoBoogieType();
	String locoBrakeSubtype = electricLocoNewShedUser.getElec_locoBrakeSubtype();
	String locoBrakeType = electricLocoNewShedUser.getElec_locoBrakeType();
	String locoCabac = electricLocoNewShedUser.getElec_locoCabac();
	String locoCommissionedShedId = electricLocoNewShedUser.getElec_locoOwningShed();
	String locoControlType = electricLocoNewShedUser.getElec_locoControlType();
	Date locoDateOfCommision = electricLocoNewShedUser.getElec_locoDateOfCommision();
	Date locoEntryDate = electricLocoNewShedUser.getElec_locoEntryDate();
	String locoHotelLoad = electricLocoNewShedUser.getElec_locoHotelLoad();	
	String locoManfacturer = electricLocoNewShedUser.getElec_locoManfacturer();
	String locoGPSEnableflag = electricLocoNewShedUser.getIsGPSEnabled();
	String locoTractionMotorType = electricLocoNewShedUser.getElec_locoTractionMotorType();	

	String status = electricLocoNewShedUser.getElec_Status();	
	String uid=electricLocoNewShedUser.getUserid();
	Date locotxndate=electricLocoNewShedUser.getTxndate();	
	int locoNo = electricLocoNewShedUser.getElec_locoNo();
	obj_eleclocoaddrepo.updateWithElectricLocoShedData( locoAuxiliaryOutput, locoBoogieType,
		locoBrakeSubtype, locoBrakeType, locoCabac, locoCommissionedShedId, locoControlType,
		locoDateOfCommision, locoEntryDate, locoHotelLoad,
		locoManfacturer, locoGPSEnableflag, locoTractionMotorType,status,uid,locotxndate,locoNo);
 returnValue = "Record Save Sucessfully";
	return returnValue;
	}
	catch(Exception e){
		
		System.out.println(e);
		return "Failed to Save";
	}
	
}

//fetch zonal user  new loco unapproved record 
public List<LocoUncleansedDataElectric> getUnapprovedZonalLocos(LocoUncleansedDataElectric obj_zonalunapproved) {
//		// TODO Auto-generated method stub
		System.out.println("getzonalunapprovedocos");
		String zoneid=obj_zonalunapproved.getElec_locoOwningZone();
		obj_electriclocorepo.getUnapprovedZonalBoardLoco(zoneid);		
		List<LocoUncleansedDataElectric> uncleaseLoco= new ArrayList<>();
		obj_electriclocorepo.getUnapprovedZonalBoardLoco(zoneid)
		.forEach(uncleaseLoco::add);
		System.out.println(" End getzonalunapprovedocos");
		return obj_electriclocorepo.getUnapprovedLoco(zoneid);
	}
}
