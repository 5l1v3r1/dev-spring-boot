//Developed By: Anshu Sharma , Date 13/Oct/2020 

package com.mdms.app.mgmt.model;

import java.util.List;

public class MenuIdResponseModel {
	
	List<String> menuid_list;
	String message;
	String status;
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
		return "MenuIdResponseModel [menuid_list=" + menuid_list + ", message=" + message + ", status=" + status + "]";
	}
	
	

}
