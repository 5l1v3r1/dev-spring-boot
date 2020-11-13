//Developed By: Anshu Sharma , Date 13/Oct/2020 

package com.mdms.app.mgmt.model;

import java.util.List;

public class MenuIdResponseModel {
	
	List<String> menuid_list;
	String message;
	String status;
	String user_type;
<<<<<<< HEAD
	String division;
	String designation;
	String user_role;
	String user_id;
	String senior_id;
	
	
	
	
	
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSenior_id() {
		return senior_id;
	}
	public void setSenior_id(String senior_id) {
		this.senior_id = senior_id;
	}
=======
	
>>>>>>> ef3574260e9ec6ab5b6df606ebd08b2a510cdcb0
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public List<String> getMenuid_list() {
		return menuid_list;
	}
	public void setMenuid_list(List<String> menuid_list) {
		this.menuid_list = menuid_list;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "MenuIdResponseModel [menuid_list=" + menuid_list + ", message=" + message + ", status=" + status
<<<<<<< HEAD
				+ ", user_type=" + user_type + ", division=" + division + ", designation=" + designation
				+ ", user_role=" + user_role + ", user_id=" + user_id + ", senior_id=" + senior_id + "]";
	}
	
	
	
	
=======
				+ ", user_type=" + user_type + "]";
	}
	
	
>>>>>>> ef3574260e9ec6ab5b6df606ebd08b2a510cdcb0

}
