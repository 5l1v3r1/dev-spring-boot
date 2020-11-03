package com.mdms.app.mgmt.model;

public class GetListUserRegistrationJsonModel {
	
	String user_type_list="";
	String user_role_list="";
	String department_list="";
	String designation_list="";
	public String getUser_type_list() {
		return user_type_list;
	}
	public void setUser_type_list(String user_type_list) {
		this.user_type_list = user_type_list;
	}
	public String getUser_role_list() {
		return user_role_list;
	}
	public void setUser_role_list(String user_role_list) {
		this.user_role_list = user_role_list;
	}
	public String getDepartment_list() {
		return department_list;
	}
	public void setDepartment_list(String department_list) {
		this.department_list = department_list;
	}
	public String getDesignation_list() {
		return designation_list;
	}
	public void setDesignation_list(String designation_list) {
		this.designation_list = designation_list;
	}
	
	
	@Override
	public String toString() {
		return "GetListUserRegistrationJsonModel [user_type_list=" + user_type_list + ", user_role_list="
				+ user_role_list + ", department_list=" + department_list + ", designation_list=" + designation_list
				+ "]";
	}
	
	

}
