package com.mdms.dahsboard.model;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class ZonalUsersAssetModel {
	
//	@JsonIgnore 
//	 @Value("#{target.zone}")
//	public	String getzone();
//	
//	@JsonIgnore 
//	 @Value("#{target.count}")
//	public	Integer getcount();
//
//	
//	@JsonIgnore 
//	 @Value("#{args[0]+': '+target.zone}")	 
//	 public void setzone(String str);
//	
//	@JsonIgnore 
//	 @Value("#{args[0]+': '+target.count}")	 
//	 public void setcount(Integer str);
	
	public ZonalUsersAssetModel(String z, int c, String zn )
	{
		this.zone=z;
		this.count=c;
		this.zone_name=zn;
	}
	

	
	
	
	public String zone;
	
	public int count;

	public String zone_name;
	
	
	
	
	
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getZone_name() {
		return zone_name;
	}

	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}
	
	
}
