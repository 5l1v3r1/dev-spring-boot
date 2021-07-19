/*This controller provides all services for getting  draft/reject and unapproved record from wagon_uncleansed_data.
 * Created By : Ritu, 19-07-2021
 * 
 */
package com.mdms.wagon.wagonuncleansed.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mdms.wagon.wagonuncleansed.model.WagonUncleansedData;
import com.mdms.wagon.wagonuncleansed.service.WagonEditForwardService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class WagonEditForwardController {	
	@Autowired
	private WagonEditForwardService obj_ctrl;
	
	@RequestMapping(method=RequestMethod.POST, value = "/getWagonCleansedRecord")
	public List<WagonUncleansedData> getWagonCleansedRecord(@RequestBody WagonUncleansedData obj)
	{System.out.println(obj);
	obj_ctrl.getWagonCleansedRecord(obj);
	return obj_ctrl.getWagonCleansedRecord(obj);
	}
	

}
