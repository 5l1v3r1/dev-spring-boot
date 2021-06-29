package com.mdms.loco.locouncleansed.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdms.loco.locouncleansed.model.BoardZonalApproval;

//import com.mdms.loco.locouncleansed.model.BoardZonalApproval;

import com.mdms.loco.locouncleansed.model.LocoApprovedData;
import com.mdms.loco.locouncleansed.model.LocoUncleansedData;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataAddNewLoco;
import com.mdms.loco.locouncleansed.model.LocoUncleansedDataElectric;
import com.mdms.loco.locouncleansed.repository.LocoUncleansedDataAddNewRepository;

//import com.mdms.loco.locouncleansed.repository.LocoUncleansedDataAddNewRepository;

import com.mdms.loco.locouncleansed.repository.LocoUncleansedDataElectricRepository;
import com.mdms.loco.locouncleansed.repository.LocoUncleansedDataRepository;

@Service
public class LocoAddService {
	@Autowired
	private LocoUncleansedDataRepository obj_dieselocoaddrepo;

	@Autowired
	private LocoUncleansedDataAddNewRepository obj_LocoNewRepo;
	@Autowired
	private LocoUncleansedDataElectricRepository obj_electriclocorepo;

	public String saveDieselBoardZonalData(LocoUncleansedDataAddNewLoco dieselLocoBoardZonal) {
		try {
			String returnValue = null;

			int locoNo = dieselLocoBoardZonal.getLoco_no();
			String locoPermanentDomain = dieselLocoBoardZonal.getLoco_permanent_domain();
			String locoType = dieselLocoBoardZonal.getLoco_type();
			String locoOwningZone = dieselLocoBoardZonal.getLoco_owning_zone();
			String locoOwningDivision = dieselLocoBoardZonal.getLoco_owning_division();
			Date locoMfgDt = dieselLocoBoardZonal.getLoco_manufacturing_date();
			String locOwningShed = dieselLocoBoardZonal.getLoco_owning_shed();
			String locoManufacturer = dieselLocoBoardZonal.getLoco_manufacturer();
			String locoLeasetype = dieselLocoBoardZonal.getLoco_lease_type();
			long locoInitialCost = dieselLocoBoardZonal.getLoco_initial_cost();
			long locoPOHCost = dieselLocoBoardZonal.getLoco_poh_cost();
			String tractionCode = dieselLocoBoardZonal.getLoco_flag();
			String gaugeType = dieselLocoBoardZonal.getGauge_type();
			Long locoHaulingPower = dieselLocoBoardZonal.getLoco_hauling_power();
			String locoMfgCountry = dieselLocoBoardZonal.getLoco_manufacturing_country();
			String status = dieselLocoBoardZonal.getStatus();
			String uid = dieselLocoBoardZonal.getUser_id();
			String recordstatus = dieselLocoBoardZonal.getRecord_status();
			Date locoEntryDt = dieselLocoBoardZonal.getLoco_entry_date();
			Date locoRecdDate = dieselLocoBoardZonal.getLoco_receiving_date();
			Date locotxndate = dieselLocoBoardZonal.getTxn_date();
			String remarks = dieselLocoBoardZonal.getRemarks();
			String locoflag = dieselLocoBoardZonal.getLoco_flag();
			obj_dieselocoaddrepo.saveDieselBoardZonalLocoData(locoNo, locoPermanentDomain, locoType, locoOwningZone,
					locoOwningDivision, locoMfgDt, locOwningShed, locoManufacturer, locoLeasetype, locoInitialCost,
					locoPOHCost, tractionCode, gaugeType, locoHaulingPower, locoMfgCountry, locoEntryDt, recordstatus,
					status, uid, locotxndate, remarks, locoflag, locoRecdDate);
			returnValue = "Record saved";
			return returnValue;
		} catch (Exception e) {

			System.out.println(e);
			return "Failed To Saved Record";
		}

	}

	public String updateDieselBoardZonalData(LocoUncleansedDataAddNewLoco dieselLocoBoardZonal) {
		try {
			String returnValue = null;
			String locoPermanentDomain = dieselLocoBoardZonal.getLoco_permanent_domain();
			String locoType = dieselLocoBoardZonal.getLoco_type();
			String locoOwningZone = dieselLocoBoardZonal.getLoco_owning_zone();
			String locoOwningDivision = dieselLocoBoardZonal.getLoco_owning_division();
			Date locoMfgDt = dieselLocoBoardZonal.getLoco_manufacturing_date();
			String locOwningShed = dieselLocoBoardZonal.getLoco_owning_shed();
			String locoManufacturer = dieselLocoBoardZonal.getLoco_manufacturer();
			String locoLeasetype = dieselLocoBoardZonal.getLoco_lease_type();
			long locoInitialCost = dieselLocoBoardZonal.getLoco_initial_cost();
			long locoPOHCost = dieselLocoBoardZonal.getLoco_poh_cost();
			String tractionCode = dieselLocoBoardZonal.getLoco_traction_code();
			String gaugeType = dieselLocoBoardZonal.getGauge_type();
			Long locoHaulingPower = dieselLocoBoardZonal.getLoco_hauling_power();
			String locoMfgCountry = dieselLocoBoardZonal.getLoco_manufacturing_country();
			int locoNo = dieselLocoBoardZonal.getLoco_no();
			String status = dieselLocoBoardZonal.getStatus();
			String uid = dieselLocoBoardZonal.getUser_id();
			Date locotxndate = dieselLocoBoardZonal.getTxn_date();
			obj_dieselocoaddrepo.updateDieselBoardZonalRecord(locoPermanentDomain, locoType, locoOwningZone,
					locoOwningDivision, locoMfgDt, locOwningShed, locoManufacturer, locoLeasetype, locoInitialCost,
					locoPOHCost, tractionCode, gaugeType, locoHaulingPower, locoMfgCountry, status, uid, locotxndate,
					locoNo);
			returnValue = "Record Approved Sucessfully";
			return returnValue;
		} catch (Exception e) {

			System.out.println(e);
			return "Failed to Approved";
		}

	}

	public String saveElectricBoardZonalData(LocoUncleansedDataAddNewLoco electricLocoBoardZonal) {
		try {
			String returnValue = null;

			int locoNo = electricLocoBoardZonal.getLoco_no();
			String locoPermanentDomain = electricLocoBoardZonal.getLoco_permanent_domain();
			String locoType = electricLocoBoardZonal.getLoco_type();
			String locoOwningZone = electricLocoBoardZonal.getLoco_owning_zone();
			String locoOwningDivision = electricLocoBoardZonal.getLoco_owning_division();
			Date locoMfgDt = electricLocoBoardZonal.getLoco_manufacturing_date();
			String locOwningShed = electricLocoBoardZonal.getLoco_owning_shed();
			String locoManufacturer = electricLocoBoardZonal.getLoco_manufacturer();
			String locoLeasetype = electricLocoBoardZonal.getLoco_lease_type();
			long locoInitialCost = electricLocoBoardZonal.getLoco_initial_cost();
			long locoPOHCost = electricLocoBoardZonal.getLoco_poh_cost();
			Date locoRecdDt = electricLocoBoardZonal.getLoco_receiving_date();

			String status = electricLocoBoardZonal.getStatus();
			String uid = electricLocoBoardZonal.getUser_id();
			String recordstatus = electricLocoBoardZonal.getRecord_status();
			Date locoEntryDt = electricLocoBoardZonal.getLoco_entry_date();
			Date locotxndate = electricLocoBoardZonal.getTxn_date();
			String remarks = electricLocoBoardZonal.getRemarks();
			String locoflag = electricLocoBoardZonal.getLoco_flag();
			obj_dieselocoaddrepo.saveElectricBoardZonalData(locoNo, locoPermanentDomain, locoType, locoOwningZone,
					locoOwningDivision, locoMfgDt, locOwningShed, locoLeasetype, locoInitialCost, locoPOHCost,
					locoRecdDt, locoEntryDt, recordstatus, status, uid, locotxndate, remarks, locoflag);
			returnValue = "Reocrd Saved Sucessfully";
			return returnValue;
		} catch (Exception e) {

			System.out.println(e);
			return "Failed To Saved Record";
		}

	}

	@Transactional(rollbackOn = Exception.class)
	public String updateElectricBoardZonalData(BoardZonalApproval updateelectricLocoBoardZonal) {

		Date date = new Date();
		try {
			String returnValue = null;
			String locoPermanentDomain = updateelectricLocoBoardZonal.getLoco_permanent_domain();
			String locoType = updateelectricLocoBoardZonal.getLoco_type();
			String locoOwningZone = updateelectricLocoBoardZonal.getLoco_owning_zone();
			String locoOwningDivision = updateelectricLocoBoardZonal.getLoco_owning_division();
			Date locoMfgDt = updateelectricLocoBoardZonal.getLoco_manufacturing_date();
			String locOwningShed = updateelectricLocoBoardZonal.getLoco_owning_shed();
			String locoManufacturer = updateelectricLocoBoardZonal.getLoco_manufacturer();
			String locoLeasetype = updateelectricLocoBoardZonal.getLoco_lease_type();
			long locoInitialCost = updateelectricLocoBoardZonal.getLoco_initial_cost();
			long locoPOHCost = updateelectricLocoBoardZonal.getLoco_poh_cost();
			Date locoRecdDt = updateelectricLocoBoardZonal.getLoco_receiving_date();
			String gaugeType = updateelectricLocoBoardZonal.getGauge_type();
			String manuCntry = updateelectricLocoBoardZonal.getLoco_manufacturing_country();
			Long haulingPower = updateelectricLocoBoardZonal.getLoco_hauling_power();
			String recordStatus = updateelectricLocoBoardZonal.getRecord_status();
			String status = updateelectricLocoBoardZonal.getStatus();
			String uid = updateelectricLocoBoardZonal.getUser_id();
			String remarks = updateelectricLocoBoardZonal.getRemarks();
			Date locoEntryDate = updateelectricLocoBoardZonal.getLoco_entry_date();
			String locoFlag = updateelectricLocoBoardZonal.getLoco_flag();
			String traction = updateelectricLocoBoardZonal.getLoco_flag();
			String txnDate1 = new SimpleDateFormat("yyyy-MM-dd").format(date);
			Date txnDate = new SimpleDateFormat("yyyy-MM-dd").parse(txnDate1);
			int locoNo = updateelectricLocoBoardZonal.getLoco_no();
			obj_dieselocoaddrepo.updateElectricBoardZonalRecord(locoNo, locoPermanentDomain, locoType, locoOwningZone,
					locoOwningDivision, locoMfgDt, locOwningShed, locoRecdDt, locoLeasetype, locoInitialCost,
					locoPOHCost, status, uid, txnDate, remarks, gaugeType, manuCntry, haulingPower);

			obj_dieselocoaddrepo.insertRBZonalToGoldenMaster(locoNo, locoType, locoOwningZone, locOwningShed,
					locoOwningDivision, manuCntry, locoMfgDt, locoRecdDt, haulingPower, traction, locoPermanentDomain,
					gaugeType, locoLeasetype, locoInitialCost, locoPOHCost, locoEntryDate, status, uid, txnDate,
					remarks, locoFlag, recordStatus);
			returnValue = "Record Approved Sucessfully";
			return returnValue;
		} catch (Exception e) {

			System.out.println(e);
			return "Failed To Approve Record";
		}

	}

	public boolean checkloconoexist(int locono) {

		int tmp = obj_dieselocoaddrepo.checklocoNoExist(locono);
		if (tmp == 0) {
			return false;
		}

		else

		{

			return true;
		}

	}

//@Transactional(rollbackOn = Exception.class)
//public String updateElectricBoardZonalData(BoardZonalApproval updateelectricLocoBoardZonal) {	
//
//	Date date = new Date();
//	try {
//	String returnValue=null;
//	String locoPermanentDomain = updateelectricLocoBoardZonal.getLoco_permanent_domain();
//	String locoType = updateelectricLocoBoardZonal.getLoco_type();
//	String locoOwningZone = updateelectricLocoBoardZonal.getLoco_owning_zone();
//	String locoOwningDivision = updateelectricLocoBoardZonal.getLoco_owning_division();
//	Date locoMfgDt=updateelectricLocoBoardZonal.getLoco_manufacturing_date();
//	String locOwningShed = updateelectricLocoBoardZonal.getLoco_owning_shed();
//	String locoManufacturer=updateelectricLocoBoardZonal.getLoco_manufacturer();
//	String locoLeasetype = updateelectricLocoBoardZonal.getLoco_lease_type();
//	long locoInitialCost = updateelectricLocoBoardZonal.getLoco_initial_cost();
//	long locoPOHCost = updateelectricLocoBoardZonal.getLoco_poh_cost();
//	Date locoRecdDt=updateelectricLocoBoardZonal.getLoco_receiving_date();
//	String gaugeType=updateelectricLocoBoardZonal.getGauge_type();
//	String manuCntry=updateelectricLocoBoardZonal.getLoco_manufacturing_country();
//	Long haulingPower=updateelectricLocoBoardZonal.getLoco_hauling_power();
//	String recordStatus=updateelectricLocoBoardZonal.getRecord_status();
//	String status = updateelectricLocoBoardZonal.getStatus();
//	String uid = updateelectricLocoBoardZonal.getUser_id();		
//	String remarks=updateelectricLocoBoardZonal.getRemarks();
//	Date locoEntryDate=updateelectricLocoBoardZonal.getLoco_entry_date();
//	String locoFlag=updateelectricLocoBoardZonal.getLoco_flag();
//	String traction=updateelectricLocoBoardZonal.getLoco_flag();
//	String txnDate1= new SimpleDateFormat("yyyy-MM-dd").format(date);
//	Date txnDate=new SimpleDateFormat("yyyy-MM-dd").parse(txnDate1);
//	int locoNo = updateelectricLocoBoardZonal.getLoco_no();		
//obj_dieselocoaddrepo.updateElectricBoardZonalRecord(locoNo,locoPermanentDomain, locoType, locoOwningZone,
//		locoOwningDivision, locoMfgDt, locOwningShed, locoRecdDt,locoLeasetype, locoInitialCost, locoPOHCost, status,uid,txnDate,remarks,gaugeType,manuCntry,haulingPower);
//
//
//obj_dieselocoaddrepo.insertRBZonalToGoldenMaster(locoNo, locoType, locoOwningZone,
//	  locOwningShed, locoOwningDivision,manuCntry, locoMfgDt, locoRecdDt, haulingPower, traction, locoPermanentDomain, gaugeType, locoLeasetype,
// locoInitialCost, locoPOHCost, locoEntryDate, status, uid, txnDate, remarks, locoFlag, recordStatus);
// returnValue = "Record Approved Sucessfully";
//	return returnValue;
//	}
//	catch(Exception e){
//		
//		System.out.println(e);
//		return "Failed To Approve Record";
//	}
//	
//}
//public boolean checkloconoexist(int locono) {
//	
//	int tmp= obj_dieselocoaddrepo.checklocoNoExist(locono); 
//	if(tmp==0)
//	{
//		return false;
//	}
//	  
//	else
//	    
//	    {
//	   
//	    	return true;
//	    }
//		
//	    
//
//}

// service use to update diesel  shed attribute for new add loco- for save as draft as well as forward to unapproved record 
	public String updateDieselShedData(LocoUncleansedDataAddNewLoco dieselLocoNewShedUser) {
		try {
			String returnValue = null;
			String locoBoogieType = dieselLocoNewShedUser.getLoco_boogie_type();
			String locoCommissionedShedId = dieselLocoNewShedUser.getLoco_commissioning_shed_id();
			String locoControlType = dieselLocoNewShedUser.getLoco_control_type();
			Date locoDateOfCommision = dieselLocoNewShedUser.getLoco_commissioning_date();
			Date locoEntryDate = dieselLocoNewShedUser.getLoco_entry_date();
			String locoManfacturer = dieselLocoNewShedUser.getLoco_manufacturer();
			String locoGPSEnableflag = dieselLocoNewShedUser.getIs_gps_enabled();
			String flagtype = dieselLocoNewShedUser.getFlag_type();
			String locoTractionMotorType = dieselLocoNewShedUser.getLoco_traction_motor_type();
			String axleload = dieselLocoNewShedUser.getLoco_axle_load();
			String axleloadunit = dieselLocoNewShedUser.getLoco_axle_load_unit();
			Date locorecddt = dieselLocoNewShedUser.getLoco_receiving_date();
			String status = dieselLocoNewShedUser.getStatus();
			String uid = dieselLocoNewShedUser.getUser_id();
			Date locotxndate = dieselLocoNewShedUser.getTxn_date();
			int locoNo = dieselLocoNewShedUser.getLoco_no();
			obj_dieselocoaddrepo.updateWithDieselLocoShedData(locoBoogieType, locoCommissionedShedId, locoControlType,
					locoDateOfCommision, locoEntryDate, locoManfacturer, locoGPSEnableflag, flagtype,
					locoTractionMotorType, axleload, axleloadunit, locorecddt, status, uid, locotxndate, locoNo);
			returnValue = "Record Saved Sucessfully";
			return returnValue;
		} catch (Exception e) {

			System.out.println(e);
			return "Failed to Saved";
		}

	}

//service use to update electric  shed attribute for new add loco- for save as draft as well as forward to unapproved record 
	public String updateElectricShedData(LocoUncleansedDataElectric electricLocoNewShedUser) {
		try {
			String returnValue = null;
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
			String uid = electricLocoNewShedUser.getUserid();
			Date locotxndate = electricLocoNewShedUser.getTxndate();
			int locoNo = electricLocoNewShedUser.getElec_locoNo();
			obj_electriclocorepo.updateWithElectricLocoShedData(locoAuxiliaryOutput, locoBoogieType, locoBrakeSubtype,
					locoBrakeType, locoCabac, locoCommissionedShedId, locoControlType, locoDateOfCommision,
					locoEntryDate, locoHotelLoad, locoManfacturer, locoGPSEnableflag, locoTractionMotorType, status,
					uid, locotxndate, locoNo);
			returnValue = "Record Save Sucessfully";
			return returnValue;
		} catch (Exception e) {

			System.out.println(e);
			return "Failed to Save";
		}

	}

//fetch zonal user  new loco unapproved record 
	public List<LocoUncleansedDataAddNewLoco> getUnapprovedZonalLocos(LocoUncleansedDataElectric obj_zonalunapproved) {
//		// TODO Auto-generated method stub
		System.out.println("getzonalunapprovedocos");
		String zoneid = obj_zonalunapproved.getElec_locoOwningZone();
		obj_electriclocorepo.getUnapprovedZonalBoardLoco(zoneid);
		List<LocoUncleansedDataElectric> zonalunapprovedLoco = new ArrayList<>();
		obj_electriclocorepo.getUnapprovedZonalBoardLoco(zoneid).forEach(zonalunapprovedLoco::add);
		System.out.println(" End getzonalunapprovedocos");
		return obj_LocoNewRepo.getUnapprovedZonalBoardLoco(zoneid);
	}

////fetch zonal user  new loco unapproved record 
//public List<LocoUncleansedDataAddNewLoco> getUnapprovedZonalLocos(LocoUncleansedDataElectric obj_zonalunapproved) {
////		// TODO Auto-generated method stub
//		System.out.println("getzonalunapprovedocos");
//		String zoneid=obj_zonalunapproved.getElec_locoOwningZone();
//		obj_electriclocorepo.getUnapprovedZonalBoardLoco(zoneid);		
//		List<LocoUncleansedDataElectric> zonalunapprovedLoco= new ArrayList<>();
//		obj_electriclocorepo.getUnapprovedZonalBoardLoco(zoneid)
//		.forEach(zonalunapprovedLoco::add);
//		System.out.println(" End getzonalunapprovedocos");
//		return obj_electriclocorepo.getUnapprovedZonalBoardLoco(zoneid);
//	}

//fetch zonal apporved new loco list - Developer - Ritu 
	public List<LocoUncleansedDataAddNewLoco> getApprovedZonalLocos(LocoUncleansedDataAddNewLoco obj_zonalapproved) {
		String zoneid = obj_zonalapproved.getLoco_owning_zone();
		System.out.println("zoneidservice : " + zoneid);
		obj_LocoNewRepo.getApprovedZonalBoardLoco(zoneid);

		List<LocoUncleansedDataAddNewLoco> zonalapprovedLoco = new ArrayList<>();
		obj_LocoNewRepo.getApprovedZonalBoardLoco(zoneid).forEach(zonalapprovedLoco::add);
		System.out.println(" End getzonalunapprovedocos" + zonalapprovedLoco);
//return obj_LocoNewRepo.getApprovedZonalBoardLoco(zoneid);
		return zonalapprovedLoco;
	}

	public String savegoldenrecord(LocoUncleansedDataAddNewLoco objnewloco) {
		try {

			int locoNo = objnewloco.getLoco_no();
			String locoType = objnewloco.getLoco_type();
			String locoOwningZone = objnewloco.getLoco_owning_zone();
			String locoOwningDivision = objnewloco.getLoco_owning_division();
			System.out.println(objnewloco.getLoco_manufacturing_date());
			String locOwningShed = objnewloco.getLoco_owning_shed();
			String locoPermanentDomain = objnewloco.getLoco_permanent_domain();
			Long locoInitialCost = objnewloco.getLoco_initial_cost();
			Long locoPOHCost = objnewloco.getLoco_poh_cost();
			String leaseType = objnewloco.getLoco_lease_type();
			Date dateOfMfg = objnewloco.getLoco_manufacturing_date();
			Date dateOfRcng = objnewloco.getLoco_receiving_date();
			String locoAuxiliaryOutput = objnewloco.getLoco_auxilary();
			String locoBoogieType = objnewloco.getLoco_boogie_type();
			String locoBrakeSubtype = objnewloco.getLoco_brake_type();
			String locoBrakeType = objnewloco.getLoco_brake_sub_type();
			String locoCabac = objnewloco.getLoco_cabin_ac();
			String locoCommissionedShedId = objnewloco.getLoco_commissioning_shed_id();
			String locoControlType = objnewloco.getLoco_control_type();
			Date locoDateOfCommision = objnewloco.getLoco_commissioning_date();
			Date locoEntryDate = objnewloco.getLoco_entry_date();
			String locoHotelLoad = objnewloco.getElec_locoHotelLoad();
			String locoManfacturer = objnewloco.getLoco_manufacturer();
			String lsGPSEnable = objnewloco.getIs_gps_enabled();
			String flagtype = objnewloco.getFlag_type();
			String locoTractionMotorType = objnewloco.getLoco_traction_motor_type();
			String status = objnewloco.getStatus();
			String userid = objnewloco.getUser_id();
			Date txndate = objnewloco.getTxn_date();
			String remarks = objnewloco.getRemarks();
			String locoflag = objnewloco.getLoco_flag();
			String recordstatus = objnewloco.getRecord_status();
			String returnValue = null;
			obj_electriclocorepo.insertNewLocoShedData(locoNo, locoType, locoOwningZone, locoOwningDivision,
					locOwningShed, locoPermanentDomain, locoInitialCost, locoPOHCost, locoAuxiliaryOutput, leaseType,
					dateOfMfg, dateOfRcng, locoBoogieType, locoBrakeSubtype, locoBrakeType, locoCabac,
					locoCommissionedShedId, locoControlType, locoDateOfCommision, locoEntryDate, locoHotelLoad,
					locoManfacturer, lsGPSEnable, flagtype, locoTractionMotorType, status, userid, txndate, remarks,
					locoflag, recordstatus);

			returnValue = "Record saved as Golden";
			return returnValue;

		} catch (Exception E) {
			System.out.println(E);
			return "Failed to Save Golden Records";
		}

	}

	public List<Integer> getLocoNumber(String locoOwingShed) {

		List<Integer> list = obj_dieselocoaddrepo.findlocoNumber(locoOwingShed);

		return list;
		// obj_dieselocoaddrepo.findlocoNumber(locozone);

	}
	
	public List<LocoUncleansedDataAddNewLoco> getLocoDetailOnLocoNo(Integer loco_no){
		
		List<LocoUncleansedDataAddNewLoco> listt = new ArrayList<LocoUncleansedDataAddNewLoco>();
		
		//List<LocoUncleansedDataAddNewLoco> listt = obj_LocoNewRepo.findlocoDetailBasedOnLocoNo(loco_no);
		listt.addAll(obj_LocoNewRepo.findlocoDetailBasedOnLocoNo(loco_no));
		return listt;
	}

}
