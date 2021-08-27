/*This controller provides all services for getting  draft/reject and unapproved record from wagon_uncleansed_data.
 * Created By : Ritu, 19-07-2021
 * 
 */
package com.mdms.wagon.wagonuncleansed.controller;

import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdms.wagon.wagonuncleansed.model.FoisWagonTxn;
import com.mdms.wagon.wagonuncleansed.model.WagonDataIrwms;
import com.mdms.wagon.wagonuncleansed.model.WagonUncleansedData;
import com.mdms.wagon.wagonuncleansed.service.FoisWagonTxnService;
import com.mdms.wagon.wagonuncleansed.service.WagonDataIrwmsService;
import com.mdms.wagon.wagonuncleansed.service.WagonEditForwardService;
@CrossOrigin(origins = {"http://localhost:4200","http://mdms-ng-dev.s3-website.ap-south-1.amazonaws.com"}, maxAge = 4800, allowCredentials = "false")

@RestController
public class WagonEditForwardController {	
	@Autowired
	private WagonDataIrwmsService obj_wagonirwms;
	
	@Autowired
	private WagonEditForwardService obj_ctrl;
	
	@Autowired
	private FoisWagonTxnService obj_foistxn;
	
	@RequestMapping(method=RequestMethod.POST, value = "/getWagonCleansedRecord")
	public List<WagonUncleansedData> getWagonCleansedRecord(@RequestBody WagonUncleansedData obj)
	{System.out.println(obj);
	obj_ctrl.getWagonCleansedRecord(obj);
	return obj_ctrl.getWagonCleansedRecord(obj);
	}
	

	@RequestMapping(method=RequestMethod.POST, value = "/getIrwmsWagonNo")
	public List<BigInteger> getIrwmsWagonNumber(@RequestBody WagonDataIrwms obj)
	{System.out.println(obj);
	obj_wagonirwms.getIrwmsWagonNumber(obj);
	return obj_wagonirwms.getIrwmsWagonNumber(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/getFoisWagonNo")
	public List<String> getFoisWagonNumber(@RequestBody FoisWagonTxn obj)
	{System.out.println(obj);
	obj_foistxn.getFoisWagonNumber(obj);
	return obj_foistxn.getFoisWagonNumber(obj);
	}
	
}
