package com.mdms.mdms_coach.coachuncleansed.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="m_coach_type_cmm", schema="mdms_coach")
public class MCoachType {

	@Id
	@Column(name="coach_type")
	private String coachType;
	
	@Column(name="coupling_type")
	private String couplingType;
	
	@Column(name="power_generation_type")
	private String powerGenType;
	
	@Column(name="coach_type_description")
	private String coachTypeDescription;
	
	@Column(name="vehicle_type")
	private String vehicleType;
	
	@Column(name="coach_category")
	private String coachCategory;
	
	@Column(name="coach_ac_flag")
	private String coachACFlag;
	
	@Column(name="gauge")
	private String gauge;
	
	@Column(name="coach_capacity")
	private String coachcapacity;
	
	@Column(name="brake_type")
	private String brakeType;

	@Column(name="tare_weight")
	private float tareweight;
	
	@Column(name="max_speed")
	private float maximumspeed;
	
	@Column(name="reserved_flag")
	private int reservedFlag;

	public String getCoachType() {
		return coachType;
	}

	public void setCoachType(String coachType) {
		this.coachType = coachType;
	}

	public String getCouplingType() {
		return couplingType;
	}

	public void setCouplingType(String couplingType) {
		this.couplingType = couplingType;
	}

	public String getPowerGenType() {
		return powerGenType;
	}

	public void setPowerGenType(String powerGenType) {
		this.powerGenType = powerGenType;
	}

	public String getCoachTypeDescription() {
		return coachTypeDescription;
	}

	public void setCoachTypeDescription(String coachTypeDescription) {
		this.coachTypeDescription = coachTypeDescription;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getCoachCategory() {
		return coachCategory;
	}

	public void setCoachCategory(String coachCategory) {
		this.coachCategory = coachCategory;
	}

	public String getCoachACFlag() {
		return coachACFlag;
	}

	public void setCoachACFlag(String coachACFlag) {
		this.coachACFlag = coachACFlag;
	}

	public String getGauge() {
		return gauge;
	}

	public void setGauge(String gauge) {
		this.gauge = gauge;
	}

	public String getCoachcapacity() {
		return coachcapacity;
	}

	public void setCoachcapacity(String coachcapacity) {
		this.coachcapacity = coachcapacity;
	}

	public String getBrakeType() {
		return brakeType;
	}

	public void setBrakeType(String brakeType) {
		this.brakeType = brakeType;
	}

	public float getTareweight() {
		return tareweight;
	}

	public void setTareweight(float tareweight) {
		this.tareweight = tareweight;
	}

	public float getMaximumspeed() {
		return maximumspeed;
	}

	public void setMaximumspeed(float maximumspeed) {
		this.maximumspeed = maximumspeed;
	}

	public int getReservedFlag() {
		return reservedFlag;
	}

	public void setReservedFlag(int reservedFlag) {
		this.reservedFlag = reservedFlag;
	}
	
	
}
