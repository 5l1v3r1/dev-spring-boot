package com.mdms.wagon.wagonuncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_wagon_type_irwms", schema="mdms_wagon")
public class MWagonType {	
	@Id
	@Column(name="vehicle_type")
	private String  vehicle_type ;
	
	@Column(name="tcd")
	private String  tcd ;
	
	@Column(name="group_code")
	private String  group_code ;
	
	@Column(name="group_name")
	private String  group_name ;
	@Column(name="brk_type")
	private String  brk_type ;
	
	
	@Column(name="valid")
	private String  valid ;
	
	@Column(name="active")
	private String  active ;

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getTcd() {
		return tcd;
	}

	public void setTcd(String tcd) {
		this.tcd = tcd;
	}

	public String getGroup_code() {
		return group_code;
	}

	public void setGroup_code(String group_code) {
		this.group_code = group_code;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public String getBrk_type() {
		return brk_type;
	}

	public void setBrk_type(String brk_type) {
		this.brk_type = brk_type;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	} 
	
	
	
		
}
