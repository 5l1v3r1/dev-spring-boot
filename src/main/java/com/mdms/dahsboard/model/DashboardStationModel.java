package com.mdms.dahsboard.model;

public class DashboardStationModel {
	public String zone_code;
	public	String division_code="null";
	//public String elec_locoOwningShed;
	public String loco_Owningshed;
	 public	Integer uncleansed_count=0;
	public Integer cleansed_count=0;
	public Integer pending_approval=0;
	
	// Shilpi 15-03-2021
	
	public String owning_depot;
	public String getOwning_depot() {
		return owning_depot;
	}


	public void setOwning_depot(String owning_depot) {
		this.owning_depot = owning_depot;
	}


	public Integer getTotal_depo_count() {
		return total_depo_count;
	}


	public void setTotal_depo_count(Integer total_depo_count) {
		this.total_depo_count = total_depo_count;
	}


	public Integer total_depo_count=0;
	
	public String getLoco_Owningshed() {
		return loco_Owningshed;
	}


	public void setLoco_Owningshed(String loco_Owningshed) {
		this.loco_Owningshed = loco_Owningshed;
	}


	public Integer draft_forward_approval_count=0;
	
	
    public Integer total_division_count=0;
	
// Shilpi 10-03-2021
    
    public Integer  total_loco_count=0;
    public Integer  loco_uncleansed_count=0;
    public Integer  draft_forward_approval_loco=0;
    public Integer  pending_approval_loco=0;
    public Integer  cleansed_loco_count=0;



	public Integer getTotal_loco_count() {
		return total_loco_count;
	}


	public void setTotal_loco_count(Integer total_loco_count) {
		this.total_loco_count = total_loco_count;
	}


	public Integer getLoco_uncleansed_count() {
		return loco_uncleansed_count;
	}


	public void setLoco_uncleansed_count(Integer loco_uncleansed_count) {
		this.loco_uncleansed_count = loco_uncleansed_count;
	}


	public Integer getDraft_forward_approval_loco() {
		return draft_forward_approval_loco;
	}


	public void setDraft_forward_approval_loco(Integer draft_forward_approval_loco) {
		this.draft_forward_approval_loco = draft_forward_approval_loco;
	}


	public Integer getPending_approval_loco() {
		return pending_approval_loco;
	}


	public void setPending_approval_loco(Integer pending_approval_loco) {
		this.pending_approval_loco = pending_approval_loco;
	}


	public Integer getCleansed_loco_count() {
		return cleansed_loco_count;
	}


	public void setCleansed_loco_count(Integer cleansed_loco_count) {
		this.cleansed_loco_count = cleansed_loco_count;
	}


//	public String getElec_locoOwningShed() {
//	return elec_locoOwningShed;
//}
//
//
//public void setElec_locoOwningShed(String elec_locoOwningShed) {
//	this.elec_locoOwningShed = elec_locoOwningShed;
//}


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



	public Integer getTotal_division_count() {
		return total_division_count;
	}


	public void setTotal_division_count(Integer total_division_count) {
		this.total_division_count = total_division_count;
	}


	public String getelec_locoOwningShed() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	

	
		 
}
