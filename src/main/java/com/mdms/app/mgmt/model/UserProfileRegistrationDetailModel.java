package com.mdms.app.mgmt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity()
@Table(name="user_profile_registration_detail", schema="mdms_app_mgmt")
public class UserProfileRegistrationDetailModel {
	
	@Id
	@Column(name="user_id")
	private String user_id;
	
	
	@Column(name="name")
	private String name;

	@Column(name="designation")
	private String designation;
	
	@Column(name="department")
	private String department;
	
	@Column(name="loco_type")
	private String loco_type;
	
	@Column(name="shed")
	private String shed;
	
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column(name="from_date")
	private Date from_date;
	
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column(name="to_date")
	private Date to_date;
	
	@Column(name="role_type")
	private String role_type;
	
	@Column(name="user_type")
	private String user_type;
	
	@Column(name="mobile_no")
	private String mobile_no;
	
	@Column(name="entity")
	private String entity;
	
	@Column(name="email")
	private String email;
	
	@Column(name="created_by")
	private String created_by;
	
	@Column(name="zone")
	private String zone;
	
	@Column(name="division")
	private String division;
	
	@Column(name="user_register_approval")
	private String user_register_approval;
	
	
	

	public String getUser_register_approval() {
		return user_register_approval;
	}

	public void setUser_register_approval(String user_register_approval) {
		this.user_register_approval = user_register_approval;
	}

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

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	@Override
	public String toString() {
		return "UserProfileRegistrationDetailModel [user_id=" + user_id + ", name=" + name + ", designation="
				+ designation + ", department=" + department + ", loco_type=" + loco_type + ", shed=" + shed
				+ ", from_date=" + from_date + ", to_date=" + to_date + ", role_type=" + role_type + ", user_type="
				+ user_type + ", mobile_no=" + mobile_no + ", entity=" + entity + ", email=" + email + ", created_by="
				+ created_by + ", zone=" + zone + ", division=" + division + ", user_register_approval="
				+ user_register_approval + "]";
	}

	

	
	
	
	 
	

}
