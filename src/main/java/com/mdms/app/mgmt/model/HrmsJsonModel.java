package com.mdms.app.mgmt.model;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HrmsJsonModel {
	
	private static final long serialVersionUID = 1L;
	
	
	
//	private String message;
//	@Id
//	private String ipasEmployeeId;
//	private String employeeNameSr;
//	private String designation;
//	private String departmentDescription;
//	private String serviceStatusDescription;
//	private String railwayUnitName;
//	private String railwayUnitDivision;
//	
//	
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("ipasEmployeeId")
	private String user_id;
	
	
	@JsonProperty("employeeNameSr")
	private String name;
	
	@JsonProperty("designation")
	private String designation;
	
	@JsonProperty("departmentDescription")
	private String departmentDescription;
	
	@JsonProperty("serviceStatusDescription")
	private String serviceStatusDescription;
	
	@JsonProperty("railwayUnitName")
	private String railwayUnitName;
	
	@JsonProperty("railwayUnitDivision")
	private String railwayUnitDivision;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartmentDescription() {
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	public String getServiceStatusDescription() {
		return serviceStatusDescription;
	}

	public void setServiceStatusDescription(String serviceStatusDescription) {
		this.serviceStatusDescription = serviceStatusDescription;
	}

	public String getRailwayUnitName() {
		return railwayUnitName;
	}

	public void setRailwayUnitName(String railwayUnitName) {
		this.railwayUnitName = railwayUnitName;
	}

	public String getRailwayUnitDivision() {
		return railwayUnitDivision;
	}

	public void setRailwayUnitDivision(String railwayUnitDivision) {
		this.railwayUnitDivision = railwayUnitDivision;
	}

	


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
	
	
	
}
