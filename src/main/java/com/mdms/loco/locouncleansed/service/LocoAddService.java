package com.mdms.loco.locouncleansed.service;

import java.sql.Date;

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
private LocoUncleansedDataElectricRepository obj_eleclocoaddrepo;

	
public String saveDieselBoardZonalData(LocoUncleansedDataAddNewLoco dieselLocoBoardZonal) {	
	try {
	String returnValue=null;	
	
	int locoNo = dieselLocoBoardZonal.getLocoNo();
	String locoPermanentDomain = dieselLocoBoardZonal.getLocoPermanentDomain();
	String locoType = dieselLocoBoardZonal.getLocoType();
	String locoOwningZone = dieselLocoBoardZonal.getLocoOwningZone();
	String locoOwningDivision = dieselLocoBoardZonal.getLocoOwningDivision();
	Date locoMfgDt=dieselLocoBoardZonal.getLocoMfgDt();
	String locOwningShed = dieselLocoBoardZonal.getLocoOwningShed();
	String locoManufacturer=dieselLocoBoardZonal.getLocoManufacturer();
	String locoLeasetype = dieselLocoBoardZonal.getLocoLeaseType();
	long locoInitialCost = dieselLocoBoardZonal.getLocoInitialCost();
	long locoPOHCost = dieselLocoBoardZonal.getLocoPOHCost();
String tractionCode=dieselLocoBoardZonal.getLocoTractionCode();
String gaugeType=dieselLocoBoardZonal.getLocoGaugeType();
Long locoHaulingPower=dieselLocoBoardZonal.getLocoHaulingPower();
String locoMfgCountry=dieselLocoBoardZonal.getLocoMfgCountry();	
	String status = dieselLocoBoardZonal.getStatus();
	String uid = dieselLocoBoardZonal.getUserid();	
	String recordstatus=dieselLocoBoardZonal.getRecordstatus();
	Date locoEntryDt=dieselLocoBoardZonal.getLocoEntryDate();
	Date locotxndate=dieselLocoBoardZonal.getTxndate();
	String remarks=dieselLocoBoardZonal.getRemarks();
	String locoflag=dieselLocoBoardZonal.getLocoflag();	
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
	String locoPermanentDomain = dieselLocoBoardZonal.getLocoPermanentDomain();
	String locoType = dieselLocoBoardZonal.getLocoType();
	String locoOwningZone = dieselLocoBoardZonal.getLocoOwningZone();
	String locoOwningDivision = dieselLocoBoardZonal.getLocoOwningDivision();
	Date locoMfgDt=dieselLocoBoardZonal.getLocoMfgDt();
	String locOwningShed = dieselLocoBoardZonal.getLocoOwningShed();
	String locoManufacturer=dieselLocoBoardZonal.getLocoManufacturer();
	String locoLeasetype = dieselLocoBoardZonal.getLocoLeaseType();
	long locoInitialCost = dieselLocoBoardZonal.getLocoInitialCost();
	long locoPOHCost = dieselLocoBoardZonal.getLocoPOHCost();
String tractionCode=dieselLocoBoardZonal.getLocoTractionCode();
String gaugeType=dieselLocoBoardZonal.getLocoGaugeType();
Long locoHaulingPower=dieselLocoBoardZonal.getLocoHaulingPower();
String locoMfgCountry=dieselLocoBoardZonal.getLocoMfgCountry();	
int locoNo = dieselLocoBoardZonal.getLocoNo();
	String status = dieselLocoBoardZonal.getStatus();	
	String uid=dieselLocoBoardZonal.getUserid();
	Date locotxndate=dieselLocoBoardZonal.getTxndate();	
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
	String uid = electricLocoBoardZonal.getUserid();	
	int locoNo = electricLocoBoardZonal.getLocoNo();
	String locoPermanentDomain = electricLocoBoardZonal.getLocoPermanentDomain();
	String locoType = electricLocoBoardZonal.getLocoType();
	String locoOwningZone = electricLocoBoardZonal.getLocoOwningZone();
	String locoOwningDivision = electricLocoBoardZonal.getLocoOwningDivision();
	Date locoMfgDt=electricLocoBoardZonal.getLocoMfgDt();
	String locOwningShed = electricLocoBoardZonal.getLocoOwningShed();
	String locoManufacturer=electricLocoBoardZonal.getLocoManufacturer();
	String locoLeasetype = electricLocoBoardZonal.getLocoLeaseType();
	long locoInitialCost = electricLocoBoardZonal.getLocoInitialCost();
	long locoPOHCost = electricLocoBoardZonal.getLocoPOHCost();
	Date locoRecdDt=electricLocoBoardZonal.getLoco_receiving_date();

	String status = electricLocoBoardZonal.getStatus();
	String recordstatus=electricLocoBoardZonal.getRecordstatus();
	Date locoEntryDt=electricLocoBoardZonal.getLocoEntryDate();
	Date locotxndate=electricLocoBoardZonal.getTxndate();
	String remarks=electricLocoBoardZonal.getRemarks();
	String locoflag=electricLocoBoardZonal.getLocoflag();	
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
	String uid = updateelectricLocoBoardZonal.getUserid();	
	int locoNo = updateelectricLocoBoardZonal.getLocoNo();
	String locoPermanentDomain = updateelectricLocoBoardZonal.getLocoPermanentDomain();
	String locoType = updateelectricLocoBoardZonal.getLocoType();
	String locoOwningZone = updateelectricLocoBoardZonal.getLocoOwningZone();
	String locoOwningDivision = updateelectricLocoBoardZonal.getLocoOwningDivision();
	Date locoMfgDt=updateelectricLocoBoardZonal.getLocoMfgDt();
	String locOwningShed = updateelectricLocoBoardZonal.getLocoOwningShed();
	String locoManufacturer=updateelectricLocoBoardZonal.getLocoManufacturer();
	String locoLeasetype = updateelectricLocoBoardZonal.getLocoLeaseType();
	long locoInitialCost = updateelectricLocoBoardZonal.getLocoInitialCost();
	long locoPOHCost = updateelectricLocoBoardZonal.getLocoPOHCost();
	Date locoRecdDt=updateelectricLocoBoardZonal.getLoco_receiving_date();
	String status = updateelectricLocoBoardZonal.getStatus();
	String recordstatus=updateelectricLocoBoardZonal.getRecordstatus();
	Date locoEntryDt=updateelectricLocoBoardZonal.getLocoEntryDate();
	Date locotxndate=updateelectricLocoBoardZonal.getTxndate();
	String remarks=updateelectricLocoBoardZonal.getRemarks();
	String locoflag=updateelectricLocoBoardZonal.getLocoflag();	
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
	String locoBoogieType = dieselLocoNewShedUser.getLocoBoogieType();
	String locoCommissionedShedId = dieselLocoNewShedUser.getLocoCommissionedShedId();
	String locoControlType = dieselLocoNewShedUser.getLocoControlType();
	Date locoDateOfCommision = dieselLocoNewShedUser.getLocoDateOfCommision();
	Date locoEntryDate = dieselLocoNewShedUser.getLocoEntryDate();
	String locoManfacturer = dieselLocoNewShedUser.getLocoManufacturer();
	String locoGPSEnableflag = dieselLocoNewShedUser.getIsGPSEnabled();
	String flagtype=dieselLocoNewShedUser.getFlagType();
	String locoTractionMotorType = dieselLocoNewShedUser.getLocoTractionMotorType();
	String axleload = dieselLocoNewShedUser.getLocoAxleLoad();	
	String axleloadunit=dieselLocoNewShedUser.getLocoAxleLoadUnit();
	Date locorecddt=dieselLocoNewShedUser.getLoco_receiving_date();
	String status = dieselLocoNewShedUser.getStatus();	
	String uid=dieselLocoNewShedUser.getUserid();
	Date locotxndate=dieselLocoNewShedUser.getTxndate();	
	int locoNo = dieselLocoNewShedUser.getLocoNo();	
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


}
