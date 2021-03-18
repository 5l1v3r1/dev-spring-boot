package com.mdms.dahsboard.model;

public class DashboardLocoModel {
//	public String zone_code;
//	public	String division_code="null";
	//public String elec_locoOwningShed;
	public String loco_Owningshed;
	 public	Integer uncleansed_count=0;
	public Integer cleansed_count=0;
	public Integer  draft_forward_approval=0;
	public Integer pending_approval=0;
	  public Integer  total_loco_count=0;
//	    public Integer  loco_uncleansed_count=0;
	 //   public Integer  draft_forward_approval_loco=0;
	  //  public Integer  pending_approval_loco=0;
	  //  public Integer  cleansed_loco_count=0;
	public String getLoco_Owningshed() {
		return loco_Owningshed;
	}
	public void setLoco_Owningshed(String loco_Owningshed) {
		this.loco_Owningshed = loco_Owningshed;
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
	public Integer getDraft_forward_approval() {
		return draft_forward_approval;
	}
	public void setDraft_forward_approval(Integer draft_forward_approval) {
		this.draft_forward_approval = draft_forward_approval;
	}
	public Integer getPending_approval() {
		return pending_approval;
	}
	public void setPending_approval(Integer pending_approval) {
		this.pending_approval = pending_approval;
	}
	public Integer getTotal_loco_count() {
		return total_loco_count;
	}
	public void setTotal_loco_count(Integer total_loco_count) {
		this.total_loco_count = total_loco_count;
	}

	  
	  
	  
}
