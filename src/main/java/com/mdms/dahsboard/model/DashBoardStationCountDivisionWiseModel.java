package com.mdms.dahsboard.model;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public interface DashBoardStationCountDivisionWiseModel {
	@JsonIgnore 
	 @Value("#{target.draft_forward_approval_count}")
public	Integer getdraft_forward_approval_count();
	
	
	@JsonIgnore 
	 @Value("#{target.division_code}")
public	String getdivision_code();
	
	
	@JsonIgnore 
	 @Value("#{target.zone_code}")
public	String getzone_code();
	 
	@JsonIgnore 
	 @Value("#{target.uncleansed_count}")
	 public	Integer getuncleansed_count();
	 
	
	@JsonIgnore 
	 @Value("#{target.cleansed_count}")
	 public Integer getcleansed_count();
	 
	
	@JsonIgnore 
	 @Value("#{target.pending_approval}")
	 public Integer getpending_approval();
	 
	
	@JsonIgnore 
	 @Value("#{target.total_division_count}")
	 public Integer gettotal_division_count();

	@JsonIgnore 
	 @Value("#{args[0]+': '+target.division_code}")	 
	 public void setdivision_code(String str);
	 
	
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.uncleansed_count}")	 
	 public void setuncleansed_count(Integer str);
	 
	
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.cleansed_count}")	 
	 public void setcleansed_count(Integer vgf);
	 
	
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.pending_approval}")	 
	 public void setpending_approval(Integer cvb);
	 
	
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.total_division_count}")	 
	 public void settotal_division_count(Integer dgd);
	
	@JsonIgnore 
	 @Value("#{args[0]+': '+target.draft_forward_approval_count}")
public	void setdraft_forward_approval();


}
