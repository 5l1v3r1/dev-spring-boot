/*This controller provides all MDMS COMMON MASTERS .
 * Zone , Division , Designation , State , Pincode , District , Tehsil etc...
 * Created By : Anshul, 02-11-2020
 * 
 */
package com.mdms.mdms_masters.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.mdms_masters.model.MDivision;
import com.mdms.mdms_masters.model.MZone;
import com.mdms.mdms_masters.service.MdmsMasterService;
import com.mdms.mdms_station.stationuncleansed.model.StationPKey;
import com.mdms.mdms_masters.model.MDepartment;
import com.mdms.mdms_masters.model.MDesignation;




@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")


@RestController
public class MdmsMastersController {
	
	@Autowired	
	MdmsMasterService mdm_mstr_serv;
	

	Logger logger=LoggerFactory.getLogger(MdmsMastersController.class);
	
	@RequestMapping(method=RequestMethod.POST, value="/division")
	public List<MDivision> getAllDivision(){
		return mdm_mstr_serv.getAllDivision();
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/divisionbyzonecode")
	public List<MDivision> findByZone(@RequestBody MDivision division) {
		List<MDivision> temp=mdm_mstr_serv.findByZone(division);
		 for(int i = 0; i < temp.size(); i++) {
	            System.out.println(temp.get(i).getDivision_code());
	        }
	return mdm_mstr_serv.findByZone(division);  
	
	}    
	
	@RequestMapping(method=RequestMethod.POST, value="/dvsnmstr")
	public String findByDivison(@RequestBody String division)throws Exception {
		 logger.error("controller : MdmsMastersController || Method : findByDivison || input recieved findByDivison: "+division);		 
       return mdm_mstr_serv.findByDivision(division) ;
	
	
	}    
	
	@RequestMapping(method=RequestMethod.POST, value="/zone")
	public	 List<String> getAllZone(){
		return mdm_mstr_serv.getAllZone();
	}
	

	 @RequestMapping(method=RequestMethod.POST, value="/stnuserdesignation")
		public boolean findStnDesignation(@RequestBody MDesignation desig){ 										
			  return  mdm_mstr_serv.verifyStnUserDesig(desig);		 	 	
		}
	 @RequestMapping(method=RequestMethod.POST, value="/coachuserdesignation")
		public boolean findCoachDesignation(@RequestBody MDesignation desig){ 										
			  return  mdm_mstr_serv.verifyCoachUserDesig(desig);		 	 	
		}
	 @RequestMapping(method=RequestMethod.POST, value="/locouserdesignation")
		public boolean findLocoDesignation(@RequestBody MDesignation desig){ 										
			  return  mdm_mstr_serv.verifyLocoUserDesig(desig);		 	 	
		}


		@RequestMapping(method=RequestMethod.POST, value="/department")
		public List<MDepartment> getAllDepartment(){
			return mdm_mstr_serv.getAllDepartment();
		}

}
