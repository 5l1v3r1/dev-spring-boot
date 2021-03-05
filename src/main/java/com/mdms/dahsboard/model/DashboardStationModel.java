package com.mdms.dahsboard.model;

public class DashboardStationModel {
	public String zone_code;
	public	String division_code="null";
	 public	Integer uncleansed_count=0;
	public Integer cleansed_count=0;
	public Integer pending_approval=0;
	public Integer draft_forward_approval_count=0;
	
	
//	public Integer total_division_count=0;
	public Integer total_division_count_single=0;


	public String getZone_code() {
		return zone_code;
	}


	public void setZone_code(String zone_code) {
		this.zone_code = zone_code;
	}


	public String getDivision_code() {
		return division_code;
	}


	public void setDivision_code(String division_code) {
		this.division_code = division_code;
	}


	public Integer getUncleansed_count() {
		return uncleansed_count;
	}


	public void setUncleansed_count(Integer uncleansed_count) {
		this.uncleansed_count = uncleansed_count;
	}


	public Integer getCleansed_count() {
		return cleansed_count;
	}


	public void setCleansed_count(Integer cleansed_count) {
		this.cleansed_count = cleansed_count;
	}


	public Integer getPending_approval() {
		return pending_approval;
	}


	public void setPending_approval(Integer pending_approval) {
		this.pending_approval = pending_approval;
	}


	public Integer getDraft_forward_approval_count() {
		return draft_forward_approval_count;
	}


	public void setDraft_forward_approval_count(Integer draft_forward_approval_count) {
		this.draft_forward_approval_count = draft_forward_approval_count;
	}


//	public Integer getTotal_division_count() {
//		return total_division_count;
//	}
//
//
//	public void setTotal_division_count(Integer total_division_count) {
//		this.total_division_count = total_division_count;
//	}


	public Integer getTotal_division_count_single() {
		return total_division_count_single;
	}


	public void setTotal_division_count_single(Integer total_division_count_single) {
		this.total_division_count_single = total_division_count_single;
	}
	
	
	
		 
}
