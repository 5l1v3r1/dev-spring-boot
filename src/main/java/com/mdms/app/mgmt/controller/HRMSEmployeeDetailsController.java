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


	 
	@RequestMapping(method=RequestMethod.POST, value="/employeedetails")
	public HrmsJsonModel hrmsEmployeeDetail(@RequestBody IPassIDModel ipassid ) {
		System.out.println(ipassid);
		 String getHRMSUrl = "http://10.77.56.35:80/HRMSWS/employeedetails";
		
			RestTemplate restTemplate = new RestTemplate();
				 try {
				        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin09876", "dasd@1241!45"));
				        HrmsJsonModel hrmsEmpData = restTemplate.postForObject(getHRMSUrl, ipassid,HrmsJsonModel.class);	
				        System.out.println( hrmsEmpData.getMessage());
				        System.out.println( hrmsEmpData.getName());
				        System.out.println( hrmsEmpData.getDepartmentDescription());
				        System.out.println( hrmsEmpData.getDesignation()); 
				        System.out.println( hrmsEmpData.getRailwayUnitDivision());
				        System.out.println( hrmsEmpData.getServiceStatusDescription());
				        System.out.println( hrmsEmpData.getRailwayUnitName());
								        
				        return hrmsEmpData;			      
				    }
				    catch (Exception eek) {
				    	System.out.println(eek);
				    }
				
			        
				return null ;
	}
	
	
	}

