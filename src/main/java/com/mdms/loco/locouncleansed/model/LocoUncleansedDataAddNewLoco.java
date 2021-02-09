package com.mdms.loco.locouncleansed.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity()
@Table(name="loco_uncleansed_data", schema="mdms_loco")
public class LocoUncleansedDataAddNewLoco {
	@Id
	@Column(name = "loco_no")
	private int locoNo;

	@Column(name = "loco_permanent_domain")
	private String locoPermanentDomain;

	@Column(name = "loco_type")
	private String locoType;

	@Column(name = "loco_owning_zone")
	private String locoOwningZone;

	@Column(name = "loco_owning_division")
	private String locoOwningDivision;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",timezone = "IST") 
	@Column(name = "loco_manufacturing_date")
	private Date locoMfgDt;

	@Column(name = "loco_owning_shed")
	private String locoOwningShed;

	

	@Column(name = "loco_initial_cost")
	private Long locoInitialCost;

	@Column(name = "loco_poh_cost")
	private Long locoPOHCost;

	@Column(name = "loco_lease_type")
	private String locoLeaseType;

	@Column(name = "loco_traction_code")
	private String locoTractionCode;

	@Column(name = "loco_gauge_type")
	private String locoGaugeType;

	@Column(name = "loco_hauling_power")
	private Long locoHaulingPower;

	@Column(name = "loco_manufacturing_country")
	private String locoMfgCountry;

	@Column(name = "loco_commissioning_date")
	private Date locoDateOfCommision;

	@Column(name = "loco_commissioning_shed_id")
	private String locoCommissionedShedId;

	@Column(name = "loco_axle_load")
	private String locoAxleLoad;

	@Column(name = "loco_axle_load_unit")
	private String locoAxleLoadUnit;

	@Column(name = "loco_traction_motor_type")
	private String locoTractionMotorType;

	@Column(name = "loco_boogie_type")
	private String locoBoogieType;

	@Column(name = "loco_control_type")
	private String locoControlType;

	@Column(name = "is_gps_enabled")
	private String isGPSEnabled;

	 @Column(name="flag_type")                  
		private String flagType;
	
	 
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",timezone = "IST")
	@Column(name = "loco_entry_date")
	private Date locoEntryDate;

	@Column(name = "loco_manufacturer")
	private String locoManufacturer;

	 @Column(name="loco_flag")                  
	 private String locoflag; 
	 
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",timezone = "IST")
	 @Column(name="txn_date")                  
	 private Date txndate;
	 
	 
	 @Column(name="status")                  
	 private String status; 
	
	 @Column(name="remarks")                  
	 private String remarks; 
	
	 @Column(name="record_status")                  
	 private String recordstatus; 
	 
	 @Column(name="user_id")                  
	 private String userid;
	 
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",timezone = "IST") 
	 @Column(name="loco_receiving_date")                  
		private Date loco_receiving_date;

	
	public int getLocoNo() {
		return locoNo;
	}

	public void setLocoNo(int locoNo) {
		this.locoNo = locoNo;
	}

	public String getLocoPermanentDomain() {
		return locoPermanentDomain;
	}

	public void setLocoPermanentDomain(String locoPermanentDomain) {
		this.locoPermanentDomain = locoPermanentDomain;
	}

	public String getLocoType() {
		return locoType;
	}

	public void setLocoType(String locoType) {
		this.locoType = locoType;
	}

	public String getLocoOwningZone() {
		return locoOwningZone;
	}

	public void setLocoOwningZone(String locoOwningZone) {
		this.locoOwningZone = locoOwningZone;
	}

	public String getLocoOwningDivision() {
		return locoOwningDivision;
	}

	public void setLocoOwningDivision(String locoOwningDivision) {
		this.locoOwningDivision = locoOwningDivision;
	}

	public Date getLocoMfgDt() {
		return locoMfgDt;
	}

	public void setLocoMfgDt(Date locoMfgDt) {
		this.locoMfgDt = locoMfgDt;
	}

	public String getLocoOwningShed() {
		return locoOwningShed;
	}

	public void setLocoOwningShed(String locoOwningShed) {
		this.locoOwningShed = locoOwningShed;
	}


	public Long getLocoInitialCost() {
		return locoInitialCost;
	}

	public void setLocoInitialCost(Long locoInitialCost) {
		this.locoInitialCost = locoInitialCost;
	}

	public Long getLocoPOHCost() {
		return locoPOHCost;
	}

	public void setLocoPOHCost(Long locoPOHCost) {
		this.locoPOHCost = locoPOHCost;
	}

	public String getLocoLeaseType() {
		return locoLeaseType;
	}

	public void setLocoLeaseType(String locoLeaseType) {
		this.locoLeaseType = locoLeaseType;
	}

	public String getLocoTractionCode() {
		return locoTractionCode;
	}

	public void setLocoTractionCode(String locoTractionCode) {
		this.locoTractionCode = locoTractionCode;
	}

	public String getLocoGaugeType() {
		return locoGaugeType;
	}

	public void setLocoGaugeType(String locoGaugeType) {
		this.locoGaugeType = locoGaugeType;
	}

	public Long getLocoHaulingPower() {
		return locoHaulingPower;
	}

	public void setLocoHaulingPower(Long locoHaulingPower) {
		this.locoHaulingPower = locoHaulingPower;
	}

	public String getLocoMfgCountry() {
		return locoMfgCountry;
	}

	public void setLocoMfgCountry(String locoMfgCountry) {
		this.locoMfgCountry = locoMfgCountry;
	}

	public Date getLocoDateOfCommision() {
		return locoDateOfCommision;
	}

	public void setLocoDateOfCommision(Date locoDateOfCommision) {
		this.locoDateOfCommision = locoDateOfCommision;
	}

	public String getLocoCommissionedShedId() {
		return locoCommissionedShedId;
	}

	public void setLocoCommissionedShedId(String locoCommissionedShedId) {
		this.locoCommissionedShedId = locoCommissionedShedId;
	}

	

	

	public String getLocoAxleLoad() {
		return locoAxleLoad;
	}

	public void setLocoAxleLoad(String locoAxleLoad) {
		this.locoAxleLoad = locoAxleLoad;
	}

	public String getLocoAxleLoadUnit() {
		return locoAxleLoadUnit;
	}

	public void setLocoAxleLoadUnit(String locoAxleLoadUnit) {
		this.locoAxleLoadUnit = locoAxleLoadUnit;
	}

	public String getLocoTractionMotorType() {
		return locoTractionMotorType;
	}

	public void setLocoTractionMotorType(String locoTractionMotorType) {
		this.locoTractionMotorType = locoTractionMotorType;
	}

	public String getLocoBoogieType() {
		return locoBoogieType;
	}

	public void setLocoBoogieType(String locoBoogieType) {
		this.locoBoogieType = locoBoogieType;
	}

	public String getLocoControlType() {
		return locoControlType;
	}

	public void setLocoControlType(String locoControlType) {
		this.locoControlType = locoControlType;
	}

	

	public String getIsGPSEnabled() {
		return isGPSEnabled;
	}

	public void setIsGPSEnabled(String isGPSEnabled) {
		this.isGPSEnabled = isGPSEnabled;
	}

	public String getFlagType() {
		return flagType;
	}

	public void setFlagType(String flagType) {
		this.flagType = flagType;
	}

	public Date getLocoEntryDate() {
		return locoEntryDate;
	}

	public void setLocoEntryDate(Date locoEntryDate) {
		this.locoEntryDate = locoEntryDate;
	}

	public String getLocoManufacturer() {
		return locoManufacturer;
	}

	public void setLocoManufacturer(String locoManufacturer) {
		this.locoManufacturer = locoManufacturer;
	}

	public String getLocoflag() {
		return locoflag;
	}

	public void setLocoflag(String locoflag) {
		this.locoflag = locoflag;
	}

	public Date getTxndate() {
		return txndate;
	}

	public void setTxndate(Date txndate) {
		this.txndate = txndate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRecordstatus() {
		return recordstatus;
	}

	public void setRecordstatus(String recordstatus) {
		this.recordstatus = recordstatus;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getLoco_receiving_date() {
		return loco_receiving_date;
	}

	public void setLoco_receiving_date(Date loco_receiving_date) {
		this.loco_receiving_date = loco_receiving_date;
	} 

	 
	 
	 
	 
}
