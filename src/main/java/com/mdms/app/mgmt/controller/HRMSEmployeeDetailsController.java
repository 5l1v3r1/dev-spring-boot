package com.mdms.app.mgmt.controller;

import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mdms.app.mgmt.model.HrmsJsonModel;
import com.mdms.app.mgmt.model.IPassIDModel;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class HRMSEmployeeDetailsController {

	
	

	Logger logger=LoggerFactory.getLogger(HRMSEmployeeDetailsController.class);	

	HrmsJsonModel hrmsEmpData;
	 
	@RequestMapping(method=RequestMethod.POST, value="/employeedetails")
	public HrmsJsonModel hrmsEmployeeDetail(@RequestBody IPassIDModel ipassid ) {
		System.out.println(ipassid);
		 //String getHRMSUrl = "http://10.77.56.35:80/HRMSWS/employeedetails";
		 String getHRMSUrl = "http://localhost:12021/hrmsEmployeeInfo";

		 
			RestTemplate restTemplate = new RestTemplate();
				 try {
				        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin09876", "dasd@1241!45"));
				         hrmsEmpData = restTemplate.postForObject(getHRMSUrl, ipassid,HrmsJsonModel.class);	
				    	logger.info("Controller : HRMSEmployeeDetailsController || Method : hrmsEmployeeDetail ||hrmsEmployeeInfo: "+hrmsEmpData.toString());							        
							        
				        return hrmsEmpData;			      
				    }
				    catch (Exception eek) {
				    	System.out.println(eek);
				    	hrmsEmpData.setMessage("some error occured in calling HRMS service");
				    	return hrmsEmpData;
				    	
				    }
				
			
	}
	
	
	}

