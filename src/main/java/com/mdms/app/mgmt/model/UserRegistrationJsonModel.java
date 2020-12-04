package com.mdms.app.mgmt.model;

import java.io.Serializable;
import java.util.Date;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRegistrationJsonModel implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("user_id")
	private String user_id;
	
	
	@JsonProperty("name")
	private String uname;

	@JsonProperty("designation")
	private String designation;
	
	@JsonProperty("department")
	private String department;
	
	@JsonProperty("loco_type")
	private String loco_type;
	
	@JsonProperty("shed")
	private String shed;
	
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@JsonProperty("from_date")
	private Date from_date;
	
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@JsonProperty("to_date")
	private Date to_date;
	
	@JsonProperty("role_type")
	private String role_type;
	
	@JsonProperty("user_type")
	private String user_type;
	
	@JsonProperty("mobile_no")
	private String mobile_no;
	
	@JsonProperty("entity")
	private String entity;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("zone")
	private String zone;
	
	@JsonProperty("division")
	private String division;
	
	
	@JsonProperty("emp_password")
	private String emp_password;

	
	
	
	
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getEmp_password() {
		return emp_password;
	}

	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	

	

	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLoco_type() {
		return loco_type;
	}

	public void setLoco_type(String loco_type) {
		this.loco_type = loco_type;
	}

	public String getShed() {
		return shed;
	}

	public void setShed(String shed) {
		this.shed = shed;
	}

	public Date getFrom_date() {
		return from_date;
	}

	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}

	public Date getTo_date() {
		return to_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}

	public String getRole_type() {
		return role_type;
	}

	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserRegistrationJsonModel [user_id=" + user_id + ", name=" + uname + ", designation=" + designation
				+ ", department=" + department + ", loco_type=" + loco_type + ", shed=" + shed + ", from_date="
				+ from_date + ", to_date=" + to_date + ", role_type=" + role_type + ", user_type=" + user_type
				+ ", mobile_no=" + mobile_no + ", entity=" + entity + ", email=" + email + ", zone=" + zone
				+ ", division=" + division + ", emp_password=" + emp_password + "]";
	}



	
	

}
