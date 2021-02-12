package com.mdms.dashboard.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mdms.dahsboard.model.DashBoardStationCountDivisionWiseModel;
import com.mdms.dahsboard.model.DashboardStationModel;
import com.mdms.dashboard.repository.StationDashboardRepo;
import com.mdms.mdms_masters.model.MDivision;
import com.mdms.mdms_station.stationuncleansed.repository.StationTableRbsRepository;
import com.mdms.mdms_station.stationuncleansed.repository.StationUncleansedDataRepository;




@Service
public class StationDashboardService {
	 Logger logger=LoggerFactory.getLogger(StationDashboardService.class);
	 
//	 @Autowired
//		private StationDashboardRepo stationRepositoryObj;
//	 
	 @Autowired
		StationUncleansedDataRepository stn_unclsnd_repo;
		
		@Autowired
		StationTableRbsRepository stn_tbl_rbs_repo;
		
		MDivision objmdiv;

		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		public HashMap<String, Integer> getStationStats() {
			logger.info("Service : StationDashboardService || Method: getStationStats");

	 HashMap<String, Integer> map = new HashMap<>();
			 
	 try {
			 final String noOfStations = "SELECT count(*) FROM mdms_station.station_table_rbs";
			    final int totalStations = (int)jdbcTemplate.queryForObject(noOfStations,Integer.class);
	
	 
	final String cleansedStations = "select count(*) from mdms_station.station_uncleansed_data";
	final int noOfCleansedStations = (int)jdbcTemplate.queryForObject(cleansedStations, Integer.class);
	
	final String uncleansedStations = "select count(*) from(\r\n" + 
			"	Select stn_code FROM mdms_station.station_table_rbs \r\n" + 
			"	except select station_code FROM mdms_station.station_uncleansed_data) AS uncleansed";
	final int noOfUncleansedStations = (int)jdbcTemplate.queryForObject(uncleansedStations, Integer.class);
	
	//Integer noOfUncleansedStations=totalStations-noOfCleansedStations;
	
	final String unapprovedStations = "select count(*) from mdms_station.station_uncleansed_data where cmi_status='0' OR dti_status='0'";
	final int waitingForApproval = (int)jdbcTemplate.queryForObject(unapprovedStations,Integer.class);
	
			    map.put("noOfUncleansedStations", noOfUncleansedStations);
			    map.put("noOfCleansedStations", noOfCleansedStations);
			    map.put("totalStations", totalStations);
			    map.put("waitingForApproval", waitingForApproval);
			    return map;
		}
		  catch(Exception e) {
		    	logger.error("Service : StationDashboardService || Method: getStationStats|| Exception : " +e.getMessage());
				e.getMessage();
				return null;
		    }
		}
		
		public HashMap<String, Integer> getDivisionWiseStationStats(String  divcode) {
			logger.info("Service : StationDashboardService || Method: getDivisionWiseStationStats");
			 String dc= "MAS";	
	 HashMap<String, Integer> map = new HashMap<>();			 
	 try {
		
			 final String noOfStations = "SELECT count(*) FROM mdms_station.station_table_rbs as a\r\n" + 
			 		"		join mdms_masters.m_division AS b on a.div_ser_no=b.division_sr_no\r\n" + 
			 		"		where b.division_code=dc";
			    final int totalStations = (int)jdbcTemplate.queryForObject(noOfStations,Integer.class);
	
	 
	final String cleansedStations = "select count(*) from mdms_station.station_uncleansed_data where division_code=?1";
	final int noOfCleansedStations = (int)jdbcTemplate.queryForObject(cleansedStations, Integer.class);
	
	final String uncleansedStations = "select count(*) from(\r\n" + 
			"	Select stn_code FROM mdms_station.station_table_rbs \r\n" + 
			"	except select station_code FROM mdms_station.station_uncleansed_data) AS uncleansed where division_code=?1 ";
	final int noOfUncleansedStations = (int)jdbcTemplate.queryForObject(uncleansedStations, Integer.class);
	
	//Integer noOfUncleansedStations=totalStations-noOfCleansedStations;
	
	final String unapprovedStations = "select count(*) from mdms_station.station_uncleansed_data where division_code=?1 AND(cmi_status='0' OR dti_status='0')";
	final int waitingForApproval = (int)jdbcTemplate.queryForObject(unapprovedStations,Integer.class);	
			    map.put("noOfUncleansedStations", noOfUncleansedStations);
			    map.put("noOfCleansedStations", noOfCleansedStations);
			    map.put("totalStations", totalStations);
			    map.put("waitingForApproval", waitingForApproval);
			    return map;
		}
		  catch(Exception e) {
		    	logger.error("Service : StationDashboardService || Method: getDivisionWiseStationStats|| Exception : " +e.getMessage());
				e.getMessage();
				return null;
		    }
		}

			
		 int uncleansedFlag=0;
			
		 
			
		 
		 DashBoardStationCountDivisionWiseModel obj;
		
		//find  station details
		
		public List<DashboardStationModel> getStationCountDivisionWise(DashboardStationModel objzone_code) {
			String zone_code =objzone_code.getZone_code();
			List<DashboardStationModel> list= new ArrayList<DashboardStationModel>();			
			Collection<DashBoardStationCountDivisionWiseModel> totalCountList= stn_tbl_rbs_repo.getTotalStationCountDivisionWise(zone_code);
				logger.info("Service : DashBoardStationService || Method: getStationCountDivisionWise || getTotalStationCountDivisionWise Query list return : "+totalCountList.size());
				if(totalCountList.size()>0) {
				totalCountList.forEach(DashBoardStationCountDivisionWiseModel -> setTotalDivision(DashBoardStationCountDivisionWiseModel,list));

				}	
				
				Collection<DashBoardStationCountDivisionWiseModel> uncleansedCountList= stn_tbl_rbs_repo.getUncleansedStationCountDivisionWise(zone_code);
				logger.info("Service : DashBoardStationService || Method: getStationCountDivisionWise || getUncleansedStationCountDivisionWise Query list return : "+uncleansedCountList.size());

				uncleansedCountList.forEach(DashBoardStationCountDivisionWiseModel -> callTotal(DashBoardStationCountDivisionWiseModel,list));
				
				
				Collection<DashBoardStationCountDivisionWiseModel> pendingApprovalCountList= stn_unclsnd_repo.getPendingApprovalStationCountDivisionWise(zone_code);
				logger.info("Service : DashBoardStationService || Method: getStationCountDivisionWise || getPendingApprovalStationCountDivisionWise Query list return : "+pendingApprovalCountList.size());
		
				pendingApprovalCountList.forEach(DashBoardStationCountDivisionWiseModel -> callPendingApproval(DashBoardStationCountDivisionWiseModel,list));

				
				Collection<DashBoardStationCountDivisionWiseModel> cleansedCountList= stn_unclsnd_repo.getTotalCleansedStationCountDivisionWise(zone_code);
				logger.info("Service : DashBoardStationService || Method: getStationCountDivisionWise || getTotalCleansedStationCountDivisionWise Query list return : "+cleansedCountList.size());			
				cleansedCountList.forEach(DashBoardStationCountDivisionWiseModel -> callCleansedCount(DashBoardStationCountDivisionWiseModel,list));			
			
				
				Collection<DashBoardStationCountDivisionWiseModel> draftCountList= stn_unclsnd_repo.getTotalDraftForwardApprovalStationCountDivisionWise(zone_code);
				logger.info("Service : DashBoardStationService || Method: getStationCountDivisionWise || getTotalDraftForwardApprovalStationCountDivisionWise Query list return : "+draftCountList.size());			
				draftCountList.forEach(DashBoardStationCountDivisionWiseModel -> callDraftCount(DashBoardStationCountDivisionWiseModel,list));	
				
				
				
				
				
				return list;
			
		}

		private void callTotal(DashBoardStationCountDivisionWiseModel uncleansedObj,Collection< DashboardStationModel>list) {
			// TODO Auto-generated method stub
			try {		
				uncleansedFlag=0;
				list.forEach(totalobj -> callTotalSub(uncleansedObj,totalobj));	
				if(uncleansedFlag==0){
					DashboardStationModel obj = new DashboardStationModel();
//					obj.setZone_code(uncleansedObj.getzone_code());
					obj.setDivision_code(uncleansedObj.getdivision_code());
					obj.setUncleansed_count(uncleansedObj.getuncleansed_count());
			//		list.add(obj);	
				}
					}catch (Exception e) {
				// TODO: Handle Exception
				e.getMessage();		}
		}
		private void callTotalSub(DashBoardStationCountDivisionWiseModel uncleansedObj,DashboardStationModel totalobj) {
			
			try {
			if(uncleansedObj.getdivision_code().equalsIgnoreCase(totalobj.getDivision_code())) {
				uncleansedFlag++;
				totalobj.setUncleansed_count(uncleansedObj.getuncleansed_count());
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		

		
		private void callPendingApproval(DashBoardStationCountDivisionWiseModel pendingApprovObj,Collection< DashboardStationModel>list) {
			// TODO Auto-generated method stub
			try {
			
				uncleansedFlag=0;
				list.forEach(totalobj -> callPendingApprovalSub(pendingApprovObj,totalobj));	
				if(uncleansedFlag==0) {
					DashboardStationModel obj = new DashboardStationModel();
//					obj.setZone_code(pendingApprovObj.getzone_code());					
					obj.setDivision_code(pendingApprovObj.getdivision_code());
					obj.setPending_approval(pendingApprovObj.getpending_approval());
			//		list.add(obj);	
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
			
		}
		private void callPendingApprovalSub(DashBoardStationCountDivisionWiseModel pendingApprovObj,DashboardStationModel totalobj) {
			
			try {
			if(pendingApprovObj.getdivision_code().equalsIgnoreCase(totalobj.getDivision_code())) {
				uncleansedFlag++;
				totalobj.setPending_approval(pendingApprovObj.getpending_approval());		
		
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		
		
		private void callCleansedCount(DashBoardStationCountDivisionWiseModel cleansedObj,Collection< DashboardStationModel>list) {
			// TODO Auto-generated method stub
			
			try {
				uncleansedFlag=0;
				list.forEach(totalobj -> callCleansedCountSub(cleansedObj,totalobj));

		
				if(uncleansedFlag==0) {
					DashboardStationModel obj = new DashboardStationModel();
//					obj.setZone_code(cleansedObj.getzone_code());
					obj.setDivision_code(cleansedObj.getdivision_code());
					obj.setCleansed_count(cleansedObj.getcleansed_count());
				//	list.add(obj);		
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
			
		}
		private void callCleansedCountSub(DashBoardStationCountDivisionWiseModel cleansedObj,DashboardStationModel totalobj) {
			try {
			if(cleansedObj.getdivision_code().equalsIgnoreCase(totalobj.getDivision_code())){
				uncleansedFlag++;
				totalobj.setCleansed_count(cleansedObj.getcleansed_count());	
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		
		private void callDraftCount(DashBoardStationCountDivisionWiseModel draftObj,Collection< DashboardStationModel>list) {
			// TODO Auto-generated method stub
			
			try {
				uncleansedFlag=0;
				list.forEach(totalobj -> callDraftCountSub(draftObj,totalobj));

		
				if(uncleansedFlag==0) {
					DashboardStationModel obj = new DashboardStationModel();
//					obj.setZone_code(draftObj.getzone_code());
					obj.setDivision_code(draftObj.getdivision_code());
					obj.setDraft_forward_approval_count(draftObj.getdraft_forward_approval_count());
				//	list.add(obj);		
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
			
		}
		private void callDraftCountSub(DashBoardStationCountDivisionWiseModel draftObj,DashboardStationModel totalobj) {
			try {
			if(draftObj.getdivision_code().equalsIgnoreCase(totalobj.getDivision_code())){
				uncleansedFlag++;
				totalobj.setDraft_forward_approval_count(draftObj.getdraft_forward_approval_count());	
		//		System.out.println("draft add in list divcode"+ totalobj.getDivision_code()+"|| AND Draft count: "+totalobj.getDraft_forward_approval_count());
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		
		
		private void setTotalDivision(DashBoardStationCountDivisionWiseModel DashBoardStationCountDivisionWiseModel,Collection<DashboardStationModel> list) {
		DashboardStationModel obj =new DashboardStationModel();	
//		obj.setZone_code(DashBoardStationCountDivisionWiseModel.getzone_code());
			
		obj.setDivision_code(DashBoardStationCountDivisionWiseModel.getdivision_code());
		obj.setTotal_division_count(DashBoardStationCountDivisionWiseModel.gettotal_division_count());			
		list.add(obj);
		
		}
		


}
