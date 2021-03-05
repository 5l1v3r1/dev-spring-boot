package com.mdms.loco.locouncleansed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_loco_type", schema="mdms_loco")
public class MLocoType {
	@Id
	@Column(name="loco_type")                  
	private String loco_Type; 
	
	@Column(name="loco_hauling_power")                  
	private String loco_Hauling_Power; 
	
	@Column(name="loco_axle_load")                  
	private Double loco_Axleload; 

	
	@Column(name="loco_axle_unit")                  
	private String loco_Unit; 
	
	@Column(name="loco_gauge_code")                  
	private String loco_Gaugetype;

	public String getLoco_Type() {
		return loco_Type;
	}

	public void setLoco_Type(String loco_Type) {
		this.loco_Type = loco_Type;
	}

	public String getLoco_Hauling_Power() {
		return loco_Hauling_Power;
	}

	public void setLoco_Hauling_Power(String loco_Hauling_Power) {
		this.loco_Hauling_Power = loco_Hauling_Power;
	}

	public Double getLoco_Axleload() {
		return loco_Axleload;
	}

	public void setLoco_Axleload(Double loco_Axleload) {
		this.loco_Axleload = loco_Axleload;
	}

	public String getLoco_Unit() {
		return loco_Unit;
	}

	public void setLoco_Unit(String loco_Unit) {
		this.loco_Unit = loco_Unit;
	}

	public String getLoco_Gaugetype() {
		return loco_Gaugetype;
	}

	public void setLoco_Gaugetype(String loco_Gaugetype) {
		this.loco_Gaugetype = loco_Gaugetype;
	}
	
	

}
